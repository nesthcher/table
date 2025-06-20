package ru.nesthcher.table.implementation.row.cell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.nesthcher.table.api.row.cell.AbstractCell;

/**
 * Класс, реализующий заголовочную ячейку таблицы (жирная).
 */
@AllArgsConstructor
@Getter
public class CellTitle implements AbstractCell {
    /**
     * Значение ячейки.
     */
    private final String value;
    /**
     * Признак жирного выделения (всегда true для заголовка).
     */
    private final boolean bold = true;
}
