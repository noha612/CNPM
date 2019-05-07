/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;
import org.junit.*;
import Control.*;
import Model.*;
import java.util.ArrayList;

/**
 *
 * @author ntnhu
 */

public class TestThongKeTheoMonHocDAO {
    @Test
    public void testLayThongKeTheoMonHoc(){
        ThongKeTheoMonHocDAO dao=new ThongKeTheoMonHocDAO();
        
        //   Exception test case 1
        ArrayList<ThongKeTheoMonHoc> ltk=dao.layThongKeTheoMonHoc("20161","20161");
        Assert.assertNotNull(ltk);
        Assert.assertEquals(0,ltk.size());
        
        //   Standard test case 1
        ltk=dao.layThongKeTheoMonHoc("20171", "20171");
        Assert.assertNotNull(ltk);
        Assert.assertEquals(4, ltk.size());
        for(ThongKeTheoMonHoc i:ltk){
            Assert.assertEquals("20171",i.getKiBD());
            Assert.assertEquals("20171",i.getKiKT());
            Assert.assertTrue(15==i.getTongSoSinhVien());
            Assert.assertTrue((i.getTongSoQuaMon()+i.getTongSoTruot()-i.getTongSoSinhVien())==0);
        }
        Assert.assertTrue(ltk.get(0).getTrungBinh()>ltk.get(1).getTrungBinh() && ltk.get(0).getTrungBinh()>ltk.get(1).getTrungBinh() && ltk.get(2).getTrungBinh()>ltk.get(3).getTrungBinh() );
    }
}
