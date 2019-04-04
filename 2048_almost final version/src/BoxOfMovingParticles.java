
//This is a box that has particles that can move in certain direction//

public class BoxOfMovingParticles extends BoxOfParticles{
    
    //These two variables will control if a particle will merge with another or not
    //Without these 2, the merge algorithm will function like this: 
    //(2 2 4 2 24) -> (16      ) in just 1 move
    //Reality : (2 2 4 2 24) -> (4444  ) ->(88  ) -> (16  )//
    private boolean mergeable=true;
    private int mergecount=0;
    private boolean moveAble=false;
    
    //Constructor the same as a normal box//
    public BoxOfMovingParticles(int r, int c) {
        super(r, c);
    }

    public boolean isMoveAble() {
        return moveAble;
    }
    
    //Moving methods for each direction//  
    public void moveup(){
        mergecount=0;
        moveAble=false;
        for(int j=1;j<ourbox[1].length-1;j++){
            for(int i=1;i<ourbox.length-1;i++){
                if(ourbox[i][j]!=" " && i>1){
                    int k = i;
                    mergecount++;
                    while(ourbox[k-1][j]== " "){
                        moveAble=true;
                        ourbox[k-1][j]=ourbox[k][j];
                        ourbox[k][j]=" ";
                        k--;
                    }
                    if(mergecount>=2){
                        mergeable=true;
                    }
                    if(ourbox[k-1][j].equals(ourbox[k][j]) && mergeable==true){
                        int temp = Integer.parseInt(ourbox[k-1][j]);
                        temp=temp*2;
                        ourbox[k-1][j]=Integer.toString(temp);
                        ourbox[k][j]=" ";
                        mergeable=false;
                        mergecount=0;
                        moveAble=true;
                    }
                }
            }
            mergeable=true;
        }
    }
    
    public void movedown(){
        mergecount=0;
        moveAble=false;
        for(int j=1;j<ourbox[1].length-1;j++){
            for(int i=ourbox.length-2;i>0;i--){
                if(ourbox[i][j]!=" " && i<ourbox.length-2){
                    int k = i;
                    mergecount++;
                    while(ourbox[k+1][j]==" "){
                        moveAble=true;
                        ourbox[k+1][j]=ourbox[k][j];
                        ourbox[k][j]=" ";
                        k++;
                    }
                    if(mergecount>=2){
                        mergeable=true;
                    }
                    if(ourbox[k+1][j].equals(ourbox[k][j]) && mergeable==true){
                        int temp = Integer.parseInt(ourbox[k+1][j]);
                        temp=temp*2;
                        ourbox[k+1][j]=Integer.toString(temp);
                        ourbox[k][j]=" ";
                        mergeable=false;
                        mergecount=0;
                        moveAble=true;
                    }
                }
            }
            mergeable=true;
        }
    }
    
    public void moveright(){
        mergecount=0;
        moveAble=false;
        for(int i=1;i<ourbox.length-1;i++){
            for(int j=ourbox[i].length-2;j>0;j--){
                if(ourbox[i][j]!=" " && j<ourbox[i].length-2){
                    int k = j;
                    mergecount++;
                    while(ourbox[i][k+1]==" "){
                        moveAble=true;
                        ourbox[i][k+1]=ourbox[i][k];
                        ourbox[i][k]=" ";
                        k++;
                    }
                    if(mergecount>=2){
                        mergeable=true;
                    }
                    if(ourbox[i][k+1].equals(ourbox[i][k]) && mergeable==true){
                        int temp = Integer.parseInt(ourbox[i][k+1]);
                        temp=temp*2;
                        ourbox[i][k+1]=Integer.toString(temp);
                        ourbox[i][k]=" ";
                        mergeable=false;
                        mergecount=0;
                        moveAble=true;
                    }
                }
            }
            mergeable=true;
        }
    }
    
    public void moveleft(){
        mergecount=0;
        moveAble=false;
        for(int i=1;i<ourbox.length-1;i++){
            for(int j=1;j<ourbox[i].length-1;j++){
                if(ourbox[i][j]!=" " && j>1){
                    int k = j;
                    mergecount++;
                    while(ourbox[i][k-1]==" "){
                        moveAble=true;
                        ourbox[i][k-1]=ourbox[i][k];
                        ourbox[i][k]=" ";
                        k--;
                    }
                    if(mergecount>=2){
                        mergeable=true;
                    }
                    if(ourbox[i][k-1].equals(ourbox[i][k]) && mergeable==true){
                        int temp = Integer.parseInt(ourbox[i][k-1]);
                        temp=temp*2;
                        ourbox[i][k-1]=Integer.toString(temp);
                        ourbox[i][k]=" ";
                        mergeable=false;
                        mergecount=0;
                        moveAble=true;
                    }
                }
            }
            mergeable=true;
        }
    }
    
    //Method to take in a direction in form of String and move accordingly//
    public void moveParticles(String howtomove){
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
    
    public BoxOfMovingParticles deepCopy(){
        BoxOfMovingParticles newBox = new BoxOfMovingParticles(row,column);
        for(int i=0;i<ourbox.length;i++){
            for(int j=0;j<ourbox[i].length;j++){
                newBox.addvalue(ourbox[i][j],i,j);
            }
        }
        return newBox;
    }
}
