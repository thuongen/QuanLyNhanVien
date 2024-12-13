// KHACHHANGVIETNAM.java
package QuanLyTienDien;

import java.util.Date;

public class KHACHHANGVIETNAM extends KHACHHANG {
    private String doiTuongKhachHang;
    private int dinhMuc;

    public KHACHHANGVIETNAM(String maKhachHang, String hoTen, Date ngayRaHoaDon, int soLuong, double donGia, String doiTuongKhachHang, int dinhMuc) {
        super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
        this.doiTuongKhachHang = doiTuongKhachHang;
        this.dinhMuc = dinhMuc;
    }

    @Override
    public double TinhThanhTien() {
        if (soLuong <= dinhMuc) {
            return soLuong * donGia;
        } else {
            return dinhMuc * donGia + (soLuong - dinhMuc) * donGia * 2.5;
        }
    }
}
