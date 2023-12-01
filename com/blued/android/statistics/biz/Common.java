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

    /* renamed from: a  reason: collision with root package name */
    private final CommonProtos.Common.Builder f18684a;
    private CommonProtos.Common b;

    /* renamed from: c  reason: collision with root package name */
    private String f18685c;
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

        /* renamed from: a  reason: collision with root package name */
        private static final Common f18686a = new Common();

        private InstanceHolder() {
        }
    }

    private Common() {
        this.f18684a = CommonProtos.Common.newBuilder();
        this.b = null;
        this.f18685c = "";
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
        return InstanceHolder.f18686a;
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
        this.f18684a.setDevice(n(DeviceUtils.a())).setOsVersion(n(Build.VERSION.RELEASE)).setTimezone(n(str)).setLanguage(n(locale.getLanguage())).setRegion(n(locale.getCountry())).setSdkVersionCode(108000);
    }

    private String n(String str) {
        this.j = true;
        return Utils.b(str);
    }

    public Common a(int i) {
        this.j = true;
        this.f18684a.setAppVersionCode(i);
        return this;
    }

    public Common a(Point point) {
        this.j = true;
        this.f18684a.setScreenWidth(point == null ? 0 : point.x);
        this.f18684a.setScreenHigh(point == null ? 0 : point.y);
        return this;
    }

    public Common a(String str) {
        this.f18684a.setNetOp(n(str));
        return this;
    }

    public Common b(String str) {
        this.f18684a.setNet(n(str));
        return this;
    }

    public CommonProtos.Common b() {
        if (this.b == null || this.j) {
            this.b = this.f18684a.build();
            this.j = false;
        }
        return this.b;
    }

    public Common c(String str) {
        this.f18684a.setLat(n(str));
        return this;
    }

    public Common d(String str) {
        this.f18684a.setLon(n(str));
        return this;
    }

    public Common e(String str) {
        this.f18684a.setChannel(n(str));
        return this;
    }

    public Common f(String str) {
        this.j = true;
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            this.f18684a.setUid(0L);
            return this;
        }
        this.f18684a.setUid(Long.parseLong(str));
        return this;
    }

    public Common g(String str) {
        this.f18684a.setPlatform(n(str));
        return this;
    }

    public Common h(String str) {
        this.f18684a.setAppVersion(n(str));
        return this;
    }

    public Common i(String str) {
        this.f18684a.setImei(n(str));
        return this;
    }

    public Common j(String str) {
        this.f18684a.setBoxId(n(str));
        return this;
    }

    public Common k(String str) {
        this.f18684a.setDevDna(n(str));
        return this;
    }

    public Common l(String str) {
        this.f18684a.setVipType(n(str));
        return this;
    }

    public Common m(String str) {
        this.f18684a.setOaid(n(str));
        return this;
    }
}
