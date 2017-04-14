package pe.softweb.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.softweb.utils.ConnectionDB;

public class Accesos {
    public String listarAccesos(int usuarioId){
        ConnectionDB c = new ConnectionDB();
        PreparedStatement stmt = null;
        ArrayList<JsonObject> rptaQuery = new ArrayList<JsonObject>(); 
        
        try {
            stmt = c.getConnection().prepareStatement("SELECT id, momento FROM accesos WHERE  usuario_id = ?");
            stmt.setInt(1, usuarioId); 
            ResultSet rs = stmt.executeQuery();
            
            while ( rs.next() ) {
                JsonObject tempJSON = new JsonObject();
                tempJSON.addProperty("id", rs.getInt(1));
                tempJSON.addProperty("momento", rs.getString(2));  
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
