package com.blued.android.chat.data;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/SendPackageAckResult.class */
public interface SendPackageAckResult extends PackageAckResult {
    public static final int CONTENT_EMPTY = 3;
    public static final int CONTENT_INVILAD = 4;
    public static final int FAILED_ACCOUNT_NOT_VERIFY = 10;
    public static final int FAILED_GROUP_LOCK = 15;
    public static final int FAILED_GROUP_VIDEO_FORBIDDEN = 12;
    public static final int FAILED_LIVECHAT_STOP_TALK = 13;
    public static final int FAILED_LIVECHAT_TOO_FREQUENT = 14;
    public static final int FAILED_NOT_FRIENDS = 11;
    public static final int FAILED_TOO_FREQUENT = 9;
    public static final int FAILED_UNREAL_NAME = 16;
    public static final int MSG_DISTURB_NOTICE = 18;
    public static final int PRIVATE_ERROR_CODE_LOW = 20;
    public static final int PRIVATE_ERROR_FAST_PICTURE_AUDIT_ERROR = 21;
    public static final int TOGROUP_GROUP_ERROR = 19;
    public static final int TOGROUP_NOT_IN = 8;
    public static final int TOGROUP_PAUSE = 17;
    public static final int TOUSER_FORBIDDEN_BY_M = 7;
    public static final int TOUSER_FORBIDDEN_U = 6;
    public static final int TOUSER_INVALID = 5;
}
