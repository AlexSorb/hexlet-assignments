@import gg.jte.Content
@import exercise.dto.BasePage
@param Content content
@param BasePage page = null
<!-- BEGIN -->
<!doctype html>
<html lang="ru" class="no-js">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Hexlet flash</title>
        <meta name="description" content="Test flash in Javalin">
    </head>
    <body>
    @if(page != null && page.getFlash() != null)
        <div class="flash_message_block">
            <h3>${page.getFlash()}</h3>
        </div>
    @endif
        ${content}
    </body>
</html>
<!-- END -->
