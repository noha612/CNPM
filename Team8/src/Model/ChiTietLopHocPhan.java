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
public class ChiTietLopHocPhan {
    private String tenSinhVien;
    private Double diemCC;
    private Double diemKT;
    private Double diemTH;
    private Double diemBTL;
    private Double diemCK;
    private Float trungBinh;

    public ChiTietLopHocPhan() {
    }

    public ChiTietLopHocPhan(String tenSinhVien, Double diemCC, Double diemKT, Double diemTH, Double diemBTL, Double diemCK, Float trungBinh) {
        this.tenSinhVien = tenSinhVien;
        this.diemCC = diemCC;
        this.diemKT = diemKT;
        this.diemTH = diemTH;
        this.diemBTL = diemBTL;
        this.diemCK = diemCK;
        this.trungBinh = trungBinh;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public Double getDiemCC() {
        return diemCC;
    }

    public void setDiemCC(Double diemCC) {
        this.diemCC = diemCC;
    }

    public Double getDiemKT() {
        return diemKT;
    }

    public void setDiemKT(Double diemKT) {
        this.diemKT = diemKT;
    }

    public Double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(Double diemTH) {
        this.diemTH = diemTH;
    }

    public Double getDiemBTL() {
        return diemBTL;
    }

    public void setDiemBTL(Double diemBTL) {
        this.diemBTL = diemBTL;
    }

    public Double getDiemCK() {
        return diemCK;
    }

    public void setDiemCK(Double diemCK) {
        this.diemCK = diemCK;
    }

    public Float getTrungBinh() {
        return trungBinh;
    }

    public void setTrungBinh(Float trungBinh) {
        this.trungBinh = trungBinh;
    }

    
    
}
