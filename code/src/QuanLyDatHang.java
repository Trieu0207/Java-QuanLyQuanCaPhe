import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuanLyDatHang{
    private List<Order> dsDat = new ArrayList<>();
    private static String KyTu;
    private static Scanner SC = new Scanner(System.in);


    public void hienThi(){
        dsDat.forEach(Order::hienThiOrder);
    }

    public void hienThi(Order donHang){
        donHang.hienThiOrder();
    }

    public void hienThi(String id){
       try{
           this.timOrder(id).hienThiOrder();
       } catch(NoSuchElementException ex){
           System.out.println("khong tim duoc hoa don");
       }
    }

    public void themdsDat(QuanLyBanAn ba, QuanLyMatHang mh){
        Order od =  new Order();
        od.nhapOrder(ba, mh);
        dsDat.add(od);
        od.hienThiOrder();
    }
    public void themdsDat(Order dh){
        dsDat.add(dh);
    }

    public void timOrder(){
        System.out.println("nhap ban muon tim");
        KyTu = SC.nextLine();
        try{
            System.out.println(this.timOrder(KyTu));

        }catch (NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }
    }

    public Order timOrder(String id) throws NoSuchElementException{
           return dsDat.stream().filter(s -> s.getIdDonHan().contains(id)).findFirst().get();
    }

    public void thanhToan(){
        System.out.print("Nhap ban muon thanh toan: ");
        KyTu = SC.nextLine();
        try{
            this.thanhToan(KyTu);
        } catch (NoSuchElementException ex){
            System.out.println("Khong co du lieu");
        }

    }

     public void thanhToan(String id) throws NoSuchElementException{ // Xoa
            // huy ban theo id -> xoa ban co id ra khoi ds dat
         this.dsDat.stream().filter(s -> s.getIdDonHan().contains(id)).findFirst().get().trangThaiThanhToan(id);
         dsDat.remove(dsDat.stream().filter(s -> s.getIdDonHan().contains(id)).findFirst().get());

            System.out.println("Don hang thanh toan thanh cong");
  }
    public int size(){
        return this.dsDat.size();
    }

    public List<Order> getDsDat() {
        return dsDat;
    }

    public void setDsDat(List<Order> dsDat) {
        this.dsDat = dsDat;
    }


}
