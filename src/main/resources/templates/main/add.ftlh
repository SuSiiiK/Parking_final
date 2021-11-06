<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div style="margin-bottom: 50px">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <H2 class="navbar-brand" >Главная</H2>
    </nav>
</div>

<div style="display: flex">

    <form action="/parking/parkingIn/${id}" method="post" enctype="multipart/form-data">
        <div>
            <label>
                <input type="text" name="numberOfCar" placeholder="Ведите номер машины">
            </label>
        </div>
        <div>
            <input type="radio" id="in" name="action" value=1>
            <label for="in">Вьезд</label><br>
            <input type="radio" id="out" name="action" value=0>
            <label for="out">Выезд</label><br>
        </div>
        <div class="input-group my-3" style="margin-bottom: 50px">
            <div class="w-100"><img id="output" class="w-100" /></div>
            <input type="file" name="multipartFile" class="form-control w-100 mt-3" multiple="multiple"  id="inputGroupFile01" accept="image/jpeg, image/png"  required>
        </div>
        <button type="submit">
            Открыть
        </button>
    </form>

</div>




</body>
</html>