package com.blued.android.statistics.biz;

import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.das.CommonProtos;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Common.class */
public class Common {
    private final CommonProtos.Common.Builder a;
    private CommonProtos.Common b;
    private String c;
    private String d;
    private TimeZone e;
    private String f;
    private Locale g;
    private String h;
    private String i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Common$InstanceHolder.class */
    public static class InstanceHolder {
        private static final Common a = new Common();

        private InstanceHolder() {
        }
    }

    private Common() {
        this.a = CommonProtos.Common.newBuilder();
        this.b = null;
        this.c = "";
        this.d = "";
        this.e = TimeZone.getDefault();
        this.f = "";
        this.g = Locale.getDefault();
        this.h = "";
        this.i = "";
        this.j = false;
        c();
    }

    public static Common a() {
        return InstanceHolder.a;
    }

    private void c() {
        String str;
        Locale locale = Locale.getDefault();
        TimeZone timeZone = TimeZone.getDefault();
        try {
            str = timeZone.getID() + "," + timeZone.getDisplayName(false, 0);
        } catch (AssertionError | Exception e) {
            str = null;
        }
        this.a.setDevice(n(DeviceUtils.a())).setOsVersion(n(Build.VERSION.RELEASE)).setTimezone(n(str)).setLanguage(n(locale.getLanguage())).setRegion(n(locale.getCountry())).setSdkVersionCode(108000);
    }

    private String n(String str) {
        this.j = true;
        return Utils.b(str);
    }

    public Common a(int i) {
        this.j = true;
        this.a.setAppVersionCode(i);
        return this;
    }

    public Common a(Point point) {
        this.j = true;
        this.a.setScreenWidth(point == null ? 0 : point.x);
        this.a.setScreenHigh(point == null ? 0 : point.y);
        return this;
    }

    public Common a(String str) {
        this.a.setNetOp(n(str));
        return this;
    }

    public Common b(String str) {
        this.a.setNet(n(str));
        return this;
    }

    public CommonProtos.Common b() {
        if (this.b == null || this.j) {
            this.b = this.a.build();
            this.j = false;
        }
        return this.b;
    }

    public Common c(String str) {
        this.a.setLat(n(str));
        return this;
    }

    public Common d(String str) {
        this.a.setLon(n(str));
        return this;
    }

    public Common e(String str) {
        this.a.setChannel(n(str));
        return this;
    }

    public Common f(String str) {
        this.j = true;
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            this.a.setUid(0L);
            return this;
        }
        this.a.setUid(Long.parseLong(str));
        return this;
    }

    public Common g(String str) {
        this.a.setPlatform(n(str));
        return this;
    }

    public Common h(String str) {
        this.a.setAppVersion(n(str));
        return this;
    }

    public Common i(String str) {
        this.a.setImei(n(str));
        return this;
    }

    public Common j(String str) {
        this.a.setBoxId(n(str));
        return this;
    }

    public Common k(String str) {
        this.a.setDevDna(n(str));
        return this;
    }

    public Common l(String str) {
        this.a.setVipType(n(str));
        return this;
    }

    public Common m(String str) {
        this.a.setOaid(n(str));
        return this;
    }
}
