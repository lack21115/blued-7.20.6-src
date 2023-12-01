package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.igexin.assist.util.AssistUtils;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bn.class */
public class bn {

    /* renamed from: a  reason: collision with root package name */
    private static bn f41644a;

    /* renamed from: a  reason: collision with other field name */
    private int f1020a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f1021a;

    private bn(Context context) {
        this.f1021a = context.getApplicationContext();
    }

    public static bn a(Context context) {
        if (f41644a == null) {
            f41644a = new bn(context);
        }
        return f41644a;
    }

    public int a() {
        int i = this.f1020a;
        if (i != 0) {
            return i;
        }
        try {
            this.f1020a = Settings.Global.getInt(this.f1021a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception e) {
        }
        return this.f1020a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Uri m12159a() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12160a() {
        return com.xiaomi.push.aa.f169a.contains("xmsf") || com.xiaomi.push.aa.f169a.contains(AssistUtils.BRAND_XIAOMI) || com.xiaomi.push.aa.f169a.contains("miui");
    }
}
