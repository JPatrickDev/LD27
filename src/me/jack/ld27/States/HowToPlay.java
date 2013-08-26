package me.jack.ld27.States;

import me.jack.ld27.LD27Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 26/08/13
 */
public class HowToPlay extends BasicGameState {
    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
      //  graphics.setFont(LD27Game.smaller);
        graphics.drawString("The aim of rush is to complete each level in as little time as possible.", 5, 50);
        graphics.drawString("You get 10 seconds to complete each level + Any time you had left from the last level",5,150);
        graphics.drawString("In order to increase your score, you can collect the coins along the way",5,200);
        graphics.drawString("But be careful! Sometimes coins can make you go out of your way,\nand you may run out of time.",5,250);
        graphics.drawString("WAD to move A = LEFT, D = RIGHT,W to jump.",5,300);
        graphics.drawString("To complete a level, get from one Gate to the other!",5,350);
        graphics.drawString("You have 3 lives to complete the game. Falling from the level or running out of time",5,400);
        graphics.drawString("will remove a life",5,450);
        graphics.drawString("Complete all 10 levels to win!",5,500);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
