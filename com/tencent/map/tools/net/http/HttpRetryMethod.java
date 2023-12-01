package com.tencent.map.tools.net.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/http/HttpRetryMethod.class */
public @interface HttpRetryMethod {
    public static final int HTTP_ALWAYS_RETYR = 5;
    public static final int HTTP_NOMARL_RETYR = 3;
    public static final int HTTP_NONE_RETRY = 0;
    public static final int HTTP_ONCE_RETRY = 2;
    public static final int HTTP_SPEED_FIRST_RETRY = 1;
    public static final int HTTP_SUCCESS_FIRST_RETRY = 4;
}
