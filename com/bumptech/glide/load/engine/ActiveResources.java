package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ActiveResources.class */
final class ActiveResources {

    /* renamed from: a  reason: collision with root package name */
    final Map<Key, ResourceWeakReference> f7128a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f7129c;
    private final ReferenceQueue<EngineResource<?>> d;
    private EngineResource.ResourceListener e;
    private volatile boolean f;
    private volatile DequeuedResourceCallback g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ActiveResources$DequeuedResourceCallback.class */
    public interface DequeuedResourceCallback {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ActiveResources$ResourceWeakReference.class */
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* renamed from: a  reason: collision with root package name */
        final Key f7132a;
        final boolean b;

        /* renamed from: c  reason: collision with root package name */
        Resource<?> f7133c;

        ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f7132a = (Key) Preconditions.a(key);
            this.f7133c = (engineResource.e() && z) ? (Resource) Preconditions.a(engineResource.d()) : null;
            this.b = engineResource.e();
        }

        void a() {
            this.f7133c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bumptech.glide.load.engine.ActiveResources.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    ActiveResources(boolean z, Executor executor) {
        this.f7128a = new HashMap();
        this.d = new ReferenceQueue<>();
        this.b = z;
        this.f7129c = executor;
        executor.execute(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            @Override // java.lang.Runnable
            public void run() {
                ActiveResources.this.a();
            }
        });
    }

    void a() {
        while (!this.f) {
            try {
                a((ResourceWeakReference) this.d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Key key) {
        synchronized (this) {
            ResourceWeakReference remove = this.f7128a.remove(key);
            if (remove != null) {
                remove.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Key key, EngineResource<?> engineResource) {
        synchronized (this) {
            ResourceWeakReference put = this.f7128a.put(key, new ResourceWeakReference(key, engineResource, this.d, this.b));
            if (put != null) {
                put.a();
            }
        }
    }

    void a(ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.f7128a.remove(resourceWeakReference.f7132a);
            if (resourceWeakReference.b && resourceWeakReference.f7133c != null) {
                this.e.a(resourceWeakReference.f7132a, new EngineResource<>(resourceWeakReference.f7133c, true, false, resourceWeakReference.f7132a, this.e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.e = resourceListener;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource<?> b(Key key) {
        synchronized (this) {
            ResourceWeakReference resourceWeakReference = this.f7128a.get(key);
            if (resourceWeakReference == null) {
                return null;
            }
            EngineResource<?> engineResource = (EngineResource) resourceWeakReference.get();
            if (engineResource == null) {
                a(resourceWeakReference);
            }
            return engineResource;
        }
    }
}
