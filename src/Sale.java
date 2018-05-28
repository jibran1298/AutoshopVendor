
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
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
    ResultSet myRes = null;
    int total;
    public Sale() {
        total = 0;
        initComponents();
        getItemsList();
        setLocationRelativeTo(null); // To Start Screen From Center of Screen
        setTitle("New Sale - Auto Shop Vendor"); //Setting Window Title
        labelTotal.setText("Total : 0");
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
    
    public void checkout()
    {
        String paid = JOptionPane.showInputDialog("Total : "+total +"\nAmount Paid : ",0);
        int change = 0;
        change = Integer.parseInt(paid) - total;
        
        JOptionPane.showMessageDialog(null, "Change : " + change);
        resetSale();
    }
    public void addToSale(int ids)
    {
        try
                {
                    String query = "select * from AUTO.ITEMS WHERE ID = "+ids+"";
                    myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
                    myStat=myCon.createStatement();
                    myRes = myStat.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)tableSale.getModel();
                    //model.setRowCount(0);
                    
                   
                    while(myRes.next())
                    {
                        int id = myRes.getInt("ID");
                        String itemName= myRes.getString("itemName");
                        int qty= myRes.getInt("qty");
                        int price= myRes.getInt("price");
                        String cat = myRes.getString("category");
                        total = total + price;
                        labelTotal.setText("Total : "+ total);
                        model.addRow(new Object[] {itemName,1,price,price});
                        
                       
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    System.out.println(e);
                }
    }
    public void resetSale()
    {
         DefaultTableModel model = (DefaultTableModel)tableSale.getModel();
         model.setRowCount(0);
         total = 0;
         labelTotal.setText("Total : "+ total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("< Back To Dashboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "QTY", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSale.setRowHeight(25);
        tableSale.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tableSaleMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(tableSale);
        if (tableSale.getColumnModel().getColumnCount() > 0) {
            tableSale.getColumnModel().getColumn(0).setResizable(false);
            tableSale.getColumnModel().getColumn(0).setPreferredWidth(300);
            tableSale.getColumnModel().getColumn(1).setResizable(false);
            tableSale.getColumnModel().getColumn(2).setResizable(false);
            tableSale.getColumnModel().getColumn(3).setResizable(false);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldAddItemNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddItemSale, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddItemSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddItemSale2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelTotal)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAddItemNewSale, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnAddItemSale, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddItemSale2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddItemSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTotal))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Moving Back to Dashboard From New Sale Page 
        this.dispose();
        Main m = new Main();
        m.show();
        
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tableItemsList;
    private javax.swing.JTable tableSale;
    // End of variables declaration//GEN-END:variables
}
