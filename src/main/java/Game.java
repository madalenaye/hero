import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    private Screen screen;
    private Position position;
    private Arena arena;
    private Hero hero;
    public Game(){
        try {
            arena = new Arena(70,30);
            TerminalSize terminalSize = new TerminalSize(70,30);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException{
        while(true){
        draw();
        KeyStroke key = screen.readInput();
        arena.processKey(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){screen.close();}
        if (key.getKeyType() == KeyType.EOF) {
            break;}
        }
    }
}
