package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FlyActor extends OneSpriteStaticActor {

    public FlyActor(MyGame game, float x, float y) {
        super(game, "badlogic.jpg");
        setWidth(5);
        setHeight(5);
        setPosition(x,y);
    }

}
