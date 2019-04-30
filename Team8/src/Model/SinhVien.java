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
public class SinhVien extends NguoiDung implements Serializable{
    private int sinhVienId;
    private int tblNguoiDungId;
    private String khoa;
    private String nganh;
    private float gpa;
    private int stcTichLuy;
    private String hocLuc;
    private String lop;

    public SinhVien() {
    }

    public int getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(int sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public int getTblNguoiDungId() {
        return tblNguoiDungId;
    }

    public void setTblNguoiDungId(int tblNguoiDungId) {
        this.tblNguoiDungId = tblNguoiDungId;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getStcTichLuy() {
        return stcTichLuy;
    }

    public void setStcTichLuy(int stcTichLuy) {
        this.stcTichLuy = stcTichLuy;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
}
