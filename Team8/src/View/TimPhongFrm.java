
package View;

import Control.KipHocDAO;
import Control.LichGiangDayDAO;
import Control.PhongHocDAO;
import Control.GiangVienDAO;
import Model.GiangVien;
import Model.KipHoc;
import Model.LopHocPhan;
import Model.MonHoc;
import Model.PhongHoc;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TimPhongFrm extends javax.swing.JFrame implements ActionListener{
    private DanhSachCacLHPFrm parent;
    private ArrayList<PhongHoc> ListPH;
    private ArrayList<JButton> ListSelcet;
    private MonHoc MH;
    private LopHocPhan LHP;
    private KipHoc KH;
    
    public TimPhongFrm( MonHoc MH, LopHocPhan LHP) {
        this.MH =MH;
        this.LHP = LHP;
      //  this.parent = parent;
        ListPH = new ArrayList<PhongHoc>();
        ListSelcet = new ArrayList<JButton>();
       // Kip = new KipHoc(); 
        initComponents();
        
       // Kip = KH.TimKipGV(Integer.parseInt(giobt), Integer.parseInt(giokt) , Integer.parseInt(thu));
       // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mamon.setText(mamon.getText()+MH.getMaMon());
        tenmon.setText(tenmon.getText()+MH.getTenMon());
        lophocphan.setText(lophocphan.getText() + LHP.getTen());
        sotinchi.setText(sotinchi.getText()+MH.getSoTinChi());
        btntimkiem.addActionListener(this);
        btnquaylai.addActionListener(this);
        tblbang.setModel(new TimPhongFrm.PhongTableModel());
        TableCellRenderer buttonRenderer = new TimPhongFrm.JTableButtonRenderer();
        tblbang.getColumn("Chọn").setCellRenderer(buttonRenderer);
        tblbang.addMouseListener(new TimPhongFrm.JTableButtonMouseListener(tblbang));
        tblbang.setRowHeight(25);
        this.setLocation(300, 150);
    }   
   
    
    
    
    public TimPhongFrm(DanhSachCacLHPFrm parent, MonHoc MH, LopHocPhan LHP) {
        this.parent=parent;
        this.MH =MH;
        this.LHP = LHP;
      //  this.parent = parent;
        ListPH = new ArrayList<PhongHoc>();
        ListSelcet = new ArrayList<JButton>();
       // Kip = new KipHoc(); 
        initComponents();
        
       // Kip = KH.TimKipGV(Integer.parseInt(giobt), Integer.parseInt(giokt) , Integer.parseInt(thu));
       // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mamon.setText(mamon.getText()+MH.getMaMon());
        tenmon.setText(tenmon.getText()+MH.getTenMon());
        lophocphan.setText(lophocphan.getText() + LHP.getTen());
        sotinchi.setText(sotinchi.getText()+MH.getSoTinChi());
        btntimkiem.addActionListener(this);
        btnquaylai.addActionListener(this);
        tblbang.setModel(new TimPhongFrm.PhongTableModel());
        TableCellRenderer buttonRenderer = new TimPhongFrm.JTableButtonRenderer();
        tblbang.getColumn("Chọn").setCellRenderer(buttonRenderer);
        tblbang.addMouseListener(new TimPhongFrm.JTableButtonMouseListener(tblbang));
        tblbang.setRowHeight(25);
        this.setLocation(300, 150);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mamon = new javax.swing.JLabel();
        tenmon = new javax.swing.JLabel();
        lophocphan = new javax.swing.JLabel();
        sotinchi = new javax.swing.JLabel();
        txtThu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtgiobd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtgiokt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbang = new javax.swing.JTable();
        btntimkiem = new javax.swing.JButton();
        btnquaylai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tìm Phòng Học ");

        mamon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mamon.setText("Mã Môn: ");

        tenmon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tenmon.setText("Tên môn học: ");

        lophocphan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lophocphan.setText("Lớp học phần: ");

        sotinchi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sotinchi.setText("Số tín chỉ: ");

        txtThu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Thứ: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Giờ bắt đầu: ");

        txtgiobd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgiobd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiobdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Giờ kết thúc: ");

        txtgiokt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tblbang);

        btntimkiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntimkiem.setText("Tìm Kiếm");

        btnquaylai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnquaylai.setText("Quay Lại");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel3.setText("Sáng: kíp học bắt đầu từ 7:00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel4.setText("Chiều kíp học bắt đầu từ 12:00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel7.setText("Mỗi kíp học kéo dài 2h. ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnquaylai)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btntimkiem)
                            .addComponent(mamon)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lophocphan)
                                    .addComponent(tenmon)
                                    .addComponent(jLabel1)))
                            .addComponent(sotinchi)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(335, 335, 335)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtThu, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtgiobd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtgiokt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sotinchi)
                    .addComponent(tenmon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mamon)
                    .addComponent(lophocphan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtgiobd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtgiokt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(btntimkiem)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnquaylai)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtgiobdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiobdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiobdActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnquaylai;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lophocphan;
    private javax.swing.JLabel mamon;
    private javax.swing.JLabel sotinchi;
    private javax.swing.JTable tblbang;
    private javax.swing.JLabel tenmon;
    private javax.swing.JTextField txtThu;
    private javax.swing.JTextField txtgiobd;
    private javax.swing.JTextField txtgiokt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();
        if(btnClicked.equals(btntimkiem)){
            btnSearchClick();
            return;
        }
        
        if (btnClicked.equals(btnquaylai)) {
            parent.setVisible(true);
           this.dispose();
        }
        for (int i = 0; i < ListSelcet.size(); i++) {
            if(btnClicked.equals(ListSelcet.get(i))){
                btnselectClick(i);
                return;
            }
        }
    }

    private void btnSearchClick() {
        if((txtThu.getText().equals("") )|| (txtgiobd.getText().equals("")) || (txtgiokt.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
            return;
        }
        if((Integer.parseInt(txtgiobd.getText()) != 7) && (Integer.parseInt(txtgiobd.getText()) !=9) &&(Integer.parseInt(txtgiobd.getText()) !=12) && (Integer.parseInt(txtgiobd.getText())!=14) && Integer.parseInt(txtgiobd.getText()) != 16 && Integer.parseInt(txtgiobd.getText())!=18){
            JOptionPane.showMessageDialog(this, "giờ bắt đầu của các kíp học là 7h, 9h, 12h, 14h, 16h, 18h. Với các kíp thực hành giờ bắt đầu là 7h,  12h. Vui Lòng nhập lại. ");
            return;
        }
        if(Integer.parseInt(txtgiobd.getText())!=Integer.parseInt(txtgiokt.getText())-2 ){
            JOptionPane.showMessageDialog(this, "Một kíp học kéo dài 2 tiếng!!!");
            return;
        }
        KipHocDAO KHDAO = new KipHocDAO();
        KH = KHDAO.TimKipGV(Integer.parseInt(txtgiobd.getText()), Integer.parseInt(txtgiokt.getText()) , Integer.parseInt(txtThu.getText())); 
        LichGiangDayDAO PhongDAO = new LichGiangDayDAO();
        ListPH = PhongDAO.TimPhongGV(KH.getKipHocId());
        ListSelcet.clear();
      
        for(int i=0; i<ListPH.size(); i++){
            JButton btn = new JButton("Chọn");
            btn.addActionListener(this);
            ListSelcet.add(btn);
            
       }
        
        ((DefaultTableModel)tblbang.getModel()).fireTableDataChanged();
    }

    private void btnselectClick(int i) {
       this.setVisible(false);
       new TimGiangVienFrm(this, MH, LHP, ListPH.get(i), KH).setVisible(true);
       return;
       
    }
    
    
    
    class PhongTableModel extends DefaultTableModel {
        private String[] columnNames = {"STT", "Tên phòng", "Vị Trí", "Sức chứa", "Mô Tả", "Chọn"};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, String.class, String.class, Integer.class, String.class, JButton.class};
 
        @Override public int getColumnCount() {
            return columnNames.length;
        }
 
        @Override public int getRowCount() {
            return ListPH.size();
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
                    return ListPH.get(rowIndex).getTenPhong();
                case 2: 
                    return ListPH.get(rowIndex).getViTri();
                case 3: 
                    return ListPH.get(rowIndex).getSucChua();
                case 4: 
                    return ListPH.get(rowIndex).getMoTa();
                
                case 5:
                    return ListSelcet.get(rowIndex);
                default: return "Error";
            }
        } 
    }
    
    
    class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;
 
        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }
 
        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button
 
                    //*Checking the row or column is valid or not
            if (row < table.getRowCount() && row >= 0  && column < table.getColumnCount() && column >= 0)  {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    //perform a click event
                    ((JButton)value).doClick();
                }
            }
        }
    }
 
    class JTableButtonRenderer implements TableCellRenderer {        
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;  
        }
    }
}
