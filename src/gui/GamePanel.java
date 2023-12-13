package gui;

import items.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener {


    final private ArrayList<Munition> munitions = new ArrayList<Munition>();
    final private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    // private final static Dimension GAME_PANEL_DIMENSION = new Dimension(400, 450);

    final private SpaceShip spaceShip;
    final private Target target;


    public int getHitPoint() {
        return hitPoint;
    }

    private int hitPoint;

    public int getUsedMunition() {
        return usedMunition;
    }

    private int usedMunition;

    public GamePanel() {

        requestFocus();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        this.spaceShip = new SpaceShip();
        this.target = new Target();
        setBackground(Color.BLACK);
        this.hitPoint = 0;
        this.usedMunition = 0;

    }

    public void checkIntersection() {

        for (int index = 0; index < munitions.size(); index++) {
            if (new Rectangle(munitions.get(index).getCoordinateX(), munitions.get(index).getCoordinateY(), 10, 20).
                    intersects(new Rectangle(target.getCoordinateX(), target.getCoordinateY(), 20, 20))) {
                target.setIntersected(true);
                munitions.get(index).setIntersected(true);
                hitPoint += 100;
            }
            for (int i = 0; i < obstacles.size(); i++) {
                if (new Rectangle(munitions.get(index).getCoordinateX(), munitions.get(index).getCoordinateY(), 10, 20).
                        intersects(new Rectangle(obstacles.get(i).getCoordinateX(), obstacles.get(i).getCoordinateY(),
                                obstacles.get(i).getImageWidth(), obstacles.get(i).getImageHeight()))) {
                    obstacles.get(i).setIntersected(true);
                    munitions.get(index).setIntersected(true);
                    hitPoint += 50;
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


        for (int index = 0; index < obstacles.size(); index++) {
            if (obstacles.get(index).isPassed() || obstacles.get(index).isIntersected()) {
                obstacles.remove(index);
                continue;
            }

            g.drawImage(obstacles.get(index).getObstacleImage(), obstacles.get(index).getCoordinateX(), obstacles.get(index).getCoordinateY(),
                    obstacles.get(index).getImageWidth(), obstacles.get(index).getImageHeight(), this);

        }

        g.setColor(Color.BLUE);
        for (int index = 0; index < munitions.size(); index++) {
            if (munitions.get(index).isMissed() || munitions.get(index).isIntersected()) {
                munitions.remove(index);
                continue;
            }
            g.fillRect(munitions.get(index).getCoordinateX(), munitions.get(index).getCoordinateY(), 10, 20);
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
            usedMunition += 1;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void addObstacles(int Time) {
        if (Time % 100 == 0) {
            this.obstacles.add(new Obstacle());
        }

    }

    public void actionPerformed(int Time) {
        addObstacles(Time);
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
