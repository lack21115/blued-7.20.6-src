package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KType.class */
public interface KType extends KAnnotatedElement {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KType$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    KClassifier a();

    List<KTypeProjection> b();
}
