package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dj.class */
public class dj implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f27647a;

    /* renamed from: a  reason: collision with other field name */
    private String f258a;
    private String b;

    public dj(Context context, String str) {
        this.f258a = "";
        this.f27647a = context;
        this.f258a = str;
    }

    private void a(String str) {
        ho hoVar = new ho();
        hoVar.a(str);
        hoVar.a(System.currentTimeMillis());
        hoVar.a(hi.ActivityActiveTimeStamp);
        dr.a(this.f27647a, hoVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (TextUtils.isEmpty(this.f258a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.b = "";
        if (!TextUtils.isEmpty("") && !TextUtils.equals(this.b, localClassName)) {
            this.f258a = "";
            return;
        }
        a(this.f27647a.getPackageName() + "|" + localClassName + ":" + this.f258a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f258a = "";
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f258a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
