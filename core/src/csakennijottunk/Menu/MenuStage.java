package csakennijottunk.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Credit.CreditScreen;
import csakennijottunk.Game.BearActor;
import csakennijottunk.Game.GameScreen;
import csakennijottunk.Game.MenuBackground;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {
    MenuBackground background;
    ClickListener c1;


    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        background = new MenuBackground(game);
        background.setSize(888.88888888f, 500);
        addActor(background);
        addBackButtonScreenBackByStackPopListener();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.getMyAssetManager().getFont("appopaint.otf");
        labelStyle.fontColor = Color.BLACK;

        MyLabel startLabel = new MyLabel(game, "Start", labelStyle);
        startLabel.setFontScale(2);
        startLabel.setPosition(340, 280);
        startLabel.setHeight(105);
        startLabel.setWidth(275);
        startLabel.setAlignment(1);
        addActor(startLabel);

        MyLabel creditLabel = new MyLabel(game, "Credit", labelStyle);
        creditLabel.setFontScale(2);
        creditLabel.setPosition(345, 145);
        creditLabel.setHeight(110);
        creditLabel.setWidth(270);
        creditLabel.setAlignment(1);
        addActor(creditLabel);

        MyLabel exitLabel = new MyLabel(game, "Exit", labelStyle);
        exitLabel.setFontScale(2);
        exitLabel.setPosition(340, 0);
        exitLabel.setHeight(95);
        exitLabel.setWidth(280);
        exitLabel.setAlignment(1);
        addActor(exitLabel);


        startLabel.addListener(c1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("click.mp3").play();
                game.setScreen(new GameScreen(game));
            }
        });

        creditLabel.addListener(c1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("click.mp3").play();
                game.setScreen(new CreditScreen(game));
            }
        });

        exitLabel.addListener(c1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("click.mp3").play();
                addTimer(new OneTickTimer(1, new OneTickTimerListener() {
                    @Override
                    public void onTick(OneTickTimer sender, float correction) {
                        super.onTick(sender, correction);
                        game.setScreenBackByStackPop();
                    }
                }));

                removeListener(c1);
            }
        });






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
