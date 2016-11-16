import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMain
{
    private static ArrayList<PrintWriter> writers = new ArrayList<>();
    public static Logger log;

    public static void main(String argv[]) throws Exception
    {
        log = Logger.getGlobal();
        log.log(Level.INFO, "Running chat server...");

        int port = 6969;
        ServerSocket listener = new ServerSocket(port);
        try
        {
            log.log(Level.INFO, "Server started, waiting for clients.");
            while (true)
            {
                new ConnectionHandler(listener.accept()).start();
            }
        }
        finally
        {
            listener.close();
        }
    }

    private static class ConnectionHandler extends Thread
    {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        ConnectionHandler(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            try
            {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                //Запрашиваем имя пока не получим строку != null и ""
                while (true)
                {
                    out.println("Name yourself.");
                    name = in.readLine();
                    if (name == null)
                    {
                        return;
                    }
                    else
                    {
                        break;
                    }
                }

                out.println("Connected.");
                log.log(Level.INFO, "New client connected: " + name);

                for (PrintWriter writer : writers)
                {
                    writer.println("[SERVER]: New user connected: " + name);
                }
                writers.add(out);

                while (true)
                {
                    String op = in.readLine();
                    switch (op)
                    {
                        case "INFO":
                        {
                            String input = in.readLine();
                            log.log(Level.INFO, name + " send INFO: " + input);
                        }
                        case "MASSAGE":
                        {
                            String input = in.readLine();
                            if (input == null)
                            {
                                return;
                            }
                            log.log(Level.INFO, name + " said: " + input);
                            for (PrintWriter writer : writers)
                            {
                                writer.println("[" + name + "]: " + input);
                            }
                        }
                    }
                }
            }
            catch (IOException e)
            {
                log.log(Level.SEVERE, "Caught an exception: ", e);
                e.printStackTrace();
            }
            finally
            {
                // Если что-то пошло не так, убираем клиент из списка
                if (out != null)
                {
                    writers.remove(out);
                }
                try
                {
                    socket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}