package ru.nesthcher.table.api.row;

import java.util.List;

import ru.nesthcher.table.api.row.cell.AbstractCell;

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
