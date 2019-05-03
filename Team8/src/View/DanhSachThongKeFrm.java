package View;

import Control.BangDiemDAO;
import Control.SinhVienDAO;
import Model.BangDiem;
import Model.SinhVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class DanhSachThongKeFrm extends javax.swing.JFrame implements ActionListener{
    private ThongKeHocLucFrm parent;
    private ArrayList<SinhVien> listSV;
    private ArrayList<BangDiem> listBD;
    private ArrayList<JButton> listDetail;
    String hocLuc;
    int kyHoc;
    
    public DanhSachThongKeFrm(int kyHoc, String hocLuc, ThongKeHocLucFrm parent) {
        this.kyHoc = kyHoc;
        this.hocLuc = hocLuc;
        this.parent = parent;
        listSV = new ArrayList<SinhVien>();
        listBD = new ArrayList<BangDiem>();
        listDetail = new ArrayList<JButton>();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnBack.addActionListener(this);
        jlbHeader.setText("Danh sách sinh viên học lực:  "  + this.hocLuc + "      Kỳ: " + this.kyHoc%10 + " - Năm học: " + this.kyHoc/10);
        tblDanhSach.setModel(new DanhSachTableModel());
        TableCellRenderer btnRenderer = new JTableButtonRenderer();
        tblDanhSach.getColumn("Xem Bang Diem").setCellRenderer(btnRenderer);
        tblDanhSach.addMouseListener(new JTableButtonMouseListener(tblDanhSach));
        fillTable();
        this.setLocation(300,150);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jlbHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDanhSach);

        btnBack.setText("Back");

        jlbHeader.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbHeader.setForeground(new java.awt.Color(0, 51, 204));
        jlbHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(309, 309, 309))
            .addComponent(jlbHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnBack)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbHeader;
    private javax.swing.JTable tblDanhSach;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e){
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnBack)){
            btnBackClick();
            return;
        }
        for(int i = 0; i < listDetail.size(); i++){
            if(btnClicked.equals(listDetail.get(i))){
                btnDetailClick(i);
                return;
            }
        }
    }

    private void fillTable(){
        BangDiemDAO bdd = new BangDiemDAO();
        listBD = bdd.getBangDiemTheoHocLuc(kyHoc, hocLuc);
        for(BangDiem bd: listBD){
            SinhVienDAO svd = new SinhVienDAO();
            SinhVien tmp = svd.timSinhVien(bd.getListDiem().get(0).getMaSinhVien());
            listSV.add(tmp);
        }
        listDetail.clear();
        for(SinhVien sv: listSV){
            JButton tmp = new JButton("Xem");
            tmp.addActionListener(this);
            listDetail.add(tmp);
        }
        tblDanhSach.setRowHeight(25);
        TableColumn col = tblDanhSach.getColumnModel().getColumn(0);
        col.setPreferredWidth(30);
        col = tblDanhSach.getColumnModel().getColumn(2);
        col.setPreferredWidth(120);
        col = tblDanhSach.getColumnModel().getColumn(1);
        col.setPreferredWidth(80);
        for(int i = 0; i < 5; i++){
            TableColumnModel columnModel = tblDanhSach.getColumnModel();
            TableColumn column = columnModel.getColumn(i); 
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            column.setCellRenderer(renderer);
        }
        ((DefaultTableModel)tblDanhSach.getModel()).fireTableDataChanged();
    }

    private void btnBackClick(){
        this.parent.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void btnDetailClick(int i){
        this.setVisible(false);
        (new BangDiemFrm(listSV.get(i), listBD.get(i), this)).setVisible(true);
    }
    
     class DanhSachTableModel extends DefaultTableModel{
        private String[] columnNames = {"STT", "Ma Sinh Vien", "Ho Ten", "Lop", "Diem Trung Binh", "Xem Bang Diem"};
        private final Class<?>[] columnTypes = new Class<?>[]{Integer.class, String.class, String.class, String.class, Double.class, JButton.class};
        
        @Override public int getColumnCount() {
            return columnNames.length;
        }
 
        @Override public int getRowCount() {
            return listSV.size();
        }
 
        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }
 
        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
        
        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
                /*Adding components*/
            switch (columnIndex) {
                case 0: 
                    return rowIndex+1;
                case 1: 
                    return listSV.get(rowIndex).getTenDangNhap();
                case 2: 
                    return listSV.get(rowIndex).getHoTen();
                case 3: 
                    return listSV.get(rowIndex).getLop();
                case 4: 
                    return (double)Math.round(listBD.get(rowIndex).getTrungBinh()*100)/100;
                case 5: 
                    return listDetail.get(rowIndex);     
                default: return "Error";
            }
        } 
    }
    
}
