package csakennijottunk.Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Game.GameScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

class ExitBUtton extends OneSpriteStaticActor {
    ClickListener c1;
    public ExitBUtton(MyGame game) {
        super(game, "Exitbutton.png");
        this.setPosition(200, 0);
        this.setSize(100, 100);


    }
}

class StartButton extends OneSpriteStaticActor {
    ClickListener c1;
    public StartButton(MyGame game) {
        super(game, "Startbutton.png");
        this.setPosition(200, 100);
        this.setSize(100, 100);
        this.addListener(c1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });


    }
}

class CreditButton extends OneSpriteStaticActor {
    public CreditButton(MyGame game) {
        super(game, "Creditsbutton.png");
        setPosition(200, 200);
        this.setSize(100, 100);
    }
}
