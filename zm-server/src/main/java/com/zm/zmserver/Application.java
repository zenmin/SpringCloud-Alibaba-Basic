package com.zm.zmserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zm
 * cd server/nacos/bin/
 * shutdown.cmd
 */
public class Application {

    public static void main(String[] args) throws Exception {
        String osType = System.getProperty("os.name");
        String dir = System.getProperty("user.dir");
        dir += "/server/nacos/bin/";
        Process ps = null;
        if (osType.startsWith("Windows")) {
            Runtime.getRuntime().exec(dir + "startup.cmd");
        } else {
            Runtime.getRuntime().exec(dir + "startup.sh");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            if (line.indexOf("INFO Completed") != -1) {
                System.exit(0);
            }
        }
    }
}
