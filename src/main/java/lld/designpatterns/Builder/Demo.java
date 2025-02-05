package lld.designpatterns.Builder;

public class Demo {

    public static void main(String[] args) {
        UrlBuilder.Builder builder = new UrlBuilder.Builder();
        builder.protocol("http://").hostname("newwebsite:").port("443");

        UrlBuilder urlBuilder = builder.build();
        System.out.print(urlBuilder.protocol);
        System.out.print(urlBuilder.hostname);
        System.out.print(urlBuilder.port);

    }
}
