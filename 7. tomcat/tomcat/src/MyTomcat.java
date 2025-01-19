import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘瑞玺
 * @version 1.0
 * 这是我们自己写的web服务，可以返回hello.html给浏览器
 */
public class MyTomcat {
    public static void main(String[] args) throws IOException {
        //在9999端口连接
        ServerSocket serverSocket = new ServerSocket(8887);

        while(!serverSocket.isClosed()) {
            System.out.println("==我的web服务在 9999 端口监听==");
            //等待浏览器连接，得到socket
            Socket socket = serverSocket.accept();

            //通过socket得到输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello,i am myTomcat".getBytes());

            outputStream.close();
            socket.close();
        }
        serverSocket.close();

    }

}
