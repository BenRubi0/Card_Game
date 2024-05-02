package org.cardgame.help;

import static com.raylib.Raylib.*;

public class WindowHelp {
    public static final int WIN_WIDTH = 1200;
    public static final int WIN_HEIGHT = 900;
    public static final String WIN_TITLE = "Card Game";

    public static Vector2 winMidPos = new Vector2().x((float)WIN_WIDTH/2).y((float)WIN_HEIGHT/2);

    public static Vector2 getWinMidPos() {
        return winMidPos;
    }

    public static void traceWinMidPos() {
        winMidPos = new Vector2()
                .x((float) GetScreenWidth() / 2)
                .y((float) GetScreenHeight() / 2);
    }
}
