package me.gleeming.gengine.loop.types;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.camera.effect.CameraEffect;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.game.provider.type.DesktopProvider;
import me.gleeming.gengine.loop.GameLoop;
import me.gleeming.gengine.math.Rectangle;
import me.gleeming.gengine.resource.type.DesktopResource;
import me.gleeming.gengine.screen.menu.MenuScreen;
import me.gleeming.gengine.screen.menu.button.Button;
import me.gleeming.gengine.screen.menu.text.TextController;
import me.gleeming.gengine.screen.menu.text.entry.TextEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DesktopGameLoop extends Frame implements MouseListener, MouseMotionListener, KeyListener, GameLoop {
    @Getter private static Graphics2D drawTo;

    private final Graphics bufferGraphics;
    private final Image offscreen;
    public DesktopGameLoop(int width, int height, DesktopResource windowImage, String windowName) {
        setSize(width, height);
        setTitle(windowName);
        setVisible(true);
        setResizable(false);

        setLocation((int) (getToolkit().getScreenSize().getWidth() - getWidth()) / 2, (int) (getToolkit().getScreenSize().getHeight() - getHeight()) / 2);

        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        offscreen = createImage(getWidth(),getHeight());
        bufferGraphics = offscreen.getGraphics();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new Thread() {
            public void run() {
                while (true) {
                    repaint();
                    try { Thread.sleep(17); } catch (Exception ex) { ex.printStackTrace(); }
                }
            }
        }.start();
    }

    public void update(Graphics g) {
        this.paint(g);

        for (CameraEffect cameraEffect : new ArrayList<>(Gengine.getInstance().getCamera().getCurrentEffeects())) cameraEffect.update();
    }

    public void paint(Graphics g) {
        bufferGraphics.clearRect(0,0, getWidth(), getHeight());

        if(Gengine.getInstance() == null || Gengine.getInstance().getCurrentScreen() == null) return;

        for (DrawQueue queue : Gengine.getInstance().getCurrentScreen().draw(new ArrayList<>())) {
            int cameraX = DesktopProvider.getCamera().getX();
            int cameraY = DesktopProvider.getCamera().getY();

            int gameWidth = Gengine.getInstance().getGameProvider().getWidth();
            int gameHeight = Gengine.getInstance().getGameProvider().getHeight();

            drawTo = (Graphics2D) bufferGraphics;

            if(queue.getX() + queue.getWidth() >= cameraX && cameraX + gameWidth >= queue.getX() - queue.getWidth() && queue.getY() + queue.getHeight() >= cameraY && cameraY + gameHeight >= queue.getY()) {
                queue.draw(queue.getX() + cameraX, queue.getY() + cameraY);
            }
        }

        g.drawImage(offscreen,0,0,this);
    }

    public void keyPressed(KeyEvent e) { DesktopProvider.getInput().getPressedHashMap().put(translateKeyboard(String.valueOf(e.getKeyChar())), true); }
    public void keyReleased(KeyEvent e) { DesktopProvider.getInput().getPressedHashMap().put(translateKeyboard(String.valueOf(e.getKeyChar())), false); }
    public void mouseReleased(MouseEvent e) { DesktopProvider.getInput().getPressedHashMap().put(translateMouse(String.valueOf(e.getButton())), false); }

    public void mousePressed(MouseEvent e) {
        if(Gengine.getInstance().getCurrentScreen() != null && Gengine.getInstance().getCurrentScreen() instanceof MenuScreen) {
            MenuScreen menuScreen = (MenuScreen) Gengine.getInstance().getCurrentScreen();
            Rectangle mouseRect = new Rectangle(e.getX(), e.getY(), 5, 5);
            for (Button button : ((MenuScreen) Gengine.getInstance().getCurrentScreen()).getButtons()) {
                if(button.getRectangle().colliding(mouseRect)) for (Button.Listener listener : button.getListeners()) listener.buttonClick();
            }

            for (TextController textController : menuScreen.getTextControllers()) {
                boolean selected = false;
                for(TextEntry entry : textController.getEntries()) {
                    if(entry.getRectangle().colliding(mouseRect)) {
                        textController.setSelectedEntry(entry);
                        selected = true;

                        break;
                    }
                }

                if(!selected) textController.setSelectedEntry(null);
            }
        }

        DesktopProvider.getInput().getPressedHashMap().put(translateMouse(String.valueOf(e.getButton())), true);
    }

    public void mouseMoved(MouseEvent e) {
        if(Gengine.getInstance().getCurrentScreen() != null && Gengine.getInstance().getCurrentScreen() instanceof MenuScreen) {
            Rectangle mouseRect = new Rectangle(e.getX(), e.getY(), 5, 5);
            for (Button button : ((MenuScreen) Gengine.getInstance().getCurrentScreen()).getButtons()) {
                if(button.getRectangle().colliding(mouseRect)) button.setHovering(true);
                else if(button.isHovering()) button.setHovering(false);
            }
        }
    }

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

    public void mouseDragged(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void keyTyped(KeyEvent e) {
        if(Gengine.getInstance().getCurrentScreen() != null && Gengine.getInstance().getCurrentScreen() instanceof MenuScreen) {
            MenuScreen menuScreen = (MenuScreen) Gengine.getInstance().getCurrentScreen();

            for (TextController textController : menuScreen.getTextControllers()) {
                if(textController.getSelectedEntry() != null) {
                    textController.getSelectedEntry().setText(textController.getSelectedEntry().getText() + String.valueOf(e.getKeyChar()));
                }
            }
        }

    }
}
