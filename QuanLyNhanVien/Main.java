package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Scanner Nhap = new Scanner(System.in);
    public static void main(String[] args) 
    {
        int chon;
        DanhSachNV danhSachNV = new DanhSachNV();
        while (true)
        {   
            do{
                System.out.println("Ban muon lam gi: ");
                System.out.println("1: Them moi thong tin nhan vien: ");
                System.out.println("1: Cap nhat thong tin nhan vien: ");
                System.out.println("2: Xem thong tin nhan vien: ");
                System.out.println("3: Xoa thong tin nhan vien: ");
                System.out.println("5: Sap xep theo luong nhan vien: ");
                System.out.println("6: Tim nhan vien theo ma: ");
                System.out.println("0: Thoat ra khoi menu");
                System.out.println("Moi lua chon: ");
                chon = Integer.parseInt(Nhap.nextLine());
                switch (chon) 
                {
                    case 1:
                        danhSachNV.ThemMoi();
                        break;
                    case 2: 
                        danhSachNV.CapNhat();
                        break;
                    case 3:
                        danhSachNV.Xem();
                        break;
                    case 4: 
                        danhSachNV.Xoa();
                        break;
                    case 5:
                        danhSachNV.SapXep();            
                        break;
                    case 6:
                    
                    case 0:
                        return;
                    default:
                        System.out.println("Khong hop le, vui long nhap lai. ");
                }
            }
            while(chon > 6 || chon < 0);
        }        
    }
}

