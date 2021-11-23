package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Credit.BackButton;
import csakennijottunk.Level;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;

public class GameStage extends MyStage {
    PlayerActor playerActor;
    ClickListener clickListener;
    BackButton backButton;
    BgActor BgActor;
    BearActor bearActor;
    SimpleOverlapsUtil simpleOverlapsUtil;
    public GameStage(MyGame game) {
        super(new ResponseViewport(501), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        playerActor = new PlayerActor(game);
        addActor(playerActor);
        playerActor.setZIndex(3);
        backButton = new BackButton(game);
        backButton.setPosition(0, 451);
        addActor(backButton);
        BgActor = new BgActor(game);
        addActor(BgActor);
        BgActor.setZIndex(1);
        BgActor.setWidth(501);
        BgActor.setHeight(501);

        Level level = new Level(1,this);
        level.build();

        bearActor = new BearActor(game);
        bearActor.setX(450);
        addActor(bearActor);



        addListener(clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.jump();
            }
        });

    }

    public void act(float delta){
        super.act(delta);
        if (SimpleOverlapsUtil.overlaps(bearActor, playerActor) == true){
            System.out.println("overlaps with medve");
        }
    }
}
