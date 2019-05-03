/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.LopHocPhan;
import Model.MonHoc;
import Model.PhieuDangKy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ntnhu
 */
public class LopHocPhanDAO extends DAO{

    public LopHocPhanDAO() {
        getInstance();
    }
    public ArrayList<LopHocPhan> TimLopTheoMon(MonHoc MH){
        ArrayList<LopHocPhan> ListLHP=new ArrayList<>();
         String sql="Select * FROM tbllophocphan WHERE tblMonHocId = ? ORDER BY maLop";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, MH.getMonHocId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                LopHocPhan lhp=new LopHocPhan();
                lhp.setMonHocId(MH.getMonHocId());
                lhp.setTenMon(MH.getTenMon());
                lhp.setMaMon(MH.getMaMon());
                lhp.setSoTinChi(MH.getSoTinChi());
                lhp.setLopHocPhanId(rs.getInt("id"));
                lhp.setMaLop(rs.getString("maLop"));
                lhp.setTen(rs.getString("ten"));
                lhp.setSiSo(rs.getInt("siSo"));
                PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
                lhp.setDaChon(pdkDAO.DemSoSVCuaLHP(rs.getInt("id")));
                ListLHP.add(lhp);
           }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListLHP;
    }

}
