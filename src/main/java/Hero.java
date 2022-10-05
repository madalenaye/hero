import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private Position position;
    public Hero(Position position) {
        this.position = position;
    }
    public void draw(Screen screen) throws IOException {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }
    public void moveUp() throws IOException{
        y -= 1;
    }
    public void moveDown() throws IOException{
        y += 1;
    }
    public void moveLeft() throws IOException{
        x -= 1;
    }
    public void moveRight() throws IOException{
        x += 1;
    }
}
