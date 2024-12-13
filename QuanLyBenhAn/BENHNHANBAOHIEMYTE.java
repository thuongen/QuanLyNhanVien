package QuanLyBenhAn;


import java.sql.Date;

public class BENHNHANBAOHIEMYTE extends BENHNHAN implements VIENPHI {
    String maBaoHiemYTe;

    public BENHNHANBAOHIEMYTE(String maBenhNhan, String hoTen, Date ngayNhapVien, String soDienThoai, String email, boolean phongTheoYeuCau, String maBaoHiemYTe) {
        super(maBenhNhan, hoTen, ngayNhapVien, soDienThoai, email, phongTheoYeuCau);
        this.maBaoHiemYTe = maBaoHiemYTe;
    }

    @Override
    public double Tinhhoadonvienphi() {
        int soNgay = tinhSoNgayNhapVien(new Date(0));
        double tienPhong = soNgay * DON_GIA_PHONG;
        if (phongTheoYeuCau) {
            return (tienPhong * 200000) - (tienPhong * 0.7);
        } else {
            return tienPhong - (tienPhong * 0.7);
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
