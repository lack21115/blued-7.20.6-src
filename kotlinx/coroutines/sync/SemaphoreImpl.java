package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/SemaphoreImpl.class */
public final class SemaphoreImpl implements Semaphore {
    volatile /* synthetic */ int _availablePermits;
    private final int b;
    private volatile /* synthetic */ long deqIdx = 0;
    private volatile /* synthetic */ long enqIdx = 0;
    private final Function1<Throwable, Unit> g;
    private volatile /* synthetic */ Object head;
    private volatile /* synthetic */ Object tail;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    private static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i, int i2) {
        this.b = i;
        if (!(this.b > 0)) {
            throw new IllegalArgumentException(Intrinsics.a("Semaphore should have at least 1 permit, but had ", (Object) Integer.valueOf(this.b)).toString());
        }
        if (!(i2 >= 0 && i2 <= this.b)) {
            throw new IllegalArgumentException(Intrinsics.a("The number of acquired permits should be in 0..", (Object) Integer.valueOf(this.b)).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head = semaphoreSegment;
        this.tail = semaphoreSegment;
        this._availablePermits = this.b - i2;
        this.g = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Throwable th) {
                SemaphoreImpl.this.a();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Throwable th) {
                a(th);
                return Unit.a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0088, code lost:
        r8 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [kotlinx.coroutines.internal.Segment] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.a(kotlinx.coroutines.CancellableContinuation):boolean");
    }

    private final Object b(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl a2 = CancellableContinuationKt.a(IntrinsicsKt.a(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = a2;
        while (true) {
            if (!a((CancellableContinuation<? super Unit>) cancellableContinuationImpl)) {
                if (a.getAndDecrement(this) > 0) {
                    cancellableContinuationImpl.a((CancellableContinuationImpl) Unit.a, this.g);
                    break;
                }
            } else {
                break;
            }
        }
        Object h = a2.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h == IntrinsicsKt.a() ? h : Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0088, code lost:
        r6 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [kotlinx.coroutines.internal.Segment] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean b() {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.b():boolean");
    }

    private final boolean b(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object a2 = cancellableContinuation.a(Unit.a, null, this.g);
        if (a2 == null) {
            return false;
        }
        cancellableContinuation.a(a2);
        return true;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object a(Continuation<? super Unit> continuation) {
        Object b;
        if (a.getAndDecrement(this) <= 0 && (b = b(continuation)) == IntrinsicsKt.a()) {
            return b;
        }
        return Unit.a;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void a() {
        while (true) {
            int i = this._availablePermits;
            if (!(i < this.b)) {
                throw new IllegalStateException(Intrinsics.a("The number of released permits cannot be greater than ", (Object) Integer.valueOf(this.b)).toString());
            }
            if (a.compareAndSet(this, i, i + 1) && (i >= 0 || b())) {
                return;
            }
        }
    }
}
