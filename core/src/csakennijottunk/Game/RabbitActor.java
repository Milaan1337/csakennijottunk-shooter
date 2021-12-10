package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class RabbitActor extends OneSpriteAnimatedActor {
    boolean isMoving = true;
    public RabbitActor(MyGame game) {
        super(game, "BunnySprite.atlas");
        setFps(20);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isMoving == true) {
            this.setX(this.getX() - 1);
        }
    }
}
