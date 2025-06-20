package ru.nesthcher.table.api.row.cell;

/**
 * Интерфейс, описывающий ячейку таблицы.
 */
public interface AbstractCell {
    /**
     * Получить значение ячейки.
     * @return значение
     */
    String getValue();
    /**
     * Проверить, выделена ли ячейка жирным.
     * @return true, если жирная
     */
    boolean isBold();
}
