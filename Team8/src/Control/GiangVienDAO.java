/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.GiangVien;
import Model.NguoiDung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ntnhu
 */
public class GiangVienDAO extends DAO{

    public GiangVienDAO() {
        getInstance();
    }
    public GiangVien TimGiangVienTheoId(int id){
       GiangVien GV=null;
        String sql="Select * FROM tblgiangvien WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==0)return null;
                GV=new GiangVien();
                GV.setGiangVienId(rs.getInt("id"));
                GV.setKhoa(rs.getString("khoa"));
                GV.setHocVi(rs.getString("hocVi"));
                GV.setNganh(rs.getString("nganh"));
                GV.setBoMon(rs.getString("boMon"));
                GV.setTblNguoiDungId(rs.getInt("tblNguoiDungId"));
            //con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();          
        }
        return GV;
    }
    
    public ArrayList<GiangVien> TimGVTheoKhoa(String tenKhoa){
        ArrayList<GiangVien> ListGV =new ArrayList<>();
        String sql = "select tblgiangvien.*, tblnguoidung.* From tblgiangvien, tblnguoidung where  tblgiangvien.tblNguoiDungId = tblnguoidung.id and tblgiangvien.khoa = ? ORDER BY hoTen ASC";
      //  String sql="Select * FROM tblgiangvien WHERE khoa LIKE ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, tenKhoa);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                GiangVien gv =new GiangVien();
                gv.setGiangVienId(rs.getInt("id"));
                gv.setHoTen(rs.getString("hoTen"));
                gv.setHocVi(rs.getString("hocVi"));
                gv.setNganh(rs.getString("nganh"));
                gv.setKhoa(rs.getString("khoa"));
                gv.setTenDangNhap(rs.getString("tenDangNhap"));
                ListGV.add(gv);
           }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListGV;
        }
    public GiangVien TimGiangVien(NguoiDung nd){
        GiangVien GV = null;
        String sql="Select * FROM tblgiangvien WHERE tblNguoiDungId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nd.getNguoiDungId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")!=0)GV=new GiangVien();
                GV.setNguoiDungId(nd.getNguoiDungId());
                GV.setGioiTinh(nd.getGioiTinh());
                GV.setHoTen(nd.getHoTen());
                GV.setMatKhau(nd.getMatKhau());
                GV.setNgaySinh(nd.getNgaySinh());
                GV.setTenDangNhap(nd.getTenDangNhap());
                GV.setVaiTro(nd.getVaiTro());
                GV.setGiangVienId(rs.getInt("id"));
                GV.setKhoa(rs.getString("khoa"));
                GV.setNganh(rs.getString("nganh"));
                GV.setHocVi(rs.getString("hocVi"));
                GV.setBoMon(rs.getString("boMon"));
                //con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GV;
    }
}
