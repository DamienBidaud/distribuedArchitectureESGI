package Reponse;

import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by bidau on 30/05/2016.
 */
public interface IHttpResponse {
    Writer getWriter();
    OutputStream getOutPutStream();
    void setMethod(String name);
    void setCookie(String name, String value);
}
