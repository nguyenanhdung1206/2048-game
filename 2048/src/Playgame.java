
import java.util.Random;
import java.util.Scanner;


public class Playgame {
    private int gamerow;
    private int gamecolumn;
    private Box gamebox;
    public Playgame(int r, int c){
        gamerow=r;
        gamecolumn=c;
        gamebox = new Box(gamerow,gamecolumn);
    }
    private String[] newrandomvalues = {" "," "," "," "," "," "," "," "," "," "," ","2"," "," "," "," "," "," "," "," "," "," "," "};
    
    public String getrandomvalue(){
        Random ran = new Random();
        int x = ran.nextInt(23);
        String value = null;
        for(int i=0;i<newrandomvalues.length-1;i++){
            value = newrandomvalues[x];
        }
        return value;
    }
    
    public void startGame(){
        for(int i=1;i<gamebox.getRow()-1;i++){
            for(int j=1;j<gamebox.getColumn()-1;j++){
                gamebox.addvalue(getrandomvalue(),i,j);
            }
        }
        gamebox.printbox();
    }
    
    public void insertRandomValues(){
        for(int i=1;i<gamebox.getRow()-1;i++){
            for(int j=1;j<gamebox.getColumn()-1;j++){
                if(gamebox.getOurbox()[i][j]==" "){
                    gamebox.getOurbox()[i][j]=getrandomvalue();
                }
            }
        }
    }
    
    public void playermove(){
        boolean keepPlaying=true;
        Scanner scan= new Scanner(System.in);
        String str;
        while(keepPlaying==true){
            System.out.print("Next move ? :");
            str=scan.nextLine();
            if("up".equals(str) || "down".equals(str) || "left".equals(str) || "right".equals(str)){
                gamebox.move(str);
                insertRandomValues();
                gamebox.printbox();
            }
            if(str.equals("stop playing")){
                System.out.println("Game ended");
                keepPlaying=false;
            }
        }
    }
}
