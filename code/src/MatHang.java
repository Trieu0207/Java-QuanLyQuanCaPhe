import java.util.Scanner;

public abstract class MatHang {
    private String ten;
    private double giaBan;
    private String thoiDiemBan;
    public static Scanner SC = new Scanner(System.in);
    private boolean isConHang = true;
    public String getThoiDiemBan() {
        return thoiDiemBan;
    }
    public void hetHang(){
        isConHang = false;
    }
    public String tinhTrangHang(){
        if(isConHang) return "Con hang";
        else return "Da het hang";
    }
    public MatHang(){}

    /**
     *
     * @param t ten mat hang
     * @param gb gia ban
     * @param conHang tinh trang: 1 la con hang, 0 la khong con hang
     */
    public MatHang(String t, double gb, String td, int conHang){

        ten = t;
        giaBan = gb;
        thoiDiemBan = td;
        if(conHang ==0) isConHang = false;
    }
    public MatHang(String t, double gb, String td){
        ten = t;
        giaBan = gb;
        thoiDiemBan = td;
    }
    public void nhapThongTin(){
        System.out.print("Ten: ");
        ten = SC.nextLine();
        System.out.print("Gia Ban: ");
        giaBan = Double.parseDouble(SC.nextLine());
        System.out.print("Thoi diem ban: ");
        thoiDiemBan = SC.nextLine();
        System.out.print("Tinh trang hang (1 con hang, 0 het hang): ");
        int i = Integer.parseInt(SC.nextLine());
        if(i == 0) isConHang = false;
    }
    public String loai(){
        return null;
    }
    @Override
    public String toString() {
        return String.format("Ten: %s\nGia Ban: %.0fVND\nThoi diem ban: %s\nTinh trang: %s",
                ten, giaBan, thoiDiemBan, this.tinhTrangHang());
    }

    public void setThoiDiemBan(String thoiDiemBan) {
        this.thoiDiemBan = thoiDiemBan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

}
