
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Categories {
    int price;
    String name;
    int quantity;
     Connection myCon = null;
    ResultSet myRes = null;
    PreparedStatement add = null;
    Statement myStat = null;
   
    public void  makeConnection()
    {
        try
        {
             myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

