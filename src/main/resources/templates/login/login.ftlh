<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Главная</a>
    </nav>
</div>

<form action="/sign-in" method="post">
    <div>
        <label class="flex flex-v-center ">
            <span class="label-input-text">Адрес почты:</span>
            <input type="text" name="username" placeholder="ваш адрес почты"  value="${(dto.email)!''}" autofocus >
        </label>
    </div>
    <div>
        <label class="flex flex-v-center label-input-text">
            <span class="label-input-text">Пароль:</span>
            <input type="text" name="password" placeholder="пароль" value="">
        </label>
    </div>
    <div>
        <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse"  role="button" aria-expanded="false" aria-controls="collapseExample" type="submit">Войти!</button>
    </div>
</form>

</body>
</html>