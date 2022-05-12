import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class QuanLyMatHang{
    private List<MatHang> dsMatHang = new ArrayList<>();
    public static final double chenhLech = 10000;
    public static String kyTu;
    public static double So;
    public static Scanner Sc = new Scanner(System.in);



    public void them(MatHang mv){
        dsMatHang.add(mv);
    }
    public void them() {
        System.out.print("Nhap loai mat hang: ");
        kyTu = Sc.nextLine();
        try{
            Class LoaiMatHang = Class.forName(kyTu);
            MatHang mh = (MatHang) LoaiMatHang.getDeclaredConstructor().newInstance();
            mh.nhapThongTin();
            dsMatHang.add(mh);
            System.out.println("Them Mat hang thanh cong");
        } catch(ClassNotFoundException| NoSuchMethodException|
                InvocationTargetException | InstantiationException |IllegalAccessException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public void xoa() {
        System.out.print("Nhap ten mat hang");
        kyTu = Sc.nextLine();
        try {
            dsMatHang.remove(this.tim(kyTu));
        }catch (NoSuchElementException ex){
            System.out.println("Xoa thanh cong");
        }
    }

    public void capNhat(){
        System.out.print("Nhap ten mat hang: ");
        kyTu = Sc.nextLine();
        try{
            this.tim(kyTu).nhapThongTin();
        }catch(NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }
    public void hienThiAll(){
        dsMatHang.forEach(System.out::println);
    }
    public void hienThi() {
        this.timTheoLoai("ThucAn").forEach(System.out::println);
        System.out.println("####################");
        this.timTheoLoai("ThucUong").forEach(System.out::println);
    }
    public List<MatHang> timTheoLoai(String loai) {
        return dsMatHang.stream().filter(s -> {
            try {
                Class LoaiMatHang = Class.forName(loai);
                return LoaiMatHang.isInstance(s);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return false;
        }).collect(Collectors.toList());
    }
    public void hienThi(MatHang mh) {
        System.out.print(mh);
    }
    public void nhapXuatMatHangCanTim(){
       System.out.print("(1) tim theo ten\n(2) tim theo gia\nlua chon cua ban: ");
       int j = Integer.parseInt(Sc.nextLine());
       switch (j){
           case 1 -> {
               System.out.print("Nhap ten cua mat hang: ");
               kyTu = Sc.nextLine();
               try {
                   this.hienThi(this.tim(kyTu));
               } catch (NoSuchElementException ex) {
                   System.out.println("Khong co du lieu");
               }
           }
           case 2 -> {
               System.out.print("Nhap khoang gia cua mat hang: ");
               So = Double.parseDouble(Sc.nextLine());
               try{
                   this.timTheoKhoangGia(So).forEach(System.out::println);
               } catch(NoSuchElementException ex){
                   System.out.println("Khong co du lieu");
               }

           }
           default -> { System.out.print("Khong co du lieu \n(1) thuc hien lai\n(2)Thoat");
               So = Integer.parseInt(Sc.nextLine());
               if(So == 1){
                   this.nhapXuatMatHangCanTim();
               } else System.out.println("cam on da su dung chuong trinh");}
       }
    }
    public List<MatHang> timTheoKhoangGia(double gia) throws NoSuchElementException{
            return dsMatHang.stream().filter(s -> s.getGiaBan() <= gia + chenhLech && s.getGiaBan() >= gia - chenhLech )
                    .collect(Collectors.toList());
    }
    public MatHang tim(String obj) throws NoSuchElementException {
        return dsMatHang.stream().filter(s -> s.getTen().contains(obj)).findFirst().get();
    }
    public MatHang tim(double gia) throws NoSuchElementException {
            return dsMatHang.stream().filter(s -> s.getGiaBan() == gia).findFirst().get();
    }





    public void capNhat(MatHang mh){
        mh.nhapThongTin();
    }
//    public void capNhatMatHang(String ten){
//        try{
//            this.timMatHang(ten).nhapThongTinh();
//        }catch(NoSuchElementException ex){
//            System.out.println("Khong co du lieu");
//        }
//    }
//    public void hienThiDsMatHang(){
//        dsMatHang.forEach(System.out::println);
//    }
    public MatHang monDatNhat(){
        return dsMatHang.stream().max((s1, s2) -> (int) (s1.getGiaBan() - s2.getGiaBan())).get();
    }
//    public void themMatHang(String loai) {
//        try{
//            Class LoaiMatHang = Class.forName(loai);
//            MatHang mh = (MatHang) LoaiMatHang.getDeclaredConstructor().newInstance();
//            mh.nhapThongTinh();
//            dsMatHang.add(mh);
//        } catch( ClassNotFoundException| NoSuchMethodException|
//                InvocationTargetException | InstantiationException |IllegalAccessException ex){
//            ex.printStackTrace();
//        }
//    }
//    public void xoaMatHang(MatHang mh){
//        dsMatHang.remove(mh);
//    }
//    public void xoaMatHang(String ten){
//        try{
//            dsMatHang.remove(this.timMatHang(ten));
//        }catch(NoSuchElementException ex){
//            System.out.println("Khong co du lieu");
//        }
//    }
//    public MatHang timMatHang(String ten) throws NoSuchElementException{
//             return dsMatHang.stream().filter(s -> s.getTen().contains(ten)).findFirst().get();
//    }
    public int size(){
        return dsMatHang.size();
    }
    //tim mat hang theo khoang gia

//    public void tongTien(){
//        List<Double> a = null;
//        dsMatHang.forEach(s -> a.add(s.getGiaBan()));
//
//    }
//    public List<MatHang> timTheoLoai(String loai){
//     return dsMatHang.stream().filter(s -> {
//          try{
//              Class LoaiMatHang = Class.forName(loai);
//              return LoaiMatHang.isInstance(s);
//          } catch( ClassNotFoundException ex){
//              ex.printStackTrace();
//          }
//          return false;
//      }).collect(Collectors.toList());
//    }
    public void sapxepTang(){
//         dsMatHang.sort((s1, s2) -> {
//             double x1 = s1.getGiaBan();
//             double x2 = s2.getGiaBan();
//             return (Double.compare(x1, x2));
//         } );
        dsMatHang.sort((s1, s2) -> (int)(s1.getGiaBan() - s2.getGiaBan()));
    }
    public void sapxepGiam(){
        dsMatHang.sort((s1, s2) -> (int) -(s1.getGiaBan() - s2.getGiaBan()));
    }
    public List<MatHang> getDsMatHang() {
        return dsMatHang;
    }
    public void setDsMatHang(List<MatHang> dsMatHang) {
        this.dsMatHang = dsMatHang;
    }
}
