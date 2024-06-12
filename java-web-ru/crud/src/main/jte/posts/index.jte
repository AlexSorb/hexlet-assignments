@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage currentPostsPage

@template.layout.page(
content = @`

    <div>
        @for(var post : currentPostsPage.getPosts())
            <a href="${NamedRoutes.showPostPath(post.getId().toString())}">${post.getName()}</a>
        @endfor
        <div>
            <a href="${NamedRoutes.postsPath()}?page=${currentPostsPage.getNumPage() - 1}">назад</a>
            <a href="${NamedRoutes.postsPath()}?page=${currentPostsPage.getNumPage() + 1}">вперед</a>
        </div>
    </div>
`
)