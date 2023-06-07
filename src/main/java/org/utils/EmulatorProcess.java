package org.utils;

import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EmulatorProcess {
    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /F /IM ";
    private static final String BATFILE = System.getProperty("user.dir") + "\\src\\main\\java\\org\\batFiles\\startEmulator.bat";
    private static InputStream input = null;
    private static int i;
    public static String[] processes = {"qemu-system-x86_64.exe", "chromedriver.exe", "node.exe"};


    //  Start the emulator
    public static void StartEmulator() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec(BATFILE);
            input = p.getInputStream();

            while ((i = input.read()) != -1) {
                System.out.println((char) i);
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /*
        Check if the process is still running
        If true, then kill it
     */
    public static boolean isProcessRunning(String serviceName) {
        Runtime isRuntime = Runtime.getRuntime();

        try {
            Process process = isRuntime.exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                if (line.contains(serviceName)) {
                    System.out.println("Process name: " + line.toLowerCase());
                    return true;
                }
            }
            return false;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void KillProcess(String serverName) throws IOException {

        try {
            Runtime.getRuntime().exec(KILL + serverName);
        } catch (Exception e) {
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
