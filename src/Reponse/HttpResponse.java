package Reponse;

import java.io.StringWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * Created by bidau on 30/05/2016.
 */
public class HttpResponse implements IHttpResponse {

    private Socket socket;
    private String method;
    private Writer writer;
    private Stream stream;

    public HttpResponse(Socket socket){
        this.socket = socket;
        this.writer = new StringWriter();
    }

    @Override
    public Writer getWriter() {
        return null;
    }

    @Override
    public Stream getOutPutStream() {
        return null;
    }

    @Override
    public void setMethod(String name) {
        this.method = name;
    }

    @Override
    public void setCookie(String name, String value) {
    }
}
