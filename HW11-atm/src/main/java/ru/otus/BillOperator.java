package ru.otus;

import java.util.*;

public class BillOperator {

    Map<Nominal, Cell> cells;

    public BillOperator(List<Nominal> cells) {
        this.cells = new TreeMap<>(Collections.reverseOrder());
        cells.forEach(
                cell -> this.cells.put(cell, new Cell(cell, 0))
        );
    }

    private long getAvailableBills(Nominal nominal) {
        return this.cells.get(nominal).getCount();
    }

    public void putBills(List<Nominal> income) {
        income.forEach(
                bill -> cells.get(bill).put(1)
        );
    }

    public long getAvailableMoney() {
        long sum = 0;
        for (Nominal nominal : cells.keySet()) {
            sum += nominal.getValue() * getAvailableBills(nominal);
        }
        return sum;

    }

    public void getBills(long amount) {
        if (amount < getAvailableMoney()) {
            for (Nominal nominal : cells.keySet()) {
                long maxBillsNominal = amount / nominal.getValue();
                long billsToGet = Math.min(getAvailableBills(nominal) , maxBillsNominal);
                amount -= nominal.getValue() * billsToGet;
                cells.get(nominal).remove(billsToGet);
            }
            if (amount != 0){
                throw new RuntimeException("Cannot give that amount of money");
            }
        } else {
            throw new RuntimeException("Not enough money for operation");
        }
    }

}
