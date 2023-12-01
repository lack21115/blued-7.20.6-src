package java.net;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/net/CookieStoreImpl.class */
public final class CookieStoreImpl implements CookieStore {
    private final Map<URI, List<HttpCookie>> map = new HashMap();

    private URI cookiesUri(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URI("http", uri.getHost(), null, null);
        } catch (URISyntaxException e) {
            return uri;
        }
    }

    @Override // java.net.CookieStore
    public void add(URI uri, HttpCookie httpCookie) {
        synchronized (this) {
            if (httpCookie == null) {
                throw new NullPointerException("cookie == null");
            }
            URI cookiesUri = cookiesUri(uri);
            ArrayList arrayList = this.map.get(cookiesUri);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.map.put(cookiesUri, arrayList);
            } else {
                arrayList.remove(httpCookie);
            }
            arrayList.add(httpCookie);
        }
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> get(URI uri) {
        List<HttpCookie> unmodifiableList;
        synchronized (this) {
            if (uri == null) {
                throw new NullPointerException("uri == null");
            }
            ArrayList arrayList = new ArrayList();
            List<HttpCookie> list = this.map.get(uri);
            if (list != null) {
                Iterator<HttpCookie> it = list.iterator();
                while (it.hasNext()) {
                    HttpCookie next = it.next();
                    if (next.hasExpired()) {
                        it.remove();
                    } else {
                        arrayList.add(next);
                    }
                }
            }
            for (Map.Entry<URI, List<HttpCookie>> entry : this.map.entrySet()) {
                if (!uri.equals(entry.getKey())) {
                    Iterator<HttpCookie> it2 = entry.getValue().iterator();
                    while (it2.hasNext()) {
                        HttpCookie next2 = it2.next();
                        if (HttpCookie.domainMatches(next2.getDomain(), uri.getHost())) {
                            if (next2.hasExpired()) {
                                it2.remove();
                            } else if (!arrayList.contains(next2)) {
                                arrayList.add(next2);
                            }
                        }
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> getCookies() {
        List<HttpCookie> unmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            for (List<HttpCookie> list : this.map.values()) {
                Iterator<HttpCookie> it = list.iterator();
                while (it.hasNext()) {
                    HttpCookie next = it.next();
                    if (next.hasExpired()) {
                        it.remove();
                    } else if (!arrayList.contains(next)) {
                        arrayList.add(next);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    @Override // java.net.CookieStore
    public List<URI> getURIs() {
        List<URI> unmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.map.keySet());
            arrayList.remove((Object) null);
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    @Override // java.net.CookieStore
    public boolean remove(URI uri, HttpCookie httpCookie) {
        boolean remove;
        synchronized (this) {
            if (httpCookie == null) {
                throw new NullPointerException("cookie == null");
            }
            List<HttpCookie> list = this.map.get(cookiesUri(uri));
            remove = list != null ? list.remove(httpCookie) : false;
        }
        return remove;
    }

    @Override // java.net.CookieStore
    public boolean removeAll() {
        boolean z;
        synchronized (this) {
            z = !this.map.isEmpty();
            this.map.clear();
        }
        return z;
    }
}
