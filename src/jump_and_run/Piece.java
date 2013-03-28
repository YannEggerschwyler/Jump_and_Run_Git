package jump_and_run;

import java.awt.Frame;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;


public class Piece {
    
    private Animation piece;
    private int frame;
   
    public Piece() throws SlickException{
        Image[] images_anim = {new Image("icones/piece_1.png"), 
            new Image("icones/piece_2.png"),
            new Image("icones/piece_3.png"),
            new Image("icones/piece_4.png"),
            new Image("icones/piece_5.png"),
            new Image("icones/piece_6.png"),
            new Image("icones/piece_7.png")};
            int[] duration = {300, 300, 300, 300, 300, 300, 300};
            piece = new Animation(images_anim, duration,true);
            frame = piece.getFrame();
            //System.out.println("nombre de frames:"+ piece.getFrameCount());
            
           
    }

    public Animation getPiece() {
        return piece;
    }

    
    public void setShape_piece() {
        
    }

    public int getFrame() {
        return frame;
    }

    public void setPiece(Animation piece) {
        this.piece = piece;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }
    
    
    
    
    
    
}
