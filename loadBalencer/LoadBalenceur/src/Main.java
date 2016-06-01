import LoadBalenceur.LoadBalancer;
import Server.Server;

import java.io.IOException;

/**
 * Created by bidau on 01/06/2016.
 */
public class Main {
    public static void main(String args[]){
        try {
            LoadBalancer loadBalancer = new LoadBalancer();
            loadBalancer.addServer("localhost", 81);
            loadBalancer.addServer("localhost", 82);
            loadBalancer.addServer("localhost", 83);
            loadBalancer.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
