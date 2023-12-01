package com.blued.android.core.net.http;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/StatusCode.class */
public class StatusCode {
    public static int a(IOException iOException) {
        if (iOException != null) {
            if (iOException instanceof SocketException) {
                if (iOException instanceof ConnectException) {
                    return -2020;
                }
                if (iOException instanceof NoRouteToHostException) {
                    return -2022;
                }
                if (iOException instanceof PortUnreachableException) {
                    return -2023;
                }
                return iOException instanceof BindException ? -2025 : -2014;
            } else if (iOException instanceof InterruptedIOException) {
                return iOException instanceof SocketTimeoutException ? -2019 : -2015;
            } else if (iOException instanceof SSLException) {
                return -2016;
            } else {
                if (iOException instanceof EOFException) {
                    return -2017;
                }
                if (iOException instanceof FileNotFoundException) {
                    return -2012;
                }
                if (iOException instanceof UnknownHostException) {
                    return -2013;
                }
                if (iOException instanceof UnknownServiceException) {
                    return -2021;
                }
                if (iOException instanceof HttpRetryException) {
                    return -2018;
                }
                return iOException instanceof ProtocolException ? -2024 : -2011;
            }
        }
        return -2011;
    }
}
