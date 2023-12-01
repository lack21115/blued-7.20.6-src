package com.getui.gtc.dim.b;

import android.os.Bundle;
import android.util.Base64;
import com.getui.gtc.dim.AppDataProvider;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/b/e.class */
public final class e extends d {
    private static final Map<String, String> h = new HashMap<String, String>() { // from class: com.getui.gtc.dim.b.e.1
        {
            put("dim-2-1-1-1", "XhNWH0ANTAVL");
            put("dim-2-1-1-3", "XhNWHy4=");
            put("dim-2-1-1-4", "XhNWHy0=");
            put("dim-2-1-2-1", "XhNACVYbWhNd");
            put("dim-2-1-2-3", "XhNACTg=");
            put("dim-2-1-2-4", "XhNACTs=");
            put("dim-2-1-3-1", "WhtY");
            put("dim-2-1-3-2", "WhtYB0YKRg==");
            put("dim-2-1-4-1", "RAFTGlsXSAZTHlwZSw==");
            put("dim-2-1-5-1", "WBlQFA==");
            put("dim-2-1-6-1", "Xh1eF1MMQQBJBw==");
            put("dim-2-1-6-3", "Xh1eF1Ni");
            put("dim-2-1-6-4", "Xh1eF1Nh");
            put("dim-2-1-7-1", "VhhcDkEITBNaHg==");
            put("dim-2-1-8-1", "VhJEAVMHTh1UGl0CSw8=");
            put("dim-2-1-9-1", "VQdGCEw=");
            put("dim-2-1-10-1", "WhVRFFg=");
            put("dim-2-1-11-1", "RQpH");
            put("dim-2-1-12-1", "WhtVAEYHRBBFF1IA");
            put("dim-2-1-13-1", "RB1OEUcCUANKBUs=");
            put("dim-2-1-14-1", "VBVHFVwZSw==");
            put("dim-2-1-15-1", "WRxIH1ACSRZCG0sO");
            put("dim-2-1-16-1", "Xg4=");
            put("dim-2-1-16-2", "Xg5Ybg==");
            put("dim-2-1-17-1", "WxRXFkILRApVEkIR");
            put("dim-2-1-17-2", "WxRXFkILRApVG14KXRJACw==");
            put("dim-2-1-18-1", "QAlPBlkQXhhX");
            put("dim-2-1-18-2", "QAlPBlkKSQhGGVUcTxs=");
            put("dim-2-1-18-3", "QAlPBlkUVRY=");
            put("dim-2-1-19-1", "VBFdEU4HSQ9A");
            put("dim-2-1-19-2", "VBFdEU4HSQ9AH1EUQw==");
            put("dim-2-1-21-1", "VgZWCUUMXws=");
            put("dim-2-1-21-2", "VgZWCUUMXws=");
            put("dim-2-1-21-3", "VgZWCUUMXws=");
            put("dim-2-1-21-5", "VgZWCUUMXws=");
            put("dim-2-1-22-1", "UBVBFF0CRgNVHF8aRQxI");
        }
    };
    public Method f;
    public Method g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/b/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f21941a = new e((byte) 0);
    }

    private e() {
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e a() {
        return a.f21941a;
    }

    private static Object a(String str, AppDataProvider appDataProvider, Class<?> cls, boolean z, Object obj) {
        try {
            String str2 = h.get(str);
            String str3 = str2 == null ? null : new String(com.getui.gtc.dim.e.a.a(Base64.decode(str2.getBytes(), 2)));
            if (str3 != null) {
                Object appData = appDataProvider.getAppData(str3);
                if (z) {
                    List list = (List) appData;
                    if (list != null && !list.isEmpty()) {
                        cls.cast(list.get(0));
                        if (list.size() > 1) {
                            cls.cast(list.get(list.size() - 1));
                        }
                    }
                    return appData;
                }
                return cls.cast(appData);
            }
            throw new IllegalStateException("decryptName==null");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b("dim call sys getProviderData failed for " + str + ",because " + th.getMessage());
            return obj;
        }
    }

    private Object d(String str) {
        try {
            String str2 = this.e;
            if (str2 != null && this.g != null) {
                this.g.invoke(null, str2);
                this.e = null;
            }
            if (this.f != null) {
                Bundle bundle = new Bundle();
                bundle.putString("dimKey", str);
                Object invoke = this.f.invoke(null, bundle);
                if (!"GDI_SYS_CALL_NONE".equals(invoke)) {
                    return invoke;
                }
            }
            return Void.TYPE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:146:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x09f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.getui.gtc.dim.b.c a(com.getui.gtc.dim.DimRequest r7) {
        /*
            Method dump skipped, instructions count: 4160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.b.e.a(com.getui.gtc.dim.DimRequest):com.getui.gtc.dim.b.c");
    }

    @Override // com.getui.gtc.dim.b.d
    public final /* bridge */ /* synthetic */ void a(AppDataProvider appDataProvider) {
        super.a(appDataProvider);
    }

    @Override // com.getui.gtc.dim.b.d
    public final /* bridge */ /* synthetic */ void a(String str, String str2, String str3) {
        super.a(str, str2, str3);
    }
}
