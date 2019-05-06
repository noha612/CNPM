/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.DiemDAO;
import Model.Diem;
import Model.GiangVien;
import Model.LopHocPhan;
import Model.MonHoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author TaDuyHieu
 */
public class NhapDiemFrm extends javax.swing.JFrame implements ActionListener{

    private DanhSachLHPFrm parent;
    private ArrayList<Diem> listStudent;
    private String kyHoc;
    int idSubject;
    private LopHocPhan LHP;
    private MonHoc MH;
    private GiangVien GV;
    public NhapDiemFrm(GiangVien GV, LopHocPhan LHP, MonHoc MH, String kyHoc,  DanhSachLHPFrm parent) {        
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.kyHoc = kyHoc;
        this.MH = MH;
        this.GV = GV;
        this.parent = parent;
        DiemDAO sv = new DiemDAO();
        btnBack.addActionListener(this);
        btnSave.addActionListener(this);
        this.listStudent = sv.getSinhVienTheoLHP(LHP);
        int index = 0;
        for (Diem a : this.listStudent) {
            this.listStudent.get(index).setKyHoc(Integer.parseInt(kyHoc));
            this.listStudent.get(index).setIdMonHoc(this.MH.getMonHocId());
            index++;
        }
        tableNhapDiem.setRowHeight(25);
        TableColumn col = tableNhapDiem.getColumnModel().getColumn(0);
        col.setPreferredWidth(5);
        col = tableNhapDiem.getColumnModel().getColumn(1);
        col.setPreferredWidth(10);
        col = tableNhapDiem.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        col = tableNhapDiem.getColumnModel().getColumn(3);
        col.setPreferredWidth(10);
        col = tableNhapDiem.getColumnModel().getColumn(4);
        col.setPreferredWidth(10);
        col = tableNhapDiem.getColumnModel().getColumn(5);
        col.setPreferredWidth(10);
        col = tableNhapDiem.getColumnModel().getColumn(6);
        col.setPreferredWidth(10);
        col = tableNhapDiem.getColumnModel().getColumn(7);
        col.setPreferredWidth(10);
        HienThiSinhVien();
    }
    
    public NhapDiemFrm(){
        initComponents(); 
    }
    
    public void HienThiSinhVien(){
        DefaultTableModel m = (DefaultTableModel) tableNhapDiem.getModel();
        m.getDataVector().removeAllElements();
        int index = 1;
        for (Diem a : this.listStudent) {
            Object[] sinhvien;
            sinhvien = a.toObject(index);
            m.addRow(sinhvien);
            index++;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton btnClicked = (JButton) ae.getSource();
        if(btnClicked.equals(btnBack)){
            btnBackClick();
            return;
        }
        if(btnClicked.equals(btnSave)){
            btnSaveClick();
            return;
        }
        
    }
    
    private void btnBackClick(){
        parent.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    private void btnSaveClick(){
        int index = 1;
        for (Diem sinhvien : this.listStudent) {
            if (sinhvien.getDiemCC() == -1) {
                JOptionPane.showMessageDialog(this, "Không được để trống điểm chuyên cần của sinh viên thứ " + index);
                return;
            }
            if (sinhvien.getDiemKT() == -1) {
                JOptionPane.showMessageDialog(this, "Không được để trống điểm kiểm tra của sinh viên thứ " + index);
                return;
            }
            if (sinhvien.getDiemBTL() == -1) {
                JOptionPane.showMessageDialog(this, "Không được để trống điểm bài tập lớn của sinh viên thứ " + index);
                return;
            }
            if (sinhvien.getDiemTH()== -1) {
                JOptionPane.showMessageDialog(this, "Không được để trống điểm thực hành của sinh viên thứ " + index);
                return;
            }
            if (sinhvien.getDiemCK()== -1) {
                JOptionPane.showMessageDialog(this, "Không được để trống điểm cuối kì của sinh viên thứ " + index);
                return;
            }
            index++;
        }
        DiemDAO diemDAO = new DiemDAO();
        diemDAO.nhapDiemTheoLopHocPhan(listStudent);
        int res = JOptionPane.showOptionDialog(null, "Nhập điểm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (res == 0) {
            new TrangChuGiangVienFrm(this.GV).setVisible(true);
            this.dispose();
        }        
    }
  
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TimLopFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TimLopFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TimLopFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TimLopFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NhapDiemFrm().setVisible(true);
//            }
//        });
//    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNhapDiem = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNhapDiem = new javax.swing.JTable();
        labelMaSV = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        labelTenSV = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        labelTenSV1 = new javax.swing.JLabel();
        txtDiemCC = new javax.swing.JTextField();
        labelTenSV2 = new javax.swing.JLabel();
        txtDiemKT = new javax.swing.JTextField();
        labelTenSV3 = new javax.swing.JLabel();
        txtDiemBTL = new javax.swing.JTextField();
        labelTenSV4 = new javax.swing.JLabel();
        txtDiemTH = new javax.swing.JTextField();
        labelTenSV5 = new javax.swing.JLabel();
        txtDiemThi = new javax.swing.JTextField();
        labelSTT = new javax.swing.JLabel();
        txtSTT = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Demo Nhóm 8");

        labelNhapDiem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelNhapDiem.setForeground(new java.awt.Color(0, 0, 102));
        labelNhapDiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNhapDiem.setText("Nhập điểm cho lớp học phần");

        btnSave.setText("Lưu");

        btnBack.setText("Quay Lại");

        tableNhapDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Điểm CC", "Điểm KT", "Điểm BTL", "Điểm TH", "Điểm thi"
            }
        ));
        tableNhapDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNhapDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNhapDiem);
        tableNhapDiem.getAccessibleContext().setAccessibleDescription("");

        labelMaSV.setText("Mã SV");

        txtMaSV.setEditable(false);
        txtMaSV.setEnabled(false);

        labelTenSV.setText("Tên SV");

        txtTenSV.setEditable(false);
        txtTenSV.setEnabled(false);

        labelTenSV1.setText("Điểm CC");

        labelTenSV2.setText("Điểm KT");

        labelTenSV3.setText("Điểm BTL");

        labelTenSV4.setText("Điểm TH");

        labelTenSV5.setText("Điểm thi");

        labelSTT.setText("STT");

        txtSTT.setEnabled(false);
        txtSTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSTTActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTenSV1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiemCC, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTenSV2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiemKT, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTenSV3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiemBTL, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTenSV4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTenSV5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiemTH, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(425, 425, 425))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(57, 57, 57))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(labelNhapDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNhapDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSTT)
                    .addComponent(txtSTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMaSV)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenSV)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTenSV1)
                        .addComponent(txtDiemCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTenSV4)
                        .addComponent(txtDiemTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenSV2)
                    .addComponent(txtDiemKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTenSV5)
                    .addComponent(txtDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenSV3)
                    .addComponent(txtDiemBTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int row = 0;
    private void tableNhapDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhapDiemMouseClicked
        row = tableNhapDiem.getSelectedRow();
        if (row != -1) {
            int stt = row + 1;
            txtSTT.setText(stt+"");
            txtMaSV.setText(listStudent.get(row).getTenDangNhap());
            txtTenSV.setText(listStudent.get(row).getHoTen());
            if (listStudent.get(row).getDiemCC() >= 0) {
                txtDiemCC.setText(listStudent.get(row).getDiemCC()+"");
            }
            else{
                txtDiemCC.setText("");
            }
            
            if (listStudent.get(row).getDiemKT() >= 0) {
                txtDiemKT.setText(listStudent.get(row).getDiemKT()+"");
            }
            else{
                txtDiemKT.setText("");
            }
            
            if (listStudent.get(row).getDiemBTL() >= 0) {
                txtDiemBTL.setText(listStudent.get(row).getDiemBTL()+"");
            }
            else{
                txtDiemBTL.setText("");
            }
            
            if (listStudent.get(row).getDiemTH() >= 0) {
                txtDiemTH.setText(listStudent.get(row).getDiemTH()+"");
            }
            else{
                txtDiemTH.setText("");
            }
            
            if (listStudent.get(row).getDiemTH() >= 0) {
                txtDiemThi.setText(listStudent.get(row).getDiemCK()+"");
            }
            else{
                txtDiemThi.setText("");
            }
        }        
    }//GEN-LAST:event_tableNhapDiemMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (txtDiemCC.getText().trim().length() ==  0) {
            JOptionPane.showMessageDialog(this, "Không được để trống điểm chuyên cần!");
            return;
        }
        if (txtDiemKT.getText().trim().length() ==  0) {
            JOptionPane.showMessageDialog(this, "Không được để trống điểm kiểm tra!");
            return;
        }
        if (txtDiemBTL.getText().trim().length() ==  0) {
            JOptionPane.showMessageDialog(this, "Không được để trống điểm bài tập lớn!");
            return;
        }
        if (txtDiemTH.getText().trim().length() ==  0) {
            JOptionPane.showMessageDialog(this, "Không được để trống điểm thực hành!");
            return;
        }
        if (txtDiemThi.getText().trim().length() ==  0) {
            JOptionPane.showMessageDialog(this, "Không được để trống điểm thi!");
            return;
        }
        
        double diemCC = Double.parseDouble(txtDiemCC.getText());
        double diemKT = Double.parseDouble(txtDiemKT.getText());
        double diemBTL = Double.parseDouble(txtDiemBTL.getText());
        double diemTH = Double.parseDouble(txtDiemTH.getText());
        double diemThi = Double.parseDouble(txtDiemThi.getText());
        
        if ((diemCC >= 0 && diemCC <= 10) && (diemKT >= 0 && diemKT <= 10) && (diemBTL >= 0 && diemBTL <= 10) && (diemTH >= 0 && diemTH <= 10) && (diemThi >= 0 && diemThi <= 10)) {
            if (row >= 0) {
                listStudent.get(row).setDiemCC(diemCC);
                listStudent.get(row).setDiemKT(diemKT);
                listStudent.get(row).setDiemBTL(diemBTL);
                listStudent.get(row).setDiemTH(diemTH);
                listStudent.get(row).setDiemCK(diemThi);
                HienThiSinhVien();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Giá trị điểm số lớn hơn 0 nhỏ hơn 10.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSTTActionPerformed
    
    

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMaSV;
    private javax.swing.JLabel labelNhapDiem;
    private javax.swing.JLabel labelSTT;
    private javax.swing.JLabel labelTenSV;
    private javax.swing.JLabel labelTenSV1;
    private javax.swing.JLabel labelTenSV2;
    private javax.swing.JLabel labelTenSV3;
    private javax.swing.JLabel labelTenSV4;
    private javax.swing.JLabel labelTenSV5;
    private javax.swing.JTable tableNhapDiem;
    private javax.swing.JTextField txtDiemBTL;
    private javax.swing.JTextField txtDiemCC;
    private javax.swing.JTextField txtDiemKT;
    private javax.swing.JTextField txtDiemTH;
    private javax.swing.JTextField txtDiemThi;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSTT;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables


    
    
}
