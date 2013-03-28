
package jump_and_run;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Level1 {
    private Shape sol1;
    private Shape sol2;
    private Shape sol3;
    private Shape sol4;
    private Shape sol5;
    private Shape vertical1;
    private Shape vertical2;
    private Shape vertical3;
    private Shape horiz1;
    private Shape horiz2;
    private Shape horiz3;
    private Shape horiz4;
    private Shape horiz5;
    private Shape platforme;
    private Shape platforme2;
    private float platform_X, platform_Y, platform_max, platform_X_2, platform_max_2;
    private String bouger;
    private String bouger2;
    private String platform_test;
    private BigImage map;
    private int shp_nbr;
    private Shape tab[];
    private Animation mer;
    private int mer_x, mer_y;
    private Piece [] pieces;
    private float [][] pieces_coord;
    private PieceShape [] pieces_shape;
    
    
    public Level1() throws SlickException {
        sol1 = new Rectangle (0,436, 601, 44);
        sol2=  new Rectangle (651, 436, 291,44); 
        sol3= new Rectangle(1083,436, 290, 44); 
        sol4 = new Rectangle(2749,436, 289, 44);
        sol5= new Rectangle(3407,436,1258,44);
        vertical1 = new Rectangle(908,404-159,33,192);
        vertical2= new Rectangle(1227,404-160,33,192);
        vertical3= new Rectangle(2749,371-160,33,225);
        horiz1= new Rectangle(939,355,98,33);
        horiz2= new Rectangle(939,404-159,242,31);
        horiz3= new Rectangle(2685,371-100,65,33);
        horiz4= new Rectangle(3149,540-180,97,32);
        horiz5= new Rectangle(762,330,97,32);
        platforme = new Rectangle (1300, 350, 200,32);
        bouger = "Right";
        bouger2= "Left";
        platform_X = 1300;
        platform_Y= 50;
        platform_max= 1800;
        platforme2 = new Rectangle (2500, 350, 200,32);
        platform_X_2 = 2000;
        platform_max_2= 2500;
        map = new BigImage("maps/map.png");
        tab = new Shape[15];
        tab[0] = sol1;
        tab [1]= sol2;
        tab[2] = sol3;
        tab [3]= sol4;
        tab[4] = sol5;
        tab [5]= horiz1;
        tab[6] = horiz2;
        tab [7]= horiz3;
        tab[8] = horiz4;
        tab [9]= horiz5;
        tab[10] = vertical3;
        tab [11]= vertical2;
        tab[12] = vertical1;
        tab [13]= platforme;
        tab[14] = platforme2;
        Image[] tab_mer = {new Image("maps/mer.png"), new Image("maps/mer2.png")};
        int[] duration = {500, 500};
        mer = new Animation(tab_mer, duration,true);
        mer_x= 1372;
        mer_y= 452;
        pieces = new Piece[30];
        for (int i= 0; i<pieces.length;i++){
            pieces[i]= new Piece();
        }
        pieces_coord = new float[30][2];
        int decalage=290;
        for (int k= 0; k< pieces_coord.length;k++){
            if (k<5){//----------------------Premiers 5
                for (int j= 0; j<2;j++){
                    if (j==0) {
                         pieces_coord[k][j]= decalage;
                    }else {
                         pieces_coord[k][j]=380;
                          System.out.println(pieces_coord[k][j]);
                    }
                   decalage += 30; 
                }
            }
            if (k==5 ){
                decalage += 150;
            }//----------------------5 à 10
           if (k>=5 && k<10){
                for (int j= 0; j<2;j++){
                
                if (j==0) {
                     pieces_coord[k][j]=decalage;
                }else {
                     pieces_coord[k][j]=380;
                }
                System.out.println(pieces_coord[k][j]);
               
            }
                 decalage += 30;
            }   
           
           if (k==10 ){
                decalage += 55;
            }//----------------------5 à 10
           if (k>=10 && k<13 ){
                for (int j= 0; j<2;j++){
                
                if (j==0) {
                     pieces_coord[k][j]=decalage;
                }else {
                     pieces_coord[k][j]=280;
                }
                System.out.println(pieces_coord[k][j]);
               
            }
                 decalage += 30;
            }   
           
           if (k==13){
                decalage += 185;
            }//----------------------5 à 10
           if (k>=13 && k<15){
                for (int j= 0; j<2;j++){
                
                if (j==0) {
                     pieces_coord[k][j]=decalage;
                }else {
                     pieces_coord[k][j]=200;
                }
                System.out.println(pieces_coord[k][j]);
               
            }
                 decalage += 30;
            }
           if (k==15){
                decalage += 200;
            }//----------------------5 à 10
           if (k>=15){
                for (int j= 0; j<2;j++){
                
                if (j==0) {
                     pieces_coord[k][j]=decalage;
                }else {
                     pieces_coord[k][j]=280;
                }
                System.out.println(pieces_coord[k][j]);
               
            }
                 decalage += 30;
            }   
            
        }
        
        pieces_shape= new PieceShape [30];
        int l;
        for (l = 0; l< pieces_shape.length; l++){
            pieces_shape[l]= new PieceShape (pieces_coord[l][0]+12, pieces_coord[l][1]+12);
            //System.out.println("x"+pieces_coord[l][1]);
        }
    
    }

    public Level1(Shape sol1, Shape sol2, Shape sol3, Shape sol4, Shape sol5, Shape vertical1, Shape vertical2, Shape vertical3, Shape horiz1, Shape horiz2, Shape horiz3, Shape platforme, Shape platforme2, float platform_X, float platform_Y, float platform_max, float platform_X_2, float platform_max_2, String bouger, String bouger2, String platform_test, BigImage map) throws SlickException {
        this.sol1 = sol1;
        this.sol2 = sol2;
        this.sol3 = sol3;
        this.sol4 = sol4;
        this.sol5 = sol5;
        this.vertical1 = vertical1;
        this.vertical2 = vertical2;
        this.vertical3 = vertical3;
        this.horiz1 = horiz1;
        this.horiz2 = horiz2;
        this.horiz3 = horiz3;
        this.platforme = platforme;
        this.platforme2 = platforme2;
        this.platform_X = platform_X;
        this.platform_Y = platform_Y;
        this.platform_max = platform_max;
        this.platform_X_2 = platform_X_2;
        this.platform_max_2 = platform_max_2;
        this.bouger = bouger;
        this.bouger2 = bouger2;
        this.platform_test = platform_test;
        this.map = map;
        this.tab = new Shape[13];
        this.tab[0] = sol1;
        this.tab [1]= sol2;
        this.tab[2] = sol3;
        this.tab [3]= sol4;
        this.tab[4] = sol5;
        this.tab [5]= horiz1;
        this.tab[6] = horiz2;
        this.tab [7]= horiz3;
        this.tab[8] = horiz4;
        this.tab [9]= horiz5;
        this.tab[10] = vertical3;
        this.tab [11]= vertical2;
        this.tab[12] = vertical1;
        this.tab [13]= platforme;
        this.tab[14] = platforme2;
        
        
    }
    
    public void suppPiece(Piece p, PieceShape ps){
       // Piece[]t_echange = new Piece[this.pieces.length-1];
      //  PieceShape[] ps_echange= new PieceShape[this.pieces_shape.length-1];
        for(int i= 0; i<this.pieces.length; i++){
            if (p== this.pieces[i]){
                System.out.println("num de la piece: "+i);
                this.pieces[i]= null;
                this.pieces_shape[i]= null;
            }
        }
       /* int compteur= 0;
         for(int j= 0; j<this.pieces.length; j++){
            if (this.pieces[j]!=null){
                t_echange[compteur]= this.pieces[j];
                ps_echange[compteur]= this.pieces_shape[j];
                compteur++;
            }
        }*/
       // this.pieces= t_echange; 
       // this.pieces_shape= ps_echange;
    }

    //--------------------- Getters -----------------------------------------
    public Shape getSol1() {
        return sol1;
    }

    public PieceShape[] getPieces_shape() {
        return pieces_shape;
    }
      public PieceShape getPieces_shape_one(int i) {
        //  System.out.println("i"+i);
        return pieces_shape[i];
    }
   

    public Shape getPlatforme() {
        return platforme;
    }

    public Shape getPlatforme2() {
        return platforme2;
    }

    public float getPlatform_X() {
        return platform_X;
    }

    public Animation getMer() {
        return mer;
    }

    public float[][] getPieces_coord() {
        return pieces_coord;
    }
     public float[] getPieces_coord_un(int i) {
        return pieces_coord[i];
    }
    
    

    public float getPlatform_Y() {
        return platform_Y;
    }

    public float getPlatform_max() {
        return platform_max;
    }

    public float getPlatform_X_2() {
        return platform_X_2;
    }

    public float getPlatform_max_2() {
        return platform_max_2;
    }

    public String getBouger() {
        return bouger;
    }

    public Piece[] getPieces() {
        return pieces;
    }
     public Piece getPieces_une(int i) {
        return pieces[i];
    }
     public int getPiece_index(Piece p){
         int k= 0;
         for (int i= 0; i<this.pieces.length; i++){
             if (p== this.pieces[i]){
                 k = i;
             }
         }
         return k;
     }
    

    public String getBouger2() {
        return bouger2;
    }

    public Shape getSol2() {
        return sol2;
    }

    public Shape getSol3() {
        return sol3;
    }

    public Shape getSol4() {
        return sol4;
    }

    public Shape getSol5() {
        return sol5;
    }

    public Shape getVertical1() {
        return vertical1;
    }

    public Shape getVertical2() {
        return vertical2;
    }

    public Shape getVertical3() {
        return vertical3;
    }

    public Shape getHoriz1() {
        return horiz1;
    }

    public Shape getHoriz2() {
        return horiz2;
    }

    public Shape getHoriz3() {
        return horiz3;
    }

    public Shape getHoriz4() {
        return horiz4;
    }

    public Shape getHoriz5() {
        return horiz5;
    }

    public String getPlatform_test() {
        return platform_test;
    }

    public BigImage getMap() {
        return map;
    }

    public int getShp_nbr() {
        return shp_nbr;
    }
    public Shape[] getTab() {
        return tab;
    }
    public Shape getTabShape(int i) {
        return tab[i];
    }
    
    
   //-----------------------Setters----------------------------------------------------- 

    public void setPlatforme(Shape platforme) {
        this.platforme = platforme;
    }

    public void setPlatforme2(Shape platforme2) {
        this.platforme2 = platforme2;
    }

    public void setPlatform_X(float platform_X) {
        this.platform_X = platform_X;
    }

    public void setPlatform_Y(float platform_Y) {
        this.platform_Y = platform_Y;
    }

    public void setPlatform_max(float platform_max) {
        this.platform_max = platform_max;
    }

    public void setPlatform_X_2(float platform_X_2) {
        this.platform_X_2 = platform_X_2;
    }

    public void setPlatform_max_2(float platform_max_2) {
        this.platform_max_2 = platform_max_2;
    }

    public void setPlatform_test(String platform_test) {
        this.platform_test = platform_test;
    }

    public void setMap(BigImage map) {
        this.map = map;
    }
    
   //-----------------------Fonctions deplacements ------------------------------------- 
    
    public void platformes(int delta) {
        // -------------------------Platteforme qui bouge
        
        if (platforme.getX()<platform_max && bouger.equals("Right")){
            platforme.setX(platforme.getX()+ (delta)/* * .1f)*/);
        }
        if (platforme.getX()>=platform_max && bouger.equals("Right")){
            bouger ="Left";
        }
        if (platforme.getX()>= platform_X && bouger.equals("Left") ){
            platforme.setX(platforme.getX()- (delta)/* * .1f)*/);
        }
        if (platforme.getX()<platform_X){
            bouger= "Right";
        }
        
        // ------------------------------Deuxieme platforme----------------------
        
        if (platforme2.getX()<platform_max_2 && bouger2.equals("Right")){
            platforme2.setX(platforme2.getX()+ (delta)/* * .1f)*/);
        }
        if (platforme2.getX()>=platform_max_2 && bouger2.equals("Right")){
            bouger2 ="Left";
        }
        if (platforme2.getX()>= platform_X_2 && bouger2.equals("Left") ){
            platforme2.setX(platforme2.getX()- (delta)/* * .1f)*/);
        }
        if (platforme2.getX()<platform_X_2){
            bouger2 = "Right";
        }
    }

    public int getMer_x() {
        return mer_x;
    }

    public int getMer_y() {
        return mer_y;
    }
    
    //---------------------Deplacement Shapes -------------------------------
    
    public void setArrierePlan(float dec){
        this.sol1.setX(this.sol1.getX()+dec);
        this.sol2.setX(this.sol2.getX()+dec);
        this.sol3.setX(this.sol3.getX()+dec); 
        this.sol4.setX(this.sol4.getX()+dec);
        this.sol5.setX(this.sol5.getX()+dec);
        this.vertical1.setX(this.vertical1.getX()+dec);
        this.vertical2.setX(this.vertical2.getX()+dec);
        this.vertical3.setX(this.vertical3.getX()+dec);
        this.horiz1.setX(this.horiz1.getX()+dec);
        this.horiz2.setX(this.horiz2.getX()+dec);
        this.horiz3.setX(this.horiz3.getX()+dec);
        this.horiz4.setX(this.horiz4.getX()+dec);
        this.horiz5.setX(this.horiz5.getX()+dec);
        this.mer_x += dec;
         /*   tableau
                    val2 tableau val1
                                val2
                                      
                    val3 tableau val1
                                  val2*/
        for (int i= 0; i< this.pieces_shape.length; i++){
            if (this.pieces_shape[i]!= null){
                for(int j = 0; j<7; j++){
                    this.pieces_shape[i].getTab_shapes_one(j).setX(this.pieces_shape[i].getTab_shapes_one(j).getX()+ dec);
                }
               // this.pieces[i].getPiece().draw((int)((this.pieces_shape[i].getTab_shapes_one(0).getX()-12)+dec), (int)this.pieces_shape[i].getTab_shapes_one(0).getY()-12);
                this.pieces_coord[i][0]= this.pieces_coord[i][0]+dec;
                }
         }
    }
    
    public void decalagePlatforme (float dec){
        platforme.setX(platforme.getX()+dec);
        platform_X = platform_X+dec;
        platform_max =  platform_max+dec;
        platforme2.setX(platforme2.getX()+dec);
        platform_X_2 = platform_X_2+dec;
        platform_max_2 =  platform_max_2+dec;
    }
    
    
}
