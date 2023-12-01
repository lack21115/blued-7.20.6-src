package com.blued.android.module.common.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Target({ElementType.METHOD})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/annotation/ApiHost.class */
public @interface ApiHost {
    public static final Companion a = Companion.a;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/annotation/ApiHost$Companion.class */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        private Companion() {
        }
    }

    String a() default "";
}
