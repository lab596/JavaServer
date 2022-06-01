package com.lab596.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread {

    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    //constructor to open thread
    public ServerListenerThread(int port, String webroot) throws IOException {
        this.port = port;
        this.webroot = webroot;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run() {

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

    }
}
