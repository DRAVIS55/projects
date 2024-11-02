import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyStore.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Finance extends JFrame{
     public Finance()throws IOException{
        super("DRAVIS GROUP OF SCHOOLS FINANCE");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());

     
        
        GridBagConstraints gdc=new GridBagConstraints();
        gdc.insets=new Insets(10, 10, 10, 10);
        gdc.fill=GridBagConstraints.HORIZONTAL;

        JPanel Portalpanel=new JPanel(new GridBagLayout());
        Portalpanel.setVisible(true);
        Portalpanel.setBackground(Color.BLUE);
        add(Portalpanel,BorderLayout.CENTER);

        JButton ENTRY=new JButton("FEE ENTRY");
        gdc.gridx=0;
        gdc.gridy=0;
        ENTRY.addActionListener(e ->{try{
            new feeHandler().HandleFeeEntry();
        }
        catch(IOException i){
            i.printStackTrace();
            JOptionPane.showMessageDialog(null,"error loading Fee entry option","error:",JOptionPane.ERROR_MESSAGE);
        }
        });
        Portalpanel.add(ENTRY,gdc);

        JButton ACCESS=new JButton("STUDENT FEE ACESS");
        gdc.gridx=0;
        gdc.gridy=3;
        ACCESS.addActionListener(e ->{
            try{
                new feeHandler().HandleFeeAcess();
            }
            catch(IOException i){
                i.printStackTrace();
                JOptionPane.showMessageDialog(null,"error loading fEE ACCESS option","error:",JOptionPane.ERROR_MESSAGE);
            }
            
        });
        Portalpanel.add(ACCESS,gdc);

        JButton EXIT=new JButton("EXIT APPLICATION");
        gdc.gridx=0;
        gdc.gridy=7;
        EXIT.addActionListener(e ->{
            int confirmation=JOptionPane.showConfirmDialog(null, "are you sure you want to leave","confirm",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            if(confirmation==JOptionPane.OK_OPTION){
            System.exit(0);
        }
        });
        Portalpanel.add(EXIT,gdc);
        
    }
    static class feeHandler{
        String RegCode=JOptionPane.showInputDialog(null,"enter the student registration CODE",
        "input form",JOptionPane.PLAIN_MESSAGE);
       public  String regCode=RegCode.toUpperCase();
        String regNum=JOptionPane.showInputDialog(null,"enter the student registration number",
        "input form",JOptionPane.PLAIN_MESSAGE);
       
        public void HandleFeeEntry()throws IOException{
            double StudentFee;
            StudentFee= getStudFee();
            Path feePath=Paths.get(regNum+"FEE.txt");
            if(Files.exists(feePath)){
                BufferedWriter writer=Files.newBufferedWriter(feePath);
                String FeeD=Files.readString(feePath);
                JOptionPane.showMessageDialog(null, "write down the existing fee paid from below shall be used\n"+FeeD, "FEE DETAILS", JOptionPane.PLAIN_MESSAGE);
                 String RECEIPTNO=JOptionPane.showInputDialog(null,"enter receipt number","input form",JOptionPane.PLAIN_MESSAGE);
                 double pAID=Double.parseDouble(JOptionPane.showInputDialog(null,"enter amount of Fee paid","input form",JOptionPane.PLAIN_MESSAGE));
                 double EPAID=Double.parseDouble(JOptionPane.showInputDialog(null,"enter amount of Existing fee paid","input form",JOptionPane.PLAIN_MESSAGE));
                 double PAID=pAID+EPAID;
                 double FEE_BALANCE=StudentFee-PAID;
                 Double less=StudentFee-(0.8*StudentFee);
                 Double minima=StudentFee-(0.5*StudentFee);
                 writer.write(String.format("RECEIPT NUMBER: "+RECEIPTNO));
                 writer.write(String.format("FEE PAID: "+PAID));
                 writer.write(String.format("FEE BALANCE: "+FEE_BALANCE));
                 writer.flush();

                 if(less > FEE_BALANCE){
                     JOptionPane.showMessageDialog(null,"Give a permanent gatepass", "info:",JOptionPane.INFORMATION_MESSAGE);
                     return;
                 }else if((minima > FEE_BALANCE)){
                     JOptionPane.showMessageDialog(null,"Give a Temporaly gatepass", "info:",JOptionPane.INFORMATION_MESSAGE);   
                     return;
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Don't offer a gatepass .\n request him/her to pay first", "info:",JOptionPane.INFORMATION_MESSAGE);
                     return;
                 }
            }
            else{
                String Fee_File=regNum+"FEE.txt";
                try(BufferedWriter writer=Files.newBufferedWriter(Paths.get(Fee_File), StandardOpenOption.CREATE)){
                    String RECEIPTNO=JOptionPane.showInputDialog(null,"enter receipt number","input form",JOptionPane.PLAIN_MESSAGE);
                    Double PAID=Double.parseDouble(JOptionPane.showInputDialog(null,"enter amount of pee paid","input form",JOptionPane.PLAIN_MESSAGE));
                    Double FEE_BALANCE=StudentFee-PAID;
                    writer.write(String.format("RECEIPT NUMBER: "+RECEIPTNO));
                    writer.write(String.format("FEE PAID: "+PAID));
                    writer.write(String.format("FEE BALANCE: "+FEE_BALANCE));
                    writer.flush();
                    Double less=StudentFee-(0.8*StudentFee);
                    Double minima=StudentFee-(0.5*StudentFee);
                    if(less>FEE_BALANCE){
                        JOptionPane.showMessageDialog(null,"Give a permanent gatepass", "info:",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }else if(minima>FEE_BALANCE){
                        JOptionPane.showMessageDialog(null,"Give a Temporaly gatepass", "info:",JOptionPane.INFORMATION_MESSAGE);   
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Don't offer a gatepass .\n request him/her to pay first", "info:",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                }
                catch(IOException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"error entering and creating student file","error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        private   double getStudFee()throws IOException{
            switch (regCode) {
                case "EB1":{
                    double fee=204000;
                    return fee;
                  
                }   
                case "EB2":{
                    return 304000;
                  
                }  
                case "EB3":{
                    return 290000;
                    
                }  
                case "EB4":{
                    return 402000;
                    
                }  
                case "EB5":{
                    return 410000;
                   
                }  
                case "AB1":{
                    return 312000;
                    
                }  
                case "AB2":{
                    return 234000;
                    
                }  
                case "AB3":{
                    return 456000;
                    
                }  
                case "AB4":{
                    return 387000;
                    
                }  
                case "AB5":{
                    return 302000;
                    
                }  
                case "HBS1":{
                    return 234000;
                    
                }  
                case "HBS2":{
                    return 456000;
                    
                }  
                case "CB1":{
                    return 345000;
                    
                }  
                case "CB2":{
                    return 103000;
                    
                }  
                case "CB3" :{
                    return 90000;
                    
                }  
                case "CB4":{
                    return 85000;
                    
                }  
                case "CB5":{
                    return 425000;
                    
                }  
                case "JS1":{
                    return 213000;
                    
                }  case "FS1":{
                    return 342000;
                
                }  case "MD1":{
                    return 567000;
                    
                }  
                case "BLAW":{
                    double fee=112000;
                    return  fee;
                    
                }  
                default:
                    break;
            }
            return 0;
            
        }
        public void HandleFeeAcess()throws IOException{
            Path handle=Paths.get(regNum+"FEE.txt");
            if(Files.exists(handle)){
               String Detailed= Files.readString(handle);
               JTextField TextField=new JTextField(Detailed);
               TextField.setEditable(false);
               JOptionPane.showMessageDialog(null, new JScrollPane(TextField),"FEE DETAILS",JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            else{
                JOptionPane.showMessageDialog(null, "no student records are found", "info:-"+regNum, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    

    public static void main(String[] args)throws IOException {
        SwingUtilities.invokeLater(()->{
            try{
            new Finance().setVisible(true);
            }
            catch(IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "error loading main method: "+e,"erro1:", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}