package ir.datin.school.io.project1;

import ir.datin.school.io.project1.generators.DepositNumber;
import ir.datin.school.io.project1.generators.PaymentAmountOfCreditors;
import ir.datin.school.io.project1.generators.RandomFieldsGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InventoryFile {

    public static void create() {
        try {
            FileWriter fileWriter = new FileWriter("inventory.txt");
            List<String> depositNumbers = DepositNumber.getAllDepositNumbers();
            for (int i = 0; i < 50; i++) {
                if (i == 0)
                    fileWriter.write(depositNumbers.get(i) + "\t" + 30000 + "\n");
                else
                    fileWriter.write(depositNumbers.get(i) + "\t"
                            + RandomFieldsGenerator.getRandomPaymentAmount() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void update() {

    }
}
