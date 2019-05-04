/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.MonHocDAO;
import Model.MonHoc;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestMonHocDAO {
    @Test
    public void testTimMonTheoTen(){
        MonHocDAO mhDAO=new MonHocDAO();
        MonHoc MH=new MonHoc();
        String x=null;
        //Exception test case 1
        x="djkgkdghkasdgh";
        ArrayList<MonHoc> ListMH=mhDAO.TimMonTheoTen(x);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(ListMH.size(), 0);
        
        //Exception test case 2
        x="";
        ListMH=mhDAO.TimMonTheoTen(x);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(ListMH.size(), 0);
        
        //Standard test case 1
        x="x";
        ListMH=mhDAO.TimMonTheoTen(x);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(ListMH.size(), 2);
        for(MonHoc mh : ListMH){
            Assert.assertTrue(mh.getTenMon().toLowerCase().contains(x));
        }
    }
    @Test
    public void testTimMonHocTheoId(){
        MonHocDAO mhDAO=new MonHocDAO();
        //Exception test case 1
        MonHoc mh=mhDAO.timMonHoc(13);
        Assert.assertNull(mh);
        
        //Exception test case 2
        mh=mhDAO.timMonHoc(322);
        Assert.assertNull(mh);
        
        //Standard test case 1
        mh=mhDAO.timMonHoc(1);
        Assert.assertNotNull(mh);
        Assert.assertEquals(mh.getMonHocId(), 1);
        Assert.assertEquals(mh.getSoTinChi(), 3);
        Assert.assertEquals(mh.getBoMon(), "CNPM");
        Assert.assertTrue(mh.getHsBaiTapLon()== 0.2);
        Assert.assertTrue(mh.getHsChuyenCan()==0.1);
        Assert.assertTrue(mh.getHsCuoiKy()==0.6);
        Assert.assertTrue(mh.getHsKiemTra()==0.1);
        Assert.assertTrue(0==mh.getHsThucHanh());
        Assert.assertEquals(mh.getKhoa(), "CNTT");
        Assert.assertEquals(mh.getMaMon(), "INT1340");
        Assert.assertEquals(mh.getMonDK(), null);
        Assert.assertEquals(mh.getSoTietBT(), 0);
        Assert.assertEquals(mh.getSoTietTH(), 0);
        Assert.assertEquals(mh.getSoTietLT(), 45);
        Assert.assertEquals(mh.getTenMon(), "Nhập môn Công nghệ phần mềm");
    }
    
}
