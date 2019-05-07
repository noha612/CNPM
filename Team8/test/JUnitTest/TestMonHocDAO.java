/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.MonHocDAO;
import Model.GiangVien;
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
        Assert.assertEquals(0,ListMH.size());
        
        //Exception test case 2
        x="";
        ListMH=mhDAO.TimMonTheoTen(x);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(0,ListMH.size());
        
        //Standard test case 1
        x="x";
        ListMH=mhDAO.TimMonTheoTen(x);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(3,ListMH.size());
        for(MonHoc mh : ListMH){
            Assert.assertTrue(mh.getTenMon().toLowerCase().contains(x));
        }
        for(int k=0;k<ListMH.size()-1;k++){
            Assert.assertTrue(ListMH.get(k).getTenMon().charAt(0)<=ListMH.get(k+1).getTenMon().charAt(0));
        }
    }
    @Test
    public void testTimMonHocTheoId(){
        MonHocDAO mhDAO=new MonHocDAO();
        //Exception test case 1
        MonHoc mh=mhDAO.timMonHoc(32);
        Assert.assertNull(mh);
        
        //Exception test case 2
        mh=mhDAO.timMonHoc(322);
        Assert.assertNull(mh);
        
        //Standard test case 1
        mh=mhDAO.timMonHoc(1);
        Assert.assertNotNull(mh);
        Assert.assertEquals(1,mh.getMonHocId());
        Assert.assertEquals(3,mh.getSoTinChi());
        Assert.assertEquals("x",mh.getBoMon());
        Assert.assertTrue(mh.getHsBaiTapLon()== 0.2);
        Assert.assertTrue(mh.getHsChuyenCan()==0.1);
        Assert.assertTrue(mh.getHsCuoiKy()==0.6);
        Assert.assertTrue(mh.getHsKiemTra()==0.1);
        Assert.assertTrue(0==mh.getHsThucHanh());
        Assert.assertEquals("CNTT",mh.getKhoa());
        Assert.assertEquals("INT1340",mh.getMaMon());
        Assert.assertEquals(null,mh.getMonDK());
        Assert.assertEquals(0,mh.getSoTietBT());
        Assert.assertEquals(0,mh.getSoTietTH());
        Assert.assertEquals(45,mh.getSoTietLT());
        Assert.assertEquals("Nhập môn Công nghệ phần mềm",mh.getTenMon());
    }
    @Test
    public void testTimMonHocTheoKey(){
        MonHocDAO mhDAO=new MonHocDAO();
        MonHoc MH = new MonHoc();
        GiangVien GV = new GiangVien();
        GV.setGiangVienId(1);
        String key = null;
        String hocky = null;
        //Exception test case 1
        key = "";
        hocky = "";
        ArrayList<MonHoc> ListMH = mhDAO.timMonHocTheoKey(GV, key, hocky);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(0,ListMH.size());
        
        //Exception test case 2
        key = "xxxxxx";
        hocky = "";
        ListMH = mhDAO.timMonHocTheoKey(GV, key, hocky);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(0,ListMH.size());
        
        //Exception test case 3
        key = "";
        hocky = "xxxxxxxxx";
        ListMH = mhDAO.timMonHocTheoKey(GV, key, hocky);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(0,ListMH.size());
        
        //Standard test case 1
        key = "nhap";
        hocky = "20171";
        ListMH = ListMH = mhDAO.timMonHocTheoKey(GV, key, hocky);
        Assert.assertNotNull(ListMH);
        Assert.assertEquals(1, ListMH.size());
        for(MonHoc mh : ListMH){
            Assert.assertTrue(mh.getTenMon().toLowerCase().contains("nhập môn công nghệ phần mềm"));
        }
    }

}
