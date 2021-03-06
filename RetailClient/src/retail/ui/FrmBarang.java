/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retail.ui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import retail.config.Config;
import retail.dao.api.IBarangDao;
import retail.model.Barang;

/**
 *
 * @author Amikom
 */
public class FrmBarang extends javax.swing.JInternalFrame {

    private final Object[] columnNames = {"No","Kode",
                                "Nama","Hrga Beli",
                                "Harga Jual","Stok"};
    
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private List<Barang> recordBarang = new ArrayList<>();
    private IBarangDao barangDao = null;
    private boolean isTambahData = true;
    /**
     * Creates new form FrmBarang
     */
    public FrmBarang() {
        initComponents();
        initTable();
        initBarangDao();
        loadRecordBarang();
    }

    private void initTable(){
        tableModel.setColumnIdentifiers(columnNames);
        tblBarang.setModel(tableModel);
        tblBarang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void initBarangDao(){
        String url = "rmi://"+ Config.ip_server + ":1099/brgDao";
        try {
            barangDao = (IBarangDao) Naming.lookup(url);
        } catch (NotBoundException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,"Koneksi ke service "+url+"[Gagal]: cek kembali aplikasi server", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void loadRecordBarang(){
        try {
            tableModel.setRowCount(0);
            recordBarang = barangDao.getAll();
            for (Barang barang: recordBarang) {
                fillToTable(true, barang);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    private void loadRecordBarangbyName(String namaBarang){
        try {
            tableModel.setRowCount(0);
            recordBarang = barangDao.getByName(namaBarang);
            for (Barang barang: recordBarang) {
                fillToTable(true, barang);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillToTable(boolean isTambahData, Barang barang){
        if (isTambahData) {
            int noUrut = tableModel.getRowCount()+1;
            Object[] objects = new Object[columnNames.length];
            objects[0]= noUrut;
            objects[1]= barang.getKodeBarang();
            objects[2]= barang.getNamaBarang();
            objects[3]= barang.getHargaBeli();
            objects[4]= barang.getHargaJual();
            objects[5]= barang.getStok();
            tableModel.addRow(objects);
        }else{
            int row = tblBarang.getSelectedRow();
            tableModel.setValueAt(barang.getKodeBarang(), row, 1);
            tableModel.setValueAt(barang.getNamaBarang(), row, 2);
            tableModel.setValueAt(barang.getHargaBeli(), row, 3);
            tableModel.setValueAt(barang.getHargaJual(), row, 4);
            tableModel.setValueAt(barang.getStok(), row, 5);
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

        frmAddEditBarang = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtBeli = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        btnSelesai = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnPerbaiki = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Harga Beli");

        jLabel5.setText("Harga Jual");

        jLabel6.setText("Stok");

        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmAddEditBarangLayout = new javax.swing.GroupLayout(frmAddEditBarang.getContentPane());
        frmAddEditBarang.getContentPane().setLayout(frmAddEditBarangLayout);
        frmAddEditBarangLayout.setHorizontalGroup(
            frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmAddEditBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmAddEditBarangLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frmAddEditBarangLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmAddEditBarangLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmAddEditBarangLayout.createSequentialGroup()
                        .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStok, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(txtHarga)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmAddEditBarangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelesai)))
                .addContainerGap())
        );
        frmAddEditBarangLayout.setVerticalGroup(
            frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmAddEditBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmAddEditBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelesai)
                    .addComponent(btnSimpan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCari)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCari))
                .addContainerGap())
        );

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnPerbaiki.setText("Perbaiki");
        btnPerbaiki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaikiActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addGap(18, 18, 18)
                                .addComponent(btnPerbaiki)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnPerbaiki)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        loadRecordBarangbyName(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        isTambahData = true;
        txtKode.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtBeli.setText("");
        txtStok.setText("");
        
        txtKode.setEnabled(true);
        txtKode.requestFocus();
        
        frmAddEditBarang.pack();
        frmAddEditBarang.setLocationRelativeTo(this);
        frmAddEditBarang.setModal(true);
        frmAddEditBarang.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnPerbaikiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaikiActionPerformed
        // TODO add your handling code here:
        int row = tblBarang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,"Data Barang belum dipilih",
                    "Peringatan",JOptionPane.WARNING_MESSAGE);
        }else{
            isTambahData = false;
            Barang barang = recordBarang.get(row);
            
        txtKode.setText(barang.getKodeBarang());
        txtNama.setText(barang.getNamaBarang());
        txtHarga.setText(Integer.toString(barang.getHargaJual()));
        txtBeli.setText(Integer.toString(barang.getHargaBeli()));
        txtStok.setText(Integer.toString(barang.getStok()));
                
        txtKode.setEnabled(false);
        txtNama.requestFocus();
        
        frmAddEditBarang.pack();
        frmAddEditBarang.setLocationRelativeTo(this);
        frmAddEditBarang.setModal(true);
        frmAddEditBarang.setVisible(true);
        }
    }//GEN-LAST:event_btnPerbaikiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = tblBarang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,"Data Barang belum dipilih",
                    "Peringatan",JOptionPane.WARNING_MESSAGE);
        }else{
            Barang barang = recordBarang.get(row);
            int result=JOptionPane.showConfirmDialog(this,
                    "Apakah data barang '"+barang.getNamaBarang()+"' Ingin dihapus?",
                    "Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            
            if (result == JOptionPane.YES_OPTION) {
                try {
                    result = barangDao.delete(barang);
                    if (result > 0) {
                        tableModel.removeRow(row);
                        recordBarang.remove(barang);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Barang barang = new Barang();
        barang.setKodeBarang(txtKode.getText());
        barang.setNamaBarang(txtNama.getText());
        barang.setHargaBeli(Integer.parseInt(txtBeli.getText()));
        barang.setHargaJual(Integer.parseInt(txtHarga.getText()));
        barang.setStok(Integer.parseInt(txtStok.getText()));
        try {
            int hasil = 0;
            if (isTambahData) { // input data baru
                hasil = barangDao.save(barang);
                if (hasil > 0) {
                    // tampilkan pesan berhasil
                    JOptionPane.showMessageDialog(frmAddEditBarang, "Data barang berhasil disimpan","Informasi", JOptionPane.INFORMATION_MESSAGE);
                    // tambahkan data barang ke tabel
                    fillToTable(isTambahData, barang);
                    // tambahkan data barang ke list
                    recordBarang.add(barang);
                    // reset form input
                    txtKode.setText("");
                    txtNama.setText("");
                    txtHarga.setText("");
                    txtBeli.setText("");
                    txtStok.setText("");
                    txtKode.requestFocus();
                }
            } else { // update data yg sudah ada
                hasil = barangDao.update(barang);
                if (hasil > 0) {
                    // tampilkan pesan berhasil
                    JOptionPane.showMessageDialog(frmAddEditBarang, "Data barang berhasil disimpan","Informasi", JOptionPane.INFORMATION_MESSAGE);
                    // update data barang yang ada di tabel
                    fillToTable(isTambahData, barang);
                    // ambil baris barang yang diperbaiki
                    int row = tblBarang.getSelectedRow();
                    // update data barang yang ada di list
                    recordBarang.set(row, barang);
                    // tutup dialog edit data
                    frmAddEditBarang.setVisible(false);
                }
            }
        } catch (RemoteException ex) {
        Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        frmAddEditBarang.setVisible(false);
    }//GEN-LAST:event_btnSelesaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPerbaiki;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JDialog frmAddEditBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtBeli;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
