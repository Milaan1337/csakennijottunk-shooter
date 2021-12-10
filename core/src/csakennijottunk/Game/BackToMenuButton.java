package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BackToMenuButton extends OneSpriteStaticActor {
    ClickListener c1;
    public BackToMenuButton(MyGame game) {
        super(game, "BackButton.png");
        this.setSize(50, 50);
        this.setPosition(0, 0);


    }
}
