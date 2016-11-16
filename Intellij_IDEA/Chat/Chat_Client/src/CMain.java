import java.io.IOException;

public class CMain
{

    public static void main(String[] args) throws IOException, InterruptedException
    {
        Client client = new Client();
        client.frame.setVisible(true);
        client.run();
    }
}

