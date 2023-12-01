package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/az.class */
public class az implements au {

    /* renamed from: a  reason: collision with root package name */
    private static final int f40645a = 1;
    private OpenDeviceId b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40646c = false;
    private boolean d = false;

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f40646c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.b = openDeviceId;
            this.d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.f40646c = true;
        }
        bg.a("getOAID", "isSupported", Boolean.valueOf(this.d));
        if (this.d && this.b.b()) {
            return this.b.a();
        }
        return null;
    }
}
