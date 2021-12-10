package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BgActor extends OneSpriteStaticActor {
    public BgActor(MyGame game, int count) {
        super(game, "bg1.png");
        this.setWidth(1280);
        this.setHeight(1024);
        this.setPosition(count,0);
        this.setZIndex(0);
    }
}
