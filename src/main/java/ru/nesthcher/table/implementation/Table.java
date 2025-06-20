package ru.nesthcher.table.implementation;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.Getter;
import lombok.ToString;
import ru.nesthcher.table.api.AbstractTable;
import ru.nesthcher.table.api.builder.AbstractTableBuilder;
import ru.nesthcher.table.api.row.AbstractRow;
import ru.nesthcher.utils.PatternUtil;

/**
 * Класс, реализующий таблицу.
 */
@ToString
@Getter
public class Table implements AbstractTable {
    /**
     * Имя таблицы.
     */
    private final String name;
    /**
     * Список строк таблицы.
     */
    private final List<AbstractRow> rows;

    /**
     * Конструктор таблицы с именем (без строк).
     * @param name имя таблицы
     */
    public Table(
            @NotNull final String name
    ) {

        this.name = name;
        this.rows = new ArrayList<>();
        validName();
    }

    /**
     * Конструктор таблицы с именем и списком строк.
     * @param name имя таблицы
     * @param rows список строк
     */
    public Table(
            @NotNull final String name,
            @NotNull final List<AbstractRow> rows
    ) {
        this.name = name;
        this.rows = rows;
        validName();
    }

    /**
     * Конструктор таблицы с именем и массивом строк.
     * @param name имя таблицы
     * @param rows массив строк
     */
    public Table(
            @NotNull final String name,
            @NotNull final AbstractRow... rows
    ) {
        this.name = name;
        this.rows = List.of(rows);
        validName();
    }

    /**
     * Проверка валидности имени таблицы.
     * @throws IllegalArgumentException если имя некорректно
     */
    private void validName() {
        if(!PatternUtil.isRussianWithDigits(name))
            throw new IllegalArgumentException("[Table] Кажется что-то пошло не так, название таблицы может содержать латиницу, кириллицу, цифры, подчёркивание и максимум 40 символов");
    }

    /**
     * Получить количество строк в таблице.
     * @return количество строк
     */
    @Override
    public int getCountRows() {
        return rows.size();
    }

    /**
     * Построить таблицу с помощью билдера и сохранить по пути.
     * @param clazz класс билдера
     * @param pathFile путь к файлу
     * @return результат построения
     */
    @Override
    @Nullable
    public <T extends AbstractTableBuilder> Object build(
            final @NotNull Class<T> clazz,
            @NotNull final String pathFile
    ) {
        if(rows.isEmpty()) {
            throw new IllegalArgumentException("[Table] Кажется что-то пошло не так, пустые строки");
        }
        T tableBuilder = null;
        try {
            tableBuilder = clazz.getConstructor().newInstance();
        } catch (ReflectiveOperationException | SecurityException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Кажется что-то пошло не так, TableBuilder - " + clazz.getSimpleName());
        }
        return tableBuilder.build(this, pathFile);
    }

    /**
     * Построить таблицу с помощью билдера (по умолчанию путь ".").
     * @param clazz класс билдера
     * @return результат построения
     */
    @Override
    @Nullable
    public <T extends AbstractTableBuilder> Object build(@NotNull final Class<T> clazz) {
        return build(clazz, ".");
    }
}
