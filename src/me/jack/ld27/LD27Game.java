package me.jack.ld27;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class LD27Game extends StateBasedGame{


    public LD27Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new InGame());
    }

}
