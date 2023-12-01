package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.MustBeDocumented;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata
@kotlin.annotation.Target
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:kotlin/DeprecatedSinceKotlin.class */
public @interface DeprecatedSinceKotlin {
}
