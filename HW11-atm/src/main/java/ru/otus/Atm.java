package ru.otus;

import java.util.*;

public class Atm {

    private BillOperator billOperator;

    public Atm(List<Nominal> nominals) {
        billOperator = new BillOperator(nominals);
    }

    public long getBalance(){
       return billOperator.getAvailableMoney();
    }

    public void putMoney(List<Nominal> money){
        billOperator.putBills(money);
    }

    public void getMoney(long money){
        billOperator.getBills(money);
    }
}
