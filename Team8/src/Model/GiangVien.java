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
public class GiangVien extends NguoiDung implements Serializable{
    private int giangVienId;
    private int tblNguoiDungId;
    private String khoa;
    private String nganh;
    private String hocVi;
    private String boMon;

    public GiangVien() {
    }

    public int getGiangVienId() {
        return giangVienId;
    }

    public void setGiangVienId(int giangVienId) {
        this.giangVienId = giangVienId;
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

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getBoMon() {
        return boMon;
    }

    public void setBoMon(String boMon) {
        this.boMon = boMon;
    }
    
}
