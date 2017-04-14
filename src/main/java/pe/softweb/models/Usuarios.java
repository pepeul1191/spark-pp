package pe.softweb.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.softweb.utils.ConnectionDB;

public class Usuarios implements Serializable {    
    
    public String listarUsuarios(){
        ConnectionDB c = new ConnectionDB();
        Statement stmt = null;
        ArrayList<String> rptaQuery = new ArrayList<String>(); 
        
        try {
            stmt = c.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT usuario FROM usuarios" );
            
            while ( rs.next() ) {
                String usuario = rs.getString(1);
                rptaQuery.add(usuario);
            }
            
            rs.close();
            stmt.close();
            c.getConnection().close();
            
            Gson gson = new Gson();
            return gson.toJson(rptaQuery);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return null;
    }
    
    public String listar(){
        ConnectionDB c = new ConnectionDB();
        Statement stmt = null;
        ArrayList<JsonObject> rptaQuery = new ArrayList<JsonObject>(); 
        
        try {
            stmt = c.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT U.id AS id, U.usuario AS usuario, A.momento AS momento, U.correo "
                    + "AS correo FROM usuarios U INNER JOIN accesos A ON U.id = A.usuario_id GROUP BY U.usuario "
                    + "ORDER BY U.id" );
            
            while ( rs.next() ) {
                String usuario = rs.getString(1);
                JsonObject tempJSON = new JsonObject();
                tempJSON.addProperty("id", rs.getInt(1));
                tempJSON.addProperty("usuario", rs.getString(2));
                tempJSON.addProperty("momento", rs.getString(3));
                tempJSON.addProperty("correo", rs.getString(4));                
                rptaQuery.add(tempJSON);
            }
            
            rs.close();
            stmt.close();
            c.getConnection().close();
            
            Gson gson = new Gson();
            return gson.toJson(rptaQuery);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return null;
    }    
}