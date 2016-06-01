package Server;

/**
 * Created by bidau on 01/06/2016.
 */
public interface IServer {

    void configure(String ip, int port);
    void launch();
    void stop();
}
