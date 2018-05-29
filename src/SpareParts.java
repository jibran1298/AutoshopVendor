
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class SpareParts extends Categories{
    
    String partType;
    public void saveItem()      
    {
        makeConnection();
        
        try
        {
            String query = "INSERT INTO AUTO.ITEMS"
		+ "(PRICE, ITEMNAME, QTY,CATEGORY,PART) VALUES"
		+ "(?,?,?,?,?)";
            add =  myCon.prepareStatement(query);
            
            add.setInt(1, price);
            add.setString(2, name);
            add.setInt(3, quantity);
            add.setString(4, "SpareParts");
            add.setString(5, partType);
            int row = add.executeUpdate();
            System.out.println("Item Added Successfully");
            JOptionPane.showMessageDialog(null, "Spare Parts  Item Added Successfully");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
