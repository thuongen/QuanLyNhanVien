// DSKHACHHANG.java
package QuanLyTienDien;

import java.util.*;
import java.io.*;
import java.text.*;

public class DSKHACHHANG {
    private List<KHACHHANG> danhSachKhachHang = new ArrayList<>();

    public void themKhachHang(KHACHHANG kh) {
        danhSachKhachHang.add(kh);
    }

    public void docDuLieuTuFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");

                // Kiểm tra nếu dữ liệu không đủ để tránh lỗi
                if (data.length < 6) continue;

                int loaiKhach = Integer.parseInt(data[0]);  // 1 - Việt Nam, 2 - Nước ngoài
                String maKH = data[1];
                String hoTen = data[2];
                Date ngayHD = dateFormat.parse(data[3]);
                String soDienThoai = data[4].equals("None") ? null : data[4];
                String email = data[5].equals("None") ? null : data[5];
                String doiTuongKhachHang = (data.length > 6 && !data[6].equals("None")) ? data[6] : null;
                int soLuong = Integer.parseInt(data[7]);
                double donGia = Double.parseDouble(data[8]);
                Integer dinhMuc = (data.length > 9 && !data[9].equals("None")) ? Integer.parseInt(data[9]) : null;
                String quocTich = (data.length > 10 && !data[10].equals("None")) ? data[10] : null;

                // Tạo đối tượng khách hàng dựa trên loại khách hàng
                if (loaiKhach == 1) { // Khách hàng Việt Nam
                    if (dinhMuc != null && doiTuongKhachHang != null) {
                        KHACHHANG khachVN = new KHACHHANGVIETNAM(maKH, hoTen, ngayHD, soLuong, donGia, doiTuongKhachHang, dinhMuc);
                        themKhachHang(khachVN);
                    }
                } else if (loaiKhach == 2) { // Khách hàng nước ngoài
                    if (quocTich != null) {
                        KHACHHANG khachNN = new KHACHHANGNUOCNGOAI(maKH, hoTen, ngayHD, soLuong, donGia, quocTich);
                        themKhachHang(khachNN);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thongKeKhachHang() {
        int vietNam = 0, nuocNgoai = 0;
        for (KHACHHANG kh : danhSachKhachHang) {
            if (kh instanceof KHACHHANGVIETNAM) {
                vietNam++;
            } else if (kh instanceof KHACHHANGNUOCNGOAI) {
                nuocNgoai++;
            }
        }
        System.out.println("Số khách hàng Việt Nam: " + vietNam);
        System.out.println("Số khách hàng nước ngoài: " + nuocNgoai);
    }
}
