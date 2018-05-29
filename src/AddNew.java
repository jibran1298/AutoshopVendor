import javax.swing.JDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddNew extends javax.swing.JFrame {

    Connection myCon = null;
    ResultSet myRes = null;
    PreparedStatement add = null;
    Statement myStat = null;
    String selected;

    
    public AddNew() {
        initComponents();
        setLocationRelativeTo(null); // To Start Login Screen From Center of Screen
        setTitle("Add New Item/Category - Auto Shop Vendor ");
        dialogCategory.setLocationRelativeTo(null);
        dialogCategory.setTitle("Add New Category");
        dialogCategory.setSize(310, 160);
        selected = "Mechanical";
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCategory = new javax.swing.JDialog();
        labelInventoryHeading1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelCategory = new javax.swing.JButton();
        btnAddCategory = new javax.swing.JButton();
        labelInventoryHeading = new javax.swing.JLabel();
        fieldAddItemQuantity = new javax.swing.JTextField();
        labelQuantity = new javax.swing.JLabel();
        fieldAddItemName = new javax.swing.JTextField();
        labelItemName = new javax.swing.JLabel();
        fieldAddItemPrice = new javax.swing.JTextField();
        labelItemPrice = new javax.swing.JLabel();
        btnAddItem = new javax.swing.JButton();
        fieldAddItemCategory = new javax.swing.JComboBox<>();
        labelCategory = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelItemOther = new javax.swing.JLabel();
        fieldAddOther = new javax.swing.JTextField();

        dialogCategory.setAlwaysOnTop(true);
        dialogCategory.setModal(true);
        dialogCategory.setResizable(false);

        labelInventoryHeading1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        labelInventoryHeading1.setForeground(new java.awt.Color(0, 0, 153));
        labelInventoryHeading1.setText("Add New Category");

        jLabel1.setText("Category Name : ");

        btnCancelCategory.setBackground(new java.awt.Color(240, 36, 51));
        btnCancelCategory.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnCancelCategory.setForeground(java.awt.Color.white);
        btnCancelCategory.setText("Cancel");
        btnCancelCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCategoryActionPerformed(evt);
            }
        });

        btnAddCategory.setBackground(new java.awt.Color(51, 153, 0));
        btnAddCategory.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAddCategory.setForeground(java.awt.Color.white);
        btnAddCategory.setText("Add ");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogCategoryLayout = new javax.swing.GroupLayout(dialogCategory.getContentPane());
        dialogCategory.getContentPane().setLayout(dialogCategoryLayout);
        dialogCategoryLayout.setHorizontalGroup(
            dialogCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(labelInventoryHeading1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogCategoryLayout.createSequentialGroup()
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        dialogCategoryLayout.setVerticalGroup(
            dialogCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInventoryHeading1)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelInventoryHeading.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        labelInventoryHeading.setForeground(new java.awt.Color(0, 0, 153));
        labelInventoryHeading.setText("Add New Item");

        labelQuantity.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelQuantity.setLabelFor(fieldAddItemQuantity);
        labelQuantity.setText("QTY : ");

        labelItemName.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelItemName.setLabelFor(fieldAddItemName);
        labelItemName.setText("Item name : ");

        labelItemPrice.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelItemPrice.setLabelFor(fieldAddItemPrice);
        labelItemPrice.setText("Price : ");

        btnAddItem.setBackground(new java.awt.Color(51, 153, 0));
        btnAddItem.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAddItem.setForeground(java.awt.Color.white);
        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        fieldAddItemCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mechanical", "Electrical", "Spare Parts" }));
        fieldAddItemCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fieldAddItemCategoryItemStateChanged(evt);
            }
        });
        fieldAddItemCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddItemCategoryActionPerformed(evt);
            }
        });

        labelCategory.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelCategory.setLabelFor(fieldAddItemCategory);
        labelCategory.setText("Category : ");

        btnCancel.setBackground(new java.awt.Color(204, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        labelItemOther.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelItemOther.setLabelFor(fieldAddItemCategory);
        labelItemOther.setText("Engine #");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldAddItemCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelInventoryHeading)
                                .addComponent(labelItemName)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldAddItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelQuantity))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelItemPrice)
                                        .addComponent(fieldAddItemPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                                .addComponent(labelCategory)
                                .addComponent(fieldAddItemName))
                            .addComponent(labelItemOther))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldAddOther, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInventoryHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelItemName)
                .addGap(4, 4, 4)
                .addComponent(fieldAddItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAddItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItemPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAddItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(labelCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAddItemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelItemOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAddOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
       
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void fieldAddItemCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddItemCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddItemCategoryActionPerformed

    private void btnCancelCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCategoryActionPerformed
        // TODO add your handling code here:
        dialogCategory.dispose();
    }//GEN-LAST:event_btnCancelCategoryActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        // TODO add your handling code here:
        dialogCategory.dispose();
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
        if(selected=="Electrical")
        {
            System.out.println("Added Electrical item");
            Electrical obj = new Electrical();
            obj.name = fieldAddItemName.getText();
            obj.price = Integer.parseInt(fieldAddItemPrice.getText());
            obj.quantity = Integer.parseInt(fieldAddItemQuantity.getText());
            obj.voltageType = fieldAddOther.getText();
            obj.saveItem();
        }
        else if(selected=="Mechanical")
        {
            System.out.println("Added Mechanical item");
             
            Mechanical obj = new Mechanical();
            obj.name = fieldAddItemName.getText();
            obj.price = Integer.parseInt(fieldAddItemPrice.getText());
            obj.quantity = Integer.parseInt(fieldAddItemQuantity.getText());
            obj.engineNumber = Integer.parseInt(fieldAddOther.getText());
            obj.saveItem();
        }
        else if(selected=="Spare Parts")
        {
            System.out.println("Added Spare Parts");
            
            SpareParts obj = new SpareParts();
            obj.name = fieldAddItemName.getText();
            obj.price = Integer.parseInt(fieldAddItemPrice.getText());
            obj.quantity = Integer.parseInt(fieldAddItemQuantity.getText());
            obj.partType= fieldAddOther.getText();
            obj.saveItem();
        }
        
        this.dispose();
       
        
        
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void fieldAddItemCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fieldAddItemCategoryItemStateChanged
        // TODO add your handling code here:
        System.out.println("State Changed");
        selected = fieldAddItemCategory.getSelectedItem().toString();
        System.out.println(selected);
        if(selected=="Electrical")
        {
            labelItemOther.setText("Voltage Type (AC/DC) : ");
        }
        else if(selected=="Mechanical")
        {
            labelItemOther.setText("Engine # ");
        }
        else if(selected=="Spare Parts")
        {
            labelItemOther.setText("Part Type : ");
        }
        
    }//GEN-LAST:event_fieldAddItemCategoryItemStateChanged

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
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelCategory;
    private javax.swing.JDialog dialogCategory;
    private javax.swing.JComboBox<String> fieldAddItemCategory;
    private javax.swing.JTextField fieldAddItemName;
    private javax.swing.JTextField fieldAddItemPrice;
    private javax.swing.JTextField fieldAddItemQuantity;
    private javax.swing.JTextField fieldAddOther;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelInventoryHeading;
    private javax.swing.JLabel labelInventoryHeading1;
    private javax.swing.JLabel labelItemName;
    private javax.swing.JLabel labelItemOther;
    private javax.swing.JLabel labelItemPrice;
    private javax.swing.JLabel labelQuantity;
    // End of variables declaration//GEN-END:variables
}
