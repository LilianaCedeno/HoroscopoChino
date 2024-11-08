<%@ page import="java.util.Optional" %>
<%@ page import="org.lc.modelo.Horoscopo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Horóscopo Chino</title>
</head>
<body>
<header>
    <jsp:include page="components/navbar2.jsp"/>
</header>

<main class="container">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="form-signin w-100 m-auto text-center">
                <%
                    Optional<String> usuario = Optional.ofNullable((String) session.getAttribute("usuario"));
                    if (usuario.isPresent()) {
                        out.println("<h2>" + usuario.get() + "</h2>");
                    } else {
                        out.println("<h4>No hay usuario presente!</h4>");
                    }
                %>

                <%
                    Optional<Horoscopo> horoscopoOpt = Optional.ofNullable((Horoscopo) request.getAttribute("horoscopo"));
                    if (horoscopoOpt.isPresent()) {
                        Horoscopo horoscopo = horoscopoOpt.get();
                        out.println("<p>Tu signo del horóscopo chino es: <strong>" + horoscopo.getAnimal() + "</strong></p>");
                        out.println("<p>Descripción: " + horoscopo.getDescripcion() + "</p>");
                        out.println("<img src='" + horoscopo.getLugar() + "' alt='" + horoscopo.getAnimal() + "' class='img-fluid'/>");
                        System.out.println(horoscopo.getLugar());
                    } else {
                        out.println("<p>No se encontró información sobre tu horóscopo.</p>");
                    }
                %>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
