
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Mechanical extends Categories {
    
    int engineNumber;
    public void saveItem()      
    {
        makeConnection();
        
        try
        {
            String query = "INSERT INTO AUTO.ITEMS"
		+ "(PRICE, ITEMNAME, QTY,CATEGORY,ENGINE) VALUES"
		+ "(?,?,?,?,?)";
            add =  myCon.prepareStatement(query);
            
            add.setInt(1, price);
            add.setString(2, name);
            add.setInt(3, quantity);
            add.setString(4, "Mechanical");
            add.setInt(5, engineNumber);
            int row = add.executeUpdate();
            System.out.println("Item Added Successfully");
            JOptionPane.showMessageDialog(null, "Mechanical Item Added Successfully");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
