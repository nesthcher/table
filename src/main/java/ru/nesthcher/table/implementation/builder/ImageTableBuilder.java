package ru.nesthcher.table.implementation.builder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ru.nesthcher.table.api.AbstractTable;
import ru.nesthcher.table.api.builder.AbstractTableBuilder;
import ru.nesthcher.table.api.row.AbstractRow;
import ru.nesthcher.table.api.row.cell.AbstractCell;
import ru.nesthcher.utils.container.Pair;

/**
 * Реализация билдера таблицы для экспорта в изображение.
 */
public class ImageTableBuilder implements AbstractTableBuilder {

    /**
     * Получить служебную информацию о таблице: максимальная ширина ячейки, количество строк и ячеек.
     * @param table таблица
     * @return пара с шириной и парой (строки, ячейки)
     */
    private Pair<Integer, Pair<Integer, Integer>> getServiceInfo(
            @NotNull final AbstractTable table
    ) {
        int maxWidth = 0;
        int maxCountCellInRow = 0;
        AbstractRow tableRow;
        AbstractCell tableCell;
        for(int i = 0; i < table.getCountRows(); i++) {
            tableRow = table.getRows().get(i);
            maxCountCellInRow = Math.max(tableRow.getCountCells(), maxCountCellInRow);
            for(int j = 0; j < tableRow.getCountCells(); j++) {
                tableCell = tableRow.getCells().get(j);
                maxWidth = Math.max(tableCell.getValue().length() * 10, maxWidth);
            }
        }
        return new Pair<>(maxWidth, new Pair<>(table.getCountRows(), maxCountCellInRow));
    }

    /**
     * Построить изображение таблицы и сохранить в файл.
     * @param table таблица
     * @param pathFile путь к файлу
     * @return созданный файл или null
     */
    @Override
    @Nullable
    public Object build(
            @NotNull final AbstractTable table,
            @NotNull final String pathFile
    ) {
        final Pair<Integer, Pair<Integer, Integer>> serviceInfo = getServiceInfo(table);
        final int numRows = serviceInfo.getSecond().getFirst();
        final int numCols = serviceInfo.getSecond().getSecond();

        final int width = serviceInfo.getFirst() * numCols;
        final int height = numRows * 20;

        if(width == 0 || height == 0)
            throw new IllegalArgumentException("[ImageTableBuilder] Кажется что-то пошло не так, полученные значения размеров равны 0");

        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        final Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        final int cellWidth = width / numCols;
        final int cellHeight = height / numRows;

        // Горизонтальные линии
        for (int i = 0; i <= numRows; i++) {
            g.setColor(Color.BLACK);
            g.drawLine(0, i * cellHeight, width, i * cellHeight);
        }

        // Вертикальные линии
        for (int j = 0; j <= numCols; j++) {
            g.setColor(Color.BLACK);
            g.drawLine(j * cellWidth, 0, j * cellWidth, height);
        }

        g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        g.setColor(Color.BLACK);

        AbstractRow tableRow;
        String tableCellValue;
        for(int i = 0; i < table.getCountRows(); i++) {
            tableRow = table.getRows().get(i);
            for(int j = 0; j < tableRow.getCountCells(); j++) {
                tableCellValue = tableRow.getCells().get(j).getValue();
                int textWidth = g.getFontMetrics().stringWidth(tableCellValue);
                int textHeight = g.getFontMetrics().getHeight();
                g.drawString(tableCellValue, (j * cellWidth) + (cellWidth - textWidth) / 2, (i * cellHeight) + (cellHeight - textHeight) / 2 + g.getFontMetrics().getAscent());
            }
        }
        try {
//            FileOutputStream outputStream = new FileOutputStream(pathFile + "/" + table.getName() + ".png")
            final File file = new File(pathFile + "/" + table.getName() + ".png");
            if(file.mkdirs()) {
                ImageIO.write(image, "png", file);
                return file;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.dispose(); // Освобождаем ресурсы
        }
        return null;
    }
}
