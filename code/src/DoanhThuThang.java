import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.Stream;

public enum DoanhThuThang {
    ThangMot(1){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 1: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangHai(2){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 2: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangBa(3){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 3: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangBon(4){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 4: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangNam(5){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 5: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangSau(6){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 6: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangBay(7){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 7: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangTam(8){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 8: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangChin(9){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 9: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangMuoi(10){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 10: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangMuoiMot(11){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 11: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    },
    ThangMuoiHai(12){
        @Override
        public void nhapSoTien() {
            System.out.print("Nhap doanh thu thang 12: ");
            setDoanhThu(new BigDecimal(SC.nextLine()));
        }

        @Override
        public String toString() {
            return String.format("Doanh thu thang %d: %f", getIdThang(), getDoanhThu());
        }
    };
//    private BigDecimal tien;
    private BigDecimal doanhThu;
    private int idThang;
    private static Scanner SC = new Scanner(System.in);
    DoanhThuThang(int thang, BigDecimal tien){
        setIdThang(thang);
        setDoanhThu(tien);
    }
    DoanhThuThang(int thang){
        setIdThang(thang);
    }
    public abstract void nhapSoTien();
    // chỉ ra cách thức để stream() cũng như truyền giá trị vào để có thể sử dụng stream()
    public static Stream<DoanhThuThang> stream(){
        return Stream.of(DoanhThuThang.values());
    }
    public BigDecimal getDoanhThu() {
        return doanhThu;
    }
    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }
    public int getIdThang() {
        return idThang;
    }
    public void setIdThang(int idThang) {
        this.idThang = idThang;
    }
}
