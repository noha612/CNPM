/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.PhongHocDAO;
import Model.PhongHoc;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestPhongHocDAO {
    @Test
    public void testTimPhongHocTheoId(){
        PhongHocDAO phDAO=new PhongHocDAO();
        //Exception test case 1
        PhongHoc ph=phDAO.TimPhongHocTheoId(7);
        Assert.assertNull(ph);
        
        //Exception test case 2
        ph=phDAO.TimPhongHocTheoId(322);
        Assert.assertNull(ph);

        //Standard test case 1
        ph=phDAO.TimPhongHocTheoId(1);
        Assert.assertNotNull(ph);
        Assert.assertEquals(1,ph.getPhongHocId());
        Assert.assertEquals("101 A2",ph.getTenPhong());
        Assert.assertEquals("Mặt Trước",ph.getViTri());
        Assert.assertEquals(59,ph.getSucChua());
        Assert.assertEquals("Máy chiếu + Điều hòa",ph.getMoTa());   
        Assert.assertEquals(1,ph.getTblTruongId());
    }
    
}
