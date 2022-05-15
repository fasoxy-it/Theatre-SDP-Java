package iterative;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String argv[]) throws Exception {
        String bookResult;

        // client socket initialization localhost: server address 6789: server service port number
        Socket clientSocket = new Socket("localhost", 6789);

        System.out.println("\n CLIENT STARTS");

        // output stream towards socket initialization
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        // input stream from socket initialization
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        // read the response from the server
        bookResult = inFromServer.readLine();
        System.out.println("FROM SERVER: " + bookResult);
        clientSocket.close();
    }
}
