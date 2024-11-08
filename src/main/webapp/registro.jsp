<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="components/navbar1.jsp"/>
</header>
<main class="container">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="form-signin w-100 m-auto text-center">
                    <form  onsubmit= "return validarClaves()" method="post" action= "/HoroscopoChino/AgregarUsuario">
                        <h1 class="h3 mb-3 fw-normal">Regístrate</h1>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
                            <label for="usuario">Nombre</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                            <label for="email">Correo Electrónico</label>
                        </div>
                        <div class="form-floating mb-3">

                            <input type="date" class="form-control" id="fechaN" name="fechaN" placeholder="FechaN" required>
                            <label for="clave">Fecha de Nacimiento</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required>
                            <label for="usuario">Usuario</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="clave" name="clave" placeholder="Clave"  required>
                            <label for="clave">Contraseña</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="clave2" name="clave2" placeholder="Clave2"  required>
                            <label for="clave">Repita Contraseña</label>
                        </div>
                        <button class="btn btn-primary w-100 py-2" type="submit">Regístrate.</button>
                        <p class="mt-5 mb-3 text-body-secondary">&copy; 2.024</p>
                    </form>
                </div>
            </div>
        </div>
    </div>

</main>
<script>
    function  validarClaves() {
        let c1 = document.getElementById("clave").value;
        let c2 = document.getElementById("clave2").value;
        if (c1!=c2 ){
            alert("Las Contraseñas no coinciden");
            return false;
        }
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>