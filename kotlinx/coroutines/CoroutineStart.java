package kotlinx.coroutines;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineStart.class */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineStart$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42802a;

        static {
            int[] iArr = new int[CoroutineStart.valuesCustom().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f42802a = iArr;
        }
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static CoroutineStart[] valuesCustom() {
        CoroutineStart[] valuesCustom = values();
        return (CoroutineStart[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        int i = WhenMappings.f42802a[ordinal()];
        if (i == 1) {
            CancellableKt.a(function2, r, continuation, null, 4, null);
        } else if (i == 2) {
            ContinuationKt.a(function2, r, continuation);
        } else if (i == 3) {
            UndispatchedKt.b(function2, r, continuation);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean a() {
        return this == LAZY;
    }
}
