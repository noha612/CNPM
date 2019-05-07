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
    public void testTimPhieuDangKy(){
        PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
        //Exception test case 1
        ArrayList<PhieuDangKy> ListPDK=pdkDAO.TimPhieuDangKy(0);
        Assert.assertNotNull(ListPDK);
        Assert.assertEquals(0, ListPDK.size());
        //Exception test case 2
        ListPDK=pdkDAO.TimPhieuDangKy(-1);
        Assert.assertNotNull(ListPDK);
        Assert.assertEquals(0, ListPDK.size());
        //Exception test case 3
        ListPDK=pdkDAO.TimPhieuDangKy(1000);
        Assert.assertNotNull(ListPDK);
        Assert.assertEquals(0, ListPDK.size());
        //Standard test case 2
        ListPDK=pdkDAO.TimPhieuDangKy(1);
        Assert.assertNotNull(ListPDK);
        Assert.assertEquals(4, ListPDK.size());
        
    }
    @Test
    public void testLuuDanhSachPDK(){
        PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
        //Standard test case 1
        ArrayList<PhieuDangKy> ListPDK=new ArrayList<>();
        for(int i=0;i<4;i++){
            PhieuDangKy pdk = new PhieuDangKy();
            pdk.setTblLopHocPhanId(70+i);
            pdk.setTblSinhVienId(100);
            ListPDK.add(pdk);
        }
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            pdkDAO.LuuDanhSachPDK(ListPDK);
            int sl=pdkDAO.DemSoSVCuaLHP(70);
            Assert.assertEquals(1, sl);
            sl=pdkDAO.DemSoSVCuaLHP(71);
            Assert.assertEquals(1, sl);
            sl=pdkDAO.DemSoSVCuaLHP(72);
            Assert.assertEquals(1, sl);
            sl=pdkDAO.DemSoSVCuaLHP(73);
            Assert.assertEquals(1, sl);
            ListPDK=pdkDAO.TimPhieuDangKy(100);
            for(int i=0;i<ListPDK.size()-1;i++){
                Assert.assertTrue(ListPDK.get(i).getPhieuDangKyId()<ListPDK.get(i+1).getPhieuDangKyId());
            }
            Assert.assertTrue(ListPDK.get(0).getPhieuDangKyId()>177);
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
