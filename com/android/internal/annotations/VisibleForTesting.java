package com.android.internal.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/annotations/VisibleForTesting.class */
public @interface VisibleForTesting {

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/annotations/VisibleForTesting$Visibility.class */
    public enum Visibility {
        PROTECTED,
        PACKAGE,
        PRIVATE
    }

    Visibility visibility() default Visibility.PRIVATE;
}
