package kotlin.reflect;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KClass.class */
public interface KClass<T> extends KAnnotatedElement, KClassifier, KDeclarationContainer {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KClass$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    boolean a(Object obj);

    String b();

    String c();
}
