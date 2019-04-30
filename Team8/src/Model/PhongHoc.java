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
public class PhongHoc implements Serializable{
    private int phongHocId;
    private String tenPhong;
    private String viTri;
    private int sucChua;
    private String moTa;
    private int tblTruongId;

    public PhongHoc() {
    }

    public int getPhongHocId() {
        return phongHocId;
    }

    public void setPhongHocId(int phongHocId) {
        this.phongHocId = phongHocId;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTblTruongId() {
        return tblTruongId;
    }

    public void setTblTruongId(int tblTruongId) {
        this.tblTruongId = tblTruongId;
    }
    
}
