import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.PKCS12Attribute;

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

 
        public class dravUser extends JFrame {
          final String regNum=JOptionPane.showInputDialog(null,"enter registration number","input form",JOptionPane.PLAIN_MESSAGE);
       public dravUser(){
        super("Dravis.$$$ student portal");
       setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);
       
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(20, 20, 20, 20);
        gbc.fill=GridBagConstraints.VERTICAL;

        JPanel entrity=new JPanel(new GridBagLayout());
        entrity.setSize(40,40);
        entrity.setBackground(Color.green);
        add(entrity,BorderLayout.WEST);

        JLabel labe1=new JLabel("student profile");
        labe1.setEnabled(false);
        labe1.setBackground(Color.WHITE);
        labe1.setForeground(Color.RED);
        gbc.gridx=0;
        gbc.gridy=0;
        entrity.add(labe1,gbc);

        JButton ProfileButton=new JButton("PROFILE");
        gbc.gridx=0;
        gbc.gridy=1;
        ProfileButton.addActionListener(e->{
            try{
            Path newPath=Paths.get(regNum+".txt");
            if(Files.exists(newPath)){
                String Deteil=Files.readString(newPath);
                JTextField TextField=new JTextField(Deteil);
                JOptionPane.showMessageDialog(null,new JScrollPane(TextField),"user profile",JOptionPane.PLAIN_MESSAGE);
              
            }
            else{
                String Deteil="\n"+"\n"+"\n"+"no file found"+"\n"+"\n";
                JTextField TextField=new JTextField(Deteil);
                JOptionPane.showMessageDialog(null,new JScrollPane(TextField),"user profile",JOptionPane.PLAIN_MESSAGE);
              
            }}
            catch(IOException i){
                i.printStackTrace();
                JOptionPane.showMessageDialog(null, "errorloading details","error",JOptionPane.ERROR_MESSAGE);
            }
        });
        entrity.add(ProfileButton,gbc);

        JLabel labe2=new JLabel("ACADEMIC");
        labe2.setEnabled(false);
        labe2.setForeground(Color.RED);
        gbc.gridx=0;
        gbc.gridy=2;
        entrity.add(labe2,gbc);
        
        JButton AcademicButton=new JButton("ACADEMIC");
        gbc.gridx=0;
        gbc.gridy=3;
        AcademicButton.addActionListener(e ->{
            try{
            Path acPath=Paths.get(regNum+"ACA.txt");
            if (Files.exists(acPath)) {
                String AcadeDetails=Files.readString(acPath);
                JTextField TextField=new JTextField(AcadeDetails);
                JOptionPane.showMessageDialog(null,new JScrollPane(TextField),"user profile",JOptionPane.PLAIN_MESSAGE);
              
            }
            else{
                String AcadeDetails="\n"+"\n"+"\n"+"no file is found"+"\n"+"\n"+"\n";
                JTextField TextField=new JTextField(AcadeDetails);
                JOptionPane.showMessageDialog(null,new JScrollPane(TextField),"user profile",JOptionPane.PLAIN_MESSAGE);
            }
        }
            catch(IOException i){
                i.printStackTrace();
                JOptionPane.showMessageDialog(null, "error loading Academic details","error",JOptionPane.ERROR_MESSAGE);
            }
        });
        entrity.add(AcademicButton,gbc);

        JLabel labe3=new JLabel("FEE MANAGEMENT");
        labe3.setForeground(Color.RED);
        labe3.setEnabled(false);
        gbc.gridx=0;
        gbc.gridy=4;
        entrity.add(labe3,gbc);

        JButton FeeButton=new JButton("FEE MANAGEMENT");
        gbc.gridx=0;
        gbc.gridy=5;
        FeeButton.addActionListener(e ->{
            try{
                Path feePath=Paths.get(regNum+"FEE.txt");
                if (Files.exists(feePath)) {
                    String feeDetails=Files.readString(feePath);
                    JTextField TextField=new JTextField(feeDetails);
                JOptionPane.showMessageDialog(null,new JScrollPane(TextField),"user profile",JOptionPane.PLAIN_MESSAGE);
              
                }
                else{
                    String feeDetails="\n"+"\n"+"\n"+"no file is found"+"\n"+"\n"+"\n";
                    JTextField TextField=new JTextField(feeDetails);
                JOptionPane.showMessageDialog(null,new JScrollPane(TextField),"user profile",JOptionPane.PLAIN_MESSAGE);
              
              }
            }
                catch(IOException i){
                    i.printStackTrace();
                    JOptionPane.showMessageDialog(null, "error loading fee details","error",JOptionPane.ERROR_MESSAGE);
                }
        });
        entrity.add(FeeButton,gbc);

        JLabel labe4=new JLabel("COMPLAINTS");
        labe4.setForeground(Color.RED);
        labe4.setEnabled(false);
        gbc.gridx=0;
        gbc.gridy=6;
        entrity.add(labe4,gbc);

        JButton ComplimentButton=new JButton("COMPLAINS");
        gbc.gridx=0;
        gbc.gridy=7;
        ComplimentButton.addActionListener(e ->{
           
            Path compli=Paths.get("complains.txt");
            if (Files.exists(compli)) {
                try{
                String Complains=JOptionPane.showInputDialog(null,"type your complain. we value you"+"private complain",JOptionPane.PLAIN_MESSAGE);
                Files.write(compli, Complains.getBytes());
                return;
                }
                catch(IOException i){
                    i.printStackTrace();
                    JOptionPane.showMessageDialog(null,"error loading complain option","complain error:",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                String Complains_File="complains.txt";
                try(BufferedWriter writer=Files.newBufferedWriter(Paths.get(Complains_File), StandardOpenOption.CREATE)){
                    String Complains=JOptionPane.showInputDialog(null,"type your complain. we value you"+"\n"+"private complain",JOptionPane.PLAIN_MESSAGE); 
                    writer.write(String.format("Complain: ",Complains));    
                    writer.flush(); 
                }
                catch(IOException i){
                    i.printStackTrace();
                    JOptionPane.showMessageDialog(null,"error loading complain option","complain error:",JOptionPane.ERROR_MESSAGE);
                }
            }
           
        });
        entrity.add(ComplimentButton,gbc);

        JLabel labe5=new JLabel("LOG OUT");
        labe5.setForeground(Color.RED);
        labe5.setEnabled(false);
        gbc.gridx=0;
        gbc.gridy=8;
        entrity.add(labe5,gbc);

        JButton ExitButton=new JButton("EXIT");
        gbc.gridx=0;
        gbc.gridy=9;
        ExitButton.addActionListener(e ->{
            int confirm=JOptionPane.showConfirmDialog(null,"are you sure you want to leave site","confirmation:",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            if(confirm==JOptionPane.OK_OPTION){
                System.exit(0);
            }
        });
        entrity.add(ExitButton,gbc);

        JPanel portPanel=new JPanel(new GridBagLayout());
        gbc.insets=new Insets(30, 30, 30, 30);
        add(portPanel,BorderLayout.CENTER);
       try{

        String studDetails= fetchDetails();
        JTextArea TextField1=new JTextArea(studDetails);
        TextField1.setEditable(false);
        gbc.gridx=0;
        gbc.gridy=0;
        portPanel.add(TextField1,gbc);
       }
       catch(IOException e){
        e.printStackTrace();
       }
        
        Path feePath=Paths.get(regNum+"FEE.txt");
        if (Files.exists(feePath)) {
            try{
             String fees=Files.readString(feePath);
            JTextArea TextField2=new JTextArea(fees);
            TextField2.setEditable(false);
            gbc.gridx=0;
            gbc.gridy=3;
            portPanel.add(TextField2,gbc);
            
            }
            catch(IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e,"file error", JOptionPane.ERROR_MESSAGE);
            }
    
        }
        else{
          String fees="\n"+"\n"+"No file found "+"\n"+"\n"+"\n";
         JTextArea TextField2=new JTextArea(fees);
         TextField2.setEditable(false);
         gbc.gridx=0;
         gbc.gridy=3;
         portPanel.add(TextField2,gbc);
         
        }

        String Information=fetchInfo();
        JTextArea TextField3=new JTextArea(Information);
        gbc.gridx=0;
        gbc.gridy=6;
        TextField3.setVisible(true);
        TextField3.setEditable(false);
        portPanel.add(TextField3,gbc);

        String Copy=  Copyright();
        JTextArea TextField4=new JTextArea(Copy);
        TextField4.setEditable(false);
        gbc.gridx=0;
        gbc.gridy=9;
        TextField4.setVisible(true);
        portPanel.add(TextField4,gbc);
        


    }
    public String fetchDetails()throws IOException{
        String Details=null;
        String REG=regNum+".txt";
        Path filePath=Paths.get(REG);
                if(Files.exists(filePath)){
                     Details=Files.readString(filePath);
                    }
                    else{
                        Details="no details found for this registration number!"+"\n consider visiting the registrar officce !"+"you seem to not be admitted fully";
                    }
        return Details;

    }
    public String fetchInfo(){
        String info="EMAIL us at: dravisGroupofschools.edu.ac.ke"+"\n"+"or \n"+" CALL us through: 0734567890/027689098/0734567897"+"\n"+"or whatsapp 0765868745";
        return info;
    }
    public String Copyright(){
        String Copi="designed by dravis.$$$ company"+"\n"+"regards: DRAVIS OSMAN KIBUNJA(samuelkibunja55@gmail.com)"+"\n helpline:0278980789";
        return Copi;
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new dravUser().setVisible(true);
        });
    }
}




