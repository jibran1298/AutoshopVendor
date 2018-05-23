
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Inventory extends javax.swing.JFrame {

    Connection myCon = null;
    Statement myStat = null;
    ResultSet myRes = null;
    
    public Inventory() {
        initComponents();
        setLocationRelativeTo(null); // To Start  Screen From Center of Screen
        setTitle("Inventory - Auto Shop Vendor "); // Setting Window Titles
        getStock();
    }
    public void getStock()
    {
              try
                {
                    String query = "select * from AUTO.ITEMS";
                    myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
                    myStat=myCon.createStatement();
                    myRes = myStat.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)tableStock.getModel();
                    model.setRowCount(0);
                   
                    while(myRes.next())
                    {
                        int id = myRes.getInt("ID");
                        String itemName= myRes.getString("itemName");
                        int qty= myRes.getInt("qty");
                        int price= myRes.getInt("price");
                        String cat = myRes.getString("category");
                        
                        model.addRow(new Object[]{id, itemName, qty,cat,price});
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    System.out.println(e);
                }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldSearchItemId = new javax.swing.JTextField();
        btnDeleteItem = new javax.swing.JButton();
        btnSearchItemId = new javax.swing.JButton();
        btnAddItemNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStock = new javax.swing.JTable();
        labelInventoryHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelItemIdSearch = new javax.swing.JLabel();
        btnSearchItemName = new javax.swing.JButton();
        labelItemNameSearch = new javax.swing.JLabel();
        fieldSearchItemName = new javax.swing.JTextField();
        btnUpdateItem = new javax.swing.JButton();
        fieldUpdateItemName = new javax.swing.JTextField();
        labelItemName = new javax.swing.JLabel();
        labelItemQty = new javax.swing.JLabel();
        fieldUpdateItemQty = new javax.swing.JTextField();
        fieldUpdateItemPrice = new javax.swing.JTextField();
        labelItemPrice = new javax.swing.JLabel();
        labelItemCategory = new javax.swing.JLabel();
        fieldUpdateItemCategory = new javax.swing.JTextField();
        fieldItemID = new javax.swing.JTextField();
        labelItemId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fieldSearchItemId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchItemIdActionPerformed(evt);
            }
        });

        btnDeleteItem.setBackground(new java.awt.Color(204, 0, 0));
        btnDeleteItem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDeleteItem.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteItem.setText("Delete");
        btnDeleteItem.setEnabled(false);
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        btnSearchItemId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchItemId.setText("Search");
        btnSearchItemId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchItemIdActionPerformed(evt);
            }
        });

        btnAddItemNew.setBackground(new java.awt.Color(51, 153, 0));
        btnAddItemNew.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddItemNew.setForeground(new java.awt.Color(255, 255, 255));
        btnAddItemNew.setText("+ Add Item");
        btnAddItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemNewActionPerformed(evt);
            }
        });

        tableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name", "QTY", "Category", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStock.setRowHeight(25);
        tableStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStockMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableStockMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableStockMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableStock);
        if (tableStock.getColumnModel().getColumnCount() > 0) {
            tableStock.getColumnModel().getColumn(1).setResizable(false);
            tableStock.getColumnModel().getColumn(2).setResizable(false);
            tableStock.getColumnModel().getColumn(4).setResizable(false);
        }

        labelInventoryHeading.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        labelInventoryHeading.setForeground(new java.awt.Color(0, 0, 153));
        labelInventoryHeading.setText("Inventory");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("< Back To Dashboard");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labelItemIdSearch.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemIdSearch.setForeground(new java.awt.Color(51, 102, 255));
        labelItemIdSearch.setText("Item ID");

        btnSearchItemName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchItemName.setText("Search");
        btnSearchItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchItemNameActionPerformed(evt);
            }
        });

        labelItemNameSearch.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemNameSearch.setForeground(new java.awt.Color(51, 102, 255));
        labelItemNameSearch.setText("Item Name");

        fieldSearchItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchItemNameActionPerformed(evt);
            }
        });

        btnUpdateItem.setBackground(new java.awt.Color(0, 51, 204));
        btnUpdateItem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnUpdateItem.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateItem.setText("Update");
        btnUpdateItem.setEnabled(false);
        btnUpdateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateItemActionPerformed(evt);
            }
        });

        fieldUpdateItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUpdateItemNameActionPerformed(evt);
            }
        });

        labelItemName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemName.setForeground(new java.awt.Color(51, 102, 255));
        labelItemName.setText("Item Name");

        labelItemQty.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemQty.setForeground(new java.awt.Color(51, 102, 255));
        labelItemQty.setText("QTY");

        fieldUpdateItemQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUpdateItemQtyActionPerformed(evt);
            }
        });

        fieldUpdateItemPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUpdateItemPriceActionPerformed(evt);
            }
        });

        labelItemPrice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemPrice.setForeground(new java.awt.Color(51, 102, 255));
        labelItemPrice.setText("Price");

        labelItemCategory.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemCategory.setForeground(new java.awt.Color(51, 102, 255));
        labelItemCategory.setText("Category");

        fieldUpdateItemCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUpdateItemCategoryActionPerformed(evt);
            }
        });

        fieldItemID.setEditable(false);
        fieldItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldItemIDActionPerformed(evt);
            }
        });

        labelItemId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemId.setForeground(new java.awt.Color(51, 102, 255));
        labelItemId.setText("ID :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelItemIdSearch)
                                        .addGap(169, 169, 169))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldSearchItemId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSearchItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldSearchItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearchItemName))
                                    .addComponent(labelItemNameSearch))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelItemName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelItemQty)
                                            .addComponent(fieldUpdateItemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelItemPrice)
                                            .addComponent(fieldUpdateItemPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                                    .addComponent(labelItemCategory)
                                    .addComponent(fieldUpdateItemName)
                                    .addComponent(fieldUpdateItemCategory))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 106, Short.MAX_VALUE)
                                .addComponent(labelItemId)
                                .addGap(18, 18, 18)
                                .addComponent(fieldItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddItemNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUpdateItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelInventoryHeading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInventoryHeading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelItemIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldSearchItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUpdateItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelItemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldUpdateItemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldUpdateItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelItemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUpdateItemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdateItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddItemNew, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItemNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearchItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldSearchItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchItemId, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldSearchItemIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchItemIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSearchItemIdActionPerformed

    private void btnSearchItemIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchItemIdActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchItemIdActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Moving Back to Dashboard From New Sale Page
        this.dispose();
        Main m = new Main();
        m.show();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchItemNameActionPerformed

    private void fieldSearchItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSearchItemNameActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        // TODO add your handling code here:
        try{
        String query = "Delete from AUTO.ITEMS where ID="+fieldItemID.getText();
        Statement del = myCon.createStatement();
        del.executeUpdate(query);
        System.out.println("Item Deleted Successfully");
        
        JOptionPane.showMessageDialog(null, "Item Deleted");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        getStock();
        
    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void btnAddItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemNewActionPerformed
        // TODO add your handling code here:
        AddNew ad = new AddNew();
        ad.show();
        this.dispose();
    }//GEN-LAST:event_btnAddItemNewActionPerformed

    private void btnUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateItemActionPerformed
        // TODO add your handling code here:
        
        
        if(fieldUpdateItemName.getText().equals("") || fieldUpdateItemCategory.getText().equals("")||fieldUpdateItemQty.getText().equals("") || fieldUpdateItemPrice.getText().equals("" ))
        {
            System.out.println("Please Fill in All the Fields");
        }
        else
        {
            String name = fieldUpdateItemName.getText();
        String cat = fieldUpdateItemCategory.getText();
        int qty = Integer.parseInt(fieldUpdateItemQty.getText());
        System.out.println("Quantity : " + (qty + 1));
        int price = Integer.parseInt(fieldUpdateItemPrice.getText());
        String id = fieldItemID.getText();
            try{
        String query = "Update AUTO.ITEMS Set PRICE = "+price+" , QTY = "+qty+" ,  ITEMNAME = '"+name+"' "+"  ,CATEGORY = '"+cat+"'"+"  where ID="+fieldItemID.getText();
        Statement upd = myCon.createStatement();
        upd.executeUpdate(query);
        System.out.println("Item Updated Successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        getStock();
        }
        
    }//GEN-LAST:event_btnUpdateItemActionPerformed

    private void fieldUpdateItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUpdateItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUpdateItemNameActionPerformed

    private void fieldUpdateItemQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUpdateItemQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUpdateItemQtyActionPerformed

    private void fieldUpdateItemPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUpdateItemPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUpdateItemPriceActionPerformed

    private void fieldUpdateItemCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUpdateItemCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUpdateItemCategoryActionPerformed

    private void fieldItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldItemIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldItemIDActionPerformed

    private void tableStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStockMouseClicked
        // TODO add your handling code here:
            int row = tableStock.getSelectedRow();
            String id = tableStock.getModel().getValueAt(row, 0).toString();  
            String name = tableStock.getModel().getValueAt(row, 1).toString();
            String qty = tableStock.getModel().getValueAt(row, 2).toString();
            String cat = tableStock.getModel().getValueAt(row, 3).toString();
            String price = tableStock.getModel().getValueAt(row, 4).toString();
            fieldItemID.setText(id);
            fieldUpdateItemName.setText(name);
            fieldUpdateItemQty.setText(qty);
            fieldUpdateItemCategory.setText(cat);
            fieldUpdateItemPrice.setText(price);
            btnUpdateItem.setEnabled(true);
            btnDeleteItem.setEnabled(true);
    }//GEN-LAST:event_tableStockMouseClicked

    private void tableStockMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStockMouseReleased

    }//GEN-LAST:event_tableStockMouseReleased

    private void tableStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStockMouseExited

    }//GEN-LAST:event_tableStockMouseExited

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItemNew;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnSearchItemId;
    private javax.swing.JButton btnSearchItemName;
    private javax.swing.JButton btnUpdateItem;
    private javax.swing.JTextField fieldItemID;
    private javax.swing.JTextField fieldSearchItemId;
    private javax.swing.JTextField fieldSearchItemName;
    private javax.swing.JTextField fieldUpdateItemCategory;
    private javax.swing.JTextField fieldUpdateItemName;
    private javax.swing.JTextField fieldUpdateItemPrice;
    private javax.swing.JTextField fieldUpdateItemQty;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelInventoryHeading;
    private javax.swing.JLabel labelItemCategory;
    private javax.swing.JLabel labelItemId;
    private javax.swing.JLabel labelItemIdSearch;
    private javax.swing.JLabel labelItemName;
    private javax.swing.JLabel labelItemNameSearch;
    private javax.swing.JLabel labelItemPrice;
    private javax.swing.JLabel labelItemQty;
    private javax.swing.JTable tableStock;
    // End of variables declaration//GEN-END:variables
}
