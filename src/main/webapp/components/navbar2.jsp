<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%

    String fecha_nac = (String) request.getSession().getAttribute("fecha_nac");
    String id_request_user = (String) request.getSession().getAttribute("id");
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Horóscopos</title>
</head>
<body>
<nav class="navbar navbar-expand-lg" style="background-color: lightsteelblue;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><b><i>Horóscopo Chino</i></b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                     <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/horoscopoServlet?fecha_nacimiento=<%= fecha_nac %>&id=<%= id_request_user %>">Conoce tu Animal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/Usuarios">Usuarios</a>
                </li>

            </ul>
            <%
                Optional<String> usuario = Optional.ofNullable((String) session.getAttribute("usuario"));
                if (usuario.isPresent()) {
                    out.println("<h4>" + usuario.get() +     "  </h4>");
                } else {
                    out.println("<h4>No hay usuario presente!</h4>");
                }
            %>
            <a href="/HoroscopoChino/CerrarSesion">
            <button class="btn btn-outline-success" type="button">Cerrar Sesión.</button>
            </a>
        </div>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>