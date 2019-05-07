/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.LopHocPhanDAO;
import Model.GiangVien;
import Model.LopHocPhan;
import Model.MonHoc;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestLopHocPhanDAO {
    @Test
    public void testTimLopTheoMon(){
        LopHocPhanDAO lhpDAO=new LopHocPhanDAO();
        MonHoc MH=new MonHoc();
        
        //Exception test case 1
        MH.setMonHocId(0);
        ArrayList<LopHocPhan> ListLHP=lhpDAO.TimLopTheoMon(MH);
        Assert.assertNotNull(ListLHP);
        Assert.assertEquals(0,ListLHP.size());
        
        //Exception test case 2
        MH.setMonHocId(1000);
        ListLHP=lhpDAO.TimLopTheoMon(MH);
        Assert.assertNotNull(ListLHP);
        Assert.assertEquals(0,ListLHP.size());        
        
        //Standard test case 1
        MH.setMonHocId(4);
        ListLHP=lhpDAO.TimLopTheoMon(MH);
        Assert.assertNotNull(ListLHP);
        Assert.assertEquals(5,ListLHP.size());
        for(LopHocPhan lhp : ListLHP){
            Assert.assertEquals(MH.getMonHocId(),lhp.getMonHocId());
        }
        for(int k=0;k<ListLHP.size()-1;k++){
            Assert.assertTrue(ListLHP.get(k).getTen().compareTo(ListLHP.get(k+1).getTen())<0);
        }
    }
    @Test
    public void testGetLopHocPhanTheoMonHoc() {
        
        MonHoc MH = new MonHoc();
        GiangVien GV = new GiangVien();
        GV.setGiangVienId(1);
        String hocKy = null;
        ArrayList<LopHocPhan> listLHP = new ArrayList<>();
        LopHocPhanDAO lhp = new LopHocPhanDAO();      
        
        //Standard test case 1
        hocKy = "20171";
        MH.setMonHocId(1);
        listLHP = lhp.getLopHocPhanTheoMonHoc(MH, hocKy, GV);
        Assert.assertNotNull(listLHP);
        Assert.assertEquals(4,listLHP.size());
        for(LopHocPhan a : listLHP){
            Assert.assertEquals(1,a.getMonHocId());
        }
    }

}
