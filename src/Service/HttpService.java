package Service;

import Reponse.IHttpResponse;
import Request.IHttpRequest;

import java.io.PrintWriter;

/**
 * Created by bidau on 30/05/2016.
 */
public class HttpService implements IHttpService {
    @Override
    public void service(IHttpRequest request, IHttpResponse response) {
        PrintWriter printWriter = (PrintWriter) response.getWriter();
        String[] parameters = request.getParametersName();
        printWriter.println("HTTP/1.1 200");
        for(int i = 0; i < parameters.length; i++){
            printWriter.println(parameters[i]+":"+request.getParameter(parameters[i]));
        }
        printWriter.println("");
        printWriter.println(request.getAbsolutePath());
        printWriter.println(request.getRelativePath());
    }
}
