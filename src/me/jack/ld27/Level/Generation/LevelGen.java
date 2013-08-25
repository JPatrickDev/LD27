package me.jack.ld27.Level.Generation;

import me.jack.JEngine.Util.Utils;
import me.jack.ld27.Entity.EntityPlayer;
import me.jack.ld27.InGame;
import me.jack.ld27.Level.Items.*;
import me.jack.ld27.Level.Level;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class LevelGen {

    public static Level generate(int difficulty, InGame parent) {
        Random random = new Random();
        int width = 20 + (difficulty * 2);
        int height = 18;
        Level level = new Level(width, height, parent);
        int y = height - 1;
        for (int x = 0; x != width - 1; x++) {

            level.setBlock(x, y, new Floor());
        }

        int startGateX = random.nextInt((width / 4) - 2) + 2;
        int startGateY = random.nextInt(height - 2) + 2;
        level.setBlock(startGateX, startGateY, new Gate());
        level.setFirstGate(startGateX, startGateY);
        level.setPlayer(new EntityPlayer(startGateX * 32, startGateY * 32, level));
        int endGateX = random.nextInt(width - (width - (width / 4))) + (width - (width / 4));
        int endGateY = random.nextInt(height - 5) + 2;
        level.setBlock(endGateX, endGateY, new Gate());
        level.setSecondGate(endGateX, endGateY);

        List<Block> blocksTried = new ArrayList<Block>();
        while (blocksTried.size() < 10) {
            Block b = getRandomBlock(level, blocksTried);
            level.setBlock(b.getX(), b.getY(), b);
            generateRandomPlatform(random, blocksTried, b, level);
            blocksTried.add(b);
        }

        return level;
    }

    private static Block getRandomBlock(Level l, List<Block> tried) {
        boolean blockFound = false;
        Random r = new Random();
        while (!blockFound) {
            int rX = r.nextInt(l.width);
            int rY = r.nextInt(l.height);
            Block b = new Box();
            b.setX(rX);
            b.setY(rY);
            if (!tried.contains(b))
                return b;
        }
        return null;
    }

    private static void generateRandomPlatform(Random r, List<Block> tried, Block include, Level level) {
        int l = r.nextInt(3) + 2;

        int x = include.getX();
        int y = include.getY();
        generatePlatform(l, level, x, y);
    }


    private static PlatformResult generatePlatform(int l, Level level, int x, int y) {
        if (x > level.width) return new PlatformResult(0, 0, false);
        boolean generatedGate = false;
        for (int i = 0; i != l; i++) {
            level.setBlock(x, y, new Box());
            if (new Random().nextInt(5) == 0 && level.getEndGate() == null) {
                int xPos = x;
                int yPos = y - 1;
                level.setBlock(xPos, yPos, new Gate());
                System.out.println("Second gate at: " + xPos + " " + yPos);
                level.setSecondGate(xPos, yPos);
                generatedGate = true;
            }
            x++;
        }

        return new PlatformResult(x, y, generatedGate);
    }

    public static Level loadFromPNG(String res, InGame inGame) throws SlickException {
        Image image = new Image(res);
        int width = image.getWidth();
        int height = image.getHeight();
        Level level = new Level(width, height, inGame);
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != height; y++) {
                Color pixel = image.getColor(x, y);
                if (Utils.isSameColour(pixel, new Color(0, 0, 0))) {
                    level.setBlock(x, y, new Floor());
                } else if (Utils.isSameColour(pixel, new Color(64, 64, 64))) {
                    level.setBlock(x, y, new Box());
                } else if (Utils.isSameColour(pixel, new Color(255, 0, 0))) {
                    level.setBlock(x, y, new Gate());
                    if (level.getStartGate() == null)
                        level.setFirstGate(x, y);
                    else
                        level.setSecondGate(x, y);
                } else if (Utils.isSameColour(pixel, new Color(0XFFD800))) {
                    level.setPlayer(new EntityPlayer(x * 32, y * 32, level));
                } else if (Utils.isSameColour(pixel, new Color(0x0026FF))){
                    if(new Random().nextInt(5) == 1){
                    level.setBlock(x,y,new Pickup());
                        level.addPickup(x,y);
                    }
                }else if(Utils.isSameColour(pixel, new Color(0x4CFF00))){
                    level.setBlock(x,y,new Pickup());
                    level.addPickup(x,y);
                }

            }
        }
        return level;
    }
}
