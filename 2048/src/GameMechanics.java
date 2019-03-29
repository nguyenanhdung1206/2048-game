
//This class represents the mechanics in the game//

import java.util.Random;
import java.util.Scanner;


public class GameMechanics {
    private int gamerow;
    private int gamecolumn;
    private BoxOfMovingParticles gamebox;
    
    public GameMechanics(int r, int c){
        gamerow=r;
        gamecolumn=c;
        gamebox = new BoxOfMovingParticles(gamerow,gamecolumn);
    }
    
    //An array contains blanks and values for randomness//
    private String[] newrandomvalues = {" "," "," "," "," "," "," ","2"," "," "," "," "," "," "," ",
    " "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    
    //Method to get the game box for later use//
    public BoxOfMovingParticles getGamebox() {
        return gamebox;
    }
    
    //Get a random value in the string of blanks and values//
    public String getrandomvalue(){
        Random ran = new Random();
        int x = ran.nextInt(30);
        String value = null;
        for(int i=0;i<newrandomvalues.length-1;i++){
            value = newrandomvalues[x];
        }
        return value;
    }
    
    //Add only 1 random "2" to prevent all blank spaces//
    public void oneRandomValue(){
        Random ran = new Random();
        int y = ran.nextInt(4)+1;
        int x = ran.nextInt(4)+1;
        while(true){
            if(gamebox.getOurbox()[y][x].equals(" ")){
                gamebox.addvalue("2", y, x);
                break;
            }
            else{
                y = ran.nextInt(4)+1;    
                x = ran.nextInt(4)+1;      
            }
        }
    }
    
    //Add random values at the start of the game//
    public void startGame(){
        //Add initial random values into the box//
        for(int i=1;i<gamerow-1;i++){
            for(int j=1;j<gamecolumn-1;j++){
                    gamebox.addvalue(getrandomvalue(),i,j);               //Add values randomly//
            }
        }
        //Prevent empty box from start //
        oneRandomValue();
    }
    
    //Every time we move, a random blank space will get a random value too//
    public void insertRandomValues(){
        for(int i=1;i<gamerow-1;i++){
            for(int j=1;j<gamecolumn-1;j++){
                if(gamebox.getOurbox()[i][j]==" "){
                    gamebox.getOurbox()[i][j]=getrandomvalue();
                }
            }
        }
        //Prevent all insert values are all blank spaces//
        oneRandomValue();
    }
    
    //Movement in the game that moves the particle in the box//
    public void move(String str){
        if("up".equals(str) || "down".equals(str) || "left".equals(str) || "right".equals(str)){
            gamebox.moveParticles(str);
            if(gamebox.isMoveAble()==true){
                insertRandomValues();
            }
        }
    }
}
