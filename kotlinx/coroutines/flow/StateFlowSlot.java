package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StateFlowSlot.class */
public final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f43436a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    public final Object a(Continuation<? super Unit> continuation) {
        Symbol symbol;
        Symbol symbol2;
        boolean z = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (!DebugKt.a() || Boxing.a(!(this._state instanceof CancellableContinuationImpl)).booleanValue()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43436a;
            symbol = StateFlowKt.f43435a;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, symbol, cancellableContinuationImpl2)) {
                if (DebugKt.a()) {
                    Object obj = this._state;
                    symbol2 = StateFlowKt.b;
                    if (obj != symbol2) {
                        z = false;
                    }
                    if (!Boxing.a(z).booleanValue()) {
                        throw new AssertionError();
                    }
                }
                CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
                Unit unit = Unit.f42314a;
                Result.Companion companion = Result.f42293a;
                cancellableContinuationImpl3.resumeWith(Result.f(unit));
            }
            Object h = cancellableContinuationImpl.h();
            if (h == IntrinsicsKt.a()) {
                DebugProbesKt.c(continuation);
            }
            return h == IntrinsicsKt.a() ? h : Unit.f42314a;
        }
        throw new AssertionError();
    }

    public final void a() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            symbol = StateFlowKt.b;
            if (obj == symbol) {
                return;
            }
            symbol2 = StateFlowKt.f43435a;
            if (obj == symbol2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43436a;
                symbol3 = StateFlowKt.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f43436a;
                symbol4 = StateFlowKt.f43435a;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, symbol4)) {
                    CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) obj;
                    Unit unit = Unit.f42314a;
                    Result.Companion companion = Result.f42293a;
                    cancellableContinuationImpl.resumeWith(Result.f(unit));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        Symbol symbol;
        if (this._state != null) {
            return false;
        }
        symbol = StateFlowKt.f43435a;
        this._state = symbol;
        return true;
    }

    public final boolean b() {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43436a;
        symbol = StateFlowKt.f43435a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, symbol);
        Intrinsics.a(andSet);
        if (!DebugKt.a() || (!(andSet instanceof CancellableContinuationImpl))) {
            symbol2 = StateFlowKt.b;
            return andSet == symbol2;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation<Unit>[] b(StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return AbstractSharedFlowKt.f43445a;
    }
}
