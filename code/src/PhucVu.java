public class PhucVu extends NhanVien{
    public static int demBoPhan;
    private String maBoPhan = String.format("PV%02d", ++ demBoPhan);
    private static String tenBoPhan = "Phuc vu";
    private static String TBP = "Phuc Vu";
    public PhucVu(){super();}
    public PhucVu(String ht, String gt, String qq, String ns){
        super(ht, gt, qq, ns);
    }

    @Override
    public String tenBoPhan() {
        this.tenBP = TBP;
        return this.tenBP;
    }

    @Override
    public String toString() {
        return String.format("%s\nBo phan: %s\nMa bo phan: %s\n", super.toString(), this.tenBoPhan(), maBoPhan);
    }
    public String getMaBoPhan() {
        return maBoPhan;
    }

}
