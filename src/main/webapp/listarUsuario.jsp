<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org.lc.modelo.Usuario" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Lista de usuarios</title>
</head>
<body>
<header>
    <jsp:include page="components/navbar2.jsp"/>
</header>
<main class="container">


    <h1 class="text-center">Listado de Usuario</h1>
    <%
        List<Usuario> usuarioList = (List<Usuario>) request.getAttribute("usuarioList");
        String usuarioNombre = (String) request.getAttribute("usuario");
    %>

    <div class="table-responsive">
        <%
            String mensaje = request.getParameter("mensaje");
            if (mensaje != null) {
        %>
        <div class="alert">
            <%= mensaje %>
        </div>
        <%
            }
        %>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Usuario</th>
                <th scope="col">Email</th>
                <th scope="col">Fecha Nacimiento</th>
                <th scope="col">Contraseña</th>
                <th scope="col">Animal</th>
                <th scope="col">Maneja tu información:</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (usuarioList != null && !usuarioList.isEmpty()) {
                    for (Usuario u : usuarioList) {
            %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getNombre() %></td>
                <td><%= u.getNomUsuario() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getFechaNacimiento() %></td>
                <td><%= u.getPassword() %></td>
                <td><%= u.getAnimal() %></td>
                <td>
                    <a class="btn btn-warning btn-sm" href="<%= request.getContextPath() %>/ActulizaGet?id=<%= u.getId() %>">Modificar</a>
                    <a class="btn btn-danger btn-sm" href="<%= request.getContextPath() %>/EliminarServlet?id=<%= u.getId() %>">Eliminar</a>
                </td>
            </tr>
            <%
                }
            } else { %>
            <tr>
                <td colspan="8" class="text-center">No hay usuarios disponibles.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>