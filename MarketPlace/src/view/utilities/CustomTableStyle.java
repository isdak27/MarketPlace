package view.utilities;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableStyle {

    public static void customizeTable(JTable table, Color headerBackgroundColor, Color cellBackgroundColor,
                                      Color headerTextColor, Color cellTextColor, Font headerFont, Font cellFont,
                                      int cellPadding, int headerHeight) {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(headerBackgroundColor);
        headerRenderer.setForeground(headerTextColor);
		headerRenderer.setFont(headerFont);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setPreferredSize(new Dimension(headerRenderer.getPreferredSize().width, headerHeight));
        table.getTableHeader().setDefaultRenderer(headerRenderer);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(cellBackgroundColor);
        cellRenderer.setForeground(cellTextColor);
        cellRenderer.setFont(cellFont);
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setBorder(BorderFactory.createEmptyBorder(cellPadding, cellPadding, cellPadding, cellPadding));
        table.setDefaultRenderer(Object.class, cellRenderer);

        table.setIntercellSpacing(new Dimension(cellPadding, cellPadding));
        table.setRowHeight(table.getRowHeight() + (cellPadding * 2));
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.setFillsViewportHeight(true);
    }
}

