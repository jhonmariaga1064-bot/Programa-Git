<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Resultado del Trámite - SERTTI</title>
</head>
<body>
  <h1>Resultado de la Operación (JSP)</h1>
  <p><strong>Método HTTP:</strong> ${metodoUsado}</p>
  <p><strong>Estado:</strong> ${mensaje}</p>

  <% if (request.getAttribute("numeroRadicado") != null) { %>
    <p><strong>Radicado:</strong> ${numeroRadicado}</p>
  <% } %>

  <% if (request.getAttribute("placaVehiculo") != null) { %>
    <p><strong>Placa:</strong> ${placaVehiculo}</p>
  <% } %>

  <% if (request.getAttribute("tipoTramite") != null) { %>
    <p><strong>Tipo de trámite:</strong> ${tipoTramite}</p>
  <% } %>

  <br>
  <a href="index.html">Volver a los formularios</a>
</body>
</html>
