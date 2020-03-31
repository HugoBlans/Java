package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Socketer {

    public byte[] read(Socket client) {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            int len = dis.readInt();
//		System.out.println(len);
            byte[] data = new byte[len];
            dis.readFully(data);
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void write(Socket client, byte[] repData) {
        try {
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(repData.length);
            dos.write(repData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
