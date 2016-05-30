package Request;

import java.util.*;

/**
 * Created by bidau on 30/05/2016.
 */
public class HttpRequest implements IHttpRequest {

    private Map<String, Object> parameters;
    private Map<String, Object> cookies;
    private String method;

    public HttpRequest(String method){
        this.parameters = new HashMap<>();
        this.cookies = new HashMap<>();
        this.method = method;
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
}
