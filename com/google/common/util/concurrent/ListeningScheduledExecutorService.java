package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/ListeningScheduledExecutorService.class */
public interface ListeningScheduledExecutorService extends ListeningExecutorService, ScheduledExecutorService {
    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}
