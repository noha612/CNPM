/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.DAO;
import Control.DiemDAO;
import Model.Diem;
import Model.LopHocPhan;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestDiemDAO {
    @Test
    public void testGetSinhVienTheoLHP() {
        
        LopHocPhan LHP = new LopHocPhan();
        ArrayList<Diem> listStudent = new ArrayList<>();
        DiemDAO diem = new DiemDAO(); 
        
        //Exception test case 1
        LHP.setLopHocPhanId(13);
        listStudent = diem.getSinhVienTheoLHP(LHP);
        Assert.assertNotNull(listStudent);
        Assert.assertEquals(0,listStudent.size());
        
        //Standard test case 1
        LHP.setLopHocPhanId(12);
        listStudent = diem.getSinhVienTheoLHP(LHP);
        Assert.assertNotNull(listStudent);
        Assert.assertEquals(5,listStudent.size());
    }
    @Test 
    public void testNhapDiemTheoLopHocPhan(){
        //Standard test case 1
        DiemDAO diemDAO = new DiemDAO();
        Diem diem1 = new Diem();
        Diem diem2 = new Diem();
        Diem diem3 = new Diem();
        ArrayList<Diem> listStudent = new ArrayList<>();
        
        diem1.setIdMonHoc(4);
        diem1.setSinhVienId(1);
        diem1.setDiemCC(Float.parseFloat("9"));
        diem1.setDiemKT(Float.parseFloat("7"));
        diem1.setDiemBTL(Float.parseFloat("7.6"));
        diem1.setDiemTH(Float.parseFloat("7.8"));
        diem1.setDiemCK(Float.parseFloat("7"));
        diem1.setKyHoc(Integer.parseInt("20171"));
        listStudent.add(diem1);
        
        diem2.setIdMonHoc(10);
        diem2.setSinhVienId(1);
        diem2.setDiemCC(Float.parseFloat("7"));
        diem2.setDiemKT(Float.parseFloat("8"));
        diem2.setDiemBTL(Float.parseFloat("7.6"));
        diem2.setDiemTH(Float.parseFloat("7.8"));
        diem2.setDiemCK(Float.parseFloat("7"));
        diem2.setKyHoc(Integer.parseInt("20171"));
        listStudent.add(diem2);
        
        diem3.setIdMonHoc(11);
        diem3.setSinhVienId(1);
        diem3.setDiemCC(Float.parseFloat("7"));
        diem3.setDiemKT(Float.parseFloat("8"));
        diem3.setDiemBTL(Float.parseFloat("7.6"));
        diem3.setDiemTH(Float.parseFloat("7.8"));
        diem3.setDiemCK(Float.parseFloat("7"));
        diem3.setKyHoc(Integer.parseInt("20171"));        
        listStudent.add(diem3);
        Connection con = DAO.con;
        try {
            con.setAutoCommit(false);
            diemDAO.nhapDiemTheoLopHocPhan(listStudent);
            int sl = diemDAO.demSoBanGhiDiem();
            Assert.assertEquals(63, sl);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }
    }
    
    @Test
    public void testDemSoBanGhiDiem(){
        //Standard test case 1
        DiemDAO diem = new DiemDAO();
        int sl = diem.demSoBanGhiDiem();
        Assert.assertEquals(60, sl);
    }
    
    @Test
    public void testCheckTonTaiDiem(){
        DiemDAO diem = new DiemDAO();
        
        //Exception test case 1
        int isSinhVien = 1; 
        int idMonHoc = 110000; 
        boolean exist = diem.checkTonTaiDiem (isSinhVien, idMonHoc);
        Assert.assertFalse(exist);
        
        //Exception test case 2
        isSinhVien = 100000; 
        idMonHoc = 11; 
        exist = diem.checkTonTaiDiem (isSinhVien, idMonHoc);
        Assert.assertFalse(exist);
        
        //Exception test case 3
        isSinhVien = 100000; 
        idMonHoc = 1100000; 
        exist = diem.checkTonTaiDiem (isSinhVien, idMonHoc);
        Assert.assertFalse(exist);
        //Standard test case 1
        isSinhVien = 1; 
        idMonHoc = 1; 
        exist = diem.checkTonTaiDiem (isSinhVien, idMonHoc);
        Assert.assertTrue(exist);
        
        //Standard test case 2
        isSinhVien = 1; 
        idMonHoc = 11; 
        exist = diem.checkTonTaiDiem (isSinhVien, idMonHoc);
        Assert.assertFalse(exist);
    }
    
}

