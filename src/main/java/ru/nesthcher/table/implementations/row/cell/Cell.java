package ru.nesthcher.table.implementations.row.cell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.nesthcher.table.interfaces.row.cell.AbstractCell;

/**
 * Класс, реализующий обычную ячейку таблицы.
 */
@AllArgsConstructor
@Getter
public class Cell implements AbstractCell {
    /**
     * Значение ячейки.
     */
    private final String value;
    /**
     * Признак жирного выделения (по умолчанию false).
     */
    private final boolean bold = false;
}
