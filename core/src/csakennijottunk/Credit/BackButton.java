package csakennijottunk.Credit;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Game.GameScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BackButton extends OneSpriteStaticActor {
    ClickListener c1;
    public BackButton(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(50, 50);
        this.setPosition(0, 0);
        this.addListener(c1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });
    }

    }

