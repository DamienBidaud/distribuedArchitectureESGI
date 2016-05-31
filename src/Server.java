import Reponse.HttpResponse;
import Request.HttpRequest;
import Service.HttpService;

import java.io.*;
import java.net.*;

/**
 * Created by bidau on 30/05/2016.
 */
public class Server {


    public static void main(String args[]) throws IOException {
        final int portNumber = 80;
        System.out.println("Creating server socket on port " + portNumber);
        ServerSocket serverSocket = new ServerSocket(portNumber);

        HttpRequest req;
        HttpResponse resp;
        while (true) {
            Socket socket = serverSocket.accept();
            /*OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));*/
            //socket = serverSocket.accept();
            req = new HttpRequest(socket);
            resp = new HttpResponse(socket);
            resp.setMethod(req.getMethod());
            String[] cookieName = req.getCookiesName();
            for (String aCookieName : cookieName) {
                resp.setCookie(aCookieName, (String) req.getCookie(aCookieName));
            }
            new HttpService().service(req, resp);

            //pw.close();
            socket.close();
        }
    }
}
