package Request;

/**
 * Created by bidau on 30/05/2016.
 */
public interface IHttpRequest {

    Object getParamet(String name);
    String[] getParametresName();
    String getMethod();
    Object getCookie(String name);
    String[] getCookiesName();
}
