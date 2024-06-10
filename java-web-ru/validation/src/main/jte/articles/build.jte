@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    
    
    <form action="/articles" method="post">
        <div>
            <label>
                Название
                <input type="text" name="title" value="${page.getTitle()}">
            </label>
        </div>
        <div>
            <label>
                Контент
                <textarea rows="10" cols="45" name="content">${page.getContent()}</textarea>
            </label>
        </div>
        <input type="submit" name="Опубликовать">
    </form>
`
)