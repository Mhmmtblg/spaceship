package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JFrame {
    private final JFrame gameFrame;
    private final GamePanel gamePanel;
    private final GameInfoPanel gameInfoPanel;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(800, 700);

    public GameScreen() {
        this.gameFrame = new JFrame("Spaceship Game");
        this.gameFrame.setLayout(new BorderLayout());
        final JMenuBar screenMenuBar = createMenuBar();
        this.gameFrame.setJMenuBar(screenMenuBar);
        this.gameFrame.setResizable(false);
        this.gameFrame.setFocusable(false);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gamePanel = new GamePanel();
        this.gameInfoPanel = new GameInfoPanel();
        this.gameFrame.add(this.gameInfoPanel, BorderLayout.NORTH);
        this.gameFrame.add(this.gamePanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
    }


    private JMenuBar createMenuBar() {
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openPGN = new JMenuItem("Load PGN File");
        openPGN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open up that pgn file!");
            }
        });
        fileMenu.add(openPGN);

        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        return fileMenu;
    }


}
