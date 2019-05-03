/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.PhongHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ntnhu
 */
public class PhongHocDAO extends DAO{

    public PhongHocDAO() {
        getInstance();
    }
    public PhongHoc TimPhongHocTheoId(int id){
       PhongHoc PH=new PhongHoc();
        String sql="Select * FROM tblphonghoc WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            rs.absolute(1);
            PH.setPhongHocId(rs.getInt("id"));
            PH.setTenPhong(rs.getString("tenPhong"));
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PH;
    }
}
