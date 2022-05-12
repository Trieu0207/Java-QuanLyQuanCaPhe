public class ThucUong extends MatHang{
    private boolean isCoDa = true;

    // so 0 la khong da con so 1 la co da
    public ThucUong(String t, double gb, String td, int coDa){
        super(t, gb, td);
        if(coDa == 0) {
            isCoDa = false;
        }
    }
    public ThucUong(){};
    /**
     *
     * @param t ten mon an
     * @param gb gia ban mon an
     * @param td thoi diem ban
     * @param conHang tinh trang con hang
     * @param coDa loai thuc an: 1 la thuc an chay, 0 khong phai thuc pham chay
     */
    public ThucUong(String t, double gb, String td, int conHang, int coDa){
        super(t, gb, td, conHang);
        if(coDa == 0) {
            isCoDa = false;
        }

    }
    public String coDa(){
        if(isCoDa) return "Thuc uong co da";
        else return "Thuc uong khong da";
    }
    @Override
    public void nhapThongTin() {
        int i;
        super.nhapThongTin();
        System.out.print("Co da hay khong (1 co da 0 khong da): ");
        i = Integer.parseInt(SC.nextLine());
        if(i == 1) this.isCoDa = true;
        else isCoDa = false;
    }
    @Override
    public String loai() {
        return "Thuc Uong";
    }
    @Override
    public String toString() {
        return String.format("Loai: %s\n%s\n%s\n", this.loai(), super.toString(), this.coDa());
    }
    public boolean isCoDa() {
        return isCoDa;
    }
    public void setCoDa(boolean coDa) {
        isCoDa = coDa;
    }
}
