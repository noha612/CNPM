/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author nguyenthang
 */
public class ThongKeLopHocPhanDAO extends DAO{
    
    public ThongKeLopHocPhanDAO() {
        getInstance();
    }
    
    public ArrayList<ThongKeLopHocPhan> layThongKeLopHocPhan(String kyBD,String kyKT, Integer monHocID){
        ArrayList<ThongKeLopHocPhan> ltk=null;
        ltk=new ArrayList<>();
        String sql="SELECT tbllophocphan.id AS maLop,tbllophocphan.hocKy AS hocKy,tbllophocphan.ten AS LopHocPhan,tblnguoidung.hoTen AS GiangVien,Z.sySo AS Syso, X.Tong/Z.sySo AS DiemTB,Y.QuaMon/Z.sySo*100 AS TyLe  FROM tbllophocphan,tblnguoidung,tbllichgiangday, tblgiangvien,(SELECT tblLopHocPhanId AS C,COUNT(id) AS sySo FROM  tblphieudangky GROUP BY tblLopHocPhanId) AS Z, (SELECT tbllophocphan.id AS A, SUM(diemCC*hsChuyenCan+diemBTL*hsBaiTapLon+diemKT*hsKiemTra+diemTH*hsThucHanh+diemCK*hsCuoiKy) AS Tong FROM tbldiem,tblmonhoc,tbllophocphan WHERE kyHoc >= ? AND kyHoc <= ? AND  tbldiem.tblMonHocId=? AND tblmonhoc.id=tbldiem.tblMonHocId AND tbllophocphan.tblMonHocId=tblmonhoc.id GROUP BY tbllophocphan.id ) AS X,  (SELECT tbllophocphan.id AS B, COUNT(tbldiem.tblSinhVientblNguoiDungId) AS QuaMon FROM tbldiem,tblmonhoc,tbllophocphan  WHERE kyHoc >=?  AND kyHoc <= ? AND  tbldiem.tblMonHocId=? AND tblmonhoc.id=tbldiem.tblMonHocId  AND tbllophocphan.tblMonHocId=tblmonhoc.id  AND (diemCC*hsChuyenCan+diemBTL*hsBaiTapLon+diemKT*hsKiemTra+diemTH*hsThucHanh+diemCK*hsCuoiKy)>=4 GROUP BY tbllophocphan.id ) AS Y  WHERE X.A=Y.B AND tbllophocphan.id=X.A  AND tbllophocphan.id=tbllichgiangday.tblLopHocPhanId  AND tblgiangvien.id=tbllichgiangday.tblGiangVientblNguoiDungId AND tblgiangvien.tblNguoiDungId=tblnguoidung.id AND Z.C=tbllichgiangday.tblLopHocPhanId  ORDER BY TyLe DESC,Syso ASC";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, kyBD);
            ps.setString(2, kyKT);
            ps.setInt(3,monHocID);
            ps.setString(4, kyBD);
            ps.setString(5, kyKT);
            ps.setInt(6,monHocID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongKeLopHocPhan tklhp=new ThongKeLopHocPhan();
                tklhp.setLopHocPhan(rs.getString("LopHocPhan"));
                tklhp.setGiangVien(rs.getString("GiangVien"));
                tklhp.setSySo(rs.getInt("SySo"));
                tklhp.setDiemTB(rs.getFloat("DiemTB"));
                tklhp.setTyLeQuaMon(rs.getInt("TyLe"));
                tklhp.setKyBD(kyBD);
                tklhp.setKyKT(kyKT);
                tklhp.setMaLop(rs.getString("maLop"));
                tklhp.setHocKy(rs.getString("hocKy"));
                ltk.add(tklhp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ltk;
    }
    
}
