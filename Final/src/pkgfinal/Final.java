package pkgfinal;
import java.awt.*;                      // paint graphics and images
import java.awt.image.BufferedImage;    // buffer of image data
import javax.swing.*;                   // GUI, Jframe, JPanel
import java.util.Scanner;
import java.util.Random;
import java.awt.event.*;

public class Final extends JFrame implements MouseListener 
{
    private final int maxIter = 360;
    //private final double zoom = 1;
    private double cY = 0, cX = 0;
    private BufferedImage image;
    double pointX = 400, pointY = 300;
    double zoom = .8;
    int coords = -1;
    double xmin = -1.5;
    double xmax = 1.5;
    double ymin = -1;
    double ymax = 1;
    
    public Final()
    {
        addMouseListener(this); 
        setBounds(0, 0, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
    void fillImage(Graphics g)
    {
        int w = getWidth();
        int h = getHeight();
        
        double[] xcoord = {0,  0, -.123, -1.756, -1.1409, .36, -.658, -.7,-.75, -1.25, -.125,  0, -.765, .3,   .28, -.391, -2, -1, .25, -.7};
        double[] ycoord = {0, .1, -.745,    0,    .2409, -.1, -.45,  .27015,  0,    0,   .64952, 1, .12,  -.01, .008, -.587,  0, -1,  0, .28};
        String[] name = {"Circle", "Rough Circle", "Douady's Rabbit", "Airplane", "Rabbit's Shadow", "Dragon", "Super Attractor", "Double Whirlpool", "San Marco", "San Marco's Shadow", "Balloon rabbit", "Dendrite", "Cantor", "Fish", "Paisley", "Siegel Disk", "Flying Saucers", "Dust", "Cauliflower", "Black Holes"};
        
        
        if (coords == -1)       // Mandelbrot
        {
            setTitle("Mandelbrot");
        }
        else
        {
            setTitle(name[coords]);
        }

        // class Buffredimage, TYPE_INT_RGB in 8-bit packed into integer pixels
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        
        if (coords != -1)       // julia
        {
            cX = xcoord[coords];
            cY = ycoord[coords];
        }
        
        
        double zx, zy;
        double xrange = xmax - xmin;
        double yrange = ymax - ymin;
        double xcenter = xmin + pointX / 800 * xrange;
        double ycenter = ymin + pointY / 600 * yrange;
        
        xmin = xcenter - xrange / (2 * zoom);
        ymin = ycenter - yrange / (2 * zoom);
        xmax = xcenter + xrange / (2 * zoom);
        ymax = ycenter + yrange / (2 * zoom);
                // x is from -1.5 to 1.5 and y is from -1 to 1
        
        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            {
                zx = xmin + (xmax - xmin) * x / w;
                zy = ymin + (ymax - ymin) * y / h;
                if (coords == -1)       // Mandelbrot
                    {
                        cX = zx;
                        cY = zy;
                    }   
                int i = maxIter;
                while (zx * zx + zy * zy < 4 && i > 0)
                {
                    double tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    i--;
                }
                int c = new Color(i % 64 * 4, i % 8 * 32, i % 8 * 32).getRGB();
                //image.setRGB(x, y, i | (i << 8));
                image.setRGB(x, y, c);
            }
        }    
    }
    
    public void reset()
    {
        pointX = 400;
        pointY = 300;
        zoom = .8;
        xmin = -1.5;
        xmax = 1.5;
        ymin = -1;
        ymax = 1;
    }
 
    @Override
    public void mouseClicked(MouseEvent mouse)
    {
    // Get the location of the current mouse click.
        pointX = mouse.getX();
        pointY = mouse.getY();
        
        if (pointY > 580)        // reset zoom
        {
            reset();
        }
        else if (pointX > 780 && coords != 19)  // next
        {
            coords += 1;
            reset();
        }
        else if (pointX < 20 && coords != -1)  // previous
        {
            coords -= 1;
            reset();
        }
        else
        {
            zoom = zoom *1.5;
        }
                
    // Tell the panel that we need to redraw things.
        
        repaint();
    }
    
    public void mouseEntered(MouseEvent mouse){ }   
    public void mouseExited(MouseEvent mouse){ }
    public void mousePressed(MouseEvent mouse){ }
    public void mouseReleased(MouseEvent mouse){ }
    
    
    @Override
    public void paint(Graphics g)      // painting code
    {
        fillImage(g);
        g.drawImage(image, 0, 0, this);
    }
    
    
    public static void main(String[] args) 
    {
        new Final().setVisible(true);
    }
}
