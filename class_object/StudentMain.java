package class_object;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // muốn lưu trữ 1 list danh sách sinh viên 
        ArrayList<Student> students = new ArrayList<>();


        // nhập vào sĩ số sinh viên 
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhap vao so luong sinh vien");
        int soSV=scanner.nextInt();

        Student s3;

        // nhập vào danh sách sinh viên
        for(int i=1;i<=soSV;i++)
        {
            System.out.println("Nhap vao Thong tin sinh vien thu "+i);
            s3 = new Student();
            s3.input();

            // thêm sv vào arraylist
            students.add(s3);
        }
        // in danh sách sinh viên ra // cho i chảy từ 0 tránh lỗi 
        for(int i=0; i < students.size() ;i++)
        {
            System.out.println(" In ra Thong tin sinh vien thu "+(i+1));
        
            students.get(i).output();
        }





    }
}
