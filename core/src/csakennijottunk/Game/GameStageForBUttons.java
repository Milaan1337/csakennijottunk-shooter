package csakennijottunk.Game;

import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStageForBUttons extends MyStage {
    RestartButton restartButton = new RestartButton(game);
    BackToMenuButton backToMenuButton;
    boolean restartButtonAdded = false;
    GameStage gameStage = new GameStage(game);
    PlayerLife life1;
    PlayerLife life2;
    PlayerLife life3;
    PlayerLifeEmpty emptyLife1;
    PlayerLifeEmpty emptyLife2;
    PlayerLifeEmpty emptyLife3;
    WeaponChange weaponChange;
    boolean isLife1Done = false;
    boolean isLife2Done = false;
    boolean isLife3Done = false;



    public GameStageForBUttons(MyGame game) {
        super(new ResponseViewport(500), game);
        backToMenuButton = new BackToMenuButton(game);
        backToMenuButton.setPosition(0, 450);
        addActor(backToMenuButton);
        restartButton.setPosition(350, 225);
        restartButton.setSize(50, 50);

        weaponChange = new WeaponChange(game);
        weaponChange.setPosition(400, 400);
        weaponChange.setSize(100,100);
        addActor(weaponChange);
        weaponChange.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gameStage.isWeaponChange = true;
            }
        });

        life1 = new PlayerLife(game);
        life1.setPosition(450, 0);
        addActor(life1);

        life2 = new PlayerLife(game);
        life2.setPosition(400, 0);
        addActor(life2);

        life3 = new PlayerLife(game);
        life3.setPosition(350, 0);
        addActor(life3);

        emptyLife1 = new PlayerLifeEmpty(game);
        emptyLife1.setPosition(450, 0);

        emptyLife2 = new PlayerLifeEmpty(game);
        emptyLife2.setPosition(450, 0);

        emptyLife3 = new PlayerLifeEmpty(game);
        emptyLife3.setPosition(450, 0);




    }

    @Override
    public void act(float delta) {
        if (gameStage.isLife1 == false && isLife1Done == false){
            life1.remove();
            addActor(emptyLife1);
            isLife1Done = true;
            gameStage.GameOver();
        }
        if (gameStage.isLife2 == false && isLife2Done == false){
            life2.remove();
            addActor(emptyLife2);
            isLife2Done = true;
        }
        if (gameStage.isLife3 == false && isLife3Done == false){
            life3.remove();
            addActor(emptyLife3);
            isLife3Done = true;
        }

        if (restartButtonAdded == false && gameStage.restartButtonVisible == true){
            addActor(restartButton);
        }

    }
}
