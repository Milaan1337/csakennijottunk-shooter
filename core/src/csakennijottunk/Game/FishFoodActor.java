package csakennijottunk.Game;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class FishFoodActor extends BallisticActor {

    public FishFoodActor(MyGame game, Ballistics2 ballistics, float waterHeight) {
        super(game, "Arrow.png", ballistics, waterHeight);
        setSize(30,30);
    }
}
