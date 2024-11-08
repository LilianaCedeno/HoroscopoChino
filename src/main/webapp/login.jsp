<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="recursos/assest/css/css.css" rel="stylesheet">
    <title>Inicio Sesión</title>
</head>
<body>
<header>
    <jsp:include page="components/navbar1.jsp"/>
</header>
<main class="container">

    <div class="container mi-div">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="form-signin w-100 m-auto text-center">
                    <form method="post" action="/HoroscopoChino/InicioSesion">
                        <h1 class="h3 mb-3 fw-normal">Ingrese sus Credenciales</h1>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario">
                            <label for="usuario">Usuario</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="clave" name="clave" placeholder="Clave">
                            <label for="clave">Clave</label>
                        </div>

                        <div class="form-check text-start my-3">
                            <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">Recuérdame</label>
                        </div>
                        <button class="btn btn-primary w-100 py-2" type="submit">Enviar</button>

                        <p class="mt-5 mb-3 text-body-secondary">Es necesario que inicie sesión para revisar su
                            Horóscopo Chino. Si no tiene cuenta por favor registrese<a href="registro.jsp"> Aquí.</a>
                        </p>
                        <p class="mt-5 mb-3 text-body-secondary">&copy; 2.024</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<%
    String mensajeError = (String) request.getAttribute("mensajeError");
    if (mensajeError != null && !mensajeError.isEmpty()) {
%>
<script>
    alert("<%= mensajeError %>");
</script>
<%
    }
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>