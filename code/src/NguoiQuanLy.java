import java.util.Scanner;

public class NguoiQuanLy {
    private QuanLyChung quanLyChung;
    private Scanner sc = new Scanner(System.in);
    private int chose;
    private String Kytu;
    public NguoiQuanLy(QuanLyChung qlc){
        quanLyChung = qlc;
    }
//    public String luaChon(int i){
//        if(i == 1){
//            return "QuanLy";
//        }
//    }
    public void cls1(){
        for(int z = 0; z < 5; z++)
            System.out.println("");
    }
    public void cls2(){
        System.out.print("Nhan so bat ki de tiep tuc chuong trinh ");
        Kytu = sc.nextLine();
        if(Kytu != null)
            for(int z = 0; z < 5; z++)
                System.out.println("");
    }
    public void menu(){
        int ch = 0;
        int i = 0;
        int j = 1;
     do{
         System.out.println("=== CHUONG TRINH QUAN LY ===");
         System.out.println("(1) QUAN LY NHAN VIEN ");
         System.out.println("(2) QUAN LY BAN AN ");
         System.out.println("(3) QUAN LY MAT HANG KINH DOANH ");
         System.out.println("(4) QUAN LY DANH SACH DAT HANG ");
         System.out.println("(5) QUAN LY DOANH THU ");
         System.out.print("Nhap lua chon cua ban: ");
         ch = Integer.parseInt(sc.nextLine());
         switch (ch){
             case 1 -> {
                 do {
                     this.cls1();
                     System.out.println("=== QUAN LY NHAN VIEN ===");
                     System.out.println("(1) Hien thi danh sach nhan vien");
                     System.out.println("(2) Them nhan vien");
                     System.out.println("(3) cap nhat nhan vien");
                     System.out.println("(4) xoa nhan vien");
                     System.out.println("(5) Tra cuu thong tin nhan vien");
                     System.out.println("(6) To chuc sinh nhat cho nhan vien");
                     System.out.println("(7) Thoat");
                     System.out.print("Nhap lua chon cua ban: ");
                     i = Integer.parseInt(sc.nextLine());
                     switch (i) {
                         case 1 -> {
                             this.cls1();
                             if (quanLyChung.getQlnv().size() == 0)
                                 System.out.println("Khong co du lieu");
                             else quanLyChung.getQlnv().hienThi();
                             this.cls2();
                         }
                         case 2 -> {
                             this.cls1();
                             quanLyChung.getQlnv().them();
                             this.cls2();
                         }
                         case 3 -> {
                             this.cls1();
                             quanLyChung.getQlnv().capNhat();
                             this.cls2();
                         }
                         case 4 -> {
                             this.cls1();
                             quanLyChung.getQlnv().xoa();
                             this.cls2();
                         }
                         case 5 -> {
                             this.cls1();
                             quanLyChung.getQlnv().nhapVaXuatNhanVienCanTim();
                             this.cls2();
                         }
                         case 6 -> {
                             this.cls1();
                             quanLyChung.getQlnv().toChuSinhNhat();
                             this.cls2();
                         }
                         default -> {

                             System.out.println("Cam on da su dung chuong trinh");
                             this.cls2();
                         }
                     }
                 } while (i > 0 && i < 7);

             }
            case 2 -> {
               do{
                   this.cls1();
                   System.out.println("=== QUAN LY BAN AN ===");
                   System.out.println("(1) Hien thi danh sach ban an trong");
                   System.out.println("(2) Them ban an");
                   System.out.println("(3) cap nhat ban an");
                   System.out.println("(4) xoa ban an");
                   System.out.println("(5) Tra cuu thong tin ban an");
                   System.out.println("(6) Hien thi danh sach ban an ");
                   System.out.println("(7) Thoat");
                   System.out.print("Nhap lua chon cua ban: ");
                   i = Integer.parseInt(sc.nextLine());
                   switch (i){
                       case 1 -> {
                           this.cls1();
                           if (quanLyChung.getQlb().size() == 0)
                               System.out.println("Khong co du lieu");
                           else quanLyChung.getQlb().hienThiDsBanTrong();
                           this.cls2();
                       }
                       case 2 -> {
                           this.cls1();
                           quanLyChung.getQlb().them();
                           this.cls2();
                       }
                       case 3 -> {
                           this.cls1();
                           quanLyChung.getQlb().capNhat();
                           this.cls2();
                       }
                       case 4 -> {
                           this.cls1();
                           quanLyChung.getQlb().xoa();
                           this.cls2();
                       }
                       case 5 -> {
                           this.cls1();
                           quanLyChung.getQlb().nhapXuatBanAnCanTim();
                           this.cls2();
                       }
                       case 6 -> {
                           this.cls1();
                           if (quanLyChung.getQlb().size() == 0)
                               System.out.println("Khong co du lieu");
                           else quanLyChung.getQlb().hienThi();
                           this.cls2();
                       }
                       default -> {
                           System.out.println("Cam on da su dung chuong trinh");
                           this.cls2();
                       }
                   }
               }while(i > 0 && i < 7);
            }
            case 3 -> {
                do{
                    this.cls1();
                    System.out.println("=== QUAN LY MAT HANG KINH DOANH ===");
                    System.out.println("(1) Hien thi menu ");
                    System.out.println("(2) Them mon an hoac thuc uong");
                    System.out.println("(3) cap nhat mon an");
                    System.out.println("(4) xoa mon an");
                    System.out.println("(5) Tra cuu thong tin mon an");
                    System.out.println("(6) sap xep mon an");
                    System.out.println("(7) Thoat");
                    System.out.print("Nhap lua chon cua ban: ");
                    i = Integer.parseInt(sc.nextLine());
                    switch (i){
                        case 1 -> {
                           this.cls1();
                           if(quanLyChung.getQlmh().size() == 0)
                               System.out.println("Khong co du lieu");
                           else quanLyChung.getQlmh().hienThi();
                           this.cls2();
                        }
                        case 2 -> {
                            this.cls1();
                            quanLyChung.getQlmh().them();
                            this.cls2();
                        }
                        case 3 -> {
                            this.cls1();
                            quanLyChung.getQlmh().capNhat();
                            this.cls2();
                        }
                        case 4 -> {
                            this.cls1();
                            quanLyChung.getQlmh().xoa();
                            this.cls2();
                        }
                        case 5 -> {
                            this.cls1();
                            quanLyChung.getQlmh().nhapXuatMatHangCanTim();
                            this.cls2();
                        }
                        case 6 -> {
                            QuanLyMatHang mh;
                            int so;
                           do{
                               this.cls1();
                               System.out.print("(1) sap xep tang\n(2) sap xep giam\n(3) Thoat\nNhap lua chon cua ban: ");
                               so = Integer.parseInt(sc.nextLine());
                               if(so == 1){
                                   this.cls1();
                                   mh = quanLyChung.getQlmh();
                                   mh.sapxepTang();
                                   mh.hienThi();
                                   this.cls2();
                               } else if(so == 2){
                                   this.cls1();
                                   mh = quanLyChung.getQlmh();
                                   mh.sapxepGiam();
                                   mh.hienThi();
                                   this.cls2();
                                    }else System.out.println("Cam on da su dung chuong trinh");
                           } while(so > 0 && so < 3);

                        }
                        default -> {
                            System.out.println("Cam on da su dung chuong trinh");
                            this.cls2();
                        }
                    }
                } while(i > 0 && i < 7);
            }
            case 4 -> {
               do{
                   this.cls1();
                   System.out.println("=== QUAN LY DANH SACH DAT HANG ===");
                   System.out.println("(1) Hien thi danh sach dat hang");
                   System.out.println("(2) Them don hang");
                   System.out.println("(3) thanh toan");
                   System.out.println("(4) Tra cuu thong tin don hang");
                   System.out.println("(5) Thoat");
                   System.out.print("Nhap lua chon cua ban: ");
                   i = Integer.parseInt(sc.nextLine());
                   switch (i){
                       case 1 -> {
                           this.cls1();
                           if (quanLyChung.getQldh().size() == 0)
                               System.out.println("Khong co du lieu");
                           else quanLyChung.getQldh().hienThi();
                           this.cls2();
                       }
                       case 2 -> {
                           this.cls1();
                           quanLyChung.getQldh().themdsDat(quanLyChung.getQlb(), quanLyChung.getQlmh());
                           this.cls2();
                       }
                       case 3 -> {
                           this.cls1();
                           quanLyChung.getQldh().thanhToan();
                           this.cls2();
                       }
                       case 4 -> {
                           this.cls1();
                           quanLyChung.getQldh().timOrder();
                           this.cls2();
                       }
                       default -> {
                           System.out.println("Cam on da su dung chuong trinh");
                           this.cls2();
                       }
                   }////
               } while(i > 0 && i < 5);
            }
            case 5 -> {
                 do{
                     this.cls1();
                     System.out.println("=== QUAN LY DOANH THU ===");
                     System.out.println("(1) Hien thi doanh thu");
                     System.out.println("(2) Nhap doanh thu");
                     System.out.println("(3) Tong doanh thu");
                     System.out.println("(4) Thoat");
                     System.out.print("Nhap lua chon cua ban: ");
                     i = Integer.parseInt(sc.nextLine());
                     switch (i){
                        case 1 -> {
                            this.cls1();
                            quanLyChung.getDoanhThu().xuat();
                            this.cls2();
                        }
                        case 2 -> {
                            this.cls1();
                            quanLyChung.getDoanhThu().nhap();
                            this.cls2();
                        }
                        case 3 -> {
                            this.cls1();
                            quanLyChung.getDoanhThu().tongDoanhThu();
                            this.cls2();
                        }
                     }
                 }while(i > 0 && i < 4);
            }
//            case 4 ->{
//                System.out.println("=== QUAN LY DANH SACH DAT HANG ===");
//            }
//            case 5 -> {
//                System.out.println("=== QUAN LY DOANH THU ===");
//            }
             default ->{
                 System.out.println("Khong co du lieu");
             }
         }
     } while(ch > 0 && ch < 5);
    }
}
