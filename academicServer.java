import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class academicServer{
    List<ClientHandler> clients=new ArrayList<>();
    public academicServer(){
        ServerSocket serverSocket=new ServerSocket(400);
        while (true) {
            Socket socket=serverSocket.accept();

            ClientHandler ClientThread=new ClientHandler(clients,socket);
            clients.add(ClientThread);
            new Thread(ClientThread).start();
        }
    }
}
class ClientHandler extends Runnable{
    private Socket socket;
    public ClientHandler(){
        this.socket=
    }
}