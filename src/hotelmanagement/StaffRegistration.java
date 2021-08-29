/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahfooz
 */
public class StaffRegistration extends javax.swing.JFrame {

    /**
     * Creates new form StaffRegistration
     */
    public StaffRegistration() {
        initComponents();
        Connect();
        showStaff();
       
        Color col = new Color(255, 255, 200);
        getContentPane().setBackground(col);

        tableStaffRegistration.getTableHeader().setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
        tableStaffRegistration.getTableHeader().setOpaque(false);
        tableStaffRegistration.getTableHeader().setBackground(new Color(255,234,0));
        tableStaffRegistration.getTableHeader().setForeground(new Color(51,51,51));
        tableStaffRegistration.setBackground(new Color(51,51,51));
        tableStaffRegistration.setForeground(new Color(255, 255, 255));
        tableStaffRegistration.setRowHeight(45);
        tableStaffRegistration.setIntercellSpacing(new Dimension(0, 1));
        tableStaffRegistration.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
        tableStaffRegistration.setSelectionBackground(new Color(255,255,200));
        tableStaffRegistration.setSelectionForeground(new Color(51,51,51));
        tableStaffRegistration.setOpaque(false);

        jScrollPane1.getViewport().setBackground(new Color(51,51,51));
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     Statement st;
   

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     public ArrayList <Staff> staffList(){
        ArrayList <Staff> staffsList = new ArrayList<>();
        try {
            
            String query1 = "SELECT * FROM staffregistration";
            st = con.createStatement();
            rs = st.executeQuery(query1);
            Staff staff;
            while(rs.next()){
                staff = new Staff (
                        
                        rs.getString("staffId"),
                        rs.getString("employeeName"),
                        rs.getString("gender"),
                        rs.getInt("phoneNumber"),
                        rs.getString("email"),
                        rs.getString("nic")
                      
                        
                );
                staffsList.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffsList;
        
    }
    
    public void showStaff() {
        ArrayList <Staff> list = staffList();
        DefaultTableModel model = ( DefaultTableModel)tableStaffRegistration.getModel();
        Object [] row = new Object[6];
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getStaffId();
            row[1] = list.get(i).getEmployeeName();
            row[2] = list.get(i).getGender();
            row[3] = list.get(i).getPhoneNumber();
            row[4] = list.get(i).getEmail();
            row[5] = list.get(i).getNic();
           model.addRow(row);
           
            
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableStaffRegistration = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboGender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNic = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        btnSave = new com.k33ptoo.components.KButton();
        btnUpdate = new com.k33ptoo.components.KButton();
        btnSearch = new com.k33ptoo.components.KButton();
        btnHome = new com.k33ptoo.components.KButton();
        btnHome1 = new com.k33ptoo.components.KButton();
        header = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staff Registration");
        setUndecorated(true);

        tableStaffRegistration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff Id", "Employee Name", "Gender", "Phone Number", "Email", "NIC"
            }
        ));
        jScrollPane1.setViewportView(tableStaffRegistration);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Open Sans ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff Registration");

        btnDelete.setBackground(new java.awt.Color(51, 51, 51));
        btnDelete.setForeground(new java.awt.Color(51, 51, 51));
        btnDelete.setText("Delete");
        btnDelete.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        btnDelete.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        btnDelete.setkBorderRadius(40);
        btnDelete.setkEndColor(new java.awt.Color(255, 234, 0));
        btnDelete.setkForeGround(new java.awt.Color(51, 51, 51));
        btnDelete.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        btnDelete.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        btnDelete.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        btnDelete.setkPressedColor(new java.awt.Color(102, 102, 102));
        btnDelete.setkStartColor(new java.awt.Color(255, 234, 0));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Staff Id");

        txtStaffId.setBackground(new java.awt.Color(51, 51, 51));
        txtStaffId.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtStaffId.setForeground(new java.awt.Color(255, 234, 0));
        txtStaffId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtStaffId.setCaretColor(new java.awt.Color(255, 234, 0));
        txtStaffId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStaffIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Employee Name");

        txtEmployeeName.setBackground(new java.awt.Color(51, 51, 51));
        txtEmployeeName.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtEmployeeName.setForeground(new java.awt.Color(255, 234, 0));
        txtEmployeeName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEmployeeName.setCaretColor(new java.awt.Color(255, 234, 0));

        jLabel4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Gender");

        comboGender.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        comboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        comboGender.setSelectedIndex(1);

        jLabel5.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Phone Number");

        txtPhoneNumber.setBackground(new java.awt.Color(51, 51, 51));
        txtPhoneNumber.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(255, 234, 0));
        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPhoneNumber.setCaretColor(new java.awt.Color(255, 234, 0));

        jLabel6.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("NIC");

        txtNic.setBackground(new java.awt.Color(51, 51, 51));
        txtNic.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtNic.setForeground(new java.awt.Color(255, 234, 0));
        txtNic.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNic.setCaretColor(new java.awt.Color(255, 234, 0));

        txtEmail.setBackground(new java.awt.Color(51, 51, 51));
        txtEmail.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 234, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEmail.setCaretColor(new java.awt.Color(255, 234, 0));

        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator10.setForeground(new java.awt.Color(204, 204, 204));

        btnSave.setBackground(new java.awt.Color(51, 51, 51));
        btnSave.setForeground(new java.awt.Color(51, 51, 51));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        btnSave.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        btnSave.setkBorderRadius(40);
        btnSave.setkEndColor(new java.awt.Color(255, 234, 0));
        btnSave.setkForeGround(new java.awt.Color(51, 51, 51));
        btnSave.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        btnSave.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        btnSave.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        btnSave.setkPressedColor(new java.awt.Color(102, 102, 102));
        btnSave.setkStartColor(new java.awt.Color(255, 234, 0));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setForeground(new java.awt.Color(51, 51, 51));
        btnUpdate.setText("Update");
        btnUpdate.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        btnUpdate.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        btnUpdate.setkBorderRadius(40);
        btnUpdate.setkEndColor(new java.awt.Color(255, 234, 0));
        btnUpdate.setkForeGround(new java.awt.Color(51, 51, 51));
        btnUpdate.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        btnUpdate.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        btnUpdate.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        btnUpdate.setkPressedColor(new java.awt.Color(102, 102, 102));
        btnUpdate.setkStartColor(new java.awt.Color(255, 234, 0));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        btnHome.setBackground(new java.awt.Color(51, 51, 51));
        btnHome.setForeground(new java.awt.Color(51, 51, 51));
        btnHome.setText("Home");
        btnHome.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        btnHome.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        btnHome.setkBorderRadius(40);
        btnHome.setkEndColor(new java.awt.Color(255, 234, 0));
        btnHome.setkForeGround(new java.awt.Color(51, 51, 51));
        btnHome.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        btnHome.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        btnHome.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        btnHome.setkPressedColor(new java.awt.Color(102, 102, 102));
        btnHome.setkStartColor(new java.awt.Color(255, 234, 0));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnHome1.setBackground(new java.awt.Color(51, 51, 51));
        btnHome1.setForeground(new java.awt.Color(51, 51, 51));
        btnHome1.setText("Salary Calculation");
        btnHome1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        btnHome1.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        btnHome1.setkBorderRadius(40);
        btnHome1.setkEndColor(new java.awt.Color(255, 234, 0));
        btnHome1.setkForeGround(new java.awt.Color(51, 51, 51));
        btnHome1.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        btnHome1.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        btnHome1.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        btnHome1.setkPressedColor(new java.awt.Color(102, 102, 102));
        btnHome1.setkStartColor(new java.awt.Color(255, 234, 0));
        btnHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jSeparator6)
                                .addComponent(jSeparator7)
                                .addComponent(txtEmployeeName)
                                .addComponent(jSeparator8)
                                .addComponent(comboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPhoneNumber)
                                .addComponent(txtEmail)
                                .addComponent(jSeparator9)
                                .addComponent(jSeparator10)
                                .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)))
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        header.setBackground(new java.awt.Color(255, 234, 0));

        jLabel9.setFont(new java.awt.Font("Open Sans SemiBold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Pahalage Hotel Management System");

        minimize.setFont(new java.awt.Font("Open Sans SemiBold", 0, 48)); // NOI18N
        minimize.setForeground(new java.awt.Color(51, 51, 51));
        minimize.setText("-");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        close.setFont(new java.awt.Font("Open Sans SemiBold", 0, 36)); // NOI18N
        close.setForeground(new java.awt.Color(51, 51, 51));
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
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1356, Short.MAX_VALUE)
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
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            String staffId = txtStaffId.getText();
            String empName = txtEmployeeName.getText();
            String gender = (String) comboGender.getSelectedItem();
            int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
            String email = txtEmail.getText();
            String nic = txtNic.getText();

            pst = con.prepareStatement("update staffregistration set employeeName = ?, gender = ?, phoneNumber = ?, email = ?,nic = ?  where staffId = ?");
            pst.setString(1, empName);
            pst.setString(2, gender);
            pst.setInt(3, phoneNumber);
            pst.setString(4, email);
            pst.setString(5, nic);
            pst.setString(6, staffId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Updated");
                txtEmployeeName.setText("");
                txtPhoneNumber.setText("");
                comboGender.setSelectedIndex(0);
                txtEmail.setText("");
                txtNic.setText("");
                txtEmployeeName.requestFocus();

            }
            else{
                JOptionPane.showMessageDialog(this, "Record Added failed");
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String sId = txtStaffId.getText();
            String empName = txtEmployeeName.getText();
            String genderMale = comboGender.getItemAt(comboGender.getSelectedIndex());
            int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
            String email = txtEmail.getText();
            String nic = txtNic.getText();

            pst = con.prepareStatement("insert into staffregistration (staffId, employeeName, gender, phoneNumber, email,nic) values (?,?,?,?,?,?) ");
            pst.setString(1, sId);
            pst.setString(2, empName);
            pst.setString(3, genderMale);

            pst.setInt(4, phoneNumber);
            pst.setString(5, email);
            pst.setString(6, nic);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Added");
                txtStaffId.setText("");
                txtEmployeeName.setText("");
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                txtNic.setText("");
                comboGender.setSelectedIndex(0);
                txtStaffId.requestFocus();

            }
            else{
                JOptionPane.showMessageDialog(this, "Record Added failed");
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtStaffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStaffIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStaffIdActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {

            String sid = txtStaffId.getText();

            pst = con.prepareStatement("delete from staffregistration where staffId = ?");

            pst.setString(1, sid);
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Deleted");
                txtEmployeeName.setText("");
                txtEmail.setText("");
                txtNic.setText("");
                txtPhoneNumber.setText("");
                comboGender.setSelectedItem(0);

                txtEmployeeName.requestFocus();

            }
            else{
                JOptionPane.showMessageDialog(this, "Record deleted  failed");
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

       String sid = txtStaffId.getText();

        try {
            pst = con.prepareStatement("select * from staffregistration where staffId = ? ");
            pst.setString(1, sid);
            rs = pst.executeQuery();

            if (rs.next() == true){
                txtStaffId.setText(rs.getString(1));
                txtEmployeeName.setText(rs.getString(2));
                comboGender.setSelectedItem(rs.getString(3));
                txtPhoneNumber.setText(rs.getString(4));
                txtEmail.setText(rs.getString(5));
                txtNic.setText(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked

        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked

        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Home home = new Home();
        home.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome1ActionPerformed
       SalaryCalculation salaryCalculation = new SalaryCalculation();
       salaryCalculation.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnHome1ActionPerformed

    
  
   
   
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
            java.util.logging.Logger.getLogger(StaffRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnDelete;
    private com.k33ptoo.components.KButton btnHome;
    private com.k33ptoo.components.KButton btnHome1;
    private com.k33ptoo.components.KButton btnSave;
    private com.k33ptoo.components.KButton btnSearch;
    private com.k33ptoo.components.KButton btnUpdate;
    private javax.swing.JLabel close;
    private javax.swing.JComboBox<String> comboGender;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel minimize;
    private javax.swing.JTable tableStaffRegistration;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtStaffId;
    // End of variables declaration//GEN-END:variables
}
