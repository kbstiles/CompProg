import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Coin {

    // image that represents the coin's position on the board
    private BufferedImage image;
    // current position of the coin on the board grid
    private Point pos;
    // coin type
    private int type;
    // coin point amount
    private int pointAmount;

    public Coin(int x, int y, int type) {
        // load the assets
        loadImage(type);

        // initialize the state
        pos = new Point(x, y);

        if (type == 1) {
            // *** change how many points per coin 5
            pointAmount = 50;
        } else {
            // *** special coin worth more points and looks different /part 1
            pointAmount = 100;
        }
    }

    private void loadImage(int type) {
        try {
            // you can use just the filename if the image file is in your
            // project folder, otherwise you need to provide the file path.
            if (type == 1) {
                // *** change the image files /part 1
                image = ImageIO.read(new File("images/coin.png"));
            } else if (type == 2) {
                // *** special coin worth more points and looks different /part 2 10
                // *** change the image files /part 2
                image = ImageIO.read(new File("images/coin2.png"));
            }
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        // with the Point class, note that pos.getX() returns a double, but
        // pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
        // this is also where we translate board grid position into a canvas pixel
        // position by multiplying by the tile size.
        g.drawImage(
                image,
                pos.x * Board.TILE_SIZE,
                pos.y * Board.TILE_SIZE,
                observer);
    }

    public Point getPos() {
        return pos;
    }

    public int getPointAmount() {
        return pointAmount;
    }
}
