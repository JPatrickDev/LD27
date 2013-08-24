package me.jack.ld27.Level.Generation;

import me.jack.JEngine.Util.Utils;
import me.jack.ld27.Entity.EntityPlayer;
import me.jack.ld27.InGame;
import me.jack.ld27.Level.Items.Box;
import me.jack.ld27.Level.Items.Floor;
import me.jack.ld27.Level.Items.Gate;
import me.jack.ld27.Level.Level;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class LevelGen {

    public static Level generate(int difficulty,InGame parent) {
        int width = difficulty * 20;
        int height = 18;
        Level level = new Level(width, height,parent);
        int y = height - 1;
        for (int x = 0; x != width - 1; x++) {

            level.setBlock(x, y, new Floor());
        }

        Random random = new Random();
        boolean complete = false;

        System.out.println(y);
        int yLevelMin = y-2;
        System.out.println(y);
        int yLevelMax = y-1;

        int currentX = 0;
        int xLevelMax = currentX + 4;
        int xLevelMin = currentX + 2;
        while (!complete) {
            System.out.println("yMax:" + yLevelMax + " yMin:" + yLevelMin + "n:" + (yLevelMax - yLevelMin + 1));
            int yPos = yLevelMin + random.nextInt(yLevelMax - yLevelMin + 1);
            int xPos = xLevelMin + random.nextInt(xLevelMax - xLevelMin + 1);
            int w = random.nextInt(3) + 2;
            for(int  i = 0;i!= w;i++){
                level.setBlock(xPos,yPos,new Floor());
                xPos++;
            }
            currentX += w;

            xLevelMin = currentX + 1;
            xLevelMax = currentX + 5;
            if(random.nextInt(5) == 1){
            yLevelMax = yPos - 1;
            yLevelMin = yPos -2;
            }else{
                yLevelMax = yPos + 2;
                yLevelMin = yPos +1;
            }
            if(currentX >=width)complete = true;

        }


        level.setBlock(5, 5, new Gate());
        level.setPlayer(new EntityPlayer(50, 50, level));
        return level;
    }

    public static Level loadFromPNG(String res, InGame inGame) throws SlickException {
        Image image = new Image(res);
        int width = image.getWidth();
        int height = image.getHeight();
        Level level = new Level(width,height,inGame);
        for(int x = 0; x!= width;x++){
            for(int y = 0; y!= height;y++){
                Color pixel = image.getColor(x,y);
                if(Utils.isSameColour(pixel, new Color(0,0,0))){
                    level.setBlock(x,y,new Floor());
                }else if(Utils.isSameColour(pixel, new Color(64,64,64))){
                    level.setBlock(x,y,new Box());
                }else if(Utils.isSameColour(pixel, new Color(255,0,0))){
                    level.setBlock(x,y,new Gate());
                    if(level.getStartGate() == null)
                        level.setFirstGate(x,y);
                    else
                        level.setSecondGate(x,y);
                }else if(Utils.isSameColour(pixel, new Color(0XFFD800))){
                    level.setPlayer(new EntityPlayer(x*32,y*32,level));
                }

            }
        }
        return level;
    }
}
