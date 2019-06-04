package xyz.stxkfzx.manager.face.utils;

import java.io.*;

public class Base64Util
{
    private static final char last2byte;
    private static final char last4byte;
    private static final char last6byte;
    private static final char lead6byte;
    private static final char lead4byte;
    private static final char lead2byte;
    private static final char[] encodeTable;
    
    static {
        last2byte = (char)Integer.parseInt("00000011", 2);
        last4byte = (char)Integer.parseInt("00001111", 2);
        last6byte = (char)Integer.parseInt("00111111", 2);
        lead6byte = (char)Integer.parseInt("11111100", 2);
        lead4byte = (char)Integer.parseInt("11110000", 2);
        lead2byte = (char)Integer.parseInt("11000000", 2);
        encodeTable = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
    }
    
    public static String getImgBase64(final String imagePath) throws UnsupportedEncodingException {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imagePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final StringBuilder to = new StringBuilder((int)(data.length * 1.34) + 3);
        int num = 0;
        char currentByte = '\0';
        for (int i = 0; i < data.length; ++i) {
            for (num %= 8; num < 8; num += 6) {
                switch (num) {
                    case 0: {
                        currentByte = (char)(data[i] & Base64Util.lead6byte);
                        currentByte >>>= 2;
                        break;
                    }
                    case 2: {
                        currentByte = (char)(data[i] & Base64Util.last6byte);
                        break;
                    }
                    case 4: {
                        currentByte = (char)(data[i] & Base64Util.last4byte);
                        currentByte <<= 2;
                        if (i + 1 < data.length) {
                            currentByte |= (char)((data[i + 1] & Base64Util.lead2byte) >>> 6);
                            break;
                        }
                        break;
                    }
                    case 6: {
                        currentByte = (char)(data[i] & Base64Util.last2byte);
                        currentByte <<= 4;
                        if (i + 1 < data.length) {
                            currentByte |= (char)((data[i + 1] & Base64Util.lead4byte) >>> 4);
                            break;
                        }
                        break;
                    }
                }
                to.append(Base64Util.encodeTable[currentByte]);
            }
        }
        if (to.length() % 4 != 0) {
            for (int i = 4 - to.length() % 4; i > 0; --i) {
                to.append("=");
            }
        }
        return to.toString();
    }
}
