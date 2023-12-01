package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/ActivityFragmentLifecycle.class */
class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a  reason: collision with root package name */
    private final Set<LifecycleListener> f7405a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7406c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b = true;
        for (LifecycleListener lifecycleListener : Util.a(this.f7405a)) {
            lifecycleListener.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void a(LifecycleListener lifecycleListener) {
        this.f7405a.add(lifecycleListener);
        if (this.f7406c) {
            lifecycleListener.onDestroy();
        } else if (this.b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.b = false;
        for (LifecycleListener lifecycleListener : Util.a(this.f7405a)) {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void b(LifecycleListener lifecycleListener) {
        this.f7405a.remove(lifecycleListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f7406c = true;
        for (LifecycleListener lifecycleListener : Util.a(this.f7405a)) {
            lifecycleListener.onDestroy();
        }
    }
}
