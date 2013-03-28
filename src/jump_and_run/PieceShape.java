/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jump_and_run;

import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Yann
 */
public class PieceShape {
    private Shape []tab_shapes = new Shape[7];
    
    public PieceShape(float x, float y){
            Ellipse e = new Ellipse (x,y,12,12);
            Ellipse e2 = new Ellipse (x,y,11,12);// 2,23
            Ellipse e3 = new Ellipse (x,y,6,12);// 6, 18
            Ellipse e4 = new Ellipse (x,y,3,12);// 9,16
            Ellipse e5 = new Ellipse (x,y,6,12);// 6, 18
            Ellipse e6 = new Ellipse (x,y,11,12);// 2,21
            Ellipse e7 = new Ellipse (x,y,12,12);// 2,21
            tab_shapes = new Shape[7];
            tab_shapes[0]= e;
            tab_shapes[1]= e2;
            tab_shapes[2]= e3;
            tab_shapes[3]= e4;
            tab_shapes[4]= e5;
            tab_shapes[5]= e6;
            tab_shapes[6]= e7;  
    }

    public Shape[] getTab_shapes() {
        return tab_shapes;
    }
    public Shape getTab_shapes_one(int i) {
        return tab_shapes[i];
    }
    public int getTab_shape_index(Shape s){
        int i= 0;
        for(int j=0; j < this.tab_shapes.length; j++){
            if (this.tab_shapes[j]== s){
                i= j;
            }
        }
        return i;
    }
    
    
    

    
}
