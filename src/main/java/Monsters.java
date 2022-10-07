import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monsters extends Element{
    private Position position;
    public void setPosition(Position position){this.position = position;}
    public Position getPosition(){return this.position;}
    public Monsters(int x, int y) {
        super(x,y);
        this.position = new Position(x,y);
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "༼ง ◉_◉༽ง");
    }
}
