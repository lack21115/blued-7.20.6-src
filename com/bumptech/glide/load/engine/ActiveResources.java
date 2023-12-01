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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ActiveResources.class */
public final class ActiveResources {

    /* renamed from: a  reason: collision with root package name */
    final Map<Key, ResourceWeakReference> f20734a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f20735c;
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
        final Key f20738a;
        final boolean b;

        /* renamed from: c  reason: collision with root package name */
        Resource<?> f20739c;

        ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f20738a = (Key) Preconditions.a(key);
            this.f20739c = (engineResource.e() && z) ? (Resource) Preconditions.a(engineResource.d()) : null;
            this.b = engineResource.e();
        }

        void a() {
            this.f20739c = null;
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
        this.f20734a = new HashMap();
        this.d = new ReferenceQueue<>();
        this.b = z;
        this.f20735c = executor;
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
            ResourceWeakReference remove = this.f20734a.remove(key);
            if (remove != null) {
                remove.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Key key, EngineResource<?> engineResource) {
        synchronized (this) {
            ResourceWeakReference put = this.f20734a.put(key, new ResourceWeakReference(key, engineResource, this.d, this.b));
            if (put != null) {
                put.a();
            }
        }
    }

    void a(ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.f20734a.remove(resourceWeakReference.f20738a);
            if (resourceWeakReference.b && resourceWeakReference.f20739c != null) {
                this.e.a(resourceWeakReference.f20738a, new EngineResource<>(resourceWeakReference.f20739c, true, false, resourceWeakReference.f20738a, this.e));
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
            ResourceWeakReference resourceWeakReference = this.f20734a.get(key);
            if (resourceWeakReference == null) {
                return null;
            }
            EngineResource<?> engineResource = resourceWeakReference.get();
            if (engineResource == null) {
                a(resourceWeakReference);
            }
            return engineResource;
        }
    }
}
