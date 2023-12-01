package kotlinx.coroutines.selects;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/UnbiasedSelectBuilderImpl.class */
public final class UnbiasedSelectBuilderImpl<R> implements SelectBuilder<R> {
    private final SelectBuilderImpl<R> a;
    private final ArrayList<Function0<Unit>> b;

    public final SelectBuilderImpl<R> a() {
        return this.a;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void a(final long j, final Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.b.add(new Function0<Unit>(this) { // from class: kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$onTimeout$1
            final /* synthetic */ UnbiasedSelectBuilderImpl<R> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.a = this;
            }

            public final void a() {
                this.a.a().a(j, (Function1) function1);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* synthetic */ Unit invoke() {
                a();
                return Unit.a;
            }
        });
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void a(final SelectClause1<? extends Q> selectClause1, final Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.b.add(new Function0<Unit>() { // from class: kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$invoke$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public final void a() {
                selectClause1.a(this.a(), function2);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* synthetic */ Unit invoke() {
                a();
                return Unit.a;
            }
        });
    }
}
