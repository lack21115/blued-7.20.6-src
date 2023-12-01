package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/he.class */
public class he {

    /* renamed from: a  reason: collision with root package name */
    private static volatile he f41468a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f543a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, hf> f544a = new HashMap();

    private he(Context context) {
        this.f543a = context;
    }

    public static he a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f41468a == null) {
            synchronized (he.class) {
                try {
                    if (f41468a == null) {
                        f41468a = new he(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41468a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hk hkVar = new hk();
        hkVar.d(str3);
        hkVar.c(str4);
        hkVar.a(j);
        hkVar.b(str5);
        hkVar.a(true);
        hkVar.a("push_sdk_channel");
        hkVar.e(str2);
        return a(hkVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hf a() {
        hf hfVar = this.f544a.get("UPLOADER_PUSH_CHANNEL");
        if (hfVar != null) {
            return hfVar;
        }
        hf hfVar2 = this.f544a.get("UPLOADER_HTTP");
        if (hfVar2 != null) {
            return hfVar2;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    Map<String, hf> m11845a() {
        return this.f544a;
    }

    public void a(hf hfVar, String str) {
        if (hfVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m11845a().put(str, hfVar);
        }
    }

    public boolean a(hk hkVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.bz.a(hkVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hkVar.d())) {
                hkVar.f(com.xiaomi.push.service.bz.a());
            }
            hkVar.g(str);
            com.xiaomi.push.service.ca.a(this.f543a, hkVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f543a.getPackageName(), this.f543a.getPackageName(), str, str2, j, str3);
    }
}
