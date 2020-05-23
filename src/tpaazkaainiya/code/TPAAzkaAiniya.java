/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya.code;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Window;
import static tpaazkaainiya.code.PasswordFieldToMD5.byteArrayToHexString;
import static tpaazkaainiya.code.PasswordFieldToMD5.digest;
import static tpaazkaainiya.code.PasswordFieldToMD5.getSalt;
import static tpaazkaainiya.code.PasswordFieldToMD5.hexStringToByteArray;
import static tpaazkaainiya.Login.jPasswordField1;
import static tpaazkaainiya.Login.jTextField1;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.commons.io.FileUtils;
import tpaazkaainiya.Login;
import tpaazkaainiya.Pembelajaran;
import tpaazkaainiya.SignUp;
import tpaazkaainiya.Siswa;


/**
 *
 * @author Jabrikos
 */
public class TPAAzkaAiniya {
    
    private static boolean passwordAdminPassed = false;
    
    private static boolean ifTrueForCheck = false;
    
    private static String namaSiswa, noInduk;
    
    private static String namaPembelajaran, kodePembelajaran;
    
    private static String pembelajaranKode, pembelajaranBiaya, pembelajaranNama, noIndukSiswaFromCombo, namaSiswaFromCombo;

     public static boolean isIfTrueForCheck() {
        return ifTrueForCheck;
    }

    public static void setIfTrueForCheck(boolean ifTrueForCheck) {
        TPAAzkaAiniya.ifTrueForCheck = ifTrueForCheck;
    }
    
    public static String getNamaSiswaFromCombo() {
        return namaSiswaFromCombo;
    }

    public static void setNamaSiswaFromCombo(String namaSiswaFromCombo) {
        TPAAzkaAiniya.namaSiswaFromCombo = namaSiswaFromCombo;
    }

    public static String getNoIndukSiswaFromCombo() {
        return noIndukSiswaFromCombo;
    }

    public static void setNoIndukSiswaFromCombo(String noIndukSiswaFromCombo) {
        TPAAzkaAiniya.noIndukSiswaFromCombo = noIndukSiswaFromCombo;
    }

    public static String getPembelajaranBiaya() {
        return pembelajaranBiaya;
    }

    public static void setPembelajaranBiaya(String pembelajaranBiaya) {
        TPAAzkaAiniya.pembelajaranBiaya = pembelajaranBiaya;
    }

    public static String getPembelajaranNama() {
        return pembelajaranNama;
    }

    public static void setPembelajaranNama(String pembelajaranNama) {
        TPAAzkaAiniya.pembelajaranNama = pembelajaranNama;
    }

    public static String getPembelajaranKode() {
        return pembelajaranKode;
    }

    public static void setPembelajaranKode(String pembelajaranKode) {
        TPAAzkaAiniya.pembelajaranKode = pembelajaranKode;
    }

    public static String getNamaPembelajaran() {
        return namaPembelajaran;
    }

    public static void setNamaPembelajaran(String namaPembelajaran) {
        TPAAzkaAiniya.namaPembelajaran = namaPembelajaran;
    }

    public static String getKodePembelajaran() {
        return kodePembelajaran;
    }

    public static void setKodePembelajaran(String kodePembelajaran) {
        TPAAzkaAiniya.kodePembelajaran = kodePembelajaran;
    }
    
    

    public static String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        TPAAzkaAiniya.namaSiswa = namaSiswa;
    }

    public static String getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(String noInduk) {
        TPAAzkaAiniya.noInduk = noInduk;
    }
    
    NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("ID"));
    JTable table;
    TableColumn column;

    int realColumnIndex;
    ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    Connection connection;
    static ResultSet resultSet;
    Statement statement;
    static PreparedStatement preparedStatement;
    String passwordOneDB, passwordTwoDB, passwordUser;
    String stringPath = null;
    
    ImageIcon icon = new ImageIcon ("src/tpaazkaainiya/image/success_icon.png");
    
    public static final int IMG_WIDTH = 354;
    public static final int IMG_HEIGHT = 472;
    
    
    public static void main (String [] args) {
        new Login().setVisible(true);
    }
    
    public static void verifikasiPassword() throws NoSuchAlgorithmException, NoSuchProviderException {
        final TPAAzkaAiniya tpaAzkaAiniya = new TPAAzkaAiniya();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        final JPasswordField passwordAdmin = new JPasswordField(15);
        passwordAdmin.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    char [] passwordAdminChar = passwordAdmin.getPassword();
                    String usernameAdmin = "IndraSudirman";
                    try {
                     ConnectionDatabase connectionDatabase = new ConnectionDatabase();
                     connectionDatabase.connect();
                     connectionDatabase.statement = connectionDatabase.connection.createStatement();
                     String sqlQuery = "SELECT `passwordOne`, `passwordTwo` FROM `users` WHERE username = ?";
                     preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                     preparedStatement.setString(1, usernameAdmin);
                     resultSet = preparedStatement.executeQuery();

                     if (resultSet.next()) {
                         String passwordOne = resultSet.getString(1);
                         String passwordTwo = resultSet.getString(2);

                         byte [] saltKey = hexStringToByteArray(passwordTwo);
                         String passwordReal = digest(passwordAdminChar, saltKey);
                         if (passwordReal.equals(passwordOne)) {
                             JOptionPane.showMessageDialog(null, "Password benar!", "Berhasil", JOptionPane.INFORMATION_MESSAGE, tpaAzkaAiniya.icon);                     
                             tpaAzkaAiniya.setPasswordAdminPassed(true);
                         } else {
                             JOptionPane.showMessageDialog(null, "Password salah!", "Salah", JOptionPane.INFORMATION_MESSAGE);
                         }
                     }
                     resultSet.close();

                    } catch (SQLException er) {
                        JOptionPane.showMessageDialog(null, "Error " + er, "Error", JOptionPane.ERROR_MESSAGE);
                    }       catch (NoSuchAlgorithmException ex) {
                                Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                }
        });
        final JCheckBox checkBoxShowPassword = new JCheckBox();
        checkBoxShowPassword.setText("Show Password"); 
        checkBoxShowPassword.setToolTipText("Show password");
        panel.add(label);
        panel.add(passwordAdmin);
        panel.add(checkBoxShowPassword);
        
        checkBoxShowPassword.addItemListener((ItemEvent e) -> {
            if (checkBoxShowPassword.isSelected()) {
                passwordAdmin.setEchoChar((char)0);
            } else {
                passwordAdmin.setEchoChar('*');
            }      
        });
        
        String [] options = new String [] {"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Verifikasi Password Admin", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        
        
        if (option == 0) //Pressing OK
        {
            char [] passwordAdminChar = passwordAdmin.getPassword();
            String usernameAdmin = "IndraSudirman";
            try {
             ConnectionDatabase connectionDatabase = new ConnectionDatabase();
             connectionDatabase.connect();
             connectionDatabase.statement = connectionDatabase.connection.createStatement();
             String sqlQuery = "SELECT `passwordOne`, `passwordTwo` FROM `users` WHERE username = ?";
             preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
             preparedStatement.setString(1, usernameAdmin);
             resultSet = preparedStatement.executeQuery();
             
             if (resultSet.next()) {
                 String passwordOne = resultSet.getString(1);
                 String passwordTwo = resultSet.getString(2);
                 
                 byte [] saltKey = hexStringToByteArray(passwordTwo);
                 String passwordReal = digest(passwordAdminChar, saltKey);
                 if (passwordReal.equals(passwordOne)) {
                     JOptionPane.showMessageDialog(null, "Password benar!", "Berhasil", JOptionPane.INFORMATION_MESSAGE, tpaAzkaAiniya.icon);                    
                     tpaAzkaAiniya.setPasswordAdminPassed(true);
                 } else {
                     JOptionPane.showMessageDialog(null, "Password salah!", "Salah", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
             resultSet.close();
             
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void login() throws NoSuchAlgorithmException {
        String usernameJTextField, usernameToDatabase;
        char [] password;
        usernameJTextField = jTextField1.getText();
        password = jPasswordField1.getPassword();
        
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT `username`, `passwordOne`, `passwordTwo` FROM `users` WHERE username = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, usernameJTextField);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                usernameToDatabase = resultSet.getString(1);
                passwordOneDB = resultSet.getString(2);
                passwordTwoDB = resultSet.getString(3);
                if (usernameJTextField.equals(usernameToDatabase)) {
                    byte [] salt = hexStringToByteArray(passwordTwoDB);
                    passwordUser = digest(password, salt);
                    if (passwordUser.equals(passwordOneDB)) {
                        JOptionPane.showMessageDialog(null, "Password benar!", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);                  
                        TPAAzkaAiniya laundry = new TPAAzkaAiniya();
                        laundry.setPasswordAdminPassed(true);
                    }else {
                        JOptionPane.showMessageDialog(null, "Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                        TPAAzkaAiniya laundry = new TPAAzkaAiniya();
                        laundry.setPasswordAdminPassed(false);
                    }
                
                } else {
                    JOptionPane.showMessageDialog(null, "Username salah!", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextField1.setText("");
                }   
                
            } else {
                JOptionPane.showMessageDialog(null, "Username salah!", "Error", JOptionPane.ERROR_MESSAGE);
                jTextField1.setText("");
            }
//            jTextField1.setText(""); 
            Arrays.fill(password, '0');
            System.out.println("Arrays Fill" + Arrays.toString(password));
            jPasswordField1.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void signUp() throws NoSuchAlgorithmException, NoSuchProviderException {
        String userNameSignUp;
        char [] passwordTwoSignUp;
        userNameSignUp = SignUp.jTextField1.getText();
        passwordTwoSignUp = SignUp.passwordUser;
        try {
            byte [] salt = getSalt();
            String passwordOne = byteArrayToHexString(salt);
            String passwordTwo = digest(passwordTwoSignUp, salt);
            connectionDatabase.connect();
            String sqlQuery = "INSERT INTO users (username, passwordOne, passwordTwo) VALUES (?, ?, ?)";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userNameSignUp);
            preparedStatement.setString(2, passwordTwo);
            preparedStatement.setString(3, passwordOne);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "User baru berhasil dibuat!", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
//            JOptionPane.showMessageDialog(null, "User baru berhasil dibuat!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }   
    
    public static boolean getPasswordAdminPassed() {
        return passwordAdminPassed;
    }
    public void setPasswordAdminPassed(boolean passwordAdminPassed) {
        TPAAzkaAiniya.passwordAdminPassed = passwordAdminPassed;
    }
    
    public void browseImage() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File (System.getProperty("user.home")));
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.IMAGE","jpg", "png");
                fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    Siswa.jLabel18.setIcon(resizeImageSave(path));
                    stringPath = path;
                    System.out.println("path file is " + path);
                    System.out.println("String path file is " + stringPath);
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No data");        
                }
                
                
    }
    
    
    public void browseImageUpdate() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File (System.getProperty("user.home")));
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.IMAGE","jpg", "png");
                fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    Siswa.jLabel45.setIcon(resizeImageSave(path));
                    stringPath = path;
                    System.out.println("path file is " + path);
                    System.out.println("String path file is " + stringPath);
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No data");        
                }
                
                
    }
    
    public ImageIcon resizeImage(String imgPath) {
        ImageIcon myImage = new ImageIcon(imgPath);
        
        int imageWidth = myImage.getIconWidth();
        int imageHeight = myImage.getIconHeight();
        
        int labelWidth = Siswa.jLabel18.getWidth();
        int labelHeight = Siswa.jLabel18.getHeight();
        
        Image img = myImage.getImage();
        ImageIcon image;// = myImage;
        
        
        
        
        if (imageWidth > labelWidth && imageHeight > labelHeight) {
            Image newImage = img.getScaledInstance(Siswa.jLabel18.getWidth(), Siswa.jLabel18.getHeight(), Image.SCALE_SMOOTH);
            image = new ImageIcon(newImage);
        }else {
            image = myImage;
        }
        
        
    return image;
    }
    
    public ImageIcon resizeImageSave(String imgPath) {
        ImageIcon myImage = new ImageIcon(imgPath);
        
        
        Image img = myImage.getImage();
        
        Image newImage = img.getScaledInstance(Siswa.jLabel18.getWidth(), Siswa.jLabel18.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        
        
        
    return image;
    }
    
    
    public ImageIcon createImageIcon(String path) {
        
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon (imgURL);
        } else {
            JOptionPane.showMessageDialog(null, "Error " + path + " tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        
    }

    public void saveInputSiswa() throws IOException {
        java.net.URL imgURL = getClass().getResource("../image/no_image_siswa.png");
        File defaultFotoSiswa = new File(imgURL.getPath());
        String pathFotoSiswa = defaultFotoSiswa.getAbsolutePath();
        System.out.println("No Image Siswa path is : " + pathFotoSiswa);
        
        String tsNoFoto = Siswa.jTextField2.getText();
        String nameNoFoto = defaultFotoSiswa.getName();
        String extNoFoto = nameNoFoto.substring(nameNoFoto.lastIndexOf("."));
        String outFileNameNoFoto = tsNoFoto + extNoFoto;
        File destinationDirNoFoto = new File ("foto-siswa", outFileNameNoFoto);
        String newPathNoFoto = destinationDirNoFoto.getAbsolutePath();
        System.out.println("new path file is " + newPathNoFoto);
        
        
        if (stringPath != null) {     
            File sourceImage = new File(stringPath); 
            String ts = Siswa.jTextField2.getText();
            String name = sourceImage.getName();
            String ext = name.substring(name.lastIndexOf("."));
            String outFileName = ts + ext;
            File destinationDir = new File ("foto-siswa", outFileName);
            String newPath = destinationDir.getAbsolutePath();
            System.out.println("new path file is " + newPath);
            
           
            FileUtils.copyFile(sourceImage, destinationDir);

            try {


                java.util.Date utilDate = (java.util.Date) Siswa.jDateChooser2.getDate(); //jDateChooser3
                java.sql.Date sqlDate = new java.sql.Date (utilDate.getTime());
                java.util.Date utilDate1 = (java.util.Date) Siswa.jDateChooser3.getDate(); //jDateChooser3
                java.sql.Date sqlDate1 = new java.sql.Date (utilDate1.getTime());
                String sqlQuery = ("insert into siswa (noInduk, namaLengkap, namaPanggilan, tempatLahir, tanggalLahir, tanggalMasukTPA, namaAyah, namaIbu, noTelpAyahIbu, noWaAyahIbu, alamatLengkap, fotoSiswa, user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                connectionDatabase.connect();
                preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, Siswa.jTextField1.getText() + " " + Siswa.jTextField5.getText());
                preparedStatement.setString(2, Siswa.jTextField2.getText());
                preparedStatement.setString(3, Siswa.jTextField4.getText());
                preparedStatement.setString(4, Siswa.jTextField3.getText());
                preparedStatement.setDate(5, sqlDate);
                preparedStatement.setDate(6, sqlDate1);
                preparedStatement.setString(7, Siswa.jTextField7.getText());
                preparedStatement.setString(8, Siswa.jTextField11.getText());
                preparedStatement.setString(9, Siswa.jTextField9.getText());
                preparedStatement.setString(10, Siswa.jTextField10.getText());
                preparedStatement.setString(11, Siswa.jTextArea1.getText());
                preparedStatement.setString(12, newPath);
                preparedStatement.setString(13, Siswa.jLabel1.getText());
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
//                JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
            }
            stringPath = null;
        } else {
            
            System.out.println("Null " + pathFotoSiswa);
            FileUtils.copyFile(defaultFotoSiswa, destinationDirNoFoto);
            
            try {


                java.util.Date utilDate = (java.util.Date) Siswa.jDateChooser2.getDate(); //jDateChooser3
                java.sql.Date sqlDate = new java.sql.Date (utilDate.getTime());
                java.util.Date utilDate1 = (java.util.Date) Siswa.jDateChooser3.getDate(); //jDateChooser3
                java.sql.Date sqlDate1 = new java.sql.Date (utilDate1.getTime());
                String sqlQuery = ("insert into siswa (noInduk, namaLengkap, namaPanggilan, tempatLahir, tanggalLahir, tanggalMasukTPA, namaAyah, namaIbu, noTelpAyahIbu, noWaAyahIbu, alamatLengkap, fotoSiswa, user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                connectionDatabase.connect();
                preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, Siswa.jTextField1.getText() + " " + Siswa.jTextField5.getText());
                preparedStatement.setString(2, Siswa.jTextField2.getText());
                preparedStatement.setString(3, Siswa.jTextField4.getText());
                preparedStatement.setString(4, Siswa.jTextField3.getText());
                preparedStatement.setDate(5, sqlDate);
                preparedStatement.setDate(6, sqlDate1);
                preparedStatement.setString(7, Siswa.jTextField7.getText());
                preparedStatement.setString(8, Siswa.jTextField11.getText());
                preparedStatement.setString(9, Siswa.jTextField9.getText());
                preparedStatement.setString(10, Siswa.jTextField10.getText());
                preparedStatement.setString(11, Siswa.jTextArea1.getText());
                preparedStatement.setString(12, pathFotoSiswa);
                preparedStatement.setString(13, Siswa.jLabel1.getText());
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
//                JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
            }
            
        }
                
        
        
    }

    public void cariNomorInduk() {
        String noIndukTerakhir;
        String noIndukPertama = "001";
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT noInduk FROM siswa ORDER BY noInduk DESC LIMIT 1";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                noIndukTerakhir = resultSet.getString(1);
                JLabel [] jLabel = {new JLabel("No Induk Terakhir adalah : "), new JLabel(noIndukTerakhir)};
                Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,16);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);
                
            } else {
                JLabel [] jLabel = {new JLabel("No Induk masih kosong, Anda bisa mulai dari : "), new JLabel(noIndukPertama)};
                Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,14);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void editSiswaTable() throws SQLException {
        connectionDatabase.connect();
        String sqlQuery = "SELECT `noInduk`, `namaLengkap` FROM `siswa`";
        preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
        resultSet = preparedStatement.executeQuery();
        
      JPanel panel = new JPanel();
        
      panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Tabel Siswa", TitledBorder.CENTER, TitledBorder.TOP));
      
      DefaultTableModel model = new DefaultTableModel(new String[]{"No Induk", "Nama Lengkap"}, 0);
      
      while(resultSet.next()){
        String d = resultSet.getString("noInduk");
        String e = resultSet.getString("namaLengkap");
        model.addRow(new Object[]{d, e});
        }
      
      table = new JTable(model) {
          
      @Override
      public String getToolTipText(MouseEvent e) {
      String tip;// = null;
      java.awt.Point p = e.getPoint();
      int rowIndex = rowAtPoint(p);
      int colIndex = columnAtPoint(p);
      realColumnIndex = convertColumnIndexToModel(colIndex);

      if (realColumnIndex == 1 ) { 
            tip = "Klik 2 kali atau Klik OK untuk edit siswa nama : "
                   + getValueAt(rowIndex, colIndex); 
            } else {
                tip = "Klik 2 kali atau Klik OK untuk edit siswa no induk : "
                       + getValueAt(rowIndex, colIndex);
            }
            return tip;
      };

      @Override
      public boolean isCellEditable(int row, int column) {                
                return false; 
                };        
      };
      
      for (int i = 0; i < 2; i++) {
          column = table.getColumnModel().getColumn(i);
          if ( i == 1) {
              column.setPreferredWidth(300);
          }else {
              column.setPreferredWidth(50);
          }
      }
      
      //Add listener double click
      table.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked (MouseEvent e) { 
              if (e.getClickCount() == 2) {     // detect double click events
               JTable target = (JTable)e.getSource();
               int row = target.getSelectedRow(); // select a row
               int column = target.getSelectedColumn(); // select a column
               
               TPAAzkaAiniya laundry = new TPAAzkaAiniya();
               
               if (column == 0) { //gw cuma ambil logic berdasarkan kolom
                   int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit siswa No Induk : " + table.getValueAt(row, column), "Konfirmasi edit siswa", JOptionPane.YES_NO_OPTION);
                   laundry.setNoInduk((String) table.getValueAt(row, column)); //table.getValueAt(row, column)
                   System.out.println(input + " "+TPAAzkaAiniya.getNoInduk());
                   try {
                       showDataSiswaByNoInduk();
                       Window win = SwingUtilities.getWindowAncestor(panel);
                       win.setVisible(false);
                   } catch (SQLException ex) {
                       Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } else {
                   int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit siswa Nama : " + table.getValueAt(row, column), "Konfirmasi edit siswa", JOptionPane.YES_NO_OPTION);
                   laundry.setNamaSiswa((String) table.getValueAt(row, column));
                   System.out.println(input + " "+TPAAzkaAiniya.getNamaSiswa());
                   try {
                       showDataSiswaByNama();
                       Window win = SwingUtilities.getWindowAncestor(panel);
                       win.setVisible(false); 
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
                              
            }
          }
      });
            
      ((JLabel) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      
      DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer() {
          
          @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
      };
      table.getColumnModel().getColumn(0).setCellRenderer(centerRender);
      table.getColumnModel().getColumn(1).setCellRenderer(centerRender);
      
      panel.add(new JScrollPane(table));
      String [] options = new String [] {"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Pilih Siswa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        
        for (int i = 0; i < 2; i++) {
        column = table.getColumnModel().getColumn(i);
        if (option == 0) {
            System.out.println("OK");
            TPAAzkaAiniya laundry = new TPAAzkaAiniya();            
            if ( i == 1) {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    laundry.setNamaSiswa((String) table.getValueAt(row, column1));
                    try{
                        showDataSiswaByNama();
//                        Window win = SwingUtilities.getWindowAncestor(panel);
//                        win.setVisible(false); 

                       } catch (SQLException ex) {
                           Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                       }

                }else {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    laundry.setNoInduk((String) table.getValueAt(row, column1));
                    try{

                        showDataSiswaByNoInduk();
//                        Window win = SwingUtilities.getWindowAncestor(panel);
//                        win.setVisible(false); 

                       } catch (SQLException ex) {
                           Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
            
            }
        
        }
    }

    private void showDataSiswaByNama() throws SQLException {
        String namaSiswaTabel, noIndukDB;
        namaSiswaTabel = TPAAzkaAiniya.getNamaSiswa();
        System.out.println("Nama siswa di show Data " + namaSiswaTabel );
        try {
            connectionDatabase.connect(); //SELECT * FROM `siswa` WHERE namaLengkap = 'Nuryati'
            String sqlQuery = "SELECT * FROM siswa WHERE namaLengkap = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, namaSiswaTabel);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                
                noIndukDB = resultSet.getString(1);
                String [] noIndukDBArray = noIndukDB.split(" ");
                System.out.println("Kode tahun " + noIndukDBArray[0]);
                System.out.println("No Urut Induk " + noIndukDBArray[1]);
                Siswa.jTextField12.setText(noIndukDBArray[0]);
                Siswa.jTextField6.setText(noIndukDBArray[1]); 
                Siswa.jTextField15.setText(resultSet.getString(2)); 
                Siswa.jTextField8.setText(resultSet.getString(3)); 
                Siswa.jTextField14.setText(resultSet.getString(4));
                Date birthDateStudent = resultSet.getDate("tanggalLahir");
                Siswa.jDateChooser5.setDate(birthDateStudent);
                Date joinDateStudent = resultSet.getDate("tanggalMasukTPA");
                Siswa.jDateChooser4.setDate(joinDateStudent);
                Siswa.jTextField16.setText(resultSet.getString(7));
                Siswa.jTextField13.setText(resultSet.getString(8));
                Siswa.jTextField18.setText(resultSet.getString(9));
                Siswa.jTextField17.setText(resultSet.getString(10));
                Siswa.jTextArea2.setText(resultSet.getString(11)); 
                String imagePath = resultSet.getString(12);
                Siswa.jLabel45.setIcon(resizeImage(imagePath));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
            }
        
    }
    
    private void showDataSiswaByNoInduk() throws SQLException {
        String noIndukSiswaTabel, noIndukDB;
        noIndukSiswaTabel = TPAAzkaAiniya.getNoInduk();
        System.out.println("Nama siswa di show Data " + noIndukSiswaTabel );
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT * FROM siswa WHERE noInduk = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, noIndukSiswaTabel);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                noIndukDB = resultSet.getString(1);
                String [] noIndukDBArray = noIndukDB.split(" ");
                System.out.println("Kode tahun " + noIndukDBArray[0]);
                System.out.println("No Urut Induk " + noIndukDBArray[1]);
                Siswa.jTextField12.setText(noIndukDBArray[0]);
                Siswa.jTextField6.setText(noIndukDBArray[1]);
                Siswa.jTextField15.setText(resultSet.getString(2)); 
                Siswa.jTextField8.setText(resultSet.getString(3)); 
                Siswa.jTextField14.setText(resultSet.getString(4));
                Date birthDateStudent = resultSet.getDate("tanggalLahir");
                Siswa.jDateChooser5.setDate(birthDateStudent);
                Date joinDateStudent = resultSet.getDate("tanggalMasukTPA");
                Siswa.jDateChooser4.setDate(joinDateStudent);
                Siswa.jTextField16.setText(resultSet.getString(7));
                Siswa.jTextField13.setText(resultSet.getString(8));
                Siswa.jTextField18.setText(resultSet.getString(9));
                Siswa.jTextField17.setText(resultSet.getString(10));
                Siswa.jTextArea2.setText(resultSet.getString(11)); 
                String imagePath = resultSet.getString(12);
                Siswa.jLabel45.setIcon(resizeImage(imagePath));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
            }
        
    }

    public void deleteSiswa() {
        ImageIcon icon = new ImageIcon ("src/tpaazkaainiya/image/success_icon.png");
        String noIndukToDelete;
        String siswaToDelete;
        String userDelete;
        Date date = new Date();
//        java.sql.Date sqlDate = new java.sql.Date (date.getTime());
//        System.out.println("Date " + sqlDate);
        
        userDelete = Siswa.jLabel1.getText();
        noIndukToDelete = Siswa.jTextField12.getText() + " " + Siswa.jTextField6.getText();
        siswaToDelete = Siswa.jTextField15.getText();
        System.out.println("No Induk Siswa to Delete is : " + noIndukToDelete);
        
        JLabel [] jLabel = {new JLabel("Yakin ingin hapus siswa : "), new JLabel("No Induk : "+noIndukToDelete), new JLabel("Nama : "+siswaToDelete)};
        Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,12);
        jLabel[1].setFont(fontNoIndukSiswa);
        jLabel[2].setFont(fontNoIndukSiswa);
        int input = JOptionPane.showConfirmDialog(null, jLabel, "Konfirmasi hapus siswa", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            
            try {
            connectionDatabase.connect();
            String siswaTerhapus = "INSERT INTO siswa_terhapus SELECT * FROM siswa WHERE noInduk = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(siswaTerhapus);
            preparedStatement.setString(1, noIndukToDelete); 
            preparedStatement.execute(); 
            String userDeleteQuery = "UPDATE siswa_terhapus SET userMadeDelete = ?, tanggalDelete = ? WHERE noInduk = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(userDeleteQuery);
            preparedStatement.setString(1, userDelete);
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
            preparedStatement.setString(3, noIndukToDelete);
            preparedStatement.execute();
            String sqlQuery = "DELETE FROM siswa WHERE noInduk = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, noIndukToDelete);
            preparedStatement.execute();
            
            
            JLabel [] jLabel1 = {new JLabel("Berhasil dihapus"), new JLabel("No Induk : "+noIndukToDelete), new JLabel("Nama : "+siswaToDelete)};
            Font fontNoIndukSiswa1 = new Font ("Ubuntu", Font.BOLD,12);
            
            jLabel1[1].setFont(fontNoIndukSiswa1);
            jLabel1[2].setFont(fontNoIndukSiswa1);
            JOptionPane.showMessageDialog(null, jLabel1, "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            
            clearDataEditSiswa();
            
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        }   

    private void clearDataEditSiswa() {
        TPAAzkaAiniya laundry = new TPAAzkaAiniya();
        
        if (Siswa.jTextField12.getText().isEmpty() && Siswa.jTextField6.getText().isEmpty() && Siswa.jTextField15.getText().isEmpty() && Siswa.jTextField8.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data sudah kosong");
        } else {
            ImageIcon defaultImageIconPhotoStudent = laundry.createImageIcon("../image/no_image_siswa.png");

            Siswa.jTextField12.setText("");
            Siswa.jTextField6.setText("");
            Siswa.jTextField15.setText("");
            Siswa.jTextField8.setText("");
            Siswa.jTextField14.setText("");
            Siswa.jDateChooser5.setDate(new Date());
            Siswa.jDateChooser4.setDate(new Date());
            Siswa.jTextField16.setText("");
            Siswa.jTextField13.setText("");
            Siswa.jTextField18.setText("");
            Siswa.jTextField17.setText("");
            Siswa.jTextArea2.setText("");
            Siswa.jLabel45.setIcon(defaultImageIconPhotoStudent);
        }
        
    }
    
    
    public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){
        
        
		
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();	
	g.setComposite(AlphaComposite.Src);

	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING,
	RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
	
	return resizedImage;
    }

    public void updateSiswa() throws IOException {
        
//        ImageIcon icon = new ImageIcon ("src/tpaazkaainiya/image/success_icon.png");
        String noIndukToUpdate;
        String siswaToUpdate;
        String userUpdate;
        Date date = new Date();
//        java.sql.Date sqlDate = new java.sql.Date (date.getTime());
//        System.out.println("Date " + sqlDate);
        
        userUpdate = Siswa.jLabel1.getText();
        noIndukToUpdate = Siswa.jTextField12.getText() + " " + Siswa.jTextField6.getText();
        siswaToUpdate = Siswa.jTextField15.getText();
        System.out.println("No Induk Siswa to Update is : " + noIndukToUpdate);
        java.util.Date dateLahir = (java.util.Date) Siswa.jDateChooser5.getDate(); 
        java.sql.Date sqlDateLahir = new java.sql.Date (dateLahir.getTime());
        java.util.Date dateJoin = (java.util.Date) Siswa.jDateChooser4.getDate(); 
        java.sql.Date sqlDateJoin = new java.sql.Date (dateJoin.getTime());
        
        
        JLabel [] jLabel = {new JLabel("Yakin ingin update siswa : "), new JLabel("No Induk : "+noIndukToUpdate), new JLabel("Nama : "+siswaToUpdate)};
        Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,12);
        jLabel[1].setFont(fontNoIndukSiswa);
        jLabel[2].setFont(fontNoIndukSiswa);
        int input = JOptionPane.showConfirmDialog(null, jLabel, "Konfirmasi update siswa", JOptionPane.YES_NO_OPTION);
        
        if (input == 0) {
            if (stringPath != null) {
                
                File sourceImage = new File(stringPath); 
                String ts = Siswa.jTextField15.getText();
                String name = sourceImage.getName();
                String ext = name.substring(name.lastIndexOf("."));
                String outFileName = ts + ext;
                File destinationDir = new File ("foto-siswa", outFileName);
                String newPath = destinationDir.getAbsolutePath();
                System.out.println("new path file is " + newPath);


                FileUtils.copyFile(sourceImage, destinationDir);
                
            
                try {
                    
                    connectionDatabase.connect();
                    String userUpdateQuery = "UPDATE siswa SET namaLengkap = ?, namaPanggilan = ?, tempatLahir = ?, tanggalLahir = ?, tanggalMasukTPA = ?, namaAyah = ?, namaIbu = ?, noTelpAyahIbu = ?, noWaAyahIbu = ?, alamatLengkap = ?, fotoSiswa = ?, userMadeEdit = ?, tanggalDiedit = ? WHERE noInduk = ?";
                    preparedStatement = connectionDatabase.connection.prepareStatement(userUpdateQuery);
                    preparedStatement.setString(1, Siswa.jTextField15.getText());
                    preparedStatement.setString(2, Siswa.jTextField8.getText());
                    preparedStatement.setString(3, Siswa.jTextField14.getText());
                    preparedStatement.setDate(4, sqlDateLahir);
                    preparedStatement.setDate(5, sqlDateJoin);
                    preparedStatement.setString(6, Siswa.jTextField16.getText());
                    preparedStatement.setString(7, Siswa.jTextField13.getText());
                    preparedStatement.setString(8, Siswa.jTextField18.getText());
                    preparedStatement.setString(9, Siswa.jTextField17.getText());
                    preparedStatement.setString(10, Siswa.jTextArea2.getText());
                    preparedStatement.setString(11, newPath);
                    preparedStatement.setString(12, userUpdate);
                    preparedStatement.setTimestamp(13, new java.sql.Timestamp(date.getTime()));

//                    preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    preparedStatement.setString(14, noIndukToUpdate);
                    preparedStatement.execute();


                    JLabel [] jLabel1 = {new JLabel("Berhasil dihapus"), new JLabel("No Induk : "+noIndukToUpdate), new JLabel("Nama : "+siswaToUpdate)};
                    Font fontNoIndukSiswa1 = new Font ("Ubuntu", Font.BOLD,12);

                    jLabel1[1].setFont(fontNoIndukSiswa1);
                    jLabel1[2].setFont(fontNoIndukSiswa1);
                    JOptionPane.showMessageDialog(null, jLabel1, "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);

                    clearDataEditSiswa();

                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else { //Foto tidak diganti
                System.out.println("String path " + stringPath);
                
                try {
                    
                    connectionDatabase.connect();
                    String userUpdateQuery = "UPDATE siswa SET namaLengkap = ?, namaPanggilan = ?, tempatLahir = ?, tanggalLahir = ?, tanggalMasukTPA = ?, namaAyah = ?, namaIbu = ?, noTelpAyahIbu = ?, noWaAyahIbu = ?, alamatLengkap = ?, userMadeEdit = ?, tanggalDiedit = ? WHERE noInduk = ?";
                    preparedStatement = connectionDatabase.connection.prepareStatement(userUpdateQuery);
                    preparedStatement.setString(1, Siswa.jTextField15.getText());
                    preparedStatement.setString(2, Siswa.jTextField8.getText());
                    preparedStatement.setString(3, Siswa.jTextField14.getText());
                    preparedStatement.setDate(4, sqlDateLahir);
                    preparedStatement.setDate(5, sqlDateJoin);
                    preparedStatement.setString(6, Siswa.jTextField16.getText());
                    preparedStatement.setString(7, Siswa.jTextField13.getText());
                    preparedStatement.setString(8, Siswa.jTextField18.getText());
                    preparedStatement.setString(9, Siswa.jTextField17.getText());
                    preparedStatement.setString(10, Siswa.jTextArea2.getText());
                    preparedStatement.setString(11, userUpdate);
                    preparedStatement.setTimestamp(12, new java.sql.Timestamp(date.getTime()));
//                    preparedStatement.setString(11, newPath);

//                    preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    preparedStatement.setString(13, noIndukToUpdate);
                    preparedStatement.execute();


                    JLabel [] jLabel1 = {new JLabel("Berhasil diupdate"), new JLabel("No Induk : "+noIndukToUpdate), new JLabel("Nama : "+siswaToUpdate)};
                    Font fontNoIndukSiswa1 = new Font ("Ubuntu", Font.BOLD,12);

                    jLabel1[1].setFont(fontNoIndukSiswa1);
                    jLabel1[2].setFont(fontNoIndukSiswa1);
                    JOptionPane.showMessageDialog(null, jLabel1, "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);

                    clearDataEditSiswa();

                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    }

    public void savePembelajaran() {
        try {
            
            String sqlQuery = ("insert into pembelajaran (kodePembelajaran, namaPembelajaran, biayaPembelajaran, deskripsiPembelajaran, user) values (?, ?, ?, ?, ?)");
            connectionDatabase.connect();
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, Pembelajaran.jComboBox1.getSelectedItem().toString() + " " + Pembelajaran.jTextField13.getText());
            preparedStatement.setString(2, Pembelajaran.jTextField14.getText());
            preparedStatement.setObject(3, Pembelajaran.jFormattedTextField1.getValue());
            preparedStatement.setString(4, Pembelajaran.jTextArea1.getText());
            preparedStatement.setString(5, Pembelajaran.jLabel1.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            TPAAzkaAiniya.setIfTrueForCheck(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void cariKodePembelajaran() {
        
        String kodePembelajaranTerakhir;
        String kodePembelajaranPertama = "001";
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT kodePembelajaran FROM pembelajaran ORDER BY kodePembelajaran DESC LIMIT 1";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                kodePembelajaranTerakhir = resultSet.getString(1);
                JLabel [] jLabel = {new JLabel("Kode Pembelajaran Terakhir adalah : "), new JLabel(kodePembelajaranTerakhir)};
                Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,16);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);
                
            } else {
                JLabel [] jLabel = {new JLabel("Kode Pembelajaran masih kosong, Anda bisa mulai dari : "), new JLabel(kodePembelajaranPertama)};
                Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,14);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void editPembelajaranTable() throws SQLException {
        connectionDatabase.connect();
        String sqlQuery = "SELECT `kodePembelajaran`, `namaPembelajaran` FROM `pembelajaran`";
        preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
        resultSet = preparedStatement.executeQuery();
        
      JPanel panel = new JPanel();
        
      panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Tabel Pembelajaran", TitledBorder.CENTER, TitledBorder.TOP));
      
      DefaultTableModel model = new DefaultTableModel(new String[]{"Kode Pembelajaran", "Nama Pembelajaran"}, 0);
      
      while(resultSet.next()){
        String d = resultSet.getString("kodePembelajaran");
        String e = resultSet.getString("namaPembelajaran");
        model.addRow(new Object[]{d, e});
        }
      
      table = new JTable(model) {
          
      @Override
      public String getToolTipText(MouseEvent e) {
      String tip;// = null;
      java.awt.Point p = e.getPoint();
      int rowIndex = rowAtPoint(p);
      int colIndex = columnAtPoint(p);
      realColumnIndex = convertColumnIndexToModel(colIndex);

      if (realColumnIndex == 1 ) { 
            tip = "Klik 2 kali atau Klik OK untuk edit Nama Pembelajaran : "
                   + getValueAt(rowIndex, colIndex); 
            } else {
                tip = "Klik 2 kali atau Klik OK untuk edit Kode Pembelajaran : "
                       + getValueAt(rowIndex, colIndex);
            }
            return tip;
      };

      @Override
      public boolean isCellEditable(int row, int column) {                
                return false; 
                };        
      };
      
      
      for (int i = 0; i < 2; i++) {
          column = table.getColumnModel().getColumn(i);
          if ( i == 1) {
              column.setPreferredWidth(220);
          }else {
              column.setPreferredWidth(130);
          }
      }
      
      //Add listener double click
      table.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked (MouseEvent e) { 
              if (e.getClickCount() == 2) {     // detect double click events
               JTable target = (JTable)e.getSource();
               int row = target.getSelectedRow(); // select a row
               int column = target.getSelectedColumn(); // select a column
               
               TPAAzkaAiniya laundry = new TPAAzkaAiniya();
               
               if (column == 0) { //gw cuma ambil logic berdasarkan kolom
                   int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit Kode Pembelajaran " + table.getValueAt(row, column)+"?", "Konfirmasi edit pembelajaran", JOptionPane.YES_NO_OPTION);
                   TPAAzkaAiniya.setKodePembelajaran((String) table.getValueAt(row, column)); //table.getValueAt(row, column)
                   System.out.println(input + " "+TPAAzkaAiniya.getKodePembelajaran());
                   try {
                       showDataPembelajaranByKodePembelajaran();
                       Window win = SwingUtilities.getWindowAncestor(panel);
                       win.setVisible(false);
                   } catch (SQLException ex) {
                       Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } else {
                   int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit Nama Pembelajaran " + table.getValueAt(row, column)+ "?", "Konfirmasi edit pembelajaran", JOptionPane.YES_NO_OPTION);
                   TPAAzkaAiniya.setNamaPembelajaran((String) table.getValueAt(row, column));
                   System.out.println(input + " "+TPAAzkaAiniya.getNamaPembelajaran());
                   try {
                       showDataPembelajaranByNama();
                       Window win = SwingUtilities.getWindowAncestor(panel);
                       win.setVisible(false); 
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
                              
            }
          }
      });
            
      ((JLabel) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      
      DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer() {
          
          @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
      };
      table.getColumnModel().getColumn(0).setCellRenderer(centerRender);
      table.getColumnModel().getColumn(1).setCellRenderer(centerRender);
      
      panel.add(new JScrollPane(table));
      String [] options = new String [] {"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Pilih Pembelajaran", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        
        for (int i = 0; i < 2; i++) {
        column = table.getColumnModel().getColumn(i);
        if (option == 0) {
            System.out.println("OK");          
            if ( i == 1) {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    TPAAzkaAiniya.setNamaPembelajaran((String) table.getValueAt(row, column1));
                    try{
                        showDataPembelajaranByNama();
//                        Window win = SwingUtilities.getWindowAncestor(panel);
//                        win.setVisible(false); 

                       } catch (SQLException ex) {
                           Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                       }

                }else {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    TPAAzkaAiniya.setKodePembelajaran((String) table.getValueAt(row, column1));
                    try{

                        showDataPembelajaranByKodePembelajaran();
//                        Window win = SwingUtilities.getWindowAncestor(panel);
//                        win.setVisible(false); 

                       } catch (SQLException ex) {
                           Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
            
            }
        
        }
      
      
    }
    
    private void showDataPembelajaranByNama() throws SQLException {
        
        String namaPembelajaranTabel, kodePembelajaranDB;
        namaPembelajaranTabel = TPAAzkaAiniya.getNamaPembelajaran();
        System.out.println("Nama siswa di show Data " + namaPembelajaranTabel );
        try {
            connectionDatabase.connect(); //SELECT * FROM `siswa` WHERE namaLengkap = 'Nuryati'
            String sqlQuery = "SELECT * FROM pembelajaran WHERE namaPembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, namaPembelajaranTabel);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                
                kodePembelajaranDB = resultSet.getString(1);
                String [] kodePembelajaranDBArray = kodePembelajaranDB.split(" ");
                System.out.println("Kode Pembelajaran " + kodePembelajaranDBArray[0]);
                System.out.println("No Urut Pembelajaran " + kodePembelajaranDBArray[1]);
                Pembelajaran.jComboBox2.setSelectedItem(kodePembelajaranDBArray[0]);
                Pembelajaran.jTextField17.setText(kodePembelajaranDBArray[1]); 
                Pembelajaran.jTextField18.setText(resultSet.getString(2)); 
                String biayaPembelajaran = resultSet.getString(3);
                String tampilRupiah =numberFormat.format(new BigDecimal(biayaPembelajaran));
                Pembelajaran.jFormattedTextField2.setText(tampilRupiah); 
                Pembelajaran.jTextArea2.setText(resultSet.getString(4));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
            }
        
    }
    
    
    private void showDataPembelajaranByKodePembelajaran() throws SQLException {
        
        
        String kodePembelajaranTabel, kodePembelajaranDB;
        kodePembelajaranTabel = TPAAzkaAiniya.getKodePembelajaran();
        System.out.println("Nama siswa di show Data " + kodePembelajaranTabel );
        try {
            connectionDatabase.connect(); //SELECT * FROM `siswa` WHERE namaLengkap = 'Nuryati'
            String sqlQuery = "SELECT * FROM pembelajaran WHERE kodePembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, kodePembelajaranTabel);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                
                kodePembelajaranDB = resultSet.getString(1);
                String [] kodePembelajaranDBArray = kodePembelajaranDB.split(" ");
                System.out.println("Kode Pembelajaran " + kodePembelajaranDBArray[0]);
                System.out.println("No Urut Pembelajaran " + kodePembelajaranDBArray[1]);
                Pembelajaran.jComboBox2.setSelectedItem(kodePembelajaranDBArray[0]);
                Pembelajaran.jTextField17.setText(kodePembelajaranDBArray[1]); 
                Pembelajaran.jTextField18.setText(resultSet.getString(2)); 
                String biayaPembelajaran = resultSet.getString(3);
                String tampilRupiah =numberFormat.format(new BigDecimal(biayaPembelajaran));
                Pembelajaran.jFormattedTextField2.setText(tampilRupiah); 
                Pembelajaran.jTextArea2.setText(resultSet.getString(4));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);            
            }
        
    }

    public void deletePembelajaran() {
        ImageIcon icon = new ImageIcon ("src/tpaazkaainiya/image/success_icon.png");
        String kodePembelajaranToDelete;
        String pembelajaranToDelete;
        String userDelete;
        Date date = new Date();
//        java.sql.Date sqlDate = new java.sql.Date (date.getTime());
//        System.out.println("Date " + sqlDate);
        
        userDelete = Pembelajaran.jLabel1.getText();
        kodePembelajaranToDelete = Pembelajaran.jComboBox2.getSelectedItem().toString() + " " + Pembelajaran.jTextField17.getText();
        pembelajaranToDelete = Pembelajaran.jTextField18.getText();
        System.out.println("Kode Pembelajaran to Delete is : " + kodePembelajaranToDelete);
        
        JLabel [] jLabel = {new JLabel("Yakin ingin hapus Pembelajaran : "), new JLabel("Kode Pembelajaran : "+kodePembelajaranToDelete), new JLabel("Nama : "+pembelajaranToDelete)};
        Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,12);
        jLabel[1].setFont(fontNoIndukSiswa);
        jLabel[2].setFont(fontNoIndukSiswa);
        int input = JOptionPane.showConfirmDialog(null, jLabel, "Konfirmasi hapus pembelajaran", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            
            try {
            connectionDatabase.connect();
            String siswaTerhapus = "INSERT INTO pembelajaran_terhapus SELECT * FROM pembelajaran WHERE kodePembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(siswaTerhapus);
            preparedStatement.setString(1, kodePembelajaranToDelete); 
            preparedStatement.execute(); 
            String userDeleteQuery = "UPDATE pembelajaran_terhapus SET userMadeDelete = ?, tanggalDelete = ? WHERE kodePembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(userDeleteQuery);
            preparedStatement.setString(1, userDelete);
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
            preparedStatement.setString(3, kodePembelajaranToDelete);
            preparedStatement.execute();
            String sqlQuery = "DELETE FROM pembelajaran WHERE kodePembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, kodePembelajaranToDelete);
            preparedStatement.execute();
            
            
            JLabel [] jLabel1 = {new JLabel("Berhasil dihapus"), new JLabel("No Induk : "+kodePembelajaranToDelete), new JLabel("Nama : "+pembelajaranToDelete)};
            Font fontNoIndukSiswa1 = new Font ("Ubuntu", Font.BOLD,12);
            
            jLabel1[1].setFont(fontNoIndukSiswa1);
            jLabel1[2].setFont(fontNoIndukSiswa1);
            JOptionPane.showMessageDialog(null, jLabel1, "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            TPAAzkaAiniya.setIfTrueForCheck(true); 
            
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    public void updatePembelajaran () {
        Date date = new Date();
        String kodePembelajaranToUpdate = Pembelajaran.jComboBox2.getSelectedItem().toString() + " " + Pembelajaran.jTextField17.getText();
        try {
            
            String sqlQuery = "UPDATE pembelajaran SET namaPembelajaran = ?, biayaPembelajaran = ?, deskripsiPembelajaran = ?, userMadeEdit = ?, tanggalDiedit = ? WHERE kodePembelajaran = ?";
            connectionDatabase.connect();
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, Pembelajaran.jTextField18.getText());
            preparedStatement.setObject(2, Pembelajaran.jFormattedTextField2.getValue());
            preparedStatement.setObject(3, Pembelajaran.jTextArea2.getText());
            preparedStatement.setString(4, Pembelajaran.jLabel1.getText());
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(date.getTime()));
            preparedStatement.setString(6, kodePembelajaranToUpdate);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            TPAAzkaAiniya.setIfTrueForCheck(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void kodePembelajaran() {
        String kodePembelajaranDB;
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT kodePembelajaran FROM `pembelajaran`";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            
            
            while (resultSet.next()) {
                kodePembelajaranDB = resultSet.getString("kodePembelajaran");
                Pembelajaran.jComboBox3.addItem(kodePembelajaranDB); 
            }
            Pembelajaran.jComboBox3.addItemListener((ItemEvent e) -> {
                
                String pembelajaranKode1 = (String) Pembelajaran.jComboBox3.getSelectedItem();
                TPAAzkaAiniya.setPembelajaranKode(pembelajaranKode1); 
                jTextFieldFromComboBox();
                Pembelajaran.jTextField20.setText(TPAAzkaAiniya.getPembelajaranNama());
                String tampilRupiah =numberFormat.format(new BigDecimal(TPAAzkaAiniya.getPembelajaranBiaya()));
                Pembelajaran.jFormattedTextField3.setText(tampilRupiah);
            });
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void jTextFieldFromComboBox() {
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT namaPembelajaran, biayaPembelajaran FROM `pembelajaran` WHERE kodePembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, TPAAzkaAiniya.getPembelajaranKode());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TPAAzkaAiniya.setPembelajaranNama(resultSet.getString("namaPembelajaran"));
                TPAAzkaAiniya.setPembelajaranBiaya(resultSet.getString("biayaPembelajaran"));
                
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void comboBoxNamaSiswa() {
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT noInduk FROM `siswa`";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            while (resultSet.next()) {
                
                String noIndukSiswaCombo = resultSet.getString("noInduk");
                comboBoxModel.addElement(noIndukSiswaCombo);
                Pembelajaran.jComboBox4.setModel(comboBoxModel);
            }
            
            Pembelajaran.jComboBox4.addItemListener((ItemEvent e) ->{
                
                String noIndukSiswaCombo1 = (String) Pembelajaran.jComboBox4.getSelectedItem();
                TPAAzkaAiniya.setNoIndukSiswaFromCombo(noIndukSiswaCombo1);
                namaSiswaFromCombo();
                Pembelajaran.jTextField21.setText(TPAAzkaAiniya.getNamaSiswaFromCombo()); 
                
            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void namaSiswaFromCombo() {
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT namaLengkap FROM `siswa` WHERE noInduk = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, TPAAzkaAiniya.getNoIndukSiswaFromCombo());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TPAAzkaAiniya.setNamaSiswaFromCombo(resultSet.getString("namaLengkap")); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void savePembelajaranSiswa() {
        try {
            
            String sqlQuery = ("INSERT INTO pembelajaran_siswa (noPembelajaranSiswa, noInduk, namaLengkap, kodePembelajaran, namaPembelajaran, biayaPembelajaran, userMadePembelajaranSiswa) values (?, ?, ?, ?, ?, ?, ?)");
            connectionDatabase.connect();
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, Pembelajaran.jComboBox5.getSelectedItem().toString() + " " + Pembelajaran.jTextField22.getText());
            preparedStatement.setString(2, Pembelajaran.jComboBox4.getSelectedItem().toString());
            preparedStatement.setString(3, Pembelajaran.jTextField21.getText());
            preparedStatement.setString(4, Pembelajaran.jComboBox3.getSelectedItem().toString());
            preparedStatement.setString(5, Pembelajaran.jTextField20.getText());
            preparedStatement.setObject(6, TPAAzkaAiniya.getPembelajaranBiaya());
            preparedStatement.setString(7, Pembelajaran.jLabel1.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            TPAAzkaAiniya.setIfTrueForCheck(true); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public void cariNoPembelajaranSiswa () {
        String noPembelajaranSiswaTerakhir;
        String noPembelajaranSiswaPertama = "001";
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT noPembelajaranSiswa FROM pembelajaran_siswa ORDER BY noPembelajaranSiswa DESC LIMIT 1";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                noPembelajaranSiswaTerakhir = resultSet.getString(1);
                JLabel [] jLabel = {new JLabel("No Pembelajaran Siswa Terakhir adalah : "), new JLabel(noPembelajaranSiswaTerakhir)};
                Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,16);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);
                
            } else {
                JLabel [] jLabel = {new JLabel("No Pembelajaran Siswa masih kosong, Anda bisa mulai dari : "), new JLabel(noPembelajaranSiswaPertama)};
                Font fontNoIndukSiswa = new Font ("Ubuntu", Font.BOLD,14);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    public void kodePembelajaranTesting() throws SQLException {
        String kodePembelajaranDB;
        
        connectionDatabase.connect();
        String sqlQuery = "SELECT kodePembelajaran FROM `pembelajaran`";
        preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
        resultSet = preparedStatement.executeQuery();
        
          DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
//        Pembelajaran.jComboBox3.setSelectedIndex(-1);
        
        
        while (resultSet.next()) {
                kodePembelajaranDB = resultSet.getString("kodePembelajaran");
                comboBoxModel.addElement(kodePembelajaranDB); 
                Pembelajaran.jComboBox3.setModel(comboBoxModel);
                
                
            }
        
//        Pembelajaran.jComboBox3.setRenderer(new MyComboBoxRender("Pilih Kode Pembelajaran"));
         
        
        Pembelajaran.jComboBox3.addItemListener((ItemEvent e) -> {
            String pembelajaranKode1 = (String) Pembelajaran.jComboBox3.getSelectedItem();
            TPAAzkaAiniya.setPembelajaranKode(pembelajaranKode1); 
            jTextFieldFromComboBox();
            Pembelajaran.jTextField20.setText(TPAAzkaAiniya.getPembelajaranNama());
            String tampilRupiah =numberFormat.format(new BigDecimal(TPAAzkaAiniya.getPembelajaranBiaya()));
            Pembelajaran.jFormattedTextField3.setText(tampilRupiah);
            });
    }

    private static class MyComboBoxRender extends JLabel implements ListCellRenderer
    {
        private String _title;

        public MyComboBoxRender(String title)
        {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(_title);
            else setText(value.toString());
            return this;
        }

        
    }
    

}


























