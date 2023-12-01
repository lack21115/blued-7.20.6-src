package android.filterfw.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/GenerateProgramPorts.class */
public @interface GenerateProgramPorts {
    GenerateProgramPort[] value();
}
