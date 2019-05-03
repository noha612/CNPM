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
    
    public MonHoc TimMonHocTheoId(int id){
       MonHoc MH=new MonHoc();
        String sql="Select * FROM tblmonhoc WHERE id = '"+id+"'";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.absolute(1);
            MH.setMonHocId(id);
            MH.setTenMon(rs.getString("tenMon"));
            MH.setMaMon(rs.getString("maMon"));
            MH.setSoTinChi(rs.getInt("soTinChi"));
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MH;
    }
    
    public MonHoc timMonHoc(int ID){
        String sql = "select * from tblmonhoc where tblmonhoc.id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MonHoc rt = new MonHoc(rs.getInt("id"), rs.getString("tenMon"), rs.getInt("soTinChi"), rs.getInt("soTietLT"), 
                                rs.getInt("soTietBT"), rs.getInt("soTietTH"), rs.getDouble("hsChuyenCan"), 
                                rs.getDouble("hsKiemTra"), rs.getDouble("hsBaiTapLon"), rs.getDouble("hsThucHanh"), rs.getDouble("hsCuoiKy"), 
                                rs.getString("monDK"), rs.getString("boMon"), rs.getString("khoa"));
                return rt;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new MonHoc();
    }
 
}
