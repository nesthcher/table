package ru.nesthcher.table.interfaces.row;

import java.util.ArrayList;

import ru.nesthcher.table.interfaces.row.cell.AbstractCell;

/**
 * Интерфейс, описывающий строку таблицы.
 */
public interface AbstractRow {
    /**
     * Получить список ячеек строки.
     * @return список ячеек
     */
    ArrayList<AbstractCell> getCells();
    /**
     * Получить количество ячеек в строке.
     * @return количество ячеек
     */
    int getCountCells();
}
