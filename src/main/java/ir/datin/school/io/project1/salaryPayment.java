package ir.datin.school.io.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class salaryPayment {
    public static void execute() {
        try {
            FileReader inventoryFileReader = new FileReader("inventory.txt");
            FileReader paymentFileReader = new FileReader("payment.txt");
            FileWriter inventoryFileWriter = new FileWriter("inventory.txt");
            FileWriter paymentFileWriter = new FileWriter("payment.txt");
            FileWriter transactionFileWriter = new FileWriter("transaction.txt");
            BufferedReader inventoryBufferedReader = new BufferedReader(inventoryFileReader);
            BufferedReader paymentBufferedReader = new BufferedReader(paymentFileReader);





            inventoryBufferedReader.close();
            paymentBufferedReader.close();
            inventoryFileReader.close();
            paymentFileReader.close();
            inventoryFileWriter.close();
            paymentFileWriter.close();
            transactionFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
