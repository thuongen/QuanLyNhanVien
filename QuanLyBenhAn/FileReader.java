package QuanLyBenhAn;

import java.io.BufferedReader;
import java.sql.Date;
import java.text.SimpleDateFormat;

class FileReader {
    public static void docFile(String fileName, DANHSACHBENHNHAN dsbn) {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                String loaiBenhNhan = data[0];
                String maBenhNhan = data[1];
                String hoTen = data[2];
                Date ngayNhapVien = new Date(sdf.parse(data[3]).getTime());
                String soDienThoai = data[4];
                String email = data[5];
                boolean phongTheoYeuCau = Boolean.parseBoolean(data[6]);
                String maBaoHiemXaHoi = data[7].equals("None") ? null : data[7];
                String maBaoHiemYTe = data[8].equals("None") ? null : data[8];

                if (loaiBenhNhan.equals("1")) {
                    dsbn.themBenhNhan(new BENHNHANBAOHIEMXAHOI(maBenhNhan, hoTen, ngayNhapVien, soDienThoai, email, phongTheoYeuCau, maBaoHiemXaHoi));
                } else if (loaiBenhNhan.equals("2")) {
                    dsbn.themBenhNhan(new BENHNHANBAOHIEMYTE(maBenhNhan, hoTen, ngayNhapVien, soDienThoai, email, phongTheoYeuCau, maBaoHiemYTe));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
