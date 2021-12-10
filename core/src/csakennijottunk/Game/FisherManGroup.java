package csakennijottunk.Game;

import com.badlogic.gdx.math.Vector2;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FisherManGroup extends MyGroup {
    public enum Handtype{
        hand,
        fishingrod,
        none,
        bugFix
    }

    Vector2 topsolders;
    Vector2 arm;
    Vector2 rod;
    public Handtype handtype = Handtype.hand;
    public float degree = 45;
    public float v0 = 100;
    public FisherManHandActor fisherManHandActor;
    public HandRod fisherManRodActor;
    public FisherManActor fisherManActor;


    public FisherManGroup(MyGame game,float x1, float y1,float x2, float y2, float x3, float y3) {
        super(game);
        this.topsolders = new Vector2(x1,y1);
        this.arm = new Vector2(x2,y2);
        this.rod = new Vector2(x3,y3).rotate(-45);
        addActor(fisherManActor = new FisherManActor(game));
        addActor(fisherManHandActor = new FisherManHandActor(game));
        addActor(fisherManRodActor = new HandRod(game));
        fisherManHandActor.setOrigin(topsolders.x, topsolders.y);
        fisherManRodActor.setOrigin(topsolders.x, topsolders.y);
        set_hand(Handtype.hand);
        set_angle(degree);
    }

    void set_angle(float degree){
        this.degree = degree;
        fisherManHandActor.setRotation(degree);
        fisherManRodActor.setRotation(degree - 45);
    }

    void set_speed(float v0){
        this.v0 = v0;
    }

    void setPos(float x1,float y1){
        topsolders = new Vector2(x1, y1);
    }

    void set_hand(Handtype handtype){
        this.handtype = handtype;
        switch (handtype){
            case hand:
                fisherManHandActor.setVisible(true);
                fisherManRodActor.setVisible(false);
                break;
            case fishingrod:
                fisherManHandActor.setVisible(false);
                fisherManRodActor.setVisible(true);
                break;
            case none:
                fisherManHandActor.setVisible(true);
                fisherManRodActor.setVisible(false);
                break;
            case bugFix:
                fisherManHandActor.setVisible(false);
                fisherManRodActor.setVisible(true);
                break;
        }
    }

    Handtype get_hand(){
        return handtype;
    }

    Vector2 get_handEnd(){
        Vector2 r = new Vector2(getX(),getY());
        r.add(topsolders);
        return  r;
    }
}
