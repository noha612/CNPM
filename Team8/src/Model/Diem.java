package Model;

public class Diem {
    private double diemCC;
    private double diemKT;
    private double diemTH;
    private double diemBTL;
    private double diemCK;
    private double tongKet;
    private int kyHoc;
    private String maSinhVien;
    private int idMonHoc;
    public int get;
    
    public Diem() {
    }

    public Diem(double diemCC, double diemKT, double diemTH, double diemBTL, double diemCK, int kyHoc, String maSinhVien, int idMonHoc, int get) {
        this.diemCC = diemCC;
        this.diemKT = diemKT;
        this.diemTH = diemTH;
        this.diemBTL = diemBTL;
        this.diemCK = diemCK;
        this.kyHoc = kyHoc;
        this.maSinhVien = maSinhVien;
        this.idMonHoc = idMonHoc;
        this.get = get;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double getDiemKT() {
        return diemKT;
    }

    public double getDiemTH() {
        return diemTH;
    }

    public double getDiemBTL() {
        return diemBTL;
    }

    public double getDiemCK() {
        return diemCK;
    }

    public double getTongKet() {
        return tongKet;
    }

    public int getKyHoc() {
        return kyHoc;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public int getIdMonHoc() {
        return idMonHoc;
    }

    public int getGet() {
        return get;
    }

    public void setDiemCC(double diemCC) {
        this.diemCC = diemCC;
    }

    public void setDiemKT(double diemKT) {
        this.diemKT = diemKT;
    }

    public void setDiemTH(double diemTH) {
        this.diemTH = diemTH;
    }

    public void setDiemBTL(double diemBTL) {
        this.diemBTL = diemBTL;
    }

    public void setDiemCK(double diemCK) {
        this.diemCK = diemCK;
    }

    public void setTongKet(double tongKet) {
        this.tongKet = tongKet;
    }

    public void setKyHoc(int kyHoc) {
        this.kyHoc = kyHoc;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setIdMonHoc(int idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public void setGet(int get) {
        this.get = get;
    }

    

}
