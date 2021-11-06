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
        <H2 class="navbar-brand" >Главная</H2>
    </nav>
</div>
<div style="display: flex;justify-content: space-around;  flex-wrap: wrap;">
    <#list places as pl>
        <#if pl.state.toString()=="FREE">
            <a href="/parking/displayParkingSpace/${pl.id}">

            <div style="border: solid black 1px;height: 100px; width:100px; margin-top: 20px;  ">
                <#if pl.numberCar!=0>
                    <h3>${pl.numberCar}</h3>
                </#if>
            </div>
            <#else>
                <a href="/parking/displayParkingSpace/${pl.id}">
                <div style="border: solid red 1px;height: 100px; width:100px; margin-top: 20px;  ">
                    <#if pl.numberCar!=0>
                        <h3>${pl.numberCar}</h3>
                    </#if>
                </div>
                </a>
            </a>

        </#if>
    </#list>

</div>
<div>
  Свободных мест =  ${free}
</div>

<div>
   Занято= ${busy}
</div>
</body>
</html>