package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class BearActor extends OneSpriteAnimatedActor {
    boolean isMoving = true;
    public BearActor(MyGame game) {
        super(game, "bear.atlas");
        setFps(20);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isMoving == true) {
            this.setX(this.getX() - 1);
        }
    }
}
