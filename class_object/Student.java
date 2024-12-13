package class_object;

import java.util.Scanner;

public class Student {
    // dịnh nghĩa property
    String name;
    int age;
    String color;

    public void eat(){
       System.out.println(name + "ang nhieu");

    }

    public void input(){
       Scanner SC=new Scanner(System.in);

       System.out.println("Nhap ten SV ");
       name = SC.nextLine();
       System.out.println("Nhap tuoi SV ");
       age = Integer.parseInt(SC.nextLine());
       System.out.println("Nhap color SV ");
       color = SC.nextLine();
    }
    public void output(){
        System.out.println("NAME:"+name);
        System.out.println("AGE:"+age);
        System.out.println("COLOR:"+color);
       
    }

    public void add(Student s3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public Student get(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
    