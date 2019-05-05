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
public class LichGiangDay extends GiangVien implements Serializable{
    private int lichGiangDayId;
    private int tuanBatDau;
    private int tuanKetThuc;
    private int tblKipHocId;
    private int tblPhongHocId;
    private int tblLopHocPhanId;
    private int tblGiangVientblNguoiDungId;

    public LichGiangDay() {
    }

    
    public int getLichGiangDayId() {
        return lichGiangDayId;
    }

    public void setLichGiangDayId(int lichGiangDayId) {
        this.lichGiangDayId = lichGiangDayId;
    }

    public int getTuanBatDau() {
        return tuanBatDau;
    }

    public void setTuanBatDau(int tuanBatDau) {
        this.tuanBatDau = tuanBatDau;
    }

    public int getTuanKetThuc() {
        return tuanKetThuc;
    }

    public void setTuanKetThuc(int tuanKetThuc) {
        this.tuanKetThuc = tuanKetThuc;
    }

    public int getTblKipHocId() {
        return tblKipHocId;
    }

    public void setTblKipHocId(int tblKipHocId) {
        this.tblKipHocId = tblKipHocId;
    }

    public int getTblPhongHocId() {
        return tblPhongHocId;
    }

    public void setTblPhongHocId(int tblPhongHocId) {
        this.tblPhongHocId = tblPhongHocId;
    }

    public int getTblLopHocPhanId() {
        return tblLopHocPhanId;
    }

    public void setTblLopHocPhanId(int tblLopHocPhanId) {
        this.tblLopHocPhanId = tblLopHocPhanId;
    }

    public int getTblGiangVientblNguoiDungId() {
        return tblGiangVientblNguoiDungId;
    }

    public void setTblGiangVientblNguoiDungId(int tblGiangVientblNguoiDungId) {
        this.tblGiangVientblNguoiDungId = tblGiangVientblNguoiDungId;
    }
    
}
