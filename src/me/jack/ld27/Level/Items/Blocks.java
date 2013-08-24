package me.jack.ld27.Level.Items;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public enum Blocks {

    FLOOR(1,"Floor",true);


    private int id;
    private String humanName;
    private boolean solid;
    private Blocks(int id, String humanName,boolean solid){
        this.id = id;
        this.humanName = humanName;
        this.solid = solid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public boolean isSolid() {
        return solid;
    }
}
