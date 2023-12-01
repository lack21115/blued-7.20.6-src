package c.t.m.g;

import android.text.TextUtils;
import com.anythink.pd.ExHandler;
import com.tencent.qimei.upload.BuildConfig;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u3.class */
public class u3 {

    /* renamed from: a  reason: collision with root package name */
    public int f3958a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3959c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public String i = "";
    public volatile long j = 0;
    public volatile long k = 0;
    public volatile long l = 0;
    public volatile long m = 0;
    public String n;

    public String a() {
        if (TextUtils.isEmpty(this.n)) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(c4.f3727a)) {
                sb.append(t0.b());
            } else {
                sb.append(c4.f3727a);
                sb.append("_");
                sb.append(t0.b());
            }
            this.n = g6.a(sb.toString());
        }
        return this.n;
    }

    public void a(int i) {
        this.f3958a = i;
    }

    public void a(long j) {
        this.l = j;
    }

    public void a(long j, boolean z) {
        this.h = Math.max(n0.b().d("min_wifi_scan_interval"), j);
        if (z) {
            this.h = 5000L;
        }
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(boolean z) {
    }

    public String b() {
        return q3.a();
    }

    public void b(int i) {
    }

    public void b(long j) {
        this.k = j;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
    }

    public String c() {
        return this.g;
    }

    public void c(long j) {
        this.m = j;
    }

    public void c(String str) {
    }

    public void c(boolean z) {
    }

    public String d() {
        return "0123456789ABCDEF";
    }

    public void d(long j) {
        this.j = j;
    }

    public void d(String str) {
        this.e = str;
    }

    public String e() {
        return this.b;
    }

    public void e(String str) {
        this.i = str;
    }

    public String f() {
        HashMap hashMap = new HashMap();
        hashMap.put(ExHandler.JSON_REQUEST_IMEI, "");
        hashMap.put("imsi", "");
        hashMap.put("qq", n());
        hashMap.put("mac", "");
        hashMap.put(BuildConfig.SDK_ID, c4.f3727a);
        hashMap.put("q16", c4.b);
        hashMap.put("q36", c4.f3728c);
        hashMap.put(com.anythink.expressad.foundation.g.a.bj, com.huawei.openalliance.ad.constant.t.aE + l());
        hashMap.put("idfv", TextUtils.isEmpty(l()) ? b() : "");
        return new JSONObject(hashMap).toString();
    }

    public void f(String str) {
    }

    public long g() {
        return this.l;
    }

    public void g(String str) {
        this.f3959c = str;
    }

    public long h() {
        return this.k;
    }

    public void h(String str) {
        this.d = str;
    }

    public String i() {
        return b6.a(this.e);
    }

    public void i(String str) {
    }

    public String j() {
        return this.i;
    }

    public void j(String str) {
        this.f = str;
    }

    public long k() {
        return this.m;
    }

    public String l() {
        return t0.b();
    }

    public int m() {
        return this.f3958a;
    }

    public String n() {
        String a2 = d6.a("LocationSDK", "location_device_id", "");
        String str = a2;
        if (!TextUtils.isEmpty(this.f3959c)) {
            if ("0123456789ABCDEF".equals(this.f3959c)) {
                return a2;
            }
            str = this.f3959c;
        }
        return str;
    }

    public String o() {
        return b6.a(this.d);
    }

    public long p() {
        return this.j;
    }

    public String q() {
        return this.f;
    }

    public long r() {
        return this.h;
    }
}
