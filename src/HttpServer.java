import Reponse.HttpResponse;
import Request.HttpRequest;
import Service.HttpService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bidau on 01/06/2016.
 */
import Thread.*;

public class HttpServer {

    public void run() throws IOException {
        final int portNumber = 80;
        System.out.println("Creating server socket on port " + portNumber);
        ServerSocket serverSocket = new ServerSocket(portNumber);
        ThreadPool pool = new ThreadPool(16);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.submit(1, () -> handleRequest(socket));

        }
    }



    public void handleRequest(Socket socket){
        HttpRequest req;
        HttpResponse resp;

        try {
            System.out.println(Thread.currentThread().getName());
            req = new HttpRequest(socket);
            resp = new HttpResponse(socket);
            resp.setMethod(req.getMethod());
            String[] cookieName = req.getCookiesName();
            for (String aCookieName : cookieName) {
                resp.setCookie(aCookieName, (String) req.getCookie(aCookieName));
            }
            new HttpService().service(req, resp);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
