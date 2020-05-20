package ir.datin.school.io.project1;

import java.io.FileWriter;
import java.io.IOException;

public class PaymentFile {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("payment.txt");
            int i = 0;
            while (i++ < 50) {
                fileWriter.write("");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
