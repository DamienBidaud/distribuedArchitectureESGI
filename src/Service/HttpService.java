package Service;

import Reponse.IHttpResponse;
import Request.IHttpRequest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class HttpService implements IHttpService {
    @Override
    public void service(IHttpRequest request, IHttpResponse response) {
        PrintWriter printWriter = (PrintWriter) response.getWriter();
        String[] parameters = request.getParametersName();
        if(Files.exists(Paths.get(request.getAbsolutePath()))) {
            printWriter.println("HTTP/1.1 200");
            for (int i = 0; i < parameters.length; i++) {
                printWriter.println(parameters[i] + ":" + request.getParameter(parameters[i]));
            }
            printWriter.println("");

            try {
                if (Files.isDirectory(Paths.get( request.getAbsolutePath()))) {
                    File f  = new File(request.getAbsolutePath());
                    ArrayList<String> files = new ArrayList<>(Arrays.asList(f.list()));
                    printWriter.println("<html>");
                    printWriter.println("<body>");
                    printWriter.println("<ul>");
                    for (String file:files
                         ) {
                        if(Files.isDirectory(Paths.get(request.getAbsolutePath()+"/"+file)))
                            printWriter.println("<li><a href="+request.getAbsolutePath()+"/"+file+">"+file+"</a></li>");
                        else
                            printWriter.println("<li>"+file+"</li>");
                    }
                    printWriter.println("</ul>");
                    printWriter.println("</body>");
                    printWriter.println("</html>");
                } else {
                    Files.lines(Paths.get( request.getAbsolutePath())).forEach(printWriter::println);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            printWriter.println("HTTP/1.1 404");
            printWriter.println("");
            printWriter.println("<html>");
            printWriter.println("<body>");
            printWriter.println("<h1>404 File not Found</h1>");
            printWriter.println("</html>");
            printWriter.println("</body>");
        }
    }
}
