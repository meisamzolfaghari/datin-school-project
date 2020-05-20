package ir.datin.school.io.project1.generators;

import java.util.Random;

public class RandomFieldsGenerator {

    public static String getRandomDepositNumber() {
        Random random = new Random();
        String first = "1";
        String second = String.valueOf((random.nextInt(9) + 1) * 10);
        String third = String.valueOf((random.nextInt(8) + 1) * 100);
        String forth = String.valueOf(random.nextInt(8) + 1);
        return first + "." + second + "." + third + "." + forth;
    }

    public static Integer getRandomPaymentAmount() {
        return new Random().nextInt(10) * 100;
    }
}
