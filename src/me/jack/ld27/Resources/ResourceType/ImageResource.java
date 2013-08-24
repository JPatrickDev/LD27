package me.jack.ld27.Resources.ResourceType;

import me.jack.ld27.Resources.Resources;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Author: Jack
 * Date: 24/08/13
 */
// THIS DOES NOT EXIST, HONEST
public class ImageResource extends ResourceType{


    private Image resource;
    public ImageResource(String id){
        this.resource = Resources.getImageResource(id);
    }
    @Override
    public void getResource() {

    }


}
