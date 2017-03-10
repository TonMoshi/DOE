package Controller;

import Model.Users.User;
import View.GUI.MainFrame;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dam2
 */
public class TableDiplomacyEnemies extends AbstractTableModel {

    private List<User> enemies;
    private boolean[] players;
    private MainFrame mf;

    public TableDiplomacyEnemies(MainFrame mf) {
        this.mf = mf;
        this.enemies = mf.getUser().getEnemies();
        players = new boolean[enemies.size()];
    }

    @Override
    public int getRowCount() {
        return enemies.size()+1;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex == 0) {
            switch (columnIndex) {
                case 0:
                    return mf.getUser().getName();
                case 1:
                    return false;
                default:
                    throw new AssertionError();
            }
        } else {
            switch (columnIndex) {
                case 0:
                    return enemies.get(rowIndex-1).getName();
                case 1:
                    return players[rowIndex-1];
                default:
                    throw new AssertionError();
            }

        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:

                return "Nombre";
            case 1:

                return "Seleccionar";
            default:
                throw new AssertionError();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return Boolean.class;      
        default:
            return String.class;
            }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (row == 0) {
            return false;
        }
        return column == 1;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (aValue instanceof Boolean && column == 1) {
            players[row-1] = (Boolean)aValue;
            fireTableCellUpdated(row, column);
        }
    }

}
