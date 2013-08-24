package me.jack.ld27.Render;

import me.jack.ld27.Entity.Entity;
import me.jack.ld27.InGame;
import me.jack.ld27.Level.Items.Block;
import me.jack.ld27.Resources.Resources;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
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

    public static boolean debug = true;
    public void render(Graphics g, GameContainer container) {

        for (Drawable drawable : drawables) {
            if(drawable == null)continue;
            Image image = Resources.getImageResource(drawable.getResourceId());
            if (drawable instanceof Block) {
                Block b = (Block) drawable;
                g.drawImage(image, (b.getX() *32) - parent.currentLevel.camera.x, (b.getY() *32) - parent.currentLevel.camera.y);
            }
            if(drawable instanceof Entity){
                Entity e = (Entity)drawable;
                g.drawImage(image,e.getX() - parent.currentLevel.camera.x,e.getY() - parent.currentLevel.camera.y);
            }

        }
        if(debug){
           Rectangle2D.Float rect =  parent.currentLevel.getPlayer().getNewHitbox(0,0);
            g.setColor(Color.red);
            g.drawRect(rect.x - parent.currentLevel.camera.x,rect.y - parent.currentLevel.camera.y,rect.width,rect.height);
            g.setColor(Color.white);
        }
    }

    public void update() {
        drawables.clear();
        drawables.addAll(parent.currentLevel.getDrawables());
    }
}
