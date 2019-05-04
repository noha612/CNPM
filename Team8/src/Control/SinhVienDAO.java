/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.SinhVien;
import Model.NguoiDung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ntnhu
 */
public class SinhVienDAO extends DAO {

    public SinhVienDAO() {
        getInstance();
    }
    public SinhVien TimSinhVien(NguoiDung nd){
        String sql="Select * FROM tblsinhvien WHERE tblNguoiDungId = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, nd.getNguoiDungId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==0)return null;
                SinhVien SV=new SinhVien();
                SV.setNguoiDungId(nd.getNguoiDungId());
                SV.setGioiTinh(nd.getGioiTinh());
                SV.setHoTen(nd.getHoTen());
                SV.setMatKhau(nd.getMatKhau());
                SV.setNgaySinh(nd.getNgaySinh());
                SV.setTenDangNhap(nd.getTenDangNhap());
                SV.setVaiTro(nd.getVaiTro());
                SV.setGpa(rs.getFloat("gpa"));
                SV.setHocLuc(rs.getString("hocLuc"));
                SV.setKhoa(rs.getString("khoa"));
                SV.setLop(rs.getString("lop"));
                SV.setNganh(rs.getString("nganh"));
                SV.setSinhVienId(rs.getInt("id"));
                SV.setStcTichLuy(rs.getInt("stcTichLuy"));
                return SV;
                //con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public SinhVien timSinhVien(String maSinhVien){
        String sql = "select tblsinhvien.*, tblnguoidung.hoTen, tblnguoidung.tenDangNhap from tblsinhvien, tblnguoidung where tblnguoidung.tenDangNhap=? and tblnguoidung.id=tblsinhvien.tblNguoiDungId";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSinhVien);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==0)return null;
                SinhVien rt = new SinhVien();
                rt.setSinhVienId(rs.getInt("id"));
                rt.setTenDangNhap(rs.getString("tenDangNhap"));
                rt.setHoTen( rs.getString("hoTen"));
                rt.setLop(rs.getString("lop")); 
                rt.setKhoa(rs.getString("khoa"));
                rt.setNganh(rs.getString("nganh"));
                rt.setGpa(rs.getFloat("gpa")); 
                rt.setStcTichLuy(rs.getInt("stcTichLuy"));
                rt.setHocLuc(rs.getString("hocLuc"));
                return rt;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
