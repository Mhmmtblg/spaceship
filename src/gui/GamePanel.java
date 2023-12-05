package gui;

import items.Obstacle;
import items.Munition;
import items.SpaceShip;
import items.Target;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    Timer timer = new Timer(5, this);


    private ArrayList<Munition> munitions = new ArrayList<Munition>();
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    // private final static Dimension GAME_PANEL_DIMENSION = new Dimension(400, 450);

    private SpaceShip spaceShip;
    private Target target;
    private GameUtils gameUtils;

    public GamePanel() {

        requestFocus();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.spaceShip = new SpaceShip();
        this.target = new Target();
        this.gameUtils = new GameUtils();
        setBackground(Color.BLACK);

        validate();
        timer.start();

    }

    public void checkIntersection() {
        for (var munition : munitions) {
            if (new Rectangle(munition.getCoordinateX(), munition.getCoordinateY(), 10, 20).
                    intersects(new Rectangle(target.getCoordinateX(), target.getCoordinateY(), 20, 20))) {
                target.setIntersected(true);
                munition.setIntersected(true);
                gameUtils.setPointToHitTarget();

            }
            for (var obstacle : obstacles) {
                if (new Rectangle(munition.getCoordinateX(), munition.getCoordinateY(), 10, 20).
                        intersects(new Rectangle(obstacle.getCoordinateX(), obstacle.getCoordinateY(),
                                obstacle.getImageWidth(), obstacle.getImageHeight()))) {
                    obstacle.setIntersected(true);
                    munition.setIntersected(true);
                    gameUtils.setPointToHitObstacle();

                }

            }


        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        checkIntersection();


        g.setColor(Color.red);
        g.fillOval(target.getCoordinateX(), target.getCoordinateY(), 20, 20);
        g.drawImage(spaceShip.getSpaceShipImage(), spaceShip.getCoordinateX(), spaceShip.getCoordinateY(),
                spaceShip.getImageWidth(), spaceShip.getImageHeight(), this);

        if (gameUtils.getGameTime() % 100 == 0) {
            obstacles.add(new Obstacle());
        }

        for (var obstacle : obstacles) {
            if (obstacle.isPassed() || obstacle.isIntersected()) {
                obstacles.remove(obstacle);
                continue;
            }
            g.drawImage(obstacle.getObstacleImage(), obstacle.getCoordinateX(), obstacle.getCoordinateY(),
                    obstacle.getImageWidth(), obstacle.getImageHeight(), this);

        }

        g.setColor(Color.BLUE);
        for (var munition : munitions) {
            if (munition.isMissed() || munition.isIntersected()) {
                munitions.remove(munition);
                continue;
            }
            g.fillRect(munition.getCoordinateX(), munition.getCoordinateY(), 10, 20);
        }


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
        } else if (c == KeyEvent.VK_SPACE) {
            munitions.add(new Munition(this.spaceShip.getCoordinateX() + 25, this.spaceShip.getCoordinateY() - 10));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameUtils.setGameTime();
        for (var munition :
                munitions) {
            munition.moveMunition();
        }
        target.moveTarget();
        for (var obstacle : obstacles) {
            obstacle.moveObstacle();
        }

        repaint();

    }


}
