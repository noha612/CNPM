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
        for(PhieuDangKy i:ListPDK){
            String sql="SELECT * FROM  tblphieudangky";           
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(i.getTblSinhVienId()==rs.getInt("tblSinhVientblNguoiDungId")&&i.getTblLopHocPhanId()==rs.getInt("tblLopHocPhanId")){
                        lhpDAO.GiamSoLuongSinhVien(i.getTblLopHocPhanId());
                    }
                }       
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        XoaPDKCu(ListPDK);
       
        for(PhieuDangKy i:ListPDK){          
            String sql="INSERT INTO tblphieudangky(thoiGian,hocPhi,tblLopHocPhanId,tblSinhVientblNguoiDungId) VALUES (?,?,?,?)";
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
    public void XoaPDKCu(ArrayList<PhieuDangKy> ListPDK){
        int idSV=ListPDK.get(0).getTblSinhVienId();
        String sql="DELETE FROM tblphieudangky WHERE tblSinhVientblNguoiDungId = '"+idSV+"'";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
