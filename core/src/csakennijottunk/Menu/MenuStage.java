package csakennijottunk.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Game.BearActor;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;

public class MenuStage extends MyStage {
    ExitBUtton exitBUtton;
    StartButton startButton;
    CreditButton creditButton;
    BearActor bearActor;

    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        //setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        exitBUtton = new ExitBUtton(game);
        addActor(exitBUtton);
        startButton = new StartButton(game);
        addActor(startButton);
        creditButton = new CreditButton(game);
        addActor(creditButton);

        setCameraTracking(new CameraTrackingToActors());
        RandomXS128 r = new RandomXS128();
        for(int i = 0; i< 10; i++){
            OneSpriteStaticActor oneSpriteStaticActor = new OneSpriteStaticActor(game, "fa.png"){
                public float rx, ry;

                @Override
                public void init() {
                    super.init();
                    rx = r.nextFloat();
                    ry = r.nextFloat();
                }

                @Override
                public void act(float delta) {
                    super.act(delta);
                    setX(getX() + rx - 0.5f);
                    setY(getY() + ry - 0.5f);
                }
            };
            oneSpriteStaticActor.setSize(30,30);
            //oneSpriteStaticActor.setPosition(getViewport().getWorldWidth() / 2, getViewport().getWorldHeight() / 2);
            oneSpriteStaticActor.setPosition(200,100);
            addActor(oneSpriteStaticActor);
            ((CameraTrackingToActors)getCameraTracking()).addActor(oneSpriteStaticActor);
        }
    }
}
