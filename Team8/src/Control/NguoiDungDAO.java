/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.getInstance;
import Model.NguoiDung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ntnhu
 */
public class NguoiDungDAO extends DAO {

    public NguoiDungDAO() {
        getInstance();
    }
    public NguoiDung TimNguoiDung(String tenDangNhap, String matKhau){
        String sql="Select * FROM tblnguoidung WHERE tenDangNhap = ? AND matKhau = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                rs.absolute(1);
                NguoiDung nd=new NguoiDung();
                nd.setNguoiDungId(rs.getInt("id"));
                nd.setTenDangNhap(rs.getString("tenDangNhap"));
                nd.setMatKhau(rs.getString("matKhau"));
                nd.setHoTen(rs.getString("hoTen"));
                nd.setNgaySinh(rs.getString("ngaySinh"));
                nd.setGioiTinh(rs.getString("gioiTinh"));
                nd.setVaiTro(rs.getString("vaiTro"));
                return nd;
            }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public NguoiDung TimNguoiDungTheoId(int id){
        NguoiDung nd=new NguoiDung();
        String sql="Select * FROM tblnguoidung WHERE id =?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
                rs.absolute(1);
                nd.setNguoiDungId(rs.getInt("id"));
                nd.setTenDangNhap(rs.getString("tenDangNhap"));
                nd.setMatKhau(rs.getString("matKhau"));
                nd.setHoTen(rs.getString("hoTen"));
                nd.setNgaySinh(rs.getString("ngaySinh"));
                nd.setGioiTinh(rs.getString("gioiTinh"));
                nd.setVaiTro(rs.getString("vaiTro"));
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nd;
    }
}
