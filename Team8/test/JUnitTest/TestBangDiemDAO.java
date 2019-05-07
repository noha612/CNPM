package JUnitTest;

import Control.BangDiemDAO;
import Model.BangDiem;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class TestBangDiemDAO {
    @Test
    public void testThongKeSoLuong(){
        BangDiemDAO bdd = new BangDiemDAO();
        //   Standard test case 1
        ArrayList<Integer> rs = bdd.thongKeSoLuong(20171);
        Assert.assertNotNull(rs);
        Assert.assertEquals(5, rs.size());
        Assert.assertEquals(1, (int)rs.get(0));
        Assert.assertEquals(1, (int)rs.get(1));
        Assert.assertEquals(5, (int)rs.get(2));
        Assert.assertEquals(5, (int)rs.get(3));
        Assert.assertEquals(3, (int)rs.get(4));
        //   Exception test case 1
        rs = bdd.thongKeSoLuong(20181);
        Assert.assertNotNull(rs);
        Assert.assertEquals(5, rs.size());
        Assert.assertEquals(0, (int)rs.get(0));
        Assert.assertEquals(0, (int)rs.get(1));
        Assert.assertEquals(0, (int)rs.get(2));
        Assert.assertEquals(0, (int)rs.get(3));
        Assert.assertEquals(0, (int)rs.get(4));
    }
    
    @Test
    public void testGetBangDiemTheoHocLuc(){
        BangDiemDAO bdd = new BangDiemDAO();

        // Exception test case 1
        ArrayList<BangDiem> rs = bdd.getBangDiemTheoHocLuc(20181, "Yếu");
        Assert.assertNotNull(rs);
        Assert.assertEquals(0, rs.size());
        // Exception test case 2
        rs = bdd.getBangDiemTheoHocLuc(20171, "__");
        Assert.assertNotNull(rs);
        Assert.assertEquals(0, rs.size());
        
        // Standard test case 1
        rs = bdd.getBangDiemTheoHocLuc(20171, "Yếu");
        Assert.assertNotNull(rs);
        Assert.assertEquals(3, rs.size());
        // Standard test case 2
        rs = bdd.getBangDiemTheoHocLuc(20171, "Trung Bình");
        Assert.assertNotNull(rs);
        Assert.assertEquals(5, rs.size());
        // Standard test case 3
        rs = bdd.getBangDiemTheoHocLuc(20171, "Khá");
        Assert.assertNotNull(rs);
        Assert.assertEquals(5, rs.size());
        // Standard test case 4
        rs = bdd.getBangDiemTheoHocLuc(20171, "Giỏi");
        Assert.assertNotNull(rs);
        Assert.assertEquals(1, rs.size());
        // Standard test case 5
        rs = bdd.getBangDiemTheoHocLuc(20171, "Xuất Sắc");
        Assert.assertNotNull(rs);
        Assert.assertEquals(1, rs.size());
    }
}