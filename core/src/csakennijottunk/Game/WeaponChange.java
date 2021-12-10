package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WeaponChange extends OneSpriteStaticActor {
    ClickListener k1;
    PlayerActor playerActor;

    public WeaponChange(MyGame game) {
        super(game, "Switchbutton.png");
        this.setSize(100,100);

        this.addListener(k1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("click.mp3").play();

            }
        });
    }
}
