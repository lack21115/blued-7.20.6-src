package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/CookiePolicy.class */
public interface CookiePolicy {
    public static final CookiePolicy ACCEPT_ALL = new CookiePolicy() { // from class: java.net.CookiePolicy.1
        @Override // java.net.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie httpCookie) {
            return true;
        }
    };
    public static final CookiePolicy ACCEPT_NONE = new CookiePolicy() { // from class: java.net.CookiePolicy.2
        @Override // java.net.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie httpCookie) {
            return false;
        }
    };
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER = new CookiePolicy() { // from class: java.net.CookiePolicy.3
        @Override // java.net.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie httpCookie) {
            return HttpCookie.domainMatches(httpCookie.getDomain(), uri.getHost());
        }
    };

    boolean shouldAccept(URI uri, HttpCookie httpCookie);
}
