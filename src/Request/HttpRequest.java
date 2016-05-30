package Request;

import java.io.*;
import java.net.Socket;
import java.util.*;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by bidau on 30/05/2016.
 */
public class HttpRequest implements IHttpRequest {

    private Map<String, Object> parameters;
    private Map<String, Object> cookies;
    private String method;
    private String name;

    public HttpRequest(Socket socket) throws IOException {
        this.parameters = new HashMap<>();
        this.cookies = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = br.readLine();
        String[] line  =  str.split(" ");
        method = line[0];
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        pw.println(pw);
        while((str = br.readLine()) != null){
            pw.println(str);
            if((line = str.split(":")).length>1){
                if(line[0].equals("Cookie")){
                    cookies.put(line[0], line[1]);
                }else {
                    parameters.put(line[0], line[1]);
                }
            }
            if(str.equals("")){
                break;
            }
        }
        name = (String)getParameter("Host");
    }

    @Override
    public Object getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public String[] getParametersName() {
        String names[] =  new String[this.parameters.size()];
        Set setParameters = this.parameters.keySet();
        Iterator it = setParameters.iterator();
        int i = 0;
        while(it.hasNext()){
            String key= (String) it.next();
            names[i] = key;
            i++;
        }
        return names;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public Object getCookie(String name) {
        return this.cookies.get(name);
    }

    @Override
    public String[] getCookiesName() {
        String names[] =  new String[this.cookies.size()];
        Set setParameters = this.cookies.keySet();
        Iterator it = setParameters.iterator();
        int i = 0;
        while(it.hasNext()){
            String key= (String) it.next();
            names[i] = key;
            i++;
        }
        return names;
    }

    @Override
    public String getRelativePath() {
        return "\\";
    }

    @Override
    public String getAbsolutePath() {
        return "C:\\www\\" + this.name;
    }
}
