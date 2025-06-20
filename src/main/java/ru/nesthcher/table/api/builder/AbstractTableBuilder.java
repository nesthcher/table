package ru.nesthcher.table.api.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ru.nesthcher.table.api.AbstractTable;

/**
 * Интерфейс строителя таблицы.
 * Позволяет реализовать различные способы построения таблицы (например, экспорт в файл).
 */
public interface AbstractTableBuilder {
    /**
     * Построить таблицу по заданному экземпляру и сохранить по пути.
     * @param table таблица
     * @param pathFile путь к файлу
     * @return результат построения (например, файл)
     */
    @Nullable Object build(@NotNull final AbstractTable table, final String pathFile);
}
