@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`


    <div class="post">
       <div>
           <h4>Post ID: ${page.getPost().getId()}</h4>
       </div>

        <div><h1>${page.getPost().getName()}</h1></div>

        <div>
            <p>
                ${page.getPost().getBody()}
            </p>
        </div>
        <div>
            <a href="${NamedRoutes.postsPath()}">Все посты</a>
        </div>
    </div>
`)