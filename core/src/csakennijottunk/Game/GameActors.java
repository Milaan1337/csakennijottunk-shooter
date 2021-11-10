package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GameActors extends OneSpriteStaticActor {
    public GameActors(MyGame game) {
        super(game, "green.png");
    }
}

class PlayerActor extends OneSpriteStaticActor {
    public PlayerActor(MyGame game){
        super(game, "green.png");
        this.setWidth(20);
        this.setHeight(30);
        this.setX(0);
        this.setY(0);
    }
}