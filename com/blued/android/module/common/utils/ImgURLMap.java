package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ImgURLMap.class */
public final class ImgURLMap {

    /* renamed from: a  reason: collision with root package name */
    public static final ImgURLMap f10885a = new ImgURLMap();
    private static final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f10886c = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> d = new ConcurrentHashMap<>();
    private static final String e = "img_url_live.json";
    private static final String f = "img_url_yy.json";
    private static final String g = "img_url.json";

    private ImgURLMap() {
    }

    private final boolean a(String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            try {
                String b2 = b(str);
                if (TextUtils.isEmpty(b2)) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject(b2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (next != null && optString != null) {
                        concurrentHashMap.put(next, optString);
                    }
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return true;
    }

    private final String b(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (AppInfo.d() == null) {
            if (AppInfo.m()) {
                throw new RuntimeException("AppInfo getAppContext() is null !");
            }
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (AppInfo.m()) {
                throw new RuntimeException("config name is null !");
            }
            return null;
        } else {
            try {
                inputStream = AppInfo.d().getAssets().open(str);
            } catch (Exception e2) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.c(forName, "forName(\"UTF-8\")");
                String str2 = new String(bArr, forName);
                if (inputStream == null) {
                    return str2;
                }
                try {
                    inputStream.close();
                    return str2;
                } catch (Exception e3) {
                    return str2;
                }
            } catch (Exception e4) {
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (Exception e5) {
                    return null;
                }
            } catch (Throwable th2) {
                inputStream2 = inputStream;
                th = th2;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 != 0) goto La
        L4:
            java.lang.String r0 = ""
            r5 = r0
            goto L88
        La:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.b
            int r0 = r0.size()
            if (r0 != 0) goto L20
            com.blued.android.module.common.utils.ImgURLMap r0 = com.blued.android.module.common.utils.ImgURLMap.f10885a
            java.lang.String r1 = com.blued.android.module.common.utils.ImgURLMap.e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = com.blued.android.module.common.utils.ImgURLMap.b
            boolean r0 = r0.a(r1, r2)
        L20:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.f10886c
            int r0 = r0.size()
            if (r0 != 0) goto L36
            com.blued.android.module.common.utils.ImgURLMap r0 = com.blued.android.module.common.utils.ImgURLMap.f10885a
            java.lang.String r1 = com.blued.android.module.common.utils.ImgURLMap.f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = com.blued.android.module.common.utils.ImgURLMap.f10886c
            boolean r0 = r0.a(r1, r2)
        L36:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.d
            int r0 = r0.size()
            if (r0 != 0) goto L4c
            com.blued.android.module.common.utils.ImgURLMap r0 = com.blued.android.module.common.utils.ImgURLMap.f10885a
            java.lang.String r1 = com.blued.android.module.common.utils.ImgURLMap.g
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = com.blued.android.module.common.utils.ImgURLMap.d
            boolean r0 = r0.a(r1, r2)
        L4c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.b
            r1 = r5
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L61
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.b
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            r5 = r0
            goto L88
        L61:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.f10886c
            r1 = r5
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L76
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.f10886c
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            r5 = r0
            goto L88
        L76:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.d
            r1 = r5
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L4
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = com.blued.android.module.common.utils.ImgURLMap.d
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            r5 = r0
        L88:
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L95
            r0 = 0
            r5 = r0
        L95:
            r0 = r5
            if (r0 != 0) goto La1
            r0 = r4
            com.blued.android.module.common.utils.ImgURLMap r0 = (com.blued.android.module.common.utils.ImgURLMap) r0
            r5 = r0
            java.lang.String r0 = ""
            return r0
        La1:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.ImgURLMap.a(java.lang.String):java.lang.String");
    }

    public final void a() {
        a(e, b);
        a(f, f10886c);
        a(g, d);
    }
}
