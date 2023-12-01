package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import android.view.Window;
import com.amap.api.col.p0003sl.ju;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.kb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kb.class */
public abstract class kb {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;
    ju.a f;
    private String h;
    private boolean i;
    private boolean j;
    int c = Window.PROGRESS_SECONDARY_START;
    int d = Window.PROGRESS_SECONDARY_START;
    Proxy e = null;
    private boolean a = false;
    private int b = Window.PROGRESS_SECONDARY_START;
    private boolean g = true;
    private a k = a.NORMAL;
    private b l = b.FIRST_NONDEGRADE;

    /* renamed from: com.amap.api.col.3sl.kb$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kb$a.class */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        
        private int f;

        a(int i) {
            this.f = i;
        }
    }

    /* renamed from: com.amap.api.col.3sl.kb$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kb$b.class */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        
        private int h;

        b(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int i2 = this.h;
            return i2 == FIRST_NONDEGRADE.h || i2 == NEVER_GRADE.h || i2 == FIX_NONDEGRADE.h;
        }

        public final boolean c() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == DEGRADE_ONLY.h || i2 == FIX_DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_ONLY.h;
        }

        public final boolean d() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_BYERROR.h;
        }

        public final boolean e() {
            return this.h == NEVER_GRADE.h;
        }
    }

    /* renamed from: com.amap.api.col.3sl.kb$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kb$c.class */
    public enum c {
        HTTP(0),
        HTTPS(1);
        
        private int c;

        c(int i) {
            this.c = i;
        }
    }

    private String a(String str) {
        byte[] entityBytes = getEntityBytes();
        String str2 = str;
        if (entityBytes != null) {
            if (entityBytes.length == 0) {
                return str;
            }
            Map<String, String> params = getParams();
            HashMap<String, String> hashMap = params;
            if (ju.e != null) {
                if (params != null) {
                    params.putAll(ju.e);
                    hashMap = params;
                } else {
                    hashMap = ju.e;
                }
            }
            if (hashMap == null) {
                return str;
            }
            String a2 = jy.a(hashMap);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("?");
            stringBuffer.append(a2);
            str2 = stringBuffer.toString();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return a(getURL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a getDegradeAbility() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b getDegradeType() {
        return this.l;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNon_degrade_final_Host() {
        return this.h;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReal_max_timeout() {
        return this.b;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.d;
    }

    public abstract String getURL();

    public ju.a getUrlConnectionImpl() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isBinary() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHostToIP() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHttps() {
        return this.j;
    }

    protected boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isIPV6Request() {
        return this.i;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    protected String parseSDKNameFromPlatInfo(String str) {
        String str2;
        String str3 = "";
        String str4 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(com.alipay.sdk.sys.a.b);
                str4 = "";
                if (split.length > 1) {
                    int length = split.length;
                    int i = 0;
                    String str5 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        String str6 = split[i];
                        if (str6.contains("sdkversion")) {
                            str5 = str6;
                        }
                        if (str6.contains("product")) {
                            str2 = str6;
                            break;
                        }
                        i++;
                    }
                    str4 = "";
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        str4 = "";
                        if (split2.length > 1) {
                            String trim = split2[1].trim();
                            str4 = trim;
                            if (!TextUtils.isEmpty(str5)) {
                                str4 = trim;
                                if (TextUtils.isEmpty(ip.a(trim))) {
                                    String[] split3 = str5.split("=");
                                    str4 = trim;
                                    if (split3.length > 1) {
                                        str3 = trim;
                                        ip.a(trim, split3[1].trim());
                                        return trim;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            it.a(th, "ht", "pnfp");
            str4 = str3;
        }
        return str4;
    }

    protected String parseSdkNameFromHeader(Map<String, String> map) {
        String str = null;
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                str = parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return str;
        } catch (Throwable th) {
            it.a(th, "ht", "pnfh");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parseSdkNameFromRequest() {
        String str;
        String str2;
        try {
            str = getSDKName();
            str2 = str;
            try {
                if (TextUtils.isEmpty(str)) {
                    return this.a ? parseSDKNameFromPlatInfo(((jv) this).g()) : parseSdkNameFromHeader(getRequestHead());
                }
            } catch (Throwable th) {
                th = th;
                it.a(th, "ht", "pnfr");
                str2 = str;
                return str2;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        return str2;
    }

    public void setBinary(boolean z) {
        this.a = z;
    }

    public final void setConnectionTimeout(int i) {
        this.c = i;
    }

    public void setDegradeAbility(a aVar) {
        this.k = aVar;
    }

    public void setDegradeType(b bVar) {
        this.l = bVar;
    }

    public void setHostToIP(boolean z) {
        this.g = z;
    }

    public void setHttpProtocol(c cVar) {
        this.j = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z) {
        this.i = z;
    }

    public void setNon_degrade_final_Host(String str) {
        this.h = str;
    }

    public final void setProxy(Proxy proxy) {
        this.e = proxy;
    }

    public void setReal_max_timeout(int i) {
        this.b = i;
    }

    public final void setSoTimeout(int i) {
        this.d = i;
    }

    public void setUrlConnectionImpl(ju.a aVar) {
        this.f = aVar;
    }
}
