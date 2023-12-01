package com.j256.ormlite.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/table/DatabaseTable.class */
public @interface DatabaseTable {
    Class<?> daoClass() default Void.class;

    String tableName() default "";
}
