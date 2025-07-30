package ru.nesthcher.table.implementations.row.cell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.nesthcher.table.interfaces.row.cell.AbstractCell;

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
