package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNV  
{
    int chon, n , i, maCapNhat;
    public static Scanner Nhap = new Scanner(System.in);
    ArrayList<NVSanXuat> DSNhanVienSX = new ArrayList<>();
    ArrayList<NVQuanLy> DSNhanVienQL = new ArrayList<>();
   
    

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
                            DSNhanVienSX.add(NVienSX);
                        }
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
    public void Xoa()
    {
        while (true) 
        {    
            do 
            {
                System.out.println("Ban muon xoa thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                String maXoa;
                chon = Nhap.nextInt();
                switch (chon) 
                {
                    case 1:
                        if (DSNhanVienQL.isEmpty()) {
                            System.out.println("Danh sach nhan vien san xuat dang trong.");
                            break;
                        }
                        System.out.println("Nhap vao ma nhan vien san xuat ma ban muon xoa: ");
                        maXoa = Nhap.nextLine();
                        boolean foundQL = false;
                        for (int i = 0; i < DSNhanVienQL.size(); i++) {
                 
                            if (DSNhanVienQL.get(i).getMaNV().equalsIgnoreCase(maXoa)) {
                                DSNhanVienQL.remove(i);
                                System.out.println("Nhan vien san xuat voi ma " + maXoa + " da duoc xoa.");
                                foundQL = true;
                                break;
                            }
                        }
                        if (!foundQL) {
                            System.out.println("Khong tim thay nhan vien san xuat co ma: " + maXoa);
                        }
                        break;
                    case 2:
                        if (DSNhanVienSX.isEmpty()) {
                            System.out.println("Danh sach nhan vien san xuat dang trong.");
                            break;
                        }
                        System.out.println("Nhap vao ma nhan vien san xuat ma ban muon xoa: ");
                        maXoa = Nhap.nextLine();
                        boolean foundSX = false;
                        for (int i = 0; i < DSNhanVienSX.size(); i++) {
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
                        System.out.println("Lua chon khong hop le vui long thu lai. ");
                }
            } while (chon < 0 || chon > 2);
        }
    }
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
    //chức năng tìm 
    public void TimNV()
    {
        String maTim;
        while (true) 
        {    
            do {
                System.out.println("Ban muon sap xep luong cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("0. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                switch (chon) 
                {
                    case 1:
                        System.out.println("Nhap vao ma nhan vien ma ban muon tim trong danh sach: ");
                        maTim = Nhap.nextLine(); 
                        Nhap.nextLine();
                        boolean foundQL = false; 
                        
                        for (i = 0; i < DSNhanVienQL.size(); i++) { 
                            if (maTim.equalsIgnoreCase(DSNhanVienQL.get(i).getMaNV())) { 
                                DSNhanVienQL.get(i).Xuat(); 
                                foundQL = true; 
                                break; 
                            }
                        }
                        
                        if (!foundQL) { 
                            System.out.println("Khong tim thay nhan vien san xuat voi ma: " + maTim);
                        }
                break; 
                    case 2:
                        System.out.println("Nhap vao ma nhan vien ma ban muon tim trong danh sach: ");
                        maTim = Nhap.nextLine(); // Đọc mã cần tìm
                        Nhap.nextLine();
                        boolean foundSX = false; // Đặt cờ để kiểm tra tìm thấy
                        
                        for (i = 0; i < DSNhanVienSX.size(); i++) { // Duyệt qua danh sách
                            if (maTim.equalsIgnoreCase(DSNhanVienSX.get(i).getMaNV())) { // So sánh mã
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
        // Nếu danh sách trống, trả về mã đầu tiên
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
    
}
