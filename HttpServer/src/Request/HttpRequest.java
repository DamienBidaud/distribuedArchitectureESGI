package Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HttpRequest implements IHttpRequest {

    private Map<String, Object> parameters;
    private Map<String, Object> cookies;
    private String method;
    private String name;
    private String path;

    public HttpRequest(Socket socket) throws IOException {
        this.parameters = new HashMap<>();
        this.cookies = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str = br.readLine();
        if (str != null) {
            String[] line = str.split(" ");
            if (line.length != 3) {
                try {
                    throw new Exception("Incorrect method");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            method = line[0];
            path = line[1];
            line = path.split("\\?");
            path = line[0];
            if (line.length > 1) {

                String[] paremetreUrl = line[1].split("&");
                for (String para : paremetreUrl
                        ) {
                    line = para.split("=");
                    if (line.length > 0) {
                        if (line.length > 1)
                            parameters.put(line[0], line[1]);
                        else
                            parameters.put(line[0], "");
                    }
                }
            }
            while ((str = br.readLine()) != null) {
                if ((line = str.split(":")).length > 1) {
                    if (line[0].equals("Cookie")) {
                        cookies.put(line[0], line[1]);
                    } else {
                        parameters.put(line[0], line[1]);
                    }
                }
                if (str.equals("")) {
                    break;
                }
            }
            name = (String) getParameter("Host");
            name = name.replace(" ", "");
            String[] hostTmp = name.split("\\.");
            name = hostTmp[1];
        }
    }

    @Override
    public Object getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public String[] getParametersName() {
        String names[] = new String[this.parameters.size()];
        Set setParameters = this.parameters.keySet();
        Iterator it = setParameters.iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = (String) it.next();
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
        String names[] = new String[this.cookies.size()];
        Set setParameters = this.cookies.keySet();
        Iterator it = setParameters.iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = (String) it.next();
            names[i] = key;
            i++;
        }
        return names;
    }

    @Override
    public String getRelativePath() {
        return this.path;
    }

    @Override
    public String getAbsolutePath() {
        return "C:/www/" + this.name + "" + this.path;
    }
}
