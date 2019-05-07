/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.*;
import Model.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestKipHocDAO {
    @Test
    public void testTimKipHocTheoId(){
        KipHocDAO khDAO=new KipHocDAO();
        //Exception test case 1
        KipHoc kh=khDAO.TimKipHocTheoId(31);
        Assert.assertNull(kh);
        
        //Exception test case 2
        kh=khDAO.TimKipHocTheoId(322);
        Assert.assertNull(kh);
        
        //Standard test case 1
        kh=khDAO.TimKipHocTheoId(1);
        Assert.assertNotNull(kh);
        Assert.assertEquals(1,kh.getKipHocId());
        Assert.assertEquals(7,kh.getGioBatDau());
        Assert.assertEquals(9,kh.getGioKetThuc());
        Assert.assertEquals(2,kh.getThu());
    }
    @Test
    
    public void testTimKipGV(){
        KipHocDAO khDAO = new KipHocDAO();
        
        //Exception test case 1
        KipHoc kh = khDAO.TimKipGV(6, 8, 1);
        Assert.assertNull(kh);
        
        //Exception test case 2
        kh = khDAO.TimKipGV(3, 1, 2);
        Assert.assertNull(kh);
        
        //Exception test case 3
        kh = khDAO.TimKipGV(7, 10, 2);
        Assert.assertNull(kh);
        
        //Standard test case
        kh= khDAO.TimKipGV(7, 9, 2);
        Assert.assertNotNull(kh);
        Assert.assertEquals(1, kh.getKipHocId());       
        Assert.assertEquals(7, kh.getGioBatDau());
        Assert.assertEquals(9, kh.getGioKetThuc());
        Assert.assertEquals(2, kh.getThu());
    }
}
