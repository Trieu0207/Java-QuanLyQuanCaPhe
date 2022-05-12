import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuanLyBanAn {
    private List<BanAn> dsBanAn = new ArrayList<>();
    private static int So;
    private static String Kytu;
    private static Scanner Sc = new Scanner(System.in);



    public void them() {
        System.out.print("Nhap so nguoi: ");
        So = Integer.parseInt(Sc.nextLine());
        dsBanAn.add(new BanAn(So));
        System.out.println("Them thanh cong");
    }

    public void them(BanAn ba){
        this.dsBanAn.add(ba);
    }

    public void xoa(){
        System.out.print("Nhap ma Ban: ");
        Kytu = Sc.nextLine();
        try {
            dsBanAn.remove(this.tim(Kytu));
        }catch (NoSuchElementException ex){
            System.out.println("Xoa thanh cong");
        }
    }

    public void capNhat(){
        System.out.print("Nhap ma ban: ");
        Kytu = Sc.nextLine();
       try{
           this.tim(Kytu).nhap();
       } catch(NoSuchElementException ex){
           System.out.println("Khong co du lieu");
       }
    }

    public void hienThi() {
        this.dsBanAn.forEach(System.out::println);
    }

    public void hienThi(BanAn ba) {
        System.out.print(ba);
    }

    // lay ds ban an theo so nguoi roi xem con trong ban khong
    public void hienThiDsBanAn(int soNguoi){
        try{
            this.tim(soNguoi).stream().filter(BanAn::isTrongBan).forEach(System.out::println);
        } catch(NoSuchElementException ex){
            System.out.println("Het ban");
        }
    }

    public void hienThiDsBanTrong(){
        try{
            this.dsBanTrong().forEach(System.out::println);
        } catch (NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public void nhapXuatBanAnCanTim(){
        System.out.print("Nhap ma ban an: ");
        Kytu = Sc.nextLine();
        try{
            this.hienThi(this.tim(Kytu));
        } catch(NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public BanAn tim(String id) throws NoSuchElementException{
        return dsBanAn.stream().filter(s -> s.getMaBanAn().equals(id)).findFirst().get();
    }

    public List<BanAn> tim(double soNguoi) throws NoSuchElementException{
        return dsBanAn.stream().filter(s -> s.getSoNguoi() == soNguoi).collect(Collectors.toList());
    }

    public int size(){
       return dsBanAn.size();
    }

    public List<BanAn> dsBanTrong() throws NoSuchElementException{
            return dsBanAn.stream().filter(BanAn::isTrongBan).collect(Collectors.toList());
    }

    public List<BanAn> getDsaBanAn() {
        return dsBanAn;
    }

    public void setDsaBanAn(List<BanAn> dsaBanAn) {
        this.dsBanAn = dsaBanAn;
    }
}
//    public void xoaBanAn(BanAn ba){
//        dsBanAn.remove(ba);
//    }
//    public void xoaBanAn(String id){
//        dsBanAn.remove(this.timBanAn(id));
//    }
//    public void capNhat(BanAn ba){
//        ba.nhap();
//    }



//    public void capNhat(String id) throws NoSuchElementException{
//
//    }



    // nem ra loi cho class DatHang su ly
//    public BanAn timBanAn(String id) throws NoSuchElementException{
//            return dsBanAn.stream().filter(s -> s.getMaBanAn().equals(id)).findFirst().get();
//    }
//    public List<BanAn> timBanAn(int soNguoi){
//        try{
//            return dsBanAn.stream().filter(s -> s.getSoNguoi() == soNguoi).collect(Collectors.toList());
//        } catch (NoSuchElementException ex){
//            System.out.println("khong co ban co so nguoi tren");
//        }
//        return null;
//    }
//    public void themBanAn(int soNguoi){
//        BanAn ba = new BanAn(soNguoi);
//        dsBanAn.add(ba);
//    }
//    public void themBanAn(BanAn ba){
//        dsBanAn.add(ba);
//    }

