package me.jack.ld27.Render;

import me.jack.ld27.InGame;
import me.jack.ld27.Level.Items.Block;
import me.jack.ld27.Resources.Resources;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class Renderer {

    private InGame parent;

    private List<Drawable> drawables = new ArrayList<Drawable>();

    public Renderer(InGame parent) {
        this.parent = parent;
    }

    public void render(Graphics g, GameContainer container) {
        for(int i = 0;i!= drawables.size();i++){
            System.out.println(drawables.get(i));
        }
        for (Drawable drawable : drawables) {
            if(drawable == null)continue;
            Image image = Resources.getImageResource(drawable.getResourceId());
            if (drawable instanceof Block) {
                Block b = (Block) drawable;
                g.drawImage(image, b.getX() *32, b.getY() *32);
            }

        }
    }

    public void update() {
        drawables.clear();
        drawables.addAll(parent.currentLevel.getDrawables());
    }
}
