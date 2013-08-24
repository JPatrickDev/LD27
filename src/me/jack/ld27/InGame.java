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

import java.awt.Rectangle;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class InGame extends BasicGameState{


    private static Renderer renderer;

    public Level currentLevel;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.renderer = new Renderer(this);
        currentLevel = LevelGen.generate(1);
        Resources.init("/res/sprites.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //render to screen
        renderer.render(graphics,gameContainer);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        renderer.update();
        currentLevel.update();
    }

    @Override
    public int getID() {
        return 1;
    }
}
