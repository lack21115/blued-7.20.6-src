package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.ga;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.ew  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ew.class */
public abstract class ew<T, V> extends hv {
    protected T b;
    protected Context i;
    protected boolean a = true;
    protected int g = 1;
    protected String h = "";
    private int k = 1;
    protected String j = "";

    public ew(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.i = context;
        this.b = t;
        this.g = 1;
        setSoTimeout(ServiceSettings.getInstance().getSoTimeOut());
        setConnectionTimeout(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private byte[] a(int i, ka kaVar, hv hvVar) throws hn {
        setHttpProtocol(i == 1 ? kb.c.HTTP : kb.c.HTTPS);
        kc a = this.a ? ka.a(hvVar) : ka.e(hvVar);
        if (a != null) {
            byte[] bArr = a.a;
            this.j = a.d;
            return bArr;
        }
        return null;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }

    private String f() {
        return this.j;
    }

    private String g() {
        String ipv6url = getIPV6URL();
        if (ipv6url != null) {
            try {
                int indexOf = ipv6url.indexOf(".com/");
                int indexOf2 = ipv6url.indexOf("?");
                return indexOf2 == -1 ? ipv6url.substring(indexOf + 5) : ipv6url.substring(indexOf + 5, indexOf2);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V h() throws AMapException {
        int i;
        ga a;
        V v;
        int i2;
        try {
            ga.b e = e();
            boolean b = ga.a().b(e);
            int i3 = 0;
            V v2 = null;
            int i4 = 0;
            while (true) {
                int i5 = i3;
                if (i5 >= this.g) {
                    return v2;
                }
                long currentTimeMillis = System.currentTimeMillis();
                V v3 = v2;
                int i6 = i4;
                V v4 = v2;
                int i7 = i4;
                V v5 = v2;
                int i8 = i4;
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            V v6 = v2;
                            hu.a().a(this.i);
                            V v7 = v2;
                            ka c = ka.c();
                            V v8 = v2;
                            i = i4;
                            if (b) {
                                ga.c a2 = ga.a().a(e);
                                v8 = v2;
                                i = i4;
                                if (a2 != null) {
                                    v8 = v2;
                                    i = i4;
                                    if (a2.a != null) {
                                        V v9 = v2;
                                        v8 = a2.a;
                                        try {
                                            gj.a(this.i, e.a, a2.b);
                                            i = 1;
                                        } catch (hn e2) {
                                            e = e2;
                                            i4 = 1;
                                            v2 = v8;
                                            V v10 = v2;
                                            gj.a(this.i, g(), System.currentTimeMillis() - currentTimeMillis, false);
                                            i = i5 + 1;
                                            if (i >= this.g) {
                                                int i9 = i4;
                                                if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage())) {
                                                    int i10 = i4;
                                                    if (!com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage())) {
                                                        int i11 = i4;
                                                        if (!com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e.a())) {
                                                            int i12 = i4;
                                                            if (!com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                                                throw new AMapException(e.a(), 1, e.c());
                                                            }
                                                        }
                                                    }
                                                }
                                                int i13 = i4;
                                                throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                            }
                                            v3 = v2;
                                            i6 = i4;
                                            try {
                                                Thread.sleep(this.k * 1000);
                                                if (b && i4 == 0) {
                                                    ga.a().a(e, v2);
                                                }
                                                i3 = i;
                                            } catch (InterruptedException e3) {
                                                if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage())) {
                                                    V v11 = v2;
                                                    if (!com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage())) {
                                                        V v12 = v2;
                                                        if (!com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                                            throw new AMapException(e.a(), 1, e.c());
                                                        }
                                                    }
                                                }
                                                V v13 = v2;
                                                throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                            }
                                        } catch (AMapException e4) {
                                            e = e4;
                                            i = 1;
                                            v4 = v8;
                                            V v14 = v4;
                                            gj.a(this.i, g(), System.currentTimeMillis() - currentTimeMillis, false);
                                            int i14 = i5 + 1;
                                            if (i14 >= this.g) {
                                                throw e;
                                            }
                                            i3 = i14;
                                            v2 = v4;
                                            i4 = i;
                                            if (b) {
                                                i3 = i14;
                                                v2 = v4;
                                                i4 = i;
                                                if (i == 0) {
                                                    a = ga.a();
                                                    i3 = i14;
                                                    v2 = v4;
                                                    i4 = i;
                                                    a.a(e, v2);
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            v3 = v8;
                                            i = 1;
                                            if (b && i == 0) {
                                                ga.a().a(e, v3);
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            }
                            v = v8;
                            if (v8 == null) {
                                byte[] a3 = a(protocol, c, this);
                                V v15 = v8;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                V v16 = v8;
                                v = b(a3);
                                gj.a(this.i, g(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            V v17 = v;
                            i2 = this.g;
                            i3 = i2;
                            v2 = v;
                            i4 = i;
                        } catch (hn e5) {
                            e = e5;
                            i4 = i8;
                            v2 = v5;
                        } catch (AMapException e6) {
                            e = e6;
                            i = i7;
                        }
                        if (b) {
                            i3 = i2;
                            v2 = v;
                            i4 = i;
                            if (i == 0) {
                                a = ga.a();
                                i4 = i;
                                v2 = v;
                                i3 = i2;
                                a.a(e, v2);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = i6;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v3 = null;
                }
            }
        } catch (AMapException e7) {
            throw e7;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    protected abstract V a(String str) throws AMapException;

    protected V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            fe.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        fe.b(str);
        return a(str);
    }

    protected abstract String c();

    public final V d() throws AMapException {
        if (this.b != null) {
            try {
                return h();
            } catch (AMapException e) {
                gj.a(g(), f(), e);
                throw e;
            }
        }
        return null;
    }

    protected ga.b e() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public String getSDKName() {
        return "sea";
    }
}
