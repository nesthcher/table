package ru.nesthcher.table.implementations.row;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.nesthcher.table.interfaces.row.AbstractRow;
import ru.nesthcher.table.interfaces.row.cell.AbstractCell;

/**
 * Класс, реализующий строку таблицы.
 */
@RequiredArgsConstructor
@Getter
public class Row implements AbstractRow {
    /**
     * Список ячеек строки.
     */
    private final ArrayList<AbstractCell> cells;

    /**
     * Конструктор строки с переменным числом ячеек.
     * @param cells массив ячеек
     */
    public Row(
            @NotNull final AbstractCell... cells
    ) {
        this.cells = new ArrayList<>(List.of(cells));
    }

    /**
     * Получить количество ячеек в строке.
     * @return количество ячеек
     */
    @Override
    public int getCountCells() {
        return cells.size();
    }
}
