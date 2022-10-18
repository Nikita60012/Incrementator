import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException{
            try(Socket socket = new Socket("localhost", 1020)){
                OutputStream out = socket.getOutputStream();
                int count = 0;
                while (count != 11) {
                    count++;
                    out.write(count);
                    out.flush();

                    InputStream input = socket.getInputStream();
                    count = input.read();
                    System.out.println("response " + count);
                }
            }
    }
}
