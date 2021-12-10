package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerLifeEmpty extends OneSpriteStaticActor {
    public PlayerLifeEmpty(MyGame game) {
        super(game, "Heart.png");
        setSize(50, 50);
    }
}