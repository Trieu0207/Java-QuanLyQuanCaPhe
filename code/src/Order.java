import java.util.NoSuchElementException;
import java.util.Scanner;

public class Order {
    protected QuanLyBanAn dsDatBan = new QuanLyBanAn();
    private double tongTien;
    public String idDonHan;
    protected QuanLyMatHang dsDatHang = new QuanLyMatHang();
    public static final Scanner SC = new Scanner(System.in);
    public static String idBan;
    public static int tam;
    public static String tenHang;
    public static BanAn ba;
    protected int sn;
    public boolean trangThai = true;

    public void hienThiOrder() {
        System.out.print("==== Ban da dat ==== \n");
        dsDatBan.hienThi();
        System.out.printf("Tong tien thanh toan: %.1f\n", tongTien);
    }

    @Override
    public String toString() {
//        return "Order{" +
//                "dsDatBan=" + dsDatBan +
//                ", tongTien=" + tongTien +
//                ", idDonHan='" + idDonHan + '\'' +
//                ", dsDatHang=" + dsDatHang +
//                ", sn=" + sn +
//                '}'
        return "==== Ban da dat ==== \n" + dsDatBan + "== Cac mon da dat ===\n" + dsDatHang
                + "Tong tien thanh toan: " + tongTien;
    }

    public Order(){}
    public Order(QuanLyBanAn dsBan, QuanLyMatHang dsHang){
        dsDatBan = dsBan;
        dsDatHang = dsHang;
    }
    public void nhapOrder(QuanLyBanAn dsb, QuanLyMatHang dsh){ // dat duoc ban thi moi dat duoc hang
        this.nhap(dsb);
        if(this.trangThai) this.nhap(dsh);

    }

    public void trangThaiThanhToan(String id){
        this.dsDatBan.tim(id).huyDatBan();
    }
    public void nhap(QuanLyMatHang dsMatHang){
        int i;

        System.out.println("===Dat thuc an thuc uong===");
        dsMatHang.hienThi();
        do{
            System.out.print("Nhap ten: ");
            tenHang = SC.nextLine();
            System.out.print("So luong: ");
            tam = Integer.parseInt(SC.nextLine());
            while(tam > 0){
                try{
                    dsDatHang.them(dsMatHang.tim(tenHang));
                }catch(NoSuchElementException ex){
                    System.out.println("Khong tim duoc hang");
                    tam = 0;
                }
                tam--;
            }
            if(dsDatHang.size() > 0)  System.out.print("Dat hang Thanh cong!!\n");
            else System.out.println("Dat hang khong thanh cong");
            System.out.print("Tiep tuc dat hang(1) thoat(0): ");
            i = Integer.parseInt(SC.nextLine());
        }while (i == 1);
        if(dsDatHang.size() > 0) {
            System.out.printf("Ban da dat hang thanh cong %d mon!!\n", dsDatHang.size());
            this.tongSoTien();
        }
    }
    public void nhap(QuanLyBanAn dsBanAn){
        System.out.print("Nhap so nguoi: ");
        sn = Integer.parseInt(SC.nextLine());
        dsBanAn.hienThiDsBanAn(sn);
        System.out.print("Nhap ma ban an: ");
        idBan = SC.nextLine();
        // bat loi khong tim duoc ban cua timBanAn(String id) class QuanLyBanAn
        try{
            ba = dsBanAn.tim(sn).stream().filter(s -> s.getMaBanAn().contains(idBan)).findFirst().get();
            idDonHan = ba.getMaBanAn();
            dsDatBan.them(ba);
            ba.datBan();
            System.out.println("Dat ban Thanh cong");
        } catch (NoSuchElementException ex){
            trangThai = false;
            System.out.println("Dat ban khong thanh cong!");

        }
    }
    public void tongSoTien(){
        tongTien += dsDatHang.getDsMatHang().stream().mapToDouble(MatHang::getGiaBan).sum();
    }

    public void setTongTien(double tongtien) {
        this.tongTien = tongTien;
    }

    public QuanLyBanAn getDsDatBan() {
        return dsDatBan;
    }

    public void setDsDatBan(QuanLyBanAn dsDatBan) {
        this.dsDatBan = dsDatBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public String getIdDonHan() {
        return idDonHan;
    }
}
