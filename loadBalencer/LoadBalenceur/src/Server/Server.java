package Server;

/**
 * Created by bidau on 01/06/2016.
 */
public class Server implements IServer {

    private String ip;
    private int port;

    @Override
    public void configure(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void launch() {

    }

    @Override
    public void stop() {

    }
}
