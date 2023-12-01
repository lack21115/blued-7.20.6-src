package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import com.blued.android.sdk.a.b;
import com.blued.android.sdk.a.f;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKBaseAction.class */
public abstract class SDKBaseAction {
    private static long f = System.currentTimeMillis() / 1000;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29750c;
    protected String d;
    protected String e;
    private boolean g = false;
    private boolean h = false;

    /* renamed from: a  reason: collision with root package name */
    protected long f29749a = d();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKBaseAction$Result.class */
    public interface Result {
    }

    public SDKBaseAction(Intent intent) {
        this.b = intent.getAction();
        this.f29750c = intent.getStringExtra("app_key");
        this.d = intent.getStringExtra("secret_key");
        this.e = intent.getStringExtra("pkg_name");
        Logger.a("SDKAction", "action create, action:", this);
    }

    public static SDKBaseAction a(Intent intent) {
        String action = intent.getAction();
        if (b.f18652c.equals(action)) {
            return new SDKAuthAction(intent);
        }
        if (f.f18660c.equals(action)) {
            return new SDKPayAction(intent);
        }
        if ("com.blued.android.sdk.action.browser".equals(action)) {
            return new SDKBrowserAction(intent);
        }
        return null;
    }

    private static long d() {
        long j;
        synchronized (SDKBaseAction.class) {
            try {
                j = f;
                f = 1 + j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    private void e() {
        this.g = true;
        SDKActionManager.c(this.f29749a);
    }

    public long a() {
        return this.f29749a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Context context);

    public void b() {
        Logger.a("SDKAction", "action finish, action:", this);
        e();
    }

    protected abstract void b(Context context);

    public void c(Context context) {
        Logger.a("SDKAction", "action start, action:", this);
        if (this.g || this.h) {
            return;
        }
        this.h = true;
        a(context);
    }

    public boolean c() {
        return this.g;
    }

    public void d(Context context) {
        Logger.a("SDKAction", "action cancel, action:", this);
        if (!this.g) {
            b(context);
        }
        e();
    }

    public String toString() {
        return "[action:" + this.b + ", id:" + this.f29749a + ", appKey:" + this.f29750c + ", appPkgName:" + this.e + "]";
    }
}
