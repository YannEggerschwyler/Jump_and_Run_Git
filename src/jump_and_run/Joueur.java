/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jump_and_run;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Yann
 */
public class Joueur {
    
    private Animation joueur, up, down, left, right, jump_right, jump_left;
    private Shape corps_millieu;
    private Shape tete_millieu;
    private Shape reste_gauche;
    private Shape futur_corps_gauche;
    private Shape futur_tete_gauche; 
    private Shape futur_corps_droite;
    private Shape futur_tete_droite;
    private Shape futur_corps_bas;
    private Shape futur_corps_haut;
    private Shape futur_tete_haut;
    private float x, y;
    private Vie vies[];
    private Shape[]tab;
    private int pieces_joueur;
    public Joueur() throws SlickException {
        
        
        Image[] move_up = {new Image("sprite/amg_hautdroite.png"), new Image("sprite/amg_hautgauche.png")};
        Image[] move_down = {new Image("sprite/amg_basdroite.png"), new Image("sprite/amg_basgauche.png")};
        Image[] move_left = {new Image("sprite/amg_reggauche.png"), new Image("sprite/amg_pasgauche.png")};
        Image[] move_right = {new Image("sprite/amg_regdroit.png"), new Image("sprite/amg_pasdroit.png")};
        Image[] move_jump_left = {new Image("sprite/amg_jump_left.png"), new Image("sprite/amg_jump_left_2.png")};
        Image[] move_jump_right = {new Image("sprite/amg_jump_right.png"), new Image("sprite/amg_jump_right_2.png")};
        int[] duration = {300, 300};
        int[] duration_2 = {500, 500};
        up = new Animation(move_up, duration, true);
        down = new Animation(move_down, duration, true);
        left = new Animation(move_left, duration, true);
        right = new Animation(move_right, duration, false);
        jump_left = new Animation(move_jump_left, duration_2, true);
        jump_right = new Animation(move_jump_right, duration_2, true);
        x=240;
        y = 320;
        tab= new Shape[9];
        //------------------------ Corps au millieu------------------------------
        corps_millieu = new Rectangle (x +3, y+14, 26,18);
        tete_millieu = new Rectangle (x +6, y+0, 20,14);
        reste_gauche = new Rectangle (x +24, y+11, 6,6);
        // ------------------------------- obstacles, Sol etc..
       
        //------------------------ Corps au millieu
        futur_corps_gauche =  new Rectangle(0, 0, 2, corps_millieu.getHeight());
        futur_tete_gauche = new Rectangle(0,0, tete_millieu.getWidth(), tete_millieu.getHeight());
        //----------------------------- Droite de corps et de tete
        futur_corps_droite =  new Rectangle(0, 0, 2, corps_millieu.getHeight());
        futur_tete_droite = new Rectangle(0,0, tete_millieu.getWidth(), tete_millieu.getHeight());
        //----------------------------- Haut et bas
        futur_corps_bas = new Rectangle(0,0, corps_millieu.getWidth()-2,2);
        futur_corps_haut = new Rectangle(0,0, tete_millieu.getWidth(), tete_millieu.getHeight());
        futur_tete_haut = new Rectangle(tete_millieu.getX(),tete_millieu.getY()-2,tete_millieu.getWidth(),tete_millieu.getHeight());
        //--------------------------------------------------
        futur_corps_gauche.setX(corps_millieu.getX()-2);
        futur_corps_gauche.setY(corps_millieu.getY());
        
        reste_gauche.setX(corps_millieu.getX());
        reste_gauche.setY(corps_millieu.getY());
        
        futur_tete_gauche.setX(tete_millieu.getX()-2);
        futur_tete_gauche.setY(tete_millieu.getY());
        
        futur_corps_droite.setY(corps_millieu.getY());
        futur_corps_droite.setX(corps_millieu.getMaxX()+2);
        
        futur_tete_droite.setX(tete_millieu.getX()+2);
        futur_tete_droite.setY(tete_millieu.getY());
        
        futur_corps_bas.setY(corps_millieu.getMaxY()+2);
        futur_corps_bas.setX(corps_millieu.getX()+1);
        
        futur_corps_haut.setY(corps_millieu.getY() -2);
        futur_corps_haut.setX(corps_millieu.getX());
        tab[7]=futur_corps_bas;
        tab[1]=reste_gauche;
        tab[8]=tete_millieu;
        tab[3]=futur_tete_gauche; 
        tab[4]=futur_corps_haut;
        tab[5]=futur_corps_droite;
        tab[0]=futur_tete_gauche;
        tab[6]=corps_millieu;
        tab[2]=futur_tete_haut;
        
        joueur = right;
        vies = new Vie[3];
        for (int i= 0; i<3; i++){
           vies[i]= new Vie(); 
        }
        pieces_joueur = 0;
        
        
    }
    public String getNbrVies() {
        String ret = ""+this.vies.length;
        return ret;
    }
    
     public void enleve_Vies() {
         Vie[] vie_re;
         vie_re = new Vie[this.vies.length-1];
         this.vies= vie_re;
    }
     
     public int getNbr_Pieces() {
        return this.pieces_joueur;
     }
     public void ajoute_Piece(){



         this.pieces_joueur +=1;
         
         
         
      }

    public Animation getJoueur() {
        return joueur;
    }

    public Animation getUp() {
        return up;
    }

    public Animation getDown() {
        return down;
    }

    public Animation getLeft() {
        return left;
    }

    public Animation getRight() {
        return right;
    }

    public Animation getJump_right() {
        return jump_right;
    }

    public Animation getJump_left() {
        return jump_left;
    }

    public Shape getCorps_millieu() {
        return corps_millieu;
    }

    public Shape getTete_millieu() {
        return tete_millieu;
    }

    public Shape getReste_gauche() {
        return reste_gauche;
    }

    public Shape getFutur_corps_gauche() {
        return futur_corps_gauche;
    }

    public Shape getFutur_tete_gauche() {
        return futur_tete_gauche;
    }

    public Shape getFutur_corps_droite() {
        return futur_corps_droite;
    }

    public Shape getFutur_tete_droite() {
        return futur_tete_droite;
    }

    public Shape getFutur_corps_bas() {
        return futur_corps_bas;
    }

    public Shape getFutur_corps_haut() {
        return futur_corps_haut;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Shape[] getTab() {
        return tab;
    }
    
     public Shape getTabShape(int i) {
        return tab[i];
    }

    public void setJoueur(Animation joueur) {
        this.joueur = joueur;
    }

    public void setTab(Shape[] tab) {
        this.tab = tab;
    }

    public void setUp(Animation up) {
        this.up = up;
    }

    public void setDown(Animation down) {
        this.down = down;
    }

    public void setLeft(Animation left) {
        this.left = left;
    }

    public void setRight(Animation right) {
        this.right = right;
    }

    public void setJump_right(Animation jump_right) {
        this.jump_right = jump_right;
    }

    public void setJump_left(Animation jump_left) {
        this.jump_left = jump_left;
    }

    public void setCorps_millieu(Shape corps_millieu) {
        this.corps_millieu = corps_millieu;
    }

    public void setTete_millieu(Shape tete_millieu) {
        this.tete_millieu = tete_millieu;
    }

    public void setReste_gauche(Shape reste_gauche) {
        this.reste_gauche = reste_gauche;
    }

    public void setFutur_corps_gauche(Shape futur_corps_gauche) {
        this.futur_corps_gauche = futur_corps_gauche;
    }

    public void setFutur_tete_gauche(Shape futur_tete_gauche) {
        this.futur_tete_gauche = futur_tete_gauche;
    }

    public void setFutur_corps_droite(Shape futur_corps_droite) {
        this.futur_corps_droite = futur_corps_droite;
    }

    public void setFutur_tete_droite(Shape futur_tete_droite) {
        this.futur_tete_droite = futur_tete_droite;
    }

    public void setFutur_corps_bas(Shape futur_corps_bas) {
        this.futur_corps_bas = futur_corps_bas;
    }

    public void setFutur_corps_haut(Shape futur_corps_haut) {
        this.futur_corps_haut = futur_corps_haut;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Shape getFutur_tete_haut() {
        return futur_tete_haut;
    }
    
    
    public void setShapes_joueur(float vertical_speed){
         this.corps_millieu.setY(this.corps_millieu.getY()+ vertical_speed);
         this.tete_millieu.setY(this.tete_millieu.getY()+ vertical_speed);
         this.futur_corps_gauche.setY(this.futur_corps_gauche.getY()+ vertical_speed);
         this.futur_tete_gauche.setY(this.futur_tete_gauche.getY()+ vertical_speed);
         this.futur_corps_droite.setY(this.futur_corps_droite.getY()+ vertical_speed);
         this.futur_tete_droite.setY(this.futur_tete_droite.getY()+ vertical_speed);
         this.futur_corps_bas.setY(this.futur_corps_bas.getY()+ vertical_speed);
         this.futur_corps_haut.setY(this.futur_corps_haut.getY()+ vertical_speed);
         this.reste_gauche.setY(this.corps_millieu.getY()+ vertical_speed);
         this.futur_tete_haut.setY(this.futur_tete_haut.getY()+ vertical_speed);
    }
    
    public void setShapes_joueur2(float vertical_speed){
         this.corps_millieu.setX(this.corps_millieu.getX()+ vertical_speed);
         this.tete_millieu.setX(this.tete_millieu.getX()+ vertical_speed);
         this.futur_corps_gauche.setX(this.futur_corps_gauche.getX()+ vertical_speed);
         this.futur_tete_gauche.setX(this.tete_millieu.getX()+ vertical_speed);
         this.futur_corps_droite.setX(this.futur_corps_droite.getX()+ vertical_speed);
         this.futur_tete_droite.setX(this.tete_millieu.getX()+ vertical_speed);
         this.futur_corps_bas.setX(this.futur_corps_bas.getX()+ vertical_speed);
         this.futur_corps_haut.setX(this.corps_millieu.getX()+ vertical_speed);
         this.reste_gauche.setX(this.corps_millieu.getX()+ vertical_speed);
         this.futur_tete_haut.setX(this.futur_tete_haut.getX()+ vertical_speed);
    }
    
    
    
    
}
