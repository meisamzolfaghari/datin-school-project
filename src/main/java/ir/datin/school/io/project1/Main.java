package ir.datin.school.io.project1;

import ir.datin.school.io.project1.createfiles.InventoryFile;
import ir.datin.school.io.project1.createfiles.PaymentFile;

public class Main {
    public static void main(String[] args) {
        InventoryFile.create();
        PaymentFile.create();

    }
}
