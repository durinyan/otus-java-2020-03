package ru.otus;

public enum Nominal {
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    FIVE_THOUSAND(5000);

    private long value;

    Nominal(long value) {
        this.value = value;
    }

    public long getValue(){
        return value;
    }
}
