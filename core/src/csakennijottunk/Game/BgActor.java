package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BgActor extends OneSpriteStaticActor {
    public BgActor(MyGame game) {
        super(game, "blue.png");
    }

    public void act(float delta){
        super.act(delta);
        this.setX(this.getX() + 1);
    }
}
