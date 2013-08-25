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
    public Animation(Entity parent, int framesPerFrame,String[] resourceIds){
        this.parent = parent;
        this.resourceIds = resourceIds;
        this.framesPerFrame = framesPerFrame;
    }

    public void tick(){
        drawFor++;
        if(drawFor == framesPerFrame){
            if(currentFrame == resourceIds.length)currentFrame = 0;
            else currentFrame++;
        }
    }

   public String getCurrentFrame(){
       return resourceIds[currentFrame];
   }
}
