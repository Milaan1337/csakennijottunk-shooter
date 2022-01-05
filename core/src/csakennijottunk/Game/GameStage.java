package csakennijottunk.Game;

import com.badlogic.gdx.Game;
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
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
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
    BgActor bgActor;
    BgActor bgActor2;
    BearActor bearActor;
    SimpleOverlapsUtil simpleOverlapsUtil;
    FisherManGroup fisherManActor;
    FishFoodActor fishFoodActor;
    BowActor bowActor;
    WolfActor wolfActor;
    BowPulled bowPulled;
    RabbitActor rabbitActor;
    LionActor lionActor;
    FoxActor foxActor;
    EmptyActor emptyActor;
    int playerLife = 3;
    public static boolean gameOver = false;
    public static boolean restartButtonVisible = false;
    public static boolean isLife1 = true;
    public static boolean isLife2 = true;
    public static boolean isLife3 = true;
    public static boolean isWeaponChange = false;



    public void generateFlying() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Actor a : getActors()) {
            if (a instanceof FlyActor) {
                actors.add(a);
            }
        }
        for (Actor a : actors) {
            getActors().removeValue(a, true);
        }

        Ballistics2 ballistics2 = new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y);
        for (float x = fisherManActor.get_handEnd().x; x < playerActor.getX() + 700; x += 20) {
            addActor(new FlyActor(game, x, ballistics2.getY(x)));
        }
    }

    public Actor getActor(Class c) {
        for (Actor a : getActors()) {
            if (c.isInstance(a)) {
                return a;
            }
        }
        return null;
    }

    public GameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();

        bgActor = new BgActor(game, -105);
        addActor(bgActor);

        Level level = new Level(1, this);
        level.build();

        bowActor = new BowActor(game);
        addActor(bowActor);

        bowPulled = new BowPulled(game);


        rabbitActor = (RabbitActor) getActor(RabbitActor.class);

        foxActor = (FoxActor) getActor(FoxActor.class);

        lionActor = (LionActor) getActor(LionActor.class);

        wolfActor = (WolfActor) getActor(WolfActor.class);

        bearActor = (BearActor) getActor(BearActor.class);
        playerActor = (PlayerActor) getActor(PlayerActor.class);
        setCameraTracking(new CameraTrackingToActors());
        ((OrthographicCamera) getCamera()).zoom = 0.1f;
        ((CameraTrackingToActors) getCameraTracking()).addActor(playerActor);
        ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0.1f;
        ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.7f;
        ((CameraTrackingToActors) getCameraTracking()).zoomSpeed = 0.05f;
        if (bgActor.getStage() != null) {
            for (int i = 1; i <= 100; i++) {
                int count = (int) ((int) (-105 + (bgActor.getWidth()) * i));

                bgActor2 = new BgActor(game, count);
                addActor(bgActor2);
                bgActor2.setZIndex(0);

            }
        }

        playerActor.addListener(clickListener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (playerActor.isMoving == true) {
                    playerActor.jump();
                }
            }
        });
        bowActor.addListener(clickListener = new ClickListener() {
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

        addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (isBowInHand == true) {
                    fisherManActor.set_angle(heightToDegree(y));
                    fisherManActor.set_speed(widthToSpeed(x));
                    fisherManActor.setPos(playerActor.getX() + playerActor.getWidth() / 2, playerActor.getY() + playerActor.getHeight() / 2);
                    generateFlying();
                    playerActor.isMoving = false;
                    for (Actor a : getActors()) {
                        if (a instanceof FishFoodActor) {
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
                    fishFoodActor.setOnStopListener(new BallisticActor.OnStopListener() {
                        @Override
                        void stop(BallisticActor sender) {
                            fishFoodActor.remove();
                        }
                    });
                    //((CameraTrackingToActors)getCameraTracking()).addActor(fishFoodActor);
                }
            }
        });
    }

    public float widthToSpeed(float x) {
        float d = x / getViewport().getWorldWidth() * 100;
        return d < 1 ? 1 : d > 100 ? 100 : d;
    }

    public float heightToDegree(float y) {
        float d = y / getViewport().getWorldHeight() * 90;
        return d < 0 ? 0 : d > 85 ? 85 : d;
    }

    public boolean getState() {
        return isBowInHand;
    }

    public void WeaponChange() {
        isBowInHand = !getState();
        if (getState() == true) {
            playerActor.isMoving = false;
            playerActor.setFps(0);
            bowActor.remove();
            addActor(bowPulled);
        } else {
            playerActor.isMoving = true;
            playerActor.setFps(20);
            if (bowPulled.getStage() != null) {
                bowPulled.remove();
            }

            if (bowActor.getStage() == null) {
                addActor(bowActor);
            }
            ArrayList<Actor> actors = new ArrayList<Actor>();
            for (Actor a : getActors()) {
                if (a instanceof FlyActor) {
                    a.remove();
                }
            }
        }
    }


    public void GameOver() {
        restartButtonVisible = true;
        playerActor.isMoving = false;
        if (bearActor != null) {
            playerActor.stop();
            if (bearActor != null) {
                bearActor.stop();
                bearActor.isMoving = false;
            }
            System.out.println("gameoverjoooo");
            gameOver = true;
        }
    }

    public void GameOverForOtherStage() {
        GameOver();
    }


        public void act ( float delta){
            super.act(delta);

            if (isWeaponChange == true) {
                WeaponChange();
                isWeaponChange = false;
            }
            for (Actor a : getActors()) {
                if (a instanceof BearActor) {
                    if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                        GameOver();
                    }
                }

                if (a instanceof RabbitActor) {
                    if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                        if (gameOver == false) {
                            GameOver();
                            gameOver = true;
                        }

                    }
                }
            }
            for (Actor a : getActors()) {
                if (a instanceof TreeActor) {
                    if (SimpleOverlapsUtil.overlaps(a, playerActor) == true) {
                        if (playerLife == 1) {
                            a.remove();
                            playerLife = playerLife - 1;
                            isLife1 = false;
                            GameOver();
                        }
                        if (playerLife == 2) {
                            a.remove();
                            playerLife = playerLife - 1;
                            isLife2 = false;

                        }
                        if (playerLife == 3) {
                            a.remove();
                            playerLife = playerLife - 1;
                            isLife3 = false;

                        }

                    }
                }

            }


            for (Actor a : getActors()) {
                if (a instanceof FishFoodActor) {
                    if (SimpleOverlapsUtil.overlaps(a, bearActor)) {
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
                if (a instanceof FishFoodActor) {
                    if (SimpleOverlapsUtil.overlaps(a, lionActor) == true) {
                        lionActor.remove();

                    }
                }
                if (a instanceof FishFoodActor) {
                    if (SimpleOverlapsUtil.overlaps(a, foxActor) == true) {
                        foxActor.remove();

                    }
                }
            }
        }
    }

