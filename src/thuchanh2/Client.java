package thuchanh2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            DatagramSocket clientSocket = new DatagramSocket();
//            lay dia chi localhost
            InetAddress clientAddress = InetAddress.getLocalHost();

            int Port = 12344;
            byte[] bytes;

            while (true) {
//                nhap phep tinh
                System.out.print("nhan phet tinh theo dinh dang: ");
                System.out.println("so hang 1, toan tu so hang 2 ");
                String inp = sc.nextLine();
//                chuyen doi data thanh dang byte de gui
                bytes = inp.getBytes();
//                tao mot datagramPacket de gui data den dia chia Port
                DatagramPacket sendServer = new DatagramPacket(bytes, bytes.length, clientAddress, Port);
                clientSocket.send(sendServer);
//                dieu kien thoat vong lap
                if (inp.equals("bye"))
                    break;
//                reset mang de nhan data
                bytes = new byte[65535];
//                tao mot datagramPacket de nha data ben server
                DatagramPacket receivedServer = new DatagramPacket(bytes, bytes.length);
                clientSocket.receive(receivedServer);
//                chuyen doi data va nhan data
                String result = new String(receivedServer.getData(), receivedServer.getOffset(), receivedServer.getLength());
                System.out.println("ket qua: " + result);
            }
//            dong socket
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
