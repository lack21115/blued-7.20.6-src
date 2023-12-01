package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KCallable.class */
public interface KCallable<R> extends KAnnotatedElement {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KCallable$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    R call(Object... objArr);

    R callBy(Map<KParameter, ? extends Object> map);

    String getName();

    List<KParameter> getParameters();

    KType getReturnType();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
