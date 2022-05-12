public class TiepTan extends NhanVien {
    public static int demBoPhan;
    private String maBoPhan = String.format("TT%02d", ++ demBoPhan);
    private static String TBP = "Tiep Tan";
    public TiepTan(){
        super();
    }
    public TiepTan(String ht, String gt, String qq, String ns){
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
