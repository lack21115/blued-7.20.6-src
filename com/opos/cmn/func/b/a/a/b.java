package com.opos.cmn.func.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.STManager;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.g;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a/b.class */
public class b {
    public static g a(Context context) {
        try {
            new g.a().a(e(context));
            return new g.a().a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("ParamUtils", "getDefaultInitParameter", e);
            return null;
        }
    }

    public static d a(Context context, d dVar) {
        boolean z;
        try {
            d.a a2 = new d.a().a(dVar);
            Map<String, String> a3 = a(dVar.f11171c);
            byte[] bArr = dVar.d;
            if (TextUtils.isEmpty(a(a3, "Route-Data")) && context != null) {
                a3.put("Route-Data", e.a(context));
            }
            byte[] bArr2 = bArr;
            if (dVar.g) {
                bArr2 = bArr;
                if (dVar.d != null) {
                    boolean z2 = false;
                    if (TextUtils.isEmpty(a(a3, "Content-Encoding"))) {
                        z = false;
                    } else {
                        com.opos.cmn.an.f.a.b("ParamUtils", "isAlreadyCompress=true");
                        z = true;
                    }
                    bArr2 = bArr;
                    if (!z) {
                        if (dVar.d.length >= 1024) {
                            z2 = true;
                        }
                        com.opos.cmn.an.f.a.b("ParamUtils", "neeCompress=" + z2);
                        bArr2 = bArr;
                        if (z2) {
                            bArr2 = com.opos.cmn.b.c.a.a(bArr);
                            a3.put("Content-Encoding", "gzip");
                        }
                    }
                }
            }
            byte[] bArr3 = bArr2;
            if (dVar.f) {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] executeEncryptBytesV2 = EncryptUtils.executeEncryptBytesV2(bArr2);
                if (executeEncryptBytesV2 != null && executeEncryptBytesV2.length > 0) {
                    a3.put("encrypt", com.huawei.hms.ads.dynamicloader.b.f);
                    bArr2 = executeEncryptBytesV2;
                    com.opos.cmn.an.f.a.b("ParamUtils", "crypt data costTime:" + (System.currentTimeMillis() - currentTimeMillis));
                    bArr3 = bArr2;
                }
                com.opos.cmn.an.f.a.b("ParamUtils", "crypt data failed");
                com.opos.cmn.an.f.a.b("ParamUtils", "crypt data costTime:" + (System.currentTimeMillis() - currentTimeMillis));
                bArr3 = bArr2;
            }
            return a2.a(a3).a(bArr3).a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ParamUtils", "getProcessedNetRequest", e);
            return dVar;
        }
    }

    private static String a(Map<String, String> map, String str) {
        if (str == null) {
            return null;
        }
        String str2 = null;
        if (map != null) {
            str2 = null;
            if (map.size() != 0) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (true) {
                    str2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    if (str.equalsIgnoreCase(next.getKey())) {
                        str2 = next.getValue();
                        break;
                    }
                }
            }
        }
        return str2;
    }

    private static Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public static String b(Context context) {
        return com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
    }

    public static String c(Context context) {
        return com.opos.cmn.biz.a.d.a(context);
    }

    public static b.a d(Context context) {
        return "CN".equalsIgnoreCase(com.opos.cmn.biz.a.d.a(context)) ? b.a.CN : STManager.REGION_OF_IN.equalsIgnoreCase(com.opos.cmn.biz.a.d.a(context)) ? b.a.SA : b.a.SEA;
    }

    private static SSLSocketFactory e(Context context) {
        SSLSocketFactory sSLSocketFactory;
        try {
            sSLSocketFactory = com.opos.cmn.biz.a.g.a(context);
        } catch (Exception e) {
            sSLSocketFactory = null;
        }
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        if (sSLSocketFactory == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                sSLSocketFactory2 = sSLContext.getSocketFactory();
            } catch (GeneralSecurityException e2) {
                return sSLSocketFactory;
            }
        }
        return sSLSocketFactory2;
    }
}
