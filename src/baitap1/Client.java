package baitap1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
//        cac Ip, Port va duong dan cua file
        String Ip = "127.0.0.1";
        int Port = 1234;
        String pathFile = "/home/tuan/IdeaProjects/LTPT/netWorking2/src/file.txt";
        try {
//            tao mot datagramSocket
            DatagramSocket socket = new DatagramSocket();
//            ket noi Ip
            InetAddress inetAddress = InetAddress.getByName(Ip);
            FileInputStream fis = new FileInputStream(pathFile);
//            tao mot mang
            byte[] bytes = new byte[1024];
//            tao mot bien de doc du lieu
            int bytesRead;
//            vong lap doc du lieu neu = -1 thi dung
            while ((bytesRead = fis.read(bytes)) != -1) {
//                datagramPacket de gui du lieu
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytesRead, inetAddress, Port);
                socket.send(datagramPacket);
            }
//            dong cac phuong thuc
            fis.close();
            socket.close();
            System.out.println("da gui file thanh cong.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
