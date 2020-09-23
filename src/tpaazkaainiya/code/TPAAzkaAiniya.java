/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya.code;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.FileUtils;
import tpaazkaainiya.Laporan;
import tpaazkaainiya.Login;
import tpaazkaainiya.Pembelajaran;
import tpaazkaainiya.SPP;
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

    private static String namaPembelajaran, kodePembelajaran, kodePembelajaranSiswa, namaPembelajaranSiswa;

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

    public static String getKodePembelajaranSiswa() {
        return kodePembelajaranSiswa;
    }

    public static void setKodePembelajaranSiswa(String kodePembelajaranSiswa) {
        TPAAzkaAiniya.kodePembelajaranSiswa = kodePembelajaranSiswa;
    }

    public static String getNamaPembelajaranSiswa() {
        return namaPembelajaranSiswa;
    }

    public static void setNamaPembelajaranSiswa(String namaPembelajaranSiswa) {
        TPAAzkaAiniya.namaPembelajaranSiswa = namaPembelajaranSiswa;
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

    double amoun;
    double amount;
    
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

    ImageIcon icon = new ImageIcon("src/tpaazkaainiya/image/success_icon.png");
    ImageIcon alhamdulillahIcon = new ImageIcon("src/tpaazkaainiya/image/alhamdulillah_icon.png");
    ImageIcon afwanIcon = new ImageIcon("src/tpaazkaainiya/image/afwan_icon.png");

    Font fontBold = new Font("Ubuntu", Font.BOLD, 13);
    Font fontPlain = new Font("Ubuntu", Font.PLAIN, 12);
    
    public static final int IMG_WIDTH = 354;
    public static final int IMG_HEIGHT = 472;

    String[] nomor = new String[]{"Aspek Penilaian 1",
        "Aspek Penilaian 2",
        "Aspek Penilaian 3",
        "Aspek Penilaian 4",
        "Aspek Penilaian 5",
        "Aspek Penilaian 6",
        "Aspek Penilaian 7",
        "Aspek Penilaian 8"};
    Border loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    String[] aspekPenilaian = new String[]{"<html><b>Hafal huruf</b></html>",
        "<html><b>Makhraj</b></html>",
        "<html><b>Kelancaran membaca</b></html>",
        "<html><b>Hafal huruf yang disambung</b></html>",
        "<html><b>Menguasai bacaan kasron, kasroh panjang, dhommah dan dhommah panjang</b></html>",
        "<html><b>Menguasai bacaan tanwin, huruf berharokat sukun dan qolqolah</b></html>",
        "<html><b>Menguasai bacaan alif-lam qomariah, waqof, mad far’i, nun sukun/tanwin,<br> idzghom bighunah dan idzghom bilaghunah</b></html>",
        "<html><b>Menguasai persoalan-persoalan Tajwid</b></html>"};

    Font font = new Font("Helvetica-Normal", Font.PLAIN, 11);

    JLabel nilai1 = new JLabel(aspekPenilaian[0]);
    JLabel nilai2 = new JLabel(aspekPenilaian[1]);
    JLabel nilai3 = new JLabel(aspekPenilaian[2]);
    JLabel nilai4 = new JLabel(aspekPenilaian[3]);
    JLabel nilai5 = new JLabel(aspekPenilaian[4]);
    JLabel nilai6 = new JLabel(aspekPenilaian[5]);
    JLabel nilai7 = new JLabel(aspekPenilaian[6]);
    JLabel nilai8 = new JLabel(aspekPenilaian[7]);

    JSpinner jSpinner1, jSpinner2, jSpinner3, jSpinner4, jSpinner5, jSpinner6, jSpinner7, jSpinner8;

    public static void main(String[] args) {
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
                    char[] passwordAdminChar = passwordAdmin.getPassword();
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

                            byte[] saltKey = hexStringToByteArray(passwordTwo);
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
                    } catch (NoSuchAlgorithmException ex) {
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
                passwordAdmin.setEchoChar((char) 0);
            } else {
                passwordAdmin.setEchoChar('*');
            }
        });

        String[] options = new String[]{"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Verifikasi Password Admin", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        if (option == 0) //Pressing OK
        {
            char[] passwordAdminChar = passwordAdmin.getPassword();
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

                    byte[] saltKey = hexStringToByteArray(passwordTwo);
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
        char[] password;
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
                    byte[] salt = hexStringToByteArray(passwordTwoDB);
                    passwordUser = digest(password, salt);
                    if (passwordUser.equals(passwordOneDB)) {
                        JOptionPane.showMessageDialog(null, "Password benar!", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
                        TPAAzkaAiniya laundry = new TPAAzkaAiniya();
                        laundry.setPasswordAdminPassed(true);
                    } else {
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
        char[] passwordTwoSignUp;
        userNameSignUp = SignUp.jTextField1.getText();
        passwordTwoSignUp = SignUp.passwordUser;
        try {
            byte[] salt = getSalt();
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
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
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
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
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
        } else {
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
            return new ImageIcon(imgURL);
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
        File destinationDirNoFoto = new File("foto-siswa", outFileNameNoFoto);
        String newPathNoFoto = destinationDirNoFoto.getAbsolutePath();
        System.out.println("new path file is " + newPathNoFoto);

        if (stringPath != null) {
            File sourceImage = new File(stringPath);
            String ts = Siswa.jTextField2.getText();
            String name = sourceImage.getName();
            String ext = name.substring(name.lastIndexOf("."));
            String outFileName = ts + ext;
            File destinationDir = new File("foto-siswa", outFileName);
            String newPath = destinationDir.getAbsolutePath();
            System.out.println("new path file is " + newPath);

            FileUtils.copyFile(sourceImage, destinationDir);

            try {

                java.util.Date utilDate = (java.util.Date) Siswa.jDateChooser2.getDate(); //jDateChooser3
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                java.util.Date utilDate1 = (java.util.Date) Siswa.jDateChooser3.getDate(); //jDateChooser3
                java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
                String sqlQuery = ("insert into siswa (noInduk, namaLengkap, namaPanggilan, jenisKelamin, tempatLahir, tanggalLahir, tanggalMasukTPA, namaAyah, namaIbu, noTelpAyahIbu, noWaAyahIbu, alamatLengkap, fotoSiswa, user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                connectionDatabase.connect();
                preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, Siswa.jTextField1.getText() + " " + Siswa.jTextField5.getText());
                preparedStatement.setString(2, Siswa.jTextField2.getText());
                preparedStatement.setString(3, Siswa.jTextField4.getText());
                System.out.println("Combo Box Jenis Kelamin " + Siswa.jComboBox1.getSelectedItem().toString());
                preparedStatement.setString(4, Siswa.jComboBox1.getSelectedItem().toString());
                preparedStatement.setString(5, Siswa.jTextField3.getText());
                preparedStatement.setDate(6, sqlDate);
                preparedStatement.setDate(7, sqlDate1);
                preparedStatement.setString(8, Siswa.jTextField7.getText());
                preparedStatement.setString(9, Siswa.jTextField11.getText());
                preparedStatement.setString(10, Siswa.jTextField9.getText());
                preparedStatement.setString(11, Siswa.jTextField10.getText());
                preparedStatement.setString(12, Siswa.jTextArea1.getText());
                preparedStatement.setString(13, newPath);
                preparedStatement.setString(14, Siswa.jLabel1.getText());
                preparedStatement.executeUpdate();
                TPAAzkaAiniya.setIfTrueForCheck(true);
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
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                java.util.Date utilDate1 = (java.util.Date) Siswa.jDateChooser3.getDate(); //jDateChooser3
                java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
                String sqlQuery = ("insert into siswa (noInduk, namaLengkap, namaPanggilan, jenisKelamin, tempatLahir, tanggalLahir, tanggalMasukTPA, namaAyah, namaIbu, noTelpAyahIbu, noWaAyahIbu, alamatLengkap, fotoSiswa, user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                connectionDatabase.connect();
                preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, Siswa.jTextField1.getText() + " " + Siswa.jTextField5.getText());
                preparedStatement.setString(2, Siswa.jTextField2.getText());
                preparedStatement.setString(3, Siswa.jTextField4.getText());
                System.out.println("Combo Box Jenis Kelamin " + Siswa.jComboBox1.getSelectedItem().toString());
                preparedStatement.setString(4, Siswa.jComboBox1.getSelectedItem().toString());
                preparedStatement.setString(5, Siswa.jTextField3.getText());
                preparedStatement.setDate(6, sqlDate);
                preparedStatement.setDate(7, sqlDate1);
                preparedStatement.setString(8, Siswa.jTextField7.getText());
                preparedStatement.setString(9, Siswa.jTextField11.getText());
                preparedStatement.setString(10, Siswa.jTextField9.getText());
                preparedStatement.setString(11, Siswa.jTextField10.getText());
                preparedStatement.setString(12, Siswa.jTextArea1.getText());
                preparedStatement.setString(13, pathFotoSiswa);
                preparedStatement.setString(14, Siswa.jLabel1.getText());
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
                JLabel[] jLabel = {new JLabel("No Induk Terakhir adalah : "), new JLabel(noIndukTerakhir)};
                Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 16);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);

            } else {
                JLabel[] jLabel = {new JLabel("No Induk masih kosong, Anda bisa mulai dari : "), new JLabel(noIndukPertama)};
                Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 14);
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

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tabel Siswa", TitledBorder.CENTER, TitledBorder.TOP));

        DefaultTableModel model = new DefaultTableModel(new String[]{"No Induk", "Nama Lengkap"}, 0);

        while (resultSet.next()) {
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

                if (realColumnIndex == 1) {
                    tip = "Klik 2 kali atau Klik OK untuk edit siswa nama : "
                            + getValueAt(rowIndex, colIndex);
                } else {
                    tip = "Klik 2 kali atau Klik OK untuk edit siswa no induk : "
                            + getValueAt(rowIndex, colIndex);
                }
                return tip;
            }

            ;

      @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
      
      for (int i = 0; i < 2; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 1) {
                column.setPreferredWidth(300);
            } else {
                column.setPreferredWidth(50);
            }
        }

        //Add listener double click
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {     // detect double click events
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column

                    TPAAzkaAiniya laundry = new TPAAzkaAiniya();

                    if (column == 0) { //gw cuma ambil logic berdasarkan kolom
                        int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit siswa No Induk : " + table.getValueAt(row, column), "Konfirmasi edit siswa", JOptionPane.YES_NO_OPTION);
                        laundry.setNoInduk((String) table.getValueAt(row, column)); //table.getValueAt(row, column)
                        System.out.println(input + " " + TPAAzkaAiniya.getNoInduk());
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
                        System.out.println(input + " " + TPAAzkaAiniya.getNamaSiswa());
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
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        table.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRender);

        panel.add(new JScrollPane(table));
        String[] options = new String[]{"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Pilih Siswa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        for (int i = 0; i < 2; i++) {
            column = table.getColumnModel().getColumn(i);
            if (option == 0) {
                System.out.println("OK");
                TPAAzkaAiniya laundry = new TPAAzkaAiniya();
                if (i == 1) {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    laundry.setNamaSiswa((String) table.getValueAt(row, column1));
                    try {
                        showDataSiswaByNama();
//                        Window win = SwingUtilities.getWindowAncestor(panel);
//                        win.setVisible(false); 

                    } catch (SQLException ex) {
                        Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    laundry.setNoInduk((String) table.getValueAt(row, column1));
                    try {

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
        System.out.println("Nama siswa di show Data " + namaSiswaTabel);
        try {
            connectionDatabase.connect(); //SELECT * FROM `siswa` WHERE namaLengkap = 'Nuryati'
            String sqlQuery = "SELECT * FROM siswa WHERE namaLengkap = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, namaSiswaTabel);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                noIndukDB = resultSet.getString(1);
                String[] noIndukDBArray = noIndukDB.split(" ");
                System.out.println("Kode tahun " + noIndukDBArray[0]);
                System.out.println("No Urut Induk " + noIndukDBArray[1]);
                Siswa.jTextField12.setText(noIndukDBArray[0]);
                Siswa.jTextField6.setText(noIndukDBArray[1]);
                Siswa.jTextField15.setText(resultSet.getString(2));
                Siswa.jTextField8.setText(resultSet.getString(3));
                String jenisKelaminFromDB = resultSet.getString(4);
                int indexJenisKelamin = 1;
                if (jenisKelaminFromDB.equals("Laki-laki")) {
                    indexJenisKelamin = 0;
                } else {
                    indexJenisKelamin = 1;
                }
                Siswa.jComboBox2.setSelectedIndex(indexJenisKelamin); 
                Siswa.jTextField14.setText(resultSet.getString(5));
                Date birthDateStudent = resultSet.getDate("tanggalLahir");
                Siswa.jDateChooser5.setDate(birthDateStudent);
                Date joinDateStudent = resultSet.getDate("tanggalMasukTPA");
                Siswa.jDateChooser4.setDate(joinDateStudent);
                Siswa.jTextField16.setText(resultSet.getString(8));
                Siswa.jTextField13.setText(resultSet.getString(9));
                Siswa.jTextField18.setText(resultSet.getString(10));
                Siswa.jTextField17.setText(resultSet.getString(11));
                Siswa.jTextArea2.setText(resultSet.getString(12));
                String imagePath = resultSet.getString(13);
                Siswa.jLabel45.setIcon(resizeImage(imagePath));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void showDataSiswaByNoInduk() throws SQLException {
        String noIndukSiswaTabel, noIndukDB;
        noIndukSiswaTabel = TPAAzkaAiniya.getNoInduk();
        System.out.println("Nama siswa di show Data " + noIndukSiswaTabel);
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT * FROM siswa WHERE noInduk = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, noIndukSiswaTabel);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                noIndukDB = resultSet.getString(1);
                String[] noIndukDBArray = noIndukDB.split(" ");
                System.out.println("Kode tahun " + noIndukDBArray[0]);
                System.out.println("No Urut Induk " + noIndukDBArray[1]);
                Siswa.jTextField12.setText(noIndukDBArray[0]);
                Siswa.jTextField6.setText(noIndukDBArray[1]);
                Siswa.jTextField15.setText(resultSet.getString(2));
                Siswa.jTextField8.setText(resultSet.getString(3));
                String jenisKelaminFromDB = resultSet.getString(4);
                int indexJenisKelamin = 1;
                if (jenisKelaminFromDB.equals("Laki-laki")) {
                    indexJenisKelamin = 0;
                } else {
                    indexJenisKelamin = 1;
                }
                Siswa.jComboBox2.setSelectedIndex(indexJenisKelamin); 
                Siswa.jTextField14.setText(resultSet.getString(5));
                Date birthDateStudent = resultSet.getDate("tanggalLahir");
                Siswa.jDateChooser5.setDate(birthDateStudent);
                Date joinDateStudent = resultSet.getDate("tanggalMasukTPA");
                Siswa.jDateChooser4.setDate(joinDateStudent);
                Siswa.jTextField16.setText(resultSet.getString(8));
                Siswa.jTextField13.setText(resultSet.getString(9));
                Siswa.jTextField18.setText(resultSet.getString(10));
                Siswa.jTextField17.setText(resultSet.getString(11));
                Siswa.jTextArea2.setText(resultSet.getString(12));
                String imagePath = resultSet.getString(13);
                Siswa.jLabel45.setIcon(resizeImage(imagePath));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteSiswa() {
        ImageIcon icon = new ImageIcon("src/tpaazkaainiya/image/success_icon.png");
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

        JLabel[] jLabel = {new JLabel("Yakin ingin hapus siswa : "), new JLabel("No Induk : " + noIndukToDelete), new JLabel("Nama : " + siswaToDelete)};
        Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 12);
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

                JLabel[] jLabel1 = {new JLabel("Berhasil dihapus"), new JLabel("No Induk : " + noIndukToDelete), new JLabel("Nama : " + siswaToDelete)};
                Font fontNoIndukSiswa1 = new Font("Ubuntu", Font.BOLD, 12);

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

    public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {

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
        java.sql.Date sqlDateLahir = new java.sql.Date(dateLahir.getTime());
        java.util.Date dateJoin = (java.util.Date) Siswa.jDateChooser4.getDate();
        java.sql.Date sqlDateJoin = new java.sql.Date(dateJoin.getTime());

        JLabel[] jLabel = {new JLabel("Yakin ingin update siswa : "), new JLabel("No Induk : " + noIndukToUpdate), new JLabel("Nama : " + siswaToUpdate)};
        Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 12);
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
                File destinationDir = new File("foto-siswa", outFileName);
                String newPath = destinationDir.getAbsolutePath();
                System.out.println("new path file is " + newPath);

                FileUtils.copyFile(sourceImage, destinationDir);

                try {

                    connectionDatabase.connect();
                    String userUpdateQuery = "UPDATE siswa SET namaLengkap = ?, namaPanggilan = ?, jenisKelamin = ?, tempatLahir = ?, tanggalLahir = ?, tanggalMasukTPA = ?, namaAyah = ?, namaIbu = ?, noTelpAyahIbu = ?, noWaAyahIbu = ?, alamatLengkap = ?, fotoSiswa = ?, userMadeEdit = ?, tanggalDiedit = ? WHERE noInduk = ?";
                    preparedStatement = connectionDatabase.connection.prepareStatement(userUpdateQuery);
                    preparedStatement.setString(1, Siswa.jTextField15.getText());
                    preparedStatement.setString(2, Siswa.jTextField8.getText());
                    preparedStatement.setString(3, Siswa.jComboBox2.getSelectedItem().toString());
                    preparedStatement.setString(4, Siswa.jTextField14.getText());
                    preparedStatement.setDate(5, sqlDateLahir);
                    preparedStatement.setDate(6, sqlDateJoin);
                    preparedStatement.setString(7, Siswa.jTextField16.getText());
                    preparedStatement.setString(8, Siswa.jTextField13.getText());
                    preparedStatement.setString(9, Siswa.jTextField18.getText());
                    preparedStatement.setString(10, Siswa.jTextField17.getText());
                    preparedStatement.setString(11, Siswa.jTextArea2.getText());
                    preparedStatement.setString(12, newPath);
                    preparedStatement.setString(13, userUpdate);
                    preparedStatement.setTimestamp(14, new java.sql.Timestamp(date.getTime()));

//                    preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    preparedStatement.setString(15, noIndukToUpdate);
                    preparedStatement.execute();

                    JLabel[] jLabel1 = {new JLabel("Berhasil dihapus"), new JLabel("No Induk : " + noIndukToUpdate), new JLabel("Nama : " + siswaToUpdate)};
                    Font fontNoIndukSiswa1 = new Font("Ubuntu", Font.BOLD, 12);

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
                    String userUpdateQuery = "UPDATE siswa SET namaLengkap = ?, namaPanggilan = ?, jenisKelamin = ?, tempatLahir = ?, tanggalLahir = ?, tanggalMasukTPA = ?, namaAyah = ?, namaIbu = ?, noTelpAyahIbu = ?, noWaAyahIbu = ?, alamatLengkap = ?, userMadeEdit = ?, tanggalDiedit = ? WHERE noInduk = ?";
                    preparedStatement = connectionDatabase.connection.prepareStatement(userUpdateQuery);
                    preparedStatement.setString(1, Siswa.jTextField15.getText());
                    preparedStatement.setString(2, Siswa.jTextField8.getText());
                    preparedStatement.setString(3, Siswa.jComboBox2.getSelectedItem().toString());
                    preparedStatement.setString(4, Siswa.jTextField14.getText());
                    preparedStatement.setDate(5, sqlDateLahir);
                    preparedStatement.setDate(6, sqlDateJoin);
                    preparedStatement.setString(7, Siswa.jTextField16.getText());
                    preparedStatement.setString(8, Siswa.jTextField13.getText());
                    preparedStatement.setString(9, Siswa.jTextField18.getText());
                    preparedStatement.setString(10, Siswa.jTextField17.getText());
                    preparedStatement.setString(11, Siswa.jTextArea2.getText());
                    preparedStatement.setString(12, userUpdate);
                    preparedStatement.setTimestamp(13, new java.sql.Timestamp(date.getTime()));
//                    preparedStatement.setString(11, newPath);

//                    preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    preparedStatement.setString(14, noIndukToUpdate);
                    preparedStatement.execute();

                    JLabel[] jLabel1 = {new JLabel("Berhasil diupdate"), new JLabel("No Induk : " + noIndukToUpdate), new JLabel("Nama : " + siswaToUpdate)};
                    Font fontNoIndukSiswa1 = new Font("Ubuntu", Font.BOLD, 12);

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
                JLabel[] jLabel = {new JLabel("Kode Pembelajaran Terakhir adalah : "), new JLabel(kodePembelajaranTerakhir)};
                Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 16);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);

            } else {
                JLabel[] jLabel = {new JLabel("Kode Pembelajaran masih kosong, Anda bisa mulai dari : "), new JLabel(kodePembelajaranPertama)};
                Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 14);
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

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tabel Pembelajaran", TitledBorder.CENTER, TitledBorder.TOP));

        DefaultTableModel model = new DefaultTableModel(new String[]{"Kode Pembelajaran", "Nama Pembelajaran"}, 0);

        while (resultSet.next()) {
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

                if (realColumnIndex == 1) {
                    tip = "Klik 2 kali atau Klik OK untuk edit Nama Pembelajaran : "
                            + getValueAt(rowIndex, colIndex);
                } else {
                    tip = "Klik 2 kali atau Klik OK untuk edit Kode Pembelajaran : "
                            + getValueAt(rowIndex, colIndex);
                }
                return tip;
            }

            ;

      @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
      
      
      for (int i = 0; i < 2; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 1) {
                column.setPreferredWidth(220);
            } else {
                column.setPreferredWidth(130);
            }
        }

        //Add listener double click
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {     // detect double click events
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column

                    TPAAzkaAiniya laundry = new TPAAzkaAiniya();

                    if (column == 0) { //gw cuma ambil logic berdasarkan kolom
                        int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit Kode Pembelajaran " + table.getValueAt(row, column) + "?", "Konfirmasi edit pembelajaran", JOptionPane.YES_NO_OPTION);
                        TPAAzkaAiniya.setKodePembelajaran((String) table.getValueAt(row, column)); //table.getValueAt(row, column)
                        System.out.println(input + " " + TPAAzkaAiniya.getKodePembelajaran());
                        try {
                            showDataPembelajaranByKodePembelajaran();
                            Window win = SwingUtilities.getWindowAncestor(panel);
                            win.setVisible(false);
                        } catch (SQLException ex) {
                            Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit Nama Pembelajaran " + table.getValueAt(row, column) + "?", "Konfirmasi edit pembelajaran", JOptionPane.YES_NO_OPTION);
                        TPAAzkaAiniya.setNamaPembelajaran((String) table.getValueAt(row, column));
                        System.out.println(input + " " + TPAAzkaAiniya.getNamaPembelajaran());
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
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        table.getColumnModel().getColumn(0).setCellRenderer(centerRender);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRender);

        panel.add(new JScrollPane(table));
        String[] options = new String[]{"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Pilih Pembelajaran", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        for (int i = 0; i < 2; i++) {
            column = table.getColumnModel().getColumn(i);
            if (option == 0) {
                System.out.println("OK");
                if (i == 1) {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    TPAAzkaAiniya.setNamaPembelajaran((String) table.getValueAt(row, column1));
                    try {
                        showDataPembelajaranByNama();
//                        Window win = SwingUtilities.getWindowAncestor(panel);
//                        win.setVisible(false); 

                    } catch (SQLException ex) {
                        Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    int row = table.getSelectedRow(); // select a row
                    int column1 = table.getSelectedColumn();

                    table.getValueAt(row, column1);
                    TPAAzkaAiniya.setKodePembelajaran((String) table.getValueAt(row, column1));
                    try {

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
        System.out.println("Nama siswa di show Data " + namaPembelajaranTabel);
        try {
            connectionDatabase.connect(); //SELECT * FROM `siswa` WHERE namaLengkap = 'Nuryati'
            String sqlQuery = "SELECT * FROM pembelajaran WHERE namaPembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, namaPembelajaranTabel);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                kodePembelajaranDB = resultSet.getString(1);
                String[] kodePembelajaranDBArray = kodePembelajaranDB.split(" ");
                System.out.println("Kode Pembelajaran " + kodePembelajaranDBArray[0]);
                System.out.println("No Urut Pembelajaran " + kodePembelajaranDBArray[1]);
                Pembelajaran.jComboBox2.setSelectedItem(kodePembelajaranDBArray[0]);
                Pembelajaran.jTextField17.setText(kodePembelajaranDBArray[1]);
                Pembelajaran.jTextField18.setText(resultSet.getString(2));
                String biayaPembelajaran = resultSet.getString(3);
                String tampilRupiah = numberFormat.format(new BigDecimal(biayaPembelajaran));
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
        System.out.println("Nama siswa di show Data " + kodePembelajaranTabel);
        try {
            connectionDatabase.connect(); //SELECT * FROM `siswa` WHERE namaLengkap = 'Nuryati'
            String sqlQuery = "SELECT * FROM pembelajaran WHERE kodePembelajaran = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, kodePembelajaranTabel);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                kodePembelajaranDB = resultSet.getString(1);
                String[] kodePembelajaranDBArray = kodePembelajaranDB.split(" ");
                System.out.println("Kode Pembelajaran " + kodePembelajaranDBArray[0]);
                System.out.println("No Urut Pembelajaran " + kodePembelajaranDBArray[1]);
                Pembelajaran.jComboBox2.setSelectedItem(kodePembelajaranDBArray[0]);
                Pembelajaran.jTextField17.setText(kodePembelajaranDBArray[1]);
                Pembelajaran.jTextField18.setText(resultSet.getString(2));
                String biayaPembelajaran = resultSet.getString(3);
                String tampilRupiah = numberFormat.format(new BigDecimal(biayaPembelajaran));
                Pembelajaran.jFormattedTextField2.setText(tampilRupiah);
                Pembelajaran.jTextArea2.setText(resultSet.getString(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deletePembelajaran() {
        ImageIcon icon = new ImageIcon("src/tpaazkaainiya/image/success_icon.png");
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

        JLabel[] jLabel = {new JLabel("Yakin ingin hapus Pembelajaran : "), new JLabel("Kode Pembelajaran : " + kodePembelajaranToDelete), new JLabel("Nama : " + pembelajaranToDelete)};
        Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 12);
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

                JLabel[] jLabel1 = {new JLabel("Berhasil dihapus"), new JLabel("No Induk : " + kodePembelajaranToDelete), new JLabel("Nama : " + pembelajaranToDelete)};
                Font fontNoIndukSiswa1 = new Font("Ubuntu", Font.BOLD, 12);

                jLabel1[1].setFont(fontNoIndukSiswa1);
                jLabel1[2].setFont(fontNoIndukSiswa1);
                JOptionPane.showMessageDialog(null, jLabel1, "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
                TPAAzkaAiniya.setIfTrueForCheck(true);

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void updatePembelajaran() {
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
            
            //Pilih Kode Pembelajaran
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            if (resultSet.next() == false) {
                System.out.println("No kode pembelajaran available");
                comboBoxModel.setSelectedItem("Pilih Kode Pembelajaran");
                Pembelajaran.jComboBox3.setModel(comboBoxModel);
                Pembelajaran.jTextField20.setText("");
                Pembelajaran.jFormattedTextField3.setText("");
                
            } else {
                do {
                    kodePembelajaranDB = resultSet.getString("kodePembelajaran");
                    comboBoxModel.addElement(kodePembelajaranDB);
                    Pembelajaran.jComboBox3.setModel(comboBoxModel);
                    
                    Pembelajaran.jComboBox3.addActionListener((ActionEvent e) -> {
                    JComboBox cd = (JComboBox)e.getSource();
                    String pembelajaranKode1 = (String) cd.getSelectedItem();
                    TPAAzkaAiniya.setPembelajaranKode(pembelajaranKode1);
                    jTextFieldFromComboBox();
                    Pembelajaran.jTextField20.setText(TPAAzkaAiniya.getPembelajaranNama());
                    String tampilRupiah = numberFormat.format(new BigDecimal(TPAAzkaAiniya.getPembelajaranBiaya()));
                    Pembelajaran.jFormattedTextField3.setText(tampilRupiah);
                    });
                } while (resultSet.next());
            }

//            while (resultSet.next()) {
//                kodePembelajaranDB = resultSet.getString("kodePembelajaran");
//                Pembelajaran.jComboBox3.addItem(kodePembelajaranDB);
//            }
//            Pembelajaran.jComboBox3.addItemListener((ItemEvent e) -> {
//
//                String pembelajaranKode1 = (String) Pembelajaran.jComboBox3.getSelectedItem();
//                TPAAzkaAiniya.setPembelajaranKode(pembelajaranKode1);
//                jTextFieldFromComboBox();
//                Pembelajaran.jTextField20.setText(TPAAzkaAiniya.getPembelajaranNama());
//                String tampilRupiah = numberFormat.format(new BigDecimal(TPAAzkaAiniya.getPembelajaranBiaya()));
//                Pembelajaran.jFormattedTextField3.setText(tampilRupiah);
//            });

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
//            connectionDatabase.connect();
            String sqlQuery = "SELECT noInduk FROM `siswa`";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            while (resultSet.next()) {

                String noIndukSiswaCombo = resultSet.getString("noInduk");
                comboBoxModel.addElement(noIndukSiswaCombo);
                Pembelajaran.jComboBox4.setModel(comboBoxModel);
            }

            Pembelajaran.jComboBox4.addItemListener((ItemEvent e) -> {

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
//            connectionDatabase.connect();
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

            Date date = new Date();
            String sqlQuery = ("INSERT INTO pembelajaran_siswa (noPembelajaranSiswa, noInduk, namaLengkap, kodePembelajaran, namaPembelajaran, biayaPembelajaran, userMadePembelajaranSiswa, tanggalDaftarPembelajaran) values (?, ?, ?, ?, ?, ?, ?, ?)");
            connectionDatabase.connect();
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, Pembelajaran.jComboBox5.getSelectedItem().toString() + " " + Pembelajaran.jTextField22.getText());
            preparedStatement.setString(2, Pembelajaran.jComboBox4.getSelectedItem().toString());
            preparedStatement.setString(3, Pembelajaran.jTextField21.getText());
            preparedStatement.setString(4, Pembelajaran.jComboBox3.getSelectedItem().toString());
            preparedStatement.setString(5, Pembelajaran.jTextField20.getText());
            preparedStatement.setObject(6, TPAAzkaAiniya.getPembelajaranBiaya());
            preparedStatement.setString(7, Pembelajaran.jLabel1.getText());
            preparedStatement.setTimestamp(8, new java.sql.Timestamp(date.getTime()));
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Yeah, data berhasil disimpan ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            TPAAzkaAiniya.setIfTrueForCheck(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cariNoPembelajaranSiswa() {
        String noPembelajaranSiswaTerakhir;
        String noPembelajaranSiswaPertama = "001";
        try {
            connectionDatabase.connect();
            String sqlQuery = "SELECT noPembelajaranSiswa FROM pembelajaran_siswa ORDER BY noPembelajaranSiswa DESC LIMIT 1";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                noPembelajaranSiswaTerakhir = resultSet.getString(1);
                JLabel[] jLabel = {new JLabel("No Pembelajaran Siswa Terakhir adalah : "), new JLabel(noPembelajaranSiswaTerakhir)};
                Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 16);
                jLabel[1].setFont(fontNoIndukSiswa);
                JOptionPane.showMessageDialog(null, jLabel);

            } else {
                JLabel[] jLabel = {new JLabel("No Pembelajaran Siswa masih kosong, Anda bisa mulai dari : "), new JLabel(noPembelajaranSiswaPertama)};
                Font fontNoIndukSiswa = new Font("Ubuntu", Font.BOLD, 14);
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

        Pembelajaran.jComboBox3.addItemListener((ItemEvent e) -> {
            String pembelajaranKode1 = (String) Pembelajaran.jComboBox3.getSelectedItem();
            TPAAzkaAiniya.setPembelajaranKode(pembelajaranKode1);
            jTextFieldFromComboBox();
            Pembelajaran.jTextField20.setText(TPAAzkaAiniya.getPembelajaranNama());
            String tampilRupiah = numberFormat.format(new BigDecimal(TPAAzkaAiniya.getPembelajaranBiaya()));
            Pembelajaran.jFormattedTextField3.setText(tampilRupiah);
        });
    }

    private String[] GetStringArray(ArrayList listData) {
        // declaration and initialise String Array 
        String str[] = new String[listData.size()]; 
  
        // Convert ArrayList to object array 
        Object[] objArr = listData.toArray(); 
  
        // Iterating and converting to String 
        int i = 0; 
        for (Object obj : objArr) { 
            str[i++] = (String)obj; 
        } 
  
        return str;
    }

    private static class MyComboBoxRender extends JLabel implements ListCellRenderer {

        private String _title;

        public MyComboBoxRender(String title) {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus) {
            if (index == -1 && value == null) {
                setText(_title);
            } else {
                setText(value.toString());
            }
            return this;
        }

    }

    public void comboBoxNamaSiswaInputNilai() throws SQLException {
        try {
//            connectionDatabase.connect();
            String sqlQuery = "SELECT noInduk FROM `siswa`";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            while (resultSet.next()) {

                String noIndukSiswaCombo = resultSet.getString("noInduk");
                comboBoxModel.addElement(noIndukSiswaCombo);
                Pembelajaran.jComboBox8.setModel(comboBoxModel);
            }

            Pembelajaran.jComboBox8.addItemListener((ItemEvent e) -> {

                String noIndukSiswaCombo1 = (String) Pembelajaran.jComboBox8.getSelectedItem();
                TPAAzkaAiniya.setNoIndukSiswaFromCombo(noIndukSiswaCombo1);
                namaSiswaFromCombo();
                Pembelajaran.jTextField25.setText(TPAAzkaAiniya.getNamaSiswaFromCombo());

            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void comboBoxPembelajaranSiswaInputNilai() throws SQLException {
        try {
//            connectionDatabase.connect();
            String sqlQuery = "SELECT noPembelajaranSiswa FROM `pembelajaran_siswa` WHERE namaLengkap = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, TPAAzkaAiniya.getNamaSiswaFromCombo());
            resultSet = preparedStatement.executeQuery();

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

            if (resultSet.next() == false) {
                System.out.println("No data");
                comboBoxModel.setSelectedItem("Belum mengikuti pembelajaran");
                Pembelajaran.jComboBox7.setModel(comboBoxModel);
                Pembelajaran.jTextField26.setText("");
            } else {
                do {
                    String noIndukSiswaCombo = resultSet.getString("noPembelajaranSiswa");
                    comboBoxModel.addElement(noIndukSiswaCombo);
                    Pembelajaran.jComboBox7.setModel(comboBoxModel);
                    
                    Pembelajaran.jComboBox7.addActionListener((ActionEvent e) -> {
                        JComboBox cd = (JComboBox)e.getSource();
                        
                        String kodePembelajaranSiswaCombo1 = (String) cd.getSelectedItem();
                        TPAAzkaAiniya.setKodePembelajaranSiswa(kodePembelajaranSiswaCombo1);
                        namaPembelajaranSiswaFromCombo();
                        Pembelajaran.jTextField26.setText(TPAAzkaAiniya.getNamaPembelajaranSiswa());
                    });

                   
                } while (resultSet.next());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }

    public void namaPembelajaranSiswaFromCombo() {
        try {
//            connectionDatabase.connect();
            String sqlQuery = "SELECT namaPembelajaran FROM `pembelajaran_siswa` WHERE noPembelajaranSiswa = ?";
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, TPAAzkaAiniya.getKodePembelajaranSiswa());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TPAAzkaAiniya.setNamaPembelajaranSiswa(resultSet.getString("namaPembelajaran"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inputNilaiPembelajaranSiswaIqra6() {

        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(nilai1);

        JPanel panelNilai1 = new JPanel(new GridLayout(0, 1));
        panelNilai1.setPreferredSize(new Dimension(100, 50));
        panelNilai1.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai1.setBorder(titledBorder);
        jSpinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai1.add(jSpinner1);

        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal2.add(nilai2);
        panelSoal2.setBorder(titledBorder);

        JPanel panelNilai2 = new JPanel(new GridLayout(0, 1));
        panelNilai2.setPreferredSize(new Dimension(100, 50));
        panelNilai2.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai2.setBorder(titledBorder);
        jSpinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai2.add(jSpinner2);

        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal3.add(nilai3);
        panelSoal3.setBorder(titledBorder);

        JPanel panelNilai3 = new JPanel(new GridLayout(0, 1));
        panelNilai3.setPreferredSize(new Dimension(100, 50));
        panelNilai3.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai3.setBorder(titledBorder);
        jSpinner3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai3.add(jSpinner3);

        JPanel panelSoal4 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[3], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal4.add(nilai4);
        panelSoal4.setBorder(titledBorder);

        JPanel panelNilai4 = new JPanel(new GridLayout(0, 1));
        panelNilai4.setPreferredSize(new Dimension(100, 50));
        panelNilai4.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "4", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai4.setBorder(titledBorder);
        jSpinner4 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai4.add(jSpinner4);

        JPanel panelSoal5 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[4], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal5.add(nilai5);
        panelSoal5.setBorder(titledBorder);

        JPanel panelNilai5 = new JPanel(new GridLayout(0, 1));
        panelNilai5.setPreferredSize(new Dimension(100, 50));
        panelNilai5.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "5", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai5.setBorder(titledBorder);
        jSpinner5 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai5.add(jSpinner5);

        JPanel panelSoal6 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[5], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal6.add(nilai6);
        panelSoal6.setBorder(titledBorder);

        JPanel panelNilai6 = new JPanel(new GridLayout(0, 1));
        panelNilai6.setPreferredSize(new Dimension(100, 50));
        panelNilai6.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "6", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai6.setBorder(titledBorder);
        jSpinner6 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai6.add(jSpinner6);

        JPanel panelSoal7 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[6], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal7.add(nilai7);
        panelSoal7.setBorder(titledBorder);

        JPanel panelNilai7 = new JPanel();
        jSpinner7 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        Component jSpinner7Editor = jSpinner7.getEditor();
        JFormattedTextField jFTF = ((JSpinner.DefaultEditor) jSpinner7Editor).getTextField();
        jFTF.setColumns(5);
        panelNilai7.setPreferredSize(new Dimension(100, 63));
        panelNilai7.setMaximumSize(new Dimension(100, 63));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "7", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai7.setBorder(titledBorder);
        panelNilai7.add(jSpinner7);

        JPanel panelSoal8 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[7], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal8.add(nilai8);
        panelSoal8.setBorder(titledBorder);

        JPanel panelNilai8 = new JPanel(new GridLayout(0, 1));
        panelNilai8.setPreferredSize(new Dimension(100, 50));
        panelNilai8.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "8", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai8.setBorder(titledBorder);
        jSpinner8 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai8.add(jSpinner8);

        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelNilai1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panelSemuaSoal.add(panelNilai2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        panelSemuaSoal.add(panelNilai3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        panelSemuaSoal.add(panelSoal4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 3;
        panelSemuaSoal.add(panelNilai4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        panelSemuaSoal.add(panelSoal5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 4;
        panelSemuaSoal.add(panelNilai5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        panelSemuaSoal.add(panelSoal6, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 5;
        panelSemuaSoal.add(panelNilai6, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 6;
        panelSemuaSoal.add(panelSoal7, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 6;
        panelSemuaSoal.add(panelNilai7, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 7;
        panelSemuaSoal.add(panelSoal8, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 7;
        panelSemuaSoal.add(panelNilai8, c);

        String[] options = new String[]{"Simpan", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panelSemuaSoal, "Input Nilai", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            System.out.println("Anda tekan simpan!");
            int aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5, aspekNilai6, aspekNilai7, aspekNilai8; //Tambah
            aspekNilai1 = (Integer) jSpinner1.getValue();
            aspekNilai2 = (Integer) jSpinner2.getValue();
            aspekNilai3 = (Integer) jSpinner3.getValue();
            aspekNilai4 = (Integer) jSpinner4.getValue();
            aspekNilai5 = (Integer) jSpinner5.getValue();
            aspekNilai6 = (Integer) jSpinner6.getValue(); //Ganti
            aspekNilai7 = (Integer) jSpinner7.getValue();
            aspekNilai8 = (Integer) jSpinner8.getValue();
            System.out.println("Nilai " + aspekNilai1 + aspekNilai2 + aspekNilai3 + aspekNilai4 + aspekNilai5 + aspekNilai6 + aspekNilai7 + aspekNilai8); //Tambah
            int nilaiRataRata[] = {aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5, aspekNilai6, aspekNilai7, aspekNilai8}; //Tambah
            double nilaiRataDecimal = 0;
            for (int i = 0; i < nilaiRataRata.length; i++) {
                nilaiRataDecimal += Double.valueOf(nilaiRataRata[i]);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double nilaiRataFinal = nilaiRataDecimal / nilaiRataRata.length;
            System.out.println("Nilai rata-rata adalah " + df.format(nilaiRataFinal));
            double standarNilaiLulus = 80;

            JPanel panelInformasiNilai = getPanel();
            JPanel panelInformasiRataNilai = getPanel();
            JPanel panelInformasiRataNilaiUcapan = getPanel();
            JPanel panelIconNilai = getPanel();
            JLabel labelIcon = new JLabel();

            

            if (nilaiRataFinal >= standarNilaiLulus) {
                JLabel[] jLabel1 = {new JLabel("Alhamdulillah kamu lanjut ke halaman berikutnya, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};

                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);
                nilai6.setFont(fontPlain);
                nilai7.setFont(fontPlain);
                nilai8.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)),
                    new JLabel(String.valueOf("= " + aspekNilai2)),
                    new JLabel(String.valueOf("= " + aspekNilai3)),
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5)),
                    new JLabel(String.valueOf("= " + aspekNilai6)),
                    new JLabel(String.valueOf("= " + aspekNilai7)),
                    new JLabel(String.valueOf("= " + aspekNilai8))};

                labelIcon.setIcon(alhamdulillahIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelSoal6.add(jLabelNilai[5]);
                panelSoal7.add(jLabelNilai[6]);
                panelSoal8.add(jLabelNilai[7]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 8;
                panelInformasiNilai.add(panelSoal6, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 9;
                panelInformasiNilai.add(panelSoal7, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 10;
                panelInformasiNilai.add(panelSoal8, c2);
                
                simpanNilaiLanjut();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Lanjut", JOptionPane.PLAIN_MESSAGE);
            } else {
                JLabel[] jLabel1 = {new JLabel("Maaf kamu masih harus mengulang lagi, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);
                nilai6.setFont(fontPlain);
                nilai7.setFont(fontPlain);
                nilai8.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), 
                    new JLabel(String.valueOf("= " + aspekNilai2)), 
                    new JLabel(String.valueOf("= " + aspekNilai3)), 
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5)),
                    new JLabel(String.valueOf("= " + aspekNilai6)),
                    new JLabel(String.valueOf("= " + aspekNilai7)),
                    new JLabel(String.valueOf("= " + aspekNilai8))};

                labelIcon.setIcon(afwanIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelSoal6.add(jLabelNilai[5]);
                panelSoal7.add(jLabelNilai[6]);
                panelSoal8.add(jLabelNilai[7]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 8;
                panelInformasiNilai.add(panelSoal6, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 9;
                panelInformasiNilai.add(panelSoal7, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 10;
                panelInformasiNilai.add(panelSoal8, c2);

                simpanNilaiMengulang();
                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Mengulang", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    public void inputNilaiPembelajaranSiswaIqra5() {

        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(nilai1);

        JPanel panelNilai1 = new JPanel(new GridLayout(0, 1));
        panelNilai1.setPreferredSize(new Dimension(100, 50));
        panelNilai1.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai1.setBorder(titledBorder);
        jSpinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai1.add(jSpinner1);

        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal2.add(nilai2);
        panelSoal2.setBorder(titledBorder);

        JPanel panelNilai2 = new JPanel(new GridLayout(0, 1));
        panelNilai2.setPreferredSize(new Dimension(100, 50));
        panelNilai2.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai2.setBorder(titledBorder);
        jSpinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai2.add(jSpinner2);

        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal3.add(nilai3);
        panelSoal3.setBorder(titledBorder);

        JPanel panelNilai3 = new JPanel(new GridLayout(0, 1));
        panelNilai3.setPreferredSize(new Dimension(100, 50));
        panelNilai3.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai3.setBorder(titledBorder);
        jSpinner3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai3.add(jSpinner3);

        JPanel panelSoal4 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[3], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal4.add(nilai4);
        panelSoal4.setBorder(titledBorder);

        JPanel panelNilai4 = new JPanel(new GridLayout(0, 1));
        panelNilai4.setPreferredSize(new Dimension(100, 50));
        panelNilai4.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "4", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai4.setBorder(titledBorder);
        jSpinner4 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai4.add(jSpinner4);

        JPanel panelSoal5 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[4], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal5.add(nilai5);
        panelSoal5.setBorder(titledBorder);

        JPanel panelNilai5 = new JPanel(new GridLayout(0, 1));
        panelNilai5.setPreferredSize(new Dimension(100, 50));
        panelNilai5.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "5", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai5.setBorder(titledBorder);
        jSpinner5 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai5.add(jSpinner5);

        JPanel panelSoal6 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[5], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal6.add(nilai6);
        panelSoal6.setBorder(titledBorder);

        JPanel panelNilai6 = new JPanel(new GridLayout(0, 1));
        panelNilai6.setPreferredSize(new Dimension(100, 50));
        panelNilai6.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "6", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai6.setBorder(titledBorder);
        jSpinner6 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai6.add(jSpinner6);

        JPanel panelSoal7 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[6], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal7.add(nilai7);
        panelSoal7.setBorder(titledBorder);

        JPanel panelNilai7 = new JPanel();
        jSpinner7 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        Component jSpinner7Editor = jSpinner7.getEditor();
        JFormattedTextField jFTF = ((JSpinner.DefaultEditor) jSpinner7Editor).getTextField();
        jFTF.setColumns(5);
        panelNilai7.setPreferredSize(new Dimension(100, 63));
        panelNilai7.setMaximumSize(new Dimension(100, 63));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "7", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai7.setBorder(titledBorder);
        panelNilai7.add(jSpinner7);

        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelNilai1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panelSemuaSoal.add(panelNilai2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        panelSemuaSoal.add(panelNilai3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        panelSemuaSoal.add(panelSoal4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 3;
        panelSemuaSoal.add(panelNilai4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        panelSemuaSoal.add(panelSoal5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 4;
        panelSemuaSoal.add(panelNilai5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        panelSemuaSoal.add(panelSoal6, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 5;
        panelSemuaSoal.add(panelNilai6, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 6;
        panelSemuaSoal.add(panelSoal7, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 6;
        panelSemuaSoal.add(panelNilai7, c);
        c.fill = GridBagConstraints.HORIZONTAL;

        JOptionPane jp = new JOptionPane(("Session Expired - Please Re Login"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
        JDialog dialog = jp.createDialog(null, "Session Expired - Please Re Login");
        ((Frame) dialog.getParent()).setIconImage(((ImageIcon) icon).getImage());

        String[] options = new String[]{"Simpan", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panelSemuaSoal, "Input Nilai", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            System.out.println("Anda tekan simpan!");
            int aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5, aspekNilai6, aspekNilai7; //Tambah
            aspekNilai1 = (Integer) jSpinner1.getValue();
            aspekNilai2 = (Integer) jSpinner2.getValue();
            aspekNilai3 = (Integer) jSpinner3.getValue();
            aspekNilai4 = (Integer) jSpinner4.getValue();
            aspekNilai5 = (Integer) jSpinner5.getValue();
            aspekNilai6 = (Integer) jSpinner6.getValue(); //Ganti
            aspekNilai7 = (Integer) jSpinner7.getValue();
            System.out.println("Nilai " + aspekNilai1 + aspekNilai2 + aspekNilai3 + aspekNilai4 + aspekNilai5 + aspekNilai6 + aspekNilai7); //Tambah
            int nilaiRataRata[] = {aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5, aspekNilai6, aspekNilai7}; //Tambah
            double nilaiRataDecimal = 0;
            for (int i = 0; i < nilaiRataRata.length; i++) {
                nilaiRataDecimal += Double.valueOf(nilaiRataRata[i]);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double nilaiRataFinal = nilaiRataDecimal / nilaiRataRata.length;
            System.out.println("Nilai rata-rata adalah " + df.format(nilaiRataFinal));
            double standarNilaiLulus = 80;

            JPanel panelInformasiNilai = getPanel();
            JPanel panelInformasiRataNilai = getPanel();
            JPanel panelInformasiRataNilaiUcapan = getPanel();
            JPanel panelIconNilai = getPanel();
            JLabel labelIcon = new JLabel();

            

            if (nilaiRataFinal >= standarNilaiLulus) {
                JLabel[] jLabel1 = {new JLabel("Alhamdulillah kamu lanjut ke halaman berikutnya, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};

                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);
                nilai6.setFont(fontPlain);
                nilai7.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)),
                    new JLabel(String.valueOf("= " + aspekNilai2)),
                    new JLabel(String.valueOf("= " + aspekNilai3)),
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5)),
                    new JLabel(String.valueOf("= " + aspekNilai6)),
                    new JLabel(String.valueOf("= " + aspekNilai7))};

                labelIcon.setIcon(alhamdulillahIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelSoal6.add(jLabelNilai[5]);
                panelSoal7.add(jLabelNilai[6]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 8;
                panelInformasiNilai.add(panelSoal6, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 9;
                panelInformasiNilai.add(panelSoal7, c2);
                
                simpanNilaiLanjut();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Lanjut", JOptionPane.PLAIN_MESSAGE);
            } else {
                JLabel[] jLabel1 = {new JLabel("Maaf kamu masih harus mengulang lagi, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);
                nilai6.setFont(fontPlain);
                nilai7.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), 
                    new JLabel(String.valueOf("= " + aspekNilai2)), 
                    new JLabel(String.valueOf("= " + aspekNilai3)), 
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5)),
                    new JLabel(String.valueOf("= " + aspekNilai6)),
                    new JLabel(String.valueOf("= " + aspekNilai7))};

                labelIcon.setIcon(afwanIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelSoal6.add(jLabelNilai[5]);
                panelSoal7.add(jLabelNilai[6]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 8;
                panelInformasiNilai.add(panelSoal6, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 9;
                panelInformasiNilai.add(panelSoal7, c2);

                simpanNilaiMengulang();
                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Mengulang", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    public void inputNilaiPembelajaranSiswaIqra4() {

        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(nilai1);

        JPanel panelNilai1 = new JPanel(new GridLayout(0, 1));
        panelNilai1.setPreferredSize(new Dimension(100, 50));
        panelNilai1.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai1.setBorder(titledBorder);
        jSpinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai1.add(jSpinner1);

        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal2.add(nilai2);
        panelSoal2.setBorder(titledBorder);

        JPanel panelNilai2 = new JPanel(new GridLayout(0, 1));
        panelNilai2.setPreferredSize(new Dimension(100, 50));
        panelNilai2.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai2.setBorder(titledBorder);
        jSpinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai2.add(jSpinner2);

        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal3.add(nilai3);
        panelSoal3.setBorder(titledBorder);

        JPanel panelNilai3 = new JPanel(new GridLayout(0, 1));
        panelNilai3.setPreferredSize(new Dimension(100, 50));
        panelNilai3.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai3.setBorder(titledBorder);
        jSpinner3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai3.add(jSpinner3);

        JPanel panelSoal4 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[3], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal4.add(nilai4);
        panelSoal4.setBorder(titledBorder);

        JPanel panelNilai4 = new JPanel(new GridLayout(0, 1));
        panelNilai4.setPreferredSize(new Dimension(100, 50));
        panelNilai4.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "4", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai4.setBorder(titledBorder);
        jSpinner4 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai4.add(jSpinner4);

        JPanel panelSoal5 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[4], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal5.add(nilai5);
        panelSoal5.setBorder(titledBorder);

        JPanel panelNilai5 = new JPanel(new GridLayout(0, 1));
        panelNilai5.setPreferredSize(new Dimension(100, 50));
        panelNilai5.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "5", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai5.setBorder(titledBorder);
        jSpinner5 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai5.add(jSpinner5);

        JPanel panelSoal6 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[5], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal6.add(nilai6);
        panelSoal6.setBorder(titledBorder);

        JPanel panelNilai6 = new JPanel(new GridLayout(0, 1));
        panelNilai6.setPreferredSize(new Dimension(100, 50));
        panelNilai6.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "6", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai6.setBorder(titledBorder);
        jSpinner6 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai6.add(jSpinner6);

        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelNilai1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panelSemuaSoal.add(panelNilai2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        panelSemuaSoal.add(panelNilai3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        panelSemuaSoal.add(panelSoal4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 3;
        panelSemuaSoal.add(panelNilai4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        panelSemuaSoal.add(panelSoal5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 4;
        panelSemuaSoal.add(panelNilai5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        panelSemuaSoal.add(panelSoal6, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 5;
        panelSemuaSoal.add(panelNilai6, c);
        c.fill = GridBagConstraints.HORIZONTAL;

        JOptionPane jp = new JOptionPane(("Session Expired - Please Re Login"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
        JDialog dialog = jp.createDialog(null, "Session Expired - Please Re Login");
        ((Frame) dialog.getParent()).setIconImage(((ImageIcon) icon).getImage());

        String[] options = new String[]{"Simpan", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panelSemuaSoal, "Input Nilai", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            System.out.println("Anda tekan simpan!");
            int aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5, aspekNilai6; //Tambah
            aspekNilai1 = (Integer) jSpinner1.getValue();
            aspekNilai2 = (Integer) jSpinner2.getValue();
            aspekNilai3 = (Integer) jSpinner3.getValue();
            aspekNilai4 = (Integer) jSpinner4.getValue();
            aspekNilai5 = (Integer) jSpinner5.getValue();
            aspekNilai6 = (Integer) jSpinner6.getValue(); //Ganti
            System.out.println("Nilai " + aspekNilai1 + aspekNilai2 + aspekNilai3 + aspekNilai4 + aspekNilai5 + aspekNilai6); //Tambah
            int nilaiRataRata[] = {aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5, aspekNilai6}; //Tambah
            double nilaiRataDecimal = 0;
            for (int i = 0; i < nilaiRataRata.length; i++) {
                nilaiRataDecimal += Double.valueOf(nilaiRataRata[i]);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double nilaiRataFinal = nilaiRataDecimal / nilaiRataRata.length;
            System.out.println("Nilai rata-rata adalah " + df.format(nilaiRataFinal));
            double standarNilaiLulus = 80;

            JPanel panelInformasiNilai = getPanel();
            JPanel panelInformasiRataNilai = getPanel();
            JPanel panelInformasiRataNilaiUcapan = getPanel();
            JPanel panelIconNilai = getPanel();
            JLabel labelIcon = new JLabel();

            

            if (nilaiRataFinal >= standarNilaiLulus) {
                JLabel[] jLabel1 = {new JLabel("Alhamdulillah kamu lanjut ke halaman berikutnya, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};

                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);
                nilai6.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)),
                    new JLabel(String.valueOf("= " + aspekNilai2)),
                    new JLabel(String.valueOf("= " + aspekNilai3)),
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5)),
                    new JLabel(String.valueOf("= " + aspekNilai6))};

                labelIcon.setIcon(alhamdulillahIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelSoal6.add(jLabelNilai[5]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 8;
                panelInformasiNilai.add(panelSoal6, c2);
                
                simpanNilaiLanjut();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Lanjut", JOptionPane.PLAIN_MESSAGE);
            } else {
                JLabel[] jLabel1 = {new JLabel("Maaf kamu masih harus mengulang lagi, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);
                nilai6.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), 
                    new JLabel(String.valueOf("= " + aspekNilai2)), 
                    new JLabel(String.valueOf("= " + aspekNilai3)), 
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5)),
                    new JLabel(String.valueOf("= " + aspekNilai6))};

                labelIcon.setIcon(afwanIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelSoal6.add(jLabelNilai[5]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 8;
                panelInformasiNilai.add(panelSoal6, c2);

                simpanNilaiMengulang();
                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Mengulang", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    public void inputNilaiPembelajaranSiswaIqra3() {

        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(nilai1);

        JPanel panelNilai1 = new JPanel(new GridLayout(0, 1));
        panelNilai1.setPreferredSize(new Dimension(100, 50));
        panelNilai1.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai1.setBorder(titledBorder);
        jSpinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai1.add(jSpinner1);

        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal2.add(nilai2);
        panelSoal2.setBorder(titledBorder);

        JPanel panelNilai2 = new JPanel(new GridLayout(0, 1));
        panelNilai2.setPreferredSize(new Dimension(100, 50));
        panelNilai2.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai2.setBorder(titledBorder);
        jSpinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai2.add(jSpinner2);

        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal3.add(nilai3);
        panelSoal3.setBorder(titledBorder);

        JPanel panelNilai3 = new JPanel(new GridLayout(0, 1));
        panelNilai3.setPreferredSize(new Dimension(100, 50));
        panelNilai3.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai3.setBorder(titledBorder);
        jSpinner3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai3.add(jSpinner3);

        JPanel panelSoal4 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[3], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal4.add(nilai4);
        panelSoal4.setBorder(titledBorder);

        JPanel panelNilai4 = new JPanel(new GridLayout(0, 1));
        panelNilai4.setPreferredSize(new Dimension(100, 50));
        panelNilai4.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "4", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai4.setBorder(titledBorder);
        jSpinner4 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai4.add(jSpinner4);

        JPanel panelSoal5 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[4], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal5.add(nilai5);
        panelSoal5.setBorder(titledBorder);

        JPanel panelNilai5 = new JPanel(new GridLayout(0, 1));
        panelNilai5.setPreferredSize(new Dimension(100, 50));
        panelNilai5.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "5", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai5.setBorder(titledBorder);
        jSpinner5 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai5.add(jSpinner5);

        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelNilai1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panelSemuaSoal.add(panelNilai2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        panelSemuaSoal.add(panelNilai3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        panelSemuaSoal.add(panelSoal4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 3;
        panelSemuaSoal.add(panelNilai4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        panelSemuaSoal.add(panelSoal5, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 4;
        panelSemuaSoal.add(panelNilai5, c);
        c.fill = GridBagConstraints.HORIZONTAL;

        JOptionPane jp = new JOptionPane(("Session Expired - Please Re Login"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
        JDialog dialog = jp.createDialog(null, "Session Expired - Please Re Login");
        ((Frame) dialog.getParent()).setIconImage(((ImageIcon) icon).getImage());

        String[] options = new String[]{"Simpan", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panelSemuaSoal, "Input Nilai", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            System.out.println("Anda tekan simpan!");
            int aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5;
            aspekNilai1 = (Integer) jSpinner1.getValue();
            aspekNilai2 = (Integer) jSpinner2.getValue();
            aspekNilai3 = (Integer) jSpinner3.getValue();
            aspekNilai4 = (Integer) jSpinner4.getValue();
            aspekNilai5 = (Integer) jSpinner5.getValue();
            System.out.println("Nilai " + aspekNilai1 + aspekNilai2 + aspekNilai3 + aspekNilai4 + aspekNilai5);
            int nilaiRataRata[] = {aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4, aspekNilai5};
            double nilaiRataDecimal = 0;
            for (int i = 0; i < nilaiRataRata.length; i++) {
                nilaiRataDecimal += Double.valueOf(nilaiRataRata[i]);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double nilaiRataFinal = nilaiRataDecimal / nilaiRataRata.length;
            System.out.println("Nilai rata-rata adalah " + df.format(nilaiRataFinal));
            double standarNilaiLulus = 80;

            JPanel panelInformasiNilai = getPanel();
            JPanel panelInformasiRataNilai = getPanel();
            JPanel panelInformasiRataNilaiUcapan = getPanel();
            JPanel panelIconNilai = getPanel();
            JLabel labelIcon = new JLabel();

            

            if (nilaiRataFinal >= standarNilaiLulus) {
                JLabel[] jLabel1 = {new JLabel("Alhamdulillah kamu lanjut ke halaman berikutnya, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};

                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)),
                    new JLabel(String.valueOf("= " + aspekNilai2)),
                    new JLabel(String.valueOf("= " + aspekNilai3)),
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5))};

                labelIcon.setIcon(alhamdulillahIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                
                simpanNilaiLanjut();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Lanjut", JOptionPane.PLAIN_MESSAGE);
            } else {
                JLabel[] jLabel1 = {new JLabel("Maaf kamu masih harus mengulang lagi, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);
                nilai5.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), 
                    new JLabel(String.valueOf("= " + aspekNilai2)), 
                    new JLabel(String.valueOf("= " + aspekNilai3)), 
                    new JLabel(String.valueOf("= " + aspekNilai4)),
                    new JLabel(String.valueOf("= " + aspekNilai5))};

                labelIcon.setIcon(afwanIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelSoal5.add(jLabelNilai[4]);
                panelInformasiRataNilaiUcapan.add(jLabel1[0]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(panelInformasiRataNilaiUcapan, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 7;
                panelInformasiNilai.add(panelSoal5, c2);
                
                simpanNilaiMengulang();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Mengulang", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    public void inputNilaiPembelajaranSiswaIqra2() {
        
        nilai1.setFont(fontPlain);
        nilai2.setFont(fontPlain);
        nilai3.setFont(fontPlain);
        nilai4.setFont(fontPlain);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(nilai1);

        JPanel panelNilai1 = new JPanel(new GridLayout(0, 1));
        panelNilai1.setPreferredSize(new Dimension(100, 50));
        panelNilai1.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai1.setBorder(titledBorder);
        jSpinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai1.add(jSpinner1);

        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal2.add(nilai2);
        panelSoal2.setBorder(titledBorder);

        JPanel panelNilai2 = new JPanel(new GridLayout(0, 1));
        panelNilai2.setPreferredSize(new Dimension(100, 50));
        panelNilai2.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai2.setBorder(titledBorder);
        jSpinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai2.add(jSpinner2);

        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal3.add(nilai3);
        panelSoal3.setBorder(titledBorder);

        JPanel panelNilai3 = new JPanel(new GridLayout(0, 1));
        panelNilai3.setPreferredSize(new Dimension(100, 50));
        panelNilai3.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai3.setBorder(titledBorder);
        jSpinner3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai3.add(jSpinner3);

        JPanel panelSoal4 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[3], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal4.add(nilai4);
        panelSoal4.setBorder(titledBorder);

        JPanel panelNilai4 = new JPanel(new GridLayout(0, 1));
        panelNilai4.setPreferredSize(new Dimension(100, 50));
        panelNilai4.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "4", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai4.setBorder(titledBorder);
        jSpinner4 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai4.add(jSpinner4);

        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelNilai1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panelSemuaSoal.add(panelNilai2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        panelSemuaSoal.add(panelNilai3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        panelSemuaSoal.add(panelSoal4, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 3;
        panelSemuaSoal.add(panelNilai4, c);
        c.fill = GridBagConstraints.HORIZONTAL;

        String[] options = new String[]{"Simpan", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panelSemuaSoal, "Input Nilai", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            System.out.println("Anda tekan simpan!");
            int aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4;
            aspekNilai1 = (Integer) jSpinner1.getValue();
            aspekNilai2 = (Integer) jSpinner2.getValue();
            aspekNilai3 = (Integer) jSpinner3.getValue();
            aspekNilai4 = (Integer) jSpinner4.getValue();
            System.out.println("Nilai " + aspekNilai1 + aspekNilai2 + aspekNilai3 + aspekNilai4);
            int nilaiRataRata[] = {aspekNilai1, aspekNilai2, aspekNilai3, aspekNilai4};
            double nilaiRataDecimal = 0;
            for (int i = 0; i < nilaiRataRata.length; i++) {
                nilaiRataDecimal += Double.valueOf(nilaiRataRata[i]);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double nilaiRataFinal = nilaiRataDecimal / nilaiRataRata.length;
            System.out.println("Nilai rata-rata adalah " + df.format(nilaiRataFinal));
            double standarNilaiLulus = 80;

            JPanel panelInformasiNilai = getPanel();
            JPanel panelInformasiRataNilai = getPanel();
            JPanel panelIconNilai = getPanel();
            JLabel labelIcon = new JLabel();

            

            if (nilaiRataFinal >= standarNilaiLulus) {
                JLabel[] jLabel1 = {new JLabel("Alhamdulillah kamu lanjut ke halaman berikutnya, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};

                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), new JLabel(String.valueOf("= " + aspekNilai2)), new JLabel(String.valueOf("= " + aspekNilai3)), new JLabel(String.valueOf("= " + aspekNilai4))};

                labelIcon.setIcon(alhamdulillahIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(jLabel1[0], c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                
                simpanNilaiLanjut();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Lanjut", JOptionPane.PLAIN_MESSAGE);
                
            } else {
                JLabel[] jLabel1 = {new JLabel("Maaf kamu masih harus mengulang lagi, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);
                nilai4.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), new JLabel(String.valueOf("= " + aspekNilai2)), new JLabel(String.valueOf("= " + aspekNilai3)), new JLabel(String.valueOf("= " + aspekNilai4))};

                labelIcon.setIcon(afwanIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelSoal4.add(jLabelNilai[3]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(jLabel1[0], c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 6;
                panelInformasiNilai.add(panelSoal4, c2);
                simpanNilaiMengulang();

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Mengulang", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    public void inputNilaiPembelajaranSiswaIqra1() {

        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(nilai1);

        JPanel panelNilai1 = new JPanel(new GridLayout(0, 1));
        panelNilai1.setPreferredSize(new Dimension(100, 50));
        panelNilai1.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai1.setBorder(titledBorder);
        jSpinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai1.add(jSpinner1);

        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal2.add(nilai2);
        panelSoal2.setBorder(titledBorder);

        JPanel panelNilai2 = new JPanel(new GridLayout(0, 1));
        panelNilai2.setPreferredSize(new Dimension(100, 50));
        panelNilai2.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai2.setBorder(titledBorder);
        jSpinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai2.add(jSpinner2);

        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, nomor[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelSoal3.add(nilai3);
        panelSoal3.setBorder(titledBorder);

        JPanel panelNilai3 = new JPanel(new GridLayout(0, 1));
        panelNilai3.setPreferredSize(new Dimension(100, 50));
        panelNilai3.setMaximumSize(new Dimension(100, 50));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, "3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, font);
        panelNilai3.setBorder(titledBorder);
        jSpinner3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelNilai3.add(jSpinner3);

        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelNilai1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panelSemuaSoal.add(panelNilai2, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        panelSemuaSoal.add(panelNilai3, c);
        c.fill = GridBagConstraints.HORIZONTAL;

        String[] options = new String[]{"Simpan", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panelSemuaSoal, "Input Nilai", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            System.out.println("Anda tekan simpan!");
            int aspekNilai1, aspekNilai2, aspekNilai3;
            aspekNilai1 = (Integer) jSpinner1.getValue();
            aspekNilai2 = (Integer) jSpinner2.getValue();
            aspekNilai3 = (Integer) jSpinner3.getValue();
            System.out.println("Nilai " + aspekNilai1 + aspekNilai2 + aspekNilai3);
            int nilaiRataRata[] = {aspekNilai1, aspekNilai2, aspekNilai3};
            double nilaiRataDecimal = 0;
            for (int i = 0; i < nilaiRataRata.length; i++) {
                nilaiRataDecimal += Double.valueOf(nilaiRataRata[i]);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double nilaiRataFinal = nilaiRataDecimal / nilaiRataRata.length;
            System.out.println("Nilai rata-rata adalah " + df.format(nilaiRataFinal));
            double standarNilaiLulus = 80;

            JPanel panelInformasiNilai = getPanel();
            JPanel panelInformasiRataNilai = getPanel();
            JPanel panelIconNilai = getPanel();
            JLabel labelIcon = new JLabel();

            Font fontBold = new Font("Ubuntu", Font.BOLD, 13);
            Font fontPlain = new Font("Ubuntu", Font.PLAIN, 12);

            if (nilaiRataFinal >= standarNilaiLulus) {
                JLabel[] jLabel1 = {new JLabel("Alhamdulillah kamu lanjut ke halaman berikutnya, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), new JLabel(String.valueOf("= " + aspekNilai2)), new JLabel(String.valueOf("= " + aspekNilai3))};

                labelIcon.setIcon(alhamdulillahIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(jLabel1[0], c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);

                simpanNilaiLanjut();
                
                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Lanjut", JOptionPane.PLAIN_MESSAGE);
            } else {
                
                JLabel[] jLabel1 = {new JLabel("Maaf kamu masih harus mengulang lagi, "), new JLabel("nilai rata-rata kamu : " + df.format(nilaiRataFinal))};
                jLabel1[1].setFont(fontBold);
                nilai1.setFont(fontPlain);
                nilai2.setFont(fontPlain);
                nilai3.setFont(fontPlain);

                JLabel[] jLabelNilai = {new JLabel(String.valueOf("= " + aspekNilai1)), new JLabel(String.valueOf("= " + aspekNilai2)), new JLabel(String.valueOf("= " + aspekNilai3))};

                labelIcon.setIcon(afwanIcon);
                panelSoal1.add(jLabelNilai[0]);
                panelSoal2.add(jLabelNilai[1]);
                panelSoal3.add(jLabelNilai[2]);
                panelInformasiRataNilai.add(jLabel1[1]);
                panelIconNilai.add(labelIcon);

                panelInformasiNilai.setLayout(new GridBagLayout());
                GridBagConstraints c2 = new GridBagConstraints();
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 0;
                panelInformasiNilai.add(panelIconNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 1;
                panelInformasiNilai.add(jLabel1[0], c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 2;
                panelInformasiNilai.add(panelInformasiRataNilai, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(20, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 3;
                panelInformasiNilai.add(panelSoal1, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 4;
                panelInformasiNilai.add(panelSoal2, c2);
                c2.fill = GridBagConstraints.HORIZONTAL;
                c2.insets = new Insets(10, 0, 0, 0);  //top padding
                c2.gridx = 0;
                c2.gridy = 5;
                panelInformasiNilai.add(panelSoal3, c2);
                
                simpanNilaiMengulang();
                

                JOptionPane.showMessageDialog(null, panelInformasiNilai, "Mengulang", JOptionPane.PLAIN_MESSAGE);

            }
        }

    }

    private JPanel getPanel() {
        JPanel result = new JPanel();

        return result;
    }
    
    private void simpanNilaiLanjut() {
        String catatanPembelajaran = "Lanjut";
                try {                  
                    //Ambil data didatabase dulu
                    
                    java.sql.Timestamp timestamp;
                    String sqlQuery = "SELECT noPembelajaranSiswa, noInduk, namaLengkap, kodePembelajaran, namaPembelajaran, BiayaPembelajaran, userMadePembelajaranSiswa, tanggalDaftarPembelajaran FROM pembelajaran_siswa WHERE noPembelajaranSiswa = ?";
                    preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, (String) Pembelajaran.jComboBox7.getSelectedItem());
                    resultSet = preparedStatement.executeQuery();
                    

                    if (resultSet.next()) {
                        
                        resultSet.getString("noPembelajaranSiswa");
                        resultSet.getString("noInduk");
                        resultSet.getString("namaLengkap");
                        resultSet.getString("kodePembelajaran");
                        resultSet.getString("namaPembelajaran");
                        resultSet.getString("BiayaPembelajaran");
                        resultSet.getString("userMadePembelajaranSiswa");
                        
                    } 
                    timestamp = resultSet.getTimestamp("tanggalDaftarPembelajaran");
                    Date date1 = new java.util.Date(timestamp.getTime());
                    Date date = new Date();
                    String sqlQuery1 = "INSERT INTO pembelajaran_siswa (noPembelajaranSiswa, noInduk, namaLengkap, kodePembelajaran, namaPembelajaran, halamanPembelajaran, nilaiPembelajaran, catatanPembelajaran, tanggalPembelajaran, userMadeNilaiSiswa, BiayaPembelajaran, userMadePembelajaranSiswa, tanggalDaftarPembelajaran) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//                    connectionDatabase.connect();
                    preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery1);
                    preparedStatement.setString(1, resultSet.getString("noPembelajaranSiswa"));
                    preparedStatement.setString(2, resultSet.getString("noInduk"));
                    preparedStatement.setString(3, resultSet.getString("namaLengkap"));
                    preparedStatement.setString(4, resultSet.getString("kodePembelajaran"));
                    preparedStatement.setString(5, resultSet.getString("namaPembelajaran"));
                    
                    
                    preparedStatement.setString(6, Pembelajaran.jSpinner1.getValue().toString()); //halaman
                    
                    ArrayList<String> nilai = new ArrayList<>();
                    String levelUntukNilai = TPAAzkaAiniya.getNamaPembelajaranSiswa();
                    System.out.println("Level Siswa untuk nilai " + levelUntukNilai);
            switch (levelUntukNilai) {
                case "Iqra I":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    break;
                case "Iqra II":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    break;
                case "Iqra III":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    break;
                case "Iqra IV":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    nilai.add(jSpinner6.getValue().toString());
                    break;
                case "Iqra V":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    nilai.add(jSpinner6.getValue().toString());
                    nilai.add(jSpinner7.getValue().toString());
                    break;
                case "Iqra VI":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    nilai.add(jSpinner6.getValue().toString());
                    nilai.add(jSpinner7.getValue().toString());
                    nilai.add(jSpinner8.getValue().toString());
                    break;
                default:
                    break;
            }
                    
                    System.out.println("nilai dari Arraylist "+String.join(" ", nilai));
                    String listNilai = String.join(" ", nilai);
                    
                    preparedStatement.setString(7, listNilai); //nilai pembelajaran
                    preparedStatement.setString(8, catatanPembelajaran); //catatan pembelajaran
                    preparedStatement.setTimestamp(9, new java.sql.Timestamp(date.getTime())); //tanggal pembelajaran
                    preparedStatement.setString(10, Pembelajaran.jLabel1.getText()); //user made nilai
                    
                    preparedStatement.setString(11, resultSet.getString("BiayaPembelajaran"));
                    preparedStatement.setString(12, resultSet.getString("userMadePembelajaranSiswa"));
                    preparedStatement.setTimestamp(13, new java.sql.Timestamp(date1.getTime())); //tanggal mulai pembelajaran
                    
//                    preparedStatement.setString(6, (String) Pembelajaran.jComboBox7.getSelectedItem()); //pembelajaran 
                    preparedStatement.executeUpdate();
                    
                }catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error gagal simpan nilai " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
    }
    
    private void simpanNilaiMengulang() {
        String catatanPembelajaran = "Mengulang";
                try {                  
                    //Ambil data didatabase dulu
                    
                    java.sql.Timestamp timestamp;
                    String sqlQuery = "SELECT noPembelajaranSiswa, noInduk, namaLengkap, kodePembelajaran, namaPembelajaran, BiayaPembelajaran, userMadePembelajaranSiswa, tanggalDaftarPembelajaran FROM pembelajaran_siswa WHERE noPembelajaranSiswa = ?";
                    preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, TPAAzkaAiniya.getNamaPembelajaranSiswa());
                    resultSet = preparedStatement.executeQuery();
                    

                    if (resultSet.next()) {
                        
                        resultSet.getString("noPembelajaranSiswa");
                        resultSet.getString("noInduk");
                        resultSet.getString("namaLengkap");
                        resultSet.getString("kodePembelajaran");
                        resultSet.getString("namaPembelajaran");
                        resultSet.getString("BiayaPembelajaran");
                        resultSet.getString("userMadePembelajaranSiswa");
                        
                    } 
                    timestamp = resultSet.getTimestamp("tanggalDaftarPembelajaran");
                    Date date1 = new java.util.Date(timestamp.getTime());
                    Date date = new Date();
                    String sqlQuery1 = "INSERT INTO pembelajaran_siswa (noPembelajaranSiswa, noInduk, namaLengkap, kodePembelajaran, namaPembelajaran, halamanPembelajaran, nilaiPembelajaran, catatanPembelajaran, tanggalPembelajaran, userMadeNilaiSiswa, BiayaPembelajaran, userMadePembelajaranSiswa, tanggalDaftarPembelajaran) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//                    connectionDatabase.connect();
                    preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery1);
                    preparedStatement.setString(1, resultSet.getString("noPembelajaranSiswa"));
                    preparedStatement.setString(2, resultSet.getString("noInduk"));
                    preparedStatement.setString(3, resultSet.getString("namaLengkap"));
                    preparedStatement.setString(4, resultSet.getString("kodePembelajaran"));
                    preparedStatement.setString(5, resultSet.getString("namaPembelajaran"));
                    
                    
                    preparedStatement.setString(6, Pembelajaran.jSpinner1.getValue().toString()); //halaman
                    
                    ArrayList<String> nilai = new ArrayList<>();
                    String levelUntukNilai = TPAAzkaAiniya.getNamaPembelajaranSiswa();
                    System.out.println("Level Siswa untuk nilai " + levelUntukNilai);
            switch (levelUntukNilai) {
                case "Iqra I":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    break;
                case "Iqra II":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    break;
                case "Iqra III":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    break;
                case "Iqra IV":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    nilai.add(jSpinner6.getValue().toString());
                    break;
                case "Iqra V":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    nilai.add(jSpinner6.getValue().toString());
                    nilai.add(jSpinner7.getValue().toString());
                    break;
                case "Iqra VI":
                    nilai.add(jSpinner1.getValue().toString());
                    nilai.add(jSpinner2.getValue().toString());
                    nilai.add(jSpinner3.getValue().toString());
                    nilai.add(jSpinner4.getValue().toString());
                    nilai.add(jSpinner5.getValue().toString());
                    nilai.add(jSpinner6.getValue().toString());
                    nilai.add(jSpinner7.getValue().toString());
                    nilai.add(jSpinner8.getValue().toString());
                    break;
                default:
                    break;
            }
                    
                    System.out.println("nilai dari Arraylist "+String.join(" ", nilai));
                    String listNilai = String.join(" ", nilai);
                    
                    preparedStatement.setString(7, listNilai); //nilai pembelajaran
                    preparedStatement.setString(8, catatanPembelajaran); //catatan pembelajaran
                    preparedStatement.setTimestamp(9, new java.sql.Timestamp(date.getTime())); //tanggal pembelajaran
                    preparedStatement.setString(10, Pembelajaran.jLabel1.getText()); //user made nilai
                    preparedStatement.setString(11, resultSet.getString("BiayaPembelajaran"));
                    preparedStatement.setString(12, resultSet.getString("userMadePembelajaranSiswa"));
                    preparedStatement.setTimestamp(13, new java.sql.Timestamp(date1.getTime())); //tanggal mulai pembelajaran
                    preparedStatement.executeUpdate();
                    
                }catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error gagal simpan nilai " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
    }
    
    public void namaSiswaUntukSPP() throws SQLException, ParseException {
        
        String tampilRupiah ="";
        String e = "";
        ArrayList listData = new ArrayList();
        connectionDatabase.connect();
        String sqlQuery = "SELECT `noInduk`, `namaLengkap`, `namaPembelajaran`, `tanggalDaftarPembelajaran`, `biayaPembelajaran` FROM `pembelajaran_siswa`";
        preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
        resultSet = preparedStatement.executeQuery();
        
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Pilih Siswa", TitledBorder.CENTER, TitledBorder.TOP));

        DefaultTableModel model = new DefaultTableModel(new String[]{"No Induk", "Nama Lengkap", "Nama Pembelajaran", "Daftar Pembelajaran", "Biaya Pembelajaran"}, 0);
        
        while (resultSet.next()) {
            String a = resultSet.getString("noInduk");
            String b = resultSet.getString("namaLengkap");
            String c = resultSet.getString("namaPembelajaran");
            String d = resultSet.getString("tanggalDaftarPembelajaran");
            e = resultSet.getString("biayaPembelajaran");
            model.addRow(new Object[]{a, b, c, d, e});
            tampilRupiah = numberFormat.format(new BigDecimal(e));
//            String f = TPAAzkaAiniya.setPembelajaranBiaya(resultSet.getString("biayaPembelajaran"));
            
        }
        
        table = new JTable(model) {

            @Override
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                realColumnIndex = convertColumnIndexToModel(colIndex);

                if (realColumnIndex == 1) {
                    tip = "Klik 2 kali atau Klik OK untuk membayar SPP : "
                            + getValueAt(rowIndex, colIndex);
                } 
                return tip;
            }

            ;

      @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        
        //Add listener double click
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {     // detect double click events
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column

                    TPAAzkaAiniya laundry = new TPAAzkaAiniya();

                    if (column == 0) { //gw cuma ambil logic berdasarkan kolom
                        int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit Kode Pembelajaran " + table.getValueAt(row, column) + "?", "Konfirmasi edit pembelajaran", JOptionPane.YES_NO_OPTION);
                        TPAAzkaAiniya.setKodePembelajaran((String) table.getValueAt(row, column)); //table.getValueAt(row, column)
                        System.out.println(input + " " + TPAAzkaAiniya.getKodePembelajaran());
                        try {
                            showDataPembelajaranByKodePembelajaran();
                            Window win = SwingUtilities.getWindowAncestor(panel);
                            win.setVisible(false);
                        } catch (SQLException ex) {
                            Logger.getLogger(TPAAzkaAiniya.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        int input = JOptionPane.showConfirmDialog(null, "Yakin ingin edit Nama Pembelajaran " + table.getValueAt(row, column) + "?", "Konfirmasi edit pembelajaran", JOptionPane.YES_NO_OPTION);
                        TPAAzkaAiniya.setNamaPembelajaran((String) table.getValueAt(row, column));
                        System.out.println(input + " " + TPAAzkaAiniya.getNamaPembelajaran());
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
        
        
               
        panel.add(new JScrollPane(table));
        String[] options = new String[]{"    OK    ", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Pilih Pembelajaran", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {
            int row = table.getSelectedRow();
            int column = table.getColumnCount();
            for(int i = 0; i < column; i++) {
//                System.out.println("Data manual "+table.getValueAt(row, i));
                listData.add(table.getValueAt(row, i)+ " ");
                 
                }
            listData.forEach(System.out::println);
            String firstElement = listData.get(0).toString();
            
            
            String [] str = GetStringArray(listData);
            System.out.println("No Induk " + str[0] );
            SimpleDateFormat formatter3=new SimpleDateFormat("MM dd, yyyy");
////            Date date3=formatter3.parse(str[3]);
//            String strDate = formatter3.format(date3); 

            amount = Double.parseDouble(str[4]);
            tampilRupiah = numberFormat.format(new BigDecimal(amount));
            String [] tanggalAja = str[3].split(" ");
            SPP.jTextField1.setText(str[0]);
            SPP.jTextField2 .setText(str[1]);
            SPP.jTextField3.setText(str[2]);
            SPP.jTextField4.setText(tanggalAja[0]); 
            SPP.jTextField5.setText("Rp" +tampilRupiah+",00");
            SPP.jButton2.setEnabled(true);
            SPP.jTextField9.setText(str[0]);
            SPP.jTextField10 .setText(str[1]);
            SPP.jTextField6.setText(str[2]); 
            SPP.jTextField7.setText("Rp" +tampilRupiah+",00");
            
            System.out.println("str[4]" + str[4]);
            
            TPAAzkaAiniya.setPembelajaranBiaya(str[4]); 
            
            SPP.jLabel18.setText("Rp" +tampilRupiah+",00");
            SPP.jSpinner1.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent arg0) {
                    
                    int total = (Integer) SPP.jSpinner1.getValue();
                    amoun = amount * total;
                    String tampilRupiah = numberFormat.format(new BigDecimal(amoun));
                    System.out.println("amount "+ "Rp"+tampilRupiah+",00");
                    SPP.jLabel18.setText("Rp" +tampilRupiah+",00");
                    
                    }
            });
            } 
    }
    
    
    public void PembayaranSPP() throws JRException {
        try {

            String sqlQuery = ("insert into spp_siswa (noInduk, namaLengkap, namaPembelajaran, biayaPembelajaran, banyakSppPerBulan, totalBayar, userMadePembelajaran) values (?, ?, ?, ?, ?, ?, ?)");
            connectionDatabase.connect();
            preparedStatement = connectionDatabase.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, SPP.jTextField9.getText());
            preparedStatement.setString(2, SPP.jTextField10.getText());
            preparedStatement.setString(3, SPP.jTextField6.getText());
            String biayaPembelajaran = TPAAzkaAiniya.getPembelajaranBiaya();
            preparedStatement.setString(4, biayaPembelajaran);
            int total = (Integer) SPP.jSpinner1.getValue();
            preparedStatement.setInt(5, total);
            amoun = amount * total;
            preparedStatement.setDouble(6, amoun); 
            preparedStatement.setString(7, SPP.jLabel1.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Yeah, SPP Siswa berhasil dibayar ...", "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
            
            JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\src\\tpaazkaainiya\\output\\BuktiBayar.jrxml");
            
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            
            JasperPrint jPrint = JasperFillManager.fillReport(jReport,null ,connectionDatabase.connect());
            JasperViewer.viewReport(jPrint, false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void tabelLaporanDataSiswa(JTable table, String query) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            
            connectionDatabase.connect();
            Statement stat = connectionDatabase.connect().createStatement();
            ResultSet rs = stat.executeQuery(query);
//            String sqlQuery = "SELECT `noInduk`, `namaLengkap`, `jenisKelamin`, `tempatLahir`, `namaAyah`, `namaIbu`, `alamatLengkap` FROM `siswa`";
//            preparedStatement = connectionDatabase.connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
            
            //To remove previously added rows
            while (table.getRowCount() > 0) {
                model.removeRow(0);
            }
            
            
            
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object [] row = new Object[columns];
                for (int i = 1; i< columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
//                model.setDataVector(dataVector, row);
                model.insertRow(resultSet.getRow()-1,row);
            }
            
            rs.close();
            stat.close();
            connectionDatabase.connect().close();
        } catch (SQLException e) {
        }
        
    }
    
    public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {       
            return false; // or a condition at your choice with row and column
   }
        };

        //Retrieve meta data from ResultSet
        ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = metaData.getColumnCount();

        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];

        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
        }
        
        

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel);
//        table.setEnabled(false); 
    }
    
    public void cetakBiodataSiswa() throws JRException, SQLException {
        TPAAzkaAiniya tpaAzkaAiniya = new TPAAzkaAiniya();
        String noInduk = tpaAzkaAiniya.getNoInduk();
        System.out.println("Nilai nomor Induk Siswa di getNoInduk adalah : " + tpaAzkaAiniya.getNoInduk());
        
        HashMap param = new HashMap();
        param.put("noIndukSiswa", noInduk);
        JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\src\\tpaazkaainiya\\output\\DataSiswa.jrxml");
 
        JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            
        JasperPrint jPrint = JasperFillManager.fillReport(jReport,param ,connectionDatabase.connect());
        JasperViewer.viewReport(jPrint, false);
    }

}
