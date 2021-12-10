package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BowPulled extends OneSpriteStaticActor {
    public BowPulled(MyGame game) {
        super(game, "BowPulled.png");
        this.setSize(60,60);
    }
}
