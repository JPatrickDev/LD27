package me.jack.ld27.Render;

import me.jack.ld27.Entity.Entity;

/**
 * Author: Jack
 * Date: 25/08/13
 */
public class Animation {

    private Entity parent;
    private int framesPerFrame;
    private String[] resourceIds;
    private int currentFrame= 0;
    private int drawFor = 0;
    public int id;

    public Animation(Entity parent, int framesPerFrame,String[] resourceIds, int id){
        this.parent = parent;
        this.resourceIds = resourceIds;
        this.framesPerFrame = framesPerFrame;
        this.id = id;
    }

    public void tick(){
        drawFor++;
        if(drawFor >= framesPerFrame){
            if(currentFrame == resourceIds.length-1)currentFrame = 0;
            else currentFrame++;
            drawFor = 0;
        }
    }

   public String getCurrentFrame(){
       return resourceIds[currentFrame];
   }
}
