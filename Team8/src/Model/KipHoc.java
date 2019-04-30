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
public class KipHoc implements Serializable{
    private int kipHocId;
    private int gioBatDau;
    private int gioKetThuc;
    private int thu;

    public KipHoc() {
    }

    public int getKipHocId() {
        return kipHocId;
    }

    public void setKipHocId(int kipHocId) {
        this.kipHocId = kipHocId;
    }

    public int getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(int gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public int getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(int gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }
    
}
