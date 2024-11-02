import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

 class test extends JFrame{
    private void test1(String reg5){ 
        setTitle("PORTAL");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String regNo=reg5;
        
        JButton Button=new JButton("exit");
        add(Button,BorderLayout.SOUTH);

        JButton Button1=new JButton("profile");
        add(Button1,BorderLayout.NORTH);

        JButton Button2=new JButton("ACADEMIC");
        add(Button2,BorderLayout.CENTER);
        
        
    }

   public static void securityAnalyzer (){    
     final String password="10000d";   
        JPanel Panel=new JPanel(new GridBagLayout()); 
        GridBagConstraints gdc =new GridBagConstraints();
        gdc.insets=new Insets(10, 10, 10, 10) ;
        gdc.fill=GridBagConstraints.HORIZONTAL;             
        Panel.setBackground(Color.BLUE);

        JLabel Label=new JLabel("USER NAME:");
        gdc.gridx=0;
        gdc.gridy=0;
        Panel.add(Label,gdc);
       
        JTextField usernamefField=new JTextField();
        gdc.gridx=0;
        gdc.gridy=1;
        Panel.add(usernamefField,gdc);

        JLabel Label1=new JLabel("PASSWORD:");
        gdc.gridx=0;
        gdc.gridy=2;
        Panel.add(Label1,gdc);

        JPasswordField PasswordField=new JPasswordField();
        gdc.gridx=0;
        gdc.gridy=3;
        Panel.add(PasswordField,gdc);

        String username=usernamefField.getText();
        String regNo=username;
        String Password=PasswordField.getPassword().toString();
        int opt=JOptionPane.showConfirmDialog(null,new JScrollPane(Panel),"......",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(opt==JOptionPane.OK_OPTION){
            if(Password.equals(password)){
                test1(regNo);
      
            }
            else{
                JOptionPane.showMessageDialog(null,"invalid credentials","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        else{
            System.exit(1);
        }
  
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            securityAnalyzer();
        });
    }
 }