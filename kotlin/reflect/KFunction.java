package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KFunction.class */
public interface KFunction<R> extends Function<R>, KCallable<R> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KFunction$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();
}
