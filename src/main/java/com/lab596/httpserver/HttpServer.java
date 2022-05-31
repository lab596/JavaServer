package com.lab596.httpserver;


/*
 *Read Configuration Files
 *Server must listen to a port // multithreaded?
 * Read request messages
 * Open and read files from the Filesystem
 * Write response Messages
 */

import com.lab596.httpserver.config.Configuration;
import com.lab596.httpserver.config.ConfigurationManager;

//Driver class for the server
public class HttpServer {

    public static void main(String[] args) {

        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        //testing configuration
        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using Webroot: " + conf.getWebroot());

    }
}
