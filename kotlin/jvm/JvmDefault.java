package kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;

@Target({ElementType.METHOD})
@Metadata
@Deprecated
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/JvmDefault.class */
public @interface JvmDefault {
}
