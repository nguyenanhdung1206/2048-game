

import java.io.IOException;
import java.lang.reflect.Array;

public class Box {
    private int row;
    private int column;
    private String[][] ourbox;
    public Box(int r, int c){
        row = r;
        column=c;
        ourbox = new String[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getOurbox() {
        return ourbox;
    }
     
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
    
    public void printbox(){
        System.out.println("_________________________________");
        for(int i=0;i<ourbox.length;i++){
            for(int j=0;j<ourbox[i].length;j++){
                System.out.print(ourbox[i][j]);
            }
        }
    }
    
    public void addvalue(String val,int y,int x){
        ourbox[y][x]= val;
        createbox();
    }
    
    //moving//
    boolean isFirstnum=true;

    
    public void moveup(){
        int count=0;
        for(int j=1;j<ourbox[1].length-1;j++){
            for(int i=1;i<ourbox.length-1;i++){
                if(ourbox[i][j]!=" " && i>1){
                    int k = i;
                    count++;
                    while(ourbox[k-1][j]== " "){
                        ourbox[k-1][j]=ourbox[k][j];
                        ourbox[k][j]=" ";
                        k--;
                    }
                    if(count>=2){
                        isFirstnum=true;
                    }
                    if(ourbox[k-1][j].equals(ourbox[k][j]) && isFirstnum==true){
                        int temp = Integer.parseInt(ourbox[k-1][j]);
                        temp=temp*2;
                        ourbox[k-1][j]=Integer.toString(temp);
                        ourbox[k][j]=" ";
                        isFirstnum=false;
                        count=0;
                    }
                }
            }
            isFirstnum=true;
        }
    }
    
    public void movedown(){
        int count=0;
        for(int j=1;j<ourbox[1].length-1;j++){
            for(int i=ourbox.length-2;i>0;i--){
                if(ourbox[i][j]!=" " && i<ourbox.length-2){
                    int k = i;
                    count++;
                    while(ourbox[k+1][j]==" "){
                        ourbox[k+1][j]=ourbox[k][j];
                        ourbox[k][j]=" ";
                        k++;
                    }
                    if(count>=2){
                        isFirstnum=true;
                    }
                    if(ourbox[k+1][j].equals(ourbox[k][j]) && isFirstnum==true){
                        int temp = Integer.parseInt(ourbox[k+1][j]);
                        temp=temp*2;
                        ourbox[k+1][j]=Integer.toString(temp);
                        ourbox[k][j]=" ";
                        isFirstnum=false;
                        count=0;
                    }
                }
            }
            isFirstnum=true;
        }
    }
    
    public void moveright(){
        int count=0;
        for(int i=1;i<ourbox.length-1;i++){
            for(int j=ourbox[i].length-2;j>0;j--){
                if(ourbox[i][j]!=" " && j<ourbox[i].length-2){
                    int k = j;
                    count++;
                    while(ourbox[i][k+1]==" "){
                        ourbox[i][k+1]=ourbox[i][k];
                        ourbox[i][k]=" ";
                        k++;
                    }
                    if(count>=2){
                        isFirstnum=true;
                    }
                    if(ourbox[i][k+1].equals(ourbox[i][k]) && isFirstnum==true){
                        int temp = Integer.parseInt(ourbox[i][k+1]);
                        temp=temp*2;
                        ourbox[i][k+1]=Integer.toString(temp);
                        ourbox[i][k]=" ";
                        isFirstnum=false;
                        count=0;
                    }
                }
            }
            isFirstnum=true;
        }
    }
    
    public void moveleft(){
        int count=0;
        for(int i=1;i<ourbox.length-1;i++){
            for(int j=1;j<ourbox[i].length-1;j++){
                if(ourbox[i][j]!=" " && j>1){
                    int k = j;
                    count++;
                    while(ourbox[i][k-1]==" "){
                        ourbox[i][k-1]=ourbox[i][k];
                        ourbox[i][k]=" ";
                        k--;
                    }
                    if(count>=2){
                        isFirstnum=true;
                    }
                    if(ourbox[i][k-1].equals(ourbox[i][k]) && isFirstnum==true){
                        int temp = Integer.parseInt(ourbox[i][k-1]);
                        temp=temp*2;
                        ourbox[i][k-1]=Integer.toString(temp);
                        ourbox[i][k]=" ";
                        isFirstnum=false;
                        count=0;
                    }
                }
            }
            isFirstnum=true;
        }
    }

    public void move(String howtomove){
        switch(howtomove){
            case "up":
                moveup();
                break;
            case "down":
                movedown();
                break;
            case "left":
                moveleft();
                break;
            case "right":
                moveright();
                break;
        }
    }
}
