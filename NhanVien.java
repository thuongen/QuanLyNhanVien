package QuanLyNhanVien;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public abstract class NhanVien implements TinhLuong{
    Scanner Nhap = new Scanner(System.in);
    private String maNV;          
    public String hoTen;  
    private Date ngaySinh;
    private String diaChi;     
    // Constructor
    
    public NhanVien(String maNV, String hoTen, Date ngaySinh, String diaChi) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    // Nhập thông tin nhân viên
    public void Nhap() {
        //System.out.println("Nhap vao ma nhan vien: ");
        //this.maNV = Nhap.nextLine();
        //Nhap.nextLine(); 
        System.out.println("Nhap vao ten nhan vien: ");
        this.hoTen = Nhap.nextLine();
        
         this.ngaySinh = null;
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        boolean valid = false;

        while (!valid) {
            System.out.println("Nhap ngay sinh cua nhan vien: ");
            try {
                ngaySinh = d.parse(Nhap.nextLine());
                valid = true; // Nếu không có lỗi, thoát khỏi vòng lặp
            } catch (Exception ex) {
                System.out.println("Ngay sinh khong hop le, vui long kiem tra lai.");
            }
        }

        



        System.out.println("Nhap vao dia chi nhan vien");
        this.diaChi = Nhap.nextLine();
        

    }

    // Xuất thông tin nhân viên
    public void Xuat() {
        System.out.println("Ma NV    : " + maNV);
        System.out.println("Ho ten   : " + hoTen);
        System.out.println("Ngay sinh: " + this.ngaySinh.toString());
        System.out.println("Dia Chi   : " + diaChi);
    }

    // Getters and Setters
    public String getMaNV(){
        return maNV;
    }
    public void setMaNV(String maNV){
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

    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }  
    
}
