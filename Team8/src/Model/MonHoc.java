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
public class MonHoc implements Serializable{
    private int monHocId;
    private String maMon;
    private String tenMon;
    private int soTinChi;
    private int soTietLT;
    private int soTietBT;
    private int soTietTH;
    private double hsChuyenCan;
    private double hsKiemTra;
    private double hsThucHanh;
    private double hsBaiTapLon;
    private double hsCuoiKy;
    private String monDK;
    private String boMon;
    private String khoa;

    public MonHoc() {
    }

    public MonHoc(int monHocId, String tenMon, int soTinChi, int soTietLT, int soTietBT, int soTietTH, double hsChuyenCan, double hsKiemTra, double hsThucHanh, double hsBaiTapLon, double hsCuoiKy, String monDK, String boMon, String khoa) {
        this.monHocId = monHocId;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.soTietLT = soTietLT;
        this.soTietBT = soTietBT;
        this.soTietTH = soTietTH;
        this.hsChuyenCan = hsChuyenCan;
        this.hsKiemTra = hsKiemTra;
        this.hsThucHanh = hsThucHanh;
        this.hsBaiTapLon = hsBaiTapLon;
        this.hsCuoiKy = hsCuoiKy;
        this.monDK = monDK;
        this.boMon = boMon;
        this.khoa = khoa;
    }
    
    public int getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(int monHocId) {
        this.monHocId = monHocId;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getSoTietLT() {
        return soTietLT;
    }

    public void setSoTietLT(int soTietLT) {
        this.soTietLT = soTietLT;
    }

    public int getSoTietBT() {
        return soTietBT;
    }

    public void setSoTietBT(int soTietBT) {
        this.soTietBT = soTietBT;
    }

    public int getSoTietTH() {
        return soTietTH;
    }

    public void setSoTietTH(int soTietTH) {
        this.soTietTH = soTietTH;
    }

    public double getHsChuyenCan() {
        return hsChuyenCan;
    }

    public void setHsChuyenCan(double hsChuyenCan) {
        this.hsChuyenCan = hsChuyenCan;
    }

    public double getHsKiemTra() {
        return hsKiemTra;
    }

    public void setHsKiemTra(double hsKiemTra) {
        this.hsKiemTra = hsKiemTra;
    }

    public double getHsThucHanh() {
        return hsThucHanh;
    }

    public void setHsThucHanh(double hsThucHanh) {
        this.hsThucHanh = hsThucHanh;
    }

    public double getHsBaiTapLon() {
        return hsBaiTapLon;
    }

    public void setHsBaiTapLon(double hsBaiTapLon) {
        this.hsBaiTapLon = hsBaiTapLon;
    }

    public double getHsCuoiKy() {
        return hsCuoiKy;
    }

    public void setHsCuoiKy(double hsCuoiKy) {
        this.hsCuoiKy = hsCuoiKy;
    }

    public String getMonDK() {
        return monDK;
    }

    public void setMonDK(String monDK) {
        this.monDK = monDK;
    }

    public String getBoMon() {
        return boMon;
    }

    public void setBoMon(String boMon) {
        this.boMon = boMon;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    
}
