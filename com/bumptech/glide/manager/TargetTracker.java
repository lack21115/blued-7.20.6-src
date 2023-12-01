package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/TargetTracker.class */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Target<?>> f21026a = Collections.newSetFromMap(new WeakHashMap());

    public List<Target<?>> a() {
        return Util.a(this.f21026a);
    }

    public void a(Target<?> target) {
        this.f21026a.add(target);
    }

    public void b() {
        this.f21026a.clear();
    }

    public void b(Target<?> target) {
        this.f21026a.remove(target);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        for (Target target : Util.a(this.f21026a)) {
            target.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        for (Target target : Util.a(this.f21026a)) {
            target.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        for (Target target : Util.a(this.f21026a)) {
            target.onStop();
        }
    }
}
