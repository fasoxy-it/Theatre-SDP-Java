package multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        System.out.println("\n MULTISERVER STARTS");

        while(true) {
            Socket connectionSocket = welcomeSocket.accept();

            // thread creation passing the established socket as arg
            ServerThread theThread =
                    new ServerThread(connectionSocket);

            // start of the thread
            theThread.start();

        }
    }
}
