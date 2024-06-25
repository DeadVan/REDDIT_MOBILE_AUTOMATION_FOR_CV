package baseDir.driverUtils;

import utils.LogUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
    private final AppiumDriverLocalService server;

    public AppiumServer() {
        LogUtils.info("Starting to build appium server");
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        server = AppiumDriverLocalService.buildService(serviceBuilder);
    }

    public void start() {
        LogUtils.info("start server");
        this.server.start();
    }

    public void stop() {
        LogUtils.info("stop server");
        this.server.stop();
    }

    public AppiumDriverLocalService get() {
        return this.server;
    }
}

