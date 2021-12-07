package csakennijottunk.Game;


import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerActor extends OneSpriteStaticActor {
    boolean isJumping = false;
    float oldPos;
    boolean isFalling;
    boolean isMoving = true;
    public PlayerActor(MyGame game){
        super(game, "green.png");
        this.setWidth(200);
        this.setHeight(150);
        this.setX(0);
        this.setY(30);
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
        if (isMoving == true){
            this.setX(this.getX() + 3);
        }
        if (isJumping == true){
            System.out.println("isJumping jó");
            float currentPos = this.getY();
            if (currentPos >= 30 && currentPos < (501 - this.getHeight() + 9)/2) {
                System.out.println("pos jó");
                this.setY(this.getY() + 15);
                isFalling = false;
            }
        }

        if (this.getY() == (501 - this.getHeight() + 9)/2){
            fall();
        }

        if (isFalling == true){
            float currentPos = this.getY();
            if (currentPos <= 501-this.getHeight() + 9 && currentPos >= 0) {
                this.setY(this.getY() - 15);
                System.out.println("Y:" + this.getY());
                if (currentPos <= 45){
                    System.out.println(currentPos);
                    isFalling = false;
                }
            }
        }
    }
}