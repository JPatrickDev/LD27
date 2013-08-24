package me.jack.ld27.Level;

import me.jack.JEngine.Level.Camera;
import me.jack.ld27.Entity.EntityPlayer;
import me.jack.ld27.InGame;
import me.jack.ld27.Level.Items.Block;
import me.jack.ld27.Level.Items.Blocks;
import me.jack.ld27.Render.Drawable;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
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

    public Camera camera;

    Point startGate;
    Point endGate;

    public ArrayList<Rectangle> collisions = new ArrayList<Rectangle>();

    private InGame parent;
    public Level(int width, int height,InGame parent) {
        this.width = width;
        this.height = height;
        tiles = new Block[width*height];
        camera = new Camera(0,0,800,600,32);
        this.parent = parent;
    }


    public void setPlayer(EntityPlayer p){

        this.player = p;
    }

    public EntityPlayer getPlayer(){
        return player;
    }


    public void setBlock(int x, int y, Block block) {
        try{
        block.setX(x);
        block.setY(y);
        tiles[x+y*width] = block;
        if(block.isSolid()){
            collisions.add(new Rectangle(x * 32, y * 32, 32, 32));
        }
        }catch(Exception e){}
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
        camera.centerOnPlayer((int)getPlayer().getX(),(int)getPlayer().getY(),width,height);

        Rectangle endGate = new Rectangle((int)getEndGate().getX() * 32,(int)getEndGate().getY() * 32,32,32);
        if(endGate.intersects(getPlayer().getNewHitbox(0,0))){
            parent.levelComplete();
        }
    }

    public boolean canMove(Rectangle2D.Float hitbox){
        if((int)hitbox.x > (width*32-(int)hitbox.width) ||(int)hitbox.x < 0)return false;
        if((int)hitbox.y > (600 - (int)hitbox.height) ||(int)hitbox.y < 0)return false;
        for(Rectangle collision : collisions){
            if(hitbox.intersects(collision)){return false;}
        }
        return true;
    }


    public void restart(){
      /* getPlayer().setX(((int)getStartGate().getX() + 1)*32);
        getPlayer().setY((int)getStartGate().getY()*32 - 10);
        getPlayer().killAllVelocity();
        getPlayer().apply(getPlayer());*/
    }

    public void setFirstGate(int x,int y){
        startGate = new Point(x,y);
    }

    public void setSecondGate(int x,int y){
        endGate = new Point(x,y);
    }

    public Point getEndGate() {
        return endGate;
    }

    public Point getStartGate() {
        return startGate;
    }


}
