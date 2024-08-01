package Employee;

import java.sql.*;

public class conn {
    Connection connection;
    Statement statement;
    public Object conn;
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Amysql11@");
            statement = connection.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
