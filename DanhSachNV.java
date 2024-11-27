package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNV 
{
    int chon, n , i, maCapNhat;
    public static Scanner Nhap = new Scanner(System.in);
    ArrayList<NVSanXuat> DSNhanVienSX = new ArrayList<>();
    ArrayList<NVQuanLy>DSNhanVienQL = new ArrayList<>();
    // Chức năng thêm mới
    public void ThemMoi()
    {
        while (true) 
        {    
            do{
                System.out.println("Ban muon them moi thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("3. Quay lai menu chinh:");
                System.out.println("Moi lua chon: ");
                chon = Integer.parseInt(Nhap.nextLine());
                switch (chon) 
                {
                    case 1:
                        System.out.println("Nhap vao so luong nhan vien cap nhat: ");
                        n = Nhap.nextInt();
                        Nhap.nextLine();
                        for (i = 1; i <= n; i++) 
                        {
                            System.out.printf("\nNhap vao thong tin nhan vien thu %d:\n", i);
                            NVQuanLy NVienQL = new NVQuanLy();
                            NVienQL.Nhap();
                            DSNhanVienQL.add(NVienQL);
                        }
                        break;
                    case 2:
                        System.out.println("Nhap vao so luong nhan vien cap nhat: ");
                        n = Nhap.nextInt();
                        Nhap.nextLine();
                        for (i = 1; i <= n; i++) 
                        {
                            System.out.printf("\nNhap vao thong tin nhan vien thu %d:\n", i);
                            NVSanXuat NVienSX = new NVSanXuat(n, null, null, null, chon);
                            NVienSX.Nhap();
                            DSNhanVienSX.add(NVienSX);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai. ");
                }
            }
            while(chon<0||chon>2);
        }
    }
    // Chức năng cập nhật 
    public void CapNhat()
    {
        while (true) 
        {    
            do {
                System.out.println("Ban muon cap nhat thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                switch (chon) 
                {
                    case 1://///////////tạm dừng
                    case 2:
                        System.out.println("Nhap vao ma nhan vien ban muon cap nhat: ");
                        maCapNhat = Nhap.nextInt();
                        //for(i=1; i<=DSNhanVienSX.size(); i++)
                        //{
                        //    if(DSNhanVienSX.get(i).getMaNV().equals(maCapNhat))
                        //}
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai. ");
                }
                } while (chon<0||chon>2);
        }
    }
    //Phương thức chọn nhan vien san xuat hay nhan vien quan li
    public void Xem()
    {
        while (true) 
        {    
            System.out.println("Ban muon xem thong tin cua nhan vien quan li hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("0. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                case 2:
                    System.out.println("\nThong tin tat ca nhan vien:");
                    for (i = 0; i < DSNhanVienSX.size(); i++) 
                    {
                        System.out.printf("\nThong tin cua nhan vien thu %d:\n", i + 1);
                        DSNhanVienSX.get(i).Xuat();
                    }
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
    public void Xoa()
    {
        while (true) 
        {    
            System.out.println("Ban muon xoa thong tin cua nhan vien quan li hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("3. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                case 2:
                    
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    public void SapXep()
    {
        while (true) 
        {    
            System.out.println("Ban muon sap xep luong cua nhan vien quan li hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("3. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                case 2:
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}
