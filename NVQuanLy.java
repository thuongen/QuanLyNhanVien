
package QuanLyNhanVien ;

import java.security.PublicKey;
import java.sql.Date;


public class NVQuanLy extends NhanVien implements Interface
{

    private double luongCoBan;
    private double heSoLuong;
    
    public NVQuanLy(String maNV, String hoTen, Date ngaySinh, double luongCoBan , double heSoLuong){
        super( maNV, hoTen, ngaySinh);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }
    //NHẬP
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap vao luong co ban");
        this.luongCoBan = Nhap.nextDouble();
        System.out.println("Nhap vao he so luong");
        this.heSoLuong = Nhap.nextDouble();
    }
    // Xuất
    public void Xuat(){
        super.Xuat();
        System.out.println("He so luong: " + heSoLuong);
        System.out.println("luong co ban: "+ luongCoBan);
        System.out.println("Tien luong nv quan ly: " + tinhLuong());
        
    }
    //set_get
    public double getLuongCoBan(){
        return luongCoBan;
    }
    public void setLuongCoBan( double luongCoBan){
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuong(){
        return heSoLuong;
    }
    public void setHeSoLuong(double heSoLuong){
        this.heSoLuong = heSoLuong;
    }
    //tính lương
    @Override 
    public double tinhLuong(){
        return luongCoBan*heSoLuong;
    }
}
