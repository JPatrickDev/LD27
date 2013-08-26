package me.jack.ld27;

import me.jack.ld27.States.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class LD27Game extends StateBasedGame {


    public LD27Game(String name) {
        super(name);
    }

    public static TrueTypeFont FONT;
    public static TrueTypeFont smaller;
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MainMenu());
        this.addState(new InGame());
        this.addState(new GameOver());
        this.addState(new VictoryScreen());
        this.addState(new HowToPlay());
        this.addState(new Credits());

        try {
            FONT = new TrueTypeFont(Font.createFont(0, getClass().getResourceAsStream("/me/jack/ld27/Render/AgentOrange.ttf")).deriveFont(25f),false);
            smaller = new TrueTypeFont(Font.createFont(0, getClass().getResourceAsStream("/me/jack/ld27/Render/AgentOrange.ttf")).deriveFont(15f),false);
          } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
