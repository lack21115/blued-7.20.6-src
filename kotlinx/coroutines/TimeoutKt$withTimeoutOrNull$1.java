package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Timeout.kt", c = {101}, d = "withTimeoutOrNull", e = "kotlinx.coroutines.TimeoutKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/TimeoutKt$withTimeoutOrNull$1.class */
public final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    long f42859a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    Object f42860c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutKt$withTimeoutOrNull$1(Continuation<? super TimeoutKt$withTimeoutOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        return TimeoutKt.a(0L, null, this);
    }
}
