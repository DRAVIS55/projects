import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class RandomGenerator1 extends JFrame {
    public RandomGenerator1() {
        super("Random Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new GridBagLayout()); // Changed to 6 rows for better layout
        getContentPane().setBackground(Color.GREEN);

        // Button for generating random numbers
       GridBagConstraints dc=new GridBagConstraints();
       dc.insets=new Insets(5, 5, 10, 10);
       dc.fill=GridBagConstraints.HORIZONTAL;

       JLabel Label=new JLabel();
       Label.setEnabled(false);
       Label.setText("  -    MENU -");
       Label.setBackground(Color.RED);
       Label.setForeground(Color.BLACK);
       dc.gridx=0;
       dc.gridy=0;
       add(Label,dc);

        JButton generatorButton = new JButton("PLAY GAME...");
        generatorButton.addActionListener(e -> {
            String num1="";
            while (num1.isEmpty()) {
                num1=JOptionPane.showInputDialog(null,"enter a random number x from 0-9","input",JOptionPane.PLAIN_MESSAGE); 
            }
            int num=Integer.parseInt(num1);
           if (num>9) {
            JOptionPane.showMessageDialog(null,"enter a number between 0-9 \n the Generator does not recognise number out of this range!","error:",JOptionPane.ERROR_MESSAGE);
            return;
           }
       
           else{
            Random random = new Random();
            int number = random.nextInt(9);
            if (num==number) {
                JOptionPane.showMessageDialog(this, "YOU WIN !"+"the number="+number);
                return;
            }
            
            else{
                JOptionPane.showMessageDialog(this, "YOU LOSE !"+"the number="+number);  
                return;
            }
        }
        });
        dc.gridx=0;
        dc.gridy=1;
        add(generatorButton,dc);
        generatorButton.setBackground(Color.RED);

        JButton HELPBT=new JButton("help");
        HELPBT.setBackground(Color.RED);
        HELPBT.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"the game is a kind a generator that produce number 0-9 \n you guess a number between 0-9 \n \n ensure you enter a number in the range[0-9] \n if it matches with the generated number you win else you lose !","HELP:",JOptionPane.PLAIN_MESSAGE);
        });
        dc.gridx=0;
        dc.gridy=2;
        add(HELPBT,dc);

        JButton INFOBT=new JButton("game info");
        INFOBT.setBackground(Color.RED);
        INFOBT.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"RANDOM NUMBER GENERATOR \n  \n version v.1.200\nPOWERED BY DRAVIS.$$$\n@Dravis2024\n\nWelcome!!!\nYou are ready to play your game","version no",JOptionPane.PLAIN_MESSAGE);
        });
        dc.gridx=0;
        dc.gridy=3;
        add(INFOBT,dc);

        JButton EXITBT=new JButton("EXIT");
        EXITBT.setBackground(Color.RED);
        EXITBT.addActionListener(e->{
            System.exit(0);
        });
        dc.gridx=0;
        dc.gridy=4;
        add(EXITBT,dc);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RandomGenerator1().setVisible(true);
        });
    }
}
