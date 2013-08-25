package me.jack.ld27.Level;


import me.jack.ld27.Entity.Entity;
import org.lwjgl.input.Keyboard;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public abstract class Gravity {

    public static final int gravity = 5;

    private int fallingSpeed = gravity;

    protected boolean falling = false;

    public void apply(Entity e){
        if(e.getYVelocity() < 0){
            return;
        }
        if(e.parent.canMove(e.getNewHitbox(0,fallingSpeed))){
          e.addY(fallingSpeed);
            fallingSpeed+=1;
            falling = true;
        }
        else{
            if(e.parent.canMove(e.getNewHitbox(0,1))){
                e.setY((int) (e.getY() +1));
            }else{
            falling = false;
            e.killVelocity();
            fallingSpeed = gravity;
            }
        }
    }

}
