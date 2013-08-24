package me.jack.ld27.Level;

import me.jack.ld27.Entity.EntityPlayer;
import me.jack.ld27.Level.Items.Block;
import me.jack.ld27.Level.Items.Blocks;
import me.jack.ld27.Render.Drawable;

import java.awt.Rectangle;
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

    private EntityPlayer player;

    public ArrayList<Rectangle> collisions = new ArrayList<Rectangle>();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Block[width*height];
    }

    public void setPlayer(EntityPlayer p){

        this.player = p;
    }

    public EntityPlayer getPlayer(){
        return player;
    }


    public void setBlock(int x, int y, Block block) {
        block.setX(x);
        block.setY(y);
        tiles[x+y*width] = block;
        if(block.isSolid()){
            collisions.add(new Rectangle(x * 32,y * 32,32,32));
        }
    }

    public List<Drawable> getDrawables(){
        List<Drawable> drawables = new ArrayList<Drawable>();
        for(int i = 0;i!= tiles.length;i++){
            drawables.add(tiles[i]);
        }
        drawables.add(getPlayer());
        return drawables;
    }

    public void update() {
        getPlayer().update();

    }

    public boolean canMove(Rectangle hitbox){
        for(Rectangle collision : collisions){
            if(hitbox.intersects(collision)){return false;}
        }
        return true;
    }
}
