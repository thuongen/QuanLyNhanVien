package QuanLyBenhAn;

import java.util.ArrayList;
import java.util.List;

public class DANHSACHBENHNHAN {
    List<BENHNHAN> danhSachBenhNhan = new ArrayList<>();

    public void themBenhNhan(BENHNHAN bn) {
        danhSachBenhNhan.add(bn);
    }

    public void xoaBenhNhan(String maBenhNhan) {
        danhSachBenhNhan.removeIf(bn -> bn.maBenhNhan.equals(maBenhNhan));
    }

    public BENHNHAN timKiemBenhNhan(String maBenhNhan) {
        for (BENHNHAN bn : danhSachBenhNhan) {
            if (bn.maBenhNhan.equals(maBenhNhan)) {
                return bn;
            }
        }
        return null;
    }

    public double tinhTongTienVienPhi() {
        double tongTien = 0;
        for (BENHNHAN bn : danhSachBenhNhan) {
            if (bn instanceof VIENPHI) {
                tongTien += ((VIENPHI) bn).Tinhhoadonvienphi();
            }
        }
        return tongTien;
    }

    public void xuat() {
        for (BENHNHAN bn : danhSachBenhNhan) {
            bn.xuat();
        }
    }
}
