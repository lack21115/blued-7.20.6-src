package com.ss.android.download.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/annotation/JsonSerial.class */
public @interface JsonSerial {
    String[] value();
}
