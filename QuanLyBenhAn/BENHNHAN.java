package QuanLyBenhAn;

import QuanLyBenhAn.BENHNHAN;
import java.sql.Date;

public class BENHNHAN {
    String maBenhNhan;
    String hoTen;
    Date ngayNhapVien;
    String soDienThoai;
    String email;
    boolean phongTheoYeuCau;

    public BENHNHAN(String maBenhNhan, String hoTen, Date ngayNhapVien, String soDienThoai, String email, boolean phongTheoYeuCau) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
        this.ngayNhapVien = ngayNhapVien;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.phongTheoYeuCau = phongTheoYeuCau;
    }

    public int tinhSoNgayNhapVien(Date ngayRaVien) {
        long diff = ngayRaVien.getTime() - this.ngayNhapVien.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    public void nhap() {
        // Code to input patient details
    }

    public void xuat() {
        // Code to output patient details
    }
}
