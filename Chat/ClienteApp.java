import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteApp {
    private static final String HOST = "10.100.64.6";
    //private final Socket socket;
    private final Scanner scanner;
    private final ClienteSocket clienteSocket;

    public static void main(String[] args) {
        new ClienteApp().start();
    }

    private void start() {
        String msg = "";
        do {
            System.out.print("Digite a mensagem: ");
            msg = scanner.nextLine();
            clienteSocket.sendMsg(msg);
        } while (!"sair".equalsIgnoreCase(msg));

    }

    public ClienteApp() {
        try {
            var socket = new Socket(HOST, ServerApp.PORT);
            this.clienteSocket = new ClienteSocket(socket);
            this.scanner = new Scanner(System.in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
