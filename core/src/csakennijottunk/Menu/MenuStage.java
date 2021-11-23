package csakennijottunk.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Game.BearActor;
import csakennijottunk.Game.MenuBackground;
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
    MenuBackground background;

    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        //setCameraResetToCenterOfScreen();
        background = new MenuBackground(game);
        background.setSize(888.88888888f, 500);
        addActor(background);
        addBackButtonScreenBackByStackPopListener();
        exitBUtton = new ExitBUtton(game);
        exitBUtton.setY(0);
        exitBUtton.setX(430);
        addActor(exitBUtton);
        startButton = new StartButton(game);
        startButton.setY(280);
        startButton.setX(430);
        addActor(startButton);
        creditButton = new CreditButton(game);
        addActor(creditButton);
        creditButton.setY(150);
        creditButton.setX(430);
        /*setCameraTracking(new CameraTrackingToActors());
        RandomXS128 r = new RandomXS128();
        for(int i = 0; i< 10; i++){
            OneSpriteStaticActor oneSpriteStaticActor = new OneSpriteStaticActor(game, "fa.png"){
                public float rx, ry;

                @Override
                public void init() {
                    super.init();
                    rx = r.nextFloat() * 3;
                    ry = r.nextFloat() * 3;
                }

                @Override
                public void act(float delta) {
                    super.act(delta);
                    setX(getX() + rx - 0.5f);
                    setY(getY() + ry - 0.5f);
                }
            };
            oneSpriteStaticActor.setSize(30,30);
            oneSpriteStaticActor.setPosition(getViewport().getWorldWidth() / 2, getViewport().getWorldHeight() / 2);
            //oneSpriteStaticActor.setPosition(200,100);
            addActor(oneSpriteStaticActor);
            ((CameraTrackingToActors)getCameraTracking()).addActor(oneSpriteStaticActor);
        }*/
    }
}
