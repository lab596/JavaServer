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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Driver class for the server
public class HttpServer {

    public static void main(String[] args) {

        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        //testing configuration
        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using Webroot: " + conf.getWebroot());

        try {
            //allows connection through port
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
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

    }
}
