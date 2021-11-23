package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TreeActor extends OneSpriteStaticActor {
    public TreeActor(MyGame game) {
        super(game, "TreeBarrier.png");
        this.setSize(50,50);
    }
}
