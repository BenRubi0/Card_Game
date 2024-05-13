// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help.gui;

import java.util.Random;

import static com.raylib.Raylib.*;

public class DefaultButton extends GuiButton{
    public DefaultButton(Vector2 pos) {
        super(LoadTexture("textures/gui/buttons/defaultbutton.png"), pos);
    }

    @Override
    public void onClick() {
        Random rand = new Random();
        int rand1 = rand.nextInt(200, 500);
        int rand2 = rand.nextInt(500, 1000);
        this.pos = new Vector2().x(rand1).y(rand2);
    }

    @Override
    public void onHover() {
    }

    @Override
    public void onHoverExit() {
    }

    @Override
    public void onMouseDown() {
    }
}
