import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuanLyChung{
    private QuanLyDatHang qldh = new QuanLyDatHang();
    private QuanLyDoanhThu quanLyDoanhThu = new QuanLyDoanhThu();
    private QuanLyBanAn qlb = new QuanLyBanAn();
    private QuanLyNhanVien qlnv = new QuanLyNhanVien();
    private QuanLyMatHang qlmh = new QuanLyMatHang();
    public QuanLyChung(){};
    public QuanLyChung(QuanLyNhanVien dsnv, QuanLyBanAn dsba, QuanLyMatHang dsmh,QuanLyDatHang dsdh, QuanLyDoanhThu dt){
        qlnv = dsnv;
        qlb = dsba;
        qlmh = dsmh;
        qldh = dsdh;
        quanLyDoanhThu = dt;
    }
    public void hienThi(int i){
        switch (i){
            case 1 -> getQlnv().hienThi();
            case 2 -> getQlb().hienThiDsBanTrong();
            case 3 -> getQlmh().hienThi();
            default -> System.out.println("Khong co du lieu");
        }
    }
    public void them(int i){
        switch (i) {
            case 1 -> getQlnv().them();
            case 2 -> getQlb().them();
            case 3 -> getQlmh().them();
            default -> System.out.println("Khong co du lieu");
        }
    }
    public void xoa(int i){
        switch (i) {
            case 1 -> getQlnv().xoa();
            case 2 -> getQlb().xoa();
            case 3 -> getQlmh().xoa();
            default -> System.out.println("Khong co du lieu");
        }
    }
    public void capNhat(int i){
        switch (i){
            case 1 -> getQlnv().capNhat();
            case 2 -> getQlb().capNhat();
            case 3 -> getQlmh().capNhat();
            default -> System.out.println("Khong co du lieu");
        }
    }
    public void tim(int i){
        switch (i){
            case 1 -> getQlnv().nhapVaXuatNhanVienCanTim();
            case 2 -> getQlb().nhapXuatBanAnCanTim();
            case 3 -> getQlmh().nhapXuatMatHangCanTim();
            default -> System.out.println("Khong co du lieu");
        }
    }

//    public void datBanVaDatHang() {
//        getQldh().themdsDat(getQlb(), getQlmh());
//    }
    // Tạo ra xong nhớ ép kiểu ví dụ SanPham sp = (SanPham) obj
//    public abstract void them(String obj);
//    public abstract void xoa(String obj);
//    public abstract void capNhat(String x);
//    public abstract void hienThi();
//    public abstract void  hienThi(Object obj);
//    public abstract Object tim(String obj);
//    public abstract Object tim(double id);
//    public abstract String test(Object obj);
    public QuanLyDatHang getQldh() {
        return qldh;
    }

    public void setQldh(QuanLyDatHang qldh) {
        this.qldh = qldh;
    }

    public QuanLyDoanhThu getDoanhThu() {
        return quanLyDoanhThu;
    }

    public void setDoanhThu(QuanLyDoanhThu dt) {
        this.quanLyDoanhThu = dt;
    }

    public QuanLyBanAn getQlb() {
        return qlb;
    }

    public void setQlb(QuanLyBanAn qlb) {
        this.qlb = qlb;
    }

    public QuanLyNhanVien getQlnv() {
        return qlnv;
    }

    public void setQlnv(QuanLyNhanVien qlnv) {
        this.qlnv = qlnv;
    }

    public QuanLyMatHang getQlmh() {
        return qlmh;
    }

    public void setQlmh(QuanLyMatHang qlmh) {
        this.qlmh = qlmh;
    }
}
