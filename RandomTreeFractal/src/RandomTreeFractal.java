/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtreefractal;

/**
 *
 * @author nicho
 */
import java.util.*;
import java.applet.*;
import java.awt.*;
public class RandomTreeFractal extends Applet {
    private Image display;//more or less the window
    private Graphics drawingArea;//drawing tools and canvas
    public void init(){
        setSize(700, 700);
        int height=getSize().height;
        int width=getSize().width;
        display=createImage(width, height);
        drawingArea=display.getGraphics();
        //call recursion
        randomFractal(0, height/2, width, height, drawingArea);
        
    }
    public void paint(Graphics g){
        g.drawImage(display, 0, 0, null);
    }
    public void randomFractal(int leftX, int leftY,
                                int horiSize, int vertSize, Graphics g){
        if(leftX>=getSize().width || vertSize/4<=0)
            return;
        int newLeft=leftX + horiSize/4;
        if(newLeft<=0)
            newLeft=1;
        Random r=new Random();
        int topY=leftY-r.nextInt(vertSize/2);
        int btmY=leftY+r.nextInt(vertSize/2);
        g.drawLine(leftX, leftY, newLeft, topY);
        g.drawLine(leftX, leftY, newLeft, btmY);
        randomFractal(newLeft, topY, horiSize*3/4, vertSize/2, g);
        randomFractal(newLeft, btmY, horiSize*3/4, vertSize/2, g);
    }
    
    
}
