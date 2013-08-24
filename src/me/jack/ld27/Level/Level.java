package me.jack.ld27.Level;

import me.jack.ld27.Level.Items.Block;
import me.jack.ld27.Level.Items.Blocks;
import me.jack.ld27.Render.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class Level {

    private Block[] tiles;

    private int width;
    private int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Block[width*height];
    }


    public void setBlock(int x, int y, Block block) {
        block.setX(x);
        block.setY(y);
        tiles[x+y*width] = block;
    }

    public List<Drawable> getDrawables(){
        List<Drawable> drawables = new ArrayList<Drawable>();
        for(int i = 0;i!= tiles.length;i++){
            drawables.add(tiles[i]);
        }
        return drawables;
    }
}
