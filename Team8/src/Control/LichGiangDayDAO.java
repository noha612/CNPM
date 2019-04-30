/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.getInstance;
import Model.LichGiangDay;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
         String sql="Select * FROM tbllichgiangday WHERE tblLopHocPhanId = '"+tblLopHocPhanId+"'";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
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
}
