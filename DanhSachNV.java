package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNV extends Interface
{
    int chon, n , i;
    String maCapNhat, maXoa;
    public Scanner Nhap = new Scanner(System.in);
    ArrayList<NVSanXuat> DSNhanVienSX = new ArrayList<>();
    ArrayList<NVQuanLy> DSNhanVienQL = new ArrayList<>();
    public void ThemMoi()
    {
        while (true) 
        {   
            do
            {  
                System.out.println("Ban muon them moi thong tin cua nhan vien quan li hay san xuat: ");
                System.out.println("1. Nhan vien quan ly:");
                System.out.println("2. Nhan vien san xuat:");
                System.out.println("3. Quay lai menu chinh:");
                chon = Nhap.nextInt();
                Nhap.nextLine();
                switch (chon) 
                {
                    case 1:
                        System.out.println("Nhap vao so luong nhan vien them moi: ");
                        n = Nhap.nextInt();
                        Nhap.nextLine();
                        for (i = 1; i <= n; i++) 
                        {
                            System.out.printf("\nNhap vao thong tin nhan vien thu %d:\n", i);
                            NVQuanLy NVienQL = new NVQuanLy(null, null, null, 0, 0);
                            NVienQL.Nhap();
                            //NVienQL.setMaNV(getMaNVQL());// gọi phương thức tự động tăng id
                            DSNhanVienQL.add(NVienQL);
                        }
                        System.out.println("Them moi thanh cong");
                        break;
                    case 2:
                        System.out.println("Nhap vao so luong nhan vien them moi: ");
                        n = Nhap.nextInt();
                        Nhap.nextLine();
                        for (i = 1; i <= n; i++) 
                        {
                            System.out.printf("\nNhap vao thong tin nhan vien them moi thu %d:\n", i);
                            NVSanXuat NVienSX = new NVSanXuat(null, null, null, 0, 0);
                            NVienSX.Nhap();
                            DSNhanVienSX.add(NVienSX);
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le vui long thu lai. ");
                }
            }while (chon<0||chon>2);        
        }
    }
    public void CapNhat() // còn lỗi phương thức cập nhật + tìm mã nhân viên gặp lỗi
    {
        System.out.println("Nhap vao ma nhan vien muon cap nhat: ");
        String maNV = Nhap.nextLine();
        Nhap.nextLine();  

        if(maNV.startsWith("QL")){
            boolean isExistNhanVien = false;// nếu đi hết vòng for mà ko tìm thấy manv đó
            for(int i=0; i< DSNhanVienQL.size(); i++)
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
                for(int i=0; i<DSNhanVienSX.size(); i++)
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
    //Phương thức chọn nhan vien san xuat hay nhan vien quan ly
    public void Xem()
    {
        while (true) 
        {    
            System.out.println("Ban muon xem thong tin cua nhan vien quan ly hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("3. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                    System.out.println("\nThong tin tat ca nhan vien quan ly:");
                    for (i = 0; i < DSNhanVienQL.size(); i++) 
                        {
                            System.out.printf("\nThong tin cua nhan vien thu %d:\n", i + 1 );
                            DSNhanVienQL.get(i).Xuat();
                        }
                case 2:
                    System.out.println("\nThong tin tat ca nhan vien:");
                    for (i = 0; i < DSNhanVienSX.size(); i++) 
                    {
                        System.out.printf("\nThong tin cua nhan vien thu %d:\n", i + 1);
                        DSNhanVienSX.get(i).Xuat();
                    }
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    public void Xoa() //Phương thức xóa còn lỗi + chưa tìm được mã nhân viên thì out ra ngoài
    {
        while (true) 
        {    
            System.out.println("Ban muon xoa thong tin cua nhan vien quan li hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("3. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                case 2:
                    if (DSNhanVienSX.isEmpty()) {
                        System.out.println("Danh sach nhan vien san xuat dang trong.");
                        break;
                    }
                    System.out.println("Nhap vao ma nhan vien ma ban muon xoa: ");
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
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    public void SapXep() // sắp xếp theo lương với số tiền lương tăng dần
    {
        while (true) 
        {    
            System.out.println("Ban muon sap xep luong cua nhan vien quan li hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("3. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                case 2:
                    if (DSNhanVienSX.isEmpty()) {
                        System.out.println("Danh sach nhan vien dang trong.");
                        break;
                    }
                    DSNhanVienSX.sort((nv1, nv2) -> Double.compare(nv1.tinhLuong(), nv2.tinhLuong()));//sort tăng dần, double.compare: so sánh 2 giá trị kiểu double
                    System.out.println("Danh sach nhan vien san xuat da duoc sap xep theo luong.");
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    public void TimNV()
    {
        String maTim;
        while (true) 
        {    
            System.out.println("Ban muon tim trong danh sach nhan vien quan li hay san xuat: ");
            System.out.println("1. Nhan vien quan ly:");
            System.out.println("2. Nhan vien san xuat:");
            System.out.println("3. Quay lai menu chinh:");
            chon = Nhap.nextInt();
            switch (chon) 
            {
                case 1:
                case 2:
                    System.out.println("Nhap vao ma nhan vien ma ban muon tim trong danh sach: ");
                    maTim = Nhap.nextLine(); 
                    boolean foundSX = false; 
                    for (NhanVien nv : DSNhanVienSX) 
                    { 
                        if (nv.getMaNV().equalsIgnoreCase(maTim)) { // So sánh mã
                            nv.Xuat();
                            foundSX = true;
                            break;
                        }
                    }
                    
                    if (!foundSX) { // Nếu không tìm thấy
                        System.out.println("Khong tim thay nhan vien san xuat voi ma: " + maTim);
                    }
                    break;                
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    private String getMaNVQL() {
        //max id=> id= id+1
        if(DSNhanVienQL.size() == 1)
            return "QL001";
        int max = Integer.parseInt(DSNhanVienQL.get(1).getMaNV().substring(3));// max là id vị trí nhân viên ql đầu trong ds và cắt 3 kí tự đầu tiên để lấy bắt đầu từ số=> và đưa nó về số nguyên
        for (int i=1; i <= DSNhanVienQL.size() ; i++)
        {
            int maNV = Integer.parseInt(DSNhanVienQL.get(1).getMaNV().substring(3));
            if(max < maNV)
            max = maNV;
        }
        
        return String.format("QL%3d", max + 1).replace("", "0");
        // nó sẽ chừa ra và buộc phải lấp đầy 3 số , và thay những khoảng trống ko có số thành số 0=> đảm bảo QL001, QL010
    }
}
