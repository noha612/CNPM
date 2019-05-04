/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.LichGiangDayDAO;
import Model.LichGiangDay;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestLichGiangDayDAO {
    @Test
    public void testTimLichTheoIdLop(){
        LichGiangDayDAO lgdDAO=new LichGiangDayDAO();
        int i;
        //Exception test case 1
        i=0;
        ArrayList<LichGiangDay> ListLGD=lgdDAO.TimLichTheoIdLop(i);
        Assert.assertNotNull(ListLGD);
        Assert.assertEquals(0,ListLGD.size());
        
        //Standard test case 1
        i=3;
        ListLGD=lgdDAO.TimLichTheoIdLop(i);
        Assert.assertNotNull(ListLGD);
        Assert.assertEquals(2,ListLGD.size());
        for(LichGiangDay lgd : ListLGD){
            Assert.assertEquals(i,lgd.getTblLopHocPhanId());
        }
    }
}
