package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectClause1.class */
public interface SelectClause1<Q> {
    <R> void a(SelectInstance<? super R> selectInstance, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
