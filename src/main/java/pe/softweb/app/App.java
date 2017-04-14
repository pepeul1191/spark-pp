package pe.softweb.app;

import static spark.Spark.*;
import pe.softweb.handlers.UsuarioHandler;

public class App {
    public static void main(String[] args) {
        get("/hello", (request, response) -> 
            "Hello World"
        );
        path("/usuario", () -> {
            get("/listar", UsuarioHandler.listar);
            get("/listar_usuarios", UsuarioHandler.listarUsuarios);
            get("/listar_accesos/:usuario_id", UsuarioHandler.listarAccesos);
       });
    }    
}
