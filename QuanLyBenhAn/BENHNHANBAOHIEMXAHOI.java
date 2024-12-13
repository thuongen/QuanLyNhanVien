package QuanLyBenhAn;

import java.sql.Date;

public class BENHNHANBAOHIEMXAHOI extends BENHNHAN implements VIENPHI {
    String maBaoHiemXaHoi;

    public BENHNHANBAOHIEMXAHOI(String maBenhNhan, String hoTen, Date ngayNhapVien, String soDienThoai, String email, boolean phongTheoYeuCau, String maBaoHiemXaHoi) {
        super(maBenhNhan, hoTen, ngayNhapVien, soDienThoai, email, phongTheoYeuCau);
        this.maBaoHiemXaHoi = maBaoHiemXaHoi;
    }

    @Override
    public double Tinhhoadonvienphi() {
        // Giả sử phương thức tinhSoNgayNhapVien nhận vào một đối tượng Date và trả về số ngày
        int soNgay = tinhSoNgayNhapVien(new Date(System.currentTimeMillis()));
        double tienPhong = soNgay * DON_GIA_PHONG;
        if (phongTheoYeuCau) {
            return tienPhong + 200000;
        } else {
            return tienPhong;
        }
    }

    @Override
    public void nhap() {
        super.nhap();
        // Code to input insurance details
    }

    @Override
    public void xuat() {
        super.xuat();
        // Code to output insurance details
    }
}
