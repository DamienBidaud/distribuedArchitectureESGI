package Service;

import Reponse.IHttpResponse;
import Request.IHttpRequest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class HttpService implements IHttpService {
    @Override
    public void service(IHttpRequest request, IHttpResponse response) {
        PrintWriter printWriter = (PrintWriter) response.getWriter();
        String[] parameters = request.getParametersName();
        FileInputStream input;
        if(Files.exists(Paths.get(request.getAbsolutePath()))) {
            printWriter.println("HTTP/1.1 200");
            for (String parameter : parameters) {
                printWriter.println(parameter + ":" + request.getParameter(parameter));
            }
            try {
                if (Files.isDirectory(Paths.get(request.getAbsolutePath()))) {
                    printWriter.println("");
                    File f = new File(request.getAbsolutePath());
                    ArrayList<String> files = new ArrayList<>(Arrays.asList(f.list()));
                    printWriter.println("<html>");
                    printWriter.println("<body>");
                    printWriter.println("<ul>");
                    printWriter.println("<li><a href=" + request.getAbsolutePath() + ">..</a></li>");
                    for (String file : files
                            ) {
                        String path = request.getAbsolutePath() + "" + file;
                        path = path.replace("/", "\\");
                        if (Files.isDirectory(Paths.get(request.getAbsolutePath() + "" + file)))

                            printWriter.println("<li><a href='" + path + "'>" + file + "</a></li>");
                        else
                            printWriter.println("<li><a href=" +path + " download='" + path + "'>" + file + "</a></li>");
                    }
                    printWriter.println("</ul>");
                    printWriter.println("</body>");
                    printWriter.println("</html>");
                } else {
                    printWriter.println("content-type:" + Files.probeContentType(Paths.get(request.getAbsolutePath())));
                    printWriter.println("");
                    input = new FileInputStream(new File(request.getAbsolutePath()));
                    BufferedOutputStream out = new BufferedOutputStream(response.getOutPutStream());
                    BufferedInputStream reader = new BufferedInputStream( input );
                    byte[] buffer = new byte[ 4096 ];
                    int bytesRead;
                    while ( (bytesRead = reader.read(buffer)) != -1 ) {
                        out.write( buffer, 0, bytesRead );
                    }
                    reader.close();
                    out.flush();
                    out.close();
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
