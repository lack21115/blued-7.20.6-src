package com.bumptech.glide.manager;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/ApplicationLifecycle.class */
class ApplicationLifecycle implements Lifecycle {
    @Override // com.bumptech.glide.manager.Lifecycle
    public void a(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void b(LifecycleListener lifecycleListener) {
    }
}
