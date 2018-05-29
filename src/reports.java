
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class reports extends javax.swing.JFrame {
    
    int items;
    int prevId;
    int total;
    Connection myCon = null;
    Statement myStat = null;
    ResultSet myRes = null;
    String method;
    /**
     * Creates new form reports
     */
    public reports() {
        initComponents();
        setLocationRelativeTo(null);
        prevId = 0;
        method = "All";
        
        System.out.println(Calendar.getInstance().get(Calendar.MONTH)+1);
 
                
    }
    public void changeLabels()
    {
        labelItemsSold.setText("Items Sold : " + items);
        labelTotalSale.setText("Total Sale : " + total);
    }
    public void resetValues()
    {
        labelItemsSold.setText("Items Sold : " + 0);
        labelTotalSale.setText("Total Sale : " + 0);
        total = 0;
        items = 0;
        prevId=0;
    }
    public void getData()
    {
        resetValues();
        String query;
        if(method=="All")
        {
            query = "select * from AUTO.SALES ";
        }
        else if(method == "daily")
        {
            DateFormat df = new SimpleDateFormat("yyyy-MM-d");
            String dt = df.format(dailyReportDate.getDate());
            System.out.println("Searching for date : " + dt);
            query = "select * from AUTO.SALES WHERE DATE = '"+dt+"'";
        }
        else if(method == "monthly")
        {
            int month= reportMonthly.getMonth() + 1;
            
            System.out.println("Month : " + month);
            query = "select * from AUTO.SALES WHERE MONTH = "+month+" ";
        }
        else if(method=="range")
        {
            DateFormat df = new SimpleDateFormat("yyyy-MM-d");
            String fromDat = df.format(fromDate.getDate());
             String toDat = df.format(toDate.getDate());
            System.out.println("Searching for date : " + fromDat + "To" + toDat);
            query = "select * from AUTO.SALES WHERE DATE BETWEEN '"+fromDat+"' AND '"+toDat+"'";
        }
        else
        {
            query = "select * from AUTO.SALES ";
        }
        
        try
                {
                    
                    
                    myCon = DriverManager.getConnection("jdbc:derby://localhost:1527/autoshop", "auto", "1234");
                    myStat=myCon.createStatement();
                    myRes = myStat.executeQuery(query);
                    DefaultTableModel model = (DefaultTableModel)tableReports.getModel();
                    model.setRowCount(0);
                   
                    while(myRes.next())
                    {
                        int id = myRes.getInt("ITEMID");
                        String itemName= myRes.getString("ITEMNAME");
                        int ref= myRes.getInt("REFERENCE");
                        String date= myRes.getString("DATE");
                        model.addRow(new Object[]{itemName,id, date,ref});
                        
                        if(prevId!=ref)
                        {
                            total = total + myRes.getInt("TOTAL");
                            System.out.println("ID Not Matched");
                        }
                        prevId=ref;
                        items++;
                        
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    System.out.println(e);
                }
        changeLabels();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReports = new javax.swing.JTable();
        labelItemsSold = new javax.swing.JLabel();
        labelTotalSale = new javax.swing.JLabel();
        dailyReportDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        searchReportDaily = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        searchReportMonthly = new javax.swing.JButton();
        reportMonthly = new com.toedter.calendar.JMonthChooser();
        jLabel6 = new javax.swing.JLabel();
        fromDate = new com.toedter.calendar.JDateChooser();
        btnSearchDate = new javax.swing.JButton();
        toDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.activeCaption);
        jLabel1.setText("Reports");

        tableReports.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        tableReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item ID", "Date", "Bill #"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tableReports.setGridColor(java.awt.Color.white);
        tableReports.setRowHeight(25);
        jScrollPane1.setViewportView(tableReports);
        if (tableReports.getColumnModel().getColumnCount() > 0) {
            tableReports.getColumnModel().getColumn(0).setResizable(false);
            tableReports.getColumnModel().getColumn(1).setResizable(false);
            tableReports.getColumnModel().getColumn(2).setResizable(false);
            tableReports.getColumnModel().getColumn(3).setResizable(false);
        }

        labelItemsSold.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        labelItemsSold.setText("Items Sold : 0");

        labelTotalSale.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        labelTotalSale.setText("Total Sale : 0");

        dailyReportDate.setDateFormatString("yyyy-MM-d");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Search By Date");

        searchReportDaily.setText("Search");
        searchReportDaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReportDailyActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Search By Month");

        searchReportMonthly.setText("Search");
        searchReportMonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReportMonthlyActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("From :");

        fromDate.setDateFormatString("yyyy-MM-d");

        btnSearchDate.setText("Search");
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDateActionPerformed(evt);
            }
        });

        toDate.setDateFormatString("yyyy-MM-d");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("To : ");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("< Back To Dashboard");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTotalSale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelItemsSold))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dailyReportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchReportDaily)))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(reportMonthly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchReportMonthly)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(128, 128, 128))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(toDate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchDate)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(dailyReportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reportMonthly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(searchReportDaily)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchReportMonthly)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchDate))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItemsSold)
                    .addComponent(labelTotalSale))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchReportDailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReportDailyActionPerformed
        // TODO add your handling code here:
        method = "daily";
        getData();
    }//GEN-LAST:event_searchReportDailyActionPerformed

    private void searchReportMonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReportMonthlyActionPerformed
        // TODO add your handling code here:
        method = "monthly";
        getData();
    }//GEN-LAST:event_searchReportMonthlyActionPerformed

    private void btnSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDateActionPerformed
        // TODO add your handling code here:
        method = "range";
        getData();
    }//GEN-LAST:event_btnSearchDateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Moving Back to Dashboard From New Sale Page
        this.dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearchDate;
    private com.toedter.calendar.JDateChooser dailyReportDate;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelItemsSold;
    private javax.swing.JLabel labelTotalSale;
    private com.toedter.calendar.JMonthChooser reportMonthly;
    private javax.swing.JButton searchReportDaily;
    private javax.swing.JButton searchReportMonthly;
    private javax.swing.JTable tableReports;
    private com.toedter.calendar.JDateChooser toDate;
    // End of variables declaration//GEN-END:variables

    private DateFormat SimpleDateFormat(String yyyymmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
