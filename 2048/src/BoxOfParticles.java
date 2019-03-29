
//This class represent a normal box that you can put particles in//

import java.io.IOException;
import java.lang.reflect.Array;

public class BoxOfParticles {
    protected int row;
    protected int column;
    protected String[][] ourbox;
    
    
    //Our box is basically a 2 dimensional array//
    public BoxOfParticles(int r, int c){
        row = r;
        column=c;
        ourbox = new String[row][column];
    }
    
    //Getter for the array so other classes can use//
    public String[][] getOurbox() {
        return ourbox;
    }
    
    //Create the box//
    public void createbox(){
        for(int i=0;i<ourbox.length;i++){
            for(int j=0;j<ourbox[i].length;j++){
                if(i==0 || i==ourbox.length-1){
                    ourbox[i][j]="-";
                }
                if(j==0){
                    ourbox[i][j]="|";
                }
                if(j==ourbox[i].length-1){
                    ourbox[i][j]="|\n";
                }
                if(ourbox[i][j]==null){
                    ourbox[i][j]=" ";
                }
            }
        }
    }
    
    //Add values to the box at a coordinate//
    public void addvalue(String val,int y,int x){
        ourbox[y][x]= val;
        createbox();
    }
    
}
