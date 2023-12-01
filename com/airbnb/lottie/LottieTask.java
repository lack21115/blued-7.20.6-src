package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieTask.class */
public class LottieTask<T> {
    public static Executor a = Executors.newCachedThreadPool();
    private final Set<LottieListener<T>> b;
    private final Set<LottieListener<Throwable>> c;
    private final Handler d;
    private volatile LottieResult<T> e;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieTask$LottieFutureTask.class */
    class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask.this.setResult(new LottieResult(e));
            }
        }
    }

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.b = new LinkedHashSet(1);
        this.c = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper());
        this.e = null;
        if (!z) {
            a.execute(new LottieFutureTask(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new LottieResult<>(th));
        }
    }

    private void a() {
        this.d.post(new Runnable() { // from class: com.airbnb.lottie.LottieTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.e == null) {
                    return;
                }
                LottieResult lottieResult = LottieTask.this.e;
                if (lottieResult.a() != null) {
                    LottieTask.this.a((LottieTask) lottieResult.a());
                } else {
                    LottieTask.this.a(lottieResult.b());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t) {
        synchronized (this) {
            for (LottieListener lottieListener : new ArrayList(this.b)) {
                lottieListener.a(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        synchronized (this) {
            ArrayList<LottieListener> arrayList = new ArrayList(this.c);
            if (arrayList.isEmpty()) {
                Logger.a("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            for (LottieListener lottieListener : arrayList) {
                lottieListener.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(LottieResult<T> lottieResult) {
        if (this.e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.e = lottieResult;
        a();
    }

    public LottieTask<T> a(LottieListener<T> lottieListener) {
        synchronized (this) {
            if (this.e != null && this.e.a() != null) {
                lottieListener.a(this.e.a());
            }
            this.b.add(lottieListener);
        }
        return this;
    }

    public LottieTask<T> b(LottieListener<T> lottieListener) {
        synchronized (this) {
            this.b.remove(lottieListener);
        }
        return this;
    }

    public LottieTask<T> c(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            if (this.e != null && this.e.b() != null) {
                lottieListener.a(this.e.b());
            }
            this.c.add(lottieListener);
        }
        return this;
    }

    public LottieTask<T> d(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            this.c.remove(lottieListener);
        }
        return this;
    }
}
