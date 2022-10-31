package com.artem.week6;

public interface CsvRowSupplier<T extends CsvRow> {

    T getObj();
}
