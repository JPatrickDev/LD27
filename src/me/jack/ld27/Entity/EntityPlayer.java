package me.jack.ld27.Entity;

import me.jack.ld27.Level.Level;
import me.jack.ld27.Render.Animation;
import me.jack.ld27.Render.Drawable;
import org.lwjgl.input.Keyboard;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class EntityPlayer extends Entity implements Drawable{

    Animation runLeft;
    Animation runRight;
    Animation jump;
    Animation fall;
    Animation standing;
    Animation current;

    public EntityPlayer(int x, int y,Level parent) {
        super(x, y,parent);
        this.width = 32;
        this.height = 30;
        standing = new Animation(this,60,new String[]{"playerStanding"});

        runLeft = new Animation(this,60,new String[]{"playerLeft1","playerLeft2","playerLeft3","playerLeft4"});
        runRight = new Animation(this,60,new String[]{"playerRight1","playerRight2","playerRight3","playerRight4"});
        jump = new Animation(this,60,new String[]{"playerJump1","playerJump2","playerJump3","playerJump4"});
        fall = new Animation(this,60,new String[]{"playerFall1","playerFall2","playerFall3","playerFall4"});
    }

    @Override
    public void update() {
        super.update();
        this.apply(this);
        checkMovement();
    }
    private boolean floating()
    {

     return false;//   return !parent.canMove(getNewHitbox(0,32));
    }

    //TODO: Gravity needs to make player flush with the floor, not floating a bit
    private void checkMovement(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){

            if(!falling && !floating()){

            if(getYVelocity() >= 0 )
            this.addY(-72);
            }
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A))this.addX((float)-5);
        if(Keyboard.isKeyDown(Keyboard.KEY_D))this.addX((float)5);
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
