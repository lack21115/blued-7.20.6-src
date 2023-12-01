package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/SelfDestructiveThread.class */
public class SelfDestructiveThread {
    private HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f2551c;
    private final int f;
    private final int g;
    private final String h;

    /* renamed from: a  reason: collision with root package name */
    private final Object f2550a = new Object();
    private Handler.Callback e = new Handler.Callback() { // from class: androidx.core.provider.SelfDestructiveThread.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread.this.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                SelfDestructiveThread.this.a((Runnable) message.obj);
                return true;
            }
        }
    };
    private int d = 0;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/SelfDestructiveThread$ReplyCallback.class */
    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.f2550a) {
            if (this.b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.b = handlerThread;
                handlerThread.start();
                this.f2551c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.f2551c.removeMessages(0);
            this.f2551c.sendMessage(this.f2551c.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.f2550a) {
            if (this.f2551c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.f2551c = null;
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f2550a) {
            this.f2551c.removeMessages(0);
            this.f2551c.sendMessageDelayed(this.f2551c.obtainMessage(0), this.f);
        }
    }

    public int getGeneration() {
        int i;
        synchronized (this.f2550a) {
            i = this.d;
        }
        return i;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f2550a) {
            z = this.b != null;
        }
        return z;
    }

    public <T> void postAndReply(final Callable<T> callable, final ReplyCallback<T> replyCallback) {
        final Handler a2 = CalleeHandler.a();
        b(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                try {
                    obj = callable.call();
                } catch (Exception e) {
                    obj = null;
                }
                final Object obj2 = obj;
                a2.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        replyCallback.onReply(obj2);
                    }
                });
            }
        });
    }

    public <T> T postAndWait(final Callable<T> callable, int i) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception e) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (atomicBoolean.get()) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(i);
                do {
                    try {
                        nanos = newCondition.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                    }
                    if (!atomicBoolean.get()) {
                        return (T) atomicReference.get();
                    }
                } while (nanos > 0);
                throw new InterruptedException("timeout");
            }
            return (T) atomicReference.get();
        } finally {
            reentrantLock.unlock();
        }
    }
}
