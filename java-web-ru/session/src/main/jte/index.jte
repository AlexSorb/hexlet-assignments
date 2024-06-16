@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
    <div class="index_content_block">
        @if(page.getName() == null)
            <div class="index_login_ref">
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            </div>
        @else
            <div class="index_logout_block">
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <p>${page.getName().toString()}</p>
                    <button class="index_logout_button" type="submit" name="logout_button">Выйти</button>
                </form>
            </div>
        @endif
    </div>
`
)
