package ir.datin.school.io.project1;

import java.util.Random;

public class RandomFieldsGenerator {
    static String getRandomPaymentState() {
        return String.valueOf(new Random().nextInt(10) * 100);
    }

    static String getRandomDepositNumber() {
        Random random = new Random();
        String first = "1";
        String second = String.valueOf((random.nextInt(9) + 1) * 10);
        String third = String.valueOf((random.nextInt(8) + 1) * 100);
        String forth = String.valueOf(random.nextInt(8) + 1);
        return first + "." + second + "." + third + "." + forth;
    }

    static Integer getRandomPaymentAmount() {
        return new Random().nextInt(10) * 100;
    }
}
