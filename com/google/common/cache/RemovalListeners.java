package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/cache/RemovalListeners.class */
public final class RemovalListeners {
    private RemovalListeners() {
    }

    public static <K, V> RemovalListener<K, V> asynchronous(final RemovalListener<K, V> removalListener, final Executor executor) {
        Preconditions.checkNotNull(removalListener);
        Preconditions.checkNotNull(executor);
        return new RemovalListener<K, V>() { // from class: com.google.common.cache.RemovalListeners.1
            @Override // com.google.common.cache.RemovalListener
            public void onRemoval(final RemovalNotification<K, V> removalNotification) {
                executor.execute(new Runnable() { // from class: com.google.common.cache.RemovalListeners.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        removalListener.onRemoval(removalNotification);
                    }
                });
            }
        };
    }
}
