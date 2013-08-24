package me.jack.ld27.Level.Generation;

import me.jack.ld27.Level.Items.Blocks;
import me.jack.ld27.Level.Items.Floor;
import me.jack.ld27.Level.Level;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class LevelGen {

    public static Level generate(int difficulty) {
        int width = 50;
        int height = 18;
        Level level = new Level(width, height);
        int y = height-1;
        for (int x = 0; x != width - 1; x++) {
            level.setBlock(x,y, new Floor());
        }
        return level;
    }
}
