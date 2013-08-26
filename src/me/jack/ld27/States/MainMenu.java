package me.jack.ld27.States;

import me.jack.JEngine.JEngine;
import me.jack.JEngine.ui.Button.Button;
import me.jack.JEngine.ui.Button.ButtonListener;
import me.jack.JEngine.ui.Menu.BasicMenu;
import me.jack.ld27.LD27Game;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Rectangle;
import java.util.HashMap;

/**
 * Author: Jack
 * Date: 25/08/13
 */
public class MainMenu extends BasicGameState implements ButtonListener {

    BasicMenu menu = new BasicMenu();
    HashMap<Rectangle, Integer> buttons = new HashMap<Rectangle, Integer>();

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        JEngine.font = LD27Game.FONT;

        menu.addTitle("Rush - LD27", gameContainer, Color.darkGray);


        menu.setListener(this);

        buttons.put(new Rectangle(getCenterX("Play", gameContainer.getGraphics()), 250, 64, 30), 1);
        buttons.put(new Rectangle(getCenterX("Credits", gameContainer.getGraphics()), 300, 64, 30), 2);
        buttons.put(new Rectangle(getCenterX("How to play", gameContainer.getGraphics()), 350, 128, 30), 3);
        buttons.put(new Rectangle(getCenterX("Exit", gameContainer.getGraphics()), 400, 64, 30), 4);
    }


    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setFont(LD27Game.FONT);
        menu.render(graphics);

        centerX(250, "Play", graphics);
        centerX(300, "Credits", graphics);
        centerX(350, "How to play", graphics);
        centerX(400, "Exit", graphics);
    }

    private void centerX(int y, String text, Graphics g) {
        int x = (JEngine.SCREEN_WIDTH / 2) - (g.getFont().getWidth(text) / 2);
        g.drawString(text, x, y);
    }

    private int getCenterX(String text, Graphics g) {
        return (JEngine.SCREEN_WIDTH / 2) - (g.getFont().getWidth(text) / 2);
    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        //    menu.update(gameContainer);

        if (Mouse.isButtonDown(0)) {
            Rectangle mouseHitbox = new Rectangle(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY(), 10, 10);
            for (Rectangle r : buttons.keySet()) {
                if (mouseHitbox.intersects(r)) {
                    int id = buttons.get(r);
                    System.out.println(id);
                    if (id == 1) {
                        stateBasedGame.enterState(1);
                    } else if (id == 2) {
                        stateBasedGame.enterState(5);
                    } else if (id == 3) {
                        stateBasedGame.enterState(4);
                    } else if (id == 4) {
                        System.exit(0);

                    }
                }
            }
        }
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void onButtonSelect(Button button) {

    }

    @Override
    public void onButtonDeselect(Button button) {

    }

    @Override
    public void onButtonActivate(Button button) {

    }
}
