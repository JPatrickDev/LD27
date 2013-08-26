package me.jack.ld27.Entity;

import me.jack.ld27.Level.Level;
import me.jack.ld27.Render.Animation;
import me.jack.ld27.Render.Drawable;
import me.jack.ld27.Resources.Resources;
import org.lwjgl.input.Keyboard;

/**
 * Author: Jack
 * Date: 24/08/13
 */
public class EntityPlayer extends Entity implements Drawable {

    Animation runLeft;
    Animation runRight;
    Animation jump;
    Animation fall;
    Animation standing;
    Animation current;

    PlayerState state;

    public EntityPlayer(int x, int y, Level parent) {
        super(x, y, parent);
        this.width = 15;
        this.height = 31;
        this.xOffset = 9;
        standing = new Animation(this, 60, new String[]{"playerStanding"}, -1);

        runLeft = new Animation(this, 10, new String[]{"playerLeft1", "playerLeft2", "playerLeft3", "playerLeft4"}, 1);
        runRight = new Animation(this, 10, new String[]{"playerRight1", "playerRight2", "playerRight3", "playerRight4"}, 2);
        jump = new Animation(this, 10, new String[]{"playerJump1", "playerJump2", "playerJump3", "playerJump4"}, 0);
        fall = new Animation(this, 10, new String[]{"playerFall1", "playerFall2", "playerFall3", "playerFall4"}, 3);
        current = standing;
        state = PlayerState.STANDING;
    }

    @Override
    public void update() {
        super.update();
        last = state;
        this.apply(this);
        checkMovement();
        applyAnim();
        if(last.name().equalsIgnoreCase("falling") && !state.name().equalsIgnoreCase("falling")) Resources.playSound("land");
    }

    private boolean floating() {

        return false;//   return !parent.canMove(getNewHitbox(0,32));
    }

    PlayerState last;
    private void applyAnim() {

        if (state == PlayerState.JUMPING && current.id != 0) current = jump;
        if (state == PlayerState.FALLING && current.id != 3) current = fall;
        if (state == PlayerState.WALKLEFT && current.id != 1) current = runLeft;
        if (state == PlayerState.WALKRIGHT && current.id != 2) current = runRight;
        if (state == PlayerState.STANDING && current.id != -1) current = standing;
    }

    //TODO: Gravity needs to make player flush with the floor, not floating a bit
    private void checkMovement() {

        if (getYVelocity() < 0) state = PlayerState.JUMPING;
        if (getYVelocity() == 0) /*|| getXVelocity() == 0)*/ state = PlayerState.STANDING;
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {

            if (!falling && !floating()) {

                if (getYVelocity() >= 0) {
                    this.addY(-72);
                }

            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            this.addX((float) -5);
            state = PlayerState.WALKLEFT;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            this.addX((float) 5);
            state = PlayerState.WALKRIGHT;
        }
        if (getYVelocity() > 0) state = PlayerState.FALLING;
    }

    @Override
    public String getResourceId() {
        return current.getCurrentFrame();
    }

    @Override
    public boolean shouldRender() {
        return true;
    }

    @Override
    public void postRender() {
        current.tick();
    }

}

enum PlayerState {
    STANDING, WALKLEFT, WALKRIGHT, JUMPING, FALLING;
}