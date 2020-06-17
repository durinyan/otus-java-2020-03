package ru.otus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class runner {
    public static void main(String... args) {
        List<Nominal> nominals = new ArrayList<>();
        nominals.add(Nominal.FIFTY);
        nominals.add(Nominal.HUNDRED);
        nominals.add(Nominal.FIVE_HUNDRED);
        nominals.add(Nominal.THOUSAND);
        nominals.add(Nominal.FIVE_THOUSAND);

        List<Nominal> moneyToPut = new ArrayList<>();
        moneyToPut.add(Nominal.FIFTY);
        moneyToPut.add(Nominal.FIFTY);
        moneyToPut.add(Nominal.FIFTY);
        moneyToPut.add(Nominal.HUNDRED);
        moneyToPut.add(Nominal.HUNDRED);
        moneyToPut.add(Nominal.HUNDRED);
        moneyToPut.add(Nominal.FIVE_HUNDRED);
        moneyToPut.add(Nominal.FIVE_HUNDRED);
        moneyToPut.add(Nominal.THOUSAND);
        moneyToPut.add(Nominal.FIVE_THOUSAND);
        moneyToPut.add(Nominal.FIVE_THOUSAND);
        moneyToPut.add(Nominal.FIVE_THOUSAND);
        moneyToPut.add(Nominal.FIVE_THOUSAND);

        Atm atm = new Atm(nominals);
        atm.putMoney(moneyToPut);
        System.out.println("Balance is: "+ atm.getBalance());
        atm.getMoney(7150);
        System.out.println("Balance is: "+ atm.getBalance());
        System.out.println();
    }

}
