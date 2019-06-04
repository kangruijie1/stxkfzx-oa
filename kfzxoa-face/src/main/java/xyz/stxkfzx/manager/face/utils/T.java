package xyz.stxkfzx.manager.face.utils;

import java.util.*;
import java.io.*;

public class T
{
    public static List<String> getIPs() {
        final List<String> list = new ArrayList<String>();
        boolean flag = false;
        int count = 0;
        final Runtime r = Runtime.getRuntime();
        try {
            final Process p = r.exec("arp -a");
            final BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inline;
            while ((inline = br.readLine()) != null) {
                if (inline.indexOf("\u63a5\u53e3") > -1) {
                    flag = !flag;
                    if (!flag) {
                        break;
                    }
                }
                if (flag && ++count > 2) {
                    final String[] str = inline.split(" {4}");
                    list.add(str[0]);
                }
                System.out.println(inline);
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
    
    public static void main(final String[] args) {
        getIPs();
    }
}
