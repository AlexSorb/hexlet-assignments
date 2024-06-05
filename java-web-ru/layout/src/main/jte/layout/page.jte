@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset =utf-8">
    <title>Test layout</title>

</head>
<body>
    <header>
    <a href="/">Главная</a>
    <a href="/users">Пользователи</a>
    </header>
    ${content}
<footer>
    <p>Тут находится Футер и
        <a href="https://github.com/AlexSorb/hexlet-assignments" target="_blank">ссылка</a>
        на проект!</p>

</footer>
</body>
</html>