package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;

@Target({ElementType.TYPE})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:kotlin/Metadata.class */
public @interface Metadata {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/Metadata$DefaultImpls.class */
    public static final class DefaultImpls {
    }
}
