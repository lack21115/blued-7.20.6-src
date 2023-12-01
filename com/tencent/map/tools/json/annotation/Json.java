package com.tencent.map.tools.json.annotation;

import com.tencent.map.tools.json.JsonParser;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/json/annotation/Json.class */
public @interface Json {
    Class<? extends JsonParser.Deserializer> deserializer() default JsonParser.Deserializer.class;

    boolean ignore() default false;

    String name() default "";
}
