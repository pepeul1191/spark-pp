package pe.softweb.handlers;

import pe.softweb.models.Accesos;
import pe.softweb.models.Usuarios;
import spark.Request;
import spark.Response;
import spark.Route;

public class UsuarioHandler{

    public static Route listar= (Request request, Response response) -> {
        Usuarios u = new Usuarios();
        return u.listar();
    };
    
     public static Route listarUsuarios= (Request request, Response response) -> {
        Usuarios u = new Usuarios();
        return u.listarUsuarios();
    };
     
      public static Route listarAccesos= (Request request, Response response) -> {
        int idUsuario = Integer.parseInt(request.params(":usuario_id"));
        Accesos a = new Accesos();
        return a.listarAccesos(idUsuario);
    };
}
