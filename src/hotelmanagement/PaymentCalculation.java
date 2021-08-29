/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahfooz
 */
public class PaymentCalculation extends javax.swing.JFrame {

    /**
     * Creates new form PaymentMethod
     */
    public PaymentCalculation() {
        initComponents();
        Connect();
        LoadProductNo();
        Color col = new Color(255, 255, 200);
        getContentPane().setBackground(col);
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentCalculation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCalculation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void LoadProductNo(){
        
        
        try {
            pst = con.prepareStatement("select guestId, roomId from roomreservation");
            rs = pst.executeQuery();
            comboGuestId.removeAllItems();
            comboRoomid.removeAllItems();
            while(rs.next()){
                comboGuestId.addItem(rs.getString(1));
                comboRoomid.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCalculation.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtServiceChargers = new javax.swing.JTextField();
        txtTotalBill = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txtSave = new com.k33ptoo.components.KButton();
        btnSearch = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        txtDeleteButton = new com.k33ptoo.components.KButton();
        jLabel3 = new javax.swing.JLabel();
        txtUpdatedButton = new com.k33ptoo.components.KButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFacilityChargers = new javax.swing.JTextField();
        comboRoomid = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPayCalId = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        comboGuestId = new javax.swing.JComboBox<>();
        header = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment Calculation");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        txtServiceChargers.setBackground(new java.awt.Color(51, 51, 51));
        txtServiceChargers.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtServiceChargers.setForeground(new java.awt.Color(255, 234, 0));
        txtServiceChargers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtServiceChargers.setCaretColor(new java.awt.Color(255, 234, 0));

        txtTotalBill.setBackground(new java.awt.Color(51, 51, 51));
        txtTotalBill.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtTotalBill.setForeground(new java.awt.Color(255, 234, 0));
        txtTotalBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTotalBill.setCaretColor(new java.awt.Color(255, 234, 0));

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Total Bill");

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        txtSave.setBackground(new java.awt.Color(51, 51, 51));
        txtSave.setForeground(new java.awt.Color(51, 51, 51));
        txtSave.setText("Save");
        txtSave.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtSave.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        txtSave.setkBorderRadius(40);
        txtSave.setkEndColor(new java.awt.Color(255, 234, 0));
        txtSave.setkForeGround(new java.awt.Color(51, 51, 51));
        txtSave.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        txtSave.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        txtSave.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        txtSave.setkPressedColor(new java.awt.Color(102, 102, 102));
        txtSave.setkStartColor(new java.awt.Color(255, 234, 0));
        txtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaveActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        btnSearch.setkBorderRadius(20);
        btnSearch.setkEndColor(new java.awt.Color(255, 234, 0));
        btnSearch.setkForeGround(new java.awt.Color(51, 51, 51));
        btnSearch.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        btnSearch.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        btnSearch.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        btnSearch.setkPressedColor(new java.awt.Color(102, 102, 102));
        btnSearch.setkStartColor(new java.awt.Color(255, 234, 0));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans ExtraBold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payment Calculation");

        txtDeleteButton.setBackground(new java.awt.Color(51, 51, 51));
        txtDeleteButton.setForeground(new java.awt.Color(51, 51, 51));
        txtDeleteButton.setText("Delete");
        txtDeleteButton.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtDeleteButton.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        txtDeleteButton.setkBorderRadius(40);
        txtDeleteButton.setkEndColor(new java.awt.Color(255, 234, 0));
        txtDeleteButton.setkForeGround(new java.awt.Color(51, 51, 51));
        txtDeleteButton.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        txtDeleteButton.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        txtDeleteButton.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        txtDeleteButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        txtDeleteButton.setkStartColor(new java.awt.Color(255, 234, 0));
        txtDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Guest Id");

        txtUpdatedButton.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdatedButton.setForeground(new java.awt.Color(51, 51, 51));
        txtUpdatedButton.setText("Update");
        txtUpdatedButton.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtUpdatedButton.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        txtUpdatedButton.setkBorderRadius(40);
        txtUpdatedButton.setkEndColor(new java.awt.Color(255, 234, 0));
        txtUpdatedButton.setkForeGround(new java.awt.Color(51, 51, 51));
        txtUpdatedButton.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        txtUpdatedButton.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        txtUpdatedButton.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        txtUpdatedButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        txtUpdatedButton.setkStartColor(new java.awt.Color(255, 234, 0));
        txtUpdatedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdatedButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Facility Charges");

        jLabel8.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Room id");

        txtFacilityChargers.setBackground(new java.awt.Color(51, 51, 51));
        txtFacilityChargers.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtFacilityChargers.setForeground(new java.awt.Color(255, 234, 0));
        txtFacilityChargers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFacilityChargers.setCaretColor(new java.awt.Color(255, 234, 0));
        txtFacilityChargers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacilityChargersActionPerformed(evt);
            }
        });

        comboRoomid.setBackground(new java.awt.Color(51, 51, 51));
        comboRoomid.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        comboRoomid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Service Chargers");

        txtPayCalId.setBackground(new java.awt.Color(51, 51, 51));
        txtPayCalId.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtPayCalId.setForeground(new java.awt.Color(255, 234, 0));
        txtPayCalId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPayCalId.setCaretColor(new java.awt.Color(255, 234, 0));

        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Pay Cal Id");

        comboGuestId.setBackground(new java.awt.Color(51, 51, 51));
        comboGuestId.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        comboGuestId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(txtUpdatedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(txtDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPayCalId, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtServiceChargers, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboGuestId, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(txtFacilityChargers, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboRoomid, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPayCalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboGuestId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(comboRoomid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(txtFacilityChargers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtServiceChargers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(txtTotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdatedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(255, 234, 0));

        jLabel6.setFont(new java.awt.Font("Open Sans SemiBold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Pahalage Hotel Management System");

        minimize.setFont(new java.awt.Font("Open Sans SemiBold", 0, 48)); // NOI18N
        minimize.setForeground(new java.awt.Color(0, 0, 0));
        minimize.setText("-");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        close.setFont(new java.awt.Font("Open Sans SemiBold", 0, 36)); // NOI18N
        close.setForeground(new java.awt.Color(0, 0, 0));
        close.setText("x");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close)
                .addGap(21, 21, 21))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(745, Short.MAX_VALUE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(849, 849, 849)
                        .addComponent(jLabel2)
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaveActionPerformed

        try {
            String pcId = txtPayCalId.getText();
            int facilityCharges = Integer.parseInt(txtFacilityChargers.getText());
            int serviceCharges  = Integer.parseInt(txtServiceChargers.getText());
            int totalBill = Integer.parseInt(txtTotalBill.getText());
            String rid = comboRoomid.getItemAt(comboRoomid.getSelectedIndex());
            String gid = comboGuestId.getItemAt(comboGuestId.getSelectedIndex());
            
            pst = con.prepareStatement("insert into paymentcalculation (payCalId, facilityCharges,serviceCharges, vat, totalBill) values (?,?,?,?,?) ");
//            pst.setString(1, pcId);
            pst.setInt(2, facilityCharges);
            pst.setInt(3, serviceCharges);
//            pst.setInt(4, vat);
            pst.setInt(5, totalBill);
            
            
            
            int k = pst.executeUpdate();
            
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Added");
//                txtPayCalc.setText("");
                txtFacilityChargers.setText("");
                txtServiceChargers.setText("");
//                txtVat.setText("");
                txtTotalBill.setText("");
//                txtPayCalc.requestFocus();
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Record Added failed");
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCalculation.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_txtSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        //       String pcId = txtPayCalc.getText();

        try {
            pst = con.prepareStatement("select * from paymentcalculation where payCalId = ? ");
//            pst.setString(1, pcId);
            rs = pst.executeQuery();
            
            if (rs.next() == true){
//                txtPayCalc.setText(rs.getString(1));
                txtFacilityChargers.setText(rs.getString(2));
                txtServiceChargers.setText(rs.getString(3));
//                txtVat.setText(rs.getString(4));
                txtTotalBill.setText(rs.getString(5));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeleteButtonActionPerformed

    }//GEN-LAST:event_txtDeleteButtonActionPerformed

    private void txtUpdatedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdatedButtonActionPerformed
       
    }//GEN-LAST:event_txtUpdatedButtonActionPerformed

    private void txtFacilityChargersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacilityChargersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacilityChargersActionPerformed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked

        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked

        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentCalculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentCalculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentCalculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentCalculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentCalculation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnSearch;
    private javax.swing.JLabel close;
    private javax.swing.JComboBox<String> comboGuestId;
    private javax.swing.JComboBox<String> comboRoomid;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel minimize;
    private com.k33ptoo.components.KButton txtDeleteButton;
    private javax.swing.JTextField txtFacilityChargers;
    private javax.swing.JTextField txtPayCalId;
    private com.k33ptoo.components.KButton txtSave;
    private javax.swing.JTextField txtServiceChargers;
    private javax.swing.JTextField txtTotalBill;
    private com.k33ptoo.components.KButton txtUpdatedButton;
    // End of variables declaration//GEN-END:variables
}
