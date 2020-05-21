package ir.datin.school.io.project1;

import ir.datin.school.io.project1.createfiles.InventoryFile;
import ir.datin.school.io.project1.createfiles.PaymentFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryFile.create();
        PaymentFile.create();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you Want to execute the Payment?(y for yes or any thing else for no)  ");
        if (scanner.next().charAt(0) == 'y')
            salaryPayment.execute();

        else
            System.out.println("bye bye!");
    }
}
