package Server;


import server.HttpServerStatic;

import java.io.IOException;

public class Server implements IServer {

    private String ip;
    private int port;


    public void configure(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void launch() {
        HttpServerStatic httpServerStatic = new HttpServerStatic();
        try {
            httpServerStatic.run(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void stop() {

    }
}
