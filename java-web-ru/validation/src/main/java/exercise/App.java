package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            int MIN_SIZE_TITLE = 2;
            int MIN_SIZE_CONTENT = 10;
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");
            try {
                title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.length() > MIN_SIZE_TITLE,
                                "Название не должно быть короче двух символов")
                        .check(value -> ArticleRepository.existsByTitle(value) == false,
                                "Статья с таким названием уже существует")
                        .get();
                content = ctx.formParamAsClass("content", String.class)
                        .check(cont -> cont.length() > MIN_SIZE_CONTENT,
                                "Статья должна быть не короче 10 символов")
                        .get();

                var newArticle = new Article(title, content);
                ArticleRepository.save(newArticle);
                ctx.redirect("/articles");

            }catch (ValidationException exp) {
                var page = new BuildArticlePage(title, content, exp.getErrors());
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", page));

            }
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
