package me.jack.ld27.States;

import me.jack.ld27.LD27Game;
import me.jack.ld27.Level.Generation.LevelGen;
import me.jack.ld27.Level.Level;
import me.jack.ld27.Render.Renderer;
import me.jack.ld27.Resources.Resources;
import org.lwjgl.input.Keyboard;
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

    private int timeRemaining = 0;
    private int lastTime = 10000;

    private int level = 1;

    public int score = 0;

    public int lifes = 3;


    //number of levels+1
    private int maxLevel = 6;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.renderer = new Renderer(this);
        levelComplete();
        Resources.init("/res/sprites.png");
    }

    int textX;
    int textY;
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setFont(LD27Game.FONT);
        //render to screen
        renderer.render(graphics, gameContainer);
        graphics.drawString("Time remaining: " + ((timeRemaining) / 1000.0), textX,textY);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        renderer.update();
        currentLevel.update();
        timeRemaining -= i;

        if(timeRemaining  <= 0){
           resetLevel();
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_RETURN))    currentLevel = LevelGen.generate(1,this);

        textX = (gameContainer.getWidth() / 2 ) - (gameContainer.getGraphics().getFont().getWidth("Time remaining: " + ((timeRemaining) / 1000)) /2);
        textY = 25;

        if(currentLevel.getPlayer().getY() > 600)resetLevel();
    }

    @Override
    public int getID() {
        return 1;
    }

    public int calculateFinalScore(){
        int timeToSpare = timeRemaining;
        int pickupsCollected = score;
        return timeToSpare * pickupsCollected;
    }

    public void levelComplete() {

        try {
            if(level == maxLevel){
                return;
            }
            currentLevel = LevelGen.loadFromPNG("/res/maps/" +  level + ".png", this);
            if(timeRemaining > 0)
            lastTime = timeRemaining;
            else
            lastTime = 10000;
            timeRemaining = timeRemaining + 10000;
            level++;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void resetLevel(){
        try {
            currentLevel = LevelGen.loadFromPNG("/res/maps/" +  (level-1) + ".png", this);
            System.out.println(lastTime);
            timeRemaining =10000+ lastTime;
            lifes--;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
