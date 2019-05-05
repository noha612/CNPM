/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.SinhVienDAO;
import Model.NguoiDung;
import Model.SinhVien;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestSinhVienDAO {
    @Test
    public void testTimSinhVien(){
        SinhVienDAO svDAO=new SinhVienDAO();
        NguoiDung nd=new NguoiDung();
        
        //Exception test case 1
        nd.setNguoiDungId(0);
        SinhVien sv=svDAO.TimSinhVien(nd);
        Assert.assertNull(sv);
        
        //Exception test case 2
        nd.setNguoiDungId(13);
        sv=svDAO.TimSinhVien(nd);
        Assert.assertNull(sv);
        
        //Exception test case 2
        nd.setNguoiDungId(135);
        sv=svDAO.TimSinhVien(nd);
        Assert.assertNull(sv);
        
        //Exception test case 3
        nd.setNguoiDungId(3220);
        sv=svDAO.TimSinhVien(nd);
        Assert.assertNull(sv);
        
        //Standard test case 1
        nd.setNguoiDungId(1);
        sv=svDAO.TimSinhVien(nd);
        Assert.assertNotNull(sv);
        Assert.assertEquals(1, sv.getSinhVienId());
        Assert.assertEquals("CNTT", sv.getKhoa());
        Assert.assertEquals("CNTT", sv.getNganh());
        Assert.assertTrue(sv.getGpa()==0);
        Assert.assertTrue(sv.getStcTichLuy()==0);
        Assert.assertEquals(null, sv.getHocLuc());
        Assert.assertEquals("CN1", sv.getLop());
    }
    
    @Test
    public void testtimSinhVien(){
        SinhVienDAO svDAO=new SinhVienDAO();
        String maSinhVien=null;
        
        //Exception test case 1
        SinhVien sv=svDAO.timSinhVien(maSinhVien);
        Assert.assertNull(sv);
        
        //Exception test case 2
        maSinhVien="jgjgkfjgdng";
        sv=svDAO.timSinhVien(maSinhVien);
        Assert.assertNull(sv);
        
        //Exception test case 3
        maSinhVien="QL001";
        sv=svDAO.timSinhVien(maSinhVien);
        Assert.assertNull(sv);
        
        //Standard test case 1
        maSinhVien="B16DCCN148";
        sv=svDAO.timSinhVien(maSinhVien);
        Assert.assertNotNull(sv);
        Assert.assertEquals(1, sv.getSinhVienId());
        Assert.assertEquals("CNTT", sv.getKhoa());
        Assert.assertEquals("B16DCCN148", sv.getTenDangNhap());
        Assert.assertEquals("Tạ Duy Hiếu", sv.getHoTen());
        Assert.assertEquals("CNTT", sv.getNganh());
        Assert.assertTrue(sv.getGpa()==0);
        Assert.assertTrue(sv.getStcTichLuy()==0);
        Assert.assertEquals(null, sv.getHocLuc());
        Assert.assertEquals("CN1", sv.getLop());
    }
}
