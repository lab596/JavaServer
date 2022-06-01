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
import com.lab596.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


//Driver class for the server
public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {

        //System.out.println("Server starting...");
        LOGGER.info("Server starting...");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        //testing configuration
        //System.out.println("Using Port: " + conf.getPort());
        LOGGER.info("Using Port: " + conf.getPort());
        //System.out.println("Using Webroot: " + conf.getWebroot());
        LOGGER.info("Using Webroot: " + conf.getWebroot());
        ServerListenerThread serverListenerThread = null;
        try {
            serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        try {
            //allows connection through port
            //ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //simple html test
            String html = "<html><head><title>Simple Java HTTP Server </title></head><h1>This page was served using Simple Java HTTP Server</h1><body></body></html>";

            final String CRLF = "\n\r"; //13,10

            //required to read the HTML
            String response =
                    "HTTP/11.1 200 OK" + CRLF + //Status Line : HTTP VERSION RESPONSE_CODE RESPONSE_MESSAGE
                            "Content-Length: " + html.getBytes().length + CRLF +
                            CRLF +
                            html +
                            CRLF + CRLF;
            //outputting what is read
            outputStream.write(response.getBytes());
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }
}
