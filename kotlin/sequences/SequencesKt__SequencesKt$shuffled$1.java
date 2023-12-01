package kotlin.sequences;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Sequences.kt", c = {145}, d = "invokeSuspend", e = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1")
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$shuffled$1.class */
final class SequencesKt__SequencesKt$shuffled$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    Object a;
    int b;
    final /* synthetic */ Sequence<T> c;
    final /* synthetic */ Random d;
    private /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$shuffled$1(Sequence<? extends T> sequence, Random random, Continuation<? super SequencesKt__SequencesKt$shuffled$1> continuation) {
        super(2, continuation);
        this.c = sequence;
        this.d = random;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(sequenceScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.c, this.d, continuation);
        sequencesKt__SequencesKt$shuffled$1.e = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        List e;
        Object a = IntrinsicsKt.a();
        int i = this.b;
        if (i == 0) {
            ResultKt.a(obj);
            sequenceScope = (SequenceScope) this.e;
            e = SequencesKt.e(this.c);
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            List list = (List) this.a;
            sequenceScope = (SequenceScope) this.e;
            ResultKt.a(obj);
            e = list;
        }
        while (!e.isEmpty()) {
            int b = this.d.b(e.size());
            Object e2 = CollectionsKt.e((List<Object>) e);
            T t = e2;
            if (b < e.size()) {
                t = e.set(b, e2);
            }
            this.e = sequenceScope;
            this.a = e;
            this.b = 1;
            if (sequenceScope.a((SequenceScope) t, (Continuation<? super Unit>) this) == a) {
                return a;
            }
        }
        return Unit.a;
    }
}
