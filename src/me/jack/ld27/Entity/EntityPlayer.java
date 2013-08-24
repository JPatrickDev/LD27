package me.jack.ld27.Entity;

import me.jack.ld27.Level.Level;
import me.jack.ld27.Render.Drawable;
import org.lwjgl.input.Keyboard;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class EntityPlayer extends Entity implements Drawable{

    public EntityPlayer(int x, int y,Level parent) {
        super(x, y,parent);
    }

    @Override
    public void update() {
        super.update();
        this.apply(this);
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            this.addY(-25);
        }
    }

    @Override
    public String getResourceId() {
        return "player";
    }

    @Override
    public boolean shouldRender() {
        return true;
    }



}
