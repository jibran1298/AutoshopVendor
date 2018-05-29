
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Electrical extends Categories {
    
    String voltageType;
    public void saveItem()      
    {
        makeConnection();
        
        try
        {
            String query = "INSERT INTO AUTO.ITEMS"
		+ "(PRICE, ITEMNAME, QTY,CATEGORY,VOLTAGE) VALUES"
		+ "(?,?,?,?,?)";
            add =  myCon.prepareStatement(query);
            
            add.setInt(1, price);
            add.setString(2, name);
            add.setInt(3, quantity);
            add.setString(4, "Electrical");
            add.setString(5, voltageType);
            int row = add.executeUpdate();
            System.out.println("Item Added Successfully");
            JOptionPane.showMessageDialog(null, "Electrical Item Added Successfully");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
