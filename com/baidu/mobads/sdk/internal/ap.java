package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ap.class */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6473a = w.p;
    private static final String b = "pauseDlByPk";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6474c = "resumeDownload";
    private static final String d = "getDownloadStatus";
    private static ap f;
    private aq e;

    private ap(Context context) {
        this.e = aq.a(context, f6473a);
    }

    public static ap a(Context context) {
        if (f == null) {
            synchronized (ap.class) {
                try {
                    if (f == null) {
                        f = new ap(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (br.a(context, str)) {
            return 103;
        }
        Object b2 = this.e.b(null, d, str);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return -1;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.a(null, b, str);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context == null || jSONObject == null) {
            return false;
        }
        Object b2 = this.e.b(null, f6474c, context, jSONObject, str, str2);
        if (b2 instanceof Boolean) {
            return ((Boolean) b2).booleanValue();
        }
        return false;
    }
}
