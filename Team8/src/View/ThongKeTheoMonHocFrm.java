/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ThongKeTheoMonHocDAO;
import Model.ThongKeTheoMonHoc;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import Model.*;
import Control.*;
import View.ThongKeFrm;
import View.ThongKeFrm;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author nguyenthang
 */
public class ThongKeTheoMonHocFrm extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ThongKeTheoMonHocFrm
     */
    DefaultTableModel tm;
    ThongKeFrm parent;
    private ArrayList<ThongKeTheoMonHoc> ltk=null;
    private ArrayList<JButton> listChiTiet;
    public ThongKeTheoMonHocFrm(ThongKeFrm parent) {
        initComponents();
        this.parent=parent;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listChiTiet=new ArrayList<JButton>();
        ltk=new ArrayList<ThongKeTheoMonHoc>();
        btnThongKe.addActionListener(this);
        btnQuayLai.addActionListener(this);
        tblResult.setModel(new ResultTableModel());
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblResult.getColumn("Chi tiết").setCellRenderer(buttonRenderer);
        tblResult.addMouseListener(new JTableButtonMouseListener(tblResult));
        tblResult.setRowHeight(25);
        TableColumn col = tblResult.getColumnModel().getColumn(0);
        col.setPreferredWidth(10);
        col = tblResult.getColumnModel().getColumn(1);
        col.setPreferredWidth(90);
        col = tblResult.getColumnModel().getColumn(2);
        col.setPreferredWidth(20);
        col = tblResult.getColumnModel().getColumn(3);
        col.setPreferredWidth(80);
        col = tblResult.getColumnModel().getColumn(4);
        col.setPreferredWidth(80);
        col = tblResult.getColumnModel().getColumn(5);
        col.setPreferredWidth(80);
        col = tblResult.getColumnModel().getColumn(6);
        col.setPreferredWidth(70);
        col = tblResult.getColumnModel().getColumn(7);
        col.setPreferredWidth(30);
        this.setLocation(300,150);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnThongKe)){
            btnThongKeDuocNhan();
            return;
        }
        if(btnClicked.equals(btnQuayLai)){
            btnQuayLaiDuocNhan();
            return;
        }
        for(int i = 0; i < ltk.size(); i++){
            if(btnClicked.equals(listChiTiet.get(i))){
                btnChiTietDuocNhan(i);
                return;
            }
        }
    }
    
    private void btnChiTietDuocNhan(int i){
        this.setVisible(false);
        ThongKeTheoMonHoc tkmh= new ThongKeTheoMonHoc();
        tkmh=ltk.get(i);
        new ThongKeCacLopHocPhanFrm(this,txtKyBD.getText().toString(),txtKyKT.getText().toString(),tkmh).setVisible(true);
    }
    
    private void btnThongKeDuocNhan(){
        String x=txtKyBD.getText().toString();
        String y=txtKyKT.getText().toString();
        if(x.compareTo(y)>0){
            JOptionPane.showMessageDialog(this, "Xin hãy nhập kì bắt đầu trước kì kết thúc");
        }
        else{
        ThongKeTheoMonHocDAO tk=new ThongKeTheoMonHocDAO();
        ltk=tk.layThongKeTheoMonHoc(x, y);
        if(ltk.size()==0) JOptionPane.showMessageDialog(this, "Kì đã chọn không có thông tin thống kê, mời nhập lại");
        for(int i = 1; i <= ltk.size(); i++){
            JButton add = new JButton("Xem");
            add.addActionListener(this);
            listChiTiet.add(add);
        }
        for(int i = 0; i < 7; i++){
            TableColumnModel columnModel = tblResult.getColumnModel();
            TableColumn column = columnModel.getColumn(i); 
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            column.setCellRenderer(renderer);
        }
        ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
        }
    }
    private void btnQuayLaiDuocNhan(){
        parent.setVisible(true);
        this.dispose();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        txtKyBD = new javax.swing.JTextField();
        txtKyKT = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kì bắt đầu");

        jLabel2.setText("Kì kết thúc");

        jLabel5.setText("Bảng kết quả");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnQuayLai.setText("Quay lại");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("THỐNG KÊ MÔN HỌC");

        btnThongKe.setText("Thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtKyKT))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKyBD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addComponent(btnThongKe))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnQuayLai)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabel6)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKyBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnThongKe)
                    .addComponent(txtKyKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuayLai)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtKyBD;
    private javax.swing.JTextField txtKyKT;
    // End of variables declaration//GEN-END:variables
class ResultTableModel extends DefaultTableModel{
        private String[] columnNames = {"STT", "Tên môn học", "Khoa", "Tổng số sinh viên", "Tổng số qua môn", "Tổng số trượt môn", "Trung bình điểm", "Chi tiết"};
        private final Class<?>[] columnTypes = new Class<?>[] {Integer.class, String.class,String.class, Integer.class, Integer.class, Integer.class,Float.class, JButton.class};
        @Override public int getColumnCount() {
            return 8;
        }
 
        @Override public int getRowCount() {
            return ltk.size();
        }
 
        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }
 
        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
        
        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            switch (columnIndex) {
                case 0: 
                    return rowIndex+1;
                case 1: 
                    return ltk.get(rowIndex).getTenMon();
                case 2: 
                    return ltk.get(rowIndex).getKhoa();
                case 3: 
                    return ltk.get(rowIndex).getTongSoSinhVien();
                case 4: 
                    return ltk.get(rowIndex).getTongSoQuaMon();
                case 5: 
                    return ltk.get(rowIndex).getTongSoTruot();
                case 6: 
                    return ltk.get(rowIndex).getTrungBinh();
                case 7: 
                    return listChiTiet.get(rowIndex);
                default: return "Error";
            }
        } 
    }
}
