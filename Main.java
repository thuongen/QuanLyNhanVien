package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;
public class Main 
{
    public static Scanner Nhap = new Scanner(System.in);
    public static void main(String[] args) 
    {
        int chon;
        DanhSachNV danhSachNV = new DanhSachNV();
        while (true)
        {   
            System.out.println("Ban muon lam gi: ");
            System.out.println("1: Them moi thong tin nhan vien: ");
            System.out.println("2: Cap nhat thong tin nhan vien: ");
            System.out.println("3: Xem thong tin nhan vien: ");
            System.out.println("4: Xoa thong tin nhan vien: ");
            System.out.println("5: Sap xep theo luong nhan vien: ");
            System.out.println("6: Tim nhan vien theo ma: ");
            System.out.println("7: Thoat ra khoi menu");
            System.out.println("Moi lua chon: ");
            chon = Nhap.nextInt();
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
                    danhSachNV.TimNV();
                case 7:
                    return;
            }
            if (chon > 6 || chon < 0) {
                System.out.println("Khong hop le, vui long nhap lai. ");
            }
        }        
    }
}

