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
public class TestThongKeLopHocPhanDAO {
@Test
    public void testLayThongKeLopHocPhan(){
        ThongKeLopHocPhanDAO dao=new ThongKeLopHocPhanDAO();
        //   Exception test case 1
        ArrayList<ThongKeLopHocPhan> ltk=dao.layThongKeLopHocPhan("20161","20161",22);
        Assert.assertNotNull(ltk);
        Assert.assertEquals(0,ltk.size());
        //   Standard test case 1
        ltk=dao.layThongKeLopHocPhan("20171", "20171",22);
        Assert.assertNotNull(ltk);
        Assert.assertEquals(3, ltk.size());
        for(ThongKeLopHocPhan i:ltk){
            Assert.assertEquals("20171",i.getKyBD());
            Assert.assertEquals("20171",i.getKyKT());
            Assert.assertTrue(5==i.getSySo());
            Assert.assertEquals("Lê Minh Thanh", i.getGiangVien());
            Assert.assertTrue(i.getLopHocPhan().contains("Cơ sở dữ liệu"));    
        }
        Assert.assertTrue(ltk.get(0).getDiemTB()>ltk.get(1).getDiemTB()&&ltk.get(1).getDiemTB()>ltk.get(2).getDiemTB() );
    }
}
