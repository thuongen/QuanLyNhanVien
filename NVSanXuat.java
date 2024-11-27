package QuanLyNhanVien;

import java.util.Date;
import java.util.Scanner;

public class NVSanXuat extends NhanVien
{
    public int soSP;
    public static int donGiaSP = 30000;
    public NVSanXuat(int maNV, String hoTen,  Date ngaySinh, String diaChi , int soSP)
    {
        super(maNV, hoTen, ngaySinh, diaChi);
        this.soSP = soSP;
    }
    public int getSoSP()
    {
        return soSP;
    }
    public void setSoSP()
    {
        if(soSP < 0)
            System.out.println("Khong hop le.");
        else 
            this.soSP = soSP;
    }
    public void Nhap()
    {
        super.Nhap();
        System.out.println("Nhap vao so luong san pham: ");
        soSP = super.Nhap.nextInt();
    }
    public void Xuat()
    {
        super.Xuat();
        System.out.println("Nhap vao so san pham nhan vien lam ra: " +soSP);
        System.out.println("Luong cua nhan vien san xuat la: " +soSP * donGiaSP + "VND");
        System.out.println("-----------------------------");
    }

}
