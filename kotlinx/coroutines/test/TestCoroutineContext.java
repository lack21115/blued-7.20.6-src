package kotlinx.coroutines.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import kotlinx.coroutines.test.TestCoroutineContext;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/test/TestCoroutineContext.class */
public final class TestCoroutineContext implements CoroutineContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f43642a;
    private final List<Throwable> b;

    /* renamed from: c  reason: collision with root package name */
    private final Dispatcher f43643c;
    private final CoroutineExceptionHandler d;
    private final ThreadSafeHeap<TimedRunnableObsolete> e;
    private long f;
    private long g;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/test/TestCoroutineContext$Dispatcher.class */
    final class Dispatcher extends EventLoop implements Delay {
        public Dispatcher() {
            EventLoop.a(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.Delay
        public DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext) {
            final TimedRunnableObsolete a2 = TestCoroutineContext.this.a(runnable, j);
            final TestCoroutineContext testCoroutineContext = TestCoroutineContext.this;
            return new DisposableHandle() { // from class: kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$invokeOnTimeout$1
                @Override // kotlinx.coroutines.DisposableHandle
                public void dispose() {
                    ThreadSafeHeap threadSafeHeap;
                    threadSafeHeap = TestCoroutineContext.this.e;
                    threadSafeHeap.b((ThreadSafeHeap) a2);
                }
            };
        }

        @Override // kotlinx.coroutines.Delay
        public void a(long j, final CancellableContinuation<? super Unit> cancellableContinuation) {
            TestCoroutineContext.this.a(new Runnable() { // from class: kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    CancellableContinuation.this.a((CoroutineDispatcher) this, (TestCoroutineContext.Dispatcher) Unit.f42314a);
                }
            }, j);
        }

        @Override // kotlinx.coroutines.EventLoop
        public long b() {
            return TestCoroutineContext.this.a();
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
            TestCoroutineContext.this.a(runnable);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    public TestCoroutineContext(String str) {
        this.f43642a = str;
        this.b = new ArrayList();
        this.f43643c = new Dispatcher();
        this.d = new TestCoroutineContext$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.b, this);
        this.e = new ThreadSafeHeap<>();
    }

    public /* synthetic */ TestCoroutineContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a() {
        TimedRunnableObsolete c2 = this.e.c();
        if (c2 != null) {
            a(c2.f43647a);
        }
        return this.e.b() ? Long.MAX_VALUE : 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimedRunnableObsolete a(Runnable runnable, long j) {
        long j2 = this.f;
        this.f = 1 + j2;
        TimedRunnableObsolete timedRunnableObsolete = new TimedRunnableObsolete(runnable, j2, this.g + TimeUnit.MILLISECONDS.toNanos(j));
        this.e.a((ThreadSafeHeap<TimedRunnableObsolete>) timedRunnableObsolete);
        return timedRunnableObsolete;
    }

    private final void a(long j) {
        Object obj;
        while (true) {
            ThreadSafeHeap<TimedRunnableObsolete> threadSafeHeap = this.e;
            synchronized (threadSafeHeap) {
                TimedRunnableObsolete e = threadSafeHeap.e();
                obj = null;
                if (e != null) {
                    obj = (e.f43647a > j ? 1 : (e.f43647a == j ? 0 : -1)) <= 0 ? threadSafeHeap.a(0) : (ThreadSafeHeapNode) null;
                }
            }
            TimedRunnableObsolete timedRunnableObsolete = (TimedRunnableObsolete) obj;
            if (timedRunnableObsolete == null) {
                return;
            }
            if (timedRunnableObsolete.f43647a != 0) {
                this.g = timedRunnableObsolete.f43647a;
            }
            timedRunnableObsolete.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Runnable runnable) {
        ThreadSafeHeap<TimedRunnableObsolete> threadSafeHeap = this.e;
        long j = this.f;
        this.f = 1 + j;
        threadSafeHeap.a((ThreadSafeHeap<TimedRunnableObsolete>) new TimedRunnableObsolete(runnable, j, 0L, 4, null));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return function2.invoke((R) function2.invoke(r, this.f43643c), this.d);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        if (key == ContinuationInterceptor.f42453a) {
            return this.f43643c;
        }
        if (key == CoroutineExceptionHandler.b) {
            return this.d;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return key == ContinuationInterceptor.f42453a ? this.d : key == CoroutineExceptionHandler.b ? this.f43643c : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        String str = this.f43642a;
        String str2 = str;
        if (str == null) {
            str2 = Intrinsics.a("TestCoroutineContext@", (Object) DebugStringsKt.a(this));
        }
        return str2;
    }
}
