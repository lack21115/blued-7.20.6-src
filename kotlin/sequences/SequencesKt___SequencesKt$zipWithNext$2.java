package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
@DebugMetadata(b = "_Sequences.kt", c = {2693}, d = "invokeSuspend", e = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2")
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$zipWithNext$2.class */
final class SequencesKt___SequencesKt$zipWithNext$2<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    Object a;
    Object b;
    int c;
    final /* synthetic */ Sequence<T> d;
    final /* synthetic */ Function2<T, T, R> e;
    private /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence<? extends T> sequence, Function2<? super T, ? super T, ? extends R> function2, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.d = sequence;
        this.e = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super R> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sequenceScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.d, this.e, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.f = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Iterator it;
        Object next;
        Object a = IntrinsicsKt.a();
        int i = this.c;
        if (i == 0) {
            ResultKt.a(obj);
            sequenceScope = (SequenceScope) this.f;
            it = this.d.iterator();
            if (!it.hasNext()) {
                return Unit.a;
            }
            next = it.next();
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj2 = this.b;
            it = (Iterator) this.a;
            sequenceScope = (SequenceScope) this.f;
            ResultKt.a(obj);
            next = obj2;
        }
        while (true) {
            Object obj3 = next;
            if (!it.hasNext()) {
                return Unit.a;
            }
            Object next2 = it.next();
            this.f = sequenceScope;
            this.a = it;
            this.b = next2;
            this.c = 1;
            if (sequenceScope.a((SequenceScope) this.e.invoke(obj3, next2), (Continuation<? super Unit>) this) == a) {
                return a;
            }
            next = next2;
        }
    }
}
