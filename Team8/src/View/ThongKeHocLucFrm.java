package View;

import Control.BangDiemDAO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ThongKeHocLucFrm extends javax.swing.JFrame implements ActionListener{   
    private int kyHoc;
    private ArrayList<Integer> sl;
    private ThongKeFrm parent;
    private ArrayList<JButton> listDetail;
    
    public ThongKeHocLucFrm(ThongKeFrm parent) {
        this.parent = parent;
        sl = new ArrayList<>();
        listDetail = new ArrayList<JButton>();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnThongKe.addActionListener(this);
        btnBack.addActionListener(this);
        tblSoLuong.setModel(new SoLuongTableModel());
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblSoLuong.getColumn("Xem Danh Sách").setCellRenderer(buttonRenderer);
        tblSoLuong.addMouseListener(new JTableButtonMouseListener(tblSoLuong));
        this.setLocation(300,150);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKyHoc = new javax.swing.JTextField();
        btnThongKe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSoLuong = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ SỐ LƯỢNG SINH VIÊN THEO HỌC LỰC");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setText("KỲ HỌC");

        btnThongKe.setText("THỐNG KÊ");

        tblSoLuong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSoLuong);

        btnBack.setText("Quay Lại");

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        jLabel3.setText("năm học + kỳ, vd: 20161");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKyHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThongKe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtKyHoc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBack))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSoLuong;
    private javax.swing.JTextField txtKyHoc;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e){
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnThongKe)){
            btnThongKeClick();
            return;
        }
        if(btnClicked.equals(btnBack)){
            btnBackClick();
            return;
        }
        for(int i = 0; i < 5; i++){
            if(btnClicked.equals(listDetail.get(i))){
                btnDetailClick(i);
                return;
            }
        }
    }

    private void btnThongKeClick(){
        try{
            kyHoc = Integer.parseInt(txtKyHoc.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Nhập sai định dạng");
            e.printStackTrace();
            return;
        }
        BangDiemDAO bdd = new BangDiemDAO();
        sl = bdd.thongKeSoLuong(kyHoc);
        for(int i = 1; i <= 5; i++){
            JButton add = new JButton("Xem");
            add.addActionListener(this);
            listDetail.add(add);
        }
        tblSoLuong.setRowHeight(25);
        TableColumn col = tblSoLuong.getColumnModel().getColumn(0);
        col.setPreferredWidth(30);
        for(int i = 0; i < 3; i++){
            TableColumnModel columnModel = tblSoLuong.getColumnModel();
            TableColumn column = columnModel.getColumn(i); 
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            column.setCellRenderer(renderer);
        }
        ((DefaultTableModel)tblSoLuong.getModel()).fireTableDataChanged();
    }

    private void btnBackClick(){
        parent.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void btnDetailClick(int i){
        this.setVisible(false);
        switch(i){
            case 0: (new DanhSachThongKeFrm(kyHoc, "Xuất Sắc", this)).setVisible(true); break;
            case 1: (new DanhSachThongKeFrm(kyHoc, "Giỏi", this)).setVisible(true); break;
            case 2: (new DanhSachThongKeFrm(kyHoc, "Khá", this)).setVisible(true); break;
            case 3: (new DanhSachThongKeFrm(kyHoc, "Trung Bình", this)).setVisible(true); break;
            case 4: (new DanhSachThongKeFrm(kyHoc, "Yếu", this)).setVisible(true); break;
        }
    }
    
    class SoLuongTableModel extends DefaultTableModel{
        private String[] columnNames = {"STT", "Họcc Lực", "Số Lượng", "Xem Danh Sách"};
        private final Class<?>[] columnTypes = new Class<?>[] {Integer.class, String.class, Integer.class, JButton.class};
        private final String[] h = {"Xuất Sắc", "Giỏi", "Khá", "Trung Bình", "Yếu"};
        @Override public int getColumnCount() {
            return 4;
        }
 
        @Override public int getRowCount() {
            return sl.size();
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
                    return h[rowIndex];
                case 2: 
                    return sl.get(rowIndex);
                case 3: 
                    return listDetail.get(rowIndex);
                default: return "Error";
            }
        } 
    }
}
