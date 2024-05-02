// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame;

import com.raylib.Jaylib;
import org.cardgame.help.WindowHelp;
import org.cardgame.help.game.Game;

import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args) {
        // initialize the main window
        InitWindow(WindowHelp.WIN_WIDTH, WindowHelp.WIN_HEIGHT, WindowHelp.WIN_TITLE);
        // set a window state so the user can resize it to their liking
        //SetWindowState(FLAG_WINDOW_RESIZABLE);

        Game.init();

        // main game loop
        while(!WindowShouldClose()) {
            WindowHelp.traceWinMidPos();

            Game.update();

            // rendering
            BeginDrawing();
                ClearBackground(Jaylib.SKYBLUE);

                Game.render();

                BeginMode3D(Game.get3DCam());
                    Game.render3D();
                EndMode3D();

                DrawFPS(10, 10);
            EndDrawing();
        }

        // end the game
        Game.end();

        // close the window
        CloseWindow();
    }
}