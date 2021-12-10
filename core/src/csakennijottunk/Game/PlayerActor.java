package csakennijottunk.Game;


import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerActor extends OneSpriteAnimatedActor {
    boolean isJumping = false;
    float oldPos;
    boolean isFalling;
    boolean isMoving = true;
    public PlayerActor(MyGame game){
        super(game, "HunterSprite.atlas");
        this.setWidth(75);
        this.setHeight(75);
        this.setZIndex(99999999);
        this.setX(0);
        this.setY(30);
        this.setFps(10);
    }



    public void jump(){
        isJumping = true;
        float oldPos = this.getY();
    }

    public void fall(){
        isJumping = false;
        isFalling = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        float currentPos = this.getY();
        if (isMoving == true){
            this.setX(this.getX() + 3);
        }
        if (isJumping == true){
            System.out.println("Jelenlegi pos" + this.getY());
            System.out.println((501 - this.getHeight() + 9)/2 + "Ez a cél");

            if (currentPos >= 30 && currentPos < (501 - this.getHeight() + 9)/2 + 7.5) {
                System.out.println("pos jó");
                this.setY(this.getY() + 15);
                isFalling = false;
            }
        }

        if (this.getY() == (501 - this.getHeight() + 9)/2 + 7.5){
            fall();
        }

        if (isFalling == true){
            if (currentPos <= 501-this.getHeight() + 9 && currentPos >= 0) {
                this.setY(this.getY() - 5);
                if (currentPos <= 45){
                    this.setY(30);
                    isFalling = false;
                }
            }
        }
    }
}