package csakennijottunk.Game;


import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerActor extends OneSpriteStaticActor {
    boolean isJumping = false;
    boolean fix = false;
    boolean sokleszaboolean = false;
    public PlayerActor(MyGame game){
        super(game, "green.png");
        this.setWidth(200);
        this.setHeight(300);
        this.setX(0);
        this.setY(0);
    }

    public void jump(){
        isJumping = true;
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        this.setX(this.getX() + 1);
        if (isJumping == true){
            sokleszaboolean = true;
            if (this.getY() < 200 && fix == false && sokleszaboolean == true) {
                this.setY(this.getY() + 5);
            }
            System.out.println(this.getY());
            if (this.getY() == 200 || fix == true && sokleszaboolean == true){
                this.fix = true;
              this.setY(this.getY() - 10);
            }

            if (this.getY() < 0){
                sokleszaboolean = false;
            }
        }
    }

}