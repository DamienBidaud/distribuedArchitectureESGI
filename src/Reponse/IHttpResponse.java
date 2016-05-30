package Reponse;

import java.io.StreamCorruptedException;
import java.io.Writer;
import java.util.stream.Stream;

/**
 * Created by bidau on 30/05/2016.
 */
public interface IHttpResponse {
    Writer getWriter();
    Stream getOutPutSream();
    void setMethod(String name);
    void setCookie(String name, String value);
}
