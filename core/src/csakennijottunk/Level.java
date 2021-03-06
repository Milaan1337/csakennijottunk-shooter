package csakennijottunk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import csakennijottunk.Game.BearActor;
import csakennijottunk.Game.FoxActor;
import csakennijottunk.Game.GrassActor;
import csakennijottunk.Game.HienaActor;
import csakennijottunk.Game.LionActor;
import csakennijottunk.Game.PlayerActor;
import csakennijottunk.Game.RabbitActor;
import csakennijottunk.Game.TreeActor;
import csakennijottunk.Game.TreeActor2;
import csakennijottunk.Game.WolfActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;

public class Level {
    char[][] levelarray;
    int width;
    int height;
    MyStage stage;

    public Level(int id, MyStage stage) {
        this.stage = stage;
        FileHandle f = Gdx.files.internal("Levels/" + id + ".txt");
        String[] lines = f.readString().split("\n");
        int max = 0;
        for (String s : lines) {
            if (s.length() > max) {
                max = s.trim().length();
            }
        }
        //levelarray = new char[vízszintes][függőleges];
        width = max;
        height = lines.length;
        levelarray = new char[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                levelarray[x][y] = ' ';
            }
        }

        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].trim().length(); x++) {
                levelarray[x][y] = lines[y].charAt(x);
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print((char) (levelarray[x][y]));
            }
            System.out.println();
        }

    }


    public void build() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                switch (levelarray[x][y]) {
                    case 'p':
                        MyActor p = new PlayerActor(stage.game);
                        p.setPosition(x * 30, 30);
                        stage.addActor(p);
                        break;
                    case 'm':
                        MyActor bearActor = new BearActor(stage.game);
                        bearActor.setPosition(x * 30, y * 50);
                        stage.addActor(bearActor);
                        break;
                    case 'o':
                        MyActor m = new GrassActor(stage.game);
                        m.setPosition(x * 30, y * 30);
                        m.setZIndex(5);
                        stage.addActor(m);
                        break;
                    case 'r':
                        MyActor r = new RabbitActor(stage.game);
                        r.setPosition(x * 30, y * 30);
                        r.setZIndex(5);
                        stage.addActor(r);
                        break;
                    case 'x':
                        MyActor d = new TreeActor(stage.game);
                        d.setPosition(x * 30, y * 30);
                        stage.addActor(d);
                        d.setZIndex(4);
                        break;
                    case 'w':
                        MyActor w = new WolfActor(stage.game);
                        w.setPosition(x * 50, y * 30);
                        stage.addActor(w);
                        w.setZIndex(4);
                        break;
                    case 't':
                        MyActor t = new TreeActor2(stage.game);
                        t.setPosition(x * 30, y * 20);
                        stage.addActor(t);
                        t.setZIndex(2);
                        break;
                    case 'l':
                        MyActor l = new LionActor(stage.game);
                        l.setPosition(x * 30, y * 20);
                        stage.addActor(l);
                        l.setZIndex(2);
                        break;
                    case 'f':
                        MyActor f = new FoxActor(stage.game);
                        f.setPosition(x * 120, y * 30);
                        stage.addActor(f);
                        f.setZIndex(2);
                        break;

                }
            }
        }
    }

}

