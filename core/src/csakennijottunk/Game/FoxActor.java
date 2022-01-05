package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class FoxActor extends OneSpriteAnimatedActor {
    boolean isMoving = true;
    public FoxActor(MyGame game) {
        super(game, "FoxSprite.atlas");
        this.setSize(120,30);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isMoving == true) {
            this.setX(this.getX() - 1);
        }
    }
}
