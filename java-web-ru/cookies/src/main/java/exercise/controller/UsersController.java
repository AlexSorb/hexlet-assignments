package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email = ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var token = Security.generateToken();

        var newUser = new User(firstName, lastName, email, password, token);
        UserRepository.save(newUser);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(newUser.getId()));
    }

    public static void show(Context ctx) {
        var user = UserRepository.find(Long.valueOf(ctx.pathParam("id")))
                .orElseThrow(() -> new NotFoundResponse("Пользователь не найден"));
        var currentCookie = ctx.cookie("token");

        if (user.getToken().equals(currentCookie)) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
