package sample;

public class Main {
    public static void main(String[] args) {

        Veterinarian vet = new Veterinarian("Dr. Poni");

        Cat cat = new Cat("pet food", "black", 10, "Tihon");
        Dog dog = new Dog("meat", "red", 25, "Red");

        vet.treatment(cat);
        System.out.println();
        vet.treatment(dog);
    }
}
