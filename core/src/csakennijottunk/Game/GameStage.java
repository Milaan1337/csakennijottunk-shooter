package csakennijottunk.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStage extends MyStage {
    PlayerActor playerActor;
    public GameStage(MyGame game) {
        super(new ResponseViewport(501), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        playerActor = new PlayerActor(game);
        addActor(playerActor);

    }
}
