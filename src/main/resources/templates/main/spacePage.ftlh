<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a href="/parking/parkingIn/${num}">
        <H2 class="navbar-brand" >управление местом</H2>
        </a>
    </nav>
</div>

    <table class="table" style="margin-top: 3rem;  border: 1px solid black; width: 100%">
        <thead class="thead-dark">
        <tr>
            <th scope="col">номер машины</th>
            <th scope="col">выезд/выезд</th>
            <th scope="col">оператор</th>
            <th scope="col">фото</th>
        </tr>
        </thead>
        <#list spaceHistory as ls>
            <tbody style="border: 1px solid black">
            <tr>
                <th> ${ls.numberOfCar}</th>
                <th> ${ls.actionType.toString()}</th>
                <th> ...</th>
                <th> <img src="${ls.imagePath}"></th>
            </tr>
            </tbody>
        </#list>
    </table>

</body>
</html>