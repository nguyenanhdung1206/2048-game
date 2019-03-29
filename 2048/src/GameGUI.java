
//This class is the layout, platform of our game//

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Extends a JFrame to appear//
public class GameGUI extends JFrame{
    private JPanel mainpanel = new JPanel();                                //Main game panel//
    private JPanel panel1 = new JPanel();                                   //Title "2048" panel//
    private JPanel panel2 = new JPanel();                                   //Game box panel//
    private JPanel highscorePanel = new JPanel();                           //High score panel//
    private JPanel undoRedoPanel = new JPanel();                            //Undo/Redo panel//

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public JPanel getHighscorePanel() {
        return highscorePanel;
    }

    public JPanel getUndoRedoPanel() {
        return undoRedoPanel;
    }
    
    public GameGUI() throws HeadlessException {
        //Create game window//
        super("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 735);
        
        //Set main panel layout for the game//
        mainpanel.setLayout(new GridBagLayout());
        mainpanel.setBackground(Color.orange);
        
        //Set panel1 for various contents//
        panel1.setLayout(new GridLayout(1,3));
        
        //Set gamelable for title card "2048"//
        JLabel gamelabel = new JLabel("2048",JLabel.CENTER);
        gamelabel.setFont(new Font("Arial", Font.BOLD, 40));
        gamelabel.setForeground(Color.orange.darker());
        gamelabel.setBorder(BorderFactory.createMatteBorder(5,5,5,0,Color.gray.darker()));
        gamelabel.setOpaque(true);
        panel1.add(gamelabel);
        
        //Set undo/redo panel for undo/redo button//
        JLabel undo = new JLabel("Undo: ",JLabel.CENTER);
        JLabel redo = new JLabel("Redo :",JLabel.CENTER);
        undo.setForeground(Color.white);
        redo.setForeground(Color.white);
        undoRedoPanel.add(undo);
        undoRedoPanel.add(redo);
        undoRedoPanel.setLayout(new GridLayout(2,2));
        undoRedoPanel.setBackground(Color.orange.darker());
        undoRedoPanel.setBorder(BorderFactory.createMatteBorder(5,0,5,0,Color.gray.darker()));
        panel1.add(undoRedoPanel);
        
        //Set highscore panel for highscore //
        highscorePanel.setBorder(BorderFactory.createMatteBorder(5,0,5,5,Color.gray.darker()));
        highscorePanel.setLayout(new GridLayout(2,1));
        highscorePanel.setBackground(Color.orange.darker());
        JLabel highscoreLabel = new JLabel("Score:",JLabel.CENTER);
        highscoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        highscoreLabel.setForeground(Color.white);
        highscorePanel.add(highscoreLabel);        
        panel1.add(highscorePanel);
        
        //Set panel2 for gameplay//
        panel2.setBackground(Color.gray);
        panel2.setLayout(new GridLayout(4,4));
        
        //Set places and constraints for those panels and add to main panel//
        GridBagConstraints layoutconstraints = new GridBagConstraints();
        layoutconstraints.fill=GridBagConstraints.HORIZONTAL;
        layoutconstraints.gridx=0;
        layoutconstraints.gridy=0;
        layoutconstraints.ipady=25;
        mainpanel.add(panel1,layoutconstraints);
        layoutconstraints.gridx=0;
        layoutconstraints.ipady=80;
        layoutconstraints.gridy=1;
        mainpanel.add(panel2,layoutconstraints);
        
        //Create new game with it's mechanics//;
        add(mainpanel);
    }
}
