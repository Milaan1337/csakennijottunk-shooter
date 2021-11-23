package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class BearActor extends OneSpriteAnimatedActor {
    public BearActor(MyGame game) {
        super(game, "bear.atlas");
        setFps(20);

    }

    public void act(float delta){
        super.act(delta);
        this.setX(this.getX() - 2);
    }
}
