package kotlin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata
@Target
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:kotlin/annotation/Retention.class */
public @interface Retention {
    AnnotationRetention value() default AnnotationRetention.RUNTIME;
}
