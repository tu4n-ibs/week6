package thuchanh1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        int Port = 1234;
        try {
            DatagramSocket socket = new DatagramSocket(Port);
            System.out.println("waiting for Client...");
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
            socket.receive(packet);

            InetAddress address = packet.getAddress();
            int clientPort = packet.getPort();

            String message = new String(packet.getData(),0,packet.getLength());
            System.out.println("received from client " + message);

            String send = "hello. i'm jisoo";
            byte[] sendData = send.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,address,clientPort);
            socket.send(sendPacket);

            socket.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
