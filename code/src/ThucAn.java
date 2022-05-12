public class ThucAn extends MatHang{
    private boolean isThucAnChay = false;

    // so 0 la khong phai thuc an chay con so 1 la thuc an chay

    /**
     *
     * @param t ten
     * @param gb gia ban
     * @param td thoi diem ban
     * @param thucAnChay  so 0 la khong phai thuc an chay, so 1 la thuc an chay
     */
    public ThucAn(String t, double gb, String td, int thucAnChay){
        super(t,gb, td);
        if(thucAnChay == 1) isThucAnChay = true;
    }

    /**
     *
     * @param t ten mon an
     * @param gb gia ban mon an
     * @param td thoi diem ban
     * @param conHang tinh trang con hang
     * @param thucAnChay loai thuc an: 1 la thuc an chay, 0 khong phai thuc pham chay
     */
    public ThucAn(String t, double gb, String td, int conHang, int thucAnChay){
        super(t, gb, td, conHang);

    }
    public ThucAn(){};

    @Override
    public void nhapThongTin() {
        int i;
        super.nhapThongTin();
        System.out.print("Co phai thuc pham chay hay khong (1 neu co 0 neu khong): ");
        i = Integer.parseInt(SC.nextLine());
        if(i == 1) isThucAnChay = true;
    }

    public String thucAnChay(){
        if(isThucAnChay) return "Thuc Pham Chay";
        else return "Khong Phai Thuc Pham Chay";
    }

    @Override
    public String loai() {
        return "Thuc An";
    }

    @Override
    public String toString() {
        return String.format("Loai: %s\n%s\n%s\n", this.loai(), super.toString(), this.thucAnChay());
    }

    public boolean isThucAnChay() {
        return isThucAnChay;
    }

    public void setThucAnChay(boolean thucAnChay) {
        isThucAnChay = thucAnChay;
    }
}
