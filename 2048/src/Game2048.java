
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Game2048 implements KeyListener,ActionListener{
    
    private GameGUI gamePlatform = new GameGUI();                           //Our main game platform//
    private GameMechanics ourgameMechanics = new GameMechanics(6,6);        //Create mechanics for the game//
    private JLabel scoreValue = new JLabel("",JLabel.CENTER);           //Label contains value of highscore//
    private JLabel[] arrayOfLabels = new JLabel[36];                        //Contain labels in the game box//
    private int k=0;                                                        //For iterating each label in game box//
    private JButton undoButton = new JButton("Undo");                       //Undo button//
    private JButton redoButton = new JButton("Redo");                       //Undo button//
    
    public Game2048(){
        //Create new game with it's mechanics//
        ourgameMechanics.startGame();
        scoreValue.setFont (new Font("Arial", Font.BOLD, 20));
        gamePlatform.getHighscorePanel().add(scoreValue);
        gamePlatform.getUndoRedoPanel().add(undoButton);
        gamePlatform.getUndoRedoPanel().add(redoButton);
        undoButton.addActionListener(this);
        undoButton.setFocusable(false);
        redoButton.addActionListener(this);
        redoButton.setFocusable(false);
        gamePlatform.addKeyListener(this);
        scoreValue.setForeground(Color.white);
    }
    
    //Start the game//
    public void playGame(){
        //Add initial values in and start the game//
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                String a = ourgameMechanics.getGamebox().getOurbox()[i][j];
                JLabel label = new JLabel(a,JLabel.CENTER);
                label.setOpaque(true);
                gamePlatform.getPanel2().add(label);
                if(a.equals("|") || a.equals("-")|| a.equals("|\n")){
                    label.setForeground(Color.white);
                    label.setBackground(Color.white);
                }
                else {
                    label.setBackground(Color.gray);
                    label.setBorder(BorderFactory.createLineBorder(Color.gray.darker(),5));
                    label.setFont(new Font("Arial", Font.BOLD, 50));
                }
                arrayOfLabels[k]=label;
                k++;
            }
        }
        gamePlatform.setVisible(true);   
    }
    
    //Move according to the key player has pressed//
    public void playersMove(String playersEnteredKey){
        k=0;
        if(playersEnteredKey.equals("stop playing")){
            System.out.println("Game ended");
        }
        ourgameMechanics.move(playersEnteredKey);
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                arrayOfLabels[k].setText(ourgameMechanics.getGamebox().getOurbox()[i][j]);
                k++;
            }
        }
        scoreValue.setText(gethighscore());
        gamePlatform.setVisible(true);
    }
    
    //Method to get the highscore//
    public String gethighscore(){
        int max = 0;
        int currentValue;
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                String a = ourgameMechanics.getGamebox().getOurbox()[i][j];
                if(a!=" "){
                    currentValue = Integer.parseInt(a);
                    if(currentValue > max)
                        max=currentValue;
                }
            }
        }
        return Integer.toString(max);
    }
    
    //Methods of KeyListener//
    @Override
    public void keyTyped(KeyEvent e) {
        //We don't need to use this one//
    }
    
    @Override
    //Use this one to get the arrow keys pressed and move//
    public void keyPressed(KeyEvent e) {
        int keyCode = 0;
        keyCode = e.getKeyCode();
        String movekey;
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                movekey="up";
                break;
            case KeyEvent.VK_DOWN:
                movekey="down"; 
                break;
            case KeyEvent.VK_LEFT:
                movekey="left";
                break;
            case KeyEvent.VK_RIGHT :
                movekey="right";
                break;
            case KeyEvent.VK_ESCAPE:
                movekey="stop playing";
                break;
        default : movekey = "not a move";
        }
        playersMove(movekey);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //We don't need to use this one//
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
