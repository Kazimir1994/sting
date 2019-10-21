package gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config.model;

public class GatewayRoutes {
    public static final String REPLACEMENT_NAME = "/${RID}";
    private String url;
    private String path;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRewritePath() {
        return path.replace("**", "") + "(?<RID>.*)";
    }

}
