package kotlin.reflect;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KParameter.class */
public interface KParameter extends KAnnotatedElement {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KParameter$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KParameter$Kind.class */
    public enum Kind {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    KType getType();
}
