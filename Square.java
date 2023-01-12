import java.awt.Color;
import java.awt.Graphics;

public class Square implements Runnable{
    int x;
    boolean leftOrRight = true;

    public Square(int x){
        this.x = x;
    }

    public void drawMe(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, 200, 50, 50);
    }

    public void run(){
        while(true){
            if(leftOrRight){
                x += 1;
                try{
                    Thread.sleep(10); //millisecond
                }
                catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                }
            }
            else if(!leftOrRight){
                x -= 1;
                try{
                    Thread.sleep(10); //millisecond
                }
                catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                }
            }

            if(x >= 800){
                leftOrRight = false;
            }
            else if(x <= 0){
                leftOrRight = true;
            }
        }
    }
}
