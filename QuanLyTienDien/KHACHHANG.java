
    // KHACHHANG.java
package QuanLyTienDien;

import java.util.Date;

public abstract class KHACHHANG implements ITIENDIEN {
    protected String maKhachHang;
    protected String hoTen;
    protected Date ngayRaHoaDon;
    protected int soLuong;
    protected double donGia;

    public KHACHHANG(String maKhachHang, String hoTen, Date ngayRaHoaDon, int soLuong, double donGia) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}


