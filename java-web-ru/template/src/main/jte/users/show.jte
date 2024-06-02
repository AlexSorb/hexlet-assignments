@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html>
<body>
    <h1>User: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
</body>
</html>
