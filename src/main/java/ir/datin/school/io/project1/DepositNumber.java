package ir.datin.school.io.project1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepositNumber {

    static List<String> getAllDepositNumbers() {
        Set<String> depositNumbersSet = new HashSet<>();
        while (depositNumbersSet.size() < 50)
            depositNumbersSet.add(RandomFieldsGenerator.getRandomDepositNumber());

        List<String> depositNumbers = new ArrayList<>();
        depositNumbers.add("1.10.100.1");
        depositNumbers.addAll(depositNumbersSet);
        return depositNumbers;
    }

}
