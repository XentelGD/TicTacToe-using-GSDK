import gsdk.App;
import gsdk.Draw;
import gsdk.Resource;
import gsdk.mwidgets.TextButton;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.system.Vector2f;

public class Field {
    public static int[][] data = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    public static int currentSign = 1;

    public static TextButton[][] buttons = new TextButton[3][3];

    public static void create() {

        Font font = Resource.loadFont("/font/roboto-r.ttf");

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                buttons[x][y] = new TextButton("", font, x * 100, y * 100, 100, 100);
                buttons[x][y].normalColor = new Color(0, 0, 0, 0);
                buttons[x][y].hoverColor = new Color(255, 255, 255, 50);

                int fx = x, fy = y;

                buttons[x][y].onClick = () -> {
                    if (data[fx][fy] == 0 && !Main.gameOver) {

                        data[fx][fy] = currentSign;

                        if (currentSign == 1) {
                            currentSign = 2;
                        } else {
                            currentSign = 1;
                        }
                    }
                };
            }
        }
    }

    private static void drawCross(int x, int y) {
        RectangleShape r1 = new RectangleShape(new Vector2f(2, 140));
        RectangleShape r2 = new RectangleShape(new Vector2f(2, 140));

        r1.setFillColor(new Color(255, 0, 0));
        r2.setFillColor(new Color(255, 0, 0));

        r1.setPosition(x * 100 + 100, y * 100);
        r2.setPosition(x * 100, y * 100);

        r1.setRotation(45);
        r2.setRotation(-45);

        App.window.draw(r1);
        App.window.draw(r2);
    }

    private static void drawZero(int x, int y) {
        CircleShape r1 = new CircleShape(46, 100);

        r1.setFillColor(new Color(0, 0, 0, 0));
        r1.setOutlineColor(new Color(0, 0, 255));
        r1.setOutlineThickness(2);

        r1.setPosition(x * 100 + 3, y * 100 + 3);

        App.window.draw(r1);
    }

    public static void update() {

        // drawing all game elements

        for (int y = 0; y < 3; y++) {

            Draw.rect(0, y * 100 - 1, 300, 1, new Color(255, 255, 255, 255));

            for (int x = 0; x < 3; x++) {
                buttons[x][y].draw();

                Draw.rect(x * 100 - 1, 0, 1, 300, new Color(255, 255, 255, 255));

                if (data[x][y] == 1) {
                    drawCross(x, y);
                }
                else if (data[x][y] == 2){
                    drawZero(x, y);
                }
            }
        }
    }

}
