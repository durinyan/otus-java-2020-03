package ru.otus;


public class Cell {

    private Nominal nominal;
    private long count;

    public Cell(Nominal nominal, long count) {
        this.nominal = nominal;
        this.count = count;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public long getCount() {
        return count;
    }

    public void put(long count){
        this.count += count;
    }

    public void remove(long count){
        if (this.count < count){
            throw new RuntimeException("Not enough bills for operation");
        }
        this.count -= count;
    }

}
