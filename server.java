import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class server{
    private static List<ClientHandler> clients=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket=new ServerSocket(5000);
        
        while (true) {
            Socket socket=serverSocket.accept();

            ClientHandler ClientThread=new ClientHandler(socket, clients);
            clients.add(ClientThread);

            new Thread(ClientThread).start();

        }
    }
}
    class ClientHandler implements Runnable{
        private Socket socket;
        private List<ClientHandler> clients;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler( Socket ClientSocket ,List<ClientHandler> clients)throws IOException {
            this.socket=ClientSocket;
            this.clients=clients;
            this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out=new PrintWriter(socket.getOutputStream(),true);
            

            }
            public void run(){
                try{
                    String InputLine;
                    while((InputLine=in.readLine()) !=null){
                        for(ClientHandler aclients: clients){
                            aclients.out.println(InputLine);

                        }
                    }}
                    catch(IOException e){
                        JOptionPane.showMessageDialog(null, e+"on method run", "an error occured", JOptionPane.ERROR_MESSAGE);

                    }

                    try{
                       if(in != null) in.close();
                       if(out != null) out.close();
                       if(socket != null) socket.close();
                    }
                    catch(IOException e){
                        JOptionPane.showMessageDialog(null, e+" closing", "an error occured", JOptionPane.ERROR_MESSAGE);
                    }


                
                
                   
                }
            }


        
    
