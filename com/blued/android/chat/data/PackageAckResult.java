package com.blued.android.chat.data;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/PackageAckResult.class */
public interface PackageAckResult {
    public static final int FAILED_SERVER_ERROR = 255;
    public static final int FAILED_TIMEOUT = -2;
    public static final int FAILED_UNKNOWN = -1;
    public static final int FAILED_WRONG_GRPC = -3;
    public static final int FAILED_WRONG_PROTOCAL = 2;
    public static final int FAILED_WRONG_VERSION = 1;
    public static final int SUCCESS = 0;
}
