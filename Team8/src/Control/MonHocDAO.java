/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.GiangVien;
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
        String sql="Select * FROM tblmonhoc WHERE tenMon LIKE ? ORDER BY tenMon ASC, maMon ASC";
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
                mh.setSoTietLT(rs.getInt("soTietLT")); 
                mh.setSoTietBT(rs.getInt("soTietBT"));
                mh.setSoTietTH(rs.getInt("soTietTH"));
                mh.setHsChuyenCan(rs.getDouble("hsChuyenCan")); 
                mh.setHsKiemTra(rs.getDouble("hsKiemTra")); 
                mh.setHsBaiTapLon(rs.getDouble("hsBaiTapLon")); 
                mh.setHsThucHanh(rs.getDouble("hsThucHanh")); 
                mh.setHsCuoiKy(rs.getDouble("hsCuoiKy")); 
                mh.setMonDK(rs.getString("monDK")); 
                mh.setBoMon(rs.getString("boMon")); 
                mh.setKhoa(rs.getString("khoa"));
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
    
     public ArrayList<MonHoc> GVTimMonTheoTen(String tenMon){
        ArrayList<MonHoc> ListMH=new ArrayList<>();
        String sql="Select * FROM tblmonhoc WHERE tenMon LIKE ? ORDER BY tenMon ASC";
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
                mh.setSoTietLT(rs.getInt("soTietLT"));
                mh.setSoTietTH(rs.getInt("soTietTH"));
                mh.setSoTietBT(rs.getInt("soTietBT"));
                mh.setBoMon(rs.getString("boMon"));
                mh.setKhoa(rs.getString("khoa"));
                mh.setMonDK(rs.getString("monDK"));
                ListMH.add(mh);
           }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMH;
        }
     
    public ArrayList<MonHoc> timMonHocTheoKey(GiangVien GV, String key, String hocky){
        ArrayList<MonHoc> ListMH = new ArrayList<>();
        String sql = "SELECT * FROM tblmonhoc"
                     + " WHERE tblmonhoc.id IN (SELECT DISTINCT tblmonhoc.id FROM tblmonhoc"
                     + " LEFT JOIN tbllophocphan ON tbllophocphan.tblMonHocId = tblmonhoc.id"
                     + " LEFT JOIN tbllichgiangday ON tbllichgiangday.tblLopHocPhanId = tbllophocphan.id"
                     + " LEFT JOIN tblgiangvien ON tblgiangvien.id = tbllichgiangday.tblGiangVientblNguoiDungId"
                     + " WHERE tblmonhoc.tenMon LIKE ?"
                     + " AND tbllophocphan.hocKy = ?"
                     + " AND tbllichgiangday.tblGiangVientblNguoiDungId = ?) ORDER BY tenMon ASC";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, hocky);
            ps.setInt(3, GV.getGiangVienId());
            ResultSet rs = ps.executeQuery();
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
 
}
