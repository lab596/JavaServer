package com.lab596.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);

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
            //allows for socket to keep receiving inputs
            while (serverSocket.isBound() && !(serverSocket.isClosed())) {
                Socket socket = serverSocket.accept();

                LOGGER.info(" * Connection accepted: " + socket.getInetAddress());

                HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
                workerThread.start();

                /*
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

                try{
                    sleep(5000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            */
            }
            //serverSocket.close();
        } catch (IOException e) {
            LOGGER.error("Problem with setting socket", e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                }
            }
        }

    }
}
