import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *Written by Nicholas Knight
 */
public class TrianglesOhFractals extends Applet {
    private Image display;
    private Graphics drawingArea;
    public void init(){
        setSize(400, 400);
        int height = getSize().height;
        int width=getSize().width;
        display= createImage(width, height);
        drawingArea= display.getGraphics();
        int[] xpts= {0, width/2, width};
        int[] ypts={height, 0, height};
        drawBTriangle(xpts,ypts,height, drawingArea);
        drawTriangle(xpts,ypts, height, drawingArea);
    }
    public void paint(Graphics g){
        g.drawImage(display, 0, 0, null);
    }
    public void drawTriangle(int[] xpts, int[] ypts, int side, Graphics g){

                // new triangle is half hight in direct middle of old flipped upside down
                //make new triangle with points halfway to midpoint // then flip y points
                //sqrt 2 /2 ~ .7
                
                    g.setColor(Color.white);
                    
                g.fillPolygon(xpts, ypts, 3);
                side=side/2;
                for(int i=0; i<3; i++){
                    ypts[i]=ypts[i]/2;
                    xpts[i]=xpts[i]/2;
                }
                //System.out.println("test");
                //g.drawString("test", side, side);
                if(side>=4){
                    
                    drawTriangle(xpts,ypts, side, g);   //top
                    drawTriangle(xpts,ypts, side, g);   //bott left
                    drawTriangle(xpts,ypts, side, g);   //bott right
                }
    }
    public static int findMidY(int[] ypts){
        int midY=(ypts[0]+ypts[1])/2;
        return midY;
    }
    public static int findMidX(int[] xpts){
        int midX=(xpts[0]+xpts[2])/2;
        return midX;
        
    }
    public static void drawBTriangle(int[] xpts, int[] ypts, int side, Graphics g){
        g.fillPolygon(xpts, ypts, 3);
        ypts[0]=side/2;
        ypts[2]=side/2;
        ypts[1]=side;
        xpts[0]=side/4;
        xpts[2]=side-(side/4);
        xpts[1]=side/2;
        
        //flipYPoints(ypts);    
    }
    /*
    this code prints the correct amount of triangles
    they are white and go off to the top left corner
    they shink to the correct size
    they get over lapped because I cant get them to go to the correct location
    I could not get the triangles to do anything other than go off to the top left corner
    */
}
