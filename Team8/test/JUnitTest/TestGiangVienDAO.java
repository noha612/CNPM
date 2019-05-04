/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;
import Control.GiangVienDAO;
import Model.GiangVien;
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
        GiangVien gv=gvDAO.TimGiangVienTheoId(6);
        Assert.assertNull(gv);
        
        //Exception test case 2
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
        Assert.assertEquals(null,gv.getBoMon());
    }
}
