package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharedFlowImpl.class */
public final class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements CancellableFlow<T>, MutableSharedFlow<T>, FusibleFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f43409a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final BufferOverflow f43410c;
    private Object[] d;
    private long e;
    private long f;
    private int g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharedFlowImpl$Emitter.class */
    public static final class Emitter implements DisposableHandle {

        /* renamed from: a  reason: collision with root package name */
        public final SharedFlowImpl<?> f43411a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f43412c;
        public final Continuation<Unit> d;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.f43411a = sharedFlowImpl;
            this.b = j;
            this.f43412c = obj;
            this.d = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.f43411a.a(this);
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharedFlowImpl$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43413a;

        static {
            int[] iArr = new int[BufferOverflow.valuesCustom().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f43413a = iArr;
        }
    }

    private final Object a(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.f43445a;
        synchronized (this) {
            if (b((SharedFlowImpl<T>) t)) {
                CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
                Unit unit = Unit.f42314a;
                Result.Companion companion = Result.f42293a;
                cancellableContinuationImpl3.resumeWith(Result.f(unit));
                continuationArr = a(continuationArr2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, k() + i(), t, cancellableContinuationImpl2);
                d(emitter2);
                this.h++;
                continuationArr = continuationArr2;
                if (this.b == 0) {
                    continuationArr = a(continuationArr2);
                }
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.a(cancellableContinuationImpl2, emitter);
        }
        int i = 0;
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation2 = continuationArr[i];
            i++;
            if (continuation2 != null) {
                Unit unit2 = Unit.f42314a;
                Result.Companion companion2 = Result.f42293a;
                continuation2.resumeWith(Result.f(unit2));
            }
        }
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h == IntrinsicsKt.a() ? h : Unit.f42314a;
    }

    private final Object a(SharedFlowSlot sharedFlowSlot) {
        Symbol c2;
        Continuation<Unit>[] a2;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f43445a;
        synchronized (this) {
            long b = b(sharedFlowSlot);
            if (b < 0) {
                a2 = continuationArr;
                c2 = SharedFlowKt.f43416a;
            } else {
                long j = sharedFlowSlot.f43417a;
                c2 = c(b);
                sharedFlowSlot.f43417a = b + 1;
                a2 = a(j);
            }
        }
        int i = 0;
        int length = a2.length;
        while (i < length) {
            Continuation<Unit> continuation = a2[i];
            i++;
            if (continuation != null) {
                Unit unit = Unit.f42314a;
                Result.Companion companion = Result.f42293a;
                continuation.resumeWith(Result.f(unit));
            }
        }
        return c2;
    }

    private final Object a(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this) {
            if (b(sharedFlowSlot) < 0) {
                sharedFlowSlot.b = cancellableContinuationImpl2;
                sharedFlowSlot.b = cancellableContinuationImpl2;
            } else {
                CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
                Unit unit = Unit.f42314a;
                Result.Companion companion = Result.f42293a;
                cancellableContinuationImpl3.resumeWith(Result.f(unit));
            }
            Unit unit2 = Unit.f42314a;
        }
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h == IntrinsicsKt.a() ? h : Unit.f42314a;
    }

    private final void a(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        if (DebugKt.a()) {
            if (!(min >= i())) {
                throw new AssertionError();
            }
        }
        long i = i();
        if (i < min) {
            while (true) {
                long j5 = 1 + i;
                Object[] objArr = this.d;
                Intrinsics.a(objArr);
                SharedFlowKt.b(objArr, i, null);
                if (j5 >= min) {
                    break;
                }
                i = j5;
            }
        }
        this.e = j;
        this.f = j2;
        this.g = (int) (j3 - min);
        this.h = (int) (j4 - j3);
        if (DebugKt.a()) {
            if (!(this.g >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.a()) {
            if (!(this.h >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.a()) {
            if (!(this.e <= i() + ((long) this.g))) {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Emitter emitter) {
        Object b;
        synchronized (this) {
            if (emitter.b < i()) {
                return;
            }
            Object[] objArr = this.d;
            Intrinsics.a(objArr);
            b = SharedFlowKt.b(objArr, emitter.b);
            if (b != emitter) {
                return;
            }
            SharedFlowKt.b(objArr, emitter.b, SharedFlowKt.f43416a);
            o();
            Unit unit = Unit.f42314a;
        }
    }

    private final Object[] a(Object[] objArr, int i, int i2) {
        Object b;
        if (!(i2 > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i2];
        this.d = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long i3 = i();
        if (i <= 0) {
            return objArr2;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            int i6 = i5 + 1;
            long j = i5 + i3;
            b = SharedFlowKt.b(objArr, j);
            SharedFlowKt.b(objArr2, j, b);
            if (i6 >= i) {
                return objArr2;
            }
            i4 = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.lang.Object[]] */
    public final Continuation<Unit>[] a(Continuation<Unit>[] continuationArr) {
        int i;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        Continuation<Unit>[] continuationArr2;
        int length = continuationArr.length;
        SharedFlowImpl<T> sharedFlowImpl = this;
        i = ((AbstractSharedFlow) sharedFlowImpl).b;
        if (i != 0) {
            abstractSharedFlowSlotArr = ((AbstractSharedFlow) sharedFlowImpl).f43443a;
            if (abstractSharedFlowSlotArr != null) {
                int length2 = abstractSharedFlowSlotArr.length;
                int i2 = 0;
                while (true) {
                    continuationArr2 = continuationArr;
                    if (i2 >= length2) {
                        break;
                    }
                    AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i2];
                    int i3 = length;
                    Continuation<Unit>[] continuationArr3 = continuationArr;
                    if (abstractSharedFlowSlot != null) {
                        SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                        Continuation<? super Unit> continuation = sharedFlowSlot.b;
                        if (continuation == null) {
                            i3 = length;
                            continuationArr3 = continuationArr;
                        } else if (b(sharedFlowSlot) < 0) {
                            i3 = length;
                            continuationArr3 = continuationArr;
                        } else {
                            Continuation<Unit>[] continuationArr4 = continuationArr;
                            if (length >= continuationArr4.length) {
                                continuationArr = Arrays.copyOf(continuationArr4, Math.max(2, continuationArr4.length * 2));
                                Intrinsics.c(continuationArr, "java.util.Arrays.copyOf(this, newSize)");
                            }
                            continuationArr[length] = continuation;
                            sharedFlowSlot.b = null;
                            i3 = length + 1;
                            continuationArr3 = continuationArr;
                        }
                    }
                    i2++;
                    length = i3;
                    continuationArr = continuationArr3;
                }
            } else {
                continuationArr2 = continuationArr;
            }
        } else {
            continuationArr2 = continuationArr;
        }
        return continuationArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b(SharedFlowSlot sharedFlowSlot) {
        long j = sharedFlowSlot.f43417a;
        if (j < l()) {
            return j;
        }
        if (this.b <= 0 && j <= i() && this.h != 0) {
            return j;
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = ((kotlinx.coroutines.flow.internal.AbstractSharedFlow) r0).f43443a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(long r6) {
        /*
            r5 = this;
            r0 = r5
            kotlinx.coroutines.flow.internal.AbstractSharedFlow r0 = (kotlinx.coroutines.flow.internal.AbstractSharedFlow) r0
            r10 = r0
            r0 = r10
            int r0 = kotlinx.coroutines.flow.internal.AbstractSharedFlow.a(r0)
            if (r0 != 0) goto L11
            goto L60
        L11:
            r0 = r10
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r0 = kotlinx.coroutines.flow.internal.AbstractSharedFlow.b(r0)
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L20
            goto L60
        L20:
            r0 = r10
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r8 = r0
        L27:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L60
            r0 = r10
            r1 = r8
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L59
            r0 = r11
            kotlinx.coroutines.flow.SharedFlowSlot r0 = (kotlinx.coroutines.flow.SharedFlowSlot) r0
            r11 = r0
            r0 = r11
            long r0 = r0.f43417a
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L59
            r0 = r11
            long r0 = r0.f43417a
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L59
            r0 = r11
            r1 = r6
            r0.f43417a = r1
        L59:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L27
        L60:
            r0 = r5
            r1 = r6
            r0.f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.b(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(T t) {
        if (g() == 0) {
            return c((SharedFlowImpl<T>) t);
        }
        if (this.g >= this.b && this.f <= this.e) {
            int i = WhenMappings.f43413a[this.f43410c.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        d(t);
        int i2 = this.g + 1;
        this.g = i2;
        if (i2 > this.b) {
            n();
        }
        if (j() > this.f43409a) {
            a(this.e + 1, this.f, l(), m());
            return true;
        }
        return true;
    }

    private final Object c(long j) {
        Object b;
        Object[] objArr = this.d;
        Intrinsics.a(objArr);
        b = SharedFlowKt.b(objArr, j);
        Object obj = b;
        if (b instanceof Emitter) {
            obj = ((Emitter) b).f43412c;
        }
        return obj;
    }

    private final boolean c(T t) {
        if (DebugKt.a()) {
            if (!(g() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f43409a == 0) {
            return true;
        }
        d(t);
        int i = this.g + 1;
        this.g = i;
        if (i > this.f43409a) {
            n();
        }
        this.f = i() + this.g;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Object obj) {
        Object[] objArr;
        int k = k();
        Object[] objArr2 = this.d;
        if (objArr2 == null) {
            objArr = a(null, 0, 2);
        } else {
            objArr = objArr2;
            if (k >= objArr2.length) {
                objArr = a(objArr2, k, objArr2.length * 2);
            }
        }
        SharedFlowKt.b(objArr, i() + k, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long i() {
        return Math.min(this.f, this.e);
    }

    private final int j() {
        return (int) ((i() + this.g) - this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k() {
        return this.g + this.h;
    }

    private final long l() {
        return i() + this.g;
    }

    private final long m() {
        return i() + this.g + this.h;
    }

    private final void n() {
        Object[] objArr = this.d;
        Intrinsics.a(objArr);
        SharedFlowKt.b(objArr, i(), null);
        this.g--;
        long i = i() + 1;
        if (this.e < i) {
            this.e = i;
        }
        if (this.f < i) {
            b(i);
        }
        if (DebugKt.a()) {
            if (!(i() == i)) {
                throw new AssertionError();
            }
        }
    }

    private final void o() {
        Object b;
        if (this.b != 0 || this.h > 1) {
            Object[] objArr = this.d;
            Intrinsics.a(objArr);
            while (this.h > 0) {
                b = SharedFlowKt.b(objArr, (i() + k()) - 1);
                if (b != SharedFlowKt.f43416a) {
                    return;
                }
                this.h--;
                SharedFlowKt.b(objArr, i() + k(), null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v106, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v122, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v9, types: [kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r1v11, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r1v25, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0220 -> B:19:0x0091). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 677
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean a(T t) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArr;
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.f43445a;
        synchronized (this) {
            i = 0;
            if (b((SharedFlowImpl<T>) t)) {
                continuationArr = a(continuationArr2);
                z = true;
            } else {
                z = false;
                continuationArr = continuationArr2;
            }
        }
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Unit unit = Unit.f42314a;
                Result.Companion companion = Result.f42293a;
                continuation.resumeWith(Result.f(unit));
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        r0 = ((kotlinx.coroutines.flow.internal.AbstractSharedFlow) r0).f43443a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] a(long r11) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.a(long):kotlin.coroutines.Continuation[]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: a */
    public SharedFlowSlot[] b(int i) {
        return new SharedFlowSlot[i];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> a_(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.a(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void b() {
        synchronized (this) {
            a(l(), this.f, l(), m());
            Unit unit = Unit.f42314a;
        }
    }

    public final long c() {
        long j = this.e;
        if (j < this.f) {
            this.f = j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: d */
    public SharedFlowSlot e() {
        return new SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object a2;
        if (!a((SharedFlowImpl<T>) t) && (a2 = a((SharedFlowImpl<T>) t, continuation)) == IntrinsicsKt.a()) {
            return a2;
        }
        return Unit.f42314a;
    }
}
