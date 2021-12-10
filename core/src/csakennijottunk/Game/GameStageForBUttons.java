package csakennijottunk.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GameStageForBUttons extends MyStage {
    BackToMenuButton backToMenuButton;
    GameStage gameStage = new GameStage(game);
    PlayerLife life1;
    PlayerLife life2;
    PlayerLife life3;
    PlayerLifeEmpty emptyLife1;
    PlayerLifeEmpty emptyLife2;
    PlayerLifeEmpty emptyLife3;
    WeaponChange weaponChange;
    MyLabel loseLabel;
    MyLabel restartLabel;
    boolean isLife1Done = false;
    boolean isLife2Done = false;
    boolean isLife3Done = false;
    static AssetList assetList2 = new AssetList();
    static {
        assetList2.addFont("appopaint2.otf", 42);
        //assetList.add(MyGoodActor.assetlist);
    }



    public GameStageForBUttons(MyGame game) {
        super(new ResponseViewport(500), game);
        backToMenuButton = new BackToMenuButton(game);
        backToMenuButton.setPosition(0, 450);
        addActor(backToMenuButton);

        weaponChange = new WeaponChange(game);
        weaponChange.setPosition(400, 400);
        weaponChange.setSize(100,100);
        addActor(weaponChange);
        weaponChange.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (gameStage.gameOver == false){
                    gameStage.isWeaponChange = true;
                }
            }
        });

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.getMyAssetManager().getFont("appopaint2.otf");
        labelStyle.fontColor = Color.BLACK;

        loseLabel = new MyLabel(game, "", labelStyle);
        //startLabel.setFontScale(2);
        loseLabel.setPosition(150, 280);
        loseLabel.setHeight(50);
        loseLabel.setWidth(500);
        loseLabel.setAlignment(1);
        loseLabel.setText("Sajnos vesztettél, próbálkozz újra!");

        backToMenuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("click.mp3").play();
                if (loseLabel != null){
                    loseLabel.remove();
                }
                if (emptyLife1 != null){
                    emptyLife1.remove();
                }
                if (emptyLife2 != null){
                    emptyLife2.remove();
                }
                if (emptyLife3 != null){
                    emptyLife3.remove();
                }
                if (life1 != null){
                    life1.remove();
                }
                if (life2 != null){
                    life2.remove();
                }
                if (life3 != null){
                    life3.remove();
                }
                game.setScreen(new MenuScreen(game));

            }
        });



        life1 = new PlayerLife(game);
        life1.setPosition(750, 450);
        addActor(life1);

        life2 = new PlayerLife(game);
        life2.setPosition(700, 450);
        addActor(life2);

        life3 = new PlayerLife(game);
        life3.setPosition(650, 450);
        addActor(life3);

        emptyLife1 = new PlayerLifeEmpty(game);
        emptyLife1.setPosition(750, 450);

        emptyLife2 = new PlayerLifeEmpty(game);
        emptyLife2.setPosition(700, 450);

        emptyLife3 = new PlayerLifeEmpty(game);
        emptyLife3.setPosition(650, 450);




    }

    @Override
    public void act(float delta) {
        if (gameStage.gameOver == true){
            if (isLife1Done == false){
                life1.remove();
            }
            if (isLife2Done == false){
                life2.remove();
            }
            if (isLife3Done == false){
                life3.remove();
            }
            addActor(loseLabel);
        }

        if (gameStage.isLife1 == false && isLife1Done == false){
            life1.remove();
            addActor(emptyLife1);
            addActor(loseLabel);
            isLife1Done = true;
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


    }
}
