import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Academic extends JFrame{
    public static String Mark1;   public static String Mark2;  public static String Mark3;
    public static String Mark4;   public static String Mark5;   public static String Mark6;
    public static String Mark7;   public static String Mark8;   public static String Mark9;
    public static String Mark10;   public static String Mark11;  public static String Mark12;
    public Academic(){
        setTitle("FINANCE PORTAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLayout(new BorderLayout());
   
        GridBagConstraints gdc=new GridBagConstraints();
        gdc.insets=new Insets(10,10,10,10);
        gdc.fill=GridBagConstraints.HORIZONTAL;

        JPanel panel=new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLUE);
        add(panel,BorderLayout.CENTER);

        JButton ENTRY=new JButton("ENTER STUDENT GRADES");
        gdc.gridx=0;
        gdc.gridy=0;
       panel.add(ENTRY,gdc);

        JButton ACCESS=new JButton("ACESS STUDENT GRADES");
        gdc.gridx=0;
        gdc.gridy=1;
        panel.add(ACCESS,gdc);

        JButton UPDATE=new JButton("UPDATE STUDENT GRADES");
        gdc.gridx=0;
        gdc.gridy=2;
        panel.add(UPDATE,gdc);

    }
    static class HandleCourses{ 
        public String Courses(){
            String regno=JOptionPane.showInputDialog(null,"enter the registration number",
            "input form",JOptionPane.PLAIN_MESSAGE);
            String code=JOptionPane.showInputDialog(null,"enter the student code",
            "input form",JOptionPane.PLAIN_MESSAGE);
            String year=JOptionPane.showInputDialog(null,"enter student year and semister eg. 1.1","input form",JOptionPane.PLAIN_MESSAGE);
            String Code=code.toUpperCase();
            switch (Code) {
                case "EB1":{
                    switch (year) {
                        case "1.1":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc101","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc110","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 122","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for zool 143","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for eng 123","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for PHYS 151","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=null;
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            Path academia_file=Paths.get(regno+year+"ACA.txt");
                            if(Files.exists(academia_file)){
                                JOptionPane.showMessageDialog(null, "errror:it seems the details exit", "error: return o", JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                String FILE_NAME=regno+year+"ACA.txt";
                                try(BufferedWriter writer=Files.newBufferedWriter(Paths.get(FILE_NAME),StandardOpenOption.CREATE)){
                                    writer.write(String.format("cosc 101:  %s%n", mark1));
                                    writer.write(String.format("cosc 110:  %s%n", mark2));
                                    writer.write(String.format("MATH 122:  %s%n", mark3));
                                    writer.write(String.format("ZOOL 143:  %s%n", mark4));
                                    writer.write(String.format("ENG 123:  %s%n", mark5));
                                    writer.write(String.format("PHYS 151:  %s%n", mark6));
                                    writer.flush();
                                }
                                catch(IOException i){
                                    i.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "error writing file: !","errror !", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            break;
                        }
                        case "1.2":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 130","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 121","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 141","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 122","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 102","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for ECON 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=JOptionPane.showInputDialog(null,"enter grade for PHYS 153","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            Path academia_file=Paths.get(regno+year+"ACA.txt");
                            if(Files.exists(academia_file)){
                                JOptionPane.showMessageDialog(null, "errror:it seems the details exit", "error: return o", JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                String FILE_NAME=regno+year+"ACA.txt";
                                try(BufferedWriter writer=Files.newBufferedWriter(Paths.get(FILE_NAME),StandardOpenOption.CREATE)){
                                    writer.write(String.format("cosc 100:  %s%n", mark1));
                                    writer.write(String.format("cosc 130:  %s%n", mark2));
                                    writer.write(String.format("MATH 121:  %s%n", mark3));
                                    writer.write(String.format("COSC 122:  %s%n", mark4));
                                    writer.write(String.format("COSC 102:  %s%n", mark5));
                                    writer.write(String.format("ECON 100:  %s%n", mark6));
                                    writer.write(String.format("PHYS 153:  %s%n", mark7));
                                    writer.flush();
                                }
                                catch(IOException i){
                                    i.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "error writing file: !","errror !", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            break;
                        }
                        case "2.1":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 221","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 222","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 221","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 241","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 201","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 202","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for PHYSC 248","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            break;
                        }
                        case "2.2":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 256","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 267","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 224","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 247","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 232","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 232","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for phys185","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            break;
                        }
                        case "3.1":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 130","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 121","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 141","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 122","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 102","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for ECON 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            break;
                        }
                        case "3.2":{
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 130","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 121","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 141","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 122","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 102","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for ECON 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            break;
                        }case "4.1":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 130","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 121","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 141","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 122","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 102","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for ECON 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            break;
                        }
                        case "4.2":{ 
                            mark1=JOptionPane.showInputDialog(null,"enter grade for cosc 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark2=JOptionPane.showInputDialog(null,"enter grade for cosc 130","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark3=JOptionPane.showInputDialog(null,"enter grade for MATH 121","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark4=JOptionPane.showInputDialog(null,"enter grade for math 141","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark5=JOptionPane.showInputDialog(null,"enter grade for cosc 122","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark6=JOptionPane.showInputDialog(null,"enter grade for cosc 102","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark7=JOptionPane.showInputDialog(null,"enter grade for ECON 100","input dialog",JOptionPane.PLAIN_MESSAGE);
                            mark8=null;
                            mark9=null;
                            mark10=null;
                            mark11=null;
                            mark12=null;
                            
                            break;
                        }
                        default:
                            break;
                    }
                }
            
                default:
                    break;
            }
           
        }

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Academic().setVisible(true);
        });
    }
}