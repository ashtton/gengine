package me.gleeming.gengine.loop;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.camera.GengineCamera;
import me.gleeming.gengine.input.GengineInput;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameLoop extends Frame implements MouseListener, KeyListener {
    @Getter private static GameLoop instance;

    private final Graphics bufferGraphics;
    private final Image offscreen;
    public GameLoop() {
        instance = this;

        setSize(Gengine.getInstance().getWidth(), Gengine.getInstance().getHeight());
        setTitle(Gengine.getInstance().getWindowName());
        setVisible(true);
        setResizable(false);

        addMouseListener(this);
        addKeyListener(this);

        offscreen = createImage(getWidth(),getHeight());
        bufferGraphics = offscreen.getGraphics();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new Thread(() -> {
            while(true) {
                repaint();
                try { Thread.sleep(17); } catch(Exception ex) { ex.printStackTrace(); }
            }
        }).start();
    }

    public void update(Graphics g) { this.paint(g); }

    public void paint(Graphics g) {
        bufferGraphics.clearRect(0,0, getWidth(), getHeight());

        if(Gengine.getInstance() == null || Gengine.getInstance().getCurrentScreen() == null) return;

        Gengine.getInstance().getCurrentScreen().draw(new ArrayList<>()).forEach(queue -> {
            int cameraX = GengineCamera.getInstance().getX();
            int cameraY = GengineCamera.getInstance().getY();

            int gameWidth = Gengine.getInstance().getWidth();
            int gameHeight = Gengine.getInstance().getHeight();

            if(queue.getX() + queue.getWidth() >= cameraX && cameraX + gameWidth >= queue.getX() - queue.getWidth() && queue.getY() + queue.getHeight() >= cameraY && cameraY + gameHeight >= queue.getY()) {
                queue.draw((Graphics2D) bufferGraphics, queue.getX() + cameraX, queue.getY() + cameraY);
            }
        });

        g.drawImage(offscreen,0,0,this);
    }

    public void keyPressed(KeyEvent e) { GengineInput.getInstance().getPressedHashMap().put(translateKeyboard(String.valueOf(e.getKeyChar())), true); }

    public void keyReleased(KeyEvent e) { GengineInput.getInstance().getPressedHashMap().put(translateKeyboard(String.valueOf(e.getKeyChar())), false); }

    public void mousePressed(MouseEvent e) { GengineInput.getInstance().getPressedHashMap().put(translateMouse(String.valueOf(e.getButton())), true); }

    public void mouseReleased(MouseEvent e) { GengineInput.getInstance().getPressedHashMap().put(translateMouse(String.valueOf(e.getButton())), false); }

    public String translateKeyboard(String s) {
        if(s.equals(" ")) return "space";
        else return s;
    }

    public String translateMouse(String s) {
        switch (s) {
            case "1":
                return "left-click";
            case "2":
                return "middle-click";
            case "3":
                return "right-click";
            case "4":
                return "mouse-four";
            case "5":
                return "mouse-five";
            default:
                return "mouse-six";
        }
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void keyTyped(KeyEvent e) { }
}
