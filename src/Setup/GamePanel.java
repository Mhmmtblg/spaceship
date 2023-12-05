package Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    Timer timer = new Timer(5, this);
    private int pastTime = 0;
    private int firedMunition = 0;


    private ArrayList<Munition> munitions = new ArrayList<Munition>();

    // private final static Dimension GAME_PANEL_DIMENSION = new Dimension(400, 450);

    private SpaceShip spaceShip;
    private Target target;


    public GamePanel() {

        requestFocus();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.spaceShip = new SpaceShip();
        this.target = new Target();
        setBackground(Color.BLACK);

        validate();
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.red);
        g.fillOval(target.getCoordinateX(), target.getCoordinateY(), 20, 20);
        g.drawImage(spaceShip.getSpaceShipImage(), spaceShip.getCoordinateX(), spaceShip.getCoordinateY(),
                spaceShip.getImageWidth(), spaceShip.getImageHeight(), this);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            this.spaceShip.moveShipLeft();
        } else if (c == KeyEvent.VK_RIGHT) {
            this.spaceShip.moveShipRight();
        } else if (c == KeyEvent.VK_UP) {
            this.spaceShip.moveShipUp();
        } else if (c == KeyEvent.VK_DOWN) {
            this.spaceShip.moveShipDown();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.target.moveTarget();
        repaint();

    }


}
