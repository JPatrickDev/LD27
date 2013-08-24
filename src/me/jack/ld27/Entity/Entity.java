package me.jack.ld27.Entity;

import me.jack.ld27.Level.Gravity;
import me.jack.ld27.Level.Level;

import java.awt.Rectangle;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public abstract class Entity extends Gravity {

    private int x;
    private int y;

    private int xVelocity;
    private int yVelocity;

    public Level parent;

    public Entity(int x, int y,Level parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public void update(){
        if(xVelocity > 50)xVelocity = 50;
        if(yVelocity > 50)yVelocity = 50;
        x+=xVelocity;
        y+=yVelocity;

        xVelocity*=0.2;
        yVelocity*=0.2;

    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void addY(int y)
    {
        this.yVelocity+=y;
    }

    public Rectangle getNewHitbox(int x, int y) {
        return new Rectangle(this.x + x, this.y + y,32,32);
    }

    public void killVelocity() {
        yVelocity =0;
        xVelocity = 0;

    }
}
