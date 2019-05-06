/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.MonHocDAO;
import Model.GiangVien;
import Model.MonHoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author TaDuyHieu
 */
public class TimMonTheoKyFrm extends javax.swing.JFrame implements ActionListener{
    private GiangVien GV;
    private String hocky;
    private String monHoc;
    private ArrayList<MonHoc> listSubject;
    private TrangChuGiangVienFrm parent;
    private ArrayList<JButton> listSelect;
    public TimMonTheoKyFrm(GiangVien GV, TrangChuGiangVienFrm parent) {
        this.parent = parent;
        this.GV = GV;
        listSelect = new ArrayList<JButton>();
        listSubject = new ArrayList<MonHoc>();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnSearch.addActionListener(this);
        btnBack.addActionListener(this);
        tableSubject.setModel(new TimMonTheoKyFrm.SubjectTableModel());
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tableSubject.getColumn("Thao tác").setCellRenderer(buttonRenderer);
        tableSubject.addMouseListener(new JTableButtonMouseListener(tableSubject));
        this.setLocation(300,150);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKeyMH = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSubject = new javax.swing.JTable();
        labelGV = new javax.swing.JLabel();
        labelHK = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKeyHK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Demo Nhóm 8");

        jLabel1.setText("Nhập môn cần tìm kiếm ");

        btnSearch.setText("Tìm kiếm");

        btnBack.setText("Quay lại");

        tableSubject.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableSubject);

        labelGV.setText(" ");

        labelHK.setText(" ");

        jLabel2.setText("Học kỳ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Ví dụ: Kì 1 năm 2016 - 20161");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Tìm môn học theo học kỳ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtKeyHK, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKeyMH, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(31, 31, 31)
                        .addComponent(btnSearch)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelGV, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelHK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKeyMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKeyHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGV)
                    .addComponent(labelHK))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGV;
    private javax.swing.JLabel labelHK;
    private javax.swing.JTable tableSubject;
    private javax.swing.JTextField txtKeyHK;
    private javax.swing.JTextField txtKeyMH;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnSearch)){
            btnSearchClick();
            return;
        }
        if(btnClicked.equals(btnBack)){
            btnBackClick();
            return;
        }
        for(int i = 0; i < listSubject.size(); i++){
            if(btnClicked.equals(listSelect.get(i))){
                btnSelectClick(i);
                return;
            }
        }
    }
    
    private void btnSearchClick(){
        String KeyMH = txtKeyMH.getText();
        this.hocky = txtKeyHK.getText();
        if (Integer.parseInt(this.hocky) < 10000 || Integer.parseInt(this.hocky) > 99999) {
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng học kỳ!!!");
            return;
        }
        
        labelGV.setText("Môn học của giảng viên : " + this.GV.getHoTen());
        labelHK.setText("Học kì : " + hocky);
        MonHocDAO mhd = new MonHocDAO();
        listSubject = mhd.timMonHocTheoKey(this.GV, KeyMH, hocky);
        if (listSubject.size()==0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy môn học nào!");
            return;
        }
        for(int i = 1; i <= listSubject.size(); i++){
            JButton add = new JButton("Xem");
            add.addActionListener(this);
            listSelect.add(add);
        }
        tableSubject.setRowHeight(25);
        TableColumn col = tableSubject.getColumnModel().getColumn(0);
        col.setPreferredWidth(30);
        for(int i = 0; i < 3; i++){
            TableColumnModel columnModel = tableSubject.getColumnModel();
            TableColumn column = columnModel.getColumn(i); 
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            column.setCellRenderer(renderer);
        }
        ((DefaultTableModel)tableSubject.getModel()).fireTableDataChanged();
    }

    private void btnBackClick(){
        parent.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void btnSelectClick(int i){
        this.setVisible(false);
        (new DanhSachLHPFrm(this.GV, this.hocky,listSubject.get(i), this)).setVisible(true);
            
    }
    
    class SubjectTableModel extends DefaultTableModel{
        private String[] columnNames = {"STT", "Mã môn học", "Tên môn học", "Thao tác"};
        private final Class<?>[] columnTypes = new Class<?>[] {Integer.class, String.class, String.class, JButton.class};
        @Override public int getColumnCount() {
            return 4;
        }
 
        @Override public int getRowCount() {
            return listSubject.size();
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
                    return listSubject.get(rowIndex).getMaMon();
                case 2: 
                    return listSubject.get(rowIndex).getTenMon();
                case 3: 
                    return listSelect.get(rowIndex);
                default: return "Error";
            }
        } 
    }
}
