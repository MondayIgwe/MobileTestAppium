package org.services;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.text.SimpleDateFormat;

import static org.utils.CommonConst.*;


public class AppiumServer {

    public static AppiumDriverLocalService service;
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.withIPAddress("127.0.0.1").usingPort(4723)
                .withAppiumJS(new File(MAINJSFILE))
                .usingDriverExecutable(new File(NODEJSPATH))
                .withLogFile(new File(LOGS))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug");


        service = AppiumDriverLocalService.buildService(builder);

        if (service.isRunning()) {
            stopServer();
        } else {
            service.start();
            System.out.println("APPIUM SERVER SUCCESSFULLY STARTED");
        }

    }

    public static void stopServer() {
        service.stop();
        service.close();
        System.out.println("APPIUM SERVER SUCCESSFULLY STOPPED");
    }

}