// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help;

import com.raylib.Jaylib;
import org.cardgame.gameobjects.bases.DrawableObject;

import static com.raylib.Raylib.*;

public class ClickDetector {
    Rectangle hitbox;
    DrawableObject object;

    public ClickDetector(DrawableObject object) {
        this.hitbox = new Rectangle().x(object.pos.x()).y(object.pos.y()).width(object.texture.width()).height(object.texture.height());
        this.object = object;
    }

    public void detect(Runnable clickCallback, Runnable mouseDownCallback, Runnable hoverCallback, Runnable exitHoverCallback) {
        Vector2 mousePosition = GetMousePosition();
        boolean colliding = CheckCollisionPointRec(mousePosition, this.hitbox);
        if (colliding) {
            hoverCallback.run();
            if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
                mouseDownCallback.run();
            } else if (IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) {
                clickCallback.run();
            }
        } else {
            exitHoverCallback.run();
        }
    }

    public void drawHitbox() {
        DrawRectangleLinesEx(this.hitbox, 5.0f, Jaylib.RED);
    }
}
