package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [S] */
@Metadata
@DebugMetadata(b = "_Sequences.kt", c = {2202, 2206}, d = "invokeSuspend", e = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1")
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$runningReduceIndexed$1.class */
final class SequencesKt___SequencesKt$runningReduceIndexed$1<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f42687a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    int f42688c;
    int d;
    final /* synthetic */ Sequence<T> e;
    final /* synthetic */ Function3<Integer, S, T, S> f;
    private /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> function3, Continuation<? super SequencesKt___SequencesKt$runningReduceIndexed$1> continuation) {
        super(2, continuation);
        this.e = sequence;
        this.f = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super S> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.e, this.f, continuation);
        sequencesKt___SequencesKt$runningReduceIndexed$1.g = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        Object obj2;
        SequenceScope sequenceScope;
        Object a2 = IntrinsicsKt.a();
        int i = this.d;
        int i2 = 1;
        if (i == 0) {
            ResultKt.a(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.g;
            it = this.e.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                this.g = sequenceScope2;
                this.f42687a = it;
                this.b = next;
                this.d = 1;
                obj2 = next;
                sequenceScope = sequenceScope2;
                if (sequenceScope2.a((SequenceScope) next, (Continuation<? super Unit>) this) == a2) {
                    return a2;
                }
            }
            return Unit.f42314a;
        } else if (i == 1) {
            Object obj3 = this.b;
            it = (Iterator) this.f42687a;
            sequenceScope = (SequenceScope) this.g;
            ResultKt.a(obj);
            obj2 = obj3;
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i2 = this.f42688c;
            Object obj4 = this.b;
            it = (Iterator) this.f42687a;
            sequenceScope = (SequenceScope) this.g;
            ResultKt.a(obj);
            obj2 = obj4;
        }
        while (it.hasNext()) {
            Function3<Integer, S, T, S> function3 = this.f;
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.c();
            }
            obj2 = function3.a(Boxing.a(i2), obj2, it.next());
            this.g = sequenceScope;
            this.f42687a = it;
            this.b = obj2;
            this.f42688c = i3;
            this.d = 2;
            if (sequenceScope.a((SequenceScope) obj2, (Continuation<? super Unit>) this) == a2) {
                return a2;
            }
            i2 = i3;
        }
        return Unit.f42314a;
    }
}
