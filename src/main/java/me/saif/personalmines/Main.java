package me.saif.personalmines;

public class Main {

    public static void main(String[] args) {
        WeightedRandomGenerator<String> generator = new WeightedRandomGenerator<>();

        generator.addItem("A", 1);
        generator.addItem("B", 2);
        generator.addItem("C", 3);
        generator.addItem("D", 4);

        System.out.println(generator.generateRandom());
    }

}
