package QuanLyBenhAn;

import java.sql.Date;
import java.util.Scanner;
import QuanLyBenhAn.DANHSACHBENHNHAN;
import QuanLyBenhAn.BENHNHANBAOHIEMYTE;
import QuanLyBenhAn.BENHNHAN;

public class BAIKIEMTRA {
    public static void main(String[] args) {
        DANHSACHBENHNHAN dsbn = new DANHSACHBENHNHAN();
        FileReader.docFile("BENHNHAN.txt", dsbn);

        Scanner scanner = new Scanner(System.in);
        int chon;

        do {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm mới bệnh nhân");
            System.out.println("2. Xóa bệnh nhân theo mã");
            System.out.println("3. Tìm kiếm bệnh nhân theo mã");
            System.out.println("4. Tính tổng tiền viện phí");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            chon = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (chon) {
                case 1:
                    // Thêm mới bệnh nhân do người dùng nhập vào
                    System.out.print("Nhập mã bệnh nhân: ");
                    String maBenhNhan = scanner.nextLine();
                    System.out.print("Nhập họ tên bệnh nhân: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập ngày nhập viện (yyyy-mm-dd): ");
                    String ngayNhapVienStr = scanner.nextLine();
                    Date ngayNhapVien = Date.valueOf(ngayNhapVienStr);
                    System.out.print("Nhập số điện thoại: ");
                    String soDienThoai = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phòng theo yêu cầu (true/false): ");
                    boolean phongTheoYeuCau = Boolean.parseBoolean(scanner.nextLine());
                    System.out.print("Nhập mã bảo hiểm y tế: ");
                    String maBaoHiemYTe = scanner.nextLine();

                    dsbn.themBenhNhan(new BENHNHANBAOHIEMYTE(maBenhNhan, hoTen, ngayNhapVien, soDienThoai, email, phongTheoYeuCau, maBaoHiemYTe));
                    System.out.println("Đã thêm bệnh nhân mới.");
                    break;

                case 2:
                    // Xóa bệnh nhân theo mã do người dùng nhập vào
                    System.out.print("Nhập mã bệnh nhân cần xóa: ");
                    String maBenhNhanXoa = scanner.nextLine();
                    dsbn.xoaBenhNhan(maBenhNhanXoa);
                    System.out.println("Đã xóa bệnh nhân.");
                    break;

                case 3:
                    // Tìm kiếm bệnh nhân theo mã do người dùng nhập vào
                    System.out.print("Nhập mã bệnh nhân cần tìm: ");
                    String maBenhNhanTim = scanner.nextLine();
                    
                    BENHNHAN bn = dsbn.timKiemBenhNhan(maBenhNhanTim);
                    if (bn != null) {
                        bn.xuat();
                    } else {
                        System.out.println("Không tìm thấy bệnh nhân");
                    }
                    break;

                case 4:
                    // Tính tổng tiền viện phí
                    double tongTien = dsbn.tinhTongTienVienPhi();
                    System.out.println("Tổng tiền viện phí: " + tongTien);
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (chon != 5);

        scanner.close();
    }
}
