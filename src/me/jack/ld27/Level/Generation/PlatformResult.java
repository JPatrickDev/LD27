package me.jack.ld27.Level.Generation;

/**
 * Author: Jack
 * Date: 25/08/13
 */
public class PlatformResult {

    public int x;
    public int y;

    public boolean gateGenerated;

    public PlatformResult(int x,int y, boolean gateGenerated){
        this.x= x;
        this.y = y;
        this.gateGenerated = gateGenerated;
    }
}
