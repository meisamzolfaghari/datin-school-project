package ir.datin.school.io.project1;

import ir.datin.school.io.project1.generators.DepositNumber;
import ir.datin.school.io.project1.generators.PaymentAmountOfCreditors;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaymentFile {
    public static void create() {
        try {
            FileWriter fileWriter = new FileWriter("payment.txt");
            FileReader fileReader = new FileReader("inventory.txt");
            List<String> depositNumbers = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
                depositNumbers.add(line.split("\t")[0]);
            List<Integer> paymentAmountOfCreditors = PaymentAmountOfCreditors.getAllCreditorPaymentAmount();
            for (int i = 0; i < 50; i++) {
                if (i == 0)
                    fileWriter.write("debtor\t" + depositNumbers.get(i) + "\t" + paymentAmountOfCreditors.get(i) + "\n");
                else
                    fileWriter.write("creditor\t" + depositNumbers.get(i) + "\t" + paymentAmountOfCreditors.get(i) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void update() {

    }
}
