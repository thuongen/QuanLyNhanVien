package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachNV  
{
    int chon, n , i, maCapNhat;
    public static Scanner Nhap = new Scanner(System.in);
    ArrayList<NhanVien> DSNhanVienSX = new ArrayList<>();
    ArrayList<NhanVien> DSNhanVienQL = new ArrayList<>();
   
    

    // Chức năng thêm mới
    public void ThemMoi()
    {
        while (true) 
        {    
            do{
                System.out.println("Ban muon them moi thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                System.out.println("Moi lua chon: ");
                chon = Integer.parseInt(Nhap.nextLine());
                switch (chon) 
                {
                    case 1:
                        System.out.println("Nhap vao so luong nhan vien cap nhat: ");
                        n = Nhap.nextInt();
                        Nhap.nextLine();
                        for (i = 1; i <= n; i++) 
                        {
                            System.out.printf("\nNhap vao thong tin nhan vien thu %d:\n", i);
                            NVQuanLy NVienQL = new NVQuanLy(getMaNVQL(), getMaNVQL(), null, getMaNVQL(), n, n);
                            NVienQL.Nhap();
                            NVienQL.setMaNV(getMaNVQL());// gọi phương thức tự động tăng id
                            DSNhanVienQL.add(NVienQL);

                        }
                        System.out.println("Them moi thanh cong");
                        break;
                    case 2:
                        System.out.println("Nhap vao so luong nhan vien cap nhat: ");
                        n = Nhap.nextInt();
                        Nhap.nextLine();
                        for (i = 1; i <= n; i++) 
                        {
                            System.out.printf("\nNhap vao thong tin nhan vien thu %d:\n", i);
                            NVSanXuat NVienSX = new NVSanXuat(getMaNVQL(), getMaNVQL(), null, getMaNVQL(), chon, i);
                            NVienSX.Nhap();
                            NVienSX.setMaNV(getMaNVSX());
                            DSNhanVienSX.add(NVienSX);
                        }
                        System.out.println("-----------Them moi thanh cong-------------");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai. ");
                        break;
                }
            }
            while(chon<0||chon>2);
        }
    }
    // Chức năng cập nhật 
    public void CapNhat()
    {
        System.out.println("Nhap vao ma nhan vien muon cap nhat: ");
        String maNV = Nhap.nextLine();
        Nhap.nextLine();  

        if(maNV.startsWith("QL")){
            boolean isExistNhanVien = false;// nếu đi hết vòng for mà ko tìm thấy manv đó
            for(int i=0;i< DSNhanVienQL.size();i++)
                if(DSNhanVienQL.get(i).getMaNV().equals(maNV)){
                    isExistNhanVien = true;
                    DSNhanVienQL.get(i).Nhap();
                    System.out.println("Cap nhat thanh cong");
                    break;
                }
            if(!isExistNhanVien)
                System.out.println("Khong tim thay ma nv");
            
            
        }
        else 
            if(maNV.startsWith("SX")){
                boolean isExistNhanVien = false;// nếu đi hết vòng for mà ko tìm thấy manv đó
                for(int i=0;i< DSNhanVienSX.size();i++)
                    if(DSNhanVienSX.get(i).getMaNV().equals(maNV)){
                        isExistNhanVien = true;
                        DSNhanVienSX.get(i).Nhap();
                        System.out.println("Cap nhat thanh cong");
                        break;
                    }
                if(!isExistNhanVien)
                    System.out.println("Khong tim thay ma nv");
            }
            else 
                System.out.println("Ma nhap ko hop le");

    }
    //Phương thức chọn nhan vien san xuat hay nhan vien quan li
    public void Xem()
    {
        while (true) 
        {    
            do {
                System.out.println("Ban muon xem thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                switch (chon) 
                {
                    case 1:
                        System.out.println("\nThong tin tat ca nhan vien quan ly:");
                        for (i = 0; i < DSNhanVienQL.size(); i++) 
                        {
                            System.out.printf("\nThong tin cua nhan vien thu %d:\n", i +1);
                            DSNhanVienQL.get(i).Xuat();
                        }
                    case 2:
                        System.out.println("\nThong tin tat ca nhan vien san xuat:");
                        for (i = 0; i < DSNhanVienSX.size(); i++) 
                        {
                            System.out.printf("\nThong tin cua nhan vien thu %d:\n", i + 1);
                            DSNhanVienSX.get(i).Xuat();
                        }
                    case 0:
                        return;
                    default:
                    System.out.println("Lua chon khong hop le vui long thu lai. ");
                    
                }
            } while (chon<0||chon>2);
        }
    }
    public void Xoa() {
        while (true) {    
            do {
                System.out.println("Ban muon xoa thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                Nhap.nextLine(); // Đọc ký tự xuống dòng còn lại
                String maXoa;
                switch (chon) {
                    case 1:
                        if (DSNhanVienQL.isEmpty()) {
                            System.out.println("Danh sach nhan vien quan ly dang trong.");
                            break;
                        }
                        System.out.println("Nhap vao ma nhan vien quan ly ma ban muon xoa: ");
                        maXoa = Nhap.nextLine().trim(); // Loại bỏ khoảng trắng thừa
                        boolean foundQL = false;
                        for (int i = 0; i < DSNhanVienQL.size(); i++) {
                            System.out.println("Kiem tra ma: " + DSNhanVienQL.get(i).getMaNV()); // In mã nhân viên để kiểm tra
                            if (DSNhanVienQL.get(i).getMaNV().equalsIgnoreCase(maXoa)) {
                                DSNhanVienQL.remove(i);
                                System.out.println("Nhan vien quan ly voi ma " + maXoa + " da duoc xoa.");
                                foundQL = true;
                                break;
                            }
                        }
                        if (!foundQL) {
                            System.out.println("Khong tim thay nhan vien quan ly co ma: " + maXoa);
                        }
                        break;
                    case 2:
                        if (DSNhanVienSX.isEmpty()) {
                            System.out.println("Danh sach nhan vien san xuat dang trong.");
                            break;
                        }
                        System.out.println("Nhap vao ma nhan vien san xuat ma ban muon xoa: ");
                        maXoa = Nhap.nextLine().trim(); // Loại bỏ khoảng trắng thừa
                        boolean foundSX = false;
                        for (int i = 0; i < DSNhanVienSX.size(); i++) {
                            System.out.println("Kiem tra ma: " + DSNhanVienSX.get(i).getMaNV()); // In mã nhân viên để kiểm tra
                            if (DSNhanVienSX.get(i).getMaNV().equalsIgnoreCase(maXoa)) {
                                DSNhanVienSX.remove(i);
                                System.out.println("Nhan vien san xuat voi ma " + maXoa + " da duoc xoa.");
                                foundSX = true;
                                break;
                            }
                        }
                        if (!foundSX) {
                            System.out.println("Khong tim thay nhan vien san xuat co ma: " + maXoa);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai.");
                }
            } while (chon < 0 || chon > 2);
        }
    }
    /* 
    public void SapXep()
    {
        while (true) 
            do {
                System.out.println("Ban muon sap xep luong cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                switch (chon) 
                {
                    case 1:
                        if (DSNhanVienQL.isEmpty()) {
                            System.out.println("Danh sach nhan vien san xuat dang trong.");
                            break;
                        }
                        
                        DSNhanVienQL.sort((nv1, nv2) -> Double.compare(nv1.tinhLuong(), nv2.tinhLuong()));
                        System.out.println("Danh sach nhan vien quan ly da duoc sap xep theo luong.");
                        break;
                    case 2:
                        if (DSNhanVienSX.isEmpty()) {
                            System.out.println("Danh sach nhan vien san xuat dang trong.");
                            break;
                        }
                        // Sắp xếp danh sách nhân viên sản xuất theo lương
                        DSNhanVienSX.sort((nv1, nv2) -> Double.compare(nv1.tinhLuong(), nv2.tinhLuong()));
                        System.out.println("Danh sach nhan vien san xuat da duoc sap xep theo luong.");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai. "); 
                }
                
            } while (chon < 0 || chon > 2); 
    }
            */



    public  void SapXep() {
        while (true) {
            do {
                System.out.println("Ban muon sap xep luong cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                Nhap.nextLine(); // Đọc ký tự xuống dòng còn lại
                switch (chon) {
                    case 1:
                        if (DSNhanVienQL.isEmpty()) {
                            System.out.println("Danh sach nhan vien quan ly dang trong.");
                            break;
                        }
                        sapXepVaInDanhSach(DSNhanVienQL);
                        break;
                    case 2:
                        if (DSNhanVienSX.isEmpty()) {
                            System.out.println("Danh sach nhan vien san xuat dang trong.");
                            break;
                        }
                        sapXepVaInDanhSach(DSNhanVienSX);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai.");
                }
            } while (chon < 0 || chon > 2);
        }
    }

    public void sapXepVaInDanhSach(List<NhanVien> danhSach) {
        // Scanner Nhap = new Scanner(System.in);
        
        System.out.println("Ban muon sap xep theo thu tu nao?");
        System.out.println("1. Tang dan");
        System.out.println("2. Giam dan");
        int luaChon = Nhap.nextInt();
        Nhap.nextLine(); // Đọc ký tự xuống dòng còn lại

        // Sắp xếp danh sách dựa theo lựa chọn
        if (luaChon == 1) {
            danhSach.sort((nv1, nv2) -> Double.compare(nv1.tinhLuong(), nv2.tinhLuong()));
        } else if (luaChon == 2) {
            danhSach.sort((nv1, nv2) -> Double.compare(nv2.tinhLuong(), nv1.tinhLuong()));
        } else {
            System.out.println("Lua chon khong hop le, vui long thu lai.");
            return;
        }

        // In thông tin các nhân viên đã sắp xếp
        System.out.println("\nThong tin tat ca nhan vien sau khi sap xep:");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.printf("\nThong tin cua nhan vien thu %d:\n", i + 1);
            danhSach.get(i).Xuat();
        }
    }
    


    //chức năng tìm 
    public void TimNV()
    {
       
        while (true) 
        {    
            do {
                String maTim;
                System.out.println("Ban muon sap xep luong cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                switch (chon) 
                {
                    case 1:
                        System.out.println("Nhap vao ma nhan vien quan ly ma ban muon tim trong danh sach: ");
                        maTim = Nhap.nextLine().trim(); 
                        Nhap.nextLine();
                        boolean foundQL = false; 
                        
                        for (i = 0; i < DSNhanVienQL.size(); i++) { 
                            if (DSNhanVienQL.get(i).getMaNV().trim().equalsIgnoreCase(maTim)) { 
                                DSNhanVienQL.get(i).Xuat(); 
                                foundQL = true; 
                                break; 
                            }
                        }
                        
                        if (!foundQL) { 
                            System.out.println("Khong tim thay nhan vien quan ly voi ma: " + maTim);
                        }
                        break; 
                    case 2:
                        System.out.println("Nhap vao ma nhan vien san xuat ma ban muon tim trong danh sach: ");
                        maTim = Nhap.nextLine().trim(); // Đọc mã cần tìm
                        Nhap.nextLine();
                        boolean foundSX = false; // Đặt cờ để kiểm tra tìm thấy
                        
                        for (i = 0; i < DSNhanVienSX.size(); i++) { // Duyệt qua danh sách
                            if (maTim.equalsIgnoreCase(DSNhanVienSX.get(i).getMaNV().trim())) { // So sánh mã
                                DSNhanVienSX.get(i).Xuat(); // Xuất thông tin
                                foundSX = true; // Đặt cờ thành true
                                break; // Thoát khỏi vòng lặp
                            }
                        }
                        
                        if (!foundSX) { // Nếu không tìm thấy
                            System.out.println("Khong tim thay nhan vien san xuat voi ma: " + maTim);
                        }
                        break; 
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai. "); 
                }
            } while (chon < 0 ||chon >2);
        }
    }
    // phương thức tự động tăng id nhân viên quản lý => tìm mã nv max trong danh sách và tăng thêm 1 đơn vị
    private String getMaNVQL() {
        if (DSNhanVienQL.size() == 0)
            return "QL001";
    
        // Lấy mã nhân viên đầu tiên trong danh sách, bỏ 2 ký tự "QL" để lấy số
        int max = Integer.parseInt(DSNhanVienQL.get(0).getMaNV().substring(2)); 
    
        
        for (int i = 1; i < DSNhanVienQL.size(); i++) { 
            int maNV = Integer.parseInt(DSNhanVienQL.get(i).getMaNV().substring(2));
            if (max < maNV)
                max = maNV;
        }
    
        //  đảm bảo có 3 chữ số (VD: QL001, QL010)
        return String.format("QL%03d", max + 1);
    }
    // hãy làm tương tự cho nv sản xuất
    private String getMaNVSX() {
        if (DSNhanVienSX.size() == 0)
            return "SX001";
    
        // Lấy mã nhân viên đầu tiên trong danh sách, bỏ 2 ký tự "QL" để lấy số
        int max = Integer.parseInt(DSNhanVienSX.get(0).getMaNV().substring(2)); 
    
        
        for (int i = 1; i < DSNhanVienSX.size(); i++) { 
            int maNV = Integer.parseInt(DSNhanVienSX.get(i).getMaNV().substring(2));
            if (max < maNV)
                max = maNV;
        }
        return String.format("SX%03d", max + 1);
    }
}
