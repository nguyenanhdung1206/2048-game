
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testbutton extends Frame implements ActionListener{
    TextField text = new TextField(20);
    Button b;
    private int numClicks = 0;
    public testbutton(String title) {
        super(title);
                setLayout(new FlowLayout());
                b = new Button("Click me");
                add(b);
                add(text);
                b.addActionListener(this);
    }

    public static void main(String[] args) {
        testbutton myWindow = new testbutton("My first window");
                myWindow.setSize(350,100);
                myWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        numClicks++;
        text.setText("Button Clicked " + numClicks + " times");
    }
    
}
