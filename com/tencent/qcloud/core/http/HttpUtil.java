package com.tencent.qcloud.core.http;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpUtil.class */
public class HttpUtil {
    public static boolean isNetworkTimeoutError(Exception exc) {
        return (exc instanceof SocketTimeoutException) || (exc instanceof ConnectException) || (exc instanceof NoRouteToHostException) || (exc instanceof UnknownHostException);
    }
}
