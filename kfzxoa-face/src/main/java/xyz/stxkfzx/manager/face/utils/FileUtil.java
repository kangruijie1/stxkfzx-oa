package xyz.stxkfzx.manager.face.utils;

import xyz.stxkfzx.manager.face.faceDbOperation.*;
import java.net.*;
import javax.servlet.http.*;
import java.io.*;

public class FileUtil
{
    public static String readFileAsString(final String filePath) throws IOException {
        final File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }
        if (file.length() > 1073741824L) {
            throw new IOException("File is too large");
        }
        final StringBuilder sb = new StringBuilder((int)file.length());
        final FileInputStream fis = new FileInputStream(filePath);
        final byte[] bbuf = new byte[10240];
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            sb.append(new String(bbuf, 0, hasRead));
        }
        fis.close();
        return sb.toString();
    }
    
    public static byte[] readFileByBytes(final String filePath) throws IOException {
        final File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }
        final ByteArrayOutputStream bos = new ByteArrayOutputStream((int)file.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            final short bufSize = 1024;
            final byte[] buffer = new byte[bufSize];
            int len1;
            while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                bos.write(buffer, 0, len1);
            }
            final byte[] var7 = bos.toByteArray();
            return var7;
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException var8) {
                var8.printStackTrace();
            }
            bos.close();
        }
    }
    
    public static String getResourcePath(final String filePath) throws UnsupportedEncodingException {
        String resourcePath = FaceAdd.class.getClassLoader().getResource(filePath).getPath();
        resourcePath = URLDecoder.decode(resourcePath, "utf-8");
        return resourcePath;
    }
    
    public static void writeStringToFile(final HttpServletRequest request, String str) throws UnsupportedEncodingException, FileNotFoundException {
        final String resourcePath = request.getSession().getServletContext().getRealPath("1.txt");
        str = str.substring(23);
        System.out.println(resourcePath);
        final File file = new File(resourcePath);
        final PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(str);
    }
}
