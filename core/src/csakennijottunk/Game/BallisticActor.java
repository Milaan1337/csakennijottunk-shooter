package csakennijottunk.Game;

import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BallisticActor extends OneSpriteStaticActor {

    public abstract static class OnStopListener {
        abstract void stop(BallisticActor sender);
    }

    protected Ballistics2 ballistics2;
    protected float waterHeight;
    protected boolean flying = true;
    protected float speed = 5;
    protected Vector2 endpoint;
    protected Vector2 startpoint;
    protected float falltime;
    protected OnStopListener onStopListener = null;

    public BallisticActor(MyGame game, String hash, Ballistics2 ballistics, float waterHeight) {
        super(game, hash);
        this.ballistics2 = ballistics;
        this.waterHeight = waterHeight;
        startpoint = new Vector2(ballistics.getX0(), ballistics.getY0());
        endpoint = new Vector2(ballistics2.getPosition(ballistics2.getElapsedTimeFromY(waterHeight)[1]).x, ballistics2.getPosition(ballistics2.getElapsedTimeFromY(waterHeight)[1]).y);
        falltime = ballistics2.getElapsedTimeFromY(waterHeight)[1];
        setSize(128, 128);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (flying) {
            rotateBy(delta * 300);
            if (getX() + getWidth() / 2 < ballistics2.getX(waterHeight)[1]) {
                setPosition(ballistics2.getPosition(getElapsedTime() * speed).x - getWidth() / 2, ballistics2.getPosition(getElapsedTime() * speed).y - getHeight() / 2);
            } else {
                setPosition(endpoint.x - getWidth() / 2, endpoint.y - getHeight() / 2);
                flying = false;
                if (onStopListener != null) {
                    onStopListener.stop(this);
                }
            }
        }
        //System.out.println(getDistanceInMeter());
    }



    public boolean isFlying() {
        return flying;
    }

    public void setOnStopListener(OnStopListener onStopListener) {
        this.onStopListener = onStopListener;
    }

    public float getDistanceInMeter() {
        return ballistics2.getPosition(falltime / speed < elapsedTime ? falltime / speed : elapsedTime).x - ballistics2.getX0();
    }

    public float getLengthInMeter() {
        return ballistics2.getPosition(falltime / speed).x - ballistics2.getX0();
    }
}
