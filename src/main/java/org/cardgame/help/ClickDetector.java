// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help;

import org.cardgame.gameobjects.bases.DrawableObject;

import static com.raylib.Raylib.*;

public class ClickDetector {
    Rectangle hitbox;
    DrawableObject object;

    public boolean isHovering = false;
    public boolean isClicking = false;
    public boolean didClick = false;

    public ClickDetector(DrawableObject object) {
        this.hitbox = new Rectangle().x(object.pos.x()).y(object.pos.y()).width(object.texture.width()).height(object.texture.height());
        this.object = object;
    }

    public void detect() {
        Vector2 mousePosition = GetMousePosition();
        boolean colliding = CheckCollisionPointRec(mousePosition, this.hitbox);
        if (colliding) {
            isHovering = true;
            if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                isClicking = !IsMouseButtonReleased(MOUSE_BUTTON_LEFT);
                if (IsMouseButtonReleased(MOUSE_BUTTON_LEFT))
                    didClick = true;
            }
        } else {
            isHovering = false;
            isClicking = false;
            didClick = false;
        }
    }
}
