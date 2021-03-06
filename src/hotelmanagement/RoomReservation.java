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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
public class RoomReservation extends javax.swing.JFrame {

    /**
     * Creates new form RoomReservation
     */
    public RoomReservation() {
        initComponents();
         Connect();
         LoadProductNo();
         showRoomReservation();
         
         Color col = new Color(255, 255, 200);
        getContentPane().setBackground(col);
        
        
        tableRoomReservation.getTableHeader().setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
        tableRoomReservation.getTableHeader().setOpaque(false);
        tableRoomReservation.getTableHeader().setBackground(new Color(255,234,0));
        tableRoomReservation.getTableHeader().setForeground(new Color(51,51,51));
        tableRoomReservation.setBackground(new Color(51,51,51));
        tableRoomReservation.setForeground(new Color(255, 255, 255));
        tableRoomReservation.setRowHeight(45);
        tableRoomReservation.setIntercellSpacing(new Dimension(0, 1));
        tableRoomReservation.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
        tableRoomReservation.setSelectionBackground(new Color(255,255,200));
        tableRoomReservation.setSelectionForeground(new Color(51,51,51));
        tableRoomReservation.setOpaque(false);
        
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
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void LoadProductNo(){
        
        
        try {
            pst = con.prepareStatement("select guestId from guestdetails");
            rs = pst.executeQuery();
            comboGuestId.removeAllItems();
            while(rs.next()){
                comboGuestId.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
      
      public ArrayList <Room> roomList(){
        ArrayList <Room> roomsList = new ArrayList<>();
        try {
            
            String query1 = "SELECT * FROM roomreservation";
            st = con.createStatement();
            rs = st.executeQuery(query1);
            Room room;
            while(rs.next()){
                room = new Room (
                        
                        rs.getString("roomId"),
                        rs.getString("guestId"),
                        rs.getString("roomType"),
                        rs.getString("checkIn"),
                        rs.getString("checkOut"),
                        rs.getInt("noOfAdult"),
                        rs.getInt("noOfChildren")
                        
                      
                        
                );
                roomsList.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roomsList;
        
    }
    
    public void showRoomReservation() {
        ArrayList <Room> list = roomList();
        DefaultTableModel model = ( DefaultTableModel)tableRoomReservation.getModel();
        Object [] row = new Object[7];
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getRoomId();
            row[1] = list.get(i).getGuestId();
            row[2] = list.get(i).getRoomtype();
            row[3] = list.get(i).getCheckIn();
            row[4] = list.get(i).getCheckOut();
            row[5] = list.get(i).getNoOfAdult();
            row[6] = list.get(i).getNoOfChildren();
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        comboGuestId = new javax.swing.JComboBox<>();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNoOfChildren = new javax.swing.JTextField();
        txtNoOfAdult = new javax.swing.JTextField();
        txtRoomId = new javax.swing.JTextField();
        comboRoomType = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        dateCheckIn = new com.toedter.calendar.JDateChooser();
        dateCheckOut = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new com.k33ptoo.components.KButton();
        txtSave = new com.k33ptoo.components.KButton();
        txtUpdate = new com.k33ptoo.components.KButton();
        txtDelete1 = new com.k33ptoo.components.KButton();
        btnHome = new com.k33ptoo.components.KButton();
        btnHome1 = new com.k33ptoo.components.KButton();
        header = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoomReservation = new javax.swing.JTable();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton1 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Reservation");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator11.setForeground(new java.awt.Color(204, 204, 204));

        comboGuestId.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        comboGuestId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jSeparator12.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Open Sans ExtraBold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Room Reservation");

        jLabel3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Room Id");

        jLabel4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Room Type");

        jLabel5.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Check In");

        jLabel6.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Check Out");

        jLabel7.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("No Of Adult");

        jLabel8.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("No Of Children");

        txtNoOfChildren.setBackground(new java.awt.Color(51, 51, 51));
        txtNoOfChildren.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtNoOfChildren.setForeground(new java.awt.Color(255, 234, 0));
        txtNoOfChildren.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNoOfChildren.setCaretColor(new java.awt.Color(255, 234, 0));

        txtNoOfAdult.setBackground(new java.awt.Color(51, 51, 51));
        txtNoOfAdult.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtNoOfAdult.setForeground(new java.awt.Color(255, 234, 0));
        txtNoOfAdult.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNoOfAdult.setCaretColor(new java.awt.Color(255, 234, 0));

        txtRoomId.setBackground(new java.awt.Color(51, 51, 51));
        txtRoomId.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtRoomId.setForeground(new java.awt.Color(255, 234, 0));
        txtRoomId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRoomId.setCaretColor(new java.awt.Color(255, 234, 0));

        comboRoomType.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        comboRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Triple", "Quad", "Queen", "King", "Twin" }));

        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));

        dateCheckIn.setForeground(new java.awt.Color(51, 51, 51));
        dateCheckIn.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N

        dateCheckOut.setForeground(new java.awt.Color(51, 51, 51));
        dateCheckOut.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Guest Id");

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

        txtUpdate.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdate.setForeground(new java.awt.Color(51, 51, 51));
        txtUpdate.setText("Update");
        txtUpdate.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtUpdate.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        txtUpdate.setkBorderRadius(40);
        txtUpdate.setkEndColor(new java.awt.Color(255, 234, 0));
        txtUpdate.setkForeGround(new java.awt.Color(51, 51, 51));
        txtUpdate.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        txtUpdate.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        txtUpdate.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        txtUpdate.setkPressedColor(new java.awt.Color(102, 102, 102));
        txtUpdate.setkStartColor(new java.awt.Color(255, 234, 0));
        txtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateActionPerformed(evt);
            }
        });

        txtDelete1.setBackground(new java.awt.Color(51, 51, 51));
        txtDelete1.setForeground(new java.awt.Color(51, 51, 51));
        txtDelete1.setText("Delete");
        txtDelete1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 18)); // NOI18N
        txtDelete1.setkBackGroundColor(new java.awt.Color(255, 234, 0));
        txtDelete1.setkBorderRadius(40);
        txtDelete1.setkEndColor(new java.awt.Color(255, 234, 0));
        txtDelete1.setkForeGround(new java.awt.Color(51, 51, 51));
        txtDelete1.setkHoverEndColor(new java.awt.Color(68, 68, 68));
        txtDelete1.setkHoverForeGround(new java.awt.Color(255, 234, 0));
        txtDelete1.setkHoverStartColor(new java.awt.Color(68, 68, 68));
        txtDelete1.setkPressedColor(new java.awt.Color(102, 102, 102));
        txtDelete1.setkStartColor(new java.awt.Color(255, 234, 0));
        txtDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDelete1ActionPerformed(evt);
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
        btnHome1.setText("Hall Reservation");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator6)
                                .addComponent(txtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jSeparator11)
                                .addComponent(dateCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNoOfAdult)
                                .addComponent(jSeparator12)
                                .addComponent(txtNoOfChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(comboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(comboGuestId, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(txtUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(txtDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(55, 55, 55))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(btnHome1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboGuestId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoOfAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoOfChildren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
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
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tableRoomReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Id", "Guest Id", "Room Type", "Check In", "Check Out", "No Of Adult", "No Of Children"
            }
        ));
        jScrollPane1.setViewportView(tableRoomReservation);

        kButton2.setBackground(new java.awt.Color(51, 51, 51));
        kButton2.setForeground(new java.awt.Color(255, 234, 0));
        kButton2.setText("Reservation Management");
        kButton2.setFont(new java.awt.Font("Open Sans SemiBold", 1, 24)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(51, 51, 51));
        kButton2.setkBorderRadius(50);
        kButton2.setkEndColor(new java.awt.Color(255, 234, 0));
        kButton2.setkForeGround(new java.awt.Color(68, 68, 68));
        kButton2.setkHoverColor(new java.awt.Color(51, 51, 51));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 234, 0));
        kButton2.setkHoverForeGround(new java.awt.Color(68, 68, 68));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 234, 0));
        kButton2.setkPressedColor(new java.awt.Color(255, 196, 0));
        kButton2.setkStartColor(new java.awt.Color(255, 234, 0));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton4.setBackground(new java.awt.Color(51, 51, 51));
        kButton4.setForeground(new java.awt.Color(51, 51, 51));
        kButton4.setText("Staff Management");
        kButton4.setFont(new java.awt.Font("Open Sans SemiBold", 1, 24)); // NOI18N
        kButton4.setkBorderRadius(50);
        kButton4.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton4.setkForeGround(new java.awt.Color(255, 234, 0));
        kButton4.setkHoverEndColor(new java.awt.Color(255, 234, 0));
        kButton4.setkHoverForeGround(new java.awt.Color(68, 68, 68));
        kButton4.setkHoverStartColor(new java.awt.Color(255, 234, 0));
        kButton4.setkPressedColor(new java.awt.Color(255, 196, 0));
        kButton4.setkStartColor(new java.awt.Color(51, 51, 51));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton3.setBackground(new java.awt.Color(51, 51, 51));
        kButton3.setForeground(new java.awt.Color(51, 51, 51));
        kButton3.setText("Payment Management");
        kButton3.setFont(new java.awt.Font("Open Sans SemiBold", 1, 24)); // NOI18N
        kButton3.setkBorderRadius(50);
        kButton3.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton3.setkForeGround(new java.awt.Color(255, 234, 0));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 234, 0));
        kButton3.setkHoverForeGround(new java.awt.Color(68, 68, 68));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 234, 0));
        kButton3.setkPressedColor(new java.awt.Color(255, 196, 0));
        kButton3.setkStartColor(new java.awt.Color(51, 51, 51));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton1.setBackground(new java.awt.Color(51, 51, 51));
        kButton1.setForeground(new java.awt.Color(51, 51, 51));
        kButton1.setText("Guest Management");
        kButton1.setFont(new java.awt.Font("Open Sans SemiBold", 1, 24)); // NOI18N
        kButton1.setkBorderRadius(50);
        kButton1.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton1.setkForeGround(new java.awt.Color(255, 234, 0));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 234, 0));
        kButton1.setkHoverForeGround(new java.awt.Color(68, 68, 68));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 234, 0));
        kButton1.setkPressedColor(new java.awt.Color(255, 196, 0));
        kButton1.setkStartColor(new java.awt.Color(51, 51, 51));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String sid = txtRoomId.getText();

        try {
            pst = con.prepareStatement("select * from roomreservation where roomId = ? ");
            pst.setString(1, sid);
            rs = pst.executeQuery();
            
            if (rs.next() == true){
                txtRoomId.setText(rs.getString(1));
                comboGuestId.setSelectedItem(rs.getString(2));
                 comboRoomType.setSelectedItem(rs.getString(3));
                dateCheckIn.setDate(rs.getDate(4));
               
                dateCheckOut.setDate(rs.getDate(5));
                txtNoOfAdult.setText(rs.getString(6));
                txtNoOfChildren.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaveActionPerformed

        try {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateCheckInString = dateFormat.format(dateCheckIn.getDate());
            String dateCheckOutString = dateFormat.format(dateCheckOut.getDate());
            
            String rId = txtRoomId.getText();
            String gid = comboGuestId.getItemAt(comboGuestId.getSelectedIndex());
            String roomType = comboRoomType.getItemAt(comboRoomType.getSelectedIndex());
            int noOfAdult = Integer.parseInt(txtNoOfAdult.getText());
            int noOfChildren = Integer.parseInt(txtNoOfChildren.getText());
           
            
            pst = con.prepareStatement("insert into roomreservation (roomId,guestId, roomType, checkIn, checkOut, noOfAdult,noOfChildren) values (?,?,?,?,?,?,?) ");
            pst.setString(1, rId);
            pst.setString(2, gid);
            pst.setString(3, roomType);
            pst.setString(4, dateCheckInString);
            pst.setString(5, dateCheckOutString);
            pst.setInt(6, noOfAdult);
            pst.setInt(7, noOfChildren);
            
            
            int k = pst.executeUpdate();
            
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Added");
                txtRoomId.setText("");
               
                txtNoOfAdult.setText("");
                txtNoOfChildren.setText("");
                txtRoomId.requestFocus();
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Record Added failed");
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSaveActionPerformed

    private void txtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateActionPerformed

         try {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateCheckInString = dateFormat.format(dateCheckIn.getDate());
            String dateCheckOutString = dateFormat.format(dateCheckOut.getDate());
            
            String rId = txtRoomId.getText();
            String gid = (String) comboGuestId.getSelectedItem();
            String roomType = (String) comboRoomType.getSelectedItem();
            int noOfAdult = Integer.parseInt(txtNoOfAdult.getText());
            int noOfChildren = Integer.parseInt(txtNoOfChildren.getText());
            
            
            pst = con.prepareStatement("update roomreservation set guestId = ? , roomType = ? , checkIn = ?, checkOut = ?, noOfAdult = ? ,noOfChildren = ? where roomId = ? ");
           
            pst.setString(1, gid);
            pst.setString(2, roomType);
            pst.setString(3, dateCheckInString);
            pst.setString(4, dateCheckOutString);
            pst.setInt(5, noOfAdult);
            pst.setInt(6, noOfChildren);
             pst.setString(7, rId);
            
            
            int k = pst.executeUpdate();
            
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Updated");
                txtRoomId.setText("");
               
                txtNoOfAdult.setText("");
                txtNoOfChildren.setText("");
                txtRoomId.requestFocus();
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Record Updated failed");
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtUpdateActionPerformed

    private void txtDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDelete1ActionPerformed

         try {
           
            String rid = txtRoomId.getText();
            
            pst = con.prepareStatement("delete from roomreservation where roomId = ?");

            pst.setString(1, rid);
            int k = pst.executeUpdate();
            
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Deleted");
               comboRoomType.setSelectedItem(0);
               dateCheckIn.setDateFormatString("");
               dateCheckOut.setDateFormatString("");
               txtRoomId.setText("");
                
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Record deleted  failed");
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(StaffRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDelete1ActionPerformed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked

        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked

        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
       Home home = new Home ();
       home.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome1ActionPerformed
       HallReservation hallReservation = new HallReservation();
        hallReservation.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnHome1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        StaffRegistration staffRegistration = new StaffRegistration();
        staffRegistration.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed

        GuestDetails guestDetails = new GuestDetails();
        guestDetails.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_kButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnHome;
    private com.k33ptoo.components.KButton btnHome1;
    private com.k33ptoo.components.KButton btnSearch;
    private javax.swing.JLabel close;
    private javax.swing.JComboBox<String> comboGuestId;
    private javax.swing.JComboBox<String> comboRoomType;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator6;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private javax.swing.JLabel minimize;
    private javax.swing.JTable tableRoomReservation;
    private com.k33ptoo.components.KButton txtDelete1;
    private javax.swing.JTextField txtNoOfAdult;
    private javax.swing.JTextField txtNoOfChildren;
    private javax.swing.JTextField txtRoomId;
    private com.k33ptoo.components.KButton txtSave;
    private com.k33ptoo.components.KButton txtUpdate;
    // End of variables declaration//GEN-END:variables
}
