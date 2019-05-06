
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
    private TimPhongFrm grandpra;
    private int STT;
 
            
            
    public LenLichFrm(TimGiangVienFrm parent, MonHoc MH, LopHocPhan LHP, PhongHoc PH, GiangVien GV, KipHoc KH,TimPhongFrm grandpra) {
        this.parent = parent;
        this.MH = MH;
        this.LHP = LHP;
        this.KH = KH;
        this.PH = PH;
        this.GV =GV ;
        this.grandpra=grandpra;
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
        btnRefresh.addActionListener(this);
        btnTrangChu.addActionListener(this);
        tm=(DefaultTableModel)tbnbang.getModel();
        
        
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
        ttlenlich = new javax.swing.JLabel();
        tbnluulich = new javax.swing.JButton();
        tbnquaylai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnbang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();

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
        tbnthemlich.setText("Thêm Lịch khác");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Tuần bắt đầu: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tuần kết thúc: ");

        txttuanbd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txttuankt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ttlenlich.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ttlenlich.setText("Xác nhận thông tin :");

        tbnluulich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbnluulich.setText("Lưu Lịch");

        tbnquaylai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbnquaylai.setText("Quay lại");

        tbnbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tuần bắt đầu", "Tuần kết thúc", "Thứ", "Giờ bắt đầu", "Giờ kết thúc", "Phòng học", "Tên giảng viên"
            }
        ));
        jScrollPane1.setViewportView(tbnbang);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("Thêm lịch cho Lớp học phần với Phòng học hoặc Giảng viên khác.");

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefresh.setText("Refresh");

        btnTrangChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTrangChu.setText("Quay về Trang chủ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbnquaylai)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mamon)
                                        .addComponent(txtsotinchi))
                                    .addGap(129, 129, 129)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tenmon)
                                        .addComponent(txtlhp)))
                                .addComponent(ttlenlich)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(tbntaolich))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRefresh)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txttuanbd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(98, 98, 98)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txttuankt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tbnluulich)
                                    .addGap(38, 38, 38)
                                    .addComponent(btnTrangChu)
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(tbnthemlich)))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbntaolich)
                        .addGap(18, 18, 18)
                        .addComponent(ttlenlich)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnluulich)
                            .addComponent(tbnthemlich)
                            .addComponent(btnTrangChu)))
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(tbnquaylai)
                .addGap(32, 32, 32))
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
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mamon;
    private javax.swing.JTable tbnbang;
    private javax.swing.JButton tbnluulich;
    private javax.swing.JButton tbnquaylai;
    private javax.swing.JButton tbntaolich;
    private javax.swing.JButton tbnthemlich;
    private javax.swing.JLabel tenmon;
    private javax.swing.JLabel ttlenlich;
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
            try {
                btnThemLich();
            } catch (SQLException ex) {
                Logger.getLogger(LenLichFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if(btnClicked.equals(btnRefresh)){
            btnRefresh();
        }
        if(btnClicked.equals(btnTrangChu)){
            new TrangChuGiaoVuFrm().setVisible(true);
            this.dispose();
        }
    }

    private void btnRefresh() {
        txttuanbd.setText("");
        txttuankt.setText("");
        LGD.removeAll(LGD);
        fillTable();
    }

    private void btnTaoLich() {
        if(Integer.parseInt(txttuanbd.getText())>Integer.parseInt(txttuankt.getText())||Integer.parseInt(txttuanbd.getText())<1||Integer.parseInt(txttuankt.getText())<1){
            JOptionPane.showMessageDialog(this, "Tuần bắt đầu hoặc tuần kết thúc nhập sai!");
        }
        lgd=new LichGiangDay();
        lgd.setTuanBatDau(Integer.parseInt(txttuanbd.getText()));
        lgd.setTuanKetThuc(Integer.parseInt(txttuankt.getText()));
        lgd.setTblKipHocId(KH.getKipHocId());
        lgd.setTblPhongHocId(PH.getPhongHocId());
        lgd.setTblLopHocPhanId(LHP.getLopHocPhanId());
        lgd.setTblGiangVientblNguoiDungId(GV.getGiangVienId());
        LGD.add(lgd);
        ttlenlich.setText(ttlenlich.getText());
        tm.setRowCount(0);
        fillTable();
    }

    private void btnThemLich() throws SQLException {
       grandpra.setVisible(true);
       this.dispose();      
    }

    private void btnLuuLich() throws SQLException {
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu lại thông tin lịch vừa tạo?","", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            LichGiangDayDAO LGDDAO = new LichGiangDayDAO();
            STT++;
            for(LichGiangDay i: LGD){
                LGDDAO.LenLich(i);
            }     
            tbnluulich.setEnabled(false);
       }
    }

    private void fillTable() {
        int stt=0;
        tm.setRowCount(LGD.size());
        for(LichGiangDay i:LGD){
            tm.setValueAt(stt+1, stt, 0);
            tm.setValueAt(i.getTuanBatDau(), stt, 1);
            tm.setValueAt(i.getTuanKetThuc(), stt, 2);
            tm.setValueAt(KH.getThu(), stt, 3);
            tm.setValueAt(KH.getGioBatDau(), stt, 4);
            tm.setValueAt(KH.getGioKetThuc(), stt, 5);
            tm.setValueAt(GV.getHoTen(), stt, 7);
            tm.setValueAt(PH.getTenPhong(), stt, 6);
            stt++;
        }
    } 
}
