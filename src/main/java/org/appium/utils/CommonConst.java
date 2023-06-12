package org.appium.utils;

public interface CommonConst {
    public static final String REALDEVICE = "\"real device\"";
    public static final String INTERNETHEROKUAPP = "https://the-internet.herokuapp.com/";
    public static final String VIRTUALDEVICE = "\"virtual device\"";
    public static final String AVDEMULATOR = "demoApp";
    public static final String APPIUMSERVERURL = "http://localhost:4723/wd/hub";
    public static final String NODEJSPATH = "C:\\Program Files\\nodejs\\node.exe";
    public static final String MAINJSFILE = "C:\\Users\\migwe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
    public static final String APKFILEPATH = "src\\main\\java\\resources\\apk\\";
    public static final int WAITTIME = 2000;
    public static final String SELENDROIDAPP = "selendroidapp";
    public static final String APIDEMOAPP = "apidemoapp";
    public static final String THEINTERNETWEBAPP = "theinternetwebapp";
    public static final String APPIUMSERVER = "http://localhost:4723/wd/hub";
    public static final String RESOURCEBASEPATH = System.getProperty("user.dir") + "/src/main/java/org/database/resource/";

    public static final String LOGS = "appiumServerlogs/logs.txt";
    static void sleep(int waitTime){
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
