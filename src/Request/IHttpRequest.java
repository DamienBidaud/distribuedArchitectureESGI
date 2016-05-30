package Request;

/**
 * Created by bidau on 30/05/2016.
 */
public interface IHttpRequest {

    Object getParameter(String name);
    String[] getParametersName();
    String getMethod();
    Object getCookie(String name);
    String[] getCookiesName();
    String getRelativePath();
    String getAbsolutePath();
}
