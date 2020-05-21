package ir.datin.school.io.project1;

import ir.datin.school.io.project1.generators.DepositNumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class salaryPayment {
    public static void execute() {
        try {
            FileReader inventoryFileReader = new FileReader("inventory.txt");
            FileReader paymentFileReader = new FileReader("payment.txt");
            BufferedReader inventoryBufferedReader = new BufferedReader(inventoryFileReader);
            BufferedReader paymentBufferedReader = new BufferedReader(paymentFileReader);

            List<String> inventories = inventoryBufferedReader.lines()
                    .collect(Collectors.toList());

            Map<String, Integer> inventoryMap = new HashMap<>();
            for (String i : inventories)
                inventoryMap.put(i.split("\t")[0], Integer.parseInt(i.split("\t")[1]));

            List<String> payments = paymentBufferedReader.lines().collect(Collectors.toList());

            String debtor = payments.stream()
                    .filter(l -> l.contains(paymentStatus.debtor.toString()))
                    .collect(Collectors.toList()).get(0);
            String debtorDepositNumber = debtor.split("\t")[1];
            int totalCredits = Integer.parseInt(debtor.split("\t")[2]);

            List<String> creditors = payments.stream()
                    .filter(l -> l.contains(paymentStatus.creditor.toString()))
                    .collect(Collectors.toList());

            Map<String, Integer> creditorMap = new HashMap<>();
            for (String c : creditors)
                creditorMap.put(c.split("\t")[1], Integer.parseInt(c.split("\t")[2]));

            int bankBalance = inventoryMap.values().stream().reduce(0, Integer::sum);

            if (bankBalance < totalCredits) {
                System.out.println("Not enough Balance to pay the Credits!");
                inventoryBufferedReader.close();
                paymentBufferedReader.close();
                inventoryFileReader.close();
                paymentFileReader.close();
                return;
            }

            inventoryBufferedReader.close();
            paymentBufferedReader.close();
            inventoryFileReader.close();
            paymentFileReader.close();

            FileWriter inventoryFileWriter = new FileWriter("inventory.txt");
            FileWriter paymentFileWriter = new FileWriter("payment.txt");
            FileWriter transactionFileWriter = new FileWriter("transaction.txt");

            inventoryFileWriter.write(debtorDepositNumber + "\t" + (bankBalance - totalCredits) + "\n");
            inventoryMap.remove(debtorDepositNumber);
            paymentFileWriter.write(paymentStatus.debtor.toString() + "\t" + debtorDepositNumber + "\t" + 0 + "\n");

            Map<String, Integer> transactionMap = new HashMap<>();

            for (String c : creditorMap.keySet()) {
                if (inventoryMap.get(c) != null)
                    inventoryMap.put(c, inventoryMap.get(c) + creditorMap.get(c));
                transactionMap.put(debtorDepositNumber + "\t" + c, creditorMap.get(c));
                creditorMap.put(c, 0);
            }

            for (String i : inventoryMap.keySet()) {
                inventoryFileWriter.write(i + "\t" + inventoryMap.get(i) + "\n");
            }

            for (String t : transactionMap.keySet()) {
                transactionFileWriter.write(t + "\t" + transactionMap.get(t) + "\n");
            }

            for (String c : creditorMap.keySet()) {
                paymentFileWriter.write(paymentStatus.creditor.toString() + "\t" + c + "\t" + creditorMap.get(c) + "\n");
            }

            inventoryFileWriter.close();
            paymentFileWriter.close();
            transactionFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
