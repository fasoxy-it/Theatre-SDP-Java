package multithread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    String bookRequest;

    // the constructor argument is an established socket
    public ServerThread(Socket s) {
        connectionSocket = s;
        try {
            inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));
            outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {

            // wait for 10 seconds
            Thread.sleep(10000);

            if (Reservations.freeSeats() > 0) {
                Reservations.seats--;
                bookRequest = "Biglietto prenotato. Rimangono " + Reservations.seats + " biglietti disponibili.";
            } else {
                bookRequest = "Mi spiace, i biglietti sono esauriti!";
            }

            outToClient.writeBytes(bookRequest);

            connectionSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
