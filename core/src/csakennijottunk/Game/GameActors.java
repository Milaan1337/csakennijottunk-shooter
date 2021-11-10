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
        super(game, "badlogic.jpg");
        this.setWidth(50);
        this.setHeight(50);
        this.setX(200);
        this.setY(200);
    }
}