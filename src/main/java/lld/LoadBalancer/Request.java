package lld.LoadBalancer;

import java.util.Map;

public class Request {
    String id;
    Map<String,String> parameters;
    RequestType requestType;
    public Request(String id, RequestType requestType){
        this.id = id;
        this.requestType = requestType;
    }
}
