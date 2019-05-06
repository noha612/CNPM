package Control;

import Model.BangDiem;
import Model.Diem;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BangDiemDAO extends DAO {

    public BangDiemDAO() {
        getInstance();
    }

    public ArrayList<Integer> thongKeSoLuong(int kyHoc) {
        ArrayList<Integer> rt = new ArrayList<>();
        String sql = "select count(tbl2.msv) as sl from(	select sum(tbl1.diemTongKet*soTinChi)/sum(tbl1.soTinChi) as diemTrungBinhKy, tbl1.msv 	from(		select tbldiem.tblSinhVientblNguoiDungId as msv,  tblmonhoc.soTinChi, (diemCC*hsChuyenCan + diemKT*hsKiemTra + diemBTL*hsBaiTapLon + diemTH*hsThucHanh + diemCK*hsCuoiKy) as diemTongKet 		from tblmonhoc, tbldiem 		where tbldiem.kyHoc=? and tbldiem.tblmonhocId=tblmonhoc.id        ) as tbl1 	group by tbl1.msv    ) as tbl2 where tbl2.diemTrungBinhKy>=? and tbl2.diemTrungBinhKy<?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, kyHoc);
            ps.setDouble(2, 0.0);
            ps.setDouble(3, 4.0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rt.add(rs.getInt("sl"));
            }

            ps.setDouble(2, 4.0);
            ps.setDouble(3, 6.5);
            rs = ps.executeQuery();
            while (rs.next()) {
                rt.add(rs.getInt("sl"));
            }

            ps.setDouble(2, 6.5);
            ps.setDouble(3, 8.0);
            rs = ps.executeQuery();
            while (rs.next()) {
                rt.add(rs.getInt("sl"));
            }

            ps.setDouble(2, 8.0);
            ps.setDouble(3, 9.0);
            rs = ps.executeQuery();
            while (rs.next()) {
                rt.add(rs.getInt("sl"));
            }

            ps.setDouble(2, 9.0);
            ps.setDouble(3, 10.1);
            rs = ps.executeQuery();
            while (rs.next()) {
                rt.add(rs.getInt("sl"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.reverse(rt);
        return rt;
    }

    public ArrayList<BangDiem> getBangDiemTheoHocLuc(int kyHoc, String hocLuc) {
        ArrayList<BangDiem> rt = new ArrayList<>();
        String sql = "select tbl2.msv, tbl2.diemTrungBinh from(	select sum(tbl1.diemTongKet*soTinChi)/sum(soTinChi) as diemTrungBinh, tbl1.msv as msv		from (		select tbldiem.maSinhVien as msv,  tblmonhoc.soTinChi, (diemCC*hsChuyenCan + diemKT*hsKiemTra + diemBTL*hsBaiTapLon + diemTH*hsThucHanh + diemCK*hsCuoiKy) as diemTongKet 		from tblmonhoc, tbldiem         where tbldiem.kyHoc=? and tbldiem.tblMonHocId=tblmonhoc.id        ) as tbl1		group by tbl1.msv	) as tbl2 where tbl2.diemTrungBinh >=? and tbl2.diemTrungBinh<? order by tbl2.diemTrungBinh desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, kyHoc);
            switch (hocLuc) {
                case "Yeu":
                    ps.setDouble(2, 0.0);
                    ps.setDouble(3, 4.0);
                    break;
                case "Trung Binh":
                    ps.setDouble(2, 4.0);
                    ps.setDouble(3, 6.5);
                    break;
                case "Kha":
                    ps.setDouble(2, 6.5);
                    ps.setDouble(3, 8.0);
                    break;
                case "Gioi":
                    ps.setDouble(2, 8.0);
                    ps.setDouble(3, 9.0);
                    break;
                case "Xuat Sac":
                    ps.setDouble(2, 9.0);
                    ps.setDouble(3, 10.1);
                    break;
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BangDiem bd = new BangDiem();
                String maSinhVien = rs.getString("msv");
                bd.setTrungBinh(rs.getDouble("diemTrungBinh"));
                String sql2 = "select tbldiem.*, (diemCC*hsChuyenCan + diemKT*hsKiemTra + diemBTL*hsBaiTapLon + diemTH*hsThucHanh + diemCK*hsCuoiKy) as tongKet from tbldiem,tblmonhoc where tbldiem.kyHoc=? and tbldiem.maSinhVien=? and tbldiem.tblMonHocId=tblmonhoc.id";
                PreparedStatement ps2 = con.prepareCall(sql2);
                ps2.setInt(1, kyHoc);
                ps2.setString(2, maSinhVien);
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<Diem> listDiem = new ArrayList<>();
                while (rs2.next()) {
                    Diem tmp = new Diem();
                    tmp.setDiemCC(rs2.getDouble("diemCC"));
                    tmp.setDiemKT(rs2.getDouble("diemKT"));
                    tmp.setDiemBTL(rs2.getDouble("diemBTL"));
                    tmp.setDiemTH(rs2.getDouble("diemTH"));
                    tmp.setDiemCK(rs2.getDouble("diemCK"));
                    tmp.setIdMonHoc(rs2.getInt("tblMonhocId"));
                    tmp.setKyHoc(rs2.getInt("kyHoc"));
                    tmp.setTongKet(rs2.getDouble("tongKet"));
                    listDiem.add(tmp);
                }
                bd.setListDiem(listDiem);
                rt.add(bd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }


}
