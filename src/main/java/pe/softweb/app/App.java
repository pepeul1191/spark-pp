package pe.softweb.app;

import static spark.Spark.*;
import pe.softweb.handlers.UsuarioHandler;

public class App {
    public static void main(String[] args) {
        get("/hello", (request, response) -> 
            "Hello World"
        );
        path("/accesos", () -> {
            path("/usuario", () -> {
                get("/litar", UsuarioHandler);
            });
        });
    }    
}
