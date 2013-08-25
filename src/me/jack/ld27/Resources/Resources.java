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
    private static SpriteSheet playerAnimations;

    public static void init(String spriteSheet) throws SlickException {
        Image i = new Image("/res/sprites.png");
        sheet = new SpriteSheet(i, 32, 32);
        playerAnimations = new SpriteSheet(new Image("/res/player.png"),32,32);
        sheetWidth = i.getWidth() / 32;
        sheetHeight = i.getHeight() / 32;
        populateImages();
        populateSounds();
    }

    private static void populateSounds() throws SlickException{
        
    }

    public static void populateImages(){
        addImageResource(1,"floor","base");
        addImageResource(2,"playerStanding","base");
        addImageResource(3,"gate1","base");
        addImageResource(4,"gate2","base");
        addImageResource(5,"box","base");
        addImageResource(6,"pickup","base");

        //player animations
        addImageResource(1,"playerJump1","player");
        addImageResource(2,"playerJump2","player");
        addImageResource(3,"playerJump3","player");
        addImageResource(4,"playerJump4","player");

        addImageResource(5,"playerRight1","player");
        addImageResource(6,"playerRight2","player");
        addImageResource(7,"playerRight3","player");
        addImageResource(8,"playerRight4","player");

        addImageResource(9,"playerLeft1","player");
        addImageResource(10,"playerLeft2","player");
        addImageResource(11,"playerLeft3","player");
        addImageResource(12,"playerLeft4","player");

        addImageResource(13,"playerFall1","player");
        addImageResource(14,"playerFall2","player");
        addImageResource(15,"playerFall3","player");
        addImageResource(16,"playerFall4","player");

    }

    public static void addImageResource(int i, String path, String spriteSheet) {
        i--;
        if(spriteSheet.equalsIgnoreCase("base")){
        int x = i %10;
        int y = i / 10;
        imageResources.put(path,sheet.getSprite(x,y));
        }else{
            int x = i %4;
            int y = i / 4;
            imageResources.put(path,playerAnimations.getSprite(x,y));
        }
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
