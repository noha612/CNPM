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
        PhieuDangKy pdk=ListPDK.get(0);  
        int idSV=ListPDK.get(0).getTblSinhVienId();
        String sql="DELETE FROM tblphieudangky WHERE tblSinhVientblNguoiDungId = ?";
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

    }
    
    public int DemSoSVCuaLHP(int idLHP){
        int daChon=0;
        String sql="SELECT tblLopHocPhanId,COUNT(id) AS daChon FROM  tblphieudangky GROUP BY tblLopHocPhanId";  
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(idLHP==rs.getInt("tblLopHocPhanId"))daChon=rs.getInt("daChon");
            }
        } catch (Exception e) {
        }
        return daChon;
    }
}
