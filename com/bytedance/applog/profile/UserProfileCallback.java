package com.bytedance.applog.profile;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/profile/UserProfileCallback.class */
public interface UserProfileCallback {
    public static final int NET_ERROR = 1;
    public static final int NOT_SATISFY = 3;
    public static final int NO_NET = 0;
    public static final int REQUEST_LIMIT = 4;
    public static final int RESULT_ERROR = 2;

    void onFail(int i);

    void onSuccess();
}
