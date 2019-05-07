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
public class TestChiTietLopHocPhanDAO {
    @Test
    public void testLayDiem(){
        ChiTietLopHocPhanDAO dao=new ChiTietLopHocPhanDAO();
        //  Exception test case 1
        ArrayList<ChiTietLopHocPhan> ltk=dao.layDiem("D16-52","20161");
        Assert.assertNotNull(ltk);
        Assert.assertEquals(0,ltk.size());
        //   Standard test case 1
        ltk=dao.layDiem("53","20171");
        Assert.assertNotNull(ltk);
        Assert.assertEquals(5, ltk.size());
        Assert.assertEquals("Nguyễn Trọng Đức Anh", ltk.get(0).getTenSinhVien());
        Assert.assertEquals("Chu Văn An", ltk.get(1).getTenSinhVien());
        Assert.assertEquals("Nguyễn Thị Lan Anh", ltk.get(2).getTenSinhVien());
        Assert.assertEquals("Hoàng Ngọc ánh", ltk.get(3).getTenSinhVien());
        Assert.assertEquals("Nguyễn Trọng Bằng", ltk.get(4).getTenSinhVien());
        Assert.assertTrue(ltk.get(0).getTrungBinh()>ltk.get(1).getTrungBinh() && ltk.get(0).getTrungBinh()>ltk.get(1).getTrungBinh() && ltk.get(2).getTrungBinh()>ltk.get(3).getTrungBinh() && ltk.get(3).getTrungBinh()>ltk.get(4).getTrungBinh() );
    }
}
