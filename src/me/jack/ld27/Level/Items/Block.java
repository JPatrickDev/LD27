package me.jack.ld27.Level.Items;

import me.jack.ld27.Render.Drawable;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class Block implements Drawable{

    private int id;
    private boolean solid;
    private String humanName;
    private String resourceId;


    private int x;
    private int y;

    public Block(Blocks type) {
        this.id = type.getId();
        this.solid = type.isSolid();
        this.humanName = type.getHumanName();
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }


    @Override
    public String getResourceId() {
        return resourceId;
    }

    @Override
    public boolean shouldRender() {
     return true;
    }

    public int getId() {
        return id;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSolid() {
        return solid;
    }
}
