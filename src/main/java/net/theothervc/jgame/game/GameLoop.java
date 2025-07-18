package net.theothervc.jgame.game;

import java.awt.event.KeyListener;


public class GameLoop implements Runnable {

    private Thread gt;
    private final double fps;
    private final double pt;
    public Scene currentScene;
    public Game parent;
    public GamePanelClass gamePanel;
    public KeyListener keyListener = null;

    public GameLoop(int framesPerSecond, Scene defaultScene) {
        fps = framesPerSecond;
        pt = 1000000000/fps;
        gt = new Thread(this);
        currentScene = defaultScene;
    }

    public void start() {
        gt.start();
    }

    public void exit() {
        gt = null;
    }

    public void changeSceneKeyListener(KeyListener newListener) {
        if (keyListener != null) gamePanel.canvas.removeKeyListener(keyListener);
        gamePanel.canvas.addKeyListener(newListener);
        keyListener = newListener;
    }

    public void changeScene(Scene newScene) {
        currentScene = newScene;
    }

    @Override
    public void run() {
      double lt = System.nanoTime();
      double dt = 0;
        while (gt != null) {
            double ct = System.nanoTime();
            dt += (ct - lt)/pt;
            lt = ct;
            if (dt >= 1) {
                update();
                draw();
                dt--;
            }


        }
    }


   private void update() {
    currentScene.update();
   }

   private void draw() {
    gamePanel.canvas.repaint();
   }
}
