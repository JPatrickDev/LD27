package me.jack.ld27.Level.Items;

import me.jack.ld27.Render.Drawable;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class Block implements Drawable{

    private int id;
    private boolean solid;
    private String imgPath;

    public Block(int id, boolean solid) {
        this.id = id;
        this.solid = solid;
    }

    public void setPath(String path) {
        this.imgPath = path;
    }


    @Override
    public String getPath() {
        return imgPath;
    }

    @Override
    public boolean shouldRender() {
     return true;
    }
}
