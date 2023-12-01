package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Objects;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e2.class */
public class e2 extends u1 {
    public static e2 f;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f21212c;
    public SharedPreferences d;
    public boolean e;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e2$a.class */
    public interface a {
        String a();
    }

    public e2(Context context, String str, String str2) {
        this.e = false;
        this.f21212c = a(context, str, 0);
        this.d = a(context, str2, 0);
    }

    public e2(Context context, String str, boolean z) {
        this.e = false;
        this.f21212c = a((Context) Objects.requireNonNull(context), str, 0);
        this.e = z;
    }

    public static SharedPreferences a(Context context, String str, int i) {
        Context context2 = context;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                try {
                    boolean moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str);
                    context = createDeviceProtectedStorageContext;
                    if (!moveSharedPreferencesFrom) {
                        z2.b("Failed to migrate shared preferences.", (Throwable) null);
                        context = createDeviceProtectedStorageContext;
                    }
                } catch (Throwable th) {
                    context = createDeviceProtectedStorageContext;
                    th = th;
                    z2.a(th);
                    context2 = context;
                    return context2.getSharedPreferences(str, i);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            context2 = context;
        }
        return context2.getSharedPreferences(str, i);
    }

    public static e2 a(Context context) {
        e2 e2Var;
        synchronized (e2.class) {
            try {
                if (f == null) {
                    f = new e2(context, "_global_cache", true);
                }
                e2Var = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return e2Var;
    }

    public String a(String str, a aVar) {
        synchronized (this) {
            if (d(str).contains(str)) {
                return e(str);
            }
            String str2 = null;
            if (aVar != null) {
                str2 = aVar.a();
            }
            h(str, str2);
            return str2;
        }
    }

    @Override // com.bytedance.bdtracker.u1
    public void a(String str) {
        SharedPreferences d = d(str);
        if (d != null && d.contains(str)) {
            d(str).edit().remove(str).apply();
        }
        super.a(str);
    }

    @Override // com.bytedance.bdtracker.u1
    public void a(String str, String str2) {
        h(str, str2);
    }

    @Override // com.bytedance.bdtracker.u1
    public void a(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        h(str, TextUtils.join("\n", strArr));
    }

    @Override // com.bytedance.bdtracker.u1
    public String b(String str) {
        return d(str).getString(str, null);
    }

    @Override // com.bytedance.bdtracker.u1
    public String[] c(String str) {
        String string = d(str).getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split("\n");
    }

    public SharedPreferences d(String str) {
        SharedPreferences sharedPreferences;
        return (!"device_id".equals(str) || (sharedPreferences = this.d) == null) ? this.f21212c : sharedPreferences;
    }

    public String e(String str) {
        return d(str).getString(str, null);
    }

    public void h(String str, String str2) {
        if (this.e || !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = d(str).edit();
            String str3 = str2;
            if (this.e) {
                str3 = str2;
                if (str2 == null) {
                    str3 = "";
                }
            }
            edit.putString(str, str3);
            edit.apply();
        }
    }
}
