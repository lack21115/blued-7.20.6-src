package androidx.concurrent.futures;

import com.amap.api.col.p0003sl.iu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture.class */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper b;
    private static final Object g;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f1969c;
    volatile Listener d;
    volatile Waiter e;

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1968a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger f = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$AtomicHelper.class */
    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract void a(Waiter waiter, Waiter waiter2);

        abstract void a(Waiter waiter, Thread thread);

        abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$Cancellation.class */
    public static final class Cancellation {

        /* renamed from: a  reason: collision with root package name */
        static final Cancellation f1970a;
        static final Cancellation b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f1971c;
        final Throwable d;

        static {
            if (AbstractResolvableFuture.f1968a) {
                b = null;
                f1970a = null;
                return;
            }
            b = new Cancellation(false, null);
            f1970a = new Cancellation(true, null);
        }

        Cancellation(boolean z, Throwable th) {
            this.f1971c = z;
            this.d = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$Failure.class */
    public static final class Failure {

        /* renamed from: a  reason: collision with root package name */
        static final Failure f1972a = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                synchronized (this) {
                }
                return this;
            }
        });
        final Throwable b;

        Failure(Throwable th) {
            this.b = (Throwable) AbstractResolvableFuture.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$Listener.class */
    public static final class Listener {

        /* renamed from: a  reason: collision with root package name */
        static final Listener f1973a = new Listener(null, null);
        final Runnable b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f1974c;
        Listener d;

        Listener(Runnable runnable, Executor executor) {
            this.b = runnable;
            this.f1974c = executor;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$SafeAtomicHelper.class */
    static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f1975a;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> f1976c;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> d;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f1975a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.f1976c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void a(Waiter waiter, Waiter waiter2) {
            this.b.lazySet(waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void a(Waiter waiter, Thread thread) {
            this.f1975a.lazySet(waiter, thread);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return this.d.compareAndSet(abstractResolvableFuture, listener, listener2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return this.f1976c.compareAndSet(abstractResolvableFuture, waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return this.e.compareAndSet(abstractResolvableFuture, obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$SetFuture.class */
    public static final class SetFuture<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final AbstractResolvableFuture<V> f1977a;
        final ListenableFuture<? extends V> b;

        SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f1977a = abstractResolvableFuture;
            this.b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1977a.f1969c != this) {
                return;
            }
            if (AbstractResolvableFuture.b.a((AbstractResolvableFuture<?>) this.f1977a, (Object) this, AbstractResolvableFuture.a((ListenableFuture<?>) this.b))) {
                AbstractResolvableFuture.a((AbstractResolvableFuture<?>) this.f1977a);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$SynchronizedHelper.class */
    static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void a(Waiter waiter, Waiter waiter2) {
            waiter.f1979c = waiter2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void a(Waiter waiter, Thread thread) {
            waiter.b = thread;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.d == listener) {
                    abstractResolvableFuture.d = listener2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.e == waiter) {
                    abstractResolvableFuture.e = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1969c == obj) {
                    abstractResolvableFuture.f1969c = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/concurrent/futures/AbstractResolvableFuture$Waiter.class */
    public static final class Waiter {

        /* renamed from: a  reason: collision with root package name */
        static final Waiter f1978a = new Waiter(false);
        volatile Thread b;

        /* renamed from: c  reason: collision with root package name */
        volatile Waiter f1979c;

        Waiter() {
            AbstractResolvableFuture.b.a(this, Thread.currentThread());
        }

        Waiter(boolean z) {
        }

        void a() {
            Thread thread = this.b;
            if (thread != null) {
                this.b = null;
                LockSupport.unpark(thread);
            }
        }

        void a(Waiter waiter) {
            AbstractResolvableFuture.b.a(this, waiter);
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, iu.h), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "d"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "c"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        b = synchronizedHelper;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    private Listener a(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.d;
        } while (!b.a((AbstractResolvableFuture<?>) this, listener2, Listener.f1973a));
        while (true) {
            Listener listener3 = listener;
            listener = listener2;
            if (listener == null) {
                return listener3;
            }
            listener2 = listener.d;
            listener.d = listener3;
        }
    }

    static Object a(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).f1969c;
            Cancellation cancellation = obj;
            if (obj instanceof Cancellation) {
                Cancellation cancellation2 = (Cancellation) obj;
                cancellation = obj;
                if (cancellation2.f1971c) {
                    if (cancellation2.d != null) {
                        return new Cancellation(false, cancellation2.d);
                    }
                    cancellation = Cancellation.b;
                }
            }
            return cancellation;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f1968a) && isCancelled) {
            return Cancellation.b;
        }
        try {
            Object a2 = a((Future<Object>) listenableFuture);
            Object obj2 = a2;
            if (a2 == null) {
                obj2 = g;
            }
            return obj2;
        } catch (CancellationException e) {
            if (isCancelled) {
                return new Cancellation(false, e);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e));
        } catch (ExecutionException e2) {
            return new Failure(e2.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    private static <V> V a(Future<V> future) throws ExecutionException {
        boolean z;
        V v;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                v = future.get();
                break;
            } catch (InterruptedException e) {
                z2 = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private static CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private void a(Waiter waiter) {
        Waiter waiter2;
        waiter.b = null;
        while (true) {
            Waiter waiter3 = this.e;
            if (waiter3 == Waiter.f1978a) {
                return;
            }
            Waiter waiter4 = null;
            while (true) {
                Waiter waiter5 = waiter4;
                if (waiter3 == null) {
                    return;
                }
                Waiter waiter6 = waiter3.f1979c;
                if (waiter3.b != null) {
                    waiter2 = waiter3;
                } else if (waiter5 != null) {
                    waiter5.f1979c = waiter6;
                    waiter2 = waiter5;
                    if (waiter5.b == null) {
                        break;
                    }
                } else {
                    waiter2 = waiter5;
                    if (!b.a((AbstractResolvableFuture<?>) this, waiter3, waiter6)) {
                        break;
                    }
                }
                waiter3 = waiter6;
                waiter4 = waiter2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.concurrent.futures.AbstractResolvableFuture<V>] */
    static void a(AbstractResolvableFuture<?> abstractResolvableFuture) {
        AbstractResolvableFuture<?> abstractResolvableFuture2 = abstractResolvableFuture;
        Listener listener = null;
        while (true) {
            abstractResolvableFuture2.d();
            abstractResolvableFuture2.b();
            Listener a2 = abstractResolvableFuture2.a(listener);
            while (true) {
                Listener listener2 = a2;
                if (listener2 == null) {
                    return;
                }
                listener = listener2.d;
                Runnable runnable = listener2.b;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractResolvableFuture2 = setFuture.f1977a;
                    if (abstractResolvableFuture2.f1969c == setFuture) {
                        if (b.a(abstractResolvableFuture2, setFuture, a((ListenableFuture<?>) setFuture.b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    a(runnable, listener2.f1974c);
                }
                a2 = listener;
            }
        }
    }

    private static void a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    private void a(StringBuilder sb) {
        try {
            Object a2 = a((Future<Object>) this);
            sb.append("SUCCESS, result=[");
            sb.append(c(a2));
            sb.append("]");
        } catch (CancellationException e) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private V b(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw a("Task was cancelled.", ((Cancellation) obj).d);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).b);
        }
        Object obj2 = obj;
        if (obj == g) {
            obj2 = null;
        }
        return (V) obj2;
    }

    private String c(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private void d() {
        Waiter waiter;
        do {
            waiter = this.e;
        } while (!b.a((AbstractResolvableFuture<?>) this, waiter, Waiter.f1978a));
        while (waiter != null) {
            waiter.a();
            waiter = waiter.f1979c;
        }
    }

    protected void a() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        a(runnable);
        a(executor);
        Listener listener2 = this.d;
        if (listener2 == Listener.f1973a) {
            a(runnable, executor);
        }
        Listener listener3 = new Listener(runnable, executor);
        do {
            listener3.d = listener2;
            if (b.a((AbstractResolvableFuture<?>) this, listener2, listener3)) {
                return;
            }
            listener = this.d;
            listener2 = listener;
        } while (listener != Listener.f1973a);
        a(runnable, executor);
    }

    protected void b() {
    }

    protected String c() {
        Object obj = this.f1969c;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + c(((SetFuture) obj).b) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean z2;
        Object obj = this.f1969c;
        if ((obj == null) || (obj instanceof SetFuture)) {
            Cancellation cancellation = f1968a ? new Cancellation(z, new CancellationException("Future.cancel() was called.")) : z ? Cancellation.f1970a : Cancellation.b;
            boolean z3 = false;
            AbstractResolvableFuture<V> abstractResolvableFuture = this;
            while (true) {
                if (b.a((AbstractResolvableFuture<?>) abstractResolvableFuture, obj, (Object) cancellation)) {
                    if (z) {
                        abstractResolvableFuture.a();
                    }
                    a((AbstractResolvableFuture<?>) abstractResolvableFuture);
                    z2 = true;
                    if (!(obj instanceof SetFuture)) {
                        break;
                    }
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).b;
                    if (!(listenableFuture instanceof AbstractResolvableFuture)) {
                        listenableFuture.cancel(z);
                        return true;
                    }
                    abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                    obj = abstractResolvableFuture.f1969c;
                    z2 = true;
                    if (!(obj == null) && !(obj instanceof SetFuture)) {
                        break;
                    }
                    z3 = true;
                } else {
                    Object obj2 = abstractResolvableFuture.f1969c;
                    obj = obj2;
                    if (!(obj2 instanceof SetFuture)) {
                        return z3;
                    }
                }
            }
        } else {
            z2 = false;
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        Waiter waiter;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f1969c;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return b(obj2);
        }
        Waiter waiter2 = this.e;
        if (waiter2 != Waiter.f1978a) {
            Waiter waiter3 = new Waiter();
            do {
                waiter3.a(waiter2);
                if (b.a((AbstractResolvableFuture<?>) this, waiter2, waiter3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            a(waiter3);
                            throw new InterruptedException();
                        }
                        obj = this.f1969c;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return b(obj);
                }
                waiter = this.e;
                waiter2 = waiter;
            } while (waiter != Waiter.f1978a);
            return b(this.f1969c);
        }
        return b(this.f1969c);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Waiter waiter;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1969c;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return b(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        long j2 = nanos;
        if (nanos >= 1000) {
            Waiter waiter2 = this.e;
            if (waiter2 != Waiter.f1978a) {
                Waiter waiter3 = new Waiter();
                do {
                    waiter3.a(waiter2);
                    if (b.a((AbstractResolvableFuture<?>) this, waiter2, waiter3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                a(waiter3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1969c;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return b(obj2);
                            }
                            j2 = nanoTime - System.nanoTime();
                            nanos = j2;
                        } while (j2 >= 1000);
                        a(waiter3);
                    } else {
                        waiter = this.e;
                        waiter2 = waiter;
                    }
                } while (waiter != Waiter.f1978a);
                return b(this.f1969c);
            }
            return b(this.f1969c);
        }
        while (j2 > 0) {
            Object obj3 = this.f1969c;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return b(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            j2 = nanoTime - System.nanoTime();
        }
        String abstractResolvableFuture = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
        String str2 = str;
        if (j2 + 1000 < 0) {
            String str3 = str + " (plus ";
            long j3 = -j2;
            long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(convert);
            int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
            boolean z = i == 0 || nanos2 > 1000;
            String str4 = str3;
            if (i > 0) {
                String str5 = str3 + convert + " " + lowerCase;
                String str6 = str5;
                if (z) {
                    str6 = str5 + ",";
                }
                str4 = str6 + " ";
            }
            String str7 = str4;
            if (z) {
                str7 = str4 + nanos2 + " nanoseconds ";
            }
            str2 = str7 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str2 + " but future completed as timeout expired");
        }
        throw new TimeoutException(str2 + " for " + abstractResolvableFuture);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1969c instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f1969c;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean set(V v) {
        V v2 = v;
        if (v == null) {
            v2 = g;
        }
        if (b.a((AbstractResolvableFuture<?>) this, (Object) null, (Object) v2)) {
            a((AbstractResolvableFuture<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (b.a((AbstractResolvableFuture<?>) this, (Object) null, (Object) new Failure((Throwable) a(th)))) {
            a((AbstractResolvableFuture<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        a(listenableFuture);
        Object obj = this.f1969c;
        Object obj2 = obj;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (b.a((AbstractResolvableFuture<?>) this, (Object) null, a((ListenableFuture<?>) listenableFuture))) {
                    a((AbstractResolvableFuture<?>) this);
                    return true;
                }
                return false;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (b.a((AbstractResolvableFuture<?>) this, (Object) null, (Object) setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                    return true;
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable th2) {
                        failure = Failure.f1972a;
                    }
                    b.a((AbstractResolvableFuture<?>) this, (Object) setFuture, (Object) failure);
                    return true;
                }
            }
            obj2 = this.f1969c;
        }
        if (obj2 instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj2).f1971c);
            return false;
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = c();
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
