package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/AbstractSharedFlow.class */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* renamed from: a  reason: collision with root package name */
    private S[] f43443a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f43444c;
    private MutableStateFlow<Integer> d;

    public final StateFlow<Integer> a() {
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            MutableStateFlow<Integer> mutableStateFlow2 = this.d;
            mutableStateFlow = mutableStateFlow2;
            if (mutableStateFlow2 == null) {
                mutableStateFlow = StateFlowKt.a(Integer.valueOf(g()));
                this.d = mutableStateFlow;
            }
        }
        return mutableStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(S s) {
        MutableStateFlow<Integer> mutableStateFlow;
        int i;
        Continuation<Unit>[] b;
        synchronized (this) {
            this.b = g() - 1;
            mutableStateFlow = this.d;
            i = 0;
            if (g() == 0) {
                this.f43444c = 0;
            }
            b = s.b(this);
        }
        int length = b.length;
        while (i < length) {
            Continuation<Unit> continuation = b[i];
            i++;
            if (continuation != null) {
                Unit unit = Unit.f42314a;
                Result.Companion companion = Result.f42293a;
                continuation.resumeWith(Result.f(unit));
            }
        }
        if (mutableStateFlow == null) {
            return;
        }
        StateFlowKt.a(mutableStateFlow, -1);
    }

    protected abstract S[] b(int i);

    protected abstract S e();

    /* JADX INFO: Access modifiers changed from: protected */
    public final S[] f() {
        return this.f43443a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[]] */
    public final S h() {
        S[] sArr;
        S s;
        int i;
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            S[] f = f();
            if (f == null) {
                sArr = b(2);
                this.f43443a = sArr;
            } else {
                sArr = f;
                if (g() >= f.length) {
                    Object[] copyOf = Arrays.copyOf(f, f.length * 2);
                    Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    this.f43443a = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                    sArr = (AbstractSharedFlowSlot[]) copyOf;
                }
            }
            int i2 = this.f43444c;
            do {
                S s2 = sArr[i2];
                s = s2;
                if (s2 == null) {
                    s = e();
                    sArr[i2] = s;
                }
                int i3 = i2 + 1;
                i = i3;
                if (i3 >= sArr.length) {
                    i = 0;
                }
                i2 = i;
            } while (!s.a(this));
            this.f43444c = i;
            this.b = g() + 1;
            mutableStateFlow = this.d;
        }
        if (mutableStateFlow == null) {
            return s;
        }
        StateFlowKt.a(mutableStateFlow, 1);
        return s;
    }
}
