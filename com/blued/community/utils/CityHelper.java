package com.blued.community.utils;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import java.util.Locale;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/CityHelper.class */
public class CityHelper {

    /* renamed from: a  reason: collision with root package name */
    private static CityHelper f20457a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f20458c;
    private String d;
    private String e;

    private CityHelper() {
    }

    public static CityHelper a() {
        if (f20457a == null) {
            synchronized (CityHelper.class) {
                try {
                    if (f20457a == null) {
                        f20457a = new CityHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20457a;
    }

    public String a(Context context) {
        return context.getString(R.string.city_feed);
    }

    public String a(Context context, String str) {
        if (b()) {
            return this.f20458c;
        }
        String cityTxt = AreaUtils.getCityTxt(str, new Locale(a.V, "CN"));
        this.b = cityTxt;
        if (TextUtils.isEmpty(cityTxt)) {
            return a(context);
        }
        String str2 = this.b;
        if (str2 != null && str2.indexOf("(") > 0) {
            String str3 = this.b;
            this.b = str3.substring(0, str3.indexOf("("));
        }
        String str4 = this.b;
        if (str4 != null && str4.indexOf("（") > 0) {
            String str5 = this.b;
            this.b = str5.substring(0, str5.indexOf("（"));
        }
        return this.b;
    }

    public void a(String str) {
        this.d = str;
    }

    public String b(Context context) {
        return context.getString(R.string.event_post_city);
    }

    public void b(String str) {
        this.e = str;
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f20458c) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) ? false : true;
    }

    public String c() {
        return b() ? this.d : CommunityServiceManager.c().e();
    }

    public String c(Context context) {
        if (b()) {
            return this.f20458c;
        }
        if (TextUtils.isEmpty(this.b)) {
            if (context != null) {
                return b(context);
            }
            return null;
        }
        return this.b;
    }

    public void c(String str) {
        this.f20458c = str;
    }

    public String d() {
        return (!b() || TextUtils.equals(this.f20458c, this.b)) ? "" : this.d;
    }

    public String d(Context context) {
        return !TextUtils.isEmpty(this.b) ? this.b : b(context);
    }

    public String e() {
        return b() ? this.e : CommunityServiceManager.c().f();
    }

    public String f() {
        return (!b() || TextUtils.equals(this.f20458c, this.b)) ? "" : this.e;
    }

    public String g() {
        return this.f20458c;
    }

    public String h() {
        return CommunityServiceManager.c().e();
    }

    public String i() {
        return CommunityServiceManager.c().f();
    }
}
