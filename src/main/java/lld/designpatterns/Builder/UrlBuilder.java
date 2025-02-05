package lld.designpatterns.Builder;

public class UrlBuilder {
    public static class Builder {
        private String protocol;
        private String hostname;
        private String port;
        private String pathParam;
        private String queryParameter;

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public Builder port(String port) {
            this.port = port;
            return this;
        }

        public Builder pathParam(String pathParam) {
            this.pathParam = pathParam;
            return this;
        }

        public Builder queryParameter(String queryParameter) {
            this.queryParameter = queryParameter;
            return this;
        }

        public UrlBuilder build() {
            return new UrlBuilder(this);
        }
    }
    public final String protocol;
    public final String hostname;
    public final String port;
    public final String pathParam;
    public final String queryParameter;

    private UrlBuilder(Builder builder){
        this.protocol = builder.protocol;
        this.hostname = builder.hostname;
        this.pathParam = builder.pathParam;
        this.port = builder.port;
        this.queryParameter = builder.queryParameter;
    }
}
