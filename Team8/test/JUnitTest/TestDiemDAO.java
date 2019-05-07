/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.DiemDAO;
import Model.Diem;
import Model.LopHocPhan;
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
}
