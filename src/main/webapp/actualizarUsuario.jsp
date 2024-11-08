<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<main class="container">
    <jsp:include page="components/navbar2.jsp"/>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="form-signin w-100 m-auto text-center">
                    <form method="post" action="/HoroscopoChino/ActualizarServlet">
                        <h1 class="h3 mb-3 fw-normal">Actualiza tus Datos.</h1>

                        <input type="hidden" name="id" value="${usuario.id}">

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="${usuario.nombre}" required>
                            <label for="nombre">Nombre</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${usuario.email}" required>
                            <label for="email">Correo Electrónico</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="date" class="form-control" id="fechaN" name="fechaN" placeholder="Fecha de Nacimiento" value="" required>
                            <label for="fechaN">Fecha de Nacimiento</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" value="${usuario.nomUsuario}">
                            <label for="usuario">Usuario</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="clave" name="clave" placeholder="Contraseña" value="${usuario.password}">
                            <label for="clave">Contraseña</label>
                        </div>

                        <button class="btn btn-primary w-100 py-2" type="submit">Actualizar</button>
                    </form>

                </div>
            </div>
        </div>
    </div>

</main>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null && !mensaje.isEmpty()) {
%>
<script>
    alert("<%= mensaje %>");
</script>
<%
    }
%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>