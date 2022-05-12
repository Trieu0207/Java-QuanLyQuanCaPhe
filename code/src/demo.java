import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class demo {

    public static void main(String[] args) throws ParseException, IOException, InterruptedException {
        NhanVien nv1 = new PhaChe("Nguyen Van A", "Nam", "Quang Ngai", "02/12/2002");
        NhanVien nv2 = new PhaChe("Nguyen Van B", "Nam", "Quang Nam", "15/07/2002");
        NhanVien nv3 = new TiepTan("Nguyen Thi C", "Nu", "Hue", "15/09/2002");
        NhanVien nv4 = new PhucVu("Nguyen Van D", "Nam", "Long An", "25/12/2000");
        NhanVien nv5 = new PhucVu("Nguyen Thi E", "Nu", "Da Lat", "15/12/2001");
        NhanVien nv6 = new TiepTan("Nguyen Van F", "Nam", "Vinh", "23/12/1997");
        NhanVien nv7 = new PhaChe("Nguyen Thi G", "Nu", "Tp Ho Chi Minh", "6/07/1999");
        Scanner sc = new Scanner(System.in);
        QuanLyChung qlc = new QuanLyChung();
        qlc.getQlnv().them(nv1);
        qlc.getQlnv().them(nv2);
        qlc.getQlnv().them(nv3);
        qlc.getQlnv().them(nv4);
        qlc.getQlnv().them(nv5);
        qlc.getQlnv().them(nv6);
        qlc.getQlnv().them(nv7);


        BanAn b1 = new BanAn(2);
        BanAn b2 = new BanAn(4);
        BanAn b3 = new BanAn(6);
        BanAn b4 = new BanAn(10);
        BanAn b5 = new BanAn(4);
        BanAn b6 = new BanAn(2);
        BanAn b7 = new BanAn(10);
        qlc.getQlb().them(b1);
        qlc.getQlb().them(b2);
        qlc.getQlb().them(b3);
        qlc.getQlb().them(b4);
        qlc.getQlb().them(b5);
        qlc.getQlb().them(b6);
        qlc.getQlb().them(b7);




        MatHang n1 = new ThucAn("com ga", 25000,"sang, trua",1, 0);
        MatHang n2 = new ThucAn("pho", 30000,"sang",1, 0);
        MatHang n3 = new ThucAn("lau nam", 150000,"sang, trua, toi",1, 1);
        MatHang n4 = new ThucAn("banh takco", 25000,"sang",1, 0);
        MatHang n5 = new ThucAn("banh takco chay", 20000,"sang",1, 1);
        MatHang n6 = new ThucAn("com suong", 25000,"sang, trua",1, 0);
        MatHang u1 = new ThucUong("caphe", 15000, "sang trua toi", 1,1);
        MatHang u2 = new ThucUong("cacao nong", 18000, "sang trua toi", 1,0);
        MatHang u3 = new ThucUong("tra sua", 16000, "sang trua toi", 1,1);
        MatHang u4 = new ThucUong("nuoc ep dua hau", 17000, "sang trua toi", 1,1);
        MatHang u5 = new ThucUong("sua tuoi tran chau duong den", 12000, "sang trua toi", 1,1);
        qlc.getQlmh().them(n1);
        qlc.getQlmh().them(n2);
        qlc.getQlmh().them(u2);
        qlc.getQlmh().them(u3);
        qlc.getQlmh().them(n3);
        qlc.getQlmh().them(n4);
        qlc.getQlmh().them(n5);
        qlc.getQlmh().them(n6);
        qlc.getQlmh().them(u1);

        qlc.getQlmh().them(u4);
        qlc.getQlmh().them(u5);

        QuanLyMatHang dsMatHang = new QuanLyMatHang();

        NguoiQuanLy quanLy = new NguoiQuanLy(qlc);
        quanLy.menu();


        }

    }
