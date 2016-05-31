package Service;

import Reponse.IHttpResponse;
import Request.IHttpRequest;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class HttpService implements IHttpService {
    @Override
    public void service(IHttpRequest request, IHttpResponse response) {
        PrintWriter printWriter = (PrintWriter) response.getWriter();
        String[] parameters = request.getParametersName();
        FileInputStream input;
        String result = null;
        if(Files.exists(Paths.get(request.getAbsolutePath()))) {
            printWriter.println("HTTP/1.1 200");
            for (String parameter : parameters) {
                printWriter.println(parameter + ":" + request.getParameter(parameter));
            }
            try {
                if (Files.isDirectory(Paths.get( request.getAbsolutePath()))) {
                    printWriter.println("");
                    File f  = new File(request.getAbsolutePath());
                    ArrayList<String> files = new ArrayList<>(Arrays.asList(f.list()));
                    printWriter.println("<html>");
                    printWriter.println("<body>");
                    printWriter.println("<ul>");
                    for (String file:files
                         ) {
                        if(Files.isDirectory(Paths.get(request.getAbsolutePath()+""+file)))
                            printWriter.println("<li><a href="+request.getAbsolutePath()+""+file+">"+file+"</a></li>");
                        else
                            printWriter.println("<li><a href="+request.getAbsolutePath()+""+file+" download='"+request.getAbsolutePath()+""+file+"'>"+file+"</a></li>");
                    }
                    printWriter.println("</ul>");
                    printWriter.println("</body>");
                    printWriter.println("</html>");
                    } else {
                        printWriter.println("content-type:"+Files.probeContentType(Paths.get( request.getAbsolutePath())));
                        printWriter.println("");
                        input = new FileInputStream(new File(request.getAbsolutePath()));
                        /*CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
                        decoder.onMalformedInput(CodingErrorAction.IGNORE);*/
                        InputStreamReader reader = new InputStreamReader(input);
                        BufferedReader bufferedReader = new BufferedReader( reader );
                        StringBuilder sb = new StringBuilder();
                        String line = bufferedReader.readLine();
                        while( line != null ) {
                            sb.append( line );
                            line = bufferedReader.readLine();
                        }
                        bufferedReader.close();
                        result = sb.toString();
                        printWriter.println(result);
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
        printWriter.close();
    }
}
