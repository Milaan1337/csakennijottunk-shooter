package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Credit.BackButton;
import csakennijottunk.Level;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTracking;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;

public class GameStage extends MyStage {
    PlayerActor playerActor = null;
    ClickListener clickListener;
    BackToMenuButton backButton;
    BgActor bgActor;
    BearActor bearActor;
    SimpleOverlapsUtil simpleOverlapsUtil;
    RestartButton restartButton;
    boolean gameOver = false;

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
        bgActor = new BgActor(game);
        bgActor.setZIndex(1);
        bgActor.setWidth(700);
        bgActor.setHeight(500);
        addActor(bgActor);
        backButton = new BackToMenuButton(game);
        backButton.setPosition(0, 450);
        addActor(backButton);

        Level level = new Level(1,this);
        level.build();

        bearActor = (BearActor) getActor(BearActor.class);

        playerActor = (PlayerActor) getActor(PlayerActor.class);
        setCameraTracking(new CameraTrackingToActors());
        ((CameraTrackingToActors)getCameraTracking()).addActor(playerActor);

        addListener(clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.jump();
            }
        });

    }

    public void GameOver(){
        addActor(restartButton = new RestartButton(game));
        playerActor.isMoving = false;
        bearActor.stop();
        bearActor.isMoving = false;
        System.out.println("gameover");
        bgActor.isMoving = false;
        gameOver = true;





    }

    public void act(float delta){
        super.act(delta);
        for (Actor a: getActors()) {
            if (a instanceof BearActor){
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true){
                    if (gameOver == false){
                        GameOver();
                    }

                }
            }
        }

    }
}
