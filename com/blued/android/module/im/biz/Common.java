package com.blued.android.module.im.biz;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.im.CommonOuterClass;
import java.util.TimeZone;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/Common.class */
public class Common {
    private CommonOuterClass.Common.Builder a;
    private CommonOuterClass.Common b;
    private String c;
    private String d;
    private TimeZone e;
    private String f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/Common$InstanceHolder.class */
    public static class InstanceHolder {
        private static final Common a = new Common();

        private InstanceHolder() {
        }
    }

    private Common() {
        this.a = CommonOuterClass.Common.newBuilder();
        this.b = null;
        this.c = "";
        this.d = "";
        this.e = TimeZone.getDefault();
        this.f = "";
        this.g = false;
        c();
    }

    public static Common a() {
        return InstanceHolder.a;
    }

    private void c() {
        if (TextUtils.isEmpty(this.c)) {
            String a = DeviceUtils.a();
            this.c = a;
            this.a.setDevice(e(a));
        }
        if (TextUtils.isEmpty(this.d)) {
            String str = Build.VERSION.RELEASE;
            this.d = str;
            this.a.setOsVersion(e(str));
        }
        if (TextUtils.isEmpty(this.f)) {
            try {
                this.f = this.e.getID() + "," + this.e.getDisplayName(false, 0);
            } catch (AssertionError | Exception e) {
            }
            this.a.setTimezone(e(this.f));
        }
    }

    private String e(String str) {
        this.g = true;
        return Utils.b(str);
    }

    public Common a(int i) {
        this.g = true;
        this.a.setAppVersionCode(i);
        return this;
    }

    public Common a(String str) {
        this.a.setChannel(e(str));
        return this;
    }

    public Common b(String str) {
        this.a.setPlatform(e(str));
        return this;
    }

    public CommonOuterClass.Common b() {
        if (this.b == null || this.g) {
            this.b = this.a.build();
            this.g = false;
        }
        return this.b;
    }

    public Common c(String str) {
        this.a.setAppVersion(e(str));
        return this;
    }

    public Common d(String str) {
        this.a.setLanguage(e(str));
        return this;
    }
}
