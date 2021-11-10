package csakennijottunk.Credit;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    BackButton backButton;
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500),game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        backButton = new BackButton(game);
        addActor(backButton);
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.getMyAssetManager().getFont("alegreyaregular.otf");

        MyLabel label = new MyLabel(game, "Készítők:", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(0, 450);
        addActor(label);

        label = new MyLabel(game, "Fellner Milán", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(30, 400);
        addActor(label);

        label = new MyLabel(game, "Kancsal Máté", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(30, 350);
        addActor(label);

        label = new MyLabel(game, "Németh Csaba Bence", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(30, 300);
        addActor(label);

        label = new MyLabel(game, "Zsebők Dávid Ferenc", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(30, 250);
        addActor(label);

        label = new MyLabel(game, "Felkészítő tanár:", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(0, 200);
        addActor(label);

        label = new MyLabel(game, "Tüske Balázs", labelStyle);
        label.setFontScale(0.5f);
        label.setPosition(30, 150);
        addActor(label);

    }
}
