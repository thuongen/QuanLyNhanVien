// KHACHHANGNUOCNGOAI.java
package QuanLyTienDien;

import java.util.Date;

public class KHACHHANGNUOCNGOAI extends KHACHHANG {
    private String quocTich;

    public KHACHHANGNUOCNGOAI(String maKhachHang, String hoTen, Date ngayRaHoaDon, int soLuong, double donGia, String quocTich) {
        super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
        this.quocTich = quocTich;
    }

    @Override
    public double TinhThanhTien() {
        return soLuong * donGia;
    }
}
