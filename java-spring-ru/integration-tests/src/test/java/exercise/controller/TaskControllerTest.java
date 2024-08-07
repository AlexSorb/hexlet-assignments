package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN

    public Task getTask() {
        return  Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    @Test
    public void testShow() throws Exception {

        // Создать таск и сохранить в репозитории
       var task = getTask();
        taskRepository.save(task);

        // Создать запрос на получение данного таска
        var request = get("/tasks/{id}", task.getId());
        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        var body = result.getResponse().getContentAsString();
        var getTask = taskRepository.findById(task.getId()).get();
        assertThatJson(body).and(
                v -> v.node("title").isEqualTo(task.getTitle()),
                v -> v.node("description").isEqualTo(task.getDescription())
        );
    }

    @Test
    public void createTest() throws Exception {
        // Создать данные для запроса
        var data = getTask();
        // Создать put запрос
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));
        var result = mockMvc.perform(request)
                .andExpect(status().isCreated());

        // Получить данные из репозитория
        var createdTask = taskRepository.findByTitle(data.getTitle()).get();
        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getTitle().equals(data.getTitle()));
        assertThat(createdTask.getDescription().equals(data.getDescription()));
        //
    }

    @Test
    public void deleteTest() throws Exception {
        // создать данные и сохранить в репозитории
        var data = getTask();
        taskRepository.save(data);

        // создать запрос на удаление элемента
        var request = delete("/tasks/{id}", data.getId());
        mockMvc.perform(request)
                .andExpect(status().isOk());

        // провереить, что данные из репозитория удалены
        var notSearchData = taskRepository.findById(data.getId()).orElse(null);
        assertThat(notSearchData).isNull();
    }

    /*
    * Создать данные и добавить в репозиторий
    * Создать данные на обнавление на обнавление
    * Создать запрос на обнавление данных
    * Проверить, что данные сохранились
    * */
    @Test
    public void updateTest() throws Exception {
        // Создать данные и добавить в репозиторий
        var data = getTask();
        taskRepository.save(data);

        // Создать данные на обнавление на обнавление
        var newData = new HashMap<String, String>();
        newData.put("title", "new title");

        // создать запрос на обнавление данных
        var request = put("/tasks/{id}", data.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(newData));
        mockMvc.perform(request).andExpect(status().isOk());

        // Проверить, что данные сохранились
        var task = taskRepository.findById(data.getId()).get();
        assertThat(task.getTitle().equals(newData.get("title")));
    }
    // END
}
