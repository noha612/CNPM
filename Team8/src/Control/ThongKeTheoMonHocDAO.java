/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Control.DAO;
import Control.DAO;
import static Control.DAO.con;
import Model.MonHoc;
import java.sql.*;
import Model.ThongKeTheoMonHoc;
import java.util.ArrayList;

/**
 *
 * @author nguyenthang
 */
public class ThongKeTheoMonHocDAO extends DAO{
    public ThongKeTheoMonHocDAO(){
        getInstance();
    }
    public ArrayList<ThongKeTheoMonHoc> layThongKeTheoMonHoc(String kiBatDau, String kiKetThuc){
        ArrayList<ThongKeTheoMonHoc> ltk = null;
        ltk=new ArrayList<>();
        String sql = "SELECT tblmonhoc.id,tblmonhoc.tenMon, tblmonhoc.khoa,X.TongSo, Y.QuaMon,(X.TongSo - Y.QuaMon) AS TruotMon, X.TrungBinh  FROM tblmonhoc, (SELECT tblMonHocId, COUNT(tblSinhVientblNguoiDungId) AS TongSo, AVG(diemCC*tblmonhoc.hsChuyenCan +diemKT*tblmonhoc.hsKiemTra+ diemTH*tblmonhoc.hsThucHanh + diemBTL*tblmonhoc.hsBaiTapLon +diemCK*tblmonhoc.hsCuoiKy) AS TrungBinh  FROM tbldiem, tblmonhoc WHERE kyHoc >= ?  AND kyHoc <=? AND tbldiem.tblMonHocId=tblmonhoc.id  GROUP BY tblMonHocId) AS X, (SELECT tblMonHocId, COUNT(tblSinhVientblNguoiDungId) AS QuaMon FROM tbldiem, tblmonhoc WHERE kyHoc >= ? AND kyHoc <=? AND tbldiem.tblMonHocId=tblmonhoc.id  AND (diemCC*tblmonhoc.hsChuyenCan +diemKT*tblmonhoc.hsKiemTra+ diemTH*tblmonhoc.hsThucHanh + diemBTL*tblmonhoc.hsBaiTapLon +diemCK*tblmonhoc.hsCuoiKy)>4 GROUP BY tblMonHocId) AS Y  WHERE tblmonhoc.id=X.tblMonHocId AND tblmonhoc.id=Y.tblMonHocId ORDER BY X.TrungBinh DESC, tblmonhoc.id ASC ;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kiBatDau);
            ps.setString(2, kiKetThuc);
            ps.setString(3, kiBatDau);
            ps.setString(4, kiKetThuc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongKeTheoMonHoc tkmh=new ThongKeTheoMonHoc();
                tkmh.setMonID(rs.getInt("ID"));
                tkmh.setTenMon(rs.getString("tenMon"));
                tkmh.setKhoa(rs.getString("Khoa"));
                tkmh.setTongSoSinhVien(rs.getInt("TongSo"));
                tkmh.setTongSoQuaMon(rs.getInt("QuaMon"));
                tkmh.setTongSoTruot(rs.getInt("TruotMon"));
                tkmh.setTrungBinh(rs.getFloat("TrungBinh"));
                tkmh.setKiBD(kiBatDau);
                tkmh.setKiKT(kiKetThuc);
                ltk.add(tkmh);
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ltk;
    }

}
