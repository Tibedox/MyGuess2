package ru.tibedox.myguess2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends Game {
    public static final int SCR_WIDTH = 1920, SCR_HEIGHT =1080;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont font, fontMedium, fontLarge;

    ScreenMenu screenMenu;
    ScreenGame screenGame;

    public static final int SIZE_3x3 = 0, SIZE_5x5 = 1, SIZE_8x8 = 2;
    int difficulty = SIZE_3x3;
    int masN = 3, masM = 3;

    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();
        generateFont();

        screenMenu = new ScreenMenu(this);
        screenGame = new ScreenGame(this);
        setScreen(screenMenu);
    }

    @Override
    public void dispose () {
        batch.dispose();
    }

    void generateFont(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("gothicb.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = new Color(0.8f, 1, 0.4f, 1);
        parameter.size = 45;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 2;
        parameter.borderStraight = true;
        parameter.shadowColor = new Color(0.1f, 0.1f, 0.1f, 0.8f);
        parameter.shadowOffsetX = parameter.shadowOffsetY = 3;
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        font = generator.generateFont(parameter);
        parameter.color = new Color(1, 0.8f, 0.4f, 1);
        parameter.size = 60;
        fontMedium = generator.generateFont(parameter);
        parameter.size = 100;
        fontLarge = generator.generateFont(parameter);
        generator.dispose();
    }
}
