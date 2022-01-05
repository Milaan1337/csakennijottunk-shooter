package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class WolfActor extends OneSpriteAnimatedActor {
    boolean isMoving = true;
    public WolfActor(MyGame game) {
        super(game, "WolfSprite.atlas");
        this.setFps(20);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isMoving == true) {
            this.setX(this.getX() - 1);
        }
    }
}

