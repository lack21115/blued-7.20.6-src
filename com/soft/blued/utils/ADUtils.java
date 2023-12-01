package com.soft.blued.utils;

import android.util.Log;
import com.blued.android.core.utils.Md5;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Calendar;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/ADUtils.class */
public class ADUtils {
    public static String a() {
        String str;
        int i;
        try {
            str = Md5.a(System.currentTimeMillis() + UserInfo.getInstance().getLoginUserInfo().uid).substring(8, 24);
        } catch (Exception e) {
            str = System.currentTimeMillis() + UserInfo.getInstance().getLoginUserInfo().uid;
        }
        Log.v("drb", "requestId Md5:" + str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i2 = calendar.get(6);
        int fv = BluedPreferences.fv();
        int fw = BluedPreferences.fw();
        if (i2 != fv) {
            BluedPreferences.x(i2);
            i = 0;
            BluedPreferences.y(0);
        } else {
            i = fw + 1;
            BluedPreferences.y(i);
        }
        String str2 = str + BridgeUtil.UNDERLINE_STR + i2 + BridgeUtil.UNDERLINE_STR + i;
        Log.v("drb", "--------requestId:" + str2);
        return str2;
    }

    public static String b() {
        String str;
        try {
            str = Md5.a(System.currentTimeMillis() + UserInfo.getInstance().getLoginUserInfo().uid).substring(8, 24);
        } catch (Exception e) {
            str = System.currentTimeMillis() + UserInfo.getInstance().getLoginUserInfo().uid;
        }
        Log.v("drb", "requestId Md5:" + str);
        return str;
    }
}
