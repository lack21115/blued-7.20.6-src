package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.RealCall;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Dispatcher.class */
public final class Dispatcher {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f22155a = !Dispatcher.class.desiredAssertionStatus();
    private Runnable d;
    private ExecutorService e;
    private int b = 64;

    /* renamed from: c  reason: collision with root package name */
    private int f22156c = 5;
    private final Deque<RealCall.AsyncCall> f = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> g = new ArrayDeque();
    private final Deque<RealCall> h = new ArrayDeque();

    public Dispatcher() {
    }

    public Dispatcher(ExecutorService executorService) {
        this.e = executorService;
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.d;
        }
        if (a() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private boolean a() {
        int i;
        boolean z;
        if (f22155a || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it = this.f.iterator();
                while (it.hasNext()) {
                    RealCall.AsyncCall next = it.next();
                    if (this.g.size() >= this.b) {
                        break;
                    } else if (c(next) < this.f22156c) {
                        it.remove();
                        arrayList.add(next);
                        this.g.add(next);
                    }
                }
                z = runningCallsCount() > 0;
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((RealCall.AsyncCall) arrayList.get(i)).a(executorService());
            }
            return z;
        }
        throw new AssertionError();
    }

    private int c(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall asyncCall2 : this.g) {
            if (!asyncCall2.b().e && asyncCall2.a().equals(asyncCall.a())) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.f.add(asyncCall);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RealCall realCall) {
        synchronized (this) {
            this.h.add(realCall);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RealCall.AsyncCall asyncCall) {
        a(this.g, asyncCall);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RealCall realCall) {
        a(this.h, realCall);
    }

    public void cancelAll() {
        synchronized (this) {
            for (RealCall.AsyncCall asyncCall : this.f) {
                asyncCall.b().cancel();
            }
            for (RealCall.AsyncCall asyncCall2 : this.g) {
                asyncCall2.b().cancel();
            }
            for (RealCall realCall : this.h) {
                realCall.cancel();
            }
        }
    }

    public ExecutorService executorService() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.e == null) {
                this.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            }
            executorService = this.e;
        }
        return executorService;
    }

    public int getMaxRequests() {
        int i;
        synchronized (this) {
            i = this.b;
        }
        return i;
    }

    public int getMaxRequestsPerHost() {
        int i;
        synchronized (this) {
            i = this.f22156c;
        }
        return i;
    }

    public List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            for (RealCall.AsyncCall asyncCall : this.f) {
                arrayList.add(asyncCall.b());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public int queuedCallsCount() {
        int size;
        synchronized (this) {
            size = this.f.size();
        }
        return size;
    }

    public List<Call> runningCalls() {
        List<Call> unmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.h);
            for (RealCall.AsyncCall asyncCall : this.g) {
                arrayList.add(asyncCall.b());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public int runningCallsCount() {
        int size;
        int size2;
        synchronized (this) {
            size = this.g.size();
            size2 = this.h.size();
        }
        return size + size2;
    }

    public void setIdleCallback(Runnable runnable) {
        synchronized (this) {
            this.d = runnable;
        }
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.b = i;
            }
            a();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f22156c = i;
            }
            a();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }
}
