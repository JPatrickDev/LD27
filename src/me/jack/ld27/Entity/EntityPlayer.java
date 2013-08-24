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
        checkMovement();
    }
    private boolean floating()
    {
        return !parent.canMove(getNewHitbox(0,1));
    }

    //TODO: Gravity needs to make player flush with the floor, not floating a bit
    private void checkMovement(){
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && !falling && !floating()){
            if(getYVelocity() <= 0 )
            this.addY(-30);
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A))this.addX(-5);
        if(Keyboard.isKeyDown(Keyboard.KEY_D))this.addX(5);
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
