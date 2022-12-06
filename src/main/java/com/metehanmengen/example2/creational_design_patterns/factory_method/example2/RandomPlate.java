package src.main.java.com.metehanmengen.example2.creational_design_patterns.factory_method.example2;

import java.util.Random;

//Sınıf random olarak plaka üretiyor. Bunun için crete metodu IRandomFactory interface'inden implemente ediliyor.
public class RandomPlate implements IRandomPlateFactory {
    public static void main(String[] args)
    {
        System.out.println(new RandomPlate().create());
    }
    private final Random random = new Random();

    private String generetaPlate()
    {
        int num = random.nextInt(1, 82);
        String text = "";
        int k = random.nextBoolean() ? 3 : 2;
        for (int i = 0; i < k; i++)
            text += (char)('a' + random.nextInt(26));

        int value = random.nextInt(1, 10000);

        return String.format("%s %s %s", num, text.toUpperCase(), value);
    }

    @Override
    public String create() {

         String plate = generetaPlate();

        return plate;

    }
}
