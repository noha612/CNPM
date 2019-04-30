package Model;

import java.util.ArrayList;

public class BangDiem {
    private ArrayList<Diem> listDiem;
    private double trungBinh;
    
    public BangDiem(){}
    
    public BangDiem(ArrayList<Diem> listDiem, double trungBinh) {
        this.listDiem = listDiem;
        this.trungBinh = trungBinh;
    }

    public ArrayList<Diem> getListDiem() {
        return listDiem;
    }

    public double getTrungBinh() {
        return trungBinh;
    }

    public void setListDiem(ArrayList<Diem> listDiem) {
        this.listDiem = listDiem;
    }

    public void setTrungBinh(double trungBinh) {
        this.trungBinh = trungBinh;
    }

    public String xepLoai(){
        if(trungBinh < 2.0) return "Yeu";
        if(trungBinh < 2.5) return "Trung Binh";
        if(trungBinh < 3.2) return "Kha";
        if(trungBinh < 3.6) return "Gioi";
        return "Xuat Sac";
    }
}
