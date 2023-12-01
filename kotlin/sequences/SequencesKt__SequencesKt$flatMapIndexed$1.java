package kotlin.sequences;

import com.android.ims.ImsReasonInfo;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
@DebugMetadata(b = "Sequences.kt", c = {ImsReasonInfo.CODE_SIP_FORBIDDEN}, d = "invokeSuspend", e = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1")
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$flatMapIndexed$1.class */
final class SequencesKt__SequencesKt$flatMapIndexed$1<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    Object a;
    int b;
    int c;
    final /* synthetic */ Sequence<T> d;
    final /* synthetic */ Function2<Integer, T, C> e;
    final /* synthetic */ Function1<C, Iterator<R>> f;
    private /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.d = sequence;
        this.e = function2;
        this.f = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super R> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.d, this.e, this.f, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.g = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        int i;
        Iterator it;
        Object a = IntrinsicsKt.a();
        int i2 = this.c;
        if (i2 == 0) {
            ResultKt.a(obj);
            sequenceScope = (SequenceScope) this.g;
            i = 0;
            it = this.d.iterator();
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.b;
            Iterator it2 = (Iterator) this.a;
            sequenceScope = (SequenceScope) this.g;
            ResultKt.a(obj);
            it = it2;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Function2<Integer, T, C> function2 = this.e;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.c();
            }
            Object invoke = function2.invoke(Boxing.a(i), next);
            this.g = sequenceScope;
            this.a = it;
            this.b = i3;
            this.c = 1;
            if (sequenceScope.a((Iterator) this.f.invoke(invoke), (Continuation<? super Unit>) this) == a) {
                return a;
            }
            i = i3;
        }
        return Unit.a;
    }
}
