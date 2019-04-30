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
public class PhieuDangKy implements Serializable{
    private int phieuDangKyId;
    private String thoiGian;
    private int hocPhi;
    private int tblLopHocPhanId;
    private int tblSinhVienId;

    public PhieuDangKy() {
    }

    public int getPhieuDangKyId() {
        return phieuDangKyId;
    }

    public void setPhieuDangKyId(int phieuDangKyId) {
        this.phieuDangKyId = phieuDangKyId;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getTblLopHocPhanId() {
        return tblLopHocPhanId;
    }

    public void setTblLopHocPhanId(int tblLopHocPhanId) {
        this.tblLopHocPhanId = tblLopHocPhanId;
    }

    public int getTblSinhVienId() {
        return tblSinhVienId;
    }

    public void setTblSinhVienId(int tblSinhVienId) {
        this.tblSinhVienId = tblSinhVienId;
    }
    
}
