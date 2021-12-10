package csakennijottunk.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

import csakennijottunk.Level;
import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GameStage extends MyStage {
    public Vector2 fisherMan = new Vector2(200, 190);
    public Vector2 fishingRod = new Vector2(10, 10);
    boolean isBowInHand = false;
    PlayerActor playerActor = null;
    ClickListener clickListener;
    BackToMenuButton backButton;
    BgActor bgActor;
    BgActor bgActor2;
    BearActor bearActor;
    SimpleOverlapsUtil simpleOverlapsUtil;
    RestartButton restartButton;
    WeaponChange weaponChange;
    FisherManGroup fisherManActor;
    ChangeActor changeActor;
    FishFoodActor fishFoodActor;
    RestartButton backButton2;
    RabbitActor rabbitActor;
    PlayerLife life1;
    PlayerLife life2;
    PlayerLife life3;
    BowActor bowActor;
    WolfActor wolfActor;
    BowPulled bowPulled;
    EmptyActor emptyActor;
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
        for(float x = fisherManActor.get_handEnd().x; x < playerActor.getX() + 700; x+=20) {
            addActor(new FlyActor(game, x, ballistics2.getY(x)));
        }
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
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        changeActor = new ChangeActor(game);
        changeActor.setZIndex(999999999);
        addActor(changeActor);

        bgActor = new BgActor(game,-105);
        addActor(bgActor);


        backButton = new BackToMenuButton(game);
        backButton.setPosition(0, 300);
        addActor(backButton);

        weaponChange = new WeaponChange(game);
        weaponChange.setPosition(400, 400);
        weaponChange.setSize(100,100);
        weaponChange.setZIndex(999999999);
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

        bowActor = new BowActor(game);
        addActor(bowActor);

        bowPulled = new BowPulled(game);

        backButton2 = new RestartButton(game);
        addActor(backButton2);
        //backButton2.setVisible(false);

        rabbitActor = (RabbitActor)  getActor(RabbitActor.class);

        wolfActor = (WolfActor)  getActor(WolfActor.class);

        bearActor = (BearActor) getActor(BearActor.class);
        playerActor = (PlayerActor) getActor(PlayerActor.class);
        setCameraTracking(new CameraTrackingToActors());
        ((OrthographicCamera)getCamera()).zoom = 0.1f;
        ((CameraTrackingToActors)getCameraTracking()).addActor(playerActor);
        ((CameraTrackingToActors)getCameraTracking()).marginLeft = 0.1f;
        ((CameraTrackingToActors)getCameraTracking()).marginRight = 0.7f;
        ((CameraTrackingToActors)getCameraTracking()).zoomSpeed = 0.05f;
        if (bgActor.getStage() != null) {
            for (int i = 1; i <= 100; i++) {
                int count = (int) ((int) (-105 + (bgActor.getWidth()) * i));

                bgActor2 = new BgActor(game,count);
                addActor(bgActor2);
                bgActor2.setZIndex(0);

            }
        }

        playerActor.addListener(clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (playerActor.isMoving == true) {
                    playerActor.jump();
                }
            }
        });
        bowActor.addListener(clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (playerActor.isMoving == true) {
                    playerActor.jump();
                }
            }
        });

        if (playerActor.getStage() != null) {
            fisherManActor = new FisherManGroup(game, playerActor.getX(), playerActor.getY(), playerActor.getX() - 15, playerActor.getY() - 15, playerActor.getX() - 30, playerActor.getY());
        }
        weaponChange.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                isBowInHand = !getState();
                if (getState() == true){
                    playerActor.isMoving = false;
                    playerActor.setFps(0);
                    bowActor.remove();
                    addActor(bowPulled);
                }else{
                    playerActor.isMoving = true;
                    playerActor.setFps(20);
                    if (bowPulled.getStage() != null){
                        bowPulled.remove();
                    }

                    if (bowActor.getStage() == null){
                        addActor(bowActor);
                    }
                    ArrayList<Actor> actors = new ArrayList<Actor>();
                    for (Actor a:getActors()) {
                        if (a instanceof FlyActor){
                            a.remove();
                        }
                    }
                }
            }
        });

        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (isBowInHand == true) {
                    fisherManActor.set_angle(heightToDegree(y));
                    fisherManActor.set_speed(widthToSpeed(x));
                    fisherManActor.setPos(playerActor.getX() + playerActor.getWidth() / 2,playerActor.getY() + playerActor.getHeight() / 2);
                    generateFlying();
                    playerActor.isMoving = false;
                    for (Actor a:getActors()) {
                        if (a instanceof FishFoodActor){
                            a.remove();
                        }
                    }
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (isBowInHand == true) {
                    fishFoodActor = new FishFoodActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y), 50);
                    //addActor(fishFoodActor = new FishFoodActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y), 50));
                    addActor(fishFoodActor);
                    //((CameraTrackingToActors)getCameraTracking()).addActor(fishFoodActor);
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
        backButton.isMoving = false;
        weaponChange.isMoving = false;
        gameOver = true;
    }
    public boolean getState(){
        return isBowInHand;
    }

    public void act(float delta) {
        super.act(delta);
        for (Actor a : getActors()) {
            if (a instanceof BearActor) {
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                    if (gameOver == false) {
                        GameOver();
                    }
            }
        }
            if (a instanceof TreeActor) {
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                    GameOver();
                }
            }
            if (a instanceof RabbitActor) {
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                    GameOver();

                }
            }
        }
        for (Actor a : getActors()) {
            if (a instanceof TreeActor) {
                if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                    if (playerLife == 1) {
                        playerLife = playerLife - 1;
                        a.remove();
                        life1.remove();
                        if (gameOver == false) {
                            GameOver();
                        }
                    }
                    if (playerLife == 2) {
                        playerLife = playerLife - 1;
                        a.remove();
                        life2.remove();

                    }
                    if (playerLife == 3) {
                        playerLife = playerLife - 1;
                        a.remove();
                        life3.remove();

                    }

                }
            }
            if (playerActor != null && weaponChange != null) {
                weaponChange.setPosition(playerActor.getX() - 195, -30);
            }
            if (playerActor != null && backButton != null) {
                backButton.setPosition(playerActor.getX() - 190, 410);

            if (playerActor != null && restartButton != null) {
                restartButton.setPosition(playerActor.getX() - 200, 350);
                }
            }
        }
        if (playerActor.getStage() != null && weaponChange.getStage() != null) {
            weaponChange.setPosition(playerActor.getX() + 20,getHeight() - weaponChange.getHeight() - 25);
        }

        if (playerActor.getStage() != null && bowActor.getStage() != null){
            bowActor.setPosition(playerActor.getX() + playerActor.getWidth() / 2 - 10 - bowActor.getWidth()/2,playerActor.getY() + playerActor.getHeight() / 2 - bowActor.getHeight() / 2);
        }

        if (playerActor.getStage() != null && bowPulled.getStage() != null){
            bowPulled.setPosition(playerActor.getX() + playerActor.getWidth() / 2 + 15 - bowPulled.getWidth()/2,playerActor.getY() + playerActor.getHeight() / 2 - bowPulled.getHeight() / 2);
        }

        for (Actor a : getActors()) {
            if (a instanceof FishFoodActor) {
                    if (SimpleOverlapsUtil.overlaps(a, bearActor) == true) {
                        bearActor.remove();
                        System.out.println("UTKOZESXDLOL");
                    }
            }
            if (a instanceof FishFoodActor) {
                    if (SimpleOverlapsUtil.overlaps(a, rabbitActor) == true) {
                        rabbitActor.remove();

                }
            }
            if (a instanceof FishFoodActor) {
                if (SimpleOverlapsUtil.overlaps(a, wolfActor) == true) {
                    wolfActor.remove();

                }
            }
        }
    }
}
