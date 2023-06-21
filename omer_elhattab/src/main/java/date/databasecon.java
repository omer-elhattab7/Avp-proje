package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databasecon {
    public  static Connection database_run() throws SQLException,ClassNotFoundException{
        String dbDriver="com.mysql.cj.jdbc.Driver";
        String dbURl="jdbc:mysql://localhost:3306/";
        String dbName="gorevllistesi";
        String dbUsername="omer22";
        String dbpaasword="plok123";
        Class.forName(dbDriver);
        Connection con= DriverManager.getConnection(dbURl+ dbName,dbUsername,dbpaasword);
        return con;
    }
}
