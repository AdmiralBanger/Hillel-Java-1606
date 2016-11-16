import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client
{
    private BufferedReader in;
    private PrintWriter out;
    JFrame frame = new JFrame("Chat client");
    private JTextArea log = new JTextArea(15, 30);
    private JTextField input = new JTextField(30);

    Client()
    {
        frame.setBounds(500,500,200,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(new JScrollPane(log), BorderLayout.NORTH);
        pane.add(input, BorderLayout.SOUTH);
        frame.pack();

        input.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                out.println("MASSAGE");
                out.println(input.getText());
                input.setText("");
            }
        });
    }

    void run() throws IOException
    {
        Socket socket = new Socket("localhost", 6969);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        while (true)
        {
            String line = in.readLine();

            switch (line)
            {
                case "Name yourself.":
                {
                    String name = JOptionPane.showInputDialog(
                            frame,
                            "Type your name:",
                            "Name selection",
                            JOptionPane.INFORMATION_MESSAGE);
                    out.println(name);
                    break;
                }
                case "Connected.":
                {
                    log.append("[SERVER]: You have connected to chat server.\n");
                    break;
                }
                default:
                {
                    log.append(line + "\n");
                    break;
                }
            }
        }
    }
}
