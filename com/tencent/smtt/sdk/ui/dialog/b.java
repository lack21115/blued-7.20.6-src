package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ui/dialog/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f25202a;
    private ResolveInfo b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f25203c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private String i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r4, int r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            r0 = r3
            r0.<init>()
            r0 = r3
            java.lang.String r1 = ""
            r0.d = r1
            r0 = r3
            java.lang.String r1 = ""
            r0.e = r1
            r0 = r3
            r1 = 0
            r0.g = r1
            r0 = r3
            r1 = 0
            r0.h = r1
            r0 = r3
            java.lang.String r1 = ""
            r0.i = r1
            r0 = r5
            r1 = -1
            if (r0 == r1) goto L32
            r0 = r4
            android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Exception -> L6e
            r1 = r5
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch: java.lang.Exception -> L6e
            r8 = r0
            goto L35
        L32:
            r0 = 0
            r8 = r0
        L35:
            r0 = r8
            r9 = r0
            r0 = r8
            if (r0 != 0) goto L45
            java.lang.String r0 = "application_icon"
            android.graphics.drawable.Drawable r0 = com.tencent.smtt.sdk.ui.dialog.e.a(r0)
            r9 = r0
        L45:
            r0 = r3
            r1 = r4
            android.content.Context r1 = r1.getApplicationContext()
            r0.f25202a = r1
            r0 = r3
            r1 = 0
            r0.b = r1
            r0 = r3
            r1 = 0
            r0.f = r1
            r0 = r3
            r1 = r9
            r0.f25203c = r1
            r0 = r3
            r1 = r7
            r0.d = r1
            r0 = r3
            r1 = 1
            r0.g = r1
            r0 = r3
            r1 = r6
            r0.i = r1
            return
        L6e:
            r8 = move-exception
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ui.dialog.b.<init>(android.content.Context, int, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, ResolveInfo resolveInfo) {
        this.d = "";
        this.e = "";
        this.g = false;
        this.h = false;
        this.i = "";
        this.f25202a = context.getApplicationContext();
        this.b = resolveInfo;
        this.f25203c = null;
        this.d = null;
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Drawable drawable, String str, String str2, String str3) {
        this.d = "";
        this.e = "";
        this.g = false;
        this.h = false;
        this.i = "";
        this.f25202a = context.getApplicationContext();
        this.b = null;
        this.f25203c = drawable;
        this.d = str;
        this.f = str2;
        this.h = true;
        this.e = str3;
    }

    public static Drawable a(Context context, String str) {
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                return e.a("application_icon");
            } catch (Throwable th) {
                Log.e("error", "getApkIcon Error:" + Log.getStackTraceString(th));
                return null;
            }
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            TypedValue typedValue = new TypedValue();
            resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
            try {
                return Drawable.createFromResourceStream(resourcesForApplication, typedValue, new BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e2) {
            Log.e("sdk", "e = " + e2);
            return null;
        }
    }

    public Drawable a() {
        Drawable drawable = this.f25203c;
        if (drawable != null) {
            return drawable;
        }
        Drawable a2 = a(this.f25202a, d());
        Drawable drawable2 = a2;
        if (a2 == null) {
            ResolveInfo resolveInfo = this.b;
            if (resolveInfo != null) {
                return resolveInfo.loadIcon(this.f25202a.getPackageManager());
            }
            drawable2 = this.f25203c;
        }
        return drawable2;
    }

    public void a(ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    public void a(Drawable drawable) {
        this.f25203c = drawable;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public String b() {
        ResolveInfo resolveInfo = this.b;
        return resolveInfo != null ? resolveInfo.loadLabel(this.f25202a.getPackageManager()).toString() : this.d;
    }

    public ResolveInfo c() {
        return this.b;
    }

    public String d() {
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        String str = this.f;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public boolean e() {
        return this.g;
    }

    public boolean f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public String h() {
        return this.e;
    }
}
