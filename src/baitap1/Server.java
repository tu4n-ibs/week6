package baitap1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
//        Port va duong dan cua file
        int Port = 1234;
        String pathFile = "/home/tuan/IdeaProjects/LTPT/netWorking2/src/demo.txt";
        try {
//            tao doi tuong datagramSocket de ket noi
            DatagramSocket socket = new DatagramSocket(Port);
//            tao mang de nhan du lieu
            byte[] bytes = new byte[1024];
            FileOutputStream fos = new FileOutputStream(pathFile);
//            datagramPacket de nhan du lieu
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            System.out.println("waiting for Client...");
            socket.receive(packet);
//            ghi du lieu
            fos.write(packet.getData(), 0, packet.getLength());
//            dong cac phuong thuc
            fos.close();
            socket.close();
            System.out.println("da nhan duoc file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
