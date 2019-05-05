/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.NguoiDungDAO;
import Model.NguoiDung;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestNguoiDungDAO {
    @Test
    public void testTimNguoiDung(){
        String tenDangNhap="";
        String matKhau="";
        NguoiDungDAO ndDAO=new NguoiDungDAO();
        
        //Exception test case 1
        tenDangNhap=null;
        matKhau=null;
        NguoiDung nd=ndDAO.TimNguoiDung(tenDangNhap, matKhau);
        Assert.assertNull(nd);
        
        //Exception test case 2
        tenDangNhap="gfakhfglhklfg";
        matKhau="dugkadagjfgd";
        nd=ndDAO.TimNguoiDung(tenDangNhap, matKhau);
        Assert.assertNull(nd);
        
        //Exception test case 3
        tenDangNhap="b16dccn159";
        matKhau="dugkadagjfgd";
        nd=ndDAO.TimNguoiDung(tenDangNhap, matKhau);
        Assert.assertNull(nd);
        
        //Exception test case 4
        tenDangNhap="gfakhfglhklfg";
        matKhau="159";
        nd=ndDAO.TimNguoiDung(tenDangNhap, matKhau);
        Assert.assertNull(nd);
        
        //Stanndard test case 1
        tenDangNhap="b16dccn159";
        matKhau="159";
        nd=ndDAO.TimNguoiDung(tenDangNhap, matKhau);
        Assert.assertNotNull(nd);
        Assert.assertEquals(3,nd.getNguoiDungId());
        Assert.assertEquals("B16DCCN159",nd.getTenDangNhap());
        Assert.assertEquals("159",nd.getMatKhau());
        Assert.assertEquals("Phạm Ngọc Hoàng",nd.getHoTen());
        Assert.assertEquals("06/12/1998",nd.getNgaySinh());
        Assert.assertEquals("Nam",nd.getGioiTinh());
        Assert.assertEquals("SV",nd.getVaiTro());
    }
    
    @Test
    public void testTimNguoiDungTheoId(){
        int id;
        NguoiDungDAO ndDAO=new NguoiDungDAO();
        
        //Exception test case 1
        id=0;
        NguoiDung nd=ndDAO.TimNguoiDungTheoId(id);
        Assert.assertNull(nd);
        
        //Exception test case 2
        id=135;
        nd=ndDAO.TimNguoiDungTheoId(id);
        Assert.assertNull(nd);
        
        //Exception test case 3
        id=322;
        nd=ndDAO.TimNguoiDungTheoId(id);
        Assert.assertNull(nd);
        
        //Stanndard test case 1
        id=3;
        nd=ndDAO.TimNguoiDungTheoId(id);
        Assert.assertNotNull(nd);
        Assert.assertEquals(3,nd.getNguoiDungId());
        Assert.assertEquals("B16DCCN159",nd.getTenDangNhap());
        Assert.assertEquals("159",nd.getMatKhau());
        Assert.assertEquals("Phạm Ngọc Hoàng",nd.getHoTen());
        Assert.assertEquals("06/12/1998",nd.getNgaySinh());
        Assert.assertEquals("Nam",nd.getGioiTinh());
        Assert.assertEquals("SV",nd.getVaiTro());
    }
}
