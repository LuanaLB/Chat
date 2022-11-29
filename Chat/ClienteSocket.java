import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocket {
    private final BufferedReader in;
    private final PrintWriter out;
    private Socket socket;

    public ClienteSocket(Socket socket) {
        this.socket = socket;
        try {
            this.in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            this.out =new PrintWriter(socket.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean sendMsg(String msg){
        out.println(msg);
        return !out.checkError();

    }
    public String getMessage(){
        try {
            return in.readLine();
        } catch (IOException e) {
            return "!!!";
        }
    }
}
