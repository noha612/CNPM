/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.MonHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ntnhu
 */
public class MonHocDAO extends DAO{

    public MonHocDAO() {
        getInstance();
    }
    
    public ArrayList<MonHoc> TimMonTheoTen(String tenMon){
        ArrayList<MonHoc> ListMH=new ArrayList<>();
        if(tenMon=="")return ListMH;
        String sql="Select * FROM tblmonhoc WHERE tenMon LIKE ? ORDER BY maMon ASC";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + tenMon + "%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                MonHoc mh=new MonHoc();
                mh.setMonHocId(rs.getInt("id"));
                mh.setMaMon(rs.getString("maMon"));
                mh.setTenMon(rs.getString("tenMon"));
                mh.setSoTinChi(rs.getInt("soTinChi"));
                ListMH.add(mh);
           }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMH;
        }

    
    public MonHoc timMonHoc(int ID){
        String sql = "select * from tblmonhoc where tblmonhoc.id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==0)return null;
                MonHoc rt = new MonHoc();
                rt.setMonHocId(rs.getInt("id")); 
                rt.setTenMon(rs.getString("tenMon")); 
                rt.setSoTinChi(rs.getInt("soTinChi")); 
                rt.setSoTietLT(rs.getInt("soTietLT")); 
                rt.setSoTietBT(rs.getInt("soTietBT"));
                rt.setSoTietTH(rs.getInt("soTietTH"));
                rt.setHsChuyenCan(rs.getDouble("hsChuyenCan")); 
                rt.setHsKiemTra(rs.getDouble("hsKiemTra")); 
                rt.setHsBaiTapLon(rs.getDouble("hsBaiTapLon")); 
                rt.setHsThucHanh(rs.getDouble("hsThucHanh")); 
                rt.setHsCuoiKy(rs.getDouble("hsCuoiKy")); 
                rt.setMonDK(rs.getString("monDK")); 
                rt.setBoMon(rs.getString("boMon")); 
                rt.setKhoa(rs.getString("khoa"));
                rt.setMaMon(rs.getString("maMon"));
                return rt;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
 
}
