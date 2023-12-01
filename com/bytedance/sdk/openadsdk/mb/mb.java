package com.bytedance.sdk.openadsdk.mb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/mb/mb.class */
class mb implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean mb = false;
    private InterfaceC0326mb b;
    private int ox = 0;

    /* renamed from: com.bytedance.sdk.openadsdk.mb.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/mb/mb$mb.class */
    public interface InterfaceC0326mb {
        void mb();

        void ox();
    }

    public Boolean mb() {
        return Boolean.valueOf(mb);
    }

    public void mb(InterfaceC0326mb interfaceC0326mb) {
        this.b = interfaceC0326mb;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.ox++;
        mb = false;
        InterfaceC0326mb interfaceC0326mb = this.b;
        if (interfaceC0326mb != null) {
            interfaceC0326mb.ox();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.ox - 1;
        this.ox = i;
        if (i == 0) {
            mb = true;
            InterfaceC0326mb interfaceC0326mb = this.b;
            if (interfaceC0326mb != null) {
                interfaceC0326mb.mb();
            }
        }
    }
}
