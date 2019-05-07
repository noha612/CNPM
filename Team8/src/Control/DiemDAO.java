/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import static Control.DAO.getInstance;
import Model.Diem;
import Model.LopHocPhan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TaDuyHieu
 */
public class DiemDAO {
    public DiemDAO() {
        getInstance();
    }

    public ArrayList<Diem> getSinhVienTheoLHP(LopHocPhan LHP) {
        ArrayList<Diem> listStudent = new ArrayList<>();
        String sql = "SELECT tblsinhvien.*, tblNguoiDung.tenDangNhap, tblNguoiDung.hoTen FROM tblsinhvien"
                    + " LEFT JOIN tblNguoiDung ON tblNguoiDung.id = tblsinhvien.tblNguoiDungId"
                    + " LEFT JOIN tblPhieuDangKy ON tblPhieuDangKy.tblSinhVientblNguoiDungId = tblsinhvien.id"
                    + " LEFT JOIN tblLopHocPhan ON tblLopHocPhan.id = tblPhieuDangKy.tblLopHocPhanId"
                    + " WHERE tblLopHocPhan.id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, LHP.getLopHocPhanId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Diem sv = new Diem();
                sv.setSinhVienId(rs.getInt("id"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setHoTen(rs.getString("hoTen"));
                sv.setDiemCC(Double.parseDouble("-1"));
                sv.setDiemKT(Double.parseDouble("-1"));
                sv.setDiemBTL(Double.parseDouble("-1"));
                sv.setDiemTH(Double.parseDouble("-1"));
                sv.setDiemCK(Double.parseDouble("-1"));
                listStudent.add(sv);
           }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudent;
    }
    
    public void nhapDiemTheoLopHocPhan(ArrayList<Diem> ListStudent){
        for(Diem a: ListStudent){ 
            boolean exist = checkTonTaiDiem (a.getSinhVienId(), a.getIdMonHoc());
            if (exist == true) {
                String sql = "UPDATE tbldiem"
                             + " SET diemCC = ?, diemKT= ?, diemTH = ?, diemBTL = ?, diemCK = ?, kyHoc = ?"
                             + " WHERE tblMonHocId = ?"
                             + " AND tblSinhVientblNguoiDungId = ?";
                try {
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setDouble(1, a.getDiemCC());
                    ps.setDouble(2, a.getDiemKT());
                    ps.setDouble(3, a.getDiemTH());
                    ps.setDouble(4, a.getDiemBTL());
                    ps.setDouble(5, a.getDiemCK());
                    ps.setString(6, a.getKyHoc()+"");
                    ps.setInt(7, a.getIdMonHoc());
                    ps.setInt(8, a.getSinhVienId());
                    ps.executeUpdate();         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                String sql = "INSERT INTO tbldiem(diemCC, diemKT, diemTH, diemBTL, diemCK, kyHoc, tblMonHocId, tblSinhVientblNguoiDungId)"
                            + " VALUES (?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setDouble(1, a.getDiemCC());
                    ps.setDouble(2, a.getDiemKT());
                    ps.setDouble(3, a.getDiemTH());
                    ps.setDouble(4, a.getDiemBTL());
                    ps.setDouble(5, a.getDiemCK());
                    ps.setString(6, a.getKyHoc()+"");
                    ps.setInt(7, a.getIdMonHoc());
                    ps.setInt(8, a.getSinhVienId());
                    ps.executeUpdate();         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        }  
    }
    
    public boolean checkTonTaiDiem (int isSinhVien, int idMonHoc){
        String sql = "SELECT * FROM tbldiem"
                    + " WHERE tblSinhVientblNguoiDungId = ?"
                    + " AND tblMonHocId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isSinhVien);
            ps.setInt(2, idMonHoc);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return false;
            } 
            else{
                return true;
            }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int demSoBanGhiDiem(){
        int soLuong = 0;
        String sql = "SELECT COUNT(id) AS SL FROM tbldiem";                
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                soLuong =  rs.getInt("SL");
            }
            
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }
}


