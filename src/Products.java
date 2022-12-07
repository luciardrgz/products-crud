import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author luciardrigz
 */
public class Products extends javax.swing.JFrame {

    public Products() {
        initComponents();
        connect();
        loadProducts();
    }

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private String INSERT = "INSERT INTO products (p_name, p_price, p_qty) VALUES (?, ?, ?)";
    private String SELECTALL = "SELECT id FROM products";
    private String SELECTBYID = "SELECT * FROM products WHERE id = ?";
    private String SELECTBYNAME = "SELECT * FROM products WHERE p_name = ?";
    private String UPDATE = "UPDATE products SET p_name = ?, p_price = ?, p_qty = ? WHERE id = ?";
    private String DELETE = "DELETE FROM products WHERE id = ?";

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcproducts", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadProducts() {
        try {
            ps = con.prepareStatement(SELECTALL);
            rs = ps.executeQuery();
            txtProductID.removeAllItems();

            while (rs.next()) {
                txtProductID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Archivo ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Product info");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        jLabel2.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jLabel4.setText("Quantity");

        txtName.setFont(new java.awt.Font("Archivo", 0, 18)); // NOI18N

        txtPrice.setFont(new java.awt.Font("Archivo", 0, 18)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        txtQuantity.setFont(new java.awt.Font("Archivo", 0, 18)); // NOI18N
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtQuantity)
                    .addComponent(txtPrice)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        jButton2.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addGap(38, 38, 38)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        jLabel5.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jLabel5.setText("Select Product ID");

        txtProductID.setFont(new java.awt.Font("Archivo", 0, 18)); // NOI18N

        jButton4.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jButton4.setText("Search");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(17, 17, 17))))
                .addGap(121, 121, 121))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Archivo ExtraBold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Add, update or delete a product");

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        jButton5.setFont(new java.awt.Font("Archivo ExtraBold", 0, 18)); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        setBounds(0, 0, 1118, 596);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int modifiedRegisters = -1;

            String pname = txtName.getText();
            String price = txtPrice.getText();
            String qty = txtQuantity.getText();

            ps = con.prepareStatement(INSERT);

            if (checkProductExistence(pname) == false) {
                if (checkEmptyFields(pname, price, qty) && checkZeroPriceOrQty(price, qty)) {

                    ps.setString(1, pname);
                    ps.setString(2, price);
                    ps.setString(3, qty);

                    modifiedRegisters = ps.executeUpdate();

                    if (modifiedRegisters == 1) {

                        JOptionPane.showMessageDialog(this, "Product added");
                        txtName.setText("");
                        txtPrice.setText("");
                        txtQuantity.setText("");

                        txtName.requestFocus();
                        loadProducts();

                    } else {
                        JOptionPane.showMessageDialog(this, "Product couldn't be added");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, pname + " already exists");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        checkCharacter(c, evt);

    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char c = evt.getKeyChar();
        checkCharacter(c, evt);
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String productID = txtProductID.getSelectedItem().toString();

            ps = con.prepareStatement(SELECTBYID);
            ps.setString(1, productID);
            rs = ps.executeQuery();

            if (rs.next()) {
                txtName.setText(rs.getString(2)); // arg number is column position
                txtPrice.setText(rs.getString(3));
                txtQuantity.setText(rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int modifiedRegisters = -1;

            String pname = txtName.getText();
            String price = txtPrice.getText();
            String qty = txtQuantity.getText();
            String productID = txtProductID.getSelectedItem().toString();

            ps = con.prepareStatement(UPDATE);

            if (checkProductExistence(pname)) {
                if (checkEmptyFields(pname, price, qty) && checkZeroPriceOrQty(price, qty)) {

                    ps.setString(1, pname);
                    ps.setString(2, price);
                    ps.setString(3, qty);
                    ps.setString(4, productID);

                    modifiedRegisters = ps.executeUpdate();

                    if (modifiedRegisters == 1) {

                        JOptionPane.showMessageDialog(this, "Product updated");
                        txtName.setText("");
                        txtPrice.setText("");
                        txtQuantity.setText("");
                        loadProducts();

                        txtName.requestFocus();

                    } else {
                        JOptionPane.showMessageDialog(this, "Product couldn't be updated");
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtName.requestFocus();
        loadProducts();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            String pname = txtName.getText();
            String price = txtPrice.getText();
            String qty = txtQuantity.getText();
            String productID = txtProductID.getSelectedItem().toString();
            int modifiedRegisters = -1;

            ps = con.prepareStatement(DELETE);

            if (checkEmptyFields(pname, price, qty) && checkZeroPriceOrQty(price, qty)) {
                if (checkProductExistence(pname)) {
                    ps.setString(1, productID);

                    modifiedRegisters = ps.executeUpdate();

                    if (modifiedRegisters == 1) {

                        JOptionPane.showMessageDialog(this, "Product deleted");
                        txtName.setText("");
                        txtPrice.setText("");
                        txtQuantity.setText("");
                        loadProducts();

                        txtName.requestFocus();

                    } else {
                        JOptionPane.showMessageDialog(this, "Product couldn't be deleted");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, pname + " doesn't exists");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void checkCharacter(char character, java.awt.event.KeyEvent event) {

        if (!Character.isDigit(character)) {
            event.consume();
        }
    }

    private boolean checkZeroPriceOrQty(String price, String quantity) {
        boolean check = false;
        if (!price.equals("0") && !quantity.equals("0")) {
            check = true;
        } else {
            JOptionPane.showMessageDialog(this, "Price or quantity can't be 0");
        }
        return check;
    }

    private boolean checkEmptyFields(String name, String price, String quantity) {
        boolean check = false;
        if (!name.equals("") && !price.equals("") && !quantity.equals("")) {
            check = true;
        } else {
            JOptionPane.showMessageDialog(this, "Please complete all fields");
        }
        return check;
    }

    private boolean checkProductExistence(String prodName) {

        boolean check = true;

        try {
            PreparedStatement checkPs;
            ResultSet checkRs;

            checkPs = con.prepareStatement(SELECTBYNAME);
            checkPs.setString(1, prodName);
            checkRs = checkPs.executeQuery();

            if (!checkRs.first()) {
                check = false; // returns false if the product doesn't exist
            }

        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JComboBox<String> txtProductID;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
