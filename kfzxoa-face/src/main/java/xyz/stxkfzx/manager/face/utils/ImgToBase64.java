package xyz.stxkfzx.manager.face.utils;

import org.apache.commons.codec.binary.*;

import java.io.*;

public class ImgToBase64
{
    public static String getImageStr(final String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(data));
    }
}
