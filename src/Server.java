import Reponse.HttpResponse;
import Request.HttpRequest;
import Service.HttpService;

import java.io.*;
import java.net.*;
import Thread.ThreadPool;

/**
 * Created by bidau on 30/05/2016.
 */
public class Server {


    public static void main(String args[]) throws IOException {
        HttpServer httpServer = new HttpServer();
        httpServer.run();



    }


}
