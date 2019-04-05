
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game implements KeyListener,ActionListener{
    
    private GameGUI gamePlatform = new GameGUI();                           //Our main game platform//
    private GameMechanics ourgameMechanics = new GameMechanics(6,6);        //Create mechanics for the game//
    private JLabel scoreValue = new JLabel("",JLabel.CENTER);               //Label contains value of highscore//
    private JLabel[] arrayOfLabels = new JLabel[36];                        //Contain labels in the game box//
    private int k=0;                                                        //For iterating each label in game box//
    private JButton undoButton = new JButton("Undo");                       //Undo button//    
    private JButton redoButton = new JButton("Redo");                       //Undo button//    
    
    public Game(){
        //Create new game with it's mechanics//
        ourgameMechanics.startGame();
        
        //Set and add the score , the buttons//
        scoreValue.setFont (new Font("Arial", Font.BOLD, 20));
        scoreValue.setForeground(Color.white);
        gamePlatform.getHighscorePanel().add(scoreValue);
        gamePlatform.getUndoRedoPanel().add(undoButton);
        gamePlatform.getUndoRedoPanel().add(redoButton);
        
        //Listener for buttons and arrow keys//
        undoButton.addActionListener(this);
        undoButton.setFocusable(false);
        redoButton.addActionListener(this);
        redoButton.setFocusable(false);
        gamePlatform.addKeyListener(this);
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
                label.setBackground(Color.gray);
                label.setBorder(BorderFactory.createLineBorder(Color.gray.darker(),5));
                label.setFont(new Font("Arial", Font.BOLD, 40));
                label.setPreferredSize(new Dimension(70, 70));
                arrayOfLabels[k]=label;
                setColor(k);
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
                setColor(k);
                k++;
            }
        }
        checkWin();
        checkLose();
        scoreValue.setText(ourgameMechanics.getScore());
        gamePlatform.setVisible(true);
    }
    
    //Set some colors for the numbers//
    public void setColor(int position){
        switch(arrayOfLabels[position].getText()){
            case "2":
                arrayOfLabels[position].setBackground(Color.LIGHT_GRAY);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "4":
                arrayOfLabels[position].setBackground(Color.WHITE);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "8":
                arrayOfLabels[position].setBackground(Color.CYAN.darker());
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "16":
                arrayOfLabels[position].setBackground(Color.CYAN);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "32":
                arrayOfLabels[position].setBackground(Color.pink.darker());
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "64":
                arrayOfLabels[position].setBackground(Color.pink);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "128":
                arrayOfLabels[position].setBackground(Color.orange.darker());
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "256":
                arrayOfLabels[position].setBackground(Color.yellow.darker());
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "512":
                arrayOfLabels[position].setBackground(Color.green);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 40));
                break;
            case "1024":
                arrayOfLabels[position].setBackground(Color.orange);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 30));
                break;
            case "2048":
                arrayOfLabels[position].setBackground(Color.YELLOW);
                arrayOfLabels[position].setFont(new Font("Arial", Font.BOLD, 30));
                break;
            default: 
                arrayOfLabels[position].setBackground(Color.gray);
                break;
        }
        arrayOfLabels[position].setOpaque(true);
    }
    
    //Check if you win or not//
    public void checkWin(){
        boolean won =ourgameMechanics.win();
        if(won==true){
            //Create a congratulation label//
            JLabel winlabel = new JLabel("YOU WIN!! Congratulation!! ",JLabel.CENTER);
            winlabel.setBackground(Color.yellow);
            winlabel.setFont(new Font("Arial", Font.BOLD, 50));
            winlabel.setForeground(Color.red);
            winlabel.setOpaque(true);
            
            //Create a congratulation frame//
            JFrame winFrame = new JFrame("Win");           
            winFrame.add(winlabel);
            winFrame.setSize(700, 170);
            winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            winFrame.setLocationRelativeTo(null);
            winFrame.setAlwaysOnTop(true);
            winFrame.setVisible(true);
            winFrame.setResizable(false);
            
            //Remove all listeners//
            gamePlatform.removeKeyListener(this);
            undoButton.removeActionListener(this);
            redoButton.removeActionListener(this);
        }
    }
    
    //Check if you lose or not//
    public void checkLose(){
        boolean lost = ourgameMechanics.lose();
        if(lost==true){
            //Create a lose label//
            JLabel loselabel = new JLabel("Oh no....YOU LOSE...!!",JLabel.CENTER);
            loselabel.setBackground(Color.gray);
            loselabel.setFont(new Font("Arial", Font.BOLD, 50));
            loselabel.setForeground(Color.LIGHT_GRAY);
            loselabel.setOpaque(true);
            
            //Create a lose frame//
            JFrame loseFrame = new JFrame("Lose");           
            loseFrame.add(loselabel);
            loseFrame.setSize(700, 170);
            loseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loseFrame.setLocationRelativeTo(null);
            loseFrame.setAlwaysOnTop(true);
            loseFrame.setVisible(true);
            loseFrame.setResizable(false);
            
            //Remove all listeners//
            gamePlatform.removeKeyListener(this);
            undoButton.removeActionListener(this);
            redoButton.removeActionListener(this);
        }
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
    
    //Listener for the undo redo buttons//
    @Override
    public void actionPerformed(ActionEvent e) {
        k=0;
        //Undo//
        if(undoButton==e.getSource()){
            ourgameMechanics.undo();
            for(int i=1;i<5;i++){
                for(int j=1;j<5;j++){
                    arrayOfLabels[k].setText(ourgameMechanics.getGamebox().getOurbox()[i][j]);
                    setColor(k);
                    k++;
                }
            }
            scoreValue.setText(ourgameMechanics.getScore());
            gamePlatform.setVisible(true);
        }
        
        //Redo//
        if(redoButton==e.getSource()){
            ourgameMechanics.redo();
            for(int i=1;i<5;i++){
                for(int j=1;j<5;j++){
                    arrayOfLabels[k].setText(ourgameMechanics.getGamebox().getOurbox()[i][j]);
                    setColor(k);
                    k++;
                }
            }
            scoreValue.setText(ourgameMechanics.getScore());
            gamePlatform.setVisible(true);
        }
        
    }
}
