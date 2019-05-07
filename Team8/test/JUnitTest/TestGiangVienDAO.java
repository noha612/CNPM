/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;
import Control.GiangVienDAO;
import Model.GiangVien;
import Model.NguoiDung;
import java.util.ArrayList;
import org.junit.*;
/**
 *
 * @author ntnhu
 */
public class TestGiangVienDAO {
    @Test
    public void testTimGiangVienTheoId(){
        GiangVienDAO gvDAO=new GiangVienDAO();
        //Exception test case 1
        GiangVien gv=gvDAO.TimGiangVienTheoId(0);
        Assert.assertNull(gv);
        
        //Exception test case 2
        gv=gvDAO.TimGiangVienTheoId(22);
        Assert.assertNull(gv);
        
        //Exception test case 3
        gv=gvDAO.TimGiangVienTheoId(322);
        Assert.assertNull(gv);
        
        //Standard test case 1
        gv=gvDAO.TimGiangVienTheoId(1);
        Assert.assertNotNull(gv);
        Assert.assertEquals(1,gv.getGiangVienId());
        Assert.assertEquals(6,gv.getTblNguoiDungId());
        Assert.assertEquals("CNTT",gv.getKhoa());
        Assert.assertEquals("CNTT",gv.getNganh());
        Assert.assertEquals("Tiến Sĩ",gv.getHocVi());
        Assert.assertEquals("x",gv.getBoMon());
    }
    @Test
    public void testGVTimGiangVien(){
        GiangVienDAO gvDAO=new GiangVienDAO();
        String x = null;
        //Exception test case 1
        x ="acb";
        ArrayList<GiangVien> ListGV = new ArrayList<GiangVien>();
        ListGV = gvDAO.TimGVTheoKhoa(x);
        Assert.assertNotNull(ListGV);
        Assert.assertEquals(0, ListGV.size());
        
        //Exception test case 2
        x ="rmd";
        ListGV = gvDAO.TimGVTheoKhoa(x);
        Assert.assertNotNull(ListGV);
        Assert.assertEquals(0, ListGV.size());
        
        //Standard test case
        x ="CNTT";
        ListGV = gvDAO.TimGVTheoKhoa(x);
        Assert.assertNotNull(ListGV);
        Assert.assertEquals(13, ListGV.size());
        for(int i=0; i<ListGV.size(); i++){
            Assert.assertEquals(x, ListGV.get(i).getKhoa());
        }
    }
    @Test
    public void testTimGiangVien(){
        GiangVienDAO gvDAO = new GiangVienDAO();
        NguoiDung nd = new NguoiDung();
        
        //Exception test case 1
        nd.setNguoiDungId(0);
        GiangVien gv = gvDAO.TimGiangVien(nd);
        Assert.assertNull(gv);
        
        //Exception test case 2
        nd.setNguoiDungId(13);
        gv = gvDAO.TimGiangVien(nd);
        Assert.assertNull(gv);
        
        //Exception test case 2
        nd.setNguoiDungId(135);
        gv = gvDAO.TimGiangVien(nd);
        Assert.assertNull(gv);
        
        //Exception test case 3
        nd.setNguoiDungId(3220);
        gv = gvDAO.TimGiangVien(nd);
        Assert.assertNull(gv);
        
        //Standard test case 1
        nd.setNguoiDungId(6);
        gv = gvDAO.TimGiangVien(nd);
        Assert.assertNotNull(gv);
        Assert.assertEquals(1, gv.getGiangVienId());
        Assert.assertEquals("CNTT", gv.getKhoa());
        Assert.assertEquals("CNTT", gv.getNganh());
        Assert.assertEquals("Tiến Sĩ", gv.getHocVi());
        Assert.assertEquals("x", gv.getBoMon());
    }

}
