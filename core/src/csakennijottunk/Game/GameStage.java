package csakennijottunk.Game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import csakennijottunk.Credit.BackButton;
import csakennijottunk.Level;
import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTracking;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;

public class GameStage extends MyStage {
    public Vector2 fisherMan = new Vector2(200, 190);
    public Vector2 fishingRod = new Vector2(10, 10);
    boolean isBowInHand = false;
    PlayerActor playerActor = null;
    ClickListener clickListener;
    BackToMenuButton backButton;
    BgActor bgActor;
    BearActor bearActor;
    SimpleOverlapsUtil simpleOverlapsUtil;
    RestartButton restartButton;
    WeaponChange weaponChange;
    FisherManGroup fisherManActor;
    ChangeActor changeActor;
    FishFoodActor fishFoodActor;
    PlayerLife life1;
    PlayerLife life2;
    PlayerLife life3;
    int playerLife = 3;
    boolean gameOver = false;

    public void generateFlying(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Actor a:getActors()) {
            if (a instanceof FlyActor){
                actors.add(a);
            }
        }
        for (Actor a:actors) {
            getActors().removeValue(a, true);
        }
        Ballistics2 ballistics2 = new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y);
        for(float x = fisherManActor.get_handEnd().x; x < getViewport().getWorldWidth(); x+=20) {
            addActor(new FlyActor(game, x, ballistics2.getY(x)));
        }
    }

    public Vector2 getFishingRodEnd(){
        Vector2 fishingRodEnd = new Vector2(fishingRod);
        fishingRodEnd.rotate(fisherManActor.degree);
        fishingRodEnd.add(fisherMan);
        return fishingRodEnd;
    }

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
        fisherManActor = new FisherManGroup(game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        changeActor = new ChangeActor(game);
        changeActor.setZIndex(999999999);
        addActor(changeActor);
        bgActor = new BgActor(game);
        bgActor.setZIndex(1);
        bgActor.setWidth(700);
        bgActor.setHeight(500);
        addActor(bgActor);
        backButton = new BackToMenuButton(game);
        backButton.setPosition(0, 300);
        addActor(backButton);

        weaponChange = new WeaponChange(game);
        weaponChange.setPosition(200, 200);
        addActor(weaponChange);

        Level level = new Level(1,this);
        level.build();

        life1 = new PlayerLife(game);
        life1.setPosition(450, 0);
        addActor(life1);

        life2 = new PlayerLife(game);
        life2.setPosition(450, 0);
        addActor(life2);

        life3 = new PlayerLife(game);
        life3.setPosition(450, 0);
        addActor(life3);

        bearActor = (BearActor) getActor(BearActor.class);

        playerActor = (PlayerActor) getActor(PlayerActor.class);
        setCameraTracking(new CameraTrackingToActors());
        ((CameraTrackingToActors)getCameraTracking()).addActor(playerActor);

        addListener(clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (playerActor.isMoving == true) {
                    playerActor.jump();
                }
            }
        });
        weaponChange.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                isBowInHand = !getState();
            }
        });

        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (isBowInHand == true) {
                    fisherManActor.set_angle(heightToDegree(y));
                    fisherManActor.set_speed(widthToSpeed(x));
                    generateFlying();
                    GameOver();
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (isBowInHand == true) {
                    addActor(fishFoodActor = new FishFoodActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y), 120));
                }
            }
        });
    }

    public float widthToSpeed(float x) {
        float d = x / getViewport().getWorldWidth() * 100;
        return d < 1 ? 1 : d > 100 ? 100 : d;
    }

    public float heightToDegree(float y){
        float d = y / getViewport().getWorldHeight() * 90;
        return d < 0 ? 0 : d > 85 ? 85 : d;
    }

    public void GameOver(){
        addActor(restartButton = new RestartButton(game));
        playerActor.isMoving = false;
        if (bearActor != null){
            bearActor.stop();
            bearActor.isMoving = false;
        }
        System.out.println("gameover");
        bgActor.isMoving = false;
        backButton.isMoving = false;
        weaponChange.isMoving = false;
        gameOver = true;
    }
    public boolean getState(){
        return isBowInHand;
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
        for (Actor a: getActors()) {
            if (a instanceof TreeActor){
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true){
                    if (playerLife == 1) {
                        playerLife = playerLife - 1;
                        a.remove();
                        life1.remove();
                        if (gameOver == false){
                            GameOver();
                        }
                    }
                    if (playerLife == 2){
                        playerLife = playerLife - 1;
                        a.remove();
                        life2.remove();

                    }
                    if (playerLife == 3){
                        playerLife = playerLife - 1;
                        a.remove();
                        life3.remove();

                    }

                }
            }
        }

    }
}
