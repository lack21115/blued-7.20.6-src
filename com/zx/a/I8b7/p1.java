package com.zx.a.I8b7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.zx.a.I8b7.c3;
import com.zx.a.I8b7.r;
import com.zx.sdk.api.Callback;
import com.zx.sdk.api.PermissionCallback;
import com.zx.sdk.api.SAIDCallback;
import com.zx.sdk.api.ZXApi;
import com.zx.sdk.api.ZXIDChangedListener;
import com.zx.sdk.api.ZXIDListener;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/p1.class */
public class p1 implements ZXApi {

    /* renamed from: a  reason: collision with root package name */
    public String f42163a;

    public p1(String str) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("ZX_APPID not found");
        }
        this.f42163a = str;
    }

    @Override // com.zx.sdk.api.ZXApi
    public void addZXIDChangedListener(ZXIDChangedListener zXIDChangedListener) {
        try {
            r.b.f42190a.a(this.f42163a, "addZXIDChangedListener", "");
            e2 b = e2.b();
            String str = this.f42163a;
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new l2(b, str, zXIDChangedListener));
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.registerListener(listener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void allowPermissionDialog(boolean z) {
        try {
            r rVar = r.b.f42190a;
            String str = this.f42163a;
            rVar.a(str, "allowPermissionDialog", "enable=" + z);
            e2 b = e2.b();
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new j2(b, z));
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.allowPermissionDialog failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void checkPermission(Activity activity, PermissionCallback permissionCallback) {
        try {
            r.b.f42190a.a(this.f42163a, "checkPermission", "");
            if (permissionCallback == null) {
                return;
            }
            e2 b = e2.b();
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new d2(b, permissionCallback, activity));
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getAuthToken(Callback callback) {
        try {
            r.b.f42190a.a(this.f42163a, "getAuthToken", "");
            if (callback == null) {
                return;
            }
            e2 b = e2.b();
            String str = this.f42163a;
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new h2(b, str, callback));
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getSAID(String str, String str2, String str3, String str4, String str5, SAIDCallback sAIDCallback) {
        try {
            r.b.f42190a.a(this.f42163a, "getUAID", "");
            if (sAIDCallback != null) {
                e2 b = e2.b();
                String str6 = this.f42163a;
                b.getClass();
                AtomicInteger atomicInteger = c3.f42112c;
                c3.c.f42114a.b.execute(new f2(b, str6, str, str2, str3, str4, str5, sAIDCallback));
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager getSAID onFailed:"));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getTag(Callback callback) {
        try {
            r.b.f42190a.a(this.f42163a, "getTag", "");
            if (callback == null) {
                return;
            }
            e2 b = e2.b();
            String str = this.f42163a;
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new g2(b, str, callback));
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public String getVersion() {
        r.b.f42190a.a(this.f42163a, "getVersion", "");
        return "3.2.0.16894";
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getZXID(ZXIDListener zXIDListener) {
        try {
            r.b.f42190a.a(this.f42163a, "getZXID", "");
            if (zXIDListener != null) {
                e2 b = e2.b();
                String str = this.f42163a;
                b.getClass();
                AtomicInteger atomicInteger = c3.f42112c;
                c3.c.f42114a.b.execute(new a2(b, str, zXIDListener));
            }
        } catch (Throwable th) {
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            n2.a(th, m2.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void init(Context context) {
        try {
            r.b.f42190a.a(this.f42163a, "init", "");
            e2.a(context);
        } catch (Throwable th) {
            m.b("ZXManager.init failed:" + th);
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public String invoke(String str, String str2) {
        try {
            r rVar = r.b.f42190a;
            String str3 = this.f42163a;
            rVar.a(str3, Launcher.Method.INVOKE_CALLBACK, "method=" + str + "&argument" + str2);
            return e2.b().a(str, str2);
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.invoke failed: "));
            return null;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isAllowPermissionDialog() {
        boolean z = false;
        try {
            r.b.f42190a.a(this.f42163a, "isAllowPermissionDialog", "");
            e2.b().getClass();
            if (t2.p == 1) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.isAllowPermissionDialog failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isEnable() {
        boolean z = false;
        try {
            r.b.f42190a.a(this.f42163a, "isEnable", "");
            e2.b().getClass();
            if (t2.o == 1) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.isEnable failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setDebug(boolean z) {
        try {
            r rVar = r.b.f42190a;
            String str = this.f42163a;
            rVar.a(str, "setDebug", "isDebug=" + z);
            e2 b = e2.b();
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new k2(b, z));
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setEnable(boolean z) {
        try {
            r rVar = r.b.f42190a;
            String str = this.f42163a;
            rVar.a(str, "setEnable", "enable=" + z);
            e2 b = e2.b();
            b.getClass();
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new i2(b, z));
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.setEnable failed: "));
        }
    }
}
