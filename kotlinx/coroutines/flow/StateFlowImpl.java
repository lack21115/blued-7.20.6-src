package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StateFlowImpl.class */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements CancellableFlow<T>, MutableStateFlow<T>, FusibleFlow<T> {
    private volatile /* synthetic */ Object _state;
    private int a;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    private final boolean b(Object obj, Object obj2) {
        f();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !Intrinsics.a(obj3, obj)) {
                return false;
            }
            if (Intrinsics.a(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i = this.a;
            if ((i & 1) != 0) {
                this.a = i + 2;
                return true;
            }
            int i2 = i + 1;
            this.a = i2;
            StateFlowSlot[] f = f();
            Unit unit = Unit.a;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = f;
                if (stateFlowSlotArr != null) {
                    int length = stateFlowSlotArr.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        }
                        StateFlowSlot stateFlowSlot = stateFlowSlotArr[i4];
                        if (stateFlowSlot != null) {
                            stateFlowSlot.a();
                        }
                        i3 = i4 + 1;
                    }
                }
                synchronized (this) {
                    if (this.a == i2) {
                        this.a = i2 + 1;
                        return true;
                    }
                    i2 = this.a;
                    f = f();
                    Unit unit2 = Unit.a;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x01dd, code lost:
        if (kotlin.jvm.internal.Intrinsics.a(r14, r0) == false) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0280  */
    /* JADX WARN: Type inference failed for: r0v137, types: [kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v14, types: [kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v155, types: [kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v176, types: [kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v49, types: [kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v71, types: [kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r0v9, types: [kotlinx.coroutines.flow.StateFlowImpl] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x027d -> B:40:0x0193). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x02f8 -> B:40:0x0193). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean a(T t) {
        b((StateFlowImpl<T>) t);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.internal.Symbol] */
    /* JADX WARN: Type inference failed for: r0v7, types: [kotlinx.coroutines.internal.Symbol] */
    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean a(T t, T t2) {
        T t3 = t;
        if (t == null) {
            t3 = NullSurrogateKt.a;
        }
        T t4 = t2;
        if (t2 == null) {
            t4 = NullSurrogateKt.a;
        }
        return b(t3, t4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: a */
    public StateFlowSlot[] b(int i) {
        return new StateFlowSlot[i];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> a_(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.a(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [kotlinx.coroutines.internal.Symbol] */
    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void b(T t) {
        T t2 = t;
        if (t == null) {
            t2 = NullSurrogateKt.a;
        }
        b(null, t2);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public T c() {
        Symbol symbol = NullSurrogateKt.a;
        Object obj = this._state;
        Object obj2 = obj;
        if (obj == symbol) {
            obj2 = null;
        }
        return (T) obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: d */
    public StateFlowSlot e() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        b((StateFlowImpl<T>) t);
        return Unit.a;
    }
}
