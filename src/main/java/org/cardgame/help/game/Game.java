// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help.game;

import static com.raylib.Raylib.*;

import org.cardgame.gameobjects.Card;
import org.cardgame.gameobjects.bases.DrawableBackground;
import org.cardgame.gameobjects.bases.DrawableObject;
import org.cardgame.help.WindowHelp;
import org.cardgame.help.texture.CardMaps;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static ArrayList<DrawableObject> drawableGameObjects = new ArrayList<>();
    public static Camera3D camera3d;

    public static DrawableBackground bg;

    public static void initDrawableGameObjects() {
        // add all cards
        for (int i = 0; i < 5; i++) {
            // new random
            Random rand = new Random();
            int num = rand.nextInt(CardMaps.map.length);
            Card card = new Card(new Vector2().x(i*65).y((float) WindowHelp.WIN_HEIGHT /2 + 300), num);
            drawableGameObjects.add(card);
        }

        Random rand = new Random();
        int num = rand.nextInt(CardMaps.map.length);

        Card c2 = new Card(new Vector2().y(65).y(65), num);
        drawableGameObjects.add(c2);

        bg = new DrawableBackground(LoadTexture("textures/backgrounds/default.png"));
    }

    public static void updateDrawables() {
        // drawable objects
        for (DrawableObject obj : drawableGameObjects) {
            obj.update();
        }
    }

    public static void renderDrawables() {
        bg.draw();

        // drawable objects
        for (DrawableObject obj : drawableGameObjects) {
            obj.draw();
            // debug draw
            if (obj.isDebugDrawing)
                obj._draw();
        }
    }

    public static void destroyDrawables() {
        // drawable objects
        for (DrawableObject obj : drawableGameObjects) {
            obj.destroy();
        }
    }

    public static void init3DCam() {
        camera3d = new Camera3D()
                ._position(new Vector3().x(0).y(2.5f).z(-5))
                .up(new Vector3().x(0).y(-1).z(0))
                .fovy(90)
                .projection(CAMERA_PERSPECTIVE)
                .target(new Vector3().x(0).y(0).z(0));
    }

    public static Camera3D get3DCam() {return camera3d;}

    // main functions

    public static void init() {
        initDrawableGameObjects();
        init3DCam();
    }

    public static void render() {
        renderDrawables();
    }

    public static void render3D() {
        // empty
    }

    public static void update() {
        // game physics and actions
        updateDrawables();
    }

    public static void end() {
        destroyDrawables();
    }
}
