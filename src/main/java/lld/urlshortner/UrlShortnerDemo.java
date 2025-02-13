package lld.urlshortner;

public class UrlShortnerDemo {
    public static void main(String[] args) {
        UrlShortner shortner = new UrlShortner(new Base62Encoder(), new UrlShortnerRespository());
        String shortUrl1 = shortner.shorterUrl("http://aba.com/url1");
        String shortUrl2 = shortner.shorterUrl("http://aba.com/url2");
        System.out.println(shortUrl1);
        System.out.println(shortUrl2);
        System.out.println(shortner.getOriginalUrl(shortUrl1));
        System.out.println(shortner.getOriginalUrl(shortUrl2));
    }
}
