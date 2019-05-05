package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BangDiem {
    private ArrayList<Diem> listDiem;
    private double trungBinh;
    
    public BangDiem(){}
    
    public BangDiem(ArrayList<Diem> listDiem, double trungBinh) {
        this.listDiem = listDiem;
        this.trungBinh = trungBinh;
    }
    
    public void sapXep(){
        Collections.sort(listDiem, new Comparator<Diem>(){
            @Override
            public int compare(Diem tr, Diem s) {
                return (int)(100*(s.getTongKet() - tr.getTongKet()));
            }
            
        });
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
