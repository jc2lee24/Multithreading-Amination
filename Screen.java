import javax.swing.*;
import java.awt.*;


public class Screen extends JPanel{
    Square sq;

    public Screen(){
        sq = new Square(0);
        Thread t1 = new Thread(sq);
        t1.start();
    
    }    

    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        sq.drawMe(g);
    }

    public void animate() {
        while(true) {
            //wait for .1 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            //repaint the graphics drawn
            repaint();
        }

    }
}
