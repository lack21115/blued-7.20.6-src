package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/CallbackToFutureAdapter.class */
public final class CallbackToFutureAdapter {

    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/CallbackToFutureAdapter$Completer.class */
    public static final class Completer<T> {

        /* renamed from: a  reason: collision with root package name */
        Object f1980a;
        SafeFuture<T> b;

        /* renamed from: c  reason: collision with root package name */
        private ResolvableFuture<Void> f1981c = ResolvableFuture.create();
        private boolean d;

        Completer() {
        }

        private void b() {
            this.f1980a = null;
            this.b = null;
            this.f1981c = null;
        }

        void a() {
            this.f1980a = null;
            this.b = null;
            this.f1981c.set(null);
        }

        public void addCancellationListener(Runnable runnable, Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.f1981c;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        protected void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.a((Throwable) new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1980a));
            }
            if (this.d || (resolvableFuture = this.f1981c) == null) {
                return;
            }
            resolvableFuture.set(null);
        }

        public boolean set(T t) {
            boolean z = true;
            this.d = true;
            SafeFuture<T> safeFuture = this.b;
            if (safeFuture == null || !safeFuture.a((SafeFuture<T>) t)) {
                z = false;
            }
            if (z) {
                b();
            }
            return z;
        }

        public boolean setCancelled() {
            boolean z = true;
            this.d = true;
            SafeFuture<T> safeFuture = this.b;
            if (safeFuture == null || !safeFuture.a(true)) {
                z = false;
            }
            if (z) {
                b();
            }
            return z;
        }

        public boolean setException(Throwable th) {
            boolean z = true;
            this.d = true;
            SafeFuture<T> safeFuture = this.b;
            if (safeFuture == null || !safeFuture.a(th)) {
                z = false;
            }
            if (z) {
                b();
            }
            return z;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/CallbackToFutureAdapter$FutureGarbageCollectedException.class */
    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            synchronized (this) {
            }
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/CallbackToFutureAdapter$Resolver.class */
    public interface Resolver<T> {
        Object attachCompleter(Completer<T> completer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/CallbackToFutureAdapter$SafeFuture.class */
    public static final class SafeFuture<T> implements ListenableFuture<T> {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<Completer<T>> f1982a;
        private final AbstractResolvableFuture<T> b = new AbstractResolvableFuture<T>() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected String c() {
                Completer<T> completer = SafeFuture.this.f1982a.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f1980a + "]";
            }
        };

        SafeFuture(Completer<T> completer) {
            this.f1982a = new WeakReference<>(completer);
        }

        boolean a(T t) {
            return this.b.set(t);
        }

        boolean a(Throwable th) {
            return this.b.setException(th);
        }

        boolean a(boolean z) {
            return this.b.cancel(z);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.b.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            Completer<T> completer = this.f1982a.get();
            boolean cancel = this.b.cancel(z);
            if (cancel && completer != null) {
                completer.a();
            }
            return cancel;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.b.get();
        }

        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.b.get(j, timeUnit);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.b.isDone();
        }

        public String toString() {
            return this.b.toString();
        }
    }

    private CallbackToFutureAdapter() {
    }

    public static <T> ListenableFuture<T> getFuture(Resolver<T> resolver) {
        Completer<T> completer = new Completer<>();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.b = safeFuture;
        completer.f1980a = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.f1980a = attachCompleter;
                return safeFuture;
            }
        } catch (Exception e) {
            safeFuture.a((Throwable) e);
        }
        return safeFuture;
    }
}
