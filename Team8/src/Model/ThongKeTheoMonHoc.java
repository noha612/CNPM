/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author nguyenthang
 */
public class ThongKeTheoMonHoc implements Serializable{
    private String kiBD;
    private String kiKT;
    private Integer monID;
    private String tenMon;
    private  String khoa;
    private Integer tongSoSinhVien;
    private Integer tongSoQuaMon;
    private Integer tongSoTruot;
    private Float trungBinh;

    public ThongKeTheoMonHoc() {
    }

    public ThongKeTheoMonHoc(String kiBD, String kiKT,Integer monID, String tenMon, String khoa, Integer tongSoSinhVien, Integer tongSoQuaMon, Integer tongSoTruot, Float trungBinh) {
        this.kiBD = kiBD;
        this.kiKT = kiKT;
        this.tenMon = tenMon;
        this.khoa = khoa;
        this.monID=monID;
        this.tongSoSinhVien = tongSoSinhVien;
        this.tongSoQuaMon = tongSoQuaMon;
        this.tongSoTruot = tongSoTruot;
        this.trungBinh = trungBinh;
    }

    public Integer getMonID() {
        return monID;
    }

    public void setMonID(Integer monID) {
        this.monID = monID;
    }

    public String getKiBD() {
        return kiBD;
    }

    public void setKiBD(String kiBD) {
        this.kiBD = kiBD;
    }

    public String getKiKT() {
        return kiKT;
    }

    public void setKiKT(String kiKT) {
        this.kiKT = kiKT;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public Integer getTongSoSinhVien() {
        return tongSoSinhVien;
    }

    public void setTongSoSinhVien(Integer tongSoSinhVien) {
        this.tongSoSinhVien = tongSoSinhVien;
    }

    public Integer getTongSoQuaMon() {
        return tongSoQuaMon;
    }

    public void setTongSoQuaMon(Integer tongSoQuaMon) {
        this.tongSoQuaMon = tongSoQuaMon;
    }

    public Integer getTongSoTruot() {
        return tongSoTruot;
    }

    public void setTongSoTruot(Integer tongSoTruot) {
        this.tongSoTruot = tongSoTruot;
    }

    public Float getTrungBinh() {
        return trungBinh;
    }

    public void setTrungBinh(Float trungBinh) {
        this.trungBinh = trungBinh;
    }

    @Override
    public String toString() {
        return "ThongKeTheoMonHoc{" + "kiBD=" + kiBD + ", kiKT=" + kiKT + ", monID=" + monID + ", tenMon=" + tenMon + ", khoa=" + khoa + ", tongSoSinhVien=" + tongSoSinhVien + ", tongSoQuaMon=" + tongSoQuaMon + ", tongSoTruot=" + tongSoTruot + ", trungBinh=" + trungBinh + '}';
    }
    
    
}
