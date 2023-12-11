package gui;

import items.GameUtils;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameInfoPanel extends JPanel implements ActionListener {


    public GameUtils getGameUtils() {
        return gameUtils;
    }

    final private GameUtils gameUtils;


    public JLabel getPointLabel() {
        return pointLabel;
    }

    final private JLabel pointLabel;


    private static final Color PANEL_COLOR = Color.decode("0xFDFE6");
    private static final EtchedBorder PANEL_BORDER = new EtchedBorder(EtchedBorder.RAISED);

    public GameInfoPanel() {
        super(new FlowLayout());
        this.setBackground(PANEL_COLOR);
        this.setBorder(PANEL_BORDER);
        this.gameUtils = new GameUtils();
        JPanel levelPanel = new JPanel();
        JPanel pointPanel = new JPanel();
        JPanel munitionPanel = new JPanel();
        this.pointLabel = new JLabel("Point:" + this.gameUtils.getGamePoint());
        JLabel levelLabel = new JLabel("Level:" + this.gameUtils.getLevel());
        JLabel munitionLabel = new JLabel("Munition:" + this.gameUtils.getUsedMunition());
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

    }


    public void setPointToHitTarget() {
        this.gameUtils.setGamePoint(100 + this.gameUtils.getGamePoint());
    }

    public void setPointToHitObstacle() {

        this.gameUtils.setGamePoint(50 + this.gameUtils.getGamePoint());
    }


    public void setUsedMunition() {
        this.gameUtils.setUsedMunition(1 + this.gameUtils.getUsedMunition());

    }


    public void setGameTime() {

        this.gameUtils.setGameTime(1 + this.gameUtils.getGameTime());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.pointLabel.setText("Point:" + this.gameUtils.getGamePoint());
    }
}
