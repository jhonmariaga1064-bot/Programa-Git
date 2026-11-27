# Proyecto_SERTTI_Tramites_Web

Módulo web para la evidencia **GA7-220501096-AA2-EV02** (SERTTI Tránsito La Jagua).

- **Formulario HTML (`index.html`):** envía parámetros mediante `POST` para registro y `GET` para consulta.
- **Servlet (`TramiteServlet.java`):** procesa peticiones en `doGet` y `doPost` usando `request.getParameter(...)` y reenvía a `resultado.jsp`.
- **Vista JSP (`resultado.jsp`):** renderiza la respuesta dinámica con expresiones y scriptlets JSP.
