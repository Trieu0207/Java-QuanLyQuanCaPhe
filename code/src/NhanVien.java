import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class NhanVien {
    public static int demNhanVien;
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    public static final Scanner SC = new Scanner(System.in);
    private int maNhanVien = ++demNhanVien;
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private Date ngaySinh;
    private Calendar ngayVaoLam;
    protected String tenBP;

    public NhanVien(){
        hoTen = null;
        gioiTinh = null;
        queQuan = null;
        ngaySinh = new Date();
    }
    public NhanVien(String ht, String gt, String qq, String ns){
        hoTen = ht;
        gioiTinh = gt;
        queQuan = qq;
        try{
            ngaySinh = F.parse(ns);
        } catch (ParseException ex){
            System.out.println("Du lieu Khong Hop Le");
        }
    }
    public abstract String tenBoPhan();

    public void nhapThongTin(){
        String ns;
        System.out.print("Ho va ten: ");
        hoTen = SC.nextLine();
        System.out.print("Ngay sinh: ");
        try{
            F.format(ngaySinh = F.parse(ns = SC.nextLine()));
        } catch(ParseException e){
            System.out.println("Du lieu Ngay Sinh Khong Hop Le");
            nhapThongTin();
        }
        System.out.print("Gioi tinh: ");
        gioiTinh = SC.nextLine();
        System.out.print("Que quan: ");
        queQuan = SC.nextLine();

    }

    @Override
    public String toString() {
        return String.format("Ho ten: %s\nMa nhan vien: %d\nNgay sinh: %s\nGioi tinh: %s\nQue quan: %s"
                                ,hoTen,maNhanVien, F.format(ngaySinh),gioiTinh,queQuan);
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Calendar getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Calendar ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getTenBP() {
        return tenBP;
    }

    public void setTenBP(String tenBP) {
        this.tenBP = tenBP;
    }
}
