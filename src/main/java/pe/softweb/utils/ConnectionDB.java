package pe.softweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private Connection c;
    
    public ConnectionDB(){
        Connection c = null;
        
        try {
          Class.forName("org.sqlite.JDBC");
          c = (Connection)DriverManager.getConnection("jdbc:sqlite:src/main/java/pe/softweb/db/db_accesos.db");
          this.c = c;
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
    }

    public Connection getConnection() {
        return c;
    }
}
