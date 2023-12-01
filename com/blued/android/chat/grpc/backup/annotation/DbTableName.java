package com.blued.android.chat.grpc.backup.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/annotation/DbTableName.class */
public @interface DbTableName {
    String name();
}
