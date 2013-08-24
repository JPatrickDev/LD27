package me.jack.ld27.Resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class Resources {

    public static final HashMap<String, Image> imageResources = new HashMap<String, Image>();
    public static final HashMap<String, Sound> soundResources = new HashMap<String, Sound>();


    public static int sheetWidth;

    public static int sheetHeight;

    private static SpriteSheet sheet;


    public static void init(String spriteSheet) throws SlickException {
        Image i = new Image("/res/sprites.png");
        sheet = new SpriteSheet(i, 32, 32);
        sheetWidth = i.getWidth() / 32;
        sheetHeight = i.getHeight() / 32;
        populateImages();
        populateSounds();
    }

    private static void populateSounds() throws SlickException{
        
    }

    public static void populateImages(){
        addImageResource(1,"floor");
        addImageResource(2,"player");
        addImageResource(3,"gate1");
        addImageResource(4,"gate2");
    }

    public static void addImageResource(int i, String path) {
        i--;
        int x = i %10;
        int y = i / 10;
        imageResources.put(path,sheet.getSprite(x,y));
    }

    public static Image getImageResource(String path){
        return imageResources.get(path);
    }

    public static void addSoundResource(String path, String id) throws SlickException {
        soundResources.put(id,new Sound(path));
    }

    public static Sound getSoundResource(String path){
        return soundResources.get(path);
    }
}
