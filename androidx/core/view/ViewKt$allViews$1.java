package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata
@DebugMetadata(b = "View.kt", c = {406, 408}, d = "invokeSuspend", e = "androidx.core.view.ViewKt$allViews$1")
/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ViewKt$allViews$1.class */
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f2621a;
    final /* synthetic */ View b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Object f2622c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.b = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> viewKt$allViews$1 = new ViewKt$allViews$1(this.b, continuation);
        viewKt$allViews$1.f2622c = obj;
        return viewKt$allViews$1;
    }

    public final Object invoke(SequenceScope<? super View> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object a2 = IntrinsicsKt.a();
        int i = this.f2621a;
        if (i == 0) {
            ResultKt.a(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f2622c;
            this.f2622c = sequenceScope2;
            this.f2621a = 1;
            sequenceScope = sequenceScope2;
            if (sequenceScope2.a(this.b, (Continuation) this) == a2) {
                return a2;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
            sequenceScope = (SequenceScope) this.f2622c;
        }
        View view = this.b;
        if (view instanceof ViewGroup) {
            this.f2622c = null;
            this.f2621a = 2;
            if (sequenceScope.a(ViewGroupKt.getDescendants((ViewGroup) view), (Continuation) this) == a2) {
                return a2;
            }
        }
        return Unit.a;
    }
}
