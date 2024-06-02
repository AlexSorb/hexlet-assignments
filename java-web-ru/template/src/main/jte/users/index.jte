@import exercise.dto.users.UsersPage
@param UsersPage page
<!doctype html>
<html>
    <head>
        <h1>Users</h1>
    </head>
    <body>
    <h2>User list</h2>
    @for(var user : page.getUsers())
        <div>
            <h3><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a> </h3>
            <p></p>
        </div>
    @endfor
    </body>
</html>