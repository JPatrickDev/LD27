package me.jack.ld27.Entity;

import me.jack.ld27.Level.Gravity;
import me.jack.ld27.Level.Level;

import java.awt.geom.Rectangle2D;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public abstract class Entity extends Gravity {

    private float x;
    private float y;

    private float xVelocity;
    private float yVelocity;

    public Level parent;
    public int width = 32;
    public int height = 32;

    public Entity(int x, int y, Level parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public void update() {
        if (xVelocity > 50) xVelocity = 50;
        if (yVelocity > 50) yVelocity = 50;
        if (parent.canMove(getNewHitbox(xVelocity,0))) {
            x += xVelocity;
        }else{
            xVelocity = 0;
        }

        if(parent.canMove(getNewHitbox(0,yVelocity))){
            y += yVelocity;
        }else{
            yVelocity = 0;
        }


        xVelocity *= 0.2;
        yVelocity *= 0.2;

        xVelocity = Math.round(xVelocity * 100) / 100;
        yVelocity = Math.round(yVelocity * 100) / 100;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void addY(float y) {
        this.yVelocity += y;
    }

    public void addX(float x) {
        this.xVelocity += x;
    }

    public Rectangle2D.Float getNewHitbox(float x, float y) {
        return new Rectangle2D.Float(this.x + x, this.y + y, width, height);
    }

    public void killVelocity() {
        yVelocity = 0;
        //  xVelocity =0;

    }


    public float getYVelocity() {
        return yVelocity;
    }

    public  void killAllVelocity(){
        xVelocity = 0;
        yVelocity = 0;
    }
}
