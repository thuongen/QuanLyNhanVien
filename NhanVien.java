package QuanLyNhanVien;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public abstract class NhanVien {
    Scanner Nhap = new Scanner(System.in);
    private String maNV;          
    public String hoTen;  
    private Date ngaySinh;     
    // Constructor
    public NhanVien(String maNV, String hoTen, Date ngaySinh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }
    // Nhập thông tin nhân viên
    public void Nhap() {
        System.out.println("Nhap vao ma nhan vien: ");
        maNV = Nhap.nextLine();
        Nhap.nextLine();
        System.out.println("Nhap vao ten nhan vien: ");
        hoTen = Nhap.nextLine();
        System.out.println("Nhap ngay sinh cua nhan vien: ");
        try {
            SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            ngaySinh = d.parse(Nhap.nextLine());
        } catch (Exception ex) {
            System.out.println("Ngay sinh khong hop le, vui long kiem tra lai.");
        }
    }

    // Xuất thông tin nhân viên
    public void Xuat() {
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ma NV    : " + maNV);
        System.out.println("Ho ten   : " + hoTen);
        System.out.println("Ngay sinh: " + d.format(ngaySinh));
    }

    // Getters and Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
