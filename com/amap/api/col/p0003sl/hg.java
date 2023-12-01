package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.hg  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hg.class */
public abstract class hg<T, V> extends da {

    /* renamed from: a  reason: collision with root package name */
    protected T f5062a;
    protected Context g;
    protected String h;
    protected int b = 1;
    protected boolean i = false;

    public hg(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.g = context;
        this.f5062a = t;
        this.b = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V b(kc kcVar) throws hf {
        return a(kcVar);
    }

    private V b(byte[] bArr) throws hf {
        return a(bArr);
    }

    private V e() throws hf {
        V v = null;
        int i = 0;
        while (i < this.b) {
            V v2 = v;
            V v3 = v;
            try {
                setProxy(hz.a(this.g));
                V v4 = v;
                if (this.i) {
                    V v5 = v;
                    v = b(makeHttpRequestNeedHeader());
                } else {
                    v = b(makeHttpRequest());
                }
                V v6 = v;
                i = this.b;
            } catch (hf e) {
                i++;
                if (i >= this.b) {
                    throw new hf(e.a());
                }
                v = v2;
            } catch (hn e2) {
                i++;
                if (i >= this.b) {
                    if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOWN.equals(e2.a()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new hf(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new hf(e2.a());
                }
                try {
                    Thread.sleep(1000L);
                    v = v3;
                } catch (InterruptedException e3) {
                    if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new hf(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new hf(e2.a());
                }
            } catch (Throwable th) {
                throw new hf(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
            }
        }
        return v;
    }

    protected V a(kc kcVar) throws hf {
        return null;
    }

    protected V a(byte[] bArr) throws hf {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        hi.a(str);
        return d(str);
    }

    protected abstract String c();

    public final V d() throws hf {
        if (this.f5062a != null) {
            try {
                return e();
            } catch (hf e) {
                dw.a(e);
                throw e;
            }
        }
        return null;
    }

    protected abstract V d(String str) throws hf;

    @Override // com.amap.api.col.p0003sl.kb
    public Map<String, String> getRequestHead() {
        ia a2 = dw.a();
        String b = a2 != null ? a2.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", w.f5440c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("X-INFO", hr.b(this.g));
        hashtable.put("key", ho.f(this.g));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }
}
