package java.net;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/net/CookieManager.class */
public class CookieManager extends CookieHandler {
    private static final String VERSION_ONE_HEADER = "Set-cookie2";
    private static final String VERSION_ZERO_HEADER = "Set-cookie";
    private CookiePolicy policy;
    private CookieStore store;

    public CookieManager() {
        this(null, null);
    }

    public CookieManager(CookieStore cookieStore, CookiePolicy cookiePolicy) {
        this.store = cookieStore == null ? new CookieStoreImpl() : cookieStore;
        this.policy = cookiePolicy == null ? CookiePolicy.ACCEPT_ORIGINAL_SERVER : cookiePolicy;
    }

    private static Map<String, List<String>> cookiesToHeaders(List<HttpCookie> list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (HttpCookie httpCookie : list) {
            i = Math.min(i, httpCookie.getVersion());
        }
        if (i == 1) {
            sb.append("$Version=\"1\"; ");
        }
        sb.append(list.get(0).toString());
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return Collections.singletonMap("Cookie", Collections.singletonList(sb.toString()));
            }
            sb.append("; ").append(list.get(i3).toString());
            i2 = i3 + 1;
        }
    }

    private static List<HttpCookie> parseCookie(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null && (key.equalsIgnoreCase(VERSION_ZERO_HEADER) || key.equalsIgnoreCase(VERSION_ONE_HEADER))) {
                for (String str : entry.getValue()) {
                    try {
                        for (HttpCookie httpCookie : HttpCookie.parse(str)) {
                            arrayList.add(httpCookie);
                        }
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
        }
        return arrayList;
    }

    static String pathToCookiePath(String str) {
        return str == null ? BridgeUtil.SPLIT_MARK : str.substring(0, str.lastIndexOf(47) + 1);
    }

    @Override // java.net.CookieHandler
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        if (uri == null || map == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (HttpCookie httpCookie : this.store.get(uri)) {
            if (HttpCookie.pathMatches(httpCookie, uri) && HttpCookie.secureMatches(httpCookie, uri) && HttpCookie.portMatches(httpCookie, uri)) {
                arrayList.add(httpCookie);
            }
        }
        return cookiesToHeaders(arrayList);
    }

    public CookieStore getCookieStore() {
        return this.store;
    }

    @Override // java.net.CookieHandler
    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        if (uri == null || map == null) {
            throw new IllegalArgumentException();
        }
        for (HttpCookie httpCookie : parseCookie(map)) {
            if (httpCookie.getDomain() == null) {
                httpCookie.setDomain(uri.getHost());
            }
            if (httpCookie.getPath() == null) {
                httpCookie.setPath(pathToCookiePath(uri.getPath()));
            } else if (!HttpCookie.pathMatches(httpCookie, uri)) {
            }
            if ("".equals(httpCookie.getPortlist())) {
                httpCookie.setPortlist(Integer.toString(uri.getEffectivePort()));
            } else if (httpCookie.getPortlist() != null && !HttpCookie.portMatches(httpCookie, uri)) {
            }
            if (this.policy.shouldAccept(uri, httpCookie)) {
                this.store.add(uri, httpCookie);
            }
        }
    }

    public void setCookiePolicy(CookiePolicy cookiePolicy) {
        if (cookiePolicy != null) {
            this.policy = cookiePolicy;
        }
    }
}
