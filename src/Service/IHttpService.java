package Service;

import Reponse.IHttpResponse;
import Request.IHttpRequest;

/**
 * Created by bidau on 30/05/2016.
 */
public interface IHttpService {

    void service(IHttpRequest request, IHttpResponse response);
}
