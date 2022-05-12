import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class QuanLyDoanhThu {
    private int So;
    private BigDecimal tienTong = new BigDecimal(0);
    private static Scanner Sc = new Scanner(System.in);
    public void nhap(){
        int i;
        int j;
        System.out.print("Nhap doanh thu \n(1) ca nam \n(2) theo thang \n(3) tu thang -> thang \nLua chon cua ban: ");
        So = Integer.parseInt(Sc.nextLine());
        switch (So){
            case 1 -> {
                nhapDoanhThu();
            }
            case 2 -> {
               System.out.print("Nhap thang: ");
               i = Integer.parseInt(Sc.nextLine());
               nhapDoanhThu(i);
            }
            case 3 -> {
                System.out.print("Nhap thang bat dau: ");
                i = Integer.parseInt(Sc.nextLine());
                System.out.print("Nhap thang ket thuc");
                j = Integer.parseInt(Sc.nextLine());
                nhapDoanhThu(i, j);
            }
            default -> {
                System.out.print("Khong co du lieu");
            }
        }
    }
    public void xuat(){
        int i;
        int j;
        System.out.print("Hien thi doanh thu \n(1) ca nam \n(2) theo thang \n(3) tu thang -> thang \nLua chon cua ban: ");
        So = Integer.parseInt(Sc.nextLine());
        switch (So){
            case 1 -> {
                this.xuatDoanhThu();
            }
            case 2 -> {
                System.out.print("Nhap thang: ");
                i = Integer.parseInt(Sc.nextLine());
                xuatDoanhThu(i);
            }
            case 3 -> {
                System.out.print("Nhap thang bat dau: ");
                i = Integer.parseInt(Sc.nextLine());
                System.out.print("Nhap thang ket thuc: ");
                j = Integer.parseInt(Sc.nextLine());
                xuatDoanhThu(i, j);
            }
        }
    }
    public void tongDoanhThu(){
        int i;
        int j;
        System.out.print("Tong doanh thu \n(1) ca nam \n(2) tu thang -> thang \nLua chon cua ban: ");
        So = Integer.parseInt(Sc.nextLine());
        switch(So){
            case 1 -> {
                System.out.printf("Tong doanh thu ca nam la: %.1f\n", this.tongTien());
            }
            case 2 -> {
                System.out.print("Nhap thang bat dau: ");
                i = Integer.parseInt(Sc.nextLine());
                System.out.print("Nhap thang ket thuc: ");
                j = Integer.parseInt(Sc.nextLine());
                System.out.printf("Tong doanh thu tu thang %d den %d la: %.1f\n", i, j, this.tongTien(i, j));
            }
            default -> {
                System.out.println("Khong co du lieu");
            }
        }
    }
    public void nhapDoanhThu(){
        EnumSet.allOf(DoanhThuThang.class).forEach(DoanhThuThang::nhapSoTien);
    }

    public void nhapDoanhThu(int thangBD, int thangKT){
        try{
            this.timDoanhThuThang(thangBD, thangKT).forEach(DoanhThuThang::nhapSoTien);
        } catch(NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public void nhapDoanhThu(int thang){
        try{
           this.timDoanhThuThang(thang).nhapSoTien();
        } catch (NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public DoanhThuThang timDoanhThuThang(int thang) throws NoSuchElementException{
          return DoanhThuThang.stream().filter(s -> s.getIdThang() == thang).findFirst().get();

    }

    public List<DoanhThuThang> timDoanhThuThang(int thangBD, int thangKT) throws NoSuchElementException{
        return DoanhThuThang.stream().filter(s -> s.getIdThang() >= thangBD && s.getIdThang() <= thangKT)
                .collect(Collectors.toList());
    }

    public void xuatDoanhThu(int thang){
        try{
           System.out.println( this.timDoanhThuThang(thang));
        } catch (NoSuchElementException ex){
            System.out.println("Khong co duu lieu");
        }
    }

    public void xuatDoanhThu(int thangBD, int thangKT){
        try{
            timDoanhThuThang(thangBD, thangKT).forEach(System.out::println);
        } catch(NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public void xuatDoanhThu(){
        EnumSet.allOf(DoanhThuThang.class).forEach(System.out::println);
    }

    public void tinhTongTien(BigDecimal tien){
        setTienTong(getTienTong().add(tien));
    }

    public BigDecimal tongTien(){
        EnumSet.allOf(DoanhThuThang.class).forEach(s -> this.tinhTongTien(s.getDoanhThu()));
        return this.getTienTong();
    }

    public BigDecimal tongTien  (int thangBD, int thangKT) throws NoSuchElementException{
        BigDecimal tong = new BigDecimal(0);
            this.timDoanhThuThang(thangBD, thangKT).forEach( s ->  this.tinhTongTien(s.getDoanhThu()));
            return getTienTong();
    }

    public BigDecimal getTienTong() {
        return tienTong;
    }

    public void setTienTong(BigDecimal tienTong) {
        this.tienTong = tienTong;
    }
}
