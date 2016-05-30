package Service;

import Reponse.IHttpResponse;
import Request.IHttpRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

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

        try {

            Files.lines(Paths.get("."+request.getRelativePath())).forEach(printWriter::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
