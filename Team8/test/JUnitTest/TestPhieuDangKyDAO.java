/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.PhieuDangKyDAO;
import org.junit.*;

/**
 *
 * @author ntnhu
 */
public class TestPhieuDangKyDAO {
    @Test
    public void testDemSoSVcuaLHP(){
        PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
        //Standard test case 
        int sl=pdkDAO.DemSoSVCuaLHP(8);
        Assert.assertEquals(3, sl);
    }
}
