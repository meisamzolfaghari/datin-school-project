package ir.datin.school.io.project1.generators;

import ir.datin.school.io.project1.generators.RandomFieldsGenerator;

import java.util.ArrayList;
import java.util.List;

public class PaymentAmountOfCreditors {
    public static List<Integer> getAllCreditorPaymentAmount() {
        List<Integer> temp = new ArrayList<>();

        while (temp.size() < 49)
            temp.add(RandomFieldsGenerator.getRandomPaymentAmount());

        Integer TotalAmountOfCreditorsPayment = 0;

        for (Integer i : temp)
            TotalAmountOfCreditorsPayment += i;

        List<Integer> paymentAmountOfCreditors = new ArrayList<>();
        paymentAmountOfCreditors.add(TotalAmountOfCreditorsPayment);
        paymentAmountOfCreditors.addAll(temp);

        return paymentAmountOfCreditors;
    }
}
