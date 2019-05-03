/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.LopHocPhan;
import Model.PhieuDangKy;
import Model.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ntnhu
 */
public class PhieuDangKyDAO extends DAO{

    public PhieuDangKyDAO() {
        getInstance();
    }
    
    public void LuuDanhSachPDK(ArrayList<PhieuDangKy> ListPDK){
        LopHocPhanDAO lhpDAO=new LopHocPhanDAO();
        PhieuDangKy pdk=ListPDK.get(0);
        String sql="SELECT * FROM  tblphieudangky WHERE tblSinhVientblNguoiDungId = ?";           
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, pdk.getTblSinhVienId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                lhpDAO.GiamSoLuongSinhVien(rs.getInt("tblLopHocPhanId"));
            }      
        } catch (Exception e) {
            e.printStackTrace();
        }    
        
        int idSV=ListPDK.get(0).getTblSinhVienId();
        sql="DELETE FROM tblphieudangky WHERE tblSinhVientblNguoiDungId = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idSV);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        for(PhieuDangKy i:ListPDK){          
            sql="INSERT INTO tblphieudangky(thoiGian,hocPhi,tblLopHocPhanId,tblSinhVientblNguoiDungId) VALUES (?,?,?,?)";
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(2, i.getHocPhi());
                ps.setString(1, i.getThoiGian());
                ps.setInt(3, i.getTblLopHocPhanId());
                ps.setInt(4, i.getTblSinhVienId());
                ps.executeUpdate();         
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
        
        lhpDAO.TangSoLuongSinhVien(ListPDK);
    }
    

}
