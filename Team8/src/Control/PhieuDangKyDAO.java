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
    
    public void LuuDanhSachPDK(SinhVien SV,ArrayList<LopHocPhan> ListDK){
        LopHocPhanDAO lhpDAO=new LopHocPhanDAO();
        for(LopHocPhan i:ListDK){
            String sql="SELECT * FROM  tblphieudangky";           
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(SV.getSinhVienId()==rs.getInt("tblSinhVientblNguoiDungId")&&i.getLopHocPhanId()==rs.getInt("tblLopHocPhanId")){
                        lhpDAO.GiamSoLuongSinhVien(i);
                    }
                }       
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        XoaPDKCu(SV);
       
        for(LopHocPhan i:ListDK){          
            String sql="INSERT INTO tblphieudangky(thoiGian,hocPhi,tblLopHocPhanId,tblSinhVientblNguoiDungId) VALUES (?,?,?,?)";
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(2, "435000");
                java.util.Date Date=new java.util.Date();
                ps.setString(1, Date.toString());
                ps.setString(3, i.getLopHocPhanId()+"");
                ps.setString(4, SV.getSinhVienId()+"");
                ps.executeUpdate();         
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
        lhpDAO.TangSoLuongSinhVien(ListDK);
    }
    public void XoaPDKCu(SinhVien SV){
        String sql="DELETE FROM tblphieudangky WHERE tblSinhVientblNguoiDungId = '"+SV.getSinhVienId()+"'";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
