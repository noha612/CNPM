/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.LichGiangDayDAO;
import Model.GiangVien;
import Model.LichGiangDay;
import Model.PhongHoc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestLichGiangDayDAO {
    @Test
    public void testTimLichTheoIdLop(){
        LichGiangDayDAO lgdDAO=new LichGiangDayDAO();
        int i;
        //Exception test case 1
        i=0;
        ArrayList<LichGiangDay> ListLGD=lgdDAO.TimLichTheoIdLop(i);
        Assert.assertNotNull(ListLGD);
        Assert.assertEquals(0,ListLGD.size());
        //Exception test case 2
        i=1000;
        ListLGD=lgdDAO.TimLichTheoIdLop(i);
        Assert.assertNotNull(ListLGD);
        Assert.assertEquals(0,ListLGD.size());
        
        //Standard test case 1
        i=16;
        ListLGD=lgdDAO.TimLichTheoIdLop(i);
        Assert.assertNotNull(ListLGD);
        Assert.assertEquals(1,ListLGD.size());
        for(LichGiangDay lgd : ListLGD){
            Assert.assertEquals(i,lgd.getTblLopHocPhanId());
        }
        for(int k=0;k<ListLGD.size()-1;k++){
            Assert.assertTrue(ListLGD.get(k).getTblKipHocId()<ListLGD.get(k+1).getTblKipHocId());
        }
        
    }
    @Test 
    public void testTimPhongGV(){
        LichGiangDayDAO lgdDAO = new LichGiangDayDAO();
        ArrayList<PhongHoc> ListPH= new ArrayList<PhongHoc>();
        int i;
        //Exception test case 1 
        i=1;
        ListPH = lgdDAO.TimPhongGV(i);
        Assert.assertNotNull(ListPH);
        Assert.assertNotEquals(0, ListPH.size());

        //Exceptipn test case 2 
        i=2;
        ListPH = lgdDAO.TimPhongGV(i);
        Assert.assertNotNull(ListPH);
        Assert.assertNotEquals(0, ListPH.size());

        //Standard test case
        i = 3;
        ListPH = lgdDAO.TimPhongGV(i);
        Assert.assertNotNull(ListPH);
        Assert.assertEquals(6, ListPH.size());
        Assert.assertEquals(1, ListPH.get(0).getPhongHocId());
        Assert.assertEquals("101 A2", ListPH.get(0).getTenPhong());
        Assert.assertEquals("Mặt Trước", ListPH.get(0).getViTri());
        Assert.assertEquals(59, ListPH.get(0).getSucChua());
        Assert.assertEquals("Máy chiếu + Điều hòa", ListPH.get(0).getMoTa() );
    }@Test
    //Them timlichgiangday theo id + getallLichGiangDay trong LichGiangDayDAO
    public  void testLenLich() throws SQLException{
        LichGiangDayDAO lgdDAO = new LichGiangDayDAO();
        
       //Standard test case 
        LichGiangDay lgd = new LichGiangDay();
        lgd.setTuanBatDau(1);
        lgd.setTuanKetThuc(15);
        lgd.setTblPhongHocId(3);
        lgd.setTblKipHocId(3);
        lgd.setTblGiangVientblNguoiDungId(1);
        lgd.setTblLopHocPhanId(2);
        lgd.setLichGiangDayId(13);
          Connection con = lgdDAO.con;
        try{
        con.setAutoCommit(false);
        lgdDAO.LenLich(lgd);
        Assert.assertNotNull(lgd);
        ArrayList<LichGiangDay> LGD = lgdDAO.getAllLichGiangDay();
        Assert.assertNotNull(LGD);
        Assert.assertEquals(14, LGD.size()); 
        LichGiangDay ld1 = lgdDAO.TimLichTheoID(11);
        Assert.assertNull(ld1);
        Assert.assertNotEquals(lgd, ld1);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }   
    }
    @Test
    public void testgetAllLichGiangDay(){
        
        //Standard test case
        LichGiangDayDAO lgd = new LichGiangDayDAO();
        ArrayList<LichGiangDay> ListLGD = lgd.getAllLichGiangDay();
        Assert.assertNotNull(ListLGD);
        Assert.assertEquals(13, ListLGD.size());
    }
    
    @Test
    public void testTimLichTheoID(){
        LichGiangDayDAO LGDDAO = new LichGiangDayDAO();
        
        //Exception test case 1
        LichGiangDay lgd = LGDDAO.TimLichTheoID(1);
        Assert.assertNull(lgd);
        
        //Exception test case 2
        lgd =LGDDAO.TimLichTheoID(10);
        Assert.assertNull(lgd);
        
        //Standard tets case
        lgd = LGDDAO.TimLichTheoID(22);
        Assert.assertNotNull(lgd);
        Assert.assertEquals(22, lgd.getLichGiangDayId());
        Assert.assertEquals(1, lgd.getTuanBatDau());
        Assert.assertEquals(15, lgd.getTuanKetThuc());
        Assert.assertEquals(7, lgd.getTblKipHocId());
        Assert.assertEquals(1, lgd.getTblPhongHocId());
        Assert.assertEquals(17, lgd.getTblLopHocPhanId());
        Assert.assertEquals(12, lgd.getTblGiangVientblNguoiDungId());
    }
    @Test
    public void testCheckGV(){
        LichGiangDayDAO lgdDAO = new LichGiangDayDAO();
        GiangVien gv = new GiangVien();
        
        //Exception test case 1
        gv = lgdDAO.checkGV(3, 3);
        Assert.assertNull(gv);
        
        //Exception test case 2
        gv = lgdDAO.checkGV(5, 1);
        Assert.assertNull(gv);
        
       //Standard test case
        gv = lgdDAO.checkGV(12, 1);
        Assert.assertNotNull(gv);
    }
}
