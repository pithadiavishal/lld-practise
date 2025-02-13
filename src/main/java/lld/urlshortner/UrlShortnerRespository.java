package lld.urlshortner;

import java.util.HashMap;
import java.util.Map;

public class UrlShortnerRespository {
    Map<String, String> shortUrlOriginalUrlMapping;
    public UrlShortnerRespository(){
        this.shortUrlOriginalUrlMapping = new HashMap<>();
    }
    public void addMapping(String shortUrl, String longUrl){
        shortUrlOriginalUrlMapping.put(shortUrl, longUrl);
    }
    public String getOriginalUrl(String shortUrl){
        return shortUrlOriginalUrlMapping.get(shortUrl);
    }
}
