package ex2;
public class DogDemo {
    public static void main(String[] args) {

        Dog dog = new Dog.DogBuilder()
                .name("MIMI")
                .age(6)
                .race("dog")
                .build();

        System.out.println(dog);
    }
}
