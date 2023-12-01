package com.oplus.log.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.oplus.log.b.a.c;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public List<c> f10627a;
    public Application.ActivityLifecycleCallbacks b = new Application.ActivityLifecycleCallbacks() { // from class: com.oplus.log.b.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            if (a.this.f10627a == null || a.this.f10627a.size() <= 0) {
                return;
            }
            for (c cVar : a.this.f10627a) {
                cVar.a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            if (a.this.f10627a == null || a.this.f10627a.size() <= 0) {
                return;
            }
            for (c cVar : a.this.f10627a) {
                cVar.b(activity);
            }
        }
    };
}
