package lld.LoadBalancer;

public class Destination {
    String ipAddress;
    int requestsBeingServed;
    int threshold;

    public Destination(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public boolean acceptRequest(Request request){
        if(requestsBeingServed < threshold){
            requestsBeingServed++;
            return true;
        }
        return false;
    }

    private void onRequestCompletion(){
        requestsBeingServed--;
    }
}
