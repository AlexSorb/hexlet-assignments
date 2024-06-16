@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
    <div class="form_auth_block">
        <div class="form_auth_block_content">
            <p class="form_auth_bloc_head_text">Авторизация</p>
            <form class="form_auth_style" action="${NamedRoutes.loginPath()}" method="post">
                <label>Имя</label>
                <input type="text" name="name" value="${page.getName()}" placeholder="Введите Ваш логин" required>
                <label>Пароль</label>
                <input type="password" name="password" placeholder="Введите ваш праоль" required>
                <button class="form_auth_button" type="submit" name="form_auth_submit">Войти</button>
            </form>
        </div>
    </div>

    @if (page.getName() != null)
        <div class="form_error_block">
            <div class="form_error_message">
                <p>${page.getError()}</p>
            </div>
        </div>
    @endif
`
)