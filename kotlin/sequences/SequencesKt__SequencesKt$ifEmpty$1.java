package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Sequences.kt", c = {69, 71}, d = "invokeSuspend", e = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1")
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$ifEmpty$1.class */
final class SequencesKt__SequencesKt$ifEmpty$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f42654a;
    final /* synthetic */ Sequence<T> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function0<Sequence<T>> f42655c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$ifEmpty$1(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0, Continuation<? super SequencesKt__SequencesKt$ifEmpty$1> continuation) {
        super(2, continuation);
        this.b = sequence;
        this.f42655c = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.b, this.f42655c, continuation);
        sequencesKt__SequencesKt$ifEmpty$1.d = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f42654a;
        if (i == 0) {
            ResultKt.a(obj);
            SequenceScope sequenceScope = (SequenceScope) this.d;
            Iterator<? extends T> it = this.b.iterator();
            if (it.hasNext()) {
                this.f42654a = 1;
                if (sequenceScope.a((Iterator) it, (Continuation<? super Unit>) this) == a2) {
                    return a2;
                }
            } else {
                this.f42654a = 2;
                if (sequenceScope.a((Sequence) this.f42655c.invoke(), (Continuation<? super Unit>) this) == a2) {
                    return a2;
                }
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.f42314a;
    }
}
