package lld.urlshortner;

public class UrlShortner {
    private Encoder encoder;
    private UrlShortnerRespository urlShortnerRespository;
    public UrlShortner(Encoder encoder, UrlShortnerRespository urlShortnerRespository){
        this.encoder = encoder;
        this.urlShortnerRespository = urlShortnerRespository;
    }
    public String shorterUrl(String originalUrl){
        String shortUrl = encoder.encode(CounterUtil.getCounter());
        urlShortnerRespository.addMapping(shortUrl, originalUrl);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl){
        return urlShortnerRespository.getOriginalUrl(shortUrl);
    }
}
