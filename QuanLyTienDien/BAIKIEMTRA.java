// BAIKIEMTRA.java
package QuanLyTienDien;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class BAIKIEMTRA {
    public static void main(String[] args) {
        DSKHACHHANG danhSach = new DSKHACHHANG();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        boolean running = true;
        
        while (running) {
            System.out.println("\n===== QUẢN LÝ KHÁCH HÀNG TIỀN ĐIỆN =====");
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Xóa khách hàng theo mã");
            System.out.println("3. Cập nhật thông tin khách hàng theo mã");
            System.out.println("4. Tìm kiếm khách hàng theo mã");
            System.out.println("5. Thống kê khách hàng theo loại");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua dòng trống sau khi nhập số

            switch (choice) {
                case 1: // Thêm mới khách hàng
                    System.out.print("Nhập loại khách hàng (1: Việt Nam, 2: Nước ngoài): ");
                    int loaiKhach = scanner.nextInt();
                    scanner.nextLine(); // Bỏ qua dòng trống

                    System.out.print("Nhập mã khách hàng: ");
                    String maKH = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập ngày ra hóa đơn (dd/MM/yyyy): ");
                    Date ngayHD = null;
                    try {
                        ngayHD = dateFormat.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ngày không hợp lệ!");
                        continue;
                    }

                    System.out.print("Nhập số lượng KW tiêu thụ: ");
                    int soLuong = scanner.nextInt();
                    System.out.print("Nhập đơn giá: ");
                    double donGia = scanner.nextDouble();
                    scanner.nextLine(); // Bỏ qua dòng trống

                    if (loaiKhach == 1) { // Khách hàng Việt Nam
                        System.out.print("Nhập đối tượng khách hàng (sinh hoạt, kinh doanh, sản xuất): ");
                        String doiTuongKhachHang = scanner.nextLine();
                        System.out.print("Nhập định mức: ");
                        int dinhMuc = scanner.nextInt();
                        scanner.nextLine(); // Bỏ qua dòng trống

                        KHACHHANG khachVN = new KHACHHANGVIETNAM(maKH, hoTen, ngayHD, soLuong, donGia, doiTuongKhachHang, dinhMuc);
                        danhSach.themKhachHang(khachVN);
                        System.out.println("Đã thêm khách hàng Việt Nam.");

                    } else if (loaiKhach == 2) { // Khách hàng nước ngoài
                        System.out.print("Nhập quốc tịch: ");
                        String quocTich = scanner.nextLine();

                        KHACHHANG khachNN = new KHACHHANGNUOCNGOAI(maKH, hoTen, ngayHD, soLuong, donGia, quocTich);
                        danhSach.themKhachHang(khachNN);
                        System.out.println("Đã thêm khách hàng nước ngoài.");
                    }
                    break;

                case 2: // Xóa khách hàng theo mã
                    System.out.print("Nhập mã khách hàng cần xóa: ");
                    String maXoa = scanner.nextLine();
                    danhSach.xoaKhachHang(maXoa);
                    System.out.println("Đã xóa khách hàng có mã: " + maXoa);
                    break;

                case 3: // Cập nhật thông tin khách hàng theo mã
                    System.out.print("Nhập mã khách hàng cần cập nhật: ");
                    String maCapNhat = scanner.nextLine();
                    KHACHHANG khachCanCapNhat = danhSach.timKiemKhachHang(maCapNhat);
                    if (khachCanCapNhat != null) {
                        System.out.println("Nhập thông tin mới cho khách hàng:");
                        // Tạo đối tượng mới với thông tin cập nhật
                        System.out.print("Nhập họ tên: ");
                        String tenMoi = scanner.nextLine();
                        System.out.print("Nhập ngày ra hóa đơn (dd/MM/yyyy): ");
                        Date ngayMoi = null;
                        try {
                            ngayMoi = dateFormat.parse(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Ngày không hợp lệ!");
                            continue;
                        }
                        System.out.print("Nhập số lượng KW tiêu thụ: ");
                        int soLuongMoi = scanner.nextInt();
                        System.out.print("Nhập đơn giá: ");
                        double donGiaMoi = scanner.nextDouble();
                        scanner.nextLine();

                        if (khachCanCapNhat instanceof KHACHHANGVIETNAM) {
                            System.out.print("Nhập đối tượng khách hàng (sinh hoạt, kinh doanh, sản xuất): ");
                            String doiTuongMoi = scanner.nextLine();
                            System.out.print("Nhập định mức: ");
                            int dinhMucMoi = scanner.nextInt();
                            scanner.nextLine();

                            KHACHHANG khachVN = new KHACHHANGVIETNAM(maCapNhat, tenMoi, ngayMoi, soLuongMoi, donGiaMoi, doiTuongMoi, dinhMucMoi);
                            danhSach.capNhatKhachHang(maCapNhat, khachVN);

                        } else if (khachCanCapNhat instanceof KHACHHANGNUOCNGOAI) {
                            System.out.print("Nhập quốc tịch: ");
                            String quocTichMoi = scanner.nextLine();

                            KHACHHANG khachNN = new KHACHHANGNUOCNGOAI(maCapNhat, tenMoi, ngayMoi, soLuongMoi, donGiaMoi, quocTichMoi);
                            danhSach.capNhatKhachHang(maCapNhat, khachNN);
                        }
                        System.out.println("Đã cập nhật khách hàng có mã: " + maCapNhat);
                    } else {
                        System.out.println("Không tìm thấy khách hàng có mã: " + maCapNhat);
                    }
                    break;

                case 4: // Tìm kiếm khách hàng theo mã
                    System.out.print("Nhập mã khách hàng cần tìm: ");
                    String maTimKiem = scanner.nextLine();
                    KHACHHANG khachTimThay = danhSach.timKiemKhachHang(maTimKiem);
                    if (khachTimThay != null) {
                        System.out.println("Khách hàng tìm thấy: " + khachTimThay.hoTen);
                    } else {
                        System.out.println("Không tìm thấy khách hàng có mã: " + maTimKiem);
                    }
                    break;

                case 5: // Thống kê khách hàng theo loại
                    danhSach.thongKeKhachHang();
                    break;

                case 0: // Thoát chương trình
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
        
        scanner.close();
    }
}
