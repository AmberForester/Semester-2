package PemrogramanBerorientasiObjek.PraktikumPBO;

// import javax.swing.Action;
// import javax.swing.JButton;
// import javax.swing.JCheckBoxMenuItem;
// import javax.swing.JComboBox;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextField;
// import javax.swing.border.BevelBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import PemrogramanBerorientasiObjek.KelasRegulerPBO.A;

public class Gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form coba ajahh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        frame.setLayout(null);
        // panel.setBounds(10, 10, 670,350);
        // panel.setBorder(new BevelBorder(BevelBorder.RAISED));
        // frame.add(panel);
        
        JLabel kodeBarang = new JLabel("Kode Barang");
        kodeBarang.setBounds(50, 50, 200, 25);
        frame.add(kodeBarang);
        JTextField textBox = new JTextField();
        textBox.setBounds(150, 50, 200, 25);
        frame.add(textBox);

        JLabel nama = new JLabel("Nama");
        nama.setBounds(50, 80, 200, 25);
        frame.add(nama);
        JTextField textBoxNama = new JTextField();
        textBoxNama.setBounds(150, 80, 200, 25);
        frame.add(textBoxNama);

        JLabel satuan = new JLabel("Satuan");
        satuan.setBounds(50, 110, 200, 25);
        frame.add(satuan);
        String[] listSatuan = {"Pcs", "Kg", "Unit", "Liter", "Lusin"};
        JComboBox daftarSatuan = new JComboBox<>(listSatuan);
        daftarSatuan.setBounds(150, 110, 100, 25);
        frame.add(daftarSatuan);
        
        JLabel hargaBeli = new JLabel("Harga Beli");
        hargaBeli.setBounds(50, 140, 200, 25);
        frame.add(hargaBeli);
        JTextField textBoxHargaBeli = new JTextField();
        textBoxHargaBeli.setBounds(150, 140, 200, 25);
        frame.add(textBoxHargaBeli);

        JLabel HargaJual = new JLabel("Harga Jual");
        HargaJual.setBounds(50, 170, 200, 25);
        frame.add(HargaJual);
        JTextField textBoxHargaJual = new JTextField();
        textBoxHargaJual.setBounds(150, 170, 200, 25);
        frame.add(textBoxHargaJual);

        JButton tambah = new JButton("Tambah");
        tambah.setBounds(50, 250, 80, 25);
        frame.add(tambah);

        JButton Ubah = new JButton("Ubah");
        Ubah.setBounds(135, 250, 80, 25);
        frame.add(Ubah);

        JButton simpan = new JButton("Simpan");
        simpan.setBounds(220, 250, 80, 25);
        frame.add(simpan);

        JButton hapus = new JButton("Hapus");
        hapus.setBounds(305, 250, 80, 25);
        frame.add(hapus);

        JButton batal = new JButton("Batal");
        batal.setBounds(390, 250, 80, 25);
        frame.add(batal);

        JButton keluar = new JButton("Keluar");
        keluar.setBounds(550, 250, 80, 25);
        frame.add(keluar);

        JLabel hasil = new JLabel("hasil");
        hasil.setBounds(50, 400, 200, 25);
        frame.add(hasil);

        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String kode = textBox.getText();
                String satuan = daftarSatuan.getSelectedItem().toString();
                hasil.setText(kode+ " " + satuan);
            }
        });
        
    }
}
