package LoadBalenceur;

import Server.IServer;
import Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bidau on 01/06/2016.
 */
public class LoadBalancer {





    private Map<IServer, Integer> servers;
    private int size;
    private IServer currentServer;

    public LoadBalancer() throws IOException {
        int port = 80;
        ServerSocket serverSocket = new ServerSocket(port);
        this.servers= new HashMap<>();
        this.size = 0;
        currentServer = null;
    }

    public void addServer(String ip, int port){
        IServer server = new Server();
        server.configure(ip, port);
        this.servers.put(server, 0);
        this.size++;
    }


}

