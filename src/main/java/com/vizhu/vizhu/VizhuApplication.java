package com.vizhu.vizhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class VizhuApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(VizhuApplication.class);
        // Указываете путь к файлу, куда будет записан PID
        String pidFilePath = "pids/application-node.pid";
        app.addListeners(new ApplicationPidFileWriter(pidFilePath));
        app.run(args);
    }

}
