package net.theothervc.jgame.game;

public class GameLoop implements Runnable {

    private Thread gt;
    private int fps;

    public GameLoop(int framesPerSecond) {
        this(framesPerSecond,new Thread("GameThread"));

    }

    public GameLoop(int framesPerSecond,Thread gameThread) {
        fps = framesPerSecond;
        gt = gameThread;
    }

    @Override
    public void run() {

    }
}
