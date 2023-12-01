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

/* JADX INFO: Add missing generic type declarations: [S] */
@Metadata
@DebugMetadata(b = "_Sequences.kt", c = {2173, 2176}, d = "invokeSuspend", e = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1")
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$runningReduce$1.class */
final class SequencesKt___SequencesKt$runningReduce$1<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f42685a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    int f42686c;
    final /* synthetic */ Sequence<T> d;
    final /* synthetic */ Function2<S, T, S> e;
    private /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningReduce$1(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> continuation) {
        super(2, continuation);
        this.d = sequence;
        this.e = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super S> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.d, this.e, continuation);
        sequencesKt___SequencesKt$runningReduce$1.f = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Iterator it;
        Object next;
        Object a2 = IntrinsicsKt.a();
        int i = this.f42686c;
        if (i == 0) {
            ResultKt.a(obj);
            sequenceScope = (SequenceScope) this.f;
            it = this.d.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.f = sequenceScope;
                this.f42685a = it;
                this.b = next;
                this.f42686c = 1;
                if (sequenceScope.a((SequenceScope) next, (Continuation<? super Unit>) this) == a2) {
                    return a2;
                }
            }
            return Unit.f42314a;
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj2 = this.b;
            it = (Iterator) this.f42685a;
            sequenceScope = (SequenceScope) this.f;
            ResultKt.a(obj);
            next = obj2;
        }
        while (it.hasNext()) {
            Object invoke = this.e.invoke(next, it.next());
            this.f = sequenceScope;
            this.f42685a = it;
            this.b = invoke;
            this.f42686c = 2;
            next = invoke;
            if (sequenceScope.a((SequenceScope) invoke, (Continuation<? super Unit>) this) == a2) {
                return a2;
            }
        }
        return Unit.f42314a;
    }
}
