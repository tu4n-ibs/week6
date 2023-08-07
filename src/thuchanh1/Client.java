package thuchanh1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String Ip = "127.0.0.1";
        int Port = 1234;

        try {
            DatagramSocket socket = new DatagramSocket();
            String message = "hello. i'm ";
            byte[] bytes = message.getBytes();

            InetAddress inetAddress = InetAddress.getByName(Ip);
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length,inetAddress,Port);
            socket.send(packet);

            byte[] sendBytes = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(sendBytes,sendBytes.length);
            socket.receive(packet1);

            String receivedMessage = new String(packet1.getData(),0,packet1.getLength());
            System.out.println("received from Server " + receivedMessage);

            socket.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
