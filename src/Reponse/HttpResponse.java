package Reponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by bidau on 30/05/2016.
 */
public class HttpResponse implements IHttpResponse {

    private Socket socket;
    private String method;
    private Stream stream;
    private Map<String, String> cookie;

    public HttpResponse(Socket socket){
        this.socket = socket;
        this.cookie = new HashMap<>();
    }

    @Override
    public Writer getWriter() {
        try {
            return new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Stream getOutPutStream() {
        try {
            return (Stream) socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setMethod(String name) {
        this.method = name;
    }

    @Override
    public void setCookie(String name, String value) {
        this.cookie.put(name, value);
    }
}
