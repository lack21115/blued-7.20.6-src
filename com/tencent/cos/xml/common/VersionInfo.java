package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/VersionInfo.class */
public class VersionInfo {
    public static final String platform = "cos-android-sdk-5.8.9";
    public static final String platformQuic = "cos-android-quic-sdk-5.8.9";
    public static final int version = 50809;

    public static String getQuicUserAgent() {
        return platformQuic;
    }

    public static String getUserAgent() {
        return platform;
    }
}
