package ir.datin.school.io.project1;

import java.util.HashSet;
import java.util.Set;

public class DepositNumber {

    static Set<String> getAllDepositNumbers() {
        Set<String> depositNumbers = new HashSet<String>();

        while (depositNumbers.size() <= 50)
            depositNumbers.add(RandomFieldsGenerator.getRandomDepositNumber());

        return depositNumbers;
    }

}
