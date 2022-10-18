import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("InfiniteLoopStatement")
public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)){
            while (true){
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }
    private static void serverClient(Socket socket) throws IOException{
        System.out.println("Serving client " + socket.getInetAddress());
        InputStream input = socket.getInputStream();

        OutputStream out = socket.getOutputStream();

        while (true){
            int count = input.read();

            if(count == 11){
                break;
            }
            System.out.println("Request: " + count);
            count++;
            out.write(count);
            out.flush();
        }
    }
}
