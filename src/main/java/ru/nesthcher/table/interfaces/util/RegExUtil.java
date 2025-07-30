package ru.nesthcher.table.interfaces.util;

import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;

/**
 * Утилитный класс для проверки регулярных выражений.
 */
@UtilityClass
public class RegExUtil {
    /**
     * Регулярное выражение для проверки валидности имени таблицы.
     */
    private final String VALID_TABLE_NAME = "^([a-zA-Zа-яА-ЯёЁ0-9\\- ]){1,30}$";

    /**
     * Проверяет, соответствует ли имя таблицы допустимому формату.
     * @param input имя таблицы
     * @return true, если имя валидно
     */
    public boolean isValidTableName(@NotNull final String input) {
        return input.matches(VALID_TABLE_NAME);
    }
}
