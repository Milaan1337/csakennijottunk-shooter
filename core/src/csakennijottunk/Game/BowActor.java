package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BowActor extends OneSpriteStaticActor {
    public BowActor(MyGame game) {
        super(game, "BowDefault.png");
        this.setSize(60,60);
    }
}
