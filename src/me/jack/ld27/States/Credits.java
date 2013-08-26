package me.jack.ld27.States;

import me.jack.JEngine.JEngine;
import me.jack.ld27.LD27Game;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 26/08/13
 */
public class Credits extends BasicGameState {


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setFont(LD27Game.FONT);
        centerX(200,"Credits",graphics);
        centerX(250,"Rush was made for Ludum Dare 27",graphics);
        centerX(350,"All code + art was made within 48 hours",graphics);
        centerX(400,"Made by Jack Patrick",graphics);
        centerX(500,"Thank you for playing!",graphics);

    }

    private void centerX(int y,String text,Graphics g){
        int x = (JEngine.SCREEN_WIDTH / 2) - (g.getFont().getWidth(text)/2);
        g.drawString(text,x,y);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            stateBasedGame.enterState(1);
        }
    }

    @Override
    public int getID() {
        return 5;
    }
}
