package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KAnnotatedElement.class */
public interface KAnnotatedElement {
    List<Annotation> getAnnotations();
}
