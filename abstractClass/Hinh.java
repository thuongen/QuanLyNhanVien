package abstractClass;

abstract class Hinh {
    protected String tenhinh;
    public Hinh(){}
    public Hinh(String tenhinh){
        this.tenhinh = tenhinh;
    }
    public void Nhap(){}
    public void Xuat(){}
    abstract public double tinhChuVi();
    abstract public double tinhDienTich();

}
