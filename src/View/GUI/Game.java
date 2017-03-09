/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import Model.Users.User;
import View.InfoGame;
import View.Terrain.Cell;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import no.geosoft.cc.graphics.GScene;
import no.geosoft.cc.graphics.GWindow;

/**
 *
 * @author Dani
 */
public class Game extends javax.swing.JPanel {

    private Timer t;
    private final InfoGame info;
    private MainFrame mf;
    private int hour, min, auxHour, auxMin, auxSec, auxDay, auxMonth, auxYear;
    private Calendar rightNow;
    private List<User> rivals;

    /**
     * Creates new form Game
     *
     * @param user
     * @param rivals
     * @param mf
     */
    public Game(User user, List<User> rivals, MainFrame mf) {

        initComponents();
        this.mf = mf;
        this.rivals = rivals;
        rightNow = Calendar.getInstance();
        GWindow window = new GWindow(Color.BLACK);
        jPDraw.add(window.getCanvas());
        // Create scene with default viewport and world extent settings
        GScene scene = new GScene(window);
        window.getCanvas().setPreferredSize(new Dimension(40 * Cell.SIDE, 30 * Cell.SIDE));
        // Create the graphics object and add to the scene
        Model.Terrain.Map map = new Model.Terrain.Map(40 * Cell.SIDE, 30 * Cell.SIDE);
        scene.add(map.getRep());
        info = new InfoGame(Model.Buildings.CityHall.MAXLIFE);
        g = new Model.Game(user, rivals, map, scene, info, this);
        //map.addGameObj(gObj);        
        hour = rightNow.get(Calendar.HOUR);
        min = rightNow.get(Calendar.MINUTE);
        t = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.loop();
            }
        });
        t.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                List<JLabel> l = new ArrayList<>();
                l.add(jLabel4);
                l.add(jLabel6);
                l.add(jLabel8);
                l.add(jLabel10);
                jLabel4.setText(Model.Buildings.CityHall.MAXLIFE + "");
                jLabel6.setText("0");
                jLabel8.setText("0");
                jLabel10.setText("0");
                while (0 == 0) {
                    try {
                        info.updateInfo(l);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t2.start();
    }

    public void winner() {
        JOptionPane.showMessageDialog(this, "Enhorabuena ¡Has ganado!",
                "¡Victoria!", JOptionPane.PLAIN_MESSAGE);
        t.stop();
        
        auxYear = rightNow.get(Calendar.YEAR);
        auxMonth = rightNow.get(Calendar.MONTH);
        auxDay = rightNow.get(Calendar.DAY_OF_MONTH);        
        auxHour = rightNow.get(Calendar.HOUR_OF_DAY);
        auxMin = rightNow.get(Calendar.MINUTE);
        auxSec = rightNow.get(Calendar.SECOND);
        
        int time = (((auxHour - hour)*60)+(auxMin - min));
        String actualTime = (auxHour+":"+auxMin+":"+auxSec+"-"+auxDay+"/"+auxMonth+"/"+auxYear);
        mf.getUser().newWin();
        mf.getUser().newPlays();
        
        for (int i = 0; i < rivals.size(); i++) {
            rivals.get(i).newPlays();
        }
        String[] data = new String[6];
        data[0] = actualTime;
        data[1] = String.valueOf(time);
        data[2] = String.valueOf(info.getLifeCityHall());
        data[3] = String.valueOf(info.getDefense());
        data[4] = String.valueOf(info.getBuilders());
        data[5] = String.valueOf(info.getWarriors());
        mf.getMc().setLastGameWin(data, rivals);
        mf.showMenu();

    }

    public void loser() {
        JOptionPane.showMessageDialog(this, "Has fracasado...",
                "¡Derrota!", JOptionPane.PLAIN_MESSAGE);
        t.stop();
        auxYear = rightNow.get(Calendar.YEAR);
        auxMonth = rightNow.get(Calendar.MONTH);
        auxDay = rightNow.get(Calendar.DAY_OF_MONTH);        
        auxHour = rightNow.get(Calendar.HOUR);
        auxMin = rightNow.get(Calendar.MINUTE);
        
        int time = (((auxHour - hour)*60)+(auxMin - min));
        String actualTime = (auxHour+":"+auxMin+":"+auxSec+"-"+auxDay+"/"+auxMonth+"/"+auxYear);
        mf.getUser().newPlays();
        
        for (int i = 0; i < rivals.size(); i++) {
            rivals.get(i).newWin();
            rivals.get(i).newPlays();
        }
        
        String[] data = new String[6];
        data[0] = actualTime;
        data[1] = String.valueOf(time);
        data[2] = String.valueOf(info.getLifeCityHall());
        data[3] = String.valueOf(info.getDefense());
        data[4] = String.valueOf(info.getBuilders());
        data[5] = String.valueOf(info.getWarriors());
        mf.getMc().setLastGameLose(data, rivals);
        mf.showMenu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPDraw = new javax.swing.JPanel();
        jPControls = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPMonitor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jPDraw.setLayout(new javax.swing.BoxLayout(jPDraw, javax.swing.BoxLayout.LINE_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 0.9;
        add(jPDraw, gridBagConstraints);

        jPControls.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Construccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPControls.add(jLabel1, gridBagConstraints);

        jButton1.setText("Obrero");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPControls.add(jButton1, gridBagConstraints);

        jButton2.setText("Guerrero");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPControls.add(jButton2, gridBagConstraints);

        jButton3.setText("Torreta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPControls.add(jButton3, gridBagConstraints);

        jLabel2.setText("Movimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPControls.add(jLabel2, gridBagConstraints);

        jButton4.setText(".");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPControls.add(jButton4, gridBagConstraints);

        jButton5.setText(".");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPControls.add(jButton5, gridBagConstraints);

        jButton6.setText(".");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPControls.add(jButton6, gridBagConstraints);

        jButton7.setText(".");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPControls.add(jButton7, gridBagConstraints);

        jButton8.setText(".");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPControls.add(jButton8, gridBagConstraints);

        jButton9.setText(".");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPControls.add(jButton9, gridBagConstraints);

        jButton10.setText(".");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPControls.add(jButton10, gridBagConstraints);

        jButton11.setText(".");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        jPControls.add(jButton11, gridBagConstraints);

        jButton12.setText(".");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        jPControls.add(jButton12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 0.1;
        add(jPControls, gridBagConstraints);

        jPMonitor.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("CityHall");
        jPMonitor.add(jLabel3, new java.awt.GridBagConstraints());

        jLabel4.setText("jLabel4");
        jPMonitor.add(jLabel4, new java.awt.GridBagConstraints());

        jLabel5.setText("Guerreros");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPMonitor.add(jLabel5, gridBagConstraints);

        jLabel6.setText("jLabel6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPMonitor.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Obreros");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPMonitor.add(jLabel7, gridBagConstraints);

        jLabel8.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPMonitor.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Defensas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPMonitor.add(jLabel9, gridBagConstraints);

        jLabel10.setText("jLabel10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPMonitor.add(jLabel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.9;
        add(jPMonitor, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.build(Model.Game.DEFENSE);
        t.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.build(Model.Game.BUILDER);
        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.build(Model.Game.WARRIOR);
        t.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.UL);
        t.start();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.UP);
        t.start();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.UR);
        t.start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.LEFT);
        t.start();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.CENTER);
        t.start();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.RIGHT);
        t.start();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.DL);
        t.start();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.DOWN);
        t.start();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        t.stop();
        g.moveUnits(Model.Game.DR);
        t.start();
    }//GEN-LAST:event_jButton12ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPControls;
    private javax.swing.JPanel jPDraw;
    private javax.swing.JPanel jPMonitor;
    // End of variables declaration//GEN-END:variables
    private Model.Game g;
}
