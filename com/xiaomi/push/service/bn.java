package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.igexin.assist.util.AssistUtils;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bn.class */
public class bn {

    /* renamed from: a  reason: collision with root package name */
    private static bn f27953a;

    /* renamed from: a  reason: collision with other field name */
    private int f973a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f974a;

    private bn(Context context) {
        this.f974a = context.getApplicationContext();
    }

    public static bn a(Context context) {
        if (f27953a == null) {
            f27953a = new bn(context);
        }
        return f27953a;
    }

    public int a() {
        int i = this.f973a;
        if (i != 0) {
            return i;
        }
        try {
            this.f973a = Settings.Global.getInt(this.f974a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception e) {
        }
        return this.f973a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Uri m9109a() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9110a() {
        return com.xiaomi.push.aa.f122a.contains("xmsf") || com.xiaomi.push.aa.f122a.contains(AssistUtils.BRAND_XIAOMI) || com.xiaomi.push.aa.f122a.contains("miui");
    }
}
