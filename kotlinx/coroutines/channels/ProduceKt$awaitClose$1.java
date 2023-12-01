package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Produce.kt", c = {157}, d = "awaitClose", e = "kotlinx.coroutines.channels.ProduceKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ProduceKt$awaitClose$1.class */
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    Object a;
    Object b;
    /* synthetic */ Object c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProduceKt$awaitClose$1(Continuation<? super ProduceKt$awaitClose$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        return ProduceKt.a(null, null, this);
    }
}
