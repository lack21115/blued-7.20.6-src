package com.blued.android.module.im.biz;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.im.CommonOuterClass;
import java.util.TimeZone;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/Common.class */
public class Common {

    /* renamed from: a  reason: collision with root package name */
    private CommonOuterClass.Common.Builder f11335a;
    private CommonOuterClass.Common b;

    /* renamed from: c  reason: collision with root package name */
    private String f11336c;
    private String d;
    private TimeZone e;
    private String f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/Common$InstanceHolder.class */
    public static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Common f11337a = new Common();

        private InstanceHolder() {
        }
    }

    private Common() {
        this.f11335a = CommonOuterClass.Common.newBuilder();
        this.b = null;
        this.f11336c = "";
        this.d = "";
        this.e = TimeZone.getDefault();
        this.f = "";
        this.g = false;
        c();
    }

    public static Common a() {
        return InstanceHolder.f11337a;
    }

    private void c() {
        if (TextUtils.isEmpty(this.f11336c)) {
            String a2 = DeviceUtils.a();
            this.f11336c = a2;
            this.f11335a.setDevice(e(a2));
        }
        if (TextUtils.isEmpty(this.d)) {
            String str = Build.VERSION.RELEASE;
            this.d = str;
            this.f11335a.setOsVersion(e(str));
        }
        if (TextUtils.isEmpty(this.f)) {
            try {
                this.f = this.e.getID() + "," + this.e.getDisplayName(false, 0);
            } catch (AssertionError | Exception e) {
            }
            this.f11335a.setTimezone(e(this.f));
        }
    }

    private String e(String str) {
        this.g = true;
        return Utils.b(str);
    }

    public Common a(int i) {
        this.g = true;
        this.f11335a.setAppVersionCode(i);
        return this;
    }

    public Common a(String str) {
        this.f11335a.setChannel(e(str));
        return this;
    }

    public Common b(String str) {
        this.f11335a.setPlatform(e(str));
        return this;
    }

    public CommonOuterClass.Common b() {
        if (this.b == null || this.g) {
            this.b = this.f11335a.build();
            this.g = false;
        }
        return this.b;
    }

    public Common c(String str) {
        this.f11335a.setAppVersion(e(str));
        return this;
    }

    public Common d(String str) {
        this.f11335a.setLanguage(e(str));
        return this;
    }
}
