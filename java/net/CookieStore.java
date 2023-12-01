package java.net;

import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/net/CookieStore.class */
public interface CookieStore {
    void add(URI uri, HttpCookie httpCookie);

    List<HttpCookie> get(URI uri);

    List<HttpCookie> getCookies();

    List<URI> getURIs();

    boolean remove(URI uri, HttpCookie httpCookie);

    boolean removeAll();
}
