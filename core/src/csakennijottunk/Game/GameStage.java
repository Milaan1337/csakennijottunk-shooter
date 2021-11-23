package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.Actor;
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
    PlayerActor playerActor = null;
    ClickListener clickListener;
    BackButton backButton;
    BgActor BgActor;
    BearActor bearActor;
    SimpleOverlapsUtil simpleOverlapsUtil;

    public Actor getActor(Class c){
        for (Actor a: getActors()) {
            if (c.isInstance(a)){
                return a;
            }
        }
        return null;
    }

    public GameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        BgActor = new BgActor(game);
        BgActor.setZIndex(1);
        BgActor.setWidth(500);
        BgActor.setHeight(500);
        addActor(BgActor);
        backButton = new BackButton(game);
        backButton.setPosition(0, 450);
        addActor(backButton);

        Level level = new Level(1,this);
        level.build();

        playerActor = (PlayerActor) getActor(PlayerActor.class);

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
        for (Actor a: getActors()) {
            if (a instanceof BearActor){
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true){
                    System.out.println("overlaps with medve");

                }
            }
        }

    }
}
