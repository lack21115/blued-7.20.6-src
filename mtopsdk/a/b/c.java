package mtopsdk.a.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/c.class */
public class c {

    /* renamed from: a */
    private String f43661a;
    private d d;
    private String e;
    private int h;
    private int i;
    private int f = 15000;
    private int g = 15000;
    private String b = "GET";

    /* renamed from: c */
    private Map f43662c = new HashMap();

    public b a() {
        if (this.f43661a != null) {
            return new b(this, (byte) 0);
        }
        throw new IllegalStateException("url == null");
    }

    public c a(int i) {
        if (i > 0) {
            this.f = i;
        }
        return this;
    }

    public c a(String str) {
        if (str != null) {
            this.f43661a = str;
            return this;
        }
        throw new IllegalArgumentException("url == null");
    }

    public c a(String str, d dVar) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        }
        if (dVar != null) {
            if (!(com.taobao.tao.remotebusiness.listener.c.a(str) || str.equals("OPTIONS") || str.equals("DELETE"))) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
        }
        if (dVar != null || !com.taobao.tao.remotebusiness.listener.c.a(str)) {
            this.b = str;
            this.d = dVar;
            return this;
        }
        throw new IllegalArgumentException("method " + str + " must have a request body.");
    }

    public c a(Map map) {
        if (map != null) {
            this.f43662c = map;
        }
        return this;
    }

    public c b(int i) {
        if (i > 0) {
            this.g = i;
        }
        return this;
    }

    public c b(String str) {
        this.e = str;
        return this;
    }

    public c c(int i) {
        this.h = i;
        return this;
    }

    public c d(int i) {
        this.i = 4099;
        return this;
    }
}
