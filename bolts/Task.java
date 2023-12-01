package bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:bolts/Task.class */
public class Task<TResult> {
    private static volatile UnobservedExceptionHandler d;
    private boolean f;
    private boolean g;
    private TResult h;
    private Exception i;
    private boolean j;
    private UnobservedErrorNotifier k;

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f3645a = BoltsExecutors.a();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f3646c = BoltsExecutors.c();
    public static final Executor b = AndroidExecutors.b();
    private static Task<?> m = new Task<>((Object) null);
    private static Task<Boolean> n = new Task<>(true);
    private static Task<Boolean> o = new Task<>(false);
    private static Task<?> p = new Task<>(true);
    private final Object e = new Object();
    private List<Continuation<TResult, Void>> l = new ArrayList();

    /* renamed from: bolts.Task$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$1.class */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bolts.TaskCompletionSource f3647a;

        @Override // java.lang.Runnable
        public void run() {
            this.f3647a.a((bolts.TaskCompletionSource) null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    /* renamed from: bolts.Task$12  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$12.class */
    class AnonymousClass12<TContinuationResult> implements Continuation<TResult, Task<TContinuationResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellationToken f3652a;
        final /* synthetic */ Continuation b;

        @Override // bolts.Continuation
        /* renamed from: a */
        public Task<TContinuationResult> then(Task<TResult> task) {
            CancellationToken cancellationToken = this.f3652a;
            return (cancellationToken == null || !cancellationToken.a()) ? task.d() ? Task.a(task.f()) : task.c() ? Task.h() : task.a((Continuation) this.b) : Task.h();
        }
    }

    /* renamed from: bolts.Task$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$2.class */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScheduledFuture f3660a;
        final /* synthetic */ bolts.TaskCompletionSource b;

        @Override // java.lang.Runnable
        public void run() {
            this.f3660a.cancel(true);
            this.b.b();
        }
    }

    /* renamed from: bolts.Task$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$3.class */
    class AnonymousClass3 implements Continuation<TResult, Task<Void>> {
        @Override // bolts.Continuation
        /* renamed from: a */
        public Task<Void> then(Task<TResult> task) throws Exception {
            return task.c() ? Task.h() : task.d() ? Task.a(task.f()) : Task.a((Object) null);
        }
    }

    /* renamed from: bolts.Task$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$5.class */
    static final class AnonymousClass5 implements Continuation<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f3663a;
        final /* synthetic */ bolts.TaskCompletionSource b;

        @Override // bolts.Continuation
        /* renamed from: a */
        public Void then(Task<TResult> task) {
            if (this.f3663a.compareAndSet(false, true)) {
                this.b.setResult(task);
                return null;
            }
            task.f();
            return null;
        }
    }

    /* renamed from: bolts.Task$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$6.class */
    static final class AnonymousClass6 implements Continuation<Object, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f3664a;
        final /* synthetic */ bolts.TaskCompletionSource b;

        @Override // bolts.Continuation
        /* renamed from: a */
        public Void then(Task<Object> task) {
            if (this.f3664a.compareAndSet(false, true)) {
                this.b.setResult(task);
                return null;
            }
            task.f();
            return null;
        }
    }

    /* renamed from: bolts.Task$7  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$7.class */
    static final class AnonymousClass7 implements Continuation<Void, List<TResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Collection f3665a;

        @Override // bolts.Continuation
        /* renamed from: a */
        public List<TResult> then(Task<Void> task) throws Exception {
            if (this.f3665a.size() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Task task2 : this.f3665a) {
                arrayList.add(task2.e());
            }
            return arrayList;
        }
    }

    /* renamed from: bolts.Task$8  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$8.class */
    static final class AnonymousClass8 implements Continuation<Object, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f3666a;
        final /* synthetic */ ArrayList b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f3667c;
        final /* synthetic */ AtomicInteger d;
        final /* synthetic */ bolts.TaskCompletionSource e;

        @Override // bolts.Continuation
        /* renamed from: a */
        public Void then(Task<Object> task) {
            if (task.d()) {
                synchronized (this.f3666a) {
                    this.b.add(task.f());
                }
            }
            if (task.c()) {
                this.f3667c.set(true);
            }
            if (this.d.decrementAndGet() == 0) {
                if (this.b.size() != 0) {
                    if (this.b.size() == 1) {
                        this.e.b((Exception) this.b.get(0));
                        return null;
                    }
                    this.e.b(new AggregateException(String.format("There were %d exceptions.", Integer.valueOf(this.b.size())), this.b));
                    return null;
                } else if (this.f3667c.get()) {
                    this.e.c();
                    return null;
                } else {
                    this.e.setResult(null);
                    return null;
                }
            }
            return null;
        }
    }

    /* renamed from: bolts.Task$9  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$9.class */
    class AnonymousClass9 implements Continuation<Void, Task<Void>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellationToken f3668a;
        final /* synthetic */ Callable b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Continuation f3669c;
        final /* synthetic */ Executor d;
        final /* synthetic */ Capture e;

        @Override // bolts.Continuation
        /* renamed from: a */
        public Task<Void> then(Task<Void> task) throws Exception {
            CancellationToken cancellationToken = this.f3668a;
            return (cancellationToken == null || !cancellationToken.a()) ? ((Boolean) this.b.call()).booleanValue() ? Task.a((Object) null).b(this.f3669c, this.d).b((Continuation) this.e.a(), this.d) : Task.a((Object) null) : Task.h();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$TaskCompletionSource.class */
    public class TaskCompletionSource extends bolts.TaskCompletionSource<TResult> {
    }

    /* loaded from: source-8756600-dex2jar.jar:bolts/Task$UnobservedExceptionHandler.class */
    public interface UnobservedExceptionHandler {
        void a(Task<?> task, UnobservedTaskException unobservedTaskException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task() {
    }

    private Task(TResult tresult) {
        b((Task<TResult>) tresult);
    }

    private Task(boolean z) {
        if (z) {
            i();
        } else {
            b((Task<TResult>) null);
        }
    }

    public static UnobservedExceptionHandler a() {
        return d;
    }

    public static <TResult> Task<TResult> a(Exception exc) {
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.b(exc);
        return taskCompletionSource.a();
    }

    public static <TResult> Task<TResult> a(TResult tresult) {
        if (tresult == null) {
            return (Task<TResult>) m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (Task<TResult>) n : (Task<TResult>) o;
        }
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void c(final bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable() { // from class: bolts.Task.14
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    CancellationToken cancellationToken2 = CancellationToken.this;
                    if (cancellationToken2 != null && cancellationToken2.a()) {
                        taskCompletionSource.c();
                        return;
                    }
                    try {
                        taskCompletionSource.setResult(continuation.then(task));
                    } catch (CancellationException e) {
                        taskCompletionSource.c();
                    } catch (Exception e2) {
                        taskCompletionSource.b(e2);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.b(new ExecutorException(e));
        }
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(callable, f3646c, null);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable, CancellationToken cancellationToken) {
        return call(callable, f3646c, cancellationToken);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor) {
        return call(callable, executor, null);
    }

    public static <TResult> Task<TResult> call(final Callable<TResult> callable, Executor executor, final CancellationToken cancellationToken) {
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        try {
            executor.execute(new Runnable() { // from class: bolts.Task.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    CancellationToken cancellationToken2 = CancellationToken.this;
                    if (cancellationToken2 != null && cancellationToken2.a()) {
                        taskCompletionSource.c();
                        return;
                    }
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (CancellationException e) {
                        taskCompletionSource.c();
                    } catch (Exception e2) {
                        taskCompletionSource.b(e2);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.b(new ExecutorException(e));
        }
        return taskCompletionSource.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(final bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable() { // from class: bolts.Task.15
                @Override // java.lang.Runnable
                public void run() {
                    CancellationToken cancellationToken2 = CancellationToken.this;
                    if (cancellationToken2 != null && cancellationToken2.a()) {
                        taskCompletionSource.c();
                        return;
                    }
                    try {
                        Task task2 = (Task) continuation.then(task);
                        if (task2 == null) {
                            taskCompletionSource.setResult(null);
                        } else {
                            task2.a((Continuation) new Continuation<TContinuationResult, Void>() { // from class: bolts.Task.15.1
                                @Override // bolts.Continuation
                                /* renamed from: a */
                                public Void then(Task<TContinuationResult> task3) {
                                    if (CancellationToken.this != null && CancellationToken.this.a()) {
                                        taskCompletionSource.c();
                                        return null;
                                    } else if (task3.c()) {
                                        taskCompletionSource.c();
                                        return null;
                                    } else if (task3.d()) {
                                        taskCompletionSource.b(task3.f());
                                        return null;
                                    } else {
                                        taskCompletionSource.setResult(task3.e());
                                        return null;
                                    }
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        taskCompletionSource.c();
                    } catch (Exception e2) {
                        taskCompletionSource.b(e2);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.b(new ExecutorException(e));
        }
    }

    public static <TResult> Task<TResult> h() {
        return (Task<TResult>) p;
    }

    private void j() {
        synchronized (this.e) {
            for (Continuation<TResult, Void> continuation : this.l) {
                try {
                    continuation.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.l = null;
        }
    }

    public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, TContinuationResult> continuation) {
        return a(continuation, f3646c, null);
    }

    public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        return b(continuation, executor, null);
    }

    public <TContinuationResult> Task<TContinuationResult> a(final Continuation<TResult, TContinuationResult> continuation, final Executor executor, final CancellationToken cancellationToken) {
        boolean b2;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.e) {
            b2 = b();
            if (!b2) {
                this.l.add(new Continuation<TResult, Void>() { // from class: bolts.Task.10
                    @Override // bolts.Continuation
                    /* renamed from: a */
                    public Void then(Task<TResult> task) {
                        Task.c(taskCompletionSource, continuation, task, executor, cancellationToken);
                        return null;
                    }
                });
            }
        }
        if (b2) {
            c(taskCompletionSource, continuation, this, executor, cancellationToken);
        }
        return taskCompletionSource.a();
    }

    public <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return b(continuation, f3646c, null);
    }

    public <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        return c(continuation, executor, null);
    }

    public <TContinuationResult> Task<TContinuationResult> b(final Continuation<TResult, Task<TContinuationResult>> continuation, final Executor executor, final CancellationToken cancellationToken) {
        boolean b2;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.e) {
            b2 = b();
            if (!b2) {
                this.l.add(new Continuation<TResult, Void>() { // from class: bolts.Task.11
                    @Override // bolts.Continuation
                    /* renamed from: a */
                    public Void then(Task<TResult> task) {
                        Task.d(taskCompletionSource, continuation, task, executor, cancellationToken);
                        return null;
                    }
                });
            }
        }
        if (b2) {
            d(taskCompletionSource, continuation, this, executor, cancellationToken);
        }
        return taskCompletionSource.a();
    }

    public boolean b() {
        boolean z;
        synchronized (this.e) {
            z = this.f;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Exception exc) {
        synchronized (this.e) {
            if (this.f) {
                return false;
            }
            this.f = true;
            this.i = exc;
            this.j = false;
            this.e.notifyAll();
            j();
            if (!this.j && a() != null) {
                this.k = new UnobservedErrorNotifier(this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(TResult tresult) {
        synchronized (this.e) {
            if (this.f) {
                return false;
            }
            this.f = true;
            this.h = tresult;
            this.e.notifyAll();
            j();
            return true;
        }
    }

    public <TContinuationResult> Task<TContinuationResult> c(final Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, final CancellationToken cancellationToken) {
        return a(new Continuation<TResult, Task<TContinuationResult>>() { // from class: bolts.Task.13
            @Override // bolts.Continuation
            /* renamed from: a */
            public Task<TContinuationResult> then(Task<TResult> task) {
                CancellationToken cancellationToken2 = cancellationToken;
                return (cancellationToken2 == null || !cancellationToken2.a()) ? task.d() ? Task.a(task.f()) : task.c() ? Task.h() : task.b((Continuation) continuation) : Task.h();
            }
        }, executor);
    }

    public boolean c() {
        boolean z;
        synchronized (this.e) {
            z = this.g;
        }
        return z;
    }

    public boolean d() {
        boolean z;
        synchronized (this.e) {
            z = f() != null;
        }
        return z;
    }

    public TResult e() {
        TResult tresult;
        synchronized (this.e) {
            tresult = this.h;
        }
        return tresult;
    }

    public Exception f() {
        Exception exc;
        synchronized (this.e) {
            if (this.i != null) {
                this.j = true;
                if (this.k != null) {
                    this.k.a();
                    this.k = null;
                }
            }
            exc = this.i;
        }
        return exc;
    }

    public void g() throws InterruptedException {
        synchronized (this.e) {
            if (!b()) {
                this.e.wait();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        synchronized (this.e) {
            if (this.f) {
                return false;
            }
            this.f = true;
            this.g = true;
            this.e.notifyAll();
            j();
            return true;
        }
    }
}
