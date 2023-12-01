package com.soft.blued.log.mobevent;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.user.model.UserInfo;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/mobevent/MobEventUtils.class */
public class MobEventUtils {
    public static void a() {
        if (UserInfo.getInstance().isLogin()) {
            HashMap hashMap = new HashMap();
            hashMap.put("uid", EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().getUid()));
            MobclickAgent.onEventObject(AppInfo.d(), "__finish_payment", hashMap);
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", EncryptTool.b(str));
        MobclickAgent.onEventObject(AppInfo.d(), "__register", hashMap);
    }
}
