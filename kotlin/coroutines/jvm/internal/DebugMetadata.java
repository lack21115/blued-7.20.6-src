package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.TYPE})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/DebugMetadata.class */
public @interface DebugMetadata {
    int a() default 1;

    String b() default "";

    int[] c() default {};

    String d() default "";

    String e() default "";
}
