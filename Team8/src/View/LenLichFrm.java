
package View;

import Control.LichGiangDayDAO;
import Model.GiangVien;
import Model.KipHoc;
import Model.LichGiangDay;
import Model.LopHocPhan;
import Model.MonHoc;
import Model.PhongHoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class LenLichFrm extends javax.swing.JFrame implements ActionListener {
    
    private TimGiangVienFrm parent;
    private MonHoc MH;
    private LopHocPhan LHP;
    private GiangVien GV;
    private KipHoc KH;
    private PhongHoc PH;
    private DefaultTableModel tm;
    private ArrayList<LichGiangDay> LGD;
    private LichGiangDay lgd;
 
            
            
    public LenLichFrm(TimGiangVienFrm parent, MonHoc MH, LopHocPhan LHP, PhongHoc PH, GiangVien GV, KipHoc KH) {
        this.parent = parent;
        this.MH = MH;
        this.LHP = LHP;
        this.KH = KH;
        this.PH = PH;
        this.GV =GV ;
        LGD = new ArrayList<LichGiangDay>();
        lgd = new LichGiangDay();
        initComponents();
        mamon.setText(mamon.getText()+MH.getMaMon());
        tenmon.setText(tenmon.getText() + MH.getTenMon());
        txtsotinchi.setText(txtsotinchi.getText()+MH.getSoTinChi());
        txtlhp.setText(txtlhp.getText()+LHP.getTen());
        tbntaolich.addActionListener(this);
        tbnthemlich.addActionListener(this);
        tbnquaylai.addActionListener(this);
        tbnluulich.addActionListener(this);
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mamon = new javax.swing.JLabel();
        tenmon = new javax.swing.JLabel();
        txtsotinchi = new javax.swing.JLabel();
        txtlhp = new javax.swing.JLabel();
        tbntaolich = new javax.swing.JButton();
        tbnthemlich = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttuanbd = new javax.swing.JTextField();
        txttuankt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbnluulich = new javax.swing.JButton();
        tbnquaylai = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnbang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Lên Lịch");

        mamon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mamon.setText("Mã môn học: ");

        tenmon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tenmon.setText("Tên môn học: ");

        txtsotinchi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtsotinchi.setText("Số tín chỉ: ");

        txtlhp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtlhp.setText("Tên lớp học phần: ");

        tbntaolich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbntaolich.setText("Tạo Lịch");
        tbntaolich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbntaolichActionPerformed(evt);
            }
        });

        tbnthemlich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbnthemlich.setText("Thêm Lịch");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Tuần bắt đầu: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tuần kết thúc: ");

        txttuanbd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txttuankt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Thông tin lên lịch");

        tbnluulich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbnluulich.setText("Lưu Lịch");

        tbnquaylai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbnquaylai.setText("Quay Lại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel5.setText("Click Tạo Lịch để lên lịch.       Click Lưu Lịch để lưu lịch học cho lớp học phần sau khi tạo. ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel6.setText("Click Thêm Lịch nếu muốn thêm lịch cho lớp học phần.");

        tbnbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tuần bắt đầu", "Tuần kết thúc", "Thứ", "Giờ bắt đầu", "Giờ kết thúc", "Phòng học", "Tên giảng viên"
            }
        ));
        jScrollPane1.setViewportView(tbnbang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mamon)
                                    .addComponent(txtsotinchi))
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tenmon)
                                    .addComponent(txtlhp)))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(txttuanbd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txttuankt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tbnquaylai)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tbntaolich)
                                        .addGap(50, 50, 50)
                                        .addComponent(tbnluulich)
                                        .addGap(35, 35, 35)
                                        .addComponent(tbnthemlich)))
                                .addGap(206, 206, 206))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel6)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mamon)
                            .addComponent(tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsotinchi)
                            .addComponent(txtlhp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttuanbd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txttuankt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbntaolich)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbnluulich)
                        .addComponent(tbnthemlich)))
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tbnquaylai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbntaolichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbntaolichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbntaolichActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mamon;
    private javax.swing.JTable tbnbang;
    private javax.swing.JButton tbnluulich;
    private javax.swing.JButton tbnquaylai;
    private javax.swing.JButton tbntaolich;
    private javax.swing.JButton tbnthemlich;
    private javax.swing.JLabel tenmon;
    private javax.swing.JLabel txtlhp;
    private javax.swing.JLabel txtsotinchi;
    private javax.swing.JTextField txttuanbd;
    private javax.swing.JTextField txttuankt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();
        if(btnClicked.equals(tbntaolich)){
            btnTaoLich();
            return;
        }
        if(btnClicked.equals(tbnthemlich)){
            btnThemLich();
            return;
        }
        if(btnClicked.equals(tbnluulich)){
            try {
                btnLuuLich();
            } catch (SQLException ex) {
                Logger.getLogger(LenLichFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if(btnClicked.equals(tbnquaylai)){
            parent.setVisible(true);
            this.dispose();
        }
    }

    private void btnTaoLich() {
      
        lgd.setTuanBatDau(Integer.parseInt(txttuanbd.getText()));
        lgd.setTuanKetThuc(Integer.parseInt(txttuankt.getText()));
        lgd.setTblKipHocId(KH.getKipHocId());
        lgd.setTblPhongHocId(PH.getPhongHocId());
        lgd.setTblLopHocPhanId(LHP.getLopHocPhanId());
        lgd.setTblGiangVientblNguoiDungId(GV.getGiangVienId());
        LGD.add(lgd);
        fillTable();
    }

    private void btnThemLich() {
       this.setVisible(false);
       new TimPhongFrm(this.MH, this.LHP).setVisible(true);
       this.dispose();
       
    }

    private void btnLuuLich() throws SQLException {
        LichGiangDayDAO LGDDAO = new LichGiangDayDAO();
        for(LichGiangDay i: LGD){
            LGDDAO.LenLich(i);
        }
        JOptionPane.showMessageDialog(this, "Lên Lịch Thành công");
        new TrangChuGiaoVuFrm().setVisible(true);
        this.dispose();
    }

    private void fillTable() {
        int stt=0;
        tm=(DefaultTableModel)tbnbang.getModel();
        tm.setRowCount(LGD.size());
        for(LichGiangDay i:LGD){
            tm.setValueAt(stt+1, stt, 0);
            tm.setValueAt(lgd.getTuanBatDau(), stt, 1);
            tm.setValueAt(lgd.getTuanKetThuc(), stt, 2);
            tm.setValueAt(KH.getThu(), stt, 3);
            tm.setValueAt(KH.getGioBatDau(), stt, 4);
            tm.setValueAt(KH.getGioKetThuc(), stt, 5);
            tm.setValueAt(GV.getHoTen(), stt, 6);
            tm.setValueAt(PH.getTenPhong(), stt, 7);
            stt++;
        }
    } 
}
