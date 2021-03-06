
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jibran
 */
public class Employees extends javax.swing.JFrame {

    /**
     * Creates new form Employees
     */
    Connection myCon = null;
    Statement myState = null;
    ResultSet myRes = null;
    public Employees() {
        initComponents();
        getEmployees();
        setLocationRelativeTo(null);
        setTitle("Employees - Autoshop");
    }
    public void getEmployees()
    {
        try
        {
            String query = "select * from AUTO.EMPLOYEES";
            myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
            myState=myCon.createStatement();
            myRes=myState.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel)tableEmp.getModel();
             tableEmp.getColumnModel().getColumn(0).setMaxWidth(50);
             tableEmp.getColumnModel().getColumn(1).setMaxWidth(80);
            
            model.setRowCount(0);
            while(myRes.next())
            {
                int id= myRes.getInt("ID");
                String name =myRes.getString("Name");
                String contact=myRes.getString("Contact");
                String address=myRes.getString("Address");
                System.out.println(name);
                model.addRow(new Object[]{id,name,contact,address});
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

        labelEmployeeId = new javax.swing.JLabel();
        labelItemCategory = new javax.swing.JLabel();
        btnSearchEmployeeName = new javax.swing.JButton();
        fieldAddress = new javax.swing.JTextField();
        labelEmployeeName = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        fieldSearchEmployeeName = new javax.swing.JTextField();
        labelItemId = new javax.swing.JLabel();
        btnUpdateItem = new javax.swing.JButton();
        fieldName = new javax.swing.JTextField();
        labelItemName = new javax.swing.JLabel();
        labelItemQty = new javax.swing.JLabel();
        fieldContact = new javax.swing.JTextField();
        fieldSearchEmployeeId = new javax.swing.JTextField();
        btnDeleteItem = new javax.swing.JButton();
        btnSearchEmployeeId = new javax.swing.JButton();
        btnAddItemNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        labelInventoryHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        labelEmployeeId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelEmployeeId.setForeground(new java.awt.Color(51, 102, 255));
        labelEmployeeId.setText("Employee ID");

        labelItemCategory.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemCategory.setForeground(new java.awt.Color(51, 102, 255));
        labelItemCategory.setText("Address");

        btnSearchEmployeeName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchEmployeeName.setText("Search");
        btnSearchEmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEmployeeNameActionPerformed(evt);
            }
        });

        fieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddressActionPerformed(evt);
            }
        });

        labelEmployeeName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelEmployeeName.setForeground(new java.awt.Color(51, 102, 255));
        labelEmployeeName.setText("Employee Name");

        fieldId.setEditable(false);
        fieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        fieldSearchEmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchEmployeeNameActionPerformed(evt);
            }
        });

        labelItemId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemId.setForeground(new java.awt.Color(51, 102, 255));
        labelItemId.setText("ID :");

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

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });

        labelItemName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemName.setForeground(new java.awt.Color(51, 102, 255));
        labelItemName.setText("Employee Name :");

        labelItemQty.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelItemQty.setForeground(new java.awt.Color(51, 102, 255));
        labelItemQty.setText("Contact");

        fieldContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContactActionPerformed(evt);
            }
        });

        fieldSearchEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchEmployeeIdActionPerformed(evt);
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

        btnSearchEmployeeId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchEmployeeId.setText("Search");
        btnSearchEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEmployeeIdActionPerformed(evt);
            }
        });

        btnAddItemNew.setBackground(new java.awt.Color(51, 153, 0));
        btnAddItemNew.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddItemNew.setForeground(new java.awt.Color(255, 255, 255));
        btnAddItemNew.setText("Add Employee");
        btnAddItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemNewActionPerformed(evt);
            }
        });

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Employee Name", "Contact", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tableEmp.setRowHeight(25);
        tableEmp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tableEmpMouseDragged(evt);
            }
        });
        tableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableEmpMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableEmpMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmp);
        if (tableEmp.getColumnModel().getColumnCount() > 0) {
            tableEmp.getColumnModel().getColumn(1).setMinWidth(250);
            tableEmp.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableEmp.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableEmp.getColumnModel().getColumn(2).setMaxWidth(100);
            tableEmp.getColumnModel().getColumn(3).setMinWidth(200);
            tableEmp.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        labelInventoryHeading.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        labelInventoryHeading.setForeground(new java.awt.Color(0, 0, 153));
        labelInventoryHeading.setText("Employees");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("< Back To Dashboard");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

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
                                        .addComponent(labelEmployeeId)
                                        .addGap(169, 169, 169))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldSearchEmployeeId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSearchEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldSearchEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearchEmployeeName))
                                    .addComponent(labelEmployeeName))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelItemName)
                                    .addComponent(labelItemQty)
                                    .addComponent(labelItemCategory)
                                    .addComponent(fieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addComponent(fieldAddress)
                                    .addComponent(fieldContact))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 109, Short.MAX_VALUE)
                                .addComponent(labelItemId)
                                .addGap(18, 18, 18)
                                .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btnRefresh)
                        .addGap(30, 30, 30)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelInventoryHeading))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldSearchEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelItemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldContact, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelItemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdateItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddItemNew, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearchEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldSearchEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchEmployeeId, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEmployeeNameActionPerformed
        // TODO add your handling code here:
        String searchName = fieldSearchEmployeeName.getText();
        System.out.println(searchName);
        try{
            String query ="SELECT * FROM AUTO.EMPLOYEES Where Name Like '%"+searchName+"%'";
           
            Statement search=myCon.createStatement();
            myRes = search.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel)tableEmp.getModel();
             tableEmp.getColumnModel().getColumn(0).setMaxWidth(50);
             tableEmp.getColumnModel().getColumn(1).setMaxWidth(80);
            
            model.setRowCount(0);
            while(myRes.next())
            {
                int id= myRes.getInt("ID");
                String name =myRes.getString("Name");
                String contact=myRes.getString("Contact");
                String address=myRes.getString("Address");
                System.out.println(name);
                model.addRow(new Object[]{id,name,contact,address});
            }
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
           
        }  
        

    }//GEN-LAST:event_btnSearchEmployeeNameActionPerformed

    private void fieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddressActionPerformed

    private void fieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdActionPerformed

    private void fieldSearchEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchEmployeeNameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_fieldSearchEmployeeNameActionPerformed

    private void btnUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateItemActionPerformed
        // TODO add your handling code here:

        if(fieldName.getText().equals("") || fieldAddress.getText().equals("")||fieldContact.getText().equals(""))
        {
            System.out.println("Please Fill in All the Fields");
        }
        else
        {
            String name = fieldName.getText();
            String contact = fieldContact.getText();
            String address= fieldAddress.getText();
            String id = fieldId.getText();
            try{
                String query = "Update AUTO.EMPLOYEES Set Name = '"+name+"' ,  Address = '"+address+"' "+"  ,Contact = '"+contact+"'"+"  where ID="+fieldId.getText();
                Statement update = myCon.createStatement();
                update.executeUpdate(query);
               
                    System.out.println("Data Updated Successfully");
                    JOptionPane.showMessageDialog(null, "Employee Info Updated");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
            
            getEmployees();
        }

    }//GEN-LAST:event_btnUpdateItemActionPerformed

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNameActionPerformed

    private void fieldContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldContactActionPerformed

    private void fieldSearchEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchEmployeeIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSearchEmployeeIdActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        // TODO add your handling code here:
        try{
        String query = "Delete from AUTO.EMPLOYEES where ID="+fieldId.getText();
        Statement del = myCon.createStatement();
        del.executeUpdate(query);
        System.out.println("Employee Deleted Successfully");
        
        JOptionPane.showMessageDialog(null, "Employee Deleted");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        getEmployees();

    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void btnSearchEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEmployeeIdActionPerformed
        // TODO add your handling code here:

        int searchId = Integer.parseInt(fieldSearchEmployeeId.getText());
        try{
            String query ="SELECT * FROM AUTO.EMPLOYEES Where ID="+fieldSearchEmployeeId.getText();
            Statement search=myCon.createStatement();
            myRes = search.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel)tableEmp.getModel();
             tableEmp.getColumnModel().getColumn(0).setMaxWidth(50);
             tableEmp.getColumnModel().getColumn(1).setMaxWidth(80);
            
            model.setRowCount(0);
            while(myRes.next())
            {
                int id= myRes.getInt("ID");
                String name =myRes.getString("Name");
                String contact=myRes.getString("Contact");
                String address=myRes.getString("Address");
                System.out.println(name);
                model.addRow(new Object[]{id,name,contact,address});
            }
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
           
        }    
        

    }//GEN-LAST:event_btnSearchEmployeeIdActionPerformed

    private void btnAddItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemNewActionPerformed
        // TODO add your handling code here:
        addEmployee ad= new addEmployee();
        ad.show();
        
    }//GEN-LAST:event_btnAddItemNewActionPerformed

    private void tableEmpMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_tableEmpMouseDragged

    private void tableEmpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseReleased

    }//GEN-LAST:event_tableEmpMouseReleased

    private void tableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseClicked
        // TODO add your handling code here:
        int row = tableEmp.getSelectedRow();
        String id = tableEmp.getModel().getValueAt(row, 0).toString();
        String name = tableEmp.getModel().getValueAt(row, 1).toString();
       
        String contact = tableEmp.getModel().getValueAt(row, 2).toString();
        String address = tableEmp.getModel().getValueAt(row, 3).toString();
        fieldId.setText(id);
        fieldName.setText(name);
        fieldContact.setText(contact);
        fieldAddress.setText(address);
        
        btnUpdateItem.setEnabled(true);
        btnDeleteItem.setEnabled(true);
    }//GEN-LAST:event_tableEmpMouseClicked

    private void tableEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseExited

    }//GEN-LAST:event_tableEmpMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Moving Back to Dashboard From New Sale Page
        this.dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        getEmployees();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItemNew;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchEmployeeId;
    private javax.swing.JButton btnSearchEmployeeName;
    private javax.swing.JButton btnUpdateItem;
    private javax.swing.JTextField fieldAddress;
    private javax.swing.JTextField fieldContact;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldSearchEmployeeId;
    private javax.swing.JTextField fieldSearchEmployeeName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelEmployeeId;
    private javax.swing.JLabel labelEmployeeName;
    private javax.swing.JLabel labelInventoryHeading;
    private javax.swing.JLabel labelItemCategory;
    private javax.swing.JLabel labelItemId;
    private javax.swing.JLabel labelItemName;
    private javax.swing.JLabel labelItemQty;
    private javax.swing.JTable tableEmp;
    // End of variables declaration//GEN-END:variables
}
