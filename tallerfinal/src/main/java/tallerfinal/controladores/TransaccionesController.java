package tallerfinal.controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import tallerfinal.entidades.Transacciones;
import tallerfinal.servicios.TransaccionesService;

public class TransaccionesController extends HttpServlet {
    private TransaccionesService transaccionesService;
    private ObjectMapper mapper;

    public TransaccionesController() {
        transaccionesService = new TransaccionesService();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        if (path == null) {
            List<Transacciones> personas = transaccionesService.listarTransacciones();
            String json = mapper.writeValueAsString(personas);
            response.setContentType("application/json");
            response.getWriter().println(json);
        } else {
            switch (path) {
                case "/buscarPorIdTransacciones":
                    int identificador = Integer.parseInt(request.getParameter("ID"));
                    try {
                        List<Transacciones> persona = transaccionesService.listarTransaccionesId(identificador);
                        String json = mapper.writeValueAsString(persona);
                        response.setContentType("application/json");
                        response.getWriter().println(json);
                    } catch (Exception e) {
                        response.setStatus(404);
                        Map<String, String> error = new HashMap<>();
                        error.put("error", e.getMessage());
                        String json = mapper.writeValueAsString(error);
                        response.setContentType("application/json");
                        response.getWriter().println(json);
                    }
                    break;
                default:
                    response.setStatus(404);
                    Map<String, String> error = new HashMap<>();
                    error.put("error", "No se encontro el recurso");
                    String json = mapper.writeValueAsString(error);
                    response.setContentType("application/json");
                    response.getWriter().println(json);
                    break;
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getContentType();

        if (content != null && content.equals("application/json")) {
            Map<String, Object> transaccionMap = mapper.readValue(request.getInputStream(), HashMap.class);
            try {
                transaccionesService.crearTransaccion(transaccionMap);
                response.setStatus(HttpServletResponse.SC_CREATED);
                Map<String, String> respuesta = new HashMap<>();
                respuesta.put("mensaje", "Transaccion guardada con exito");
                String json = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().println(json);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                String json = mapper.writeValueAsString(error);
                response.setContentType("application/json");
                response.getWriter().println(json);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            Map<String, String> error = new HashMap<>();
            error.put("error", "El contenido debe ser JSON");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }

}
