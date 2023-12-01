package com.getui.gtc.base.http;

import com.getui.gtc.base.http.RealCall;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Dispatcher.class */
public final class Dispatcher {
    private ExecutorService executorService;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    private <T> void finished(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                promoteCalls();
            }
        }
    }

    private void promoteCalls() {
        if (this.runningAsyncCalls.size() < this.maxRequests && !this.readyAsyncCalls.isEmpty()) {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningAsyncCalls.add(next);
                    executorService().execute(next);
                }
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }

    private int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            if (asyncCall2.get().request().url().getHost().equals(asyncCall.get().request().url().getHost())) {
                i++;
            }
        }
        return i;
    }

    public final void cancelAll() {
        synchronized (this) {
            for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
                asyncCall.get().cancel();
            }
            for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
                asyncCall2.get().cancel();
            }
            for (RealCall realCall : this.runningSyncCalls) {
                realCall.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enqueue(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            if (this.runningAsyncCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
                this.readyAsyncCalls.add(asyncCall);
                return;
            }
            this.runningAsyncCalls.add(asyncCall);
            executorService().execute(asyncCall);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void executed(RealCall realCall) {
        synchronized (this) {
            this.runningSyncCalls.add(realCall);
        }
    }

    public final ExecutorService executorService() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.executorService == null) {
                this.executorService = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.getui.gtc.base.http.Dispatcher.1
                    AtomicInteger index = new AtomicInteger(0);

                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("GtHttpClient dispatcher's thread" + this.index.getAndIncrement());
                        return thread;
                    }
                });
            }
            executorService = this.executorService;
        }
        return executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void finished(RealCall.AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void finished(RealCall realCall) {
        finished(this.runningSyncCalls, realCall, false);
    }

    public final int getMaxRequests() {
        int i;
        synchronized (this) {
            i = this.maxRequests;
        }
        return i;
    }

    public final int getMaxRequestsPerHost() {
        int i;
        synchronized (this) {
            i = this.maxRequestsPerHost;
        }
        return i;
    }

    public final List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
                arrayList.add(asyncCall.get());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public final int queuedCallsCount() {
        int size;
        synchronized (this) {
            size = this.readyAsyncCalls.size();
        }
        return size;
    }

    public final List<Call> runningCalls() {
        List<Call> unmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.runningSyncCalls);
            for (RealCall.AsyncCall asyncCall : this.runningAsyncCalls) {
                arrayList.add(asyncCall.get());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public final int runningCallsCount() {
        int size;
        int size2;
        synchronized (this) {
            size = this.runningAsyncCalls.size();
            size2 = this.runningSyncCalls.size();
        }
        return size + size2;
    }

    public final void setMaxRequests(int i) {
        synchronized (this) {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.maxRequests = i;
            promoteCalls();
        }
    }

    public final void setMaxRequestsPerHost(int i) {
        synchronized (this) {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.maxRequestsPerHost = i;
            promoteCalls();
        }
    }
}
