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
        <h2 style="color: aliceblue; margin-left: auto" >Please register</h2>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <li class="nav-item">
                <a class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" href="/login" role="button" aria-expanded="false" aria-controls="collapseExample" >Вход</a>
            </li>
        </div>
    </nav>
</div>
<div>
    <form action="/sign-up" method="post" enctype="multipart/form-data">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Имя:</p>
                <input type="text" name="name" placeholder="ваше имя" value="">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Адрес почты:</p>
                <input type="text" name="email" placeholder="ваш адрес почты" value="">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Пароль:</p>
                <input type="text" name="password" placeholder="пароль"  value="">
            </label>
        </div>

        <div>
            <button type="submit">Регистрация</button>
        </div>
        <div>
            <#if errors?? >
                <p>Входные данные с ошибками!</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
            </#if>
        </div>
    </form>
</div>
<div class="bottom-box">
    <a href="/">На главную страницу</a>
</div>

</body>
</html>