package daHinh;

class animal{
    void sound(){
        System.out.println("animal makes a sound");
    }
}

class chim extends animal{
    @Override// chim sẽ override sound
    void sound() {
        System.out.println("chim hót");
    }
} 
class meo extends animal{
    //@Override// mèo sẽ override sound
    //void sound() {
        //System.out.println("mèo kêu meo meo");
    //}
} 

public class runtime {
    public static void main(String[] args) {
        animal animal1 = new chim();// vì có tính đa hình nên cha (animal) có thể tham chiếu đc cho con(chim)
        animal animal2 = new meo();

        animal1.sound();// tương tự như chim.sound
        animal2.sound();
    }
}
