package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "WhileSelect.kt", c = {37}, d = "whileSelect", e = "kotlinx.coroutines.selects.WhileSelectKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/WhileSelectKt$whileSelect$1.class */
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43610a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43611c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WhileSelectKt$whileSelect$1(Continuation<? super WhileSelectKt$whileSelect$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.f43611c |= Integer.MIN_VALUE;
        return WhileSelectKt.a(null, this);
    }
}
