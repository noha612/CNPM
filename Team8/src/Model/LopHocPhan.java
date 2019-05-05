/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author ntnhu
 */
public class LopHocPhan extends MonHoc implements Serializable {
    private int lopHocPhanId;
    private String maLop;
    private String ten;
    private String hocKy;
    private int siSo;
    private int daChon;
    private LichGiangDay lichGiangDay;
    public LopHocPhan() {
    }

   

    public int getLopHocPhanId() {
        return lopHocPhanId;
    }

    public void setLopHocPhanId(int lopHocPhanId) {
        this.lopHocPhanId = lopHocPhanId;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public int getDaChon() {
        return daChon;
    }

    public void setDaChon(int daChon) {
        this.daChon = daChon;
    }
    
    public void setLichGiangDay(LichGiangDay lichGiangDay) {
        this.lichGiangDay = lichGiangDay;
    }

    public LichGiangDay getLichGiangDay() {
        return lichGiangDay;
    }

}
