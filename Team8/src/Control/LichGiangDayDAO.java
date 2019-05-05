/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.getInstance;
import Model.GiangVien;
import Model.LichGiangDay;
import Model.PhongHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ntnhu
 */
public class LichGiangDayDAO extends DAO{
    public LichGiangDayDAO() {
        getInstance();
    }
    public ArrayList<LichGiangDay> TimLichTheoIdLop(int tblLopHocPhanId){
        ArrayList<LichGiangDay> ListLGD=new ArrayList<>();
         String sql="Select * FROM tbllichgiangday WHERE tblLopHocPhanId = ? ORDER BY tblKipHocId ASC ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, tblLopHocPhanId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                LichGiangDay lgd=new LichGiangDay();
                lgd.setLichGiangDayId(rs.getInt("id"));
                lgd.setTblLopHocPhanId(tblLopHocPhanId);
                lgd.setTuanBatDau(rs.getInt("tuanBatDau"));
                lgd.setTuanKetThuc(rs.getInt("tuanKetThuc"));
                lgd.setTblGiangVientblNguoiDungId(rs.getInt("tblGiangVientblNguoiDungId"));
                lgd.setTblKipHocId(rs.getInt("tblKipHocId"));
                lgd.setTblPhongHocId(rs.getInt("tblPhongHocId"));
                ListLGD.add(lgd);
            }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListLGD;
    }    
    
    public ArrayList<PhongHoc> TimPhongGV(int idkip){
        ArrayList<PhongHoc> ListPH =new ArrayList<>();
         String sql="SELECT *FROM tblphonghoc WHERE tblphonghoc.id NOT IN (SELECT tbllichgiangday.tblPhongHocId FROM tbllichgiangday WHERE tbllichgiangday.tblKipHocId = ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, idkip);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                PhongHoc phonghoc =new PhongHoc();
                phonghoc.setPhongHocId(rs.getInt("id"));
                phonghoc.setTenPhong(rs.getString("tenPhong"));
                phonghoc.setViTri(rs.getString("viTri"));
                phonghoc.setSucChua(rs.getInt("suaChua"));
                phonghoc.setMoTa(rs.getString("moTa"));
                
                ListPH.add(phonghoc);
            }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPH;
    }    
    
    public void LenLich(LichGiangDay b)throws SQLException{
        String sql = "INSERT INTO tbllichgiangday(tuanBatDau, tuanKetThuc, tblKipHocId, tblPhongHocId, tblLopHocPhanId, tblGiangVientblNguoiDungId) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prstm = con.prepareStatement(sql);
            prstm.setInt(1, b.getTuanBatDau());
            prstm.setInt(2, b.getTuanKetThuc());
            prstm.setInt(3, b.getTblKipHocId());
            prstm.setInt(4, b.getTblPhongHocId());
            prstm.setInt(5, b.getTblLopHocPhanId());
            prstm.setInt(6, b.getTblGiangVientblNguoiDungId());
            prstm.executeUpdate();
        } catch (SQLException e ) {
            throw e;
        } 
    }
    
    public GiangVien  checkGV(int id, int kip){
        GiangVien GV=new GiangVien();
        String sql= "SELECT *FROM tbllichgiangday WHERE tblGiangVientblNguoiDungId = '"+id+"' AND tblKipHocId = '"+kip+"' ";
         try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return GV;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
}
