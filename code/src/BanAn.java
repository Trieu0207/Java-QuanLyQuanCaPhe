import java.util.Scanner;

public class BanAn {
    public static int demBanAn;
    private String maBanAn = String.format("B%02d", ++demBanAn);
    private int soNguoi;
    private boolean isTrongBan = true;
    public static Scanner SC = new Scanner(System.in);


    public BanAn(){}
    public BanAn(int sn){
        soNguoi = sn;
    }
    public void nhap(){
        System.out.print("So nguoi: ");
        soNguoi = Integer.parseInt(SC.nextLine());
        System.out.print("Tinh trang( Con Trong(1) Khong con trong(0): ");
        int i = Integer.parseInt(SC.nextLine());
        if(i == 0) isTrongBan = false;
    }
    public void datBan(){
        this.isTrongBan = false;
    }
    public void huyDatBan(){
        this.isTrongBan = true;
    }
    public String tinhTrang(){
        if(isTrongBan) return "Con Trong";
        else return "Da Co Nguoi";
    }
    @Override
    public String toString() {
        return String.format("Ma Ban: %s\nSo Nguoi: %d\nTrang Thai: %s\n",
                maBanAn, soNguoi, this.tinhTrang());
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public boolean isTrongBan() {
        return isTrongBan;
    }

    public void setTrongBan(boolean trongBan) {
        isTrongBan = trongBan;
    }

    public String getMaBanAn() {
        return maBanAn;
    }
}
