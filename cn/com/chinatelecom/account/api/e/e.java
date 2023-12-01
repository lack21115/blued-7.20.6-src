package cn.com.chinatelecom.account.api.e;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.ClientUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.umeng.analytics.pro.bh;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/e/e.class */
public class e {
    private String l;
    private int o;
    private long q;
    private int t;
    private long w;
    private long r = -1;
    private StringBuffer u = new StringBuffer();

    /* renamed from: c  reason: collision with root package name */
    private String f4142c = "";
    private String e = "";
    private String n = "";
    private String m = "";
    private String p = "";

    /* renamed from: a  reason: collision with root package name */
    private String f4141a = "1.2";
    private long v = SystemClock.uptimeMillis();
    private String b = a(System.currentTimeMillis());
    private String d = CtAuth.mAppId;
    private String f = "";
    private String g = Build.BRAND;
    private String h = Build.MODEL;
    private String i = "Android";
    private String j = Build.VERSION.RELEASE;
    private String k = ClientUtils.getSdkVersion();
    private String s = "0";

    public e(String str) {
        this.l = str;
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public e a(int i) {
        this.o = i;
        return this;
    }

    public e a(String str) {
        this.e = str;
        return this;
    }

    public String a() {
        return this.l;
    }

    public e b(int i) {
        this.t = i;
        return this;
    }

    public e b(long j) {
        if (j > 0) {
            this.q = j;
        }
        return this;
    }

    public e b(String str) {
        this.f = str;
        return this;
    }

    public void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.w = uptimeMillis;
        if (this.r == -1) {
            this.r = uptimeMillis - this.v;
        }
    }

    public e c(String str) {
        this.m = str;
        return this;
    }

    public e d(String str) {
        this.n = str;
        return this;
    }

    public e e(String str) {
        this.p = str;
        return this;
    }

    public e f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.s = str;
        }
        return this;
    }

    public e g(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.u;
            stringBuffer.append(str);
            stringBuffer.append(";");
        }
        return this;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f4141a);
            jSONObject.put("t", this.b);
            jSONObject.put("tag", this.f4142c);
            jSONObject.put(com.anythink.expressad.d.a.b.cZ, this.d);
            jSONObject.put(AppIconSetting.DEFAULT_LARGE_ICON, this.e);
            jSONObject.put("ns", this.f);
            jSONObject.put("br", this.g);
            jSONObject.put("ml", this.h);
            jSONObject.put(bh.x, this.i);
            jSONObject.put(com.anythink.expressad.foundation.g.a.F, this.j);
            jSONObject.put("sv", this.k);
            jSONObject.put("ri", this.l);
            jSONObject.put("api", this.m);
            jSONObject.put("p", this.n);
            jSONObject.put("rt", this.o);
            jSONObject.put("msg", this.p);
            jSONObject.put("st", this.q);
            jSONObject.put("tt", this.r);
            jSONObject.put(com.anythink.expressad.foundation.g.a.J, this.s);
            jSONObject.put("rec", this.t);
            jSONObject.put("ep", this.u.toString());
            return jSONObject.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
