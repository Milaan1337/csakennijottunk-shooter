package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class EmptyActor extends OneSpriteStaticActor {
    public EmptyActor(MyGame game) {
        super(game, "badlogic.jpg");
        this.setPosition(200,0);
        this.setSize(100,100);
    }
}
