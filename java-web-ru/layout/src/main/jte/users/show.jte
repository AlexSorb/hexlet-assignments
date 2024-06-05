@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
    <p>User ID: ${page.getUser().getId()}</p>
    <p>User email: ${page.getUser().getEmail()}</p>
`)