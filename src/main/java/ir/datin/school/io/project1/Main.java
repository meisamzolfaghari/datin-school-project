package ir.datin.school.io.project1;

public class Main {
    public static void main(String[] args) {
        InventoryFile.create();
        PaymentFile.create();

        InventoryFile.update();
        TransactionFile.createOrUpdate();
        PaymentFile.update();

    }
}
