package java.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/AbstractExecutorService.class */
public abstract class AbstractExecutorService implements ExecutorService {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !AbstractExecutorService.class.desiredAssertionStatus();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fb, code lost:
        if (r6 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fe, code lost:
        r6 = new java.util.concurrent.ExecutionException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0107, code lost:
        throw r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011a A[LOOP:1: B:42:0x0113->B:44:0x011a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T doInvokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> r6, boolean r7, long r8) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.AbstractExecutorService.doInvokeAny(java.util.Collection, boolean, long):java.lang.Object");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        if (collection == null) {
            throw new NullPointerException();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            for (Callable<T> callable : collection) {
                RunnableFuture<T> newTaskFor = newTaskFor(callable);
                arrayList.add(newTaskFor);
                execute(newTaskFor);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Future future = (Future) arrayList.get(i);
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            if (1 == 0) {
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((Future) arrayList.get(i2)).cancel(true);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 == 0) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((Future) arrayList.get(i3)).cancel(true);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ec, code lost:
        if (r10 >= r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ef, code lost:
        r0 = (java.util.concurrent.Future) r0.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0103, code lost:
        r12 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0107, code lost:
        if (r0.isDone() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010d, code lost:
        if (r7 > 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0111, code lost:
        if (0 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0114, code lost:
        r10 = 0;
        r0 = r0.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0122, code lost:
        if (r10 >= r0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0125, code lost:
        ((java.util.concurrent.Future) r0.get(r10)).cancel(true);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013f, code lost:
        r0.get(r7, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0162, code lost:
        if (0 == 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0165, code lost:
        r10 = 0;
        r0 = r0.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0173, code lost:
        if (r10 < r0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0176, code lost:
        ((java.util.concurrent.Future) r0.get(r10)).cancel(true);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0191, code lost:
        if (1 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0194, code lost:
        r10 = 0;
        r0 = r0.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a2, code lost:
        if (r10 >= r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01a5, code lost:
        ((java.util.concurrent.Future) r0.get(r10)).cancel(true);
        r10 = r10 + 1;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01c4 -> B:48:0x014a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01c8 -> B:48:0x014a). Please submit an issue!!! */
    @Override // java.util.concurrent.ExecutorService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> r6, long r7, java.util.concurrent.TimeUnit r9) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.AbstractExecutorService.invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit):java.util.List");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        try {
            return (T) doInvokeAny(collection, false, 0L);
        } catch (TimeoutException e) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) doInvokeAny(collection, true, timeUnit.toNanos(j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new FutureTask(runnable, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureTask(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture newTaskFor = newTaskFor(runnable, null);
        execute(newTaskFor);
        return newTaskFor;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> newTaskFor = newTaskFor(runnable, t);
        execute(newTaskFor);
        return newTaskFor;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> newTaskFor = newTaskFor(callable);
        execute(newTaskFor);
        return newTaskFor;
    }
}
