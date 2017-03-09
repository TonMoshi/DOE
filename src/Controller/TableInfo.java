/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users.User;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dam2
 */
public class TableInfo extends AbstractTableModel {

    private List<User> users;

    public TableInfo(MainController mc) {
        this.users = mc.getUsers();
        users.sort(null);
//        Collections.sort(users, (User o1, User o2) -> {
//            if (o1.getWinRatio() > o2.getWinRatio()) {
//                return -1;
//            } else if (o1.getWinRatio() == o2.getWinRatio()) {
//                return 0;
//            } else {
//                return 1;
//            }
//        });
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return users.get(rowIndex).getName();
            case 2:
                return users.get(rowIndex).getWin();
            case 3:
                return users.get(rowIndex).getPlays();
            default:
                return 0;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:

                return "Rank";
            case 1:

                return "UserName";
            case 2:

                return "Wins";
            case 3:

                return "Games Played";
            default:
                throw new AssertionError();
        }
    }

}
