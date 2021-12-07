package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ChangeActor extends OneSpriteStaticActor {
    public ChangeActor(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(100,100);
        this.setZIndex(999999999);
    }
}
