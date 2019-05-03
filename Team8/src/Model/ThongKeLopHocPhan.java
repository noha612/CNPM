/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nguyenthang
 */
public class ThongKeLopHocPhan {
    private String maLop;
    private String hocKy;
    private String kyBD;
    private String kyKT;
    private String lopHocPhan;
    private String giangVien;
    private Integer sySo;
    private Float diemTB;
    private Integer tyLeQuaMon;

    public ThongKeLopHocPhan(String maLop, String hocKy, String kyBD, String kyKT, String lopHocPhan, String giangVien, Integer sySo, Float diemTB, Integer tyLeQuaMon) {
        this.maLop = maLop;
        this.hocKy = hocKy;
        this.kyBD = kyBD;
        this.kyKT = kyKT;
        this.lopHocPhan = lopHocPhan;
        this.giangVien = giangVien;
        this.sySo = sySo;
        this.diemTB = diemTB;
        this.tyLeQuaMon = tyLeQuaMon;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public ThongKeLopHocPhan() {
    }

    public ThongKeLopHocPhan(String kyBD, String kyKT, String lopHocPhan, String giangVien, Integer sySo, Float diemTB, Integer tyLeQuaMon) {
        this.kyBD = kyBD;
        this.kyKT = kyKT;
        this.lopHocPhan = lopHocPhan;
        this.giangVien = giangVien;
        this.sySo = sySo;
        this.diemTB = diemTB;
        this.tyLeQuaMon = tyLeQuaMon;
    }

    public String getKyBD() {
        return kyBD;
    }

    public void setKyBD(String kyBD) {
        this.kyBD = kyBD;
    }

    public String getKyKT() {
        return kyKT;
    }

    public void setKyKT(String kyKT) {
        this.kyKT = kyKT;
    }

    public String getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(String lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public Integer getSySo() {
        return sySo;
    }

    public void setSySo(Integer sySo) {
        this.sySo = sySo;
    }

    public Float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Float diemTB) {
        this.diemTB = diemTB;
    }

    public Integer getTyLeQuaMon() {
        return tyLeQuaMon;
    }

    public void setTyLeQuaMon(Integer tyLeQuaMon) {
        this.tyLeQuaMon = tyLeQuaMon;
    }

  
    
}
