// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help;

// create an abstract class called drawable
public abstract class Drawable {
    // initialize a variable to control whether an object should render or not
    boolean shouldDraw = true;

    // getting and setting
    public void setShouldDraw(boolean shouldDraw) {this.shouldDraw = shouldDraw;}
    public boolean getShouldDraw() {return this.shouldDraw;}

    // an overrideable draw method
    public abstract void draw();

    // an overrideable method to destroy the object
    public abstract void destroy();
}
