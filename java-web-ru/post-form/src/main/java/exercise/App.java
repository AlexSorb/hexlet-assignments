package exercise;

import io.javalin.Javalin;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx ->{
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx->{
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");


            if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName) &&
                    !StringUtils.isEmpty(email) && !StringUtils.isEmpty(password)) {
                firstName = StringUtils.lowerCase(firstName);
                lastName = StringUtils.lowerCase(lastName);
                email = StringUtils.lowerCase(email).trim();

                firstName = StringUtils.capitalize(firstName);
                lastName = StringUtils.capitalize(lastName);
                password = Security.encrypt(password);

                var newUser = new User(firstName, lastName, email, password);
                UserRepository.save(newUser);
            }
            ctx.redirect("/users");
        });

        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
