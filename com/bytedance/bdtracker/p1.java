package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.profile.UserProfileCallback;
import java.util.HashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p1.class */
public class p1 implements Runnable {
    public static final Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final String f21285a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21286c;
    public final UserProfileCallback d;
    public final Context e;
    public final IAppLogInstance f;

    public p1(IAppLogInstance iAppLogInstance, String str, String str2, String str3, UserProfileCallback userProfileCallback, Context context) {
        this.f = iAppLogInstance;
        this.f21285a = str;
        this.b = str2;
        this.f21286c = str3;
        this.d = userProfileCallback;
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.d.onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i) {
        UserProfileCallback userProfileCallback = this.d;
        if (userProfileCallback != null) {
            userProfileCallback.onFail(i);
        }
    }

    public final void a() {
        g.post(new Runnable() { // from class: com.bytedance.bdtracker.-$$Lambda$p1$oC5kYI1XjmC2DgwI7W7otEhrMsk
            @Override // java.lang.Runnable
            public final void run() {
                p1.this.b();
            }
        });
    }

    public final void a(final int i) {
        g.post(new Runnable() { // from class: com.bytedance.bdtracker.-$$Lambda$p1$cONMbI108dOMwrHact3A4o_3uZM
            @Override // java.lang.Runnable
            public final void run() {
                p1.this.b(i);
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!s2.e(this.e)) {
                a(0);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("X-APIKEY", this.b);
            this.f.getNetClient().post(this.f21285a, this.f21286c.getBytes(), hashMap);
            a();
        } catch (Throwable th) {
            z2.a(th);
            a(1);
        }
    }
}
