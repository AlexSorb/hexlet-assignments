@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`

    <div>
        @for(var post : page.getPosts())
            <a href="${NamedRoutes.showPostPath(post.getId().toString())}">${post.getName()}</a>
        @endfor
        <div>
            <a href="${NamedRoutes.indexPostPath()}?pag=">Next</a>
        </div>
    </div>
`
)