package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt.class */
final /* synthetic */ class FlowKt__ZipKt {
    public static final <T1, T2, R> Flow<R> a(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return CombineKt.a(flow, flow2, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function0<T[]> b() {
        return new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final Void invoke() {
                return null;
            }
        };
    }
}
