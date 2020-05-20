package ir.datin.school.io.project1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PaymentFile {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("payment.txt");
            List<String> depositNumbers = DepositNumber.getAllDepositNumbers();
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
}
