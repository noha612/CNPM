
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuanLiLichFrm extends javax.swing.JFrame implements ActionListener{
    
    private TrangChuGiaoVuFrm parent;
    public QuanLiLichFrm(TrangChuGiaoVuFrm parent){
        this.parent = parent;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        btnlenlich.addActionListener(this);
        btnsualich.addActionListener(this);
        btnXoa.addActionListener(this);
        btnback.addActionListener(this);
        this.setLocation(300, 150);
    }

   
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnlenlich = new javax.swing.JButton();
        btnsualich = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Quản Lý Lịch Học ");

        btnlenlich.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnlenlich.setText("Lên Lịch Cho Một Lớp Học Phần");
        btnlenlich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlenlichActionPerformed(evt);
            }
        });

        btnsualich.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnsualich.setText("Sửa Lịch Cho Một Lớp Học Phần ");

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.setText("Xóa Lịch Một Lớp Học Phần");

        btnback.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnback.setText("Quay Lại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnlenlich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsualich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1)))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlenlich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsualich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnback)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlenlichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlenlichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlenlichActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnlenlich;
    private javax.swing.JButton btnsualich;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnlenlich)){
            this.setVisible(false);
           (new TimMonGVFrm(this)).setVisible(true);
            return;
        }
        if(btnClicked.equals(btnsualich)){
            JOptionPane.showMessageDialog(this, "Chức năng này đang được cập nhật, vui lòng chọn chức năng khác để thao tác. ");
        }
        if(btnClicked.equals(btnXoa)){
            JOptionPane.showMessageDialog(this, "Chức năng này đăng được cập nhật, vui lòng chọn chức năng khác để thao tác. ");
        }
        if(btnClicked.equals(btnback)){
            parent.setVisible(true);
            this.dispose();
        }
        
    }
}
