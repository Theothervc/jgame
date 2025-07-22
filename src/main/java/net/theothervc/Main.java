package net.theothervc;


import net.theothervc.jgame.game.Game;
import net.theothervc.jgame.game.GameLoop;
import net.theothervc.jgame.game.GamePanelAspectLocked;

import java.awt.*;

public class Main{


    public static void main(String[] args) {
        TitleScene scene1 = new TitleScene();
        GameLoop loop = new GameLoop(60,scene1);
        GamePanelAspectLocked panel = new GamePanelAspectLocked(new Dimension(16,9));
        Game game = new Game("TEST",new Dimension(1920,1080),panel,loop);
        loop.changeSceneKeyListener(scene1);
        game.start();

    }
}