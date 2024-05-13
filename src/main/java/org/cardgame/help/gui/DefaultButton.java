// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help.gui;

import static com.raylib.Raylib.*;

public class DefaultButton extends GuiButton{
    public DefaultButton(Vector2 pos) {
        super(LoadTexture("textures/gui/buttons/defaultbutton.png"), pos);
    }

    @Override
    public void onClick() {
        System.out.println(this + " clicked!");
    }

    @Override
    public void onHover() {

    }

    @Override
    public void onHoverExit() {

    }
}