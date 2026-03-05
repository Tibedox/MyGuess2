package ru.tibedox.myguess2;

import static ru.tibedox.myguess2.Main.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenMenu implements Screen {
    Main gg;
    Texture imgBG;
    GuButton btnPlay, btnDifficulty, btnExit;

    public ScreenMenu(Main myGuess) {
        gg = myGuess;
        imgBG = new Texture("bg.jpg");

        btnPlay = new GuButton(gg.fontLarge, "Старт", 750);
        btnDifficulty = new GuButton(gg.fontLarge, "Сложность: 3х3", 600);
        btnExit = new GuButton(gg.fontLarge, "Выход", 450);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // обработка касаний экрана
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            if (btnPlay.hit(gg.touch.x, gg.touch.y)) {
                gg.setScreen(gg.screenGame);
            }
            if (btnDifficulty.hit(gg.touch.x, gg.touch.y)) {
                if (gg.difficulty == SIZE_3x3) {
                    gg.difficulty = SIZE_5x5;
                    gg.masN = 5;
                    gg.masM = 5;
                    btnDifficulty.setText("Сложность: 5х5");
                } else if (gg.difficulty == SIZE_5x5) {
                    gg.difficulty = SIZE_8x8;
                    gg.masN = 8;
                    gg.masM = 8;
                    btnDifficulty.setText("Сложность: 8х8");
                } else if (gg.difficulty == SIZE_8x8) {
                    gg.difficulty = SIZE_3x3;
                    gg.masN = 3;
                    gg.masM = 3;
                    btnDifficulty.setText("Сложность: 3х3");
                }
            }
            if(btnExit.hit(gg.touch.x, gg.touch.y)) {
                Gdx.app.exit();
            }
        }

        // события

        // отрисовка всей графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.draw(gg.batch);
        btnDifficulty.draw(gg.batch);
        btnExit.draw(gg.batch);
        gg.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        imgBG.dispose();
    }
}
