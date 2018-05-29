
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JIBRAN
 */
public class Sale extends javax.swing.JFrame {

    /**
     * Creates new form Sale
     */
    Connection myCon = null;
    Statement myStat = null;
    PreparedStatement add = null;
    ResultSet myRes = null;
    
    int total;
    int newBillId;
    boolean matched;
    int []  items = new int[50];
    int [] cart =new int[50];
    int cartIndex;
    String [] cartItemName = new String[50];
    int itemCount;
    public Sale() {
        total = 0;
        matched= false;
        initComponents();
        getItemsList();
        itemCount=0;
        reciept.setSize(350, 590);
        reciept.setLocationRelativeTo(this);
        cartIndex = 0;
        setLocationRelativeTo(null); // To Start Screen From Center of Screen
        setTitle("New Sale - Auto Shop Vendor"); //Setting Window Title
        labelTotal.setText("Total : 0");
        newBillId();
    }
    public void newBillId()
    {
        System.out.println("In Bill Function");
        try
                {
                    String query = "select * from AUTO.SALES";
                    myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
                    myStat=myCon.createStatement();
                    myRes = myStat.executeQuery(query);
                    while(myRes.next())
                    {
                        int id = myRes.getInt("REFERENCE");
                        System.out.println("Previous Bill # " + id++);
                        newBillId = id++;
                        
                       
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    System.out.println(e);
                }
    }
    public void getItemsList()
    {
        try
                {
                    String query = "select * from AUTO.ITEMS";
                    myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
                    myStat=myCon.createStatement();
                    myRes = myStat.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)tableItemsList.getModel();
                    model.setRowCount(0);
                    while(myRes.next())
                    {
                       
                        int id = myRes.getInt("ID");
                        String itemName= myRes.getString("itemName");
                        int qty= myRes.getInt("qty");
                        int price= myRes.getInt("price");
                        String cat = myRes.getString("category");
                        
                         if(qty > 0)
                        {
                               model.addRow(new Object[] {id,itemName});
                               
                        }
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    System.out.println(e);
                }
    }
    public void saveBill()
    {
        Calendar calendar = Calendar.getInstance();
        String todayDate = new java.sql.Date(calendar.getTime().getTime()).toString();
        DateFormat df = new SimpleDateFormat("MM");
        String month = df.format(calendar.getTime().getTime());
        
       
        labelInvoice.setText("Invoice # " + newBillId);
        for (int i =0 ; i<cartIndex;i++)
            {
                //System.out.println("Saved Invoice Item " + cartItemName[i] + "With Invoice # " + newBillId );
                //Saving Invoice 
                try{
                    
                    String query = "INSERT INTO AUTO.SALES"
                        + "(ITEMID, ITEMNAME, ITEMQTY,REFERENCE,DATE,TOTAL,MONTH) VALUES"
                        + "(?,?,?,?,?,?,?)";
                     add =  myCon.prepareStatement(query);
                    add.setInt(1, cart[i]);
                    add.setString(2, cartItemName[i]);
                    add.setInt(3, 1);
                    add.setInt(4, newBillId);
                    add.setString(5, todayDate);
                    add.setInt(6,total);
                    add.setString(7, month);
                    int row = add.executeUpdate();
                    System.out.println("Bill Saved Successfully with # "+newBillId);
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                //Saving Invoice 
            }

        
    }
    public void checkout()
    {
        labelTotalReciept.setText("Total : " + total);
        for (int i =0 ; i<cartIndex;i++)
        {
            System.out.println("Item ID :" + cart[i] );
            
            //updating qty in database
            try{
        String query = "Update AUTO.ITEMS Set  QTY = QTY - 1 where ID="+cart[i];
        Statement upd = myCon.createStatement();
        upd.executeUpdate(query);
       
        System.out.println("Quantity Decremented Successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
            //updaring qty in databse 
        }
         String paid = JOptionPane.showInputDialog("Total : "+total +"\nAmount Paid : ",0);
        int change = 0;
        change = Integer.parseInt(paid) - total;
        JOptionPane.showMessageDialog(null, "Change : " + change);
        saveBill();
        reciept.show();
        
        resetSale();
    }
    public void addToSale(int ids)
    {
        
        for(int i =0 ;i <itemCount;i++)
        {
            if(ids == items[i])
            {
                System.out.println("Item Already In Table with id " + ids + " At Index " + i);
                DefaultTableModel model = (DefaultTableModel)tableSale.getModel();
                DefaultTableModel model1 = (DefaultTableModel)tableReciept.getModel();
                 matched = true;
                 String qty = tableSale.getModel().getValueAt(i, 1).toString();
                 String Item = tableSale.getModel().getValueAt(i, 0).toString();
                 
                 cartItemName[cartIndex] = Item;
                 int iqty = Integer.parseInt(qty);
                 iqty++;
                model.setValueAt(iqty, i, 1);
                model1.setValueAt(iqty, i, 1);
                break;
            }
        }
        System.out.println(ids);
         
         try
                {
                    String query = "select * from AUTO.ITEMS WHERE ID = "+ids+"";
                    myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
                    myStat=myCon.createStatement();
                    myRes = myStat.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)tableSale.getModel();
                    DefaultTableModel model1 = (DefaultTableModel)tableReciept.getModel();
                    while(myRes.next())
                    {
                        int id = myRes.getInt("ID");
                        String itemName= myRes.getString("itemName");
                        int qty= myRes.getInt("qty");
                        int price= myRes.getInt("price");
                        String cat = myRes.getString("category");
                        total = total + price;
                        labelTotal.setText("Total : "+ total);
                        
                        
                        if(matched == true)
                        {
                            System.out.println("Not Adding Row");
                        }
                        
                        else 
                        { 
                            items[itemCount] = ids;
                            itemCount++;
                            cartItemName[cartIndex] = itemName;
                            model.addRow(new Object[] {itemName,1,price});
                            model1.addRow(new Object[] {itemName,1,price});
                        }
                       
                    }
                    
                    matched = false;
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    System.out.println(e);
                }
         cart[cartIndex] = ids;
        cartIndex++;
    }
    public void resetSale()
    {
         DefaultTableModel model = (DefaultTableModel)tableSale.getModel();
         DefaultTableModel model1 = (DefaultTableModel)tableReciept.getModel();
         model.setRowCount(0);
         
         total = 0;
         
         labelTotal.setText("Total : "+ total);
         //items= null;
         itemCount = 0;
         cartIndex = 0;
         //cart = null;
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reciept = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelInvoice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableReciept = new javax.swing.JTable();
        labelTotalReciept = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSale = new javax.swing.JTable();
        fieldAddItemNewSale = new javax.swing.JTextField();
        btnAddItemSale = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        btnAddItemSale1 = new javax.swing.JButton();
        btnAddItemSale2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableItemsList = new javax.swing.JTable();

        reciept.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("STIX", 1, 30)); // NOI18N
        jLabel1.setText("AUTOSHOP");

        labelInvoice.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        labelInvoice.setText("Invoice # : 013");

        tableReciept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableReciept.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        tableReciept.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "QTY", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableReciept.setGridColor(java.awt.Color.white);
        tableReciept.setRowHeight(30);
        jScrollPane2.setViewportView(tableReciept);
        if (tableReciept.getColumnModel().getColumnCount() > 0) {
            tableReciept.getColumnModel().getColumn(0).setResizable(false);
            tableReciept.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableReciept.getColumnModel().getColumn(1).setResizable(false);
            tableReciept.getColumnModel().getColumn(2).setResizable(false);
        }

        labelTotalReciept.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        labelTotalReciept.setText("Total : 4500");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel6.setText("GST  Tax : 0.00");

        jButton2.setBackground(new java.awt.Color(51, 153, 0));
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(labelInvoice))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(labelTotalReciept)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTotalReciept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout recieptLayout = new javax.swing.GroupLayout(reciept.getContentPane());
        reciept.getContentPane().setLayout(recieptLayout);
        recieptLayout.setHorizontalGroup(
            recieptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        recieptLayout.setVerticalGroup(
            recieptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recieptLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(java.awt.Color.white);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("< Back To Dashboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableSale.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        tableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "QTY", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSale.setRowHeight(30);
        tableSale.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tableSaleMouseDragged(evt);
            }
        });
        tableSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableSaleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableSale);
        if (tableSale.getColumnModel().getColumnCount() > 0) {
            tableSale.getColumnModel().getColumn(0).setResizable(false);
            tableSale.getColumnModel().getColumn(0).setPreferredWidth(300);
            tableSale.getColumnModel().getColumn(1).setResizable(false);
            tableSale.getColumnModel().getColumn(2).setResizable(false);
        }

        fieldAddItemNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddItemNewSaleActionPerformed(evt);
            }
        });

        btnAddItemSale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddItemSale.setText("+ Add ");
        btnAddItemSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemSaleActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(51, 153, 0));
        labelTotal.setText("Total : ");

        btnAddItemSale1.setBackground(new java.awt.Color(204, 0, 0));
        btnAddItemSale1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddItemSale1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddItemSale1.setText("Reset");
        btnAddItemSale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemSale1ActionPerformed(evt);
            }
        });

        btnAddItemSale2.setBackground(new java.awt.Color(51, 153, 0));
        btnAddItemSale2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddItemSale2.setForeground(new java.awt.Color(255, 255, 255));
        btnAddItemSale2.setText("Checkout");
        btnAddItemSale2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemSale2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("New Sale");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("List of Items");

        tableItemsList.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        tableItemsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItemsList.setRowHeight(25);
        tableItemsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableItemsListMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableItemsList);
        if (tableItemsList.getColumnModel().getColumnCount() > 0) {
            tableItemsList.getColumnModel().getColumn(0).setResizable(false);
            tableItemsList.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableItemsList.getColumnModel().getColumn(1).setResizable(false);
            tableItemsList.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(fieldAddItemNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAddItemSale, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnAddItemSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddItemSale2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelTotal)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(83, 83, 83)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldAddItemNewSale, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(btnAddItemSale, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(398, 398, 398)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddItemSale2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddItemSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTotal))))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Moving Back to Dashboard From New Sale Page 
        this.dispose();
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddItemSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemSaleActionPerformed
        // TODO add your handling code here:
        
        addToSale(Integer.parseInt(fieldAddItemNewSale.getText()));
       
    }//GEN-LAST:event_btnAddItemSaleActionPerformed

    private void fieldAddItemNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddItemNewSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddItemNewSaleActionPerformed

    private void btnAddItemSale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemSale1ActionPerformed
        // TODO add your handling code here:
        resetSale();
    }//GEN-LAST:event_btnAddItemSale1ActionPerformed

    private void btnAddItemSale2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemSale2ActionPerformed
        // TODO add your handling code here:
        checkout();
    }//GEN-LAST:event_btnAddItemSale2ActionPerformed

    private void tableItemsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemsListMouseClicked
       
    }//GEN-LAST:event_tableItemsListMouseClicked

    private void tableItemsListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemsListMousePressed
        // TODO add your handling code here:
         int row = tableItemsList.getSelectedRow();
        String  id = tableItemsList.getModel().getValueAt(row, 0).toString();
        addToSale(Integer.parseInt(id));
    }//GEN-LAST:event_tableItemsListMousePressed

    private void tableSaleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSaleMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableSaleMouseDragged

    private void tableSaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableSaleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSaleKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reciept.dispose();
        DefaultTableModel model1 = (DefaultTableModel)tableReciept.getModel();
         model1.setRowCount(0);
         newBillId();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Sale().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItemSale;
    private javax.swing.JButton btnAddItemSale1;
    private javax.swing.JButton btnAddItemSale2;
    private javax.swing.JTextField fieldAddItemNewSale;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelInvoice;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotalReciept;
    private javax.swing.JDialog reciept;
    private javax.swing.JTable tableItemsList;
    private javax.swing.JTable tableReciept;
    private javax.swing.JTable tableSale;
    // End of variables declaration//GEN-END:variables
}
