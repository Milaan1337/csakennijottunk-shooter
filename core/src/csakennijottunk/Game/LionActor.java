package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class LionActor extends OneSpriteAnimatedActor {
    boolean isMoving = true;
    public LionActor(MyGame game) {
        super(game, "mountainlion.atlas");
        this.setSize(150,80);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isMoving == true) {
            this.setX(this.getX() - 1);
        }
    }
}
