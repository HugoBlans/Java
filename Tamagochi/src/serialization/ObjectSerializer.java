package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializer {


    public Object fromData(byte[] data) {

        try {
            return new ObjectInputStream(new ByteArrayInputStream(data)).readObject();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public byte[] toData(Object message) {

        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            new ObjectOutputStream(bo).writeObject(message);
            return bo.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
