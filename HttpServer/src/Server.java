import server.HttpServerStatic;

import java.io.IOException;

/**
 * Created by bidau on 30/05/2016.
 */
public class Server {


    public static void main(String args[]) throws IOException {
        HttpServerStatic httpServer = new HttpServerStatic();
        httpServer.run(80);


    }


}
