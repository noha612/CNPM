/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.LopHocPhanDAO;
import Model.LopHocPhan;
import Model.MonHoc;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestLopHocPhanDAO {
    @Test
    public void testTimLopTheoMon(){
        LopHocPhanDAO lhpDAO=new LopHocPhanDAO();
        MonHoc MH=new MonHoc();
        
        //Exception test case 1
        MH.setMonHocId(0);
        ArrayList<LopHocPhan> ListLHP=lhpDAO.TimLopTheoMon(MH);
        Assert.assertNotNull(ListLHP);
        Assert.assertEquals(0,ListLHP.size());
        
        //Standard test case 1
        MH.setMonHocId(4);
        ListLHP=lhpDAO.TimLopTheoMon(MH);
        Assert.assertNotNull(ListLHP);
        Assert.assertEquals(5,ListLHP.size());
        for(LopHocPhan lhp : ListLHP){
            Assert.assertEquals(MH.getMonHocId(),lhp.getMonHocId());
        }
    }
    
}
