package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class HienaActor extends OneSpriteAnimatedActor {
    boolean isMoving = true;
    public HienaActor(MyGame game) {
        super(game, "HyenaSprite.atlas");
        this.setFps(20);
        this.setSize(80,40);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isMoving == true ) {
            this.setX(this.getX() - 1);
        }
    }
}
