public class test {
    public static void main(String[] args) {
        class Animal {
            void eat() {
                System.out.println("Animal is eating");
            }
        }
        
        class Dog extends Animal {
            @Override
            void eat() {
                System.out.println("Dog is eating");
            }
        }
       
    }
}
