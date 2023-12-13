package gui;

import items.GameUtils;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameInfoPanel extends JPanel{

    public JLabel getPointLabel() {
        return pointLabel;
    }
    final private JLabel pointLabel;

    public JLabel getMunitionLabel() {
        return munitionLabel;
    }
    final private JLabel munitionLabel;

    private static final Color PANEL_COLOR = Color.decode("0xFDFE6");
    private static final EtchedBorder PANEL_BORDER = new EtchedBorder(EtchedBorder.RAISED);

    public GameInfoPanel() {
        super(new FlowLayout());
        this.setBackground(PANEL_COLOR);
        this.setBorder(PANEL_BORDER);
        JPanel levelPanel = new JPanel();
        JPanel pointPanel = new JPanel();
        JPanel munitionPanel = new JPanel();
        this.pointLabel = new JLabel("Point:" + 0);
        JLabel levelLabel = new JLabel("Level:" +0);
        this.munitionLabel = new JLabel("Munition:" +1);
        pointLabel.setFont(new Font("Verdana", 1, 20));
        levelLabel.setFont(new Font("Verdana", 1, 20));
        munitionLabel.setFont(new Font("Verdana", 1, 20));
        levelPanel.add(levelLabel);
        munitionPanel.add(munitionLabel);
        pointPanel.add(pointLabel);
        levelPanel.setBackground(PANEL_COLOR);
        pointPanel.setBackground(PANEL_COLOR);
        munitionPanel.setBackground(PANEL_COLOR);
        this.add(levelPanel);
        this.add(munitionPanel);
        this.add(pointPanel);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setFocusable(false);

    }

}
