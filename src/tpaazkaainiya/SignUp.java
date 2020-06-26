/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya;

import tpaazkaainiya.code.BuzzActionListener;
import tpaazkaainiya.code.TPAAzkaAiniya;
import static java.awt.Color.blue;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Jabrikos
 */
public class SignUp extends javax.swing.JFrame {

    public static char[] passwordUser;

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Akun TPA Azka Ainiya");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("<html><font color=\"green\">Daftar Akun <b>TPA Azka Ainiya</b></font></html>");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Perumahan Griya Indah Serpong Blok 05/14 Gunung Sindur Kabupaten Bogor");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Username/Nama");

        jLabel2.setText("Password");

        jLabel3.setText("Ulangi Password");

        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
        });

        jButton1.setText("Daftar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpaazkaainiya/image/LogoTPAAzkaAiniya.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("<html> Kembali ke Login</html>");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel6)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(760, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().isEmpty() && jPasswordField1.getPassword().length == 0 && jPasswordField2.getPassword().length == 0) {
            BuzzActionListener buzzActionListener = new BuzzActionListener(this);
            buzzActionListener.actionPerformed();
            JOptionPane.showMessageDialog(null, "Username, Password dan Ulangi Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);     
        } else if (jPasswordField1.getPassword().length == 0 && jPasswordField2.getPassword().length == 0) {
            BuzzActionListener buzzActionListener = new BuzzActionListener(this);
            buzzActionListener.actionPerformed();
            JOptionPane.showMessageDialog(null, "Password dan Ulangi Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jTextField1.getText().isEmpty()) {
            BuzzActionListener buzzActionListener = new BuzzActionListener(this);
            buzzActionListener.actionPerformed();
            JOptionPane.showMessageDialog(null, "Username harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jPasswordField1.getPassword().length == 0) {
            BuzzActionListener buzzActionListener = new BuzzActionListener(this);
            buzzActionListener.actionPerformed();
            JOptionPane.showMessageDialog(null, "Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jPasswordField2.getPassword().length == 0) {
            BuzzActionListener buzzActionListener = new BuzzActionListener(this);
            buzzActionListener.actionPerformed();
            JOptionPane.showMessageDialog(null, "Ulangi Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jTextField1.getText().length() <= 5) {
            BuzzActionListener buzzActionListener = new BuzzActionListener(this);
            buzzActionListener.actionPerformed();
            JOptionPane.showMessageDialog(null, "Username terlalu pendek!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Arrays.equals(jPasswordField1.getPassword(), jPasswordField2.getPassword())) {
                if (jPasswordField1.getPassword().length <= 5 && jPasswordField2.getPassword().length <= 5) {
                    BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                    buzzActionListener.actionPerformed();
                    JOptionPane.showMessageDialog(null, "Password terlalu pendek!", "Error", JOptionPane.ERROR_MESSAGE);                
                } else {
                    passwordUser = jPasswordField1.getPassword();
                    
                    try { 
                        TPAAzkaAiniya tpaAzkaAiniya = new TPAAzkaAiniya();
                        tpaAzkaAiniya.signUp();
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchProviderException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                
            } else {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Password dan Ulangi Password tidak sama!", "Error", JOptionPane.ERROR_MESSAGE);            
            }
        }
        jTextField1.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        Border labelBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, blue);
        jLabel5.setBorder(labelBorder);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        jLabel7.setText("<html><font color=\"green\"><b>Perumahan Griya Indah Serpong Blok 05/14 Gunung Sindur Kabupaten Bogor</b></font></html>");
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        jLabel7.setText("Perumahan Griya Indah Serpong Blok 05/14 Gunung Sindur Kabupaten Bogor");
    }//GEN-LAST:event_jLabel7MouseExited

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            if (jTextField1.getText().isEmpty() && jPasswordField1.getPassword().length == 0 && jPasswordField2.getPassword().length == 0) {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Username, Password dan Ulangi Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);     
            } else if (jPasswordField1.getPassword().length == 0 && jPasswordField2.getPassword().length == 0) {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Password dan Ulangi Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (jTextField1.getText().isEmpty()) {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Username harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (jPasswordField1.getPassword().length == 0) {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (jPasswordField2.getPassword().length == 0) {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Ulangi Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (jTextField1.getText().length() <= 5) {
                BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                buzzActionListener.actionPerformed();
                JOptionPane.showMessageDialog(null, "Username terlalu pendek!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (Arrays.equals(jPasswordField1.getPassword(), jPasswordField2.getPassword())) {
                    if (jPasswordField1.getPassword().length <= 5 && jPasswordField2.getPassword().length <= 5) {
                        BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                        buzzActionListener.actionPerformed();
                        JOptionPane.showMessageDialog(null, "Password terlalu pendek!", "Error", JOptionPane.ERROR_MESSAGE);                
                    } else {
                        passwordUser = jPasswordField1.getPassword();

                        try { 
                            TPAAzkaAiniya tpaAzkaAiniya = new TPAAzkaAiniya();
                            tpaAzkaAiniya.signUp();
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NoSuchProviderException ex) {
                            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }                
                } else {
                    BuzzActionListener buzzActionListener = new BuzzActionListener(this);
                    buzzActionListener.actionPerformed();
                    JOptionPane.showMessageDialog(null, "Password dan Ulangi Password tidak sama!", "Error", JOptionPane.ERROR_MESSAGE);            
                }
            }
            jTextField1.setText("");
            jPasswordField1.setText("");
            jPasswordField2.setText("");
            
        
        }
    }//GEN-LAST:event_jPasswordField2KeyPressed
    
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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPasswordField jPasswordField1;
    public static javax.swing.JPasswordField jPasswordField2;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}