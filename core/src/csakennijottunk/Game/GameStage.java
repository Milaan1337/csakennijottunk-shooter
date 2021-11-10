package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Level;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStage extends MyStage {
    PlayerActor playerActor;
    ClickListener clickListener;
    public GameStage(MyGame game) {
        super(new ResponseViewport(501), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        playerActor = new PlayerActor(game);
        addActor(playerActor);

        Level level = new Level(1,this);
        level.build();

        addListener(clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.jump();
            }
        });

    }
}
