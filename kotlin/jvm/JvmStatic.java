package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

@Target({ElementType.METHOD})
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Metadata
@Documented
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/JvmStatic.class */
public @interface JvmStatic {
}