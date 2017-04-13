package pe.softweb.handlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class UsuarioHandler implements Route{

    public static Route listar= (Request request, Response response) -> {
        return "listarUusuarios";
    };
    
    @Override
    public Object handle(Request rqst, Response rspns) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
