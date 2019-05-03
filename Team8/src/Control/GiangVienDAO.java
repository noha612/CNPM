/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.GiangVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ntnhu
 */
public class GiangVienDAO extends DAO{

    public GiangVienDAO() {
        getInstance();
    }
    public GiangVien TimGiangVienTheoId(int id){
       GiangVien GV=new GiangVien();
        String sql="Select * FROM tblgiangvien WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            rs.absolute(1);
            GV.setTblNguoiDungId(rs.getInt("tblNguoiDungId"));
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GV;
    }
}
