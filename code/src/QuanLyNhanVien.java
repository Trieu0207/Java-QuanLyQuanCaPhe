import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class QuanLyNhanVien {
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private List<NhanVien> dsNhanVien = new ArrayList<>();
    public final Date N1 = new Date();
    public static String tenBoPhan;
    private static int So;
    private static String KyTu;
    public static Scanner Sc = new Scanner(System.in);



    public void them(NhanVien nv){
        dsNhanVien.add(nv);
    }

    public void them()  {
        System.out.print("Nhap bo phan ma nhan vien lam viec: ");
        tenBoPhan = Sc.nextLine();
        try{
            Class BoPhan = Class.forName(tenBoPhan);
            NhanVien nv = (NhanVien) BoPhan.getDeclaredConstructor().newInstance();
            nv.nhapThongTin();
            dsNhanVien.add(nv);
            System.out.println("Them thanh cong");
        } catch(ClassNotFoundException | NoSuchMethodException |
                InstantiationException | IllegalAccessException | InvocationTargetException ex){
            System.out.println("Khong tim duoc bo phan nhan vien lam viec\nThem nhan vien khong thanh cong");
        }
    }

    public void xoa() {
        System.out.print("Nhap ma nhan vien: ");
        So = Integer.parseInt(Sc.nextLine());
        try {
            dsNhanVien.remove(this.tim(So));
            System.out.println("Xoa thanh cong");
        }catch (NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public void capNhat(){
        System.out.print("Nhap ma nhan vien: ");
        So = Integer.parseInt(Sc.nextLine());
            try{
                this.tim(So).nhapThongTin();
            } catch (NoSuchElementException ex){
                System.out.println("Khong co thong tin");
            }

    }

    public void hienThi() {
        dsNhanVien.forEach(System.out::println);
    }

    public void hienThi(NhanVien nv) {
        System.out.print(nv);
    }

    public NhanVien tim(int id) throws NoSuchElementException {
        return dsNhanVien.stream().filter(s -> s.getMaNhanVien() == id).findFirst().get();
    }

    public List<NhanVien> tim(String obj) throws  NoSuchElementException{
        return dsNhanVien.stream().filter(s -> s.getHoTen().equals(obj) ||
                s.getGioiTinh().equals(obj) || s.getQueQuan().equals(obj) ||
                F.format(s.getNgaySinh()).contains(obj)).collect(Collectors.toList());
    }

    public void nhapVaXuatNhanVienCanTim(){
        System.out.println("(1) tim them ma nhan vien\n(2) tim them ho ten / que quan / ngay sinh / gioi tinh ");
        int j = Integer.parseInt(Sc.nextLine());
       switch (j) {
           case 1 -> {
               System.out.print("Nhap ma nhan vien: ");
               So = Integer.parseInt(Sc.nextLine());
               try{
                   this.hienThi(this.tim(So));
               } catch (NoSuchElementException ex){
                   System.out.println("Khong co du lieu");
               }
           }
           case 2 ->{
               System.out.print("Nhap ho ten / que quan / ngay sinh / gioi tinh: ");
               KyTu = Sc.nextLine();
               try{
                   this.tim(KyTu).forEach(System.out::println);
               } catch (NoSuchElementException ex){
                   System.out.println("Khong co du lieu");
               }
           }
           default ->{
               System.out.print("Khong co du lieu \n(1) thuc hien lai\n(2)Thoat");
               So = Integer.parseInt(Sc.nextLine());
               if(So == 1){
                   this.nhapVaXuatNhanVienCanTim();
               } else System.out.println("cam on da su dung chuong trinh");

           }
       }
    }

    public int size(){
        return dsNhanVien.size();
    }

    public void toChuSinhNhat() {
        try{
            this.sinhNhat().forEach(System.out::println);
        } catch(NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }
    public List<NhanVien> sinhNhat() throws NoSuchElementException{
           return dsNhanVien.stream().filter(s -> s.getNgaySinh().getMonth() == N1.getMonth()).collect(Collectors.toList());
    }
    public void capNhat(NhanVien nv){
        nv.nhapThongTin();
    }

    public void xoaNhanVien(NhanVien nv){
        dsNhanVien.remove(nv);
    }

    public void themNhanVien(NhanVien nv){
        dsNhanVien.add(nv);
    }

    public List<NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }

    public void setDsNhanVien(List<NhanVien> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
    }
//    public void capNhat(int id){
//        try{
//            System.out.printf("Cap nhat thong tin nhan vien thu %d\n", id);
//            this.timNhanVienTheoMa(id).nhapThongTin();
//        } catch(NoSuchElementException ex){
//            System.out.println("Khong co du lieu");
//        }
//    }

//    public List<NhanVien> timNhanVienTheoTenVaQueQuan(String obj){
//        List<NhanVien> ds = new ArrayList<>();
//        try{
//         return dsNhanVien.stream().filter(s -> s.getHoTen().contains(obj)
//         || s.getQueQuan().contains(obj)).collect(Collectors.toList());
//        } catch( NoSuchElementException ex){
//            System.out.println("Khong tim thay ten nhan vien");
//        }
//        return null;
//    }
//    public List<NhanVien> timNhanVienTheoNgaySinh(String ns){ //n1 == (Date) sf.parse("02/07/2002")
//        try{
//            return dsNhanVien.stream().filter(s -> {
//                        try {
//                            return s.getNgaySinh() == (Date) NhanVien.F.parse(ns);
//                        } catch (ParseException ex) {
//                            System.out.println("Khong tim thay ten nhan vien");
//                        }
//                        return false;
//                        })
//                    .collect(Collectors.toList());
//        } catch(NoSuchElementException ex){
//            System.out.println("Khong tim thay ten nhan vien");
//        }
//        return null;
//    }
//    public List<NhanVien> timNhanVienTheoThangSinh(int th){
//        try{
//            return dsNhanVien.stream().filter(s -> s.getNgaySinh().getMonth() + 1 == th)
//                    .collect(Collectors.toList());
//        } catch(NoSuchElementException ex){
//            System.out.println("Khong tim thay ten nhan vien");
//        }
//        return null;
//    }

//    public void xoaNhanVien(String id){
//       try{
//           xoaNhanVien(timNhanVienTheoMa(Integer.parseInt(id)));
//       } catch(NoSuchElementException ex){
//           System.out.println("Khong co du lieu");
//       }
//    }
//    public void hienThidsNhanVien(){
//        dsNhanVien.forEach(System.out::println);
//    }
//    public NhanVien timNhanVienTheoMa(int id) throws NoSuchElementException{
//            return dsNhanVien.stream().filter(s -> s.getMaNhanVien() == id).findFirst().get();
//    }
}
