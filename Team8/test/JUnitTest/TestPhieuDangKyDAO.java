/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.DAO;
import Control.PhieuDangKyDAO;
import Model.PhieuDangKy;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.*;

/**
 *
 * @author ntnhu
 */
public class TestPhieuDangKyDAO {
    @Test
    public void testDemSoSVcuaLHP(){
        PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
        //Exception test case 1
        int sl=pdkDAO.DemSoSVCuaLHP(-1);
        Assert.assertEquals(0, sl);
        //Standard test case 1
        sl=pdkDAO.DemSoSVCuaLHP(16);
        Assert.assertEquals(5, sl);
        //Standard test case 2
        sl=pdkDAO.DemSoSVCuaLHP(80);
        Assert.assertEquals(0, sl);
    }
    @Test
    public void testLuuDanhSachPDK(){
        PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
        //Standard test case 1
        ArrayList<PhieuDangKy> ListPDK=new ArrayList<>();
        for(int i=0;i<4;i++){
            PhieuDangKy pdk = new PhieuDangKy();
            pdk.setTblLopHocPhanId(80);
            pdk.setTblSinhVienId(100+i);
            ListPDK.add(pdk);
        }
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            pdkDAO.LuuDanhSachPDK(ListPDK);
            int sl=pdkDAO.DemSoSVCuaLHP(80);
            Assert.assertEquals(4, sl);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }
    }
}
