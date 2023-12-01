package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/SafeCollectorKt.class */
public final class SafeCollectorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> f43503a = (Function3) TypeIntrinsics.b(SafeCollectorKt$emitFun$1.f43504a, 3);

    public static final /* synthetic */ Function3 a() {
        return f43503a;
    }
}
