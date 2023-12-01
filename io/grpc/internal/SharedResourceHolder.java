package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/SharedResourceHolder.class */
public final class SharedResourceHolder {
    static final long DESTROY_DELAY_SECONDS = 1;
    private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory() { // from class: io.grpc.internal.SharedResourceHolder.1
        @Override // io.grpc.internal.SharedResourceHolder.ScheduledExecutorFactory
        public ScheduledExecutorService createScheduledExecutor() {
            return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
        }
    });
    private ScheduledExecutorService destroyer;
    private final ScheduledExecutorFactory destroyerFactory;
    private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/SharedResourceHolder$Instance.class */
    public static class Instance {
        ScheduledFuture<?> destroyTask;
        final Object payload;
        int refcount;

        Instance(Object obj) {
            this.payload = obj;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/SharedResourceHolder$Resource.class */
    public interface Resource<T> {
        void close(T t);

        T create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/SharedResourceHolder$ScheduledExecutorFactory.class */
    public interface ScheduledExecutorFactory {
        ScheduledExecutorService createScheduledExecutor();
    }

    SharedResourceHolder(ScheduledExecutorFactory scheduledExecutorFactory) {
        this.destroyerFactory = scheduledExecutorFactory;
    }

    public static <T> T get(Resource<T> resource) {
        return (T) holder.getInternal(resource);
    }

    public static <T> T release(Resource<T> resource, T t) {
        return (T) holder.releaseInternal(resource, t);
    }

    <T> T getInternal(Resource<T> resource) {
        T t;
        synchronized (this) {
            Instance instance = this.instances.get(resource);
            Instance instance2 = instance;
            if (instance == null) {
                instance2 = new Instance(resource.create());
                this.instances.put(resource, instance2);
            }
            if (instance2.destroyTask != null) {
                instance2.destroyTask.cancel(false);
                instance2.destroyTask = null;
            }
            instance2.refcount++;
            t = (T) instance2.payload;
        }
        return t;
    }

    <T> T releaseInternal(final Resource<T> resource, final T t) {
        synchronized (this) {
            final Instance instance = this.instances.get(resource);
            if (instance == null) {
                throw new IllegalArgumentException("No cached instance found for " + resource);
            }
            Preconditions.checkArgument(t == instance.payload, "Releasing the wrong instance");
            Preconditions.checkState(instance.refcount > 0, "Refcount has already reached zero");
            instance.refcount--;
            if (instance.refcount == 0) {
                boolean z = false;
                if (instance.destroyTask == null) {
                    z = true;
                }
                Preconditions.checkState(z, "Destroy task already scheduled");
                if (this.destroyer == null) {
                    this.destroyer = this.destroyerFactory.createScheduledExecutor();
                }
                instance.destroyTask = this.destroyer.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.SharedResourceHolder.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SharedResourceHolder.this) {
                            if (instance.refcount == 0) {
                                resource.close(t);
                                SharedResourceHolder.this.instances.remove(resource);
                                if (SharedResourceHolder.this.instances.isEmpty()) {
                                    SharedResourceHolder.this.destroyer.shutdown();
                                    SharedResourceHolder.this.destroyer = null;
                                }
                            }
                        }
                    }
                }), 1L, TimeUnit.SECONDS);
            }
        }
        return null;
    }
}
