package me.jack.ld27.Level.Generation;

import me.jack.JEngine.AI.ASTAR.BasicNodeFactory;
import me.jack.JEngine.AI.ASTAR.Map;
import me.jack.JEngine.AI.ASTAR.Node;
import me.jack.ld27.Level.Items.Block;
import me.jack.ld27.Level.Level;

import java.util.List;

/**
 * Author: Jack
 * Date: 25/08/13
 */
public class Validation {


    public static boolean valid(Level l){
        if(l.getEndGate() == null)return false;
       Map m = new Map(l.width,l.height,new BasicNodeFactory());
        for(int x = 0; x!= l.width;x++){
            for(int y = 0; y!=l.height;y++){
                Block b = l.getBlock(x,y);
                if(b == null)continue;
                if(b.isSolid())
                    m.setWalkable(x,y,false);
            }
        }
        List<Node> path = m.findPath((int)l.getStartGate().getX(),(int)l.getStartGate().getY(),(int)l.getEndGate().getX(),(int)l.getEndGate().getY());
        System.out.println(path);
        if(path.isEmpty())return false;
        return true;
    }
}
