package ideals.enums;

public enum Endpoints {

    USERS("/api/users"),
    USER_BY_ID("/api/users/{id}")
    ;

    private final String url;

    Endpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
