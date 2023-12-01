package kotlin.jvm.internal;

import kotlin.Function;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/FunctionBase.class */
public interface FunctionBase<R> extends Function<R> {
    int getArity();
}
