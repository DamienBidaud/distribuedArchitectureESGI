package Reponse;

import java.io.Writer;
import java.util.stream.Stream;

/**
 * Created by bidau on 30/05/2016.
 */
public class HttpResponse implements IHttpResponse {
    @Override
    public Writer getWriter() {
        return null;
    }

    @Override
    public Stream getOutPutSream() {
        return null;
    }

    @Override
    public void setMethod(String name) {

    }

    @Override
    public void setCookie(String name, String value) {

    }
}
