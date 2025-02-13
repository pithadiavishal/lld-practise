package lld.urlshortner;

public class Base62Encoder implements Encoder{
    private static final String BASE_62_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @Override
    public String encode(Integer number) {
        StringBuilder stringBuilder = new StringBuilder();
        while(number!=0){
            int index = number%62;
            stringBuilder.append(BASE_62_CHARACTERS.charAt(index-1));
            number=number/62;
        }
        return stringBuilder.toString();
    }
}
