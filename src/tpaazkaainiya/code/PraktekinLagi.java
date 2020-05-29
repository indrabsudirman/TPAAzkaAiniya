/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya.code;

/**
 *
 * @author Jabrikos
 */
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PraktekinLagi {

    private String [] titleString = new String[] {"<html><FONT COLOR=BLUE>Soal No 1</FONT></html>",
            "<html><FONT COLOR=BLUE>Soal No 2</FONT></html>",
            "<html><FONT COLOR=BLUE>Soal No 3</FONT></html>",
            "<html><FONT COLOR=BLUE>Soal No 4</FONT></html>",
            "<html><FONT COLOR=BLUE>Soal No 5</FONT></html>",
            "<html><FONT COLOR=GREEN>Periksa Jawaban</FONT></html>",
            "<html><FONT COLOR=RED>Nilai</FONT></html>"};
    private Border loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    //private LayoutStyle

    private String [] semuaSoal = new String[]
            {"Siapakah nama Presiden RI ke I ?",
                    "Siapakah nama Presiden RI ke II ?",
                    "Siapakah nama Presiden RI ke III ?",
                    "Siapakah nama Presiden RI ke IV ?",
                    "Siapakah nama Presiden RI ke V ?"};

    private String [] semuaJawaban = new String[]
            {"Soekarno",
                    "Soeharto",
                    "B. J Habibie",
                    "Abdurrahman Wahid",
                    "Megawati Soekarno Putri"};

    private String [] koreksiJawaban = new String[]
            {"<html><FONT COLOR=RED> &#10004</FONT></html>", //checklist benar
                    "<html><FONT COLOR=RED> &#10006</FONT></html>"}; //cross salah

    private JLabel soalNo1 = new JLabel(semuaSoal[0], JLabel.CENTER);
    private JLabel soalNo2 = new JLabel(semuaSoal[1], JLabel.CENTER);
    private JLabel soalNo3 = new JLabel(semuaSoal[2], JLabel.CENTER);
    private JLabel soalNo4 = new JLabel(semuaSoal[3], JLabel.CENTER);
    private JLabel soalNo5 = new JLabel(semuaSoal[4], JLabel.CENTER);
    private  JLabel koreksiSoal1 = new JLabel(" ");
    private  JLabel koreksiSoal2 = new JLabel(" ");
    private  JLabel koreksiSoal3 = new JLabel(" ");
    private  JLabel koreksiSoal4 = new JLabel(" ");
    private  JLabel koreksiSoal5 = new JLabel(" ");
    private  JLabel salah = new JLabel("");
    private JLabel nilaiAnda1 = new JLabel("", JLabel.CENTER);
    private JLabel nilaiAnda2 = new JLabel("", JLabel.CENTER);
    private JLabel nilaiAnda3 = new JLabel("", JLabel.CENTER);
    private JLabel nilaiAnda4 = new JLabel("", JLabel.CENTER);
    private JLabel nilaiAnda5 = new JLabel("", JLabel.CENTER);
    private JTextField ketikJawaban1 = new JTextField(15);
    private JTextField ketikJawaban2 = new JTextField(15);
    private JTextField ketikJawaban3 = new JTextField(15);
    private JTextField ketikJawaban4 = new JTextField(7);
    private JTextField ketikJawaban5 = new JTextField(15);
    private JButton cekJawaban = new JButton("<html><FONT COLOR=GREEN> Cek Jawaban</FONT></html>");
    private  JButton ulangiJawaban = new JButton("<html><FONT COLOR=GREEN> Ulangi Jawaban</FONT></html>");


    public static void main (String [] args)
    {
        PraktekinLagi praktekinLagi = new PraktekinLagi(args);
        praktekinLagi.go();
    }



    private PraktekinLagi(String... args) {

    }

    private void go() {
        JFrame mainFrame = new JFrame("Kuis GUI dengan Java Swing, selesai 22 Mart");
        //mainFrame.setSize(800,600);






        TitledBorder titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[0], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
        Border borderSisiKosong = BorderFactory.createEmptyBorder(10,10,10,10);

//        GridBagConstraints bagConstraints = new GridBagConstraints();
//        bagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;

        JPanel panelSoal1 = getPanel();
        panelSoal1.setBorder(titledBorder);
        panelSoal1.add(soalNo1);
        // panelSoal1.setLayout(new GridBagLayout());
        //GridBagConstraints gbcPanelSoal1 = new GridBagConstraints();

        panelSoal1.add(ketikJawaban1);
        panelSoal1.add(koreksiSoal1);//, gbcPanelSoal1);
        //panelSoal1.add(salah,gbcPanelSoal1);


        JPanel panelSoal2 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[1], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
        panelSoal2.add(soalNo2);
        panelSoal2.setBorder(titledBorder);
//        panelSoal2.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.weightx = 1f;
        //panelSoal2.setLayout(new GridBagLayout());
        //GridBagConstraints gbcPanelSoal2 = new GridBagConstraints();

        panelSoal2.add(ketikJawaban2);
        panelSoal2.add(koreksiSoal2);
        //panelSoal2.add(salah, gbcPanelSoal2);


        JPanel panelSoal3 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[2], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
        panelSoal3.add(soalNo3);
        panelSoal3.setBorder(titledBorder);
        // panelSoal3.setLayout(new GridBagLayout());

        panelSoal3.add(ketikJawaban3);
        panelSoal3.add(koreksiSoal3);
        //  panelSoal3.add(salah, bagConstraints);


        JPanel panelSoal4 = getPanel();
        panelSoal4.setPreferredSize(new Dimension(100, 53));
        panelSoal4.setMaximumSize(new Dimension(100, 53));
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[3], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
//        panelSoal4.add(soalNo4);
        panelSoal4.setBorder(titledBorder);
        // panelSoal4.setLayout(new GridBagLayout());


        panelSoal4.add(ketikJawaban4);
        panelSoal4.add(koreksiSoal4);
        //  panelSoal4.add(salah, bagConstraints);



        JPanel panelSoal5 = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[4], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
        panelSoal5.add(soalNo5);
        panelSoal5.setBorder(titledBorder);
        //panelSoal5.setLayout(new GridBagLayout());


        panelSoal5.add(ketikJawaban5);
        panelSoal5.add(koreksiSoal5);

        // panelSoal5.add(betul, bagConstraints);


        JPanel panelCekJawaban = getPanel();
        titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[5], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
        panelCekJawaban.setBorder(titledBorder);
        panelCekJawaban.add(cekJawaban);
        panelCekJawaban.add(ulangiJawaban);
        cekJawaban.addActionListener((ActionEvent e) -> {
            //System.out.println("Anda Click Cek Jawaban");
            periksaJawaban();
        });

        ulangiJawaban.addActionListener((ActionEvent actionEvent) -> {
            bersihkanJawaban();
        });

//        JPanel panelNilai = getPanel();
//        titledBorder = BorderFactory.createTitledBorder(loweredEtched, titleString[6], TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
//        panelNilai.setBorder(titledBorder);
//        panelNilai.setLayout(new GridBagLayout());
//
//        GridBagConstraints jarakNya = new GridBagConstraints();
//        jarakNya.insets = new Insets(0,0,1,0);
//
//
//
//        panelNilai.add(nilaiAnda1);
//        jarakNya.gridx = 0;
//        jarakNya.gridy = 1;
//        panelNilai.add(nilaiAnda2, jarakNya);
//        jarakNya.gridx = 0;
//        jarakNya.gridy = 2;
//        panelNilai.add(nilaiAnda3, jarakNya);
//        jarakNya.gridx = 0;
//        jarakNya.gridy = 3;
//        panelNilai.add(nilaiAnda4, jarakNya);
//
//        jarakNya.insets = new Insets(0,0,10,0);
//        jarakNya.gridx = 0;
//        jarakNya.gridy = 4;
//
//        panelNilai.add(nilaiAnda5, jarakNya);


        
        GridLayout gridLayout = new GridLayout(0,2);
        JPanel panelSemuaSoal = new JPanel();
        panelSemuaSoal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        //panelSemuaSoal.setLayout(new GridBagLayout());
        panelSemuaSoal.setBorder(borderSisiKosong);
        panelSemuaSoal.add(panelSoal1,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        panelSemuaSoal.add(panelSoal2,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        panelSemuaSoal.add(panelSoal3, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        panelSemuaSoal.add(panelSoal4, c);
        panelSemuaSoal.add(panelSoal5);
        panelSemuaSoal.add(panelCekJawaban);
//        panelSemuaSoal.add(panelNilai);





        mainFrame.add(panelSemuaSoal, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void bersihkanJawaban() {
        ketikJawaban1.setText("");
        ketikJawaban2.setText("");
        ketikJawaban3.setText("");
        ketikJawaban4.setText("");
        ketikJawaban5.setText("");
        koreksiSoal1.setText("");
        koreksiSoal2.setText("");
        koreksiSoal3.setText("");
        koreksiSoal4.setText("");
        koreksiSoal5.setText("");
        nilaiAnda1.setText("");
        nilaiAnda2.setText("");

    }

    private void periksaJawaban() {
        //ArrayList listJawabanSalah = new ArrayList();
        int[] pointJawaban =  new int[5];

        if (ketikJawaban1.getText().equalsIgnoreCase(semuaJawaban[0])) {
            pointJawaban[0] = 20;

            koreksiSoal1.setText(koreksiJawaban[0]);
            //nilaiAnda1.setText("Jawaban No 1 Benar, Point Anda " + pointJawaban[0]);
        } else {
            koreksiSoal1.setText(koreksiJawaban[1]);
        }

        if (ketikJawaban2.getText().equalsIgnoreCase(semuaJawaban[1])) {
            pointJawaban[1] = 20;
            koreksiSoal2.setText(koreksiJawaban[0]);
            //nilaiAnda2.setText("Jawaban No 2 Benar, Point Anda " + pointJawaban[1]);
        } else {
            koreksiSoal2.setText(koreksiJawaban[1]);
        }

        if (ketikJawaban3.getText().equalsIgnoreCase(semuaJawaban[2])) {
            pointJawaban[2] = 20;
            koreksiSoal3.setText(koreksiJawaban[0]);
            //nilaiAnda3.setText("Jawaban No 3 Benar, Point Anda " + pointJawaban[2]);
        } else {
            koreksiSoal3.setText(koreksiJawaban[1]);
        }

        if (ketikJawaban4.getText().equalsIgnoreCase(semuaJawaban[3])) {
            pointJawaban[3] = 20;
            koreksiSoal4.setText(koreksiJawaban[0]);
            //nilaiAnda4.setText("Jawaban No 4 Benar, Point Anda " + pointJawaban[3]);
        } else {
            koreksiSoal4.setText(koreksiJawaban[1]);
        }

        if (ketikJawaban5.getText().equalsIgnoreCase(semuaJawaban[4])) {
            pointJawaban[4] = 20;
            koreksiSoal5.setText(koreksiJawaban[0]);
            //nilaiAnda5.setText("Jawaban No 5 Benar, Point Anda " + pointJawaban[4]);
        } else {
            koreksiSoal5.setText(koreksiJawaban[1]);
        }

        int totalPointJawaban = IntStream.of(pointJawaban).sum();
        nilaiAnda1.setText("Nilai Anda = ");
        nilaiAnda2.setText(Integer.toString(totalPointJawaban));
        nilaiAnda1.setForeground(Color.RED);
        nilaiAnda2.setForeground(Color.RED);

    }

    //private boolean cekJawabanSoal1() {
    //   String jawabanNo1 = ketikJawaban1.getText(semuaJawaban[0]);
    //  return jawabanNo1.getText().equalsIgnoreCase(semuaJawaban[0]);
    //}

    private JPanel getPanel() {
        JPanel result = new JPanel();



        return result;
    }
    
//      private JPanel getPanel2() {
//        JPanel result = new JPanel( new Dimension(50, 400));
//
//        return result;
//    }

}
