package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectClause0.class */
public interface SelectClause0 {
    <R> void a(SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1);
}
