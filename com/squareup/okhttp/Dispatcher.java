package com.squareup.okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Dispatcher.class */
public final class Dispatcher {
    private ExecutorService executorService;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque();
    private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque();
    private final Deque<Call> executedCalls = new ArrayDeque();

    public Dispatcher() {
    }

    public Dispatcher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    private void promoteCalls() {
        if (this.runningCalls.size() < this.maxRequests && !this.readyCalls.isEmpty()) {
            Iterator<Call.AsyncCall> it = this.readyCalls.iterator();
            while (it.hasNext()) {
                Call.AsyncCall next = it.next();
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningCalls.add(next);
                    getExecutorService().execute(next);
                }
                if (this.runningCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }

    private int runningCallsForHost(Call.AsyncCall asyncCall) {
        int i = 0;
        for (Call.AsyncCall asyncCall2 : this.runningCalls) {
            if (asyncCall2.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    public void cancel(Object obj) {
        synchronized (this) {
            for (Call.AsyncCall asyncCall : this.readyCalls) {
                if (Util.equal(obj, asyncCall.tag())) {
                    asyncCall.cancel();
                }
            }
            for (Call.AsyncCall asyncCall2 : this.runningCalls) {
                if (Util.equal(obj, asyncCall2.tag())) {
                    asyncCall2.get().canceled = true;
                    HttpEngine httpEngine = asyncCall2.get().engine;
                    if (httpEngine != null) {
                        httpEngine.cancel();
                    }
                }
            }
            for (Call call : this.executedCalls) {
                if (Util.equal(obj, call.tag())) {
                    call.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(Call.AsyncCall asyncCall) {
        synchronized (this) {
            if (this.runningCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
                this.readyCalls.add(asyncCall);
            } else {
                this.runningCalls.add(asyncCall);
                getExecutorService().execute(asyncCall);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void executed(Call call) {
        synchronized (this) {
            this.executedCalls.add(call);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finished(Call.AsyncCall asyncCall) {
        synchronized (this) {
            if (!this.runningCalls.remove(asyncCall)) {
                throw new AssertionError("AsyncCall wasn't running!");
            }
            promoteCalls();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finished(Call call) {
        synchronized (this) {
            if (!this.executedCalls.remove(call)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
    }

    public ExecutorService getExecutorService() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.executorService == null) {
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            }
            executorService = this.executorService;
        }
        return executorService;
    }

    public int getMaxRequests() {
        int i;
        synchronized (this) {
            i = this.maxRequests;
        }
        return i;
    }

    public int getMaxRequestsPerHost() {
        int i;
        synchronized (this) {
            i = this.maxRequestsPerHost;
        }
        return i;
    }

    public int getQueuedCallCount() {
        int size;
        synchronized (this) {
            size = this.readyCalls.size();
        }
        return size;
    }

    public int getRunningCallCount() {
        int size;
        synchronized (this) {
            size = this.runningCalls.size();
        }
        return size;
    }

    public void setMaxRequests(int i) {
        synchronized (this) {
            if (i < 1) {
                throw new IllegalArgumentException("max < 1: " + i);
            }
            this.maxRequests = i;
            promoteCalls();
        }
    }

    public void setMaxRequestsPerHost(int i) {
        synchronized (this) {
            if (i < 1) {
                throw new IllegalArgumentException("max < 1: " + i);
            }
            this.maxRequestsPerHost = i;
            promoteCalls();
        }
    }
}
