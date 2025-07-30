package ru.nesthcher.table.interfaces.row;

import ru.nesthcher.table.interfaces.row.cell.AbstractCell;

import java.util.List;

/**
 * Интерфейс, описывающий строку таблицы.
 */
public interface AbstractRow {
    /**
     * Получить список ячеек строки.
     * @return список ячеек
     */
    List<AbstractCell> getCells();
    /**
     * Получить количество ячеек в строке.
     * @return количество ячеек
     */
    int getCountCells();
}
