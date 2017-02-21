/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users.User;
import View.GUI.MainFrame;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dam2
 */
public class TableEnemies extends AbstractTableModel{
    
    private List<User> users;
    private MainFrame mf;
    
    public TableEnemies(MainFrame mf) {
        this.users = mf.getMc().getEnemies(mf.getUser());
        Collections.sort(users, (User o1, User o2) -> {
            if (o1.getWinRatio() > o2.getWinRatio()) {
                return -1;
            } else if (o1.getWinRatio() == o2.getWinRatio()) {
                return 0;
            } else {
                return 1;
            }
        });
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
