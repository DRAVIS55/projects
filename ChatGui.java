

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;
import java.net.*;

public class ChatGui extends JFrame {
    private JTextArea MessageArea;
    private JTextField TextField;
    private ChatClient client;
    private JButton ExitButton;
    private BufferedImage backgroundImage;
    private String userName;
    private static final String NAME_FILE = "username.txt"; // File to store the user's name

    public ChatGui() throws IOException {
        super("Chat Application");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\hp\\drav\\Capture.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load background image", "Image Error", JOptionPane.ERROR_MESSAGE);
        }

        // Retrieve or ask for the user's name
        this.userName = loadUserName();
        if (this.userName == null) {
            this.userName = JOptionPane.showInputDialog(this, "Enter your name", "Name Input:", JOptionPane.PLAIN_MESSAGE);
            saveUserName(this.userName);
        }
        this.setTitle("Chat Application - " + userName);

        // Colors and fonts
        Color back = new Color(75, 240, 112);
        Color textColor = new Color(50, 50, 50);
        Color buttonColor = new Color(250, 0, 0);
        Color background = new Color(75, 240, 112);
        Color Tili = new Color(210, 190, 240);
        Color cop = new Color(75, 240, 75);


        Font textFont = new Font("serif", Font.ITALIC, 18);
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        Font Tile = new Font("Arial", Font.BOLD, 13);
        Font copi= new Font("serif", Font.BOLD, 8);

        // Message area setup
        this.MessageArea = new JTextArea();
        MessageArea.setEditable(false);
        MessageArea.setForeground(textColor);
        MessageArea.setFont(textFont);
        JScrollPane scrollPane = new JScrollPane(MessageArea);

        // Background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        add(backgroundPanel, BorderLayout.CENTER);

        // Text field setup
        this.TextField = new JTextField();
        TextField.setForeground(textColor);
        TextField.setFont(textFont);
        TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + userName + ": " + TextField.getText();
                client.sendMessage(message);
                TextField.setText("");
            }
        });

        // Exit button setup
        this.ExitButton = new JButton("Exit");
        ExitButton.setForeground(Color.WHITE);
        ExitButton.setBackground(buttonColor);
        ExitButton.setFont(buttonFont);
        ExitButton.addActionListener(e -> {
            String disappearingMessage = userName + " has left the Chat Application";
            client.sendMessage(disappearingMessage);
            try {
                Thread.sleep(1000); // Sleep for 1 second before exiting
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.exit(0);
        });

        JLabel Label= new JLabel();
        Label.setText("ENTER MESSAGE");
        Label.setBackground(back);
        Label.setFont(buttonFont);
        Label.setEnabled(false);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(TextField, BorderLayout.CENTER);
        bottomPanel.add(ExitButton, BorderLayout.EAST);
        bottomPanel.add(Label,BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);

       JTextField Tittle= new JTextField();
        Tittle.setText("CHUKA COMRADE MEET-UP");
        Tittle.setEditable(false);
        Tittle.setBackground(Tili);
        Tittle.setFont(Tile);

        JTextField copyright= new JTextField();
        copyright.setText("@dravis(0714026439)");
        copyright.setEditable(false);
        copyright.setBackground(cop);
        copyright.setFont(copi);

        JPanel up=new JPanel(new BorderLayout());
        up.add(Tittle,BorderLayout.CENTER);
        up.add(copyright,BorderLayout.EAST);
        up.setBackground(background);

        add(up,BorderLayout.NORTH);

        // Initialize ChatClient
        try {
            this.client = new ChatClient("192.168.10.2", 5000, this::onMessageReceived);
            client.startclient();
        } catch (IOException e) {
           JOptionPane.showMessageDialog(null,
           "error connecting to the server: the server may not be started. contact 0714026439 for help","connection info:",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    private void onMessageReceived(String message) {
        SwingUtilities.invokeLater(() -> MessageArea.append(message + "\n"));
    }

    private void saveUserName(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAME_FILE))) {
            writer.write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String loadUserName() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NAME_FILE))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ChatGui().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public class ChatClient {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private Consumer<String> onMessageReceived;

        public ChatClient(String serverAddress, int serverPort, Consumer<String> onMessageReceived) throws IOException {
            this.socket = new Socket(serverAddress, serverPort);
            JOptionPane.showMessageDialog(null,
             "client connected", "connection info:", JOptionPane.INFORMATION_MESSAGE);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.onMessageReceived = onMessageReceived;
        }

        public void sendMessage(String msg) {
            out.println(msg);
        }

        public void startclient() {
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        onMessageReceived.accept(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    class BackgroundPanel extends JPanel {
        private BufferedImage backgroundImage;

        public BackgroundPanel(BufferedImage backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
