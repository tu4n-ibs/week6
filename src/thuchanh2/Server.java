package thuchanh2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) {
//        tao mot Port
        int Port = 12344;
        try {
//            tao mot doi tuong datagramSocket de ket noi
            DatagramSocket clientSocket = new DatagramSocket(Port);
//            tao mot mang
            byte[] bytes;
//            tao mot doi tuong nhan data
            DatagramPacket receivedClient;
//            tao mot doi tuong gui data
            DatagramPacket sendClient;
//            vong lap
            while (true) {
//                khoi tao mang
                bytes = new byte[65535];
//                nhan data tu ben client
                receivedClient = new DatagramPacket(bytes, bytes.length);
                clientSocket.receive(receivedClient);
//                chuyen doi data de nhan data tu client
                String inp = new String(receivedClient.getData(), receivedClient.getOffset(), receivedClient.getLength());
                System.out.println("phep tinh nhan duoc: " + inp);
//                dieu kien de thoat vong lap
                if (inp.equals("bye")) {
                    System.out.println("client dang thoat...");
                    break;
                }
//                tach chuoi phep tinh thanh so hang 1, toan tu, so hang 2
                int result;
                StringTokenizer st = new StringTokenizer(inp);
                int oprnd1 = Integer.parseInt(st.nextToken());
                String operation = st.nextToken();
                int oprnd2 = Integer.parseInt(st.nextToken());
//                phep tinh
                if (operation.equals("+")) {
                    result = oprnd1 + oprnd2;
                } else if (operation.equals("-")) {
                    result = oprnd1 - oprnd2;
                } else if (operation.equals("*")) {
                    result = oprnd1 * oprnd2;
                } else {
                    result = oprnd1 / oprnd2;
                }
//                chuyen doi data thanh mang de gui ve client
                System.out.println("dang gui ket qua...");
                String res = Integer.toString(result);
                bytes = res.getBytes();
//                lay so port tu client
                int port = receivedClient.getPort();
                sendClient = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), port);
//                tao datagrampacket de gui data ve ben client
                clientSocket.send(sendClient);
            }
//            dong socket
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
