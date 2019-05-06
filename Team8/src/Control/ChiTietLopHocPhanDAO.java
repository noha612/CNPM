/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.ChiTietLopHocPhan;
import Model.Diem;
import Model.LopHocPhan;
import Model.ThongKeLopHocPhan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguyenthang
 */
public class ChiTietLopHocPhanDAO extends DAO{

    public ChiTietLopHocPhanDAO() {
        getInstance();
    }
    public ArrayList<ChiTietLopHocPhan> layDiem(String maLop, String hocKy){
        ArrayList<ChiTietLopHocPhan> ltk=null;
        ltk=new ArrayList<>();
        String sql="SELECT tblnguoidung.hoTen AS HoTen, tbldiem.diemCC AS DiemCC,tbldiem.diemKT AS DiemKT,tbldiem.diemTH AS DiemTH,tbldiem.diemBTL AS DiemBTL,tbldiem.diemCK AS DiemCK, (diemCC*hsChuyenCan+diemBTL*hsBaiTapLon+diemKT*hsKiemTra+diemTH*hsThucHanh+diemCK*hsCuoiKy) AS DiemTB " +
                    "FROM tblsinhvien,tblmonhoc,tbldiem,tblnguoidung,tbllophocphan,tblphieudangky " +
                        "WHERE tbldiem.tblMonHocId=tblmonhoc.id " +
                        "AND tblphieudangky.tblSinhVientblNguoiDungId=tbldiem.tblSinhVientblNguoiDungId " +
                        "AND tblphieudangky.tblLopHocPhanId=tbllophocphan.id " +
                        "AND tblnguoidung.id=tblsinhvien.tblNguoiDungId " +
                        "AND tbldiem.tblSinhVientblNguoiDungId=tblsinhvien.id " +
                        "AND tblmonhoc.id=tbllophocphan.tblMonHocId  " +
                        "AND tbllophocphan.id= ? " +
                        "AND tbldiem.kyHoc=? " +
                    "ORDER BY DiemTB DESC, HoTen ASC";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, maLop);
            ps.setString(2, hocKy);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietLopHocPhan ctlhp=new ChiTietLopHocPhan();
                ctlhp.setTenSinhVien(rs.getString("HoTen"));
                ctlhp.setDiemCC(rs.getDouble("DiemCC"));
                ctlhp.setDiemKT(rs.getDouble("DiemKT"));
                ctlhp.setDiemTH(rs.getDouble("DiemTH"));
                ctlhp.setDiemBTL(rs.getDouble("DiemBTL"));
                ctlhp.setDiemCK(rs.getDouble("DiemCk"));
                ctlhp.setTrungBinh(rs.getFloat("DiemTB"));
                ltk.add(ctlhp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ltk;
    }
    
    
}
