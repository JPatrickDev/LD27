package me.jack.ld27.Level;


import me.jack.ld27.Entity.Entity;
import org.lwjgl.input.Keyboard;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public abstract class Gravity {

    public static final int gravity = 5;


    public void apply(Entity e){
        if(e.parent.canMove(e.getNewHitbox(0,gravity)))
          e.addY(gravity);
        else
            e.killVelocity();
    }

}
