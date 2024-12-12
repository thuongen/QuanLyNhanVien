package QuanLyNhanVien;

import java.util.Date;
import java.util.Scanner;

public class NVSanXuat extends NhanVien implements Interface
{
    public int soSP, donGiaSP;
    public double luong;
    public NVSanXuat(String maNV, String hoTen,  Date ngaySinh, String diaChi,int soSP, int donGiaSP)
    {
        super(maNV, hoTen, ngaySinh, diaChi);
        this.soSP = soSP;
        this.donGiaSP = donGiaSP;
    }
    public int getSoSP( int soSP)
    {
        if (soSP < 0)
            System.out.println("Khong hop le.");
        else
            this.soSP = soSP;
        return soSP;
    }
    public int getDonGiaSP()
    {
        return donGiaSP;
    }                 
    @Override
    public double tinhLuong() 
    {
        return soSP * donGiaSP;
    }
    public void Nhap()
    {
        super.Nhap();
        setMaNV(getMaNVSX());
        System.out.println("Nhap vao so luong san pham: ");
        soSP = super.Nhap.nextInt();
        System.out.println("Nhap vao don gia san pham: ");
        donGiaSP = super.Nhap.nextInt();
    }
    public void Xuat()
    {
        super.Xuat();
        System.out.println("Nhap vao so san pham nhan vien lam ra: " +soSP);
        System.out.println("Luong cua nhan vien san xuat la: " + tinhLuong() + "VND");
        System.out.println("-----------------------------");
    } 
    
    private String getMaNVSX() {
        if (DSNhanVienSX.size() == 0)
            return "SX001";
        int max = Integer.parseInt(DSNhanVienSX.get(0).getMaNV().substring(2)); 
    
        
        for (int i = 1; i < DSNhanVienSX.size(); i++) { 
            int maNV = Integer.parseInt(DSNhanVienSX.get(i).getMaNV().substring(2));
            if (max < maNV)
                max = maNV;
        }
        return String.format("SX%03d", max + 1);
    }
}