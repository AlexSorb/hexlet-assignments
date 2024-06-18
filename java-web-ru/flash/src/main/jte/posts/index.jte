@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page.getFlash(),
    content = @`
        <div class="index_block">
            @for(var post : page.getPosts())
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            @endfor
        </div>
`
)