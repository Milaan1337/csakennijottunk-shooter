package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GrassActor extends OneSpriteStaticActor {
    public GrassActor(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(20,20);
    }
}
