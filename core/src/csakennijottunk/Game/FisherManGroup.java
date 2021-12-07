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

    public Handtype handtype = Handtype.hand;
    public float degree = 45;
    public float v0 = 100;
    public FisherManHandActor fisherManHandActor;
    public HandRod fisherManRodActor;
    public FisherManActor fisherManActor;
    public Vector2 topsolders = new Vector2(210,310);
    public Vector2 arm = new Vector2(154,11);
    public Vector2 rod = new Vector2(276,200).rotate(-45);

    public FisherManGroup(MyGame game) {
        super(game);
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
        Vector2 forgatott = new Vector2((handtype == Handtype.hand ||  handtype == Handtype.none) ? arm : rod);
        forgatott.rotate(degree);
        r.add(forgatott);
        return  r;
    }
}
