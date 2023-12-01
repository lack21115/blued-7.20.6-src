package com.blued.community.utils;

import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/UserInfoUtils.class */
public class UserInfoUtils {
    public static UserInfo a() {
        return UserInfo.getInstance();
    }

    public static BluedLoginResult b() {
        return UserInfo.getInstance().getLoginUserInfo();
    }

    public static String c() {
        return UserInfo.getInstance().getLoginUserInfo().getUid();
    }

    public static String d() {
        return UserInfo.getInstance().getLoginUserInfo().getName();
    }

    public static String e() {
        return UserInfo.getInstance().getLoginUserInfo().getAvatar();
    }

    public static boolean f() {
        return UserInfo.getInstance().isLogin();
    }
}
