package jump_and_run;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

public class Jump_and_Run extends BasicGame {

    private Joueur player;
    private float x1, y1;
    private static final int Size = 2;
    private int camera_X = 0, camera_Y= 0;
    private Level1 niveau1;
    private String platform_test;
    private Image map_afficher;
    private boolean essaie;
    private boolean jump = false;
    private boolean k = false;
    private Image jump_direction;
    private float vertical_speed = 0.0f;
    private float horizontal_speed= 0.0f;
    private int deplacement_X;
    private int decalageY;
    private float reponse;
    private Sound jump_sound;
    private Sound coin_sound;
    private Music ambiance;
    private String nbr_vies;
    private Image icone_vie;
    private Image icone_pieces;
    private String nbr_pieces;
    private Circle c;
    private Ellipse e;
    private String Piece;
    private int nbr_P;
    private String info;
    

    public Jump_and_Run(String name) {
        super(name);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Jump_and_Run("Game"));
            container.setVSync(true);
            container.setDisplayMode(1000, 480, false);
            container.setTargetFrameRate(60);
            container.isVSyncRequested();
            container.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void init(GameContainer gc) throws SlickException {
        //---------------------Création du joueur-------------------------------
        player= new Joueur();
        player.getJoueur().stop();
        //---------------------Infos system carte graphique---------------------
        System.out.println(GL11.glGetInteger(GL11.GL_MAX_TEXTURE_SIZE));
        //---------------------Creation niveau----------------------------------
        niveau1 = new Level1();
        map_afficher= niveau1.getMap().getSubImage(0, 160, 600, 480);
        //--------------------Mise a 0 des coordonnées sou_map------------------
        camera_X= 0;
        camera_Y= 160;
        reponse = 0;
        //---------------------Sounds-----------------
        jump_sound = new Sound("Sons/jump.wav"); 
        ambiance = new Music("Sons/ambiance.wav");
        coin_sound = new Sound("Sons/coin.wav");
        //------------------------vie et Pieces-----------------
        nbr_vies= "x";
        nbr_P= 0;
        nbr_pieces= "x";
        icone_vie = new Image("icones/vie.png");
        icone_pieces = new Image("icones/piece_1.png");
        niveau1.getPieces_une(0).getPiece().setPingPong(true);
        //-------------------------La mer-------------------------------
        niveau1.getMer().start();
        niveau1.getMer().setLooping(true);
        info = "";  
      
        
       
    }
    

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        
        map_afficher =  niveau1.getMap().getSubImage(camera_X, camera_Y, 600, 480) ;
        String direction;
        Piece= "1";
        nbr_vies= "x"+player.getNbrVies();
        Shape tomber= null;
        niveau1.getMer().start();
        player.getJoueur().setAutoUpdate(false);
        Input test = container.getInput();
        info="";
        info+= "Collision:"+collision() +"\n"+"Fall:"+fall()+
                    "\n"+"Toche ou pas:"+touch()+"\n"+"Vertical speed:"+vertical_speed +"\n"+
                    "y_joueur:"+player.getCorps_millieu().getMaxY()+"\n"+"Camera_X:"+camera_X+"\n"+
                    "Joueur_X:"+player.getX();
        if (test.isKeyDown(Input.KEY_DOWN)) {
            
            System.out.println("Info: ---------------------------------------------------");
            System.out.println("Collision:"+collision());
            System.out.println("Fall:"+fall());
            System.out.println("Toche ou pas:"+touch());
            //System.out.println("Fall_test_y_collision:"+fall_test().getY());
            System.out.println("y_joueur:"+player.getCorps_millieu().getMaxY());
            System.out.println("Vertical speed:"+vertical_speed);
            System.out.println("jump:"+jump);
            System.out.println("Camera_X:"+camera_X);
            System.out.println("Joueur_X:"+player.getX());
            System.out.println("Mer:"+niveau1.getMer_x());
            System.out.println("Pieces:"+player.getNbr_Pieces());
            
            System.out.println("---------------------------------------------------------");
        } 
        deplacement_X = Math.round( delta * 0.1f);
        niveau1.platformes(deplacement_X);
 //-------------------------------------------Platformes---------------------------------------------
        if (fall() == niveau1.getPlatforme()) {
            if (niveau1.getBouger().equals("Right")){
                   player.setX(player.getX()+deplacement_X); 
                   player.setShapes_joueur2(deplacement_X);
                 if(player.getX()> 300){
                     camera_X += deplacement_X;
                     niveau1.setArrierePlan(-(deplacement_X));
                     niveau1.getMer().draw(niveau1.getMer_x(), niveau1.getMer_y());
                     niveau1.decalagePlatforme(-(deplacement_X));
                     player.setX(player.getX()-deplacement_X); 
                     player.setShapes_joueur2(-deplacement_X);
                 }
            }  else {
                player.setX(player.getX()-deplacement_X);
                player.setShapes_joueur2(-deplacement_X);
                if (player.getX() < 30){
                   player.setX(player.getX()+deplacement_X);
                    player.setShapes_joueur2(+deplacement_X);
                    camera_X -= deplacement_X;
                    niveau1.setArrierePlan(+deplacement_X);
                    niveau1.getMer().draw(niveau1.getMer_x(), niveau1.getMer_y());
                    niveau1.decalagePlatforme(+deplacement_X);
                }
            }
        }else {
            if ( fall()== niveau1.getPlatforme2()) {
                if ( niveau1.getBouger2().equals("Right")){
                       player.setX(player.getX()+deplacement_X); 
                       player.setShapes_joueur2(deplacement_X);
                     if(player.getX()> 300){
                         camera_X += deplacement_X;
                         niveau1.setArrierePlan(-(deplacement_X));
                         niveau1.getMer().draw(niveau1.getMer_x(), niveau1.getMer_y());
                         niveau1.decalagePlatforme(-(deplacement_X));
                         player.setX(player.getX()-deplacement_X); 
                         player.setShapes_joueur2(-deplacement_X);
                     }
                }  else {
                        player.setX(player.getX()-deplacement_X);
                        player.setShapes_joueur2(-deplacement_X);
                        if (player.getX() < 30){
                            player.setX(player.getX()+deplacement_X);
                            player.setShapes_joueur2(+deplacement_X);
                            camera_X -= deplacement_X;
                            niveau1.setArrierePlan(+deplacement_X);
                            niveau1.getMer().draw(niveau1.getMer_x(), niveau1.getMer_y());
                            niveau1.decalagePlatforme(+deplacement_X);
                        }
                    }
        }
            
   }
  //------------------------------------- Pieces ------------------------------------------------------------     
       
 for (int m=0; m<niveau1.getPieces().length; m++){
     if (niveau1.getPieces()[m]!= null){
           if (niveau1.getPieces_une(m).getPiece().getFrame()!=niveau1.getPieces_une(m).getFrame()) {
               niveau1.getPieces_une(m).setFrame(niveau1.getPieces_une(m).getPiece().getFrame());
            }  
     }
} 
      
for (int o=0; o<niveau1.getPieces().length; o++){
    if(o< niveau1.getPieces().length){
        if (niveau1.getPieces()[o]!= null){
            for (int p=0; p<7; p++){
                 if (player.getCorps_millieu().intersects(niveau1.getPieces_shape_one(o).getTab_shapes_one(p))||player.getTete_millieu().intersects(niveau1.getPieces_shape_one(o).getTab_shapes_one(p)) ){
                     if (niveau1.getPieces_une(o).getFrame()-1== p){
                           // System.out.println("Piece index: "+niveau1.getPiece_index(niveau1.getPieces_une(o)));
                           // System.out.println("Piece frame: "+niveau1.getPieces_une(o).getFrame());
                           // System.out.println("Piece shape index: "+niveau1.getPieces_shape_one(o).getTab_shape_index(niveau1.getPieces_shape_one(o).getTab_shapes(p)));
                            p= niveau1.getPieces_shape_one(o).getTab_shapes().length;
                            niveau1.suppPiece(niveau1.getPieces_une(o),niveau1.getPieces_shape_one(o));
                            coin_sound.play();
                            player.ajoute_Piece();
                     }     
                 }
            }   
        }   
    }
}
 //------------------------------------- Graviter ------------------------------------------------------------     
     
 if (fall()==null) {  // Si ce n'est pas bloqué en bas
            vertical_speed += 0.1f * delta;
            decalageY= (int)vertical_speed;
    }else {
          vertical_speed = 0.0f; 
          jump = false; 
          if (touch() == true){
            float y_tomber = fall().getY();
            if(player.getCorps_millieu().getY()<y_tomber){
                 float y_play= (player.getCorps_millieu().getY())+19;
                 float y_correction = y_play -y_tomber;
                 player.setY(player.getY()-y_correction);
                 player.setShapes_joueur(-y_correction); 
                // System.out.println("go");
            }
           
          }
     }
 
 if (casse_tete() != null){
     System.out.println("touche avec la tete");
     jump= false;
     vertical_speed += 0.1f * delta;
   if(touch_tete() == true) {
        float y_tomber = casse_tete().getMaxY();
            if(player.getTete_millieu().getY()<y_tomber){
                 float y_play= (player.getTete_millieu().getY());//+19;
                 float y_correction = y_tomber-y_play;
                 player.setY(player.getY()+y_correction+2);
                 player.setShapes_joueur(+y_correction+2); 
                 System.out.println("go");
            }
     
    } 
 }
 
 //-------------------------- Touches gauche ; droites ; haut-------------------------------------------
    if (test.isKeyPressed(Input.KEY_UP) && jump != true) {
            jump_direction = player.getJoueur().getCurrentFrame();
            direction = jump_direction.getResourceReference();
            control_jump_direction(direction);
            //vertical_speed = -1.4f * delta;
            vertical_speed= (float)-23.8;
            jump = true;
            jump_sound.play();
          //  System.out.println("jump height: "+vertical_speed);
            decalageY=Math.round(1.6f * delta);
            if (camera_Y>=0){
                    if (camera_Y- decalageY>=0.0){
                    }
            }
    }
    
    if (test.isKeyDown(Input.KEY_LEFT)) {
            player.setJoueur(player.getLeft());
           player.getJoueur().start();
            player.getJoueur().setAutoUpdate(true);
           
            if ((collision()== null)) {
                if (camera_X-deplacement_X>0.0){
                    if(player.getX()<= 30){
                        camera_X -=deplacement_X;
                        niveau1.setArrierePlan(+deplacement_X);
                        niveau1.getMer().draw(niveau1.getMer_x(), niveau1.getMer_y());
                        niveau1.decalagePlatforme(+deplacement_X);
                    }else {
                         player.setX(player.getX()-(deplacement_X));
                        player.setShapes_joueur2(-(deplacement_X));
                    }
                   }else {
                        if (camera_X-deplacement_X<=0.0){
                            player.setX(player.getX()-(deplacement_X));
                            player.setShapes_joueur2(-(deplacement_X));
                            System.out.println("go-left");
                        }
                }
        } 
    } 
   
    if (test.isKeyDown(Input.KEY_RIGHT)) { 
             player.setJoueur(player.getRight());
             player.getJoueur().start();
            player.getJoueur().setAutoUpdate(true);
            if (collision()== null) {
                    if (camera_X+ deplacement_X<4007){
                        if(player.getX()>= 300){
                        camera_X += deplacement_X;
                        niveau1.setArrierePlan(-deplacement_X);
                        niveau1.getMer().draw(niveau1.getMer_x(), niveau1.getMer_y());
                        niveau1.decalagePlatforme(-deplacement_X);
                        }else {
                            player.setX(player.getX()+(deplacement_X));
                            player.setShapes_joueur2(deplacement_X);
                        }
                     }else {
                        player.setX(player.getX()+(deplacement_X));
                        player.setShapes_joueur2(deplacement_X);
                    }
            }
   }
    
   //----------------------------Reset---------------------------------------- 
   if (player.getY()>480){
       player.enleve_Vies();
        container.reinit();
    }
        // --------------------- Updater Y du joueur
         player.setY(player.getY()+vertical_speed);
        // --------------------- Updater Y des formes shapes du Joueur
         player.setShapes_joueur(vertical_speed);
         player.getJoueur().draw(player.getX(),player.getY());
         
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
       map_afficher.draw(0,0);
       for (int i = 0; i< 15; i++){
           g.setColor(Color.gray);
           if (niveau1.getTabShape(i)== niveau1.getPlatforme() ||niveau1.getTabShape(i)== niveau1.getPlatforme2()){
               g.fill(niveau1.getTabShape(i));
           }else {
               g.setColor(Color.red);
               g.fill(niveau1.getTabShape(i));
           }
       }
       for (int j = 0; j< 9; j++){
           g.setColor(Color.blue); 
           player.getJoueur().draw(player.getX(),player.getY());
           if (player.getTabShape(j)==player.getFutur_corps_droite()){
               g.setColor(Color.yellow);
               g.fill(player.getTabShape(j));
           }
           if (player.getTabShape(j)==player.getFutur_corps_bas()){
               g.setColor(Color.green);
               g.fill(player.getTabShape(j));
           }
           if (player.getTabShape(j)==player.getTete_millieu()){
               g.setColor(Color.black);
               g.fill(player.getTabShape(j));
           }
           if (player.getTabShape(j)==player.getFutur_tete_haut()){
             //  System.out.println("ok");
               g.setColor(Color.white);
               g.fill(player.getTabShape(j));
           }
          
       }
       
       g.setColor(Color.black);
       g.drawString(nbr_vies+player.getNbrVies(), 35, 10);
       g.drawImage(icone_vie , 5, 5);
       g.drawString(nbr_pieces+ player.getNbr_Pieces(), 100, 10);
       System.out.println(info);
       g.drawString(info,300,10);
       g.drawImage(icone_pieces,70,5);
       g.drawAnimation(niveau1.getMer(), niveau1.getMer_x(), niveau1.getMer_y() );
      for (int k = 0; k< niveau1.getPieces().length; k++){
         if (niveau1.getPieces_shape_one(k)!= null){
          for (int n=0; n<7;n++){
              
           g.drawAnimation(niveau1.getPieces_une(k).getPiece(),niveau1.getPieces_coord_un(k)[0], niveau1.getPieces_coord_un(k)[1]);
           niveau1.getPieces_une(k).getPiece().setPingPong(true);
          }
         }
          
      }        
    }
    
    private void setScreen (int dec){
         map_afficher =  niveau1.getMap().getSubImage(dec, camera_Y, 600, 480) ;
    }
 
    private void control_jump_direction(String reference) {
        String pic_ref = reference;
        if (pic_ref.matches("sprite/amg_regdroit.png") || pic_ref.matches("sprite/amg_pasdroit.png")) {
            player.setJoueur(player.getJump_right());
        } else if (pic_ref.matches("sprite/amg_reggauche.png") == true || pic_ref.matches("sprite/amg_pasgauche.png") == true) {
            player.setJoueur(player.getJump_left());
        }
    }
    private Shape collision() {
        Shape re = null;
      if (player.getJoueur() == player.getLeft()){
            for (int i = 0; i< 15; i++){

               if( niveau1.getTabShape(i).intersects(player.getFutur_corps_gauche())== true){
                   re=niveau1.getTabShape(i);
               }
            }
       }else{ 
          if (player.getJoueur() == player.getRight()){
            for (int i = 0; i< 15; i++){
                System.out.println("droite");
               if( niveau1.getTabShape(i).intersects(player.getFutur_corps_droite())== true){
                   re=niveau1.getTabShape(i);
               }
            }  
       }else {
              re= null;
          }
      }
      return re;
    }
     private Shape casse_tete() {
        Shape test = null;
          for (int i = 0; i<15; i++){
               if( niveau1.getTabShape(i).intersects(player.getFutur_tete_haut())== true){
                   test=niveau1.getTabShape(i);
               }
          }
        return test;
    }
    
    
    
    
    private Shape fall() {
        Shape test = null;
          for (int i = 0; i<15; i++){
               if( niveau1.getTabShape(i).intersects(player.getFutur_corps_bas())== true){
                   test=niveau1.getTabShape(i);
               }
          }
        return test;
    }
     private Shape fall_test() {
        Shape test = null;
          for (int i = 0; i<15; i++){
               if( niveau1.getTabShape(i).intersects(player.getCorps_millieu())== true){
                   test=niveau1.getTabShape(i);
               }
          }
        return test;
    }
  
   private boolean touch() {
        boolean test = false;
        float y=0;
        for (int i = 0; i< 15; i++){
               if( niveau1.getTabShape(i).intersects(player.getCorps_millieu())== true){
                   test=true;
                   i =15;
               }
          }
        return test;
    }
     private boolean touch_tete() {
        boolean test = false;
        float y=0;
        for (int i = 0; i< 15; i++){
               if( niveau1.getTabShape(i).intersects(player.getTete_millieu())== true){
                   test=true;
                   i =15;
               }
          }
        return test;
    }
   
}
