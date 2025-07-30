package ru.nesthcher.table.interfaces;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ru.nesthcher.table.interfaces.builder.AbstractTableBuilder;
import ru.nesthcher.table.interfaces.row.AbstractRow;

/**
 * Интерфейс, описывающий таблицу.
 */
public interface AbstractTable {
    /**
     * Получить имя таблицы.
     * @return имя
     */
    String getName();
    /**
     * Получить строки таблицы.
     * @return список строк
     */
    List<AbstractRow> getRows();
    /**
     * Получить количество строк.
     * @return количество строк
     */
    int getCountRows();

    /**
     * Построить таблицу с помощью билдера.
     * @param clazz класс билдера
     * @return результат построения
     */
    @Nullable <T extends AbstractTableBuilder> Object build(@NotNull final Class<T> clazz);
    /**
     * Построить таблицу с помощью билдера и сохранить по пути.
     * @param clazz класс билдера
     * @param pathFile путь к файлу
     * @return результат построения
     */
    @Nullable <T extends AbstractTableBuilder> Object build(@NotNull final Class<T> clazz, @NotNull final String pathFile);
}
