package me.jack.ld27;

import me.jack.ld27.Level.Generation.LevelGen;
import me.jack.ld27.Level.Level;
import me.jack.ld27.Render.Renderer;
import me.jack.ld27.Resources.Resources;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class InGame extends BasicGameState {


    private static Renderer renderer;

    public Level currentLevel;

    private int timeRemaining = 10000;

    private int level = 1;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.renderer = new Renderer(this);
        currentLevel = LevelGen.loadFromPNG("/res/maps/1.png", this);
        Resources.init("/res/sprites.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //render to screen
        renderer.render(graphics, gameContainer);
        graphics.drawString("Time remaining: " + ((timeRemaining) / 1000.0), 350, 50);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        renderer.update();
        currentLevel.update();
        timeRemaining -= i;

        if(timeRemaining  <= 0){
            currentLevel.restart();
        }
    }

    @Override
    public int getID() {
        return 1;
    }

    public void levelComplete() {
        level++;
        try {
            currentLevel = LevelGen.loadFromPNG("/res/maps/1.png", this);
            timeRemaining = timeRemaining + 10000;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
