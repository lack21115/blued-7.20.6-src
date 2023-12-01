package a.a.a.a.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f1347a;
    public SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f1348c;
    public SharedPreferences d;
    public SharedPreferences.Editor e;
    public SharedPreferences f;
    public SharedPreferences.Editor g;
    public Context h;
    public boolean i;

    public static f a() {
        if (f1347a == null) {
            f1347a = new f();
        }
        return f1347a;
    }

    public long a(String str) {
        return this.f.getLong(str, System.currentTimeMillis());
    }

    public void a(Context context) {
        this.h = context;
        e();
        this.i = true;
    }

    public Map<String, ?> b() {
        return this.b.getAll();
    }

    public void b(String str) {
        if (this.i && c.a().b()) {
            this.e.putInt(str, this.d.getInt(str, 0) + 1);
            this.e.apply();
        }
    }

    public Map<String, ?> c() {
        return this.d.getAll();
    }

    public void d() {
        g();
        i();
        h();
    }

    public final void e() {
        SharedPreferences sharedPreferences = this.h.getSharedPreferences("StreamingReportData_Base", 0);
        this.b = sharedPreferences;
        this.f1348c = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = this.h.getSharedPreferences("StreamingReportData_Function", 0);
        this.d = sharedPreferences2;
        this.e = sharedPreferences2.edit();
        SharedPreferences sharedPreferences3 = this.h.getSharedPreferences("StreamingReportData_Extra", 0);
        this.f = sharedPreferences3;
        this.g = sharedPreferences3.edit();
        f();
    }

    public final void f() {
        if (!this.b.getString("os_platform", com.igexin.push.core.b.l).equals(com.igexin.push.core.b.l)) {
            h();
            return;
        }
        String string = Settings.System.getString(this.h.getContentResolver(), "android_id");
        String str = string;
        if (string == null) {
            str = UUID.randomUUID().toString().replaceAll("-", "");
        }
        this.f1348c.putString("os_platform", "android");
        this.f1348c.putString("bundle_id", this.h.getPackageName());
        this.f1348c.putString("app_name", h.a(this.h));
        this.f1348c.putString("device_id", str);
        this.f1348c.putString("device_model", h.a());
        this.f1348c.putString("os_version", Build.VERSION.RELEASE);
        this.f1348c.putString("sdk_version", "3.0.0");
        this.f1348c.apply();
        this.g.putLong("method_report_last_time_ms", System.currentTimeMillis());
        this.g.apply();
    }

    public final void g() {
        this.e.clear();
        this.e.apply();
    }

    public final void h() {
        this.f1348c.putString("os_version", Build.VERSION.RELEASE);
        this.f1348c.putString("sdk_version", "3.0.0");
        this.f1348c.apply();
    }

    public final void i() {
        this.g.putLong("method_report_last_time_ms", System.currentTimeMillis());
        this.g.apply();
    }
}
