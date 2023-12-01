package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilder.class */
public interface SelectBuilder<R> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilder$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    void a(long j, Function1<? super Continuation<? super R>, ? extends Object> function1);

    <Q> void a(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
